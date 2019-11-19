package com.vinicius.techtalk.customers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.techtalk.customers.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientRest {
    
    private final ClientService clientService;
    
    public ClientRest(final ClientService clientService) {
        this.clientService = clientService;
    }

}
