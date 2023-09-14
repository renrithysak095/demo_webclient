package com.example.learn_webclient.service.implementation;
import com.example.learn_webclient.model.AllInstance;
import com.example.learn_webclient.model.Boyfriend;
import com.example.learn_webclient.model.Girlfriend;
import com.example.learn_webclient.model.ReturnType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class WebClientServiceImpl {


    private static final String baseUrl = "http://localhost:2025/";
    private static final String baseUrlBoy = "http://localhost:2024/";
    private final WebClient webClient;
    private final WebClient webClientBoy;


    public WebClientServiceImpl(WebClient.Builder webClient, WebClient.Builder webClientBoy) {
        this.webClient = webClient
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer ")
                .build();
        this.webClientBoy = webClientBoy
                .baseUrl(baseUrlBoy)
                .defaultHeader("Authorization", "Bearer ")
                .build();;
    }

    public void myWebClient(){

        webClient.get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToMono(String.class).subscribe(data -> {
                    System.out.println("Data: "+ data);
                    System.out.println("Data: "+ data.getClass());
                });

        webClient
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToMono(List.class).block();


        ReturnType girl = webClient
                .get()
                .uri("api/v1/girlfriend/e67a7a74-cb90-4576-9497-44c85760fd9f")
                .retrieve()
                .bodyToMono(ReturnType.class)
                .block();

            webClient
                .get()
                .uri("api/v1/girlfriend/e67a7a74-cb90-4576-9497-44c85760fd9f")
                .retrieve()
                .bodyToMono(ReturnType.class)
                .subscribe(
                        next ->{
                            System.out.println("onNext: "+ next);
                        },
                        error ->{
                            System.out.println("My error: " + error);
                        },
                        () -> {
                            System.out.println("Done");
                        }
                );

        webClient
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(ReturnType.class)
                .delayElements(Duration.ofSeconds(3))
                .subscribe(
                        next -> {
                            System.out.println("onNextWithInterval: " + next);
                            System.out.println("Type: "+ next.getClass());
                        },
                        error ->{
                            System.out.println("My error: " + error);
                        },
                        () -> {
                            System.out.println("Done");
                        }
                );


        System.out.println("Girl: " + girl);
        System.out.println("Girl: " + girl.getClass());


        webClient.get()
                .uri("api/v1/girlfriend/my-string")
                .retrieve()
                .bodyToMono(String.class).subscribe(data -> {

                });

    }

    public AllInstance returnAll() {

        List<Girlfriend> girlfriend =
                webClient
                .get()
                .uri("/api/v1/girlfriend")
                .retrieve()
                .bodyToFlux(Girlfriend.class).buffer().blockLast();

        System.out.println("checking: " + girlfriend);

        List<Boyfriend> boyfriend = webClientBoy
                .get()
                .uri("/api/v1/boyfriend")
                .retrieve()
                .bodyToFlux(Boyfriend.class).buffer().blockLast();

        return new AllInstance(girlfriend,boyfriend);
    }

    public String returnMonoString() {
        return webClient
                .get()
                .uri("api/v1/girlfriend")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
