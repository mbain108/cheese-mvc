package com.melissadbain.cheesemvc.controllers;

import com.melissadbain.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import javax.validation.Valid;
import com.melissadbain.cheesemvc.models.Cheese;
import com.melissadbain.cheesemvc.models.CheeseData;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", CheeseData.getAll());

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {

            model.addAttribute("title", "Add Cheese");
            model.addAttribute(newCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());

            return "cheese/add";
        }

        CheeseData.add(newCheese);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", CheeseData.getAll());

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {

            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        Cheese toEdit = CheeseData.getById(cheeseId);

        model.addAttribute("title", "Edit Cheese " +
                toEdit.getName() + "(id=" + cheeseId + ")");
        model.addAttribute("cheese", toEdit);
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese, Errors errors, int cheeseId, Model model) {

        Cheese toEdit = CheeseData.getById(cheeseId);

        if (errors.hasErrors()) {

            model.addAttribute("title", "Edit Cheese " +
                    toEdit.getName() + "(id=" + cheeseId + ")");
            model.addAttribute("cheese", cheese);
            model.addAttribute("cheeseTypes", CheeseType.values());

            return "cheese/edit";
        }

        toEdit.setName(cheese.getName());
        toEdit.setDescription(cheese.getDescription());
        toEdit.setType(cheese.getType());
        toEdit.setRating(cheese.getRating());

        return "redirect:";
    }
}