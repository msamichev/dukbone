package ru.sam.dukbone.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.sam.dukbone.util.LoggerWrapper;

/**
 *
 */
@Controller
public class RootController {

    private static final LoggerWrapper LOG = LoggerWrapper.get(RootController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        LOG.debug("redirect from root to welcome");
        return "redirect:welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(Model model) {
        LOG.debug("move to welcome page");
        ModelAndView modelAndView = new ModelAndView("welcome");
        return modelAndView;
    }

}
