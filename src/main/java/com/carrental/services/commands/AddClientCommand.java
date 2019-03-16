package com.carrental.services.commands;

import com.carrental.exceptions.CreateOrderException;
import com.carrental.model.ClientRepository;
import com.carrental.model.entities.Client;
import com.carrental.model.entities.Order;

import java.util.Optional;

public class AddClientCommand implements Command {

    private Order order;
    private ClientRepository clientRepository;
    private String clientName;

    public AddClientCommand(Order order, ClientRepository clientRepository, String clientName) {
        this.order = order;
        this.clientRepository = clientRepository;
        this.clientName = clientName;
    }

    @Override
    public void execute() {
        Optional<Client> clientOptional = clientRepository.findByName(clientName);
        order.setClient(clientOptional.orElseThrow(() -> new CreateOrderException("Invalid client name")));
    }
}
