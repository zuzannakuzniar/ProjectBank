package util;

import datamodel.Customer;
import dto.CustomerDTO;

public class CustomerUtil {

    private Customer mapDTOToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setUserType(UserType.CUSTOMER);

        return customer;
    }

    private CustomerDTO mapCustomerToDTO(Customer customer) {
       return CustomerDTO.builder()
               .address(customer.getAddress())
               .email(customer.getEmail())
               .firstName(customer.getFirstName())
               .lastName(customer.getLastName())
               .phone(customer.getPhone())
               .userType(UserType.CUSTOMER).build();

    }
}
