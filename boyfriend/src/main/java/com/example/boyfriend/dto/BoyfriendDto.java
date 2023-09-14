package com.example.boyfriend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class BoyfriendDto {

    private UUID id;
    private String name;

    public BoyfriendDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

}
