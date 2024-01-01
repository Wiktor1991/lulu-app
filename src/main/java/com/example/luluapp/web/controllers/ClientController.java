package com.example.luluapp.web.controllers;

import com.example.luluapp.rest.models.Client;
import com.example.luluapp.rest.models.Tour;
import com.example.luluapp.rest.service.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class ClientController {

    private final TourService tourService;

    public ClientController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/clients")
    public String clients(@ModelAttribute(name = "tourNumber") String tourNumber,
                          Model model){
        Tour choosedTour = tourService.findAll().stream()
                .filter(tour -> tour.getTourNumber().equals(tourNumber)).findFirst().orElseThrow();

        List<Client> clients = choosedTour.getClients();

        model.addAttribute("clients", clients);
        model.addAttribute("tourNumber",tourNumber);

        return "clients";

    }

    @PostMapping("/clients")
    public String chooseClient(@ModelAttribute(name = "client") Long clientId,
                               @ModelAttribute(name="tourNumber") String tourNumber,
                               RedirectAttributes redirectAttributes){

        log.info("************" + clientId);
        log.info("***********" + tourNumber);
        redirectAttributes.addAttribute("client",clientId);
        redirectAttributes.addAttribute("tourNumber",tourNumber);
        return "redirect:/orders";

    }

}
