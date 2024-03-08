package com.bunu.jpafetching;

import com.bunu.jpafetching.domain.CreditCard;
import com.bunu.jpafetching.domain.Customer;
import com.bunu.jpafetching.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JpaFetchingApplication implements CommandLineRunner {
@Autowired
private CustomerRepository customerRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaFetchingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer("Jack", "Bauer", "jack@acme.com");
        CreditCard c1 = new CreditCard(123,"Visa", "08/07/24");
        CreditCard c2 = new CreditCard(345,"MasterCard", "05/09/24");
        customer.addCreditCard(c1);
        customer.addCreditCard(c2);
        customerRepository.save(customer);

        System.out.println("Fetch Customer  with findById(1L):");
        Optional<Customer> custOpt = customerRepository.findById(1L);
        Customer customer2 = custOpt.get();
        System.out.println("Customer found with findById(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer2);
        System.out.println();

    }
}
