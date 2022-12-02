package com.example.productmanagement.controlller;

import com.example.productmanagement.entity.Address;
import com.example.productmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> listAddresss(@PathVariable long userId) {
        return addressService.retrieveAllAddresss(userId);
    }

    @PostMapping("/addresses")
    public void createAddress(@PathVariable Long userId,@RequestBody Address address) {
        addressService.addNewAddress(userId, address);
    }

    @GetMapping("/addresses/{addressId}")
    public Address getAddress(@PathVariable Long userId,@PathVariable Long addressId) {
        return addressService.getAddressById(userId,addressId);
    }

    @DeleteMapping("/addresses/{addressId}")
    public void deleteAddress(@PathVariable Long userId,@PathVariable Long addressId) {
        addressService.deleteAddressById(userId, addressId);
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@PathVariable  Long userId,
                           @RequestBody Address address) {
        return addressService.updateAddress(userId,address);
    }
}
