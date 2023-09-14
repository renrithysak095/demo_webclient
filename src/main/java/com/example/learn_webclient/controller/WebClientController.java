package com.example.learn_webclient.controller;

import com.example.learn_webclient.service.implementation.WebClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/web-client")
public class WebClientController {

    private final WebClientServiceImpl webClientService;

    public WebClientController(WebClientServiceImpl webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping
    public void myClient(){
        webClientService.myWebClient();
    }

    @PostMapping
    public ResponseEntity<?> addData(){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<?> returnAll(){
        return ResponseEntity.ok().body(webClientService.returnAll());
    }

    @GetMapping("/used-mono-string")
    public ResponseEntity<?> returnMonoString(){
        return ResponseEntity.ok().body(webClientService.returnMonoString());
    }

}
