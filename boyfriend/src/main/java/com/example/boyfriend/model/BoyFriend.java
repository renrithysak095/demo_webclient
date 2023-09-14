package com.example.boyfriend.model;

import com.example.boyfriend.dto.BoyfriendDto;
import com.example.boyfriend.request.BoyfriendRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boyfriends")
public class BoyFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "boyfriend_id")
    private UUID id;

    @Column(name = "boyfriend_name")
    private String name;

    public BoyfriendDto toDto(){
        return new BoyfriendDto(id, name);
    }


}
