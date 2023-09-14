package com.example.girlfriend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class GirlfriendDto {

    private UUID id;
    private String name;

    public GirlfriendDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
