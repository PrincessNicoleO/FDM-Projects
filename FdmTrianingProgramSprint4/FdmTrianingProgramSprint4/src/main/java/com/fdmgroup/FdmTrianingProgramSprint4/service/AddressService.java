package com.fdmgroup.FdmTrianingProgramSprint4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fdmgroup.FdmTrianingProgramSprint4.model.Address;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.AddressRepository;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Create a new address
    @Transactional
    public Address createAddress(Address address) {
        return addressRepository.save(address); // Save the address in the database
    }

    // Get an address by ID
    public Address getAddressById(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        return address.orElseThrow(() -> new RuntimeException("Address not found with ID: " + addressId)); // Handle not found case
    }

    // Update an existing address
    @Transactional
    public Address updateAddress(Long addressId, Address updatedAddress) {
        Optional<Address> existingAddress = addressRepository.findById(addressId);
        
        if(existingAddress.isPresent()) {
            Address address = existingAddress.get();
            // Update fields here
            address.setStreetNumber(updatedAddress.getStreetNumber());
            address.setCity(updatedAddress.getCity());
            address.setProvince(updatedAddress.getProvince());
            address.setPostalCode(updatedAddress.getPostalCode());

            return addressRepository.save(address); // Save the updated address
        } else {
            throw new RuntimeException("Address not found with ID: " + addressId); // Handle not found case
        }
    }

    // Delete an address by ID
    @Transactional
    public void deleteAddress(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        
        if(address.isPresent()) {
            addressRepository.deleteById(addressId); // Delete the address from the database
        } else {
            throw new RuntimeException("Address not found with ID: " + addressId); // Handle not found case
        }
    }
}
