package com.example.luluapp.rest;

import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.models.Client;
import com.example.luluapp.rest.models.Tour;
import com.example.luluapp.rest.service.BreadService;
import com.example.luluapp.rest.service.ClientService;
import com.example.luluapp.rest.service.TourService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    private final BreadService breadService;
    private final ClientService clientService;
    private final TourService tourService;

    public DataInitializer(BreadService breadService, ClientService clientService, TourService orderService) {
        this.breadService = breadService;
        this.clientService = clientService;
        this.tourService = orderService;
    }


    public List<Bread> breads() {

        int[] orders = {1,1,2,6,8,9};
        int[] orders2 = {7,7,4,5,6,9};

           Bread brot1 = Bread.builder()
                   .articleNumber(67)
                   .name("UnsereMildes500")
                   .orders(orders)
                   .picture("https://img.rewe-static.de/4922506/3488850_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                   .build();

           Bread brot2 = Bread.builder()
                   .orders(orders2)
                   .articleNumber(64)
                   .name("volkorntoast")
                   .picture("https://img.rewe-static.de/4922506/3488850_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp").build();

           Bread brot3 = Bread.builder()
                   .orders(orders)
                   .articleNumber(108)
                   .name("Weissbrot750")
                   .picture("https://img.rewe-static.de/4922239/5332540_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                   .build();
           return List.of(brot1,brot2,brot3);
       }
       public List<Bread> breads1(){

        int[] orders = {3,6,3,2,1,1};
        int[] orders2 = {6,5,8,9,3,4};
        Bread br = Bread.builder()
                .name("Vitamin400")
                .articleNumber(4953)
                .picture("ssad")
                .orders(orders)
                .build();
        Bread br2 = Bread.builder()
                .name("VitalFit500")
                .articleNumber(101)
                .picture("saa")
                .orders(orders2)
                .build();
        return List.of(br,br2);
       }

       public List<Client> clients(){
        Client client = Client.builder()
                .name("Edeka")
                .clientNumber(66569L)
                .breadList(breads())
                .build();
        Client client1 = Client.builder()
                .name("Kaufland")
                .clientNumber(6456464L)
                .breadList(breads1())
                .build();

        clientService.saveAll(List.of(client1,client));

        return List.of(client1,client);

       }

       public List<Client> clients2(){
        Client cl1 = Client.builder()
                .name("Nah und Gut")
                .clientNumber(256644L)
                .breadList(breads1())
                .build();

        Client cl2 = Client.builder()
                .name("Marktkauf")
                .clientNumber(6984646L)
                .breadList(breads())
                .build();

        clientService.saveAll(List.of(cl1,cl2));

        return List.of(cl2,cl1);
       }

       @Bean
    public void addOrder(){
        Tour ord = Tour.builder()
                .tourNumber("97")
                .clients(clients())
                .build();

        Tour ord2 = Tour.builder()
                        .tourNumber("158")
                                .clients(clients())
                                        .build();

        Tour ord3 = Tour.builder()
                        .tourNumber("98")
                                .clients(clients2())
                                        .build();

        tourService.save(ord2);
        tourService.save(ord3);
        tourService.save(ord);
       }
}
