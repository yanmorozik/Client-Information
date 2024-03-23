package com.morozik.clientinformation.repository;

import com.morozik.clientinformation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
