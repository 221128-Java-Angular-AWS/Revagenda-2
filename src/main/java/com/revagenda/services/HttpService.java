package com.revagenda.services;

import com.revagenda.models.Pokexample;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service(value = "httpService")
public class HttpService {
    RestTemplate remote = new RestTemplate();
    String baseUrl = "https://pokeapi.co/api/v2";

    public Pokexample testPokeApi() {
        Pokexample ditto = remote.getForObject(baseUrl + "/pokemon/ditto", Pokexample.class);
        return ditto;
    }

}
