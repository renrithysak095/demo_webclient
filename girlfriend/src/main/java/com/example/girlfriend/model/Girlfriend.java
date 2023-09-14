package com.example.girlfriend.model;

import com.example.girlfriend.dto.GirlfriendDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "girlfriends")
public class Girlfriend {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "girlfriends_id")
    private UUID id;

    @Column(name = "girlfriends_name")
    private String name;

    public GirlfriendDto toDto(){
        return new GirlfriendDto(id, name);
    }

}
