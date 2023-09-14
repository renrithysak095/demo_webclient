package com.example.boyfriend.controller;
import com.example.boyfriend.dto.BoyfriendDto;
import com.example.boyfriend.model.BoyFriend;
import com.example.boyfriend.request.BoyfriendRequest;
import com.example.boyfriend.service.BoyfriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/boyfriend")
public class BoyfriendController {

    private final BoyfriendService boyfriendService;
    public BoyfriendController(BoyfriendService boyfriendService) {
        this.boyfriendService = boyfriendService;
    }

    @GetMapping
    public ResponseEntity<List<BoyfriendDto>> getAll(){
        return ResponseEntity.ok().body(boyfriendService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> requestBoyfriend(@RequestBody BoyfriendRequest boyfriendRequest){
        return ResponseEntity.ok().body(boyfriendService.addBf(boyfriendRequest));
    }


}
