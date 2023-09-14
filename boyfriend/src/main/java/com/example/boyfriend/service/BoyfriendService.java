package com.example.boyfriend.service;

import com.example.boyfriend.dto.BoyfriendDto;
import com.example.boyfriend.model.BoyFriend;
import com.example.boyfriend.request.BoyfriendRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoyfriendService {
    List<BoyfriendDto> getAll();
    BoyFriend addBf(BoyfriendRequest boyfriendRequest);
}
