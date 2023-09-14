package com.example.learn_webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllInstance {

    List<Girlfriend> girlfriend;
    List<Boyfriend> boyfriend;

}
