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


@Controller
@Slf4j
public class OrderController {

    private final TourService tourService;

    private final BreadService breadService;


    public OrderController(TourService tourService, BreadService breadService) {
        this.tourService = tourService;
        this.breadService = breadService;
    }

    @GetMapping("/orders")
    public String orders(@ModelAttribute (name = "client") String client,
                         @ModelAttribute(name ="tourNumber") String tourNumber,
                         Model model){
        BreadCreationDto breadCreationDto = new BreadCreationDto();
        String calenderWeek ="";

        log.info(tourNumber+"***************");
        log.info(client+"***************");

        Tour choosedTour = tourService.findAll().stream()
                .filter(tour -> tour.getTourNumber().equals(tourNumber)).findFirst().orElseThrow();

        Client choosedClient = choosedTour.getClients().stream()
                .filter(client2 -> client2.getName().equals(client)).findFirst().orElseThrow();

        choosedClient.getBreadList().forEach(bread -> breadCreationDto.addBread(bread));


        breadCreationDto.getBreads().forEach(System.out::println);

        model.addAttribute("client",choosedClient);
        model.addAttribute("breads",breadCreationDto);
        model.addAttribute("calenderWeek", calenderWeek);


        return "orders";


    }
    @PostMapping("/update")
    public String updateOrders(@ModelAttribute(name = "breads") BreadCreationDto breadCreationDto,
                               @ModelAttribute(name ="calenderWeek") String calenderWeek){

        System.out.println(calenderWeek + "***************************");

        log.info(breadCreationDto.getBreads().toString());

        breadService.saveAll(breadCreationDto.getBreads());

        return "home";
    }
}
