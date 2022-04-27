package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusLiability;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.LiabilityService;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.LiabilityUtils;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private LiabilityService liabilityService;

    Utils utils = new Utils();
    LiabilityUtils liabilityUtils = new LiabilityUtils();
    Dates dates = new Dates();

    @Bean
    public Function<String, String> currentUrlWithoutParam() {
        return param ->   ServletUriComponentsBuilder.fromCurrentRequest().replaceQueryParam(param).toUriString();
    }

    @GetMapping
    public ModelAndView despesasControllerGet(@RequestParam("year")Optional<Integer> year,
                                              @RequestParam("month")Optional<Integer> month,
                                              @RequestParam("page")Optional<Integer> page,
                                              Model model, ModelAndView modelAndView,
                                              RedirectAttributes redirAttrs,
                                              ModelMap modelMap,
                                              HttpServletRequest req){

        String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();

        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        int currentYear = year.orElse(cal.get(Calendar.YEAR));
        int currentMonth = month.orElse(cal.get(Calendar.MONTH)+1);
        int currentPage = page.orElse(1);

        modelMap.addAttribute("baseUrl", baseUrl);
        modelMap.addAttribute("year", currentYear);
        modelMap.addAttribute("month", currentMonth);
        modelMap.addAttribute("page" ,currentPage);

        // CONVERSÃO DAS DATAS A SEREM EXIBIDAS NA TABELA PARA PADRÃO BRASILEIRO: dd-MM-YY
        for(int i = 0; i < utils.loggedUser(userRepository).getLiabilities().size(); i++){

            if(utils.loggedUser(userRepository).getLiabilities().get(i).getDate() != null) {
                utils.loggedUser(userRepository).getLiabilities().get(i)
                        .setDate(dates.usToBr(utils.loggedUser(userRepository).getLiabilities().get(i).getDate()));
            }
            if(utils.loggedUser(userRepository).getLiabilities().get(i).getScheduling() != null && !utils.loggedUser(userRepository).getLiabilities().get(i).getScheduling().equals("")) {
                utils.loggedUser(userRepository).getLiabilities().get(i)
                        .setScheduling(dates.usToBr(utils.loggedUser(userRepository).getLiabilities().get(i).getScheduling()));
            }
        }

        Map<Integer, List<Liability>> mapPages = liabilityUtils.liabilityPagination
                (utils.loggedUser(userRepository), currentMonth, currentYear, 5);
        Integer totalPages = liabilityUtils.totalPages
                (utils.loggedUser(userRepository), currentMonth, currentYear, 5);
        List<Integer> pageNumbers = liabilityUtils.pageNumberList
                (liabilityUtils.totalPages(utils.loggedUser(userRepository), currentMonth, currentYear, 5));

        // DEFINE A QUANTIDADE DE ITENS A SER INSERIDO POR PÁGINA
        if(!mapPages.get(currentPage).isEmpty()) {
            model.addAttribute("liabilities", mapPages.get(currentPage));
        }
        else{
            model.addAttribute("liabilities", "");
        }

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("user", utils.loggedUser(userRepository));
        modelAndView.setViewName("despesas");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView despesasControllerPost(Liability liability, RedirectAttributes redirAttrs, ModelAndView modelAndView){

        // SE A DESCRIÇÃO ESTIVER PREENCHIDA
        if(!liability.getDescription().equals("") || liability.getStatusLiability() != null){

            // SE O STATUS ESTIVER COMO A PAGAR
            if(liability.getStatusLiability()== StatusLiability.PAGAR){

                liability.setMean(Mean.ABERTO);

                // SE O AGENDAMENTO ESTIVER EM BRANCO ELE É JOGADO COMO NULO
                if(liability.getScheduling().equals("")){
                    liability.setScheduling(null);
                    liability.setUser(utils.loggedUser(userRepository));
                    liability.setCreated(dates.splitedToday()[2] + "/" + dates.splitedToday()[1] + "/" + dates.splitedToday()[0]);
                    List<Liability> novaLista = utils.loggedUser(userRepository).getLiabilities();
                    novaLista.add(liability);
                    utils.loggedUser(userRepository).setLiabilities(novaLista);
                    userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                    redirAttrs.addFlashAttribute("SucessoCadastro", "Cadastro da despesa salvo com sucesso");
                }

                // SE O AGENDAMENTO ESTIVER PREENCHIDO ELE É VALIDADO PARA QUE NÃO SEJA NO PASSADO
                else{
                    String[] agendamento = liability.getScheduling().split("-");
                    // SE O ANO DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                    if(Integer.parseInt(agendamento[0]) >= Integer.parseInt(dates.splitedToday()[0])){
                        // SE O MÊS DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                        if(Integer.parseInt(agendamento[1]) >= Integer.parseInt(dates.splitedToday()[1])){
                            // SE O DIA DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                            if(Integer.parseInt(agendamento[2]) >= Integer.parseInt(dates.splitedToday()[2])){
                                // SALVANDO A DESPESA NO BANCO DE DADOS
                                liability.setUser(utils.loggedUser(userRepository));
                                liability.setCreated(dates.todayBr());
                                List<Liability> novaLista = utils.loggedUser(userRepository).getLiabilities();
                                novaLista.add(liability);
                                utils.loggedUser(userRepository).setLiabilities(novaLista);
                                userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                                redirAttrs.addFlashAttribute("SucessoCadastro", "Cadastro da despesa salvo com sucesso");
                            }
                            // SE O DIA DO AGENDAMENTO FOR MENOR DO QUE O DIA ATUAL (ERRADO)
                            else{
                                redirAttrs.addFlashAttribute("ErroCadastro", "A data do agendamento não pode ser menor do que a data atual");
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

                String[] dataDespesa = liability.getDate().split("-");

                // SE O ANO DA DESPESA FOR MENOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                if(Integer.parseInt(dataDespesa[0]) <= Integer.parseInt(dates.splitedToday()[0])){
                    System.err.println("IF 1");
                    // SE O MÊS DA DESPESA FOR MENOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                    if(Integer.parseInt(dataDespesa[1]) <= Integer.parseInt(dates.splitedToday()[1])){
                        System.err.println("IF 2");
                        // SE O DIA DA DESPESA FOR MENOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                        if(Integer.parseInt(dataDespesa[2]) <= Integer.parseInt(dates.splitedToday()[2])){
                            System.err.println("IF 3");
                            // SALVANDO A DESPESA NO BANCO DE DADOS
                            liability.setUser(utils.loggedUser(userRepository));
                            liability.setCreated(dates.todayBr());
                            List<Liability> novaLista = utils.loggedUser(userRepository).getLiabilities();
                            novaLista.add(liability);
                            utils.loggedUser(userRepository).setLiabilities(novaLista);
                            userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                            redirAttrs.addFlashAttribute("SucessoCadastro", "Cadastro da despesa salvo com sucesso");
                        }
                        // SE O DIA DA DESPESA FOR MENOR DO QUE O DIA ATUAL (ERRADO)
                        else{
                            System.err.println("ELSE 1");
                            redirAttrs.addFlashAttribute("ErroCadastro", "A data do pagamento não pode ser maior do que a data atual");
                        }
                    }
                    // SE O MÊS DA DESPESA FOR MENOR DO QUE O MÊS ATUAL (ERRADO)
                    else{
                        System.err.println("ELSE 2");
                        redirAttrs.addFlashAttribute("ErroCadastro", "A data da despesa não pode ser maior do que a data atual");
                    }
                }
                // SE O ANO DA DESPESA FOR MENOR DO QUE O ANO ATUAL (ERRADO)
                else{
                    System.err.println("ELSE 3");
                    redirAttrs.addFlashAttribute("ErroCadastro", "O ano da despesa não pode ser maior do que o ano atual");
                }

            }

        }
        // SE A DESCRIÇÃO ESTIVER VAZIA
        else{
            redirAttrs.addFlashAttribute("ErroCadastro", "Houve um erro no cadastro da despesa");
        }

        modelAndView.setViewName("redirect:despesas");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView despesasControllerEdit(Liability liability, RedirectAttributes redirAttrs, ModelAndView modelAndView){

        // SE A DESCRIÇÃO ESTIVER PREENCHIDA
        if(!liability.getDescription().equals("") || liability.getStatusLiability() != null){

            // SE O STATUS ESTIVER COMO A PAGAR
            if(liability.getStatusLiability()== StatusLiability.PAGAR){

                liability.setMean(Mean.ABERTO);

                // SE O AGENDAMENTO ESTIVER EM BRANCO ELE É JOGADO COMO NULO
                if(liability.getScheduling().equals("")){
                    liability.setScheduling(null);
                    liability.setCreated(dates.todayBr());
                    utils.loggedUser(userRepository).getLiabilities().set(utils.loggedUser(userRepository).getLiabilities()
                            .indexOf(liabilityService.findById(liability.getId()).get()), liability);
                    userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                    redirAttrs.addFlashAttribute("SucessoCadastro", "Alteração salva com sucesso");
                }

                // SE O AGENDAMENTO ESTIVER PREENCHIDO ELE É VALIDADO PARA QUE NÃO SEJA NO PASSADO
                else{
                    String[] agendamento = liability.getScheduling().split("-");
                    // SE O ANO DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                    if(Integer.parseInt(agendamento[0]) >= Integer.parseInt(dates.splitedToday()[0])){
                        // SE O MÊS DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                        if(Integer.parseInt(agendamento[1]) >= Integer.parseInt(dates.splitedToday()[1])){
                            // SE O DIA DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                            if(Integer.parseInt(agendamento[2]) >= Integer.parseInt(dates.splitedToday()[2])){
                                // SALVANDO A DESPESA NO BANCO DE DADOS
                                liability.setCreated(dates.todayBr());
                                utils.loggedUser(userRepository).getLiabilities().set(utils.loggedUser(userRepository).getLiabilities()
                                        .indexOf(liabilityService.findById(liability.getId()).get()), liability);
                                userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                                redirAttrs.addFlashAttribute("SucessoCadastro", "Atualização salva com sucesso");
                            }
                            // SE O DIA DO AGENDAMENTO FOR MENOR DO QUE O DIA ATUAL (ERRADO)
                            else{
                                redirAttrs.addFlashAttribute("ErroCadastro", "A data do agendamento não pode ser menor do que a data atual");
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

                String[] dataDespesa = liability.getDate().split("-");

                // SE O ANO DA DESPESA FOR MENOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                if(Integer.parseInt(dataDespesa[0]) <= Integer.parseInt(dates.splitedToday()[0])){
                    System.err.println("IF 1");
                    // SE O MÊS DA DESPESA FOR MENOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                    if(Integer.parseInt(dataDespesa[1]) <= Integer.parseInt(dates.splitedToday()[1])){
                        System.err.println("IF 2");
                        // SE O DIA DA DESPESA FOR MENOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                        if(Integer.parseInt(dataDespesa[2]) <= Integer.parseInt(dates.splitedToday()[2])){
                            System.err.println("IF 3");
                            // SALVANDO A DESPESA NO BANCO DE DADOS
                            liability.setCreated(dates.todayBr());
                            utils.loggedUser(userRepository).getLiabilities().set(utils.loggedUser(userRepository).getLiabilities()
                                    .indexOf(liabilityService.findById(liability.getId()).get()), liability);
                            userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
                            redirAttrs.addFlashAttribute("SucessoCadastro", "Atualização salva com sucesso");
                        }
                        // SE O DIA DA DESPESA FOR MENOR DO QUE O DIA ATUAL (ERRADO)
                        else{
                            System.err.println("ELSE 1");
                            redirAttrs.addFlashAttribute("ErroCadastro", "A data do pagamento não pode ser maior do que a data atual");
                        }
                    }
                    // SE O MÊS DA DESPESA FOR MENOR DO QUE O MÊS ATUAL (ERRADO)
                    else{
                        System.err.println("ELSE 2");
                        redirAttrs.addFlashAttribute("ErroCadastro", "A data da despesa não pode ser maior do que a data atual");
                    }
                }
                // SE O ANO DA DESPESA FOR MENOR DO QUE O ANO ATUAL (ERRADO)
                else{
                    System.err.println("ELSE 3");
                    redirAttrs.addFlashAttribute("ErroCadastro", "O ano da despesa não pode ser maior do que o ano atual");
                }

            }

        }
        // SE A DESCRIÇÃO ESTIVER VAZIA
        else{
            redirAttrs.addFlashAttribute("ErroCadastro", "Houve um erro no cadastro da despesa");
        }

        modelAndView.setViewName("redirect:../despesas");
        return modelAndView;
    }

    @PostMapping("/delete-{id}")
    public ModelAndView despesasControllerDelete(@PathVariable Long id, RedirectAttributes redirAttrs, ModelAndView modelAndView){
        utils.loggedUser(userRepository).getLiabilities().remove(utils.loggedUser(userRepository).getLiabilities().indexOf(liabilityService.findById(id).get()));
        System.err.println(utils.loggedUser(userRepository).getLiabilities());
        userService.updateUser(id, utils.loggedUser(userRepository));
        liabilityService.deleteLiability(id);
        redirAttrs.addFlashAttribute("SucessoDelete", "Despesa deletada com sucesso");
        modelAndView.setViewName("redirect:../despesas");
        return modelAndView;
    }

}
