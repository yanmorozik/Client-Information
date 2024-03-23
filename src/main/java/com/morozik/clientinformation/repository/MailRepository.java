package com.morozik.clientinformation.repository;

import com.morozik.clientinformation.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findByClientId(Long clientId);
}
