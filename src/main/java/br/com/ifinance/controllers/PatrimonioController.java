package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.enums.PatrimonyType;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.PatrimonyService;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.PatrimonyUtils;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PatrimonyService patrimonyService;

    PatrimonyUtils patrimonyUtils = new PatrimonyUtils();
    Utils utils = new Utils();
    Dates dates = new Dates();

    @GetMapping
    public ModelAndView patrimonioControllerGet(@RequestParam("type") Optional<String> type,
                                                @RequestParam("page") Optional<Integer> page,
                                                Model model,
                                                ModelMap modelMap,
                                                RedirectAttributes redirAttrs,
                                                ModelAndView modelAndView,
                                                HttpServletRequest req){

        String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        Integer currentPage = page.orElse(1);
        String currentType = type.orElse("all");
        modelMap.addAttribute("baseUrl", baseUrl);
        modelMap.addAttribute("username", utils.loggedUser(userRepository).getUsername());

        Map<Integer, List<Patrimony>> mapPages = patrimonyUtils.patrimonyPagination
                (utils.loggedUser(userRepository), currentType, 3);
        Integer totalPages = patrimonyUtils.totalPages
                (utils.loggedUser(userRepository), currentType, 3);
        List<Integer> pageNumbers = patrimonyUtils.pageNumberList
                (patrimonyUtils.totalPages(utils.loggedUser(userRepository), currentType, 3));

        // DEFINE A QUANTIDADE DE ITENS A SER INSERIDO POR P??GINA
        if(!mapPages.get(currentPage).isEmpty()) {
            model.addAttribute("assets", mapPages.get(currentPage));
        }

        model.addAttribute("type", currentType);
        model.addAttribute("pageNumbers", pageNumbers);
        modelMap.addAttribute("assetsSum", patrimonyUtils.patrimonySum(utils.loggedUser(userRepository)));
        modelMap.addAttribute("assetsAllSum", patrimonyUtils.patrimonyAllSum(utils.loggedUser(userRepository)));
        modelMap.addAttribute("page" ,currentPage);

        modelAndView.setViewName("patrimonio");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView patrimonioControllerPost(Patrimony patrimony,
                                                 RedirectAttributes redirAttrs,
                                                 ModelAndView modelAndView){

        patrimony.setUser(utils.loggedUser(userRepository));
        patrimony.setDate(dates.today());
        List<Patrimony> userAssets = utils.loggedUser(userRepository).getAssets();
        userAssets.add(patrimony);
        utils.loggedUser(userRepository).setAssets(userAssets);

        userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));

        redirAttrs.addFlashAttribute("Sucesso", "Patrim??nio salvo com sucesso!");
        modelAndView.setViewName("redirect:patrimonio");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView patrimonioControllerEdit(Patrimony patrimony,
                                                 RedirectAttributes redirAttrs,
                                                 ModelAndView modelAndView){

        patrimony.setUser(userService.findById(utils.loggedUser(userRepository).getId()).get());
        List<Patrimony> userAssets = utils.loggedUser(userRepository).getAssets();
        userAssets.set(userAssets.indexOf(patrimonyService.findById(patrimony.getId()).get()), patrimony);
        utils.loggedUser(userRepository).setAssets(userAssets);
        userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
        redirAttrs.addFlashAttribute("Sucesso", "Patrim??nio editado com sucesso!");
        modelAndView.setViewName("redirect:../patrimonio");
        return modelAndView;

    }

    @PostMapping("/delete-{id}")
    public ModelAndView patrimonioControllerDelete(@PathVariable Long id,
                                                   RedirectAttributes redirAttrs,
                                                   ModelAndView modelAndView){

        List<Patrimony> userAssets = utils.loggedUser(userRepository).getAssets();
        userAssets.remove(patrimonyService.findById(id).get());
        userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));
        patrimonyService.deletePatrimony(id);
        redirAttrs.addFlashAttribute("Sucesso", "Patrim??nio exclu??do com sucesso!");
        modelAndView.setViewName("redirect:../patrimonio");
        return modelAndView;
    }
}
