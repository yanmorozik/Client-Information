package com.morozik.clientinformation.service;

import com.morozik.clientinformation.dto.CreateMailDto;
import com.morozik.clientinformation.model.Mail;
import com.morozik.clientinformation.repository.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.morozik.clientinformation.mapper.MailMapper.toMail;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailRepository mailRepository;
    private final ClientService clientService;

    @Transactional
    public void save(CreateMailDto createMailDto) {
        mailRepository.save(toMail(clientService.findById(createMailDto.getClientId()), createMailDto.getValue()));
    }

    @Transactional(readOnly = true)
    public List<Mail> findByClientId(Long clientId) {
        return mailRepository.findByClientId(clientId);
    }
}
