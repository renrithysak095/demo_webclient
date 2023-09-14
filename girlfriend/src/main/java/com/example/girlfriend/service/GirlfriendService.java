package com.example.girlfriend.service;

import com.example.girlfriend.dto.GirlfriendDto;
import com.example.girlfriend.model.Girlfriend;
import com.example.girlfriend.request.GirlfriendRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GirlfriendService {

    List<GirlfriendDto> getAll();

    Girlfriend addGf(GirlfriendRequest girlfriendRequest);

    GirlfriendDto getById(UUID id);
}
