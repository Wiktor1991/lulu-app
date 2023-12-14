package com.example.luluapp.web.controllers;

import com.example.luluapp.rest.models.Tour;
import com.example.luluapp.rest.service.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tour")
    public String tour(Model model){
        log.info(tourService.findAll().toString());
        model.addAttribute("toures",tourService.findAll());
        return "tour";
    }
    @PostMapping("/go")
    public String goToTour(@ModelAttribute (name = "number") String tourNumber,
                           RedirectAttributes redirectAttributese){
        redirectAttributese.addAttribute("tourNumber", tourNumber);

        return "redirect:/clients";
    }
}
