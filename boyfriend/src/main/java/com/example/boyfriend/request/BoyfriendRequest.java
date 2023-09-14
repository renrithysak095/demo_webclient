package com.example.boyfriend.request;

import com.example.boyfriend.model.BoyFriend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoyfriendRequest {

    private String name;

    public BoyFriend toEntity(){
        return new BoyFriend(null, name);
    }

}
