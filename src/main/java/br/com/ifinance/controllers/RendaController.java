package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.models.enums.IncomeType;
import br.com.ifinance.repositories.IncomeRepository;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.IncomeService;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.IncomeUtils;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/renda")
public class RendaController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    IncomeService incomeService;

    Utils utils = new Utils();
    IncomeUtils incomeUtils = new IncomeUtils();
    Dates dates = new Dates();



    @GetMapping
    public ModelAndView rendaControllerGet(ModelAndView modelAndView,
                                           Model model, ModelMap modelMap,
                                           RedirectAttributes redirAttrs){

        modelMap.addAttribute("username", utils.loggedUser(userRepository).getUsername());
        model.addAttribute("Salarios", incomeUtils.Rendas(utils.loggedUser(userRepository), IncomeType.SALARIO));
        model.addAttribute("Dividendos", incomeUtils.Rendas(utils.loggedUser(userRepository), IncomeType.DIVIDENDO));
        model.addAttribute("Extras", incomeUtils.Rendas(utils.loggedUser(userRepository), IncomeType.EXTRA));
        model.addAttribute("Outros", incomeUtils.Rendas(utils.loggedUser(userRepository), IncomeType.OUTRO));

        model.addAttribute("SomaSalario", incomeUtils.somaRenda(utils.loggedUser(userRepository), IncomeType.SALARIO));
        model.addAttribute("SomaDividendo", incomeUtils.somaRenda(utils.loggedUser(userRepository), IncomeType.DIVIDENDO));
        model.addAttribute("SomaExtra", incomeUtils.somaRenda(utils.loggedUser(userRepository), IncomeType.EXTRA));
        model.addAttribute("SomaOutros", incomeUtils.somaRenda(utils.loggedUser(userRepository), IncomeType.OUTRO));

        modelAndView.setViewName("renda");
        return modelAndView;
    }

    @PostMapping("/novo")
    public ModelAndView salarioControllerPost(Income income,
                                              ModelAndView modelAndView,
                                              Model model,
                                              RedirectAttributes redirAttrs){

        redirAttrs.addFlashAttribute("Sucesso", income.getIncomeType().getDesc() + " salvo com sucesso");
        income.setUser(utils.loggedUser(userRepository));
        income.setDate(dates.today());
        List<Income> userIncomes = utils.loggedUser(userRepository).getIncomes();
        userIncomes.add(income);
        utils.loggedUser(userRepository).setIncomes(userIncomes);
        userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
        modelAndView.setViewName("redirect:../renda");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView salarioControllerEdit(Income income,
                                              RedirectAttributes redirAttrs,
                                              ModelAndView modelAndView){

        Income newIncome = incomeService.findById(income.getId()).get();
        redirAttrs.addFlashAttribute("Sucesso", income.getIncomeType().getDesc() + " atualizado com sucesso");
        newIncome.setDescription(income.getDescription());
        newIncome.setValue(income.getValue());
        newIncome.setFrequency(income.getFrequency());

        utils.loggedUser(userRepository).getIncomes().set(utils.loggedUser(userRepository).getIncomes()
                .indexOf(incomeService.findById(income.getId()).get()), newIncome);
        userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
        modelAndView.setViewName("redirect:../renda");

        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView salarioControllerDelete(Income income,
                                                RedirectAttributes redirAttrs,
                                                ModelAndView modelAndView){

        redirAttrs.addFlashAttribute("Sucesso", incomeService.findById
                (income.getId()).get().getIncomeType().getDesc() + " deletado com sucesso");
        utils.loggedUser(userRepository).getIncomes().remove(incomeService.findById(income.getId()).get());
        incomeService.delete(income.getId());
        modelAndView.setViewName("redirect:../renda");
        return modelAndView;
    }

}
