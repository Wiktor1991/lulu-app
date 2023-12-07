package com.example.luluapp.web.controllers;

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
public class ViewController {

    private final BreadService breadService;

    public ViewController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping("/save")
    public String addBread(Model model){
        BreadCreationDto breads = new BreadCreationDto();
        breadService.getAllBreads().iterator().forEachRemaining(bread -> breads.addBread(bread));

        model.addAttribute("breads", breads);

        return "breads";
    }

    @PostMapping("/edit")
    public String updateBread(@ModelAttribute BreadCreationDto breads, Model model){

        breads.getBreads().stream().forEach(bread -> {
            log.info("new breads are coming : " + bread);
        });
        model.addAttribute("breads",breads);


        return "redirect:/save";
    }
}
