package com.example.learn_webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/rest-template")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/fetch-data")
    public String fetchData(Model model) {

        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = response.getBody();
        model.addAttribute("data", responseBody);
//        return "data-view";

        return responseBody;
    }



}
