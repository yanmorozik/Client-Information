package com.morozik.clientinformation.repository;

import com.morozik.clientinformation.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByClientId(Long clientId);
}
