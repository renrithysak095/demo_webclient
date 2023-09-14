package com.example.boyfriend.service.implementation;
import com.example.boyfriend.dto.BoyfriendDto;
import com.example.boyfriend.model.BoyFriend;
import com.example.boyfriend.repository.BoyfriendRepository;
import com.example.boyfriend.request.BoyfriendRequest;
import com.example.boyfriend.service.BoyfriendService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoyfriendServiceImpl implements BoyfriendService {
    private final BoyfriendRepository boyfriendRepository;

    public BoyfriendServiceImpl(BoyfriendRepository boyfriendRepository) {
        this.boyfriendRepository = boyfriendRepository;
    }

    @Override
    public List<BoyfriendDto> getAll() {
        List<BoyfriendDto> bfDto = boyfriendRepository.findAll().stream().map(BoyFriend::toDto).collect(Collectors.toList());
        return bfDto;
    }

    @Override
    public BoyFriend addBf(BoyfriendRequest boyfriendRequest) {
        return boyfriendRepository.save(boyfriendRequest.toEntity());
    }

}
