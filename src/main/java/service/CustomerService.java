package service;

import datamodel.Customer;
import dto.CustomerDTO;
import util.CustomerUtil;

import javax.inject.Inject;


public class CustomerService {

    @Inject
    public CustomerUtil customerUtil;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return null;
    }


}
