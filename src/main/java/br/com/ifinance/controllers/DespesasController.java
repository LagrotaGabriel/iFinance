package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusLiability;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.LiabilityService;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016 Calendar cal = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        int currentYear = year.orElse(cal.get(Calendar.YEAR));
        int currentMonth = month.orElse(cal.get(Calendar.MONTH)+1);
        int currentPage = page.orElse(1);

        modelMap.addAttribute("baseUrl", baseUrl);
        modelMap.addAttribute("year", currentYear);
        modelMap.addAttribute("month", currentMonth);
        modelMap.addAttribute("page" ,currentPage);

        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }

        // CONVERSÃO DAS DATAS A SEREM EXIBIDAS NA TABELA PARA PADRÃO BRASILEIRO: dd-MM-YY
        for(int i = 0; i < user.getLiabilities().size(); i++){

            if(user.getLiabilities().get(i).getDate() != null) {
                String[] dataSplited = user.getLiabilities().get(i).getDate().split("-");
                String dataBr = dataSplited[2] + '/' + dataSplited[1] + '/' + dataSplited[0];
                user.getLiabilities().get(i).setDate(dataBr);
            }
            if(user.getLiabilities().get(i).getScheduling() != null && !user.getLiabilities().get(i).getScheduling().equals("")) {
                String[] agendamentoSplited = user.getLiabilities().get(i).getScheduling().split("-");
                String agendamentoBr = agendamentoSplited[2] + '/' + agendamentoSplited[1] + '/' + agendamentoSplited[0];
                user.getLiabilities().get(i).setScheduling(agendamentoBr);
            }

        }

        // FILTRO DOS LIABILITIES POR DATA
        List<Liability> liabilitiesOfSelectedDate = new ArrayList<>();
        if(user.getLiabilities().size() > 0){
            for(int i = 0; i < user.getLiabilities().size(); i++){
                if(user.getLiabilities().get(i).getDate() != null && !user.getLiabilities().get(i).getDate().equals("")) {
                    String atual = user.getLiabilities().get(i).getDate();
                    String[] atualSplitado = atual.split("/");
                    if (Integer.parseInt(atualSplitado[2]) == (currentYear)) {
                        liabilitiesOfSelectedDate.add(user.getLiabilities().get(i));
                    }
                }
            }
            model.addAttribute("liabilities", liabilitiesOfSelectedDate);
        }
        else{
            model.addAttribute("liabilities", "");
        }

        // CLASSIFICANDO O NÚMERO DE PÁGINAS QUE A TABELA TERÁ
        int totalPages = liabilitiesOfSelectedDate.size()/5;
        List<Integer> pageNumbers = new ArrayList<>();
        if(totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }

        System.err.println("Total pages: " + totalPages);
        System.err.println("Page numbers: " + pageNumbers);

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("user", user);
        modelAndView.setViewName("despesas");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView despesasControllerPost(Liability liability, RedirectAttributes redirAttrs, ModelAndView modelAndView){
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }

        // DATA DE HOJE
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String hoje = dtf.format(now);
        String[] hojeSplitado = dtf.format(now).split("/");

        // SE A DESCRIÇÃO ESTIVER PREENCHIDA
        if(!liability.getDescription().equals("") || liability.getStatusLiability() != null){

            // SE O STATUS ESTIVER COMO A PAGAR
            if(liability.getStatusLiability()== StatusLiability.PAGAR){

                liability.setMean(Mean.ABERTO);

                // SE O AGENDAMENTO ESTIVER EM BRANCO ELE É JOGADO COMO NULO
                if(liability.getScheduling().equals("")){
                    liability.setScheduling(null);
                    liability.setUser(user);
                    List<Liability> novaLista = user.getLiabilities();
                    novaLista.add(liability);
                    user.setLiabilities(novaLista);
                    userService.updateUser(user.getId(), user);
                    redirAttrs.addFlashAttribute("SucessoCadastro", "Cadastro da despesa salvo com sucesso");
                }

                // SE O AGENDAMENTO ESTIVER PREENCHIDO ELE É VALIDADO PARA QUE NÃO SEJA NO PASSADO
                else{
                    String[] agendamento = liability.getScheduling().split("-");
                    // SE O ANO DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                    if(Integer.parseInt(agendamento[0]) >= Integer.parseInt(hojeSplitado[0])){
                        // SE O MÊS DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                        if(Integer.parseInt(agendamento[1]) >= Integer.parseInt(hojeSplitado[1])){
                            // SE O DIA DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                            if(Integer.parseInt(agendamento[2]) >= Integer.parseInt(hojeSplitado[2])){
                                // SALVANDO A DESPESA NO BANCO DE DADOS
                                liability.setUser(user);
                                List<Liability> novaLista = user.getLiabilities();
                                novaLista.add(liability);
                                user.setLiabilities(novaLista);
                                userService.updateUser(user.getId(), user);
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
                if(Integer.parseInt(dataDespesa[0]) <= Integer.parseInt(hojeSplitado[0])){
                    System.err.println("IF 1");
                    // SE O MÊS DA DESPESA FOR MENOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                    if(Integer.parseInt(dataDespesa[1]) <= Integer.parseInt(hojeSplitado[1])){
                        System.err.println("IF 2");
                        // SE O DIA DA DESPESA FOR MENOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                        if(Integer.parseInt(dataDespesa[2]) <= Integer.parseInt(hojeSplitado[2])){
                            System.err.println("IF 3");
                            // SALVANDO A DESPESA NO BANCO DE DADOS
                            liability.setUser(user);
                            List<Liability> novaLista = user.getLiabilities();
                            novaLista.add(liability);
                            user.setLiabilities(novaLista);
                            userService.updateUser(user.getId(), user);
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
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }

        System.err.println("POST ACESSADO");

        System.err.println("ID:" + liability.getId());

        // DATA DE HOJE
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String hoje = dtf.format(now);
        String[] hojeSplitado = dtf.format(now).split("/");

        // SE A DESCRIÇÃO ESTIVER PREENCHIDA
        if(!liability.getDescription().equals("") || liability.getStatusLiability() != null){

            // SE O STATUS ESTIVER COMO A PAGAR
            if(liability.getStatusLiability()== StatusLiability.PAGAR){

                liability.setMean(Mean.ABERTO);

                // SE O AGENDAMENTO ESTIVER EM BRANCO ELE É JOGADO COMO NULO
                if(liability.getScheduling().equals("")){
                    liability.setScheduling(null);
                    user.getLiabilities().set(user.getLiabilities()
                            .indexOf(liabilityService.findById(liability.getId()).get()), liability);
                    userService.updateUser(user.getId(), user);
                    redirAttrs.addFlashAttribute("SucessoCadastro", "Alteração salva com sucesso");
                }

                // SE O AGENDAMENTO ESTIVER PREENCHIDO ELE É VALIDADO PARA QUE NÃO SEJA NO PASSADO
                else{
                    String[] agendamento = liability.getScheduling().split("-");
                    // SE O ANO DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O ANO ATUAL (CORRETO)
                    if(Integer.parseInt(agendamento[0]) >= Integer.parseInt(hojeSplitado[0])){
                        // SE O MÊS DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                        if(Integer.parseInt(agendamento[1]) >= Integer.parseInt(hojeSplitado[1])){
                            // SE O DIA DO AGENDAMENTO FOR MAIOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                            if(Integer.parseInt(agendamento[2]) >= Integer.parseInt(hojeSplitado[2])){
                                // SALVANDO A DESPESA NO BANCO DE DADOS
                                user.getLiabilities().set(user.getLiabilities()
                                        .indexOf(liabilityService.findById(liability.getId()).get()), liability);
                                userService.updateUser(user.getId(), user);
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
                if(Integer.parseInt(dataDespesa[0]) <= Integer.parseInt(hojeSplitado[0])){
                    System.err.println("IF 1");
                    // SE O MÊS DA DESPESA FOR MENOR OU IGUAL DO QUE O MÊS ATUAL (CORRETO)
                    if(Integer.parseInt(dataDespesa[1]) <= Integer.parseInt(hojeSplitado[1])){
                        System.err.println("IF 2");
                        // SE O DIA DA DESPESA FOR MENOR OU IGUAL DO QUE O DIA ATUAL (CORRETO)
                        if(Integer.parseInt(dataDespesa[2]) <= Integer.parseInt(hojeSplitado[2])){
                            System.err.println("IF 3");
                            // SALVANDO A DESPESA NO BANCO DE DADOS
                            user.getLiabilities().set(user.getLiabilities()
                                    .indexOf(liabilityService.findById(liability.getId()).get()), liability);
                            userService.updateUser(user.getId(), user);
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
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }

        user.getLiabilities().remove(user.getLiabilities().indexOf(liabilityService.findById(id).get()));
        System.err.println(user.getLiabilities());
        userService.updateUser(id, user);
        liabilityService.deleteLiability(id);
        redirAttrs.addFlashAttribute("SucessoDelete", "Despesa deletada com sucesso");
        modelAndView.setViewName("redirect:../despesas");
        return modelAndView;
    }

}
