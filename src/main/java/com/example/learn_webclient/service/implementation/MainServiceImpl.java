package com.example.learn_webclient.service.implementation;

import com.example.learn_webclient.model.MergeModel;
import com.example.learn_webclient.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.util.HashMap;

@Service
public class MainServiceImpl implements MainService {

    private final WebClient webClient;

    @Autowired
    public MainServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    @Override
    public MergeModel getAllDataFromInstance() {

       MergeModel mer = new MergeModel();

       Object fromInstanceGf = webClient.get()
                .uri("http://localhost:2025/api/v1/girlfriend")
                .retrieve()
                .bodyToMono(Object.class).block();

        Object fromInstanceBf = webClient.get()
                .uri("http://localhost:2024/api/v1/boyfriend")
                .retrieve()
                .bodyToMono(Object.class).block();

        mer.setMerge1(fromInstanceBf);
        mer.setMerge2(fromInstanceGf);


//        Mono<Tuple2<Object, Object>> combinedData = Mono.zip(fromInstanceGf, fromInstanceBf);
//
//        Tuple2<Object, Object> dataTuple = combinedData.block();
//
//        Object gfData = dataTuple.getT1();
//        Object bfData = dataTuple.getT2();
//
//        mer.setMerge1(gfData);
//        mer.setMerge2(bfData);

        return mer;
    }


}
