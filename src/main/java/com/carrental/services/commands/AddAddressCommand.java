package com.carrental.services.commands;

import com.carrental.exceptions.CreateOrderException;
import com.carrental.model.AddressRepository;
import com.carrental.model.entities.Address;
import com.carrental.model.entities.Order;

import java.util.Optional;

public class AddAddressCommand implements Command {

    private Order order;
    private AddressRepository addressRepository;
    private long addressId;

    public AddAddressCommand(Order order, AddressRepository addressRepository, long addressId) {
        this.order = order;
        this.addressRepository = addressRepository;
        this.addressId = addressId;
    }

    @Override
    public void execute() {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        order.setAddress(addressOptional.orElseThrow(() -> new CreateOrderException("Invalid address id")));
    }
}
