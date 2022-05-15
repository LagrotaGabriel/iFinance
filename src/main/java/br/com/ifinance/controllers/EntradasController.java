package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusInflow;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.InflowService;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.InflowUtils;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("entradas")
public class EntradasController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private InflowService inflowService;

    Utils utils = new Utils();
    InflowUtils inflowUtils = new InflowUtils();
    Dates dates = new Dates();

    @GetMapping
    public ModelAndView entradasControllerGet(@RequestParam("year") Optional<Integer> year,
                                              @RequestParam("month")Optional<Integer> month,
                                              @RequestParam("page")Optional<Integer> page,
                                              Model model,
                                              ModelAndView modelAndView,
                                              RedirectAttributes redirAttrs,
                                              ModelMap modelMap,
                                              HttpServletRequest req){

        String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        int currentYear = year.orElse(cal.get(Calendar.YEAR));
        int currentMonth = month.orElse(cal.get(Calendar.MONTH) + 1);
        int currentPage = page.orElse(1);

        modelMap.addAttribute("baseUrl", baseUrl);
        modelMap.addAttribute("year", currentYear);
        modelMap.addAttribute("month", currentMonth);
        modelMap.addAttribute("page", currentPage);

        // CONVERSÃO DAS DATAS A SEREM EXIBIDAS NA TABELA PARA PADRÃO BRASILEIRO: dd-MM-YY
        for(int i = 0; i < utils.loggedUser(userRepository).getInflows().size(); i++){

            if(utils.loggedUser(userRepository).getInflows().get(i).getDate() != null) {
                utils.loggedUser(userRepository).getInflows().get(i)
                        .setDate(dates.usToBr(utils.loggedUser(userRepository).getInflows().get(i).getDate()));
            }
            if(utils.loggedUser(userRepository).getInflows().get(i).getScheduling() != null && !utils.loggedUser(userRepository).getInflows().get(i).getScheduling().equals("")) {
                utils.loggedUser(userRepository).getInflows().get(i)
                        .setScheduling(dates.usToBr(utils.loggedUser(userRepository).getInflows().get(i).getScheduling()));
            }
        }

        Map<Integer, List<Inflow>> mapPages = inflowUtils.inflowPagination
                (utils.loggedUser(userRepository), currentMonth, currentYear, 5);
        Integer totalPages = inflowUtils.totalPages
                (utils.loggedUser(userRepository), currentMonth, currentYear, 5);
        List<Integer> pageNumbers = inflowUtils.pageNumberList
                (inflowUtils.totalPages(utils.loggedUser(userRepository), currentMonth, currentYear, 5));

        // DEFINE A QUANTIDADE DE ITENS A SER INSERIDO POR PÁGINA
        if(!mapPages.get(currentPage).isEmpty()) {
            model.addAttribute("inflows", mapPages.get(currentPage));
        }
        else{
            model.addAttribute("inflows", "");
        }

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("user", utils.loggedUser(userRepository));

        modelAndView.setViewName("entradas");
        return modelAndView;

    }

    @PostMapping
    public ModelAndView entradasControllerPost(Inflow inflow,
                                               RedirectAttributes redirAttrs,
                                               ModelAndView modelAndView){

        // SE A DESCRIÇÃO ESTIVER PREENCHIDA
        if(!inflow.getDescription().equals("") || inflow.getStatusInflow() != null){

            // SE O STATUS ESTIVER COMO A RECEBER
            if(inflow.getStatusInflow()== StatusInflow.RECEBER){

                inflow.setMean(Mean.ABERTO);

                // SE O AGENDAMENTO ESTIVER EM BRANCO ELE É JOGADO COMO NULO
                if(inflow.getScheduling().equals("")){
                    inflow.setScheduling(null);
                    inflow.setUser(utils.loggedUser(userRepository));
                    inflow.setCreated(dates.splitedToday()[2] + "/" + dates.splitedToday()[1] + "/" + dates.splitedToday()[0]);
                    List<Inflow> novaLista = utils.loggedUser(userRepository).getInflows();
                    novaLista.add(inflow);
                    utils.loggedUser(userRepository).setInflows(novaLista);
                    userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                    redirAttrs.addFlashAttribute("SucessoCadastro",
                            "Cadastro da entrada salvo com sucesso");
                }

                // SE O AGENDAMENTO ESTIVER PREENCHIDO ELE É VALIDADO PARA QUE NÃO SEJA NO PASSADO
                else{
                    String[] agendamento = inflow.getScheduling().split("-");
                    // SE O ANO DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                    if(Integer.parseInt(agendamento[0]) >= Integer.parseInt(dates.splitedToday()[0])){
                        // SE O MÊS DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                        if(Integer.parseInt(agendamento[1]) >= Integer.parseInt(dates.splitedToday()[1])){

                            // SE O MÊS SALVO FOR IGUAL AO MÊS ATUAL E O DIA DE AGENDAMENTO FOR MENOR DO QUE O DIA ATUAL
                            if(Integer.parseInt(agendamento[1]) == Integer.parseInt(dates.splitedToday()[1])
                                    && Integer.parseInt(agendamento[2]) < Integer.parseInt(dates.splitedToday()[2])){
                                redirAttrs.addFlashAttribute("ErroCadastro",
                                        "A data do agendamento não pode ser menor do que a data atual");
                            }
                            else {
                                // SALVANDO A ENTRADA NO BANCO DE DADOS
                                inflow.setUser(utils.loggedUser(userRepository));
                                inflow.setCreated(dates.todayBr());
                                List<Inflow> novaLista = utils.loggedUser(userRepository).getInflows();
                                novaLista.add(inflow);
                                utils.loggedUser(userRepository).setInflows(novaLista);
                                userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                                redirAttrs.addFlashAttribute("SucessoCadastro",
                                        "Cadastro da entrada salvo com sucesso");
                            }
                        }
                        // SE O MÊS DO AGENDAMENTO FOR MENOR DO QUE O MÊS ATUAL (ERRADO)
                        else{
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "A data do agendamento não pode ser menor do que a data atual");
                        }
                    }
                    // SE O ANO DO AGENDAMENTO FOR MENOR DO QUE O ANO ATUAL (ERRADO)
                    else{
                        redirAttrs.addFlashAttribute("ErroCadastro",
                                "O ano do agendamento não pode ser menor do que o ano atual");
                    }

                }

            }

            // SE O STATUS ESTIVER COMO PAGO
            else{

                String[] dataEntrada = inflow.getDate().split("-");

                // SE O ANO DA ENTRADA FOR MENOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                if(Integer.parseInt(dataEntrada[0]) <= Integer.parseInt(dates.splitedToday()[0])){
                    // SE O MÊS DA ENTRADA FOR MENOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                    if(Integer.parseInt(dataEntrada[1]) <= Integer.parseInt(dates.splitedToday()[1])){

                        // SE O MÊS SALVO FOR IGUAL AO MÊS ATUAL E O DIA DA ENTRADA FOR MAIOR DO QUE O DIA ATUAL
                        if(Integer.parseInt(dataEntrada[1]) == Integer.parseInt(dates.splitedToday()[1])
                                && Integer.parseInt(dataEntrada[2]) > Integer.parseInt(dates.splitedToday()[2])) {
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "A data da entrada não pode ser maior do que a data atual");
                        }
                        else{
                            inflow.setUser(utils.loggedUser(userRepository));
                            inflow.setCreated(dates.todayBr());
                            List<Inflow> novaLista = utils.loggedUser(userRepository).getInflows();
                            novaLista.add(inflow);
                            utils.loggedUser(userRepository).setInflows(novaLista);
                            userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                            redirAttrs.addFlashAttribute("SucessoCadastro", "Cadastro da entrada salvo com sucesso");
                        }

                    }
                    // SE O MÊS DA ENTRADA FOR MENOR DO QUE O MÊS ATUAL (ERRADO)
                    else{
                        redirAttrs.addFlashAttribute("ErroCadastro",
                                "A data da entrada não pode ser maior do que a data atual");
                    }
                }
                // SE O ANO DA ENTRADA FOR MENOR DO QUE O ANO ATUAL (ERRADO)
                else{
                    redirAttrs.addFlashAttribute("ErroCadastro",
                            "O ano da entrada não pode ser maior do que o ano atual");
                }

            }

        }
        // SE A DESCRIÇÃO ESTIVER VAZIA
        else{
            redirAttrs.addFlashAttribute("ErroCadastro", "Houve um erro no cadastro da entrada");
        }

        modelAndView.setViewName("redirect:entradas");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView entradasControllerEdit(Inflow inflow,
                                               RedirectAttributes redirAttrs,
                                               ModelAndView modelAndView){

        // SE A DESCRIÇÃO ESTIVER PREENCHIDA
        if(!inflow.getDescription().equals("") || inflow.getStatusInflow() != null){

            // SE O STATUS ESTIVER COMO A PAGAR
            if(inflow.getStatusInflow()== StatusInflow.RECEBER){

                inflow.setMean(Mean.ABERTO);

                // SE O AGENDAMENTO ESTIVER EM BRANCO ELE É JOGADO COMO NULO
                if(inflow.getScheduling().equals("")){
                    inflow.setScheduling(null);
                    inflow.setCreated(dates.todayBr());
                    utils.loggedUser(userRepository).getInflows().set(utils.loggedUser(userRepository).getInflows()
                            .indexOf(inflowService.findById(inflow.getId()).get()), inflow);
                    userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                    redirAttrs.addFlashAttribute("SucessoCadastro", "Alteração salva com sucesso");
                }

                // SE O AGENDAMENTO ESTIVER PREENCHIDO ELE É VALIDADO PARA QUE NÃO SEJA NO PASSADO
                else{
                    String[] agendamento = inflow.getScheduling().split("-");
                    // SE O ANO DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                    if(Integer.parseInt(agendamento[0]) >= Integer.parseInt(dates.splitedToday()[0])){
                        // SE O MÊS DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                        if(Integer.parseInt(agendamento[1]) >= Integer.parseInt(dates.splitedToday()[1])){
                            // SE O MÊS SALVO FOR IGUAL AO MÊS ATUAL E O DIA DE AGENDAMENTO FOR MENOR DO QUE O DIA ATUAL
                            if(Integer.parseInt(agendamento[1]) == Integer.parseInt(dates.splitedToday()[1])
                                    && Integer.parseInt(agendamento[2]) < Integer.parseInt(dates.splitedToday()[2])){
                                redirAttrs.addFlashAttribute("ErroCadastro",
                                        "A data do agendamento não pode ser menor do que a data atual");
                            }
                            else {
                                // SALVANDO A ENTRADA NO BANCO DE DADOS
                                inflow.setCreated(dates.todayBr());
                                utils.loggedUser(userRepository).getInflows().set(utils.loggedUser(userRepository).getInflows()
                                        .indexOf(inflowService.findById(inflow.getId()).get()), inflow);
                                userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                                redirAttrs.addFlashAttribute("SucessoCadastro", "Atualização salva com sucesso");
                            }
                        }
                        // SE O MÊS DO AGENDAMENTO FOR MENOR DO QUE O MÊS ATUAL (ERRADO)
                        else{
                            redirAttrs.addFlashAttribute("ErroCadastro", "A data do agendamento não pode ser menor do que a data atual");
                        }
                    }
                    // SE O ANO DO AGENDAMENTO FOR MENOR DO QUE O ANO ATUAL (ERRADO)
                    else{
                        redirAttrs.addFlashAttribute("ErroCadastro", "O ano do agendamento não pode ser menor do que o ano atual");
                    }

                }
            }

            // SE O STATUS ESTIVER COMO PAGO
            else{

                String[] dataEntrada = inflow.getDate().split("-");

                // SE O ANO DA ENTRADA FOR MENOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                if(Integer.parseInt(dataEntrada[0]) <= Integer.parseInt(dates.splitedToday()[0])){
                    // SE O MÊS DA ENTRADA FOR MENOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                    if(Integer.parseInt(dataEntrada[1]) <= Integer.parseInt(dates.splitedToday()[1])){
                        // SE O MÊS SALVO FOR IGUAL AO MÊS ATUAL E O DIA DA ENTRADA FOR MAIOR DO QUE O DIA ATUAL
                        if(Integer.parseInt(dataEntrada[1]) == Integer.parseInt(dates.splitedToday()[1])
                                && Integer.parseInt(dataEntrada[2]) > Integer.parseInt(dates.splitedToday()[2])) {
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "A data da entrada não pode ser maior do que a data atual");
                        }
                        else{
                            inflow.setCreated(dates.todayBr());
                            utils.loggedUser(userRepository).getInflows().set(utils.loggedUser(userRepository).getInflows()
                                    .indexOf(inflowService.findById(inflow.getId()).get()), inflow);
                            userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                            redirAttrs.addFlashAttribute("SucessoCadastro",
                                    "Atualização salva com sucesso");
                        }
                    }
                    // SE O MÊS DA ENTRADA FOR MENOR DO QUE O MÊS ATUAL (ERRADO)
                    else{
                        redirAttrs.addFlashAttribute("ErroCadastro",
                                "A data da entrada não pode ser maior do que a data atual");
                    }
                }
                // SE O ANO DA ENTRADA FOR MENOR DO QUE O ANO ATUAL (ERRADO)
                else{
                    redirAttrs.addFlashAttribute("ErroCadastro",
                            "O ano da entrada não pode ser maior do que o ano atual");
                }

            }

        }
        // SE A DESCRIÇÃO ESTIVER VAZIA
        else{
            redirAttrs.addFlashAttribute("ErroCadastro",
                    "Houve um erro na atualização da entrada");
        }

        modelAndView.setViewName("redirect:../entradas");
        return modelAndView;
    }

    @PostMapping("/delete-{id}")
    public ModelAndView entradasControllerDelete(@PathVariable Long id, RedirectAttributes redirAttrs, ModelAndView modelAndView){
        utils.loggedUser(userRepository).getInflows().remove(utils.loggedUser(userRepository).getInflows().indexOf(inflowService.findById(id).get()));
        userService.updateUser(id, utils.loggedUser(userRepository));
        inflowService.delete(id);
        redirAttrs.addFlashAttribute("SucessoDelete", "Entrada deletada com sucesso");
        modelAndView.setViewName("redirect:../entradas");
        return modelAndView;
    }

}
