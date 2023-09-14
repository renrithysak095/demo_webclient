package com.example.learn_webclient.service;

import com.example.learn_webclient.model.MergeModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Service
public interface MainService {

    MergeModel getAllDataFromInstance();

}
