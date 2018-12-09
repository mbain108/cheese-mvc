package com.melissadbain.cheesemvc.controllers;

import com.melissadbain.cheesemvc.models.User;
import com.melissadbain.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "My Cheeses: Users");

        return "user/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {

        model.addAttribute("title", "My Cheeses: New User");
        model.addAttribute(new User());

        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors,
                                     String verify, Model model) {

        model.addAttribute(newUser);

        if (errors.hasErrors() || !newUser.getPassword().equals(verify)) {

            if (!newUser.getPassword().equals(verify)) {

                model.addAttribute("title", "My Cheeses: New User");
                model.addAttribute("noMatch", "passwords must match");
            }

            return "user/add";
        }

        UserData.add(newUser);

        return "redirect:";
    }

    @RequestMapping(value="{userId}", method = RequestMethod.GET)
    public String displayHome(Model model, @PathVariable int userId) {

        User toDisplay = UserData.getByUserId(userId);
        model.addAttribute("title", "My Cheeses: Display User");
        model.addAttribute("user", toDisplay);

        return"user/user";
    }
}