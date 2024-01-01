package com.example.luluapp.web.controllers;
import com.example.luluapp.rest.models.Client;
import com.example.luluapp.rest.models.Tour;
import com.example.luluapp.rest.service.BreadService;
import com.example.luluapp.rest.service.TourService;
import com.example.luluapp.web.dto.BreadCreationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@Slf4j
public class OrderController {

    private final TourService tourService;

    private final BreadService breadService;

    private boolean isSaved;


    public OrderController(TourService tourService, BreadService breadService) {
        this.tourService = tourService;
        this.breadService = breadService;
    }

    @GetMapping("/orders")
    public String orders(@ModelAttribute (name = "client") Long clientId,
                         @ModelAttribute(name ="tourNumber") String tourNumber,
                         Model model){
        BreadCreationDto breadCreationDto = new BreadCreationDto();
        log.info(tourNumber+"***************");
        log.info(clientId+"***************");

        Tour choosedTour = tourService.findAll().stream()
                .filter(tour -> tour.getTourNumber().equals(tourNumber)).findFirst().orElseThrow();

        Client choosedClient = choosedTour.getClients().stream()
                .filter(client2 -> client2.getId().equals(clientId)).findFirst().orElseThrow();

        choosedClient.getBreadList().forEach(breadCreationDto::addBread);


        breadCreationDto.getBreads().forEach(System.out::println);
        log.info("***** is saved from GET mapping " + isSaved);

        model.addAttribute("client",choosedClient);
        model.addAttribute("breads",breadCreationDto);
        model.addAttribute("isSaved", isSaved);


        return "orders";
    }
    @PostMapping("/update")
    public String updateOrders(@ModelAttribute(name = "breads") BreadCreationDto breadCreationDto,
                               @ModelAttribute(name ="calenderWeek") String calenderWeek,
                               @ModelAttribute(name = "client") Long clientId,
                               @ModelAttribute(name = "tourNumber") String tourNumber,
                               RedirectAttributes redirectAttributes){


        log.info(breadCreationDto.getBreads().toString());
        breadService.saveAll(breadCreationDto.getBreads());
        isSaved = true;
        log.info("******** is saved from POST mapping " +isSaved);

        log.info("****** "+ clientId);

        redirectAttributes.addAttribute("client", clientId);
        redirectAttributes.addAttribute("tourNumber", tourNumber);
        return "redirect:/orders";

//        return "home";
    }

    @PostMapping("/change")
    public String changeStatus(@ModelAttribute(name = "tourNumber") String tourNumber,
                               RedirectAttributes redirectAttributes){
        isSaved = false;
        redirectAttributes.addAttribute("tourNumber", tourNumber);
        return "redirect:/clients";
    }

}
