package com.example.girlfriend.service.implementation;
import com.example.girlfriend.dto.GirlfriendDto;
import com.example.girlfriend.model.Girlfriend;
import com.example.girlfriend.repository.GirlfriendRepository;
import com.example.girlfriend.request.GirlfriendRequest;
import com.example.girlfriend.service.GirlfriendService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GirlfriendServiceImpl implements GirlfriendService {

    private final GirlfriendRepository girlfriendRepository;

    public GirlfriendServiceImpl(GirlfriendRepository girlfriendRepository) {
        this.girlfriendRepository = girlfriendRepository;
    }

    @Override
    public List<GirlfriendDto> getAll() {
        List<GirlfriendDto> bfDto = girlfriendRepository.findAll().stream().map(Girlfriend::toDto).collect(Collectors.toList());
        return bfDto;
    }

    @Override
    public Girlfriend addGf(GirlfriendRequest girlfriendRequest) {
        return girlfriendRepository.save(girlfriendRequest.toEntity());
    }

    @Override
    public GirlfriendDto getById(UUID id) {
        return girlfriendRepository.findById(id).get().toDto();
    }
}
