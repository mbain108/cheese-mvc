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

        model.addAttribute("title", "My Cheeses: Users");
        model.addAttribute("users", UserData.getAll());

        return "user/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {

        model.addAttribute("title", "My Cheeses: New User");
        model.addAttribute(new User());

        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add User");
            model.addAttribute(newUser);
            model.addAttribute("username", newUser.getUsername());
            model.addAttribute("email", newUser.getEmail());
            return "user/add";
        }

        UserData.add(newUser);
        model.addAttribute("user", newUser);
        model.addAttribute("title", "All Users");
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