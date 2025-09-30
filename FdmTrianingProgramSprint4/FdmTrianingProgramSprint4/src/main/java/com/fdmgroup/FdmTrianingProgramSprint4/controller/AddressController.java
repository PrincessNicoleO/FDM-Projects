package com.fdmgroup.FdmTrianingProgramSprint4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fdmgroup.FdmTrianingProgramSprint4.model.Address;
import com.fdmgroup.FdmTrianingProgramSprint4.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Api(value = "Address Management")
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "Create a new address", response = Address.class)
    @PostMapping
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get address by ID", response = Address.class)
    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long addressId) {
        Address address = addressService.getAddressById(addressId);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @ApiOperation(value = "Update an existing address", response = Address.class)
    @PutMapping("/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long addressId, @Valid @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(addressId, address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an address")
    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
