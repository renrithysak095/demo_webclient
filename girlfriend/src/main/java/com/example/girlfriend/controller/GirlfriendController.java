package com.example.girlfriend.controller;
import com.example.girlfriend.dto.GirlfriendDto;
import com.example.girlfriend.request.GirlfriendRequest;
import com.example.girlfriend.service.GirlfriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/girlfriend")
public class GirlfriendController {

    private final GirlfriendService girlfriendService;

    public GirlfriendController(GirlfriendService girlfriendService) {
        this.girlfriendService = girlfriendService;
    }

    @GetMapping
    public ResponseEntity<List<GirlfriendDto>> getAll(){
        return ResponseEntity.ok().body(girlfriendService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GirlfriendDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok().body(girlfriendService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> requestBoyfriend(@RequestBody GirlfriendRequest girlfriendRequest){
        return ResponseEntity.ok().body(girlfriendService.addGf(girlfriendRequest));
    }



    @GetMapping("/my-string")
    public String myString(){
        return "This is my String";
    }

}
