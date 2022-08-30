package com.natanribeiro.total.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.total.models.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Long>{

}
