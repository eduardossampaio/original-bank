package com.esampaio.orig.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class RestAPi {
    @Autowired
    CustomerRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ping")
    public PingResponse ping() {
        PingResponse pingResponse = new PingResponse();
        pingResponse.message = "Ping";

        return pingResponse;
    }
    @GetMapping("/quote")
    public Quote getQuote() {
    return (Quote)    restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

    @PostMapping("/save")
    public PostResponse save(PostRequest request){
        System.out.println(request);
        Customer customer = new Customer(request.nome, " da silva");

        repository.save(customer);
        return new PostResponse(true);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
//        return Collections.emptyList();
        List<Customer> result =
                StreamSupport.stream(repository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return result;
    }

}
