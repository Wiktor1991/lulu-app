package com.example.luluapp.rest.restControllers;

import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.service.BreadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BreadRestController {


    private final BreadService breadService;

    public BreadRestController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping("/breads")
    public List<Bread> getAllBreads(){
        return this.breadService.getAllBreads();
    }

}
