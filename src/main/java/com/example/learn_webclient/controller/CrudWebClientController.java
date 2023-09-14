package com.example.learn_webclient.controller;

import com.example.learn_webclient.model.AllInstance;
import com.example.learn_webclient.model.Boyfriend;
import com.example.learn_webclient.model.Girlfriend;
import com.example.learn_webclient.model.RequestObject;
import com.example.learn_webclient.service.implementation.CrudWebClientImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/crud")
public class CrudWebClientController {

    private final CrudWebClientImpl crud;

    public CrudWebClientController(CrudWebClientImpl crud) {
        this.crud = crud;
    }

    @GetMapping("/get")
    public ResponseEntity<AllInstance> getAllInstance(){
        return ResponseEntity.ok().body(crud.getAllInstance());
    }

    @GetMapping("/get/limit/{take}")
    public ResponseEntity<AllInstance> getLimitValue(@PathVariable Integer take){
        return ResponseEntity.ok().body(crud.getLimitData(take));
    }

    @GetMapping("/get/limit-nonblocking/{take}")
    public ResponseEntity<?> getLimitNonBlockingValue(@PathVariable Integer take){
        return ResponseEntity.ok().body(crud.getLimitDataNonBlocking(take));
    }

    @GetMapping("/get/flux")
    public Flux<Girlfriend> getGirl(){
        return crud.getGirlFlux();
    }

    @GetMapping("/get/multi-flux")
    public Flux<?> getMulti(){
        return crud.getMultiFlux();
    }


    @PostMapping("/post")
    public ResponseEntity<Boyfriend> postInstance(@RequestBody RequestObject requestObject){
        return ResponseEntity.ok().body(crud.postInstance(requestObject));
    }


}
