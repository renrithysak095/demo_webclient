package com.example.learn_webclient.service.implementation;

import com.example.learn_webclient.model.AllInstance;
import com.example.learn_webclient.model.Boyfriend;
import com.example.learn_webclient.model.Girlfriend;
import com.example.learn_webclient.model.RequestObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class CrudWebClientImpl {

    private final static String apiUrlInstance1 = "http://localhost:2024/";
    private final static String ApiUrlInstance2 = "http://localhost:2025/";

    private final WebClient webClientInstance1;
    private final WebClient webClientInstance2;

    public CrudWebClientImpl(WebClient.Builder webClientInstance1, WebClient.Builder webClientInstance2) {
        this.webClientInstance1 = webClientInstance1
                .baseUrl(apiUrlInstance1)
                .defaultHeader("Authorization", "Bearer ")
                .build();
        this.webClientInstance2 = webClientInstance2
                .baseUrl(ApiUrlInstance2)
                .defaultHeader("Authorization", "Bearer ")
                .build();
    }

    public AllInstance getAllInstance() {

        List<Boyfriend> boyfriendList = webClientInstance1
                .get()
                .uri("api/v1/boyfriend")
                .retrieve()
                .bodyToFlux(Boyfriend.class)
                .buffer().blockLast();

        List<Girlfriend> girlfriendList = webClientInstance2
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class)
                .buffer().blockLast();

        return new AllInstance(girlfriendList,boyfriendList);
    }

    public Boyfriend postInstance(RequestObject requestObject) {

        Boyfriend boyfriend = webClientInstance1
                .post()
                .uri("api/v1/boyfriend")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestObject)
                .retrieve()
                .bodyToMono(Boyfriend.class)
                .block();

        return boyfriend;
    }

    public AllInstance getLimitData(Integer take) {

        List<Boyfriend> boyLimit = webClientInstance1
                .get()
                .uri("api/v1/boyfriend")
                .retrieve()
                .bodyToFlux(Boyfriend.class)
                .buffer(take)
                .blockLast();

        List<Girlfriend> girlLimit = webClientInstance2
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class)
                .buffer(take)
                .blockLast();

        return new AllInstance(girlLimit,boyLimit);
    }

    public AllInstance getLimitDataNonBlocking(Integer take) {

//        Girlfriend girlfriend = new Girlfriend();

        List<Boyfriend> boyLimitMono = webClientInstance1
                .get()
                .uri("api/v1/boyfriend")
                .retrieve()
                .bodyToFlux(Boyfriend.class)
                .take(take,true)
                .collectList()
                .block();

        Flux<Girlfriend> girlfriendMono = webClientInstance2
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class)
                .take(take)
                .map(val -> {
                    Girlfriend girlfriend = new Girlfriend();
                    girlfriend.setId(val.getId());
                    girlfriend.setName(val.getName());
                    return girlfriend;
                });

        return new AllInstance(girlfriendMono.buffer().blockLast(), boyLimitMono);

    }

    public Flux<Girlfriend> getGirlFlux() {
        return webClientInstance2
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class);
    }

    public Flux<?> getMultiFlux() {

        List<Girlfriend> girlfriends = webClientInstance2.get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class)
                .delayElements(Duration.ofSeconds(1))
                .buffer()
                .blockLast();

        System.out.println("GirlFriendBlock: " + girlfriends);
        System.out.println("Block invoked");

        Flux<Girlfriend> girlfriend = webClientInstance2
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class)
                .delayElements(Duration.ofSeconds(3));

        girlfriend.subscribe(val -> {
            System.out.println("GirlFriend: " + val);
        });

        Flux<Boyfriend> boyfriend = webClientInstance1
                .get()
                .uri("api/v1/boyfriend")
                .retrieve()
                .bodyToFlux(Boyfriend.class)
                .delayElements(Duration.ofSeconds(3));

        boyfriend.subscribe(val -> {
            System.out.println("BoyFriend: "+ val);
        });


        return Flux.zip(girlfriend,boyfriend);
    }
}
