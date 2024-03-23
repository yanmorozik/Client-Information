package com.morozik.clientinformation.service;

import com.morozik.clientinformation.dto.ClientDto;
import com.morozik.clientinformation.dto.ClientExDto;
import com.morozik.clientinformation.dto.ContactDto;
import com.morozik.clientinformation.dto.CreateClientDto;
import com.morozik.clientinformation.exception.NotFoundException;
import com.morozik.clientinformation.mapper.ClientMapper;
import com.morozik.clientinformation.mapper.MailMapper;
import com.morozik.clientinformation.mapper.PhoneMapper;
import com.morozik.clientinformation.model.Client;
import com.morozik.clientinformation.model.enums.ContactType;
import com.morozik.clientinformation.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.morozik.clientinformation.mapper.ClientMapper.toClient;
import static com.morozik.clientinformation.mapper.ClientMapper.toClientExDto;
import static com.morozik.clientinformation.model.enums.ExceptionCode.CLIENT_NOT_FOUND;
import static java.util.Collections.emptyList;
import static java.util.stream.Stream.concat;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private MailService mailService;
    private PhoneService phoneService;

    @Autowired
    public void setMailService(@Lazy MailService mailService) {
        this.mailService = mailService;
    }

    @Autowired
    public void setPhoneService(@Lazy PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @Transactional
    public void save(CreateClientDto dto) {
        clientRepository.save(toClient(dto));
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client don't found", CLIENT_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable).map(ClientMapper::toClientDto);
    }

    @Transactional(readOnly = true)
    public ClientExDto getClientDetails(Long id) {
        return toClientExDto(
                findById(id),
                mailService.findByClientId(id).stream().map(MailMapper::toMailDto).toList(),
                phoneService.findByClientId(id).stream().map(PhoneMapper::toPhoneDto).toList()
        );
    }

    @Transactional(readOnly = true)
    public List<ContactDto> getClientContact(Long id, ContactType contactType) {
        switch (contactType) {
            case MAIL -> {
                return mailService.findByClientId(id).stream().map(MailMapper::toContactDto).toList();
            }
            case PHONE -> {
                return phoneService.findByClientId(id).stream().map(PhoneMapper::toContactDto).toList();
            }
            case ALL -> {
                return concat(
                        mailService.findByClientId(id).stream().map(MailMapper::toContactDto),
                        phoneService.findByClientId(id).stream().map(PhoneMapper::toContactDto)
                ).toList();
            }
            default -> {
                return emptyList();
            }
        }
    }
}
