package com.vinicius.techtalk.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vinicius.techtalk.customers.entity.Address;

/**
 * ONLY FOR COMPARISION
 * 
 * @author vinicius
 *
 */

@Repository
public interface AddressJpaSpecificationRepository
        extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

}
