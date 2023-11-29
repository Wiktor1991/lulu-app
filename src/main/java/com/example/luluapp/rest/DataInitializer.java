package com.example.luluapp.rest;

import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.models.Client;
import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.BreadService;
import com.example.luluapp.rest.service.ClientService;
import com.example.luluapp.rest.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BreadService breadService;
    private final ClientService clientService;
    private final OrderService orderService;

    public DataInitializer(BreadService breadService, ClientService clientService, OrderService orderService) {
        this.breadService = breadService;
        this.clientService = clientService;
        this.orderService = orderService;
    }


       @Bean
    public void addSomeRecords(){

           Bread brot1 = Bread.builder()
                   .articleNumber(67)
                   .name("UnsereMildes500")
                   .picture("bild0")
                   .build();

           Bread brot2 = Bread.builder()
                   .articleNumber(64)
                   .name("volkorntoast")
                   .picture("bild1").build();

           Bread brot3 = Bread.builder()
                   .articleNumber(108)
                   .name("Weissbrot750")
                   .picture(" bild3")
                   .build();

           this.breadService.addBread(brot1);
           this.breadService.addBread(brot2);
           this.breadService.addBread(brot3);

           Client edeka = Client.builder()
                .clientNumber(100204L)
                .tour("98")
                .name("Edeka Wilde")
                .city("Friedersdorf")
                .build();
        Client rewe = Client.builder()
                .clientNumber(100648L)
                .tour("97")
                .name("Rewe Adolf")
                .city("Fürstenwalde")
                .build();
        Client kaufland = Client.builder()
                .clientNumber(100526L)
                .tour("158")
                .name("Kaufland Heilbronnerstr")
                .city("Frankfurt/Oder")
                .build();
        this.clientService.addClient(edeka);
        this.clientService.addClient(rewe);
        this.clientService.addClient(kaufland);

           int[] orders = {12,4,6,8,11,25};
           int[] orders2 = {12,8,5,6,12,4};
           int[] orders3 = {2,8,5,2,3,4};

           Order ord1 = Order.builder()
                   .bread(brot1)
                   .client(edeka)
                   .orders(orders)
                   .build();

           Order ord2 = Order.builder()
                   .bread(brot2)
                   .client(rewe)
                   .orders(orders2)
                   .build();

           Order ord3 = Order.builder()
                   .bread(brot3)
                   .client(kaufland)
                   .orders(orders3)
                   .build();
           this.orderService.addOrder(ord1);
           this.orderService.addOrder(ord2);
           this.orderService.addOrder(ord3);

       }

}
