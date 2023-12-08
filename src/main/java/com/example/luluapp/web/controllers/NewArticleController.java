package com.example.luluapp.web.controllers;

import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.service.BreadService;
import com.example.luluapp.web.dto.BreadCreationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class NewArticleController {

    private final BreadService breadService;

    public NewArticleController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping("/save")
    public String addBread(Model model){
        Bread bread1 = new Bread();
        model.addAttribute("bread",bread1);

        return "breads";
    }

    @PostMapping("/edit")
    public String updateBread(@ModelAttribute Bread bread){

        breadService.addBread(bread);

        log.info(" bread for save "+bread);
        return "redirect:/save";
    }
}
