package com.example.learn_webclient.controller;
import com.example.learn_webclient.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/received")
public class MainController {

    private final MainService mainService;
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public ResponseEntity<?> getAllInstance(){
        return ResponseEntity.ok().body(mainService.getAllDataFromInstance());
    }

}
