package com.example.girlfriend.request;

import com.example.girlfriend.dto.GirlfriendDto;
import com.example.girlfriend.model.Girlfriend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GirlfriendRequest {
    private String name;

    public Girlfriend toEntity(){
        return new Girlfriend(null, name);
    }
}
