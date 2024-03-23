package com.morozik.clientinformation.controller;

import com.morozik.clientinformation.dto.ClientDto;
import com.morozik.clientinformation.dto.ClientExDto;
import com.morozik.clientinformation.dto.ContactDto;
import com.morozik.clientinformation.dto.CreateClientDto;
import com.morozik.clientinformation.model.enums.ContactType;
import com.morozik.clientinformation.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public void save(@RequestBody CreateClientDto createClientDto) {
        clientService.save(createClientDto);
    }

    @GetMapping
    public Page<ClientDto> findAll(Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ClientExDto getClientDetails(@PathVariable Long id) {
        return clientService.getClientDetails(id);
    }

    @GetMapping("/{id}/contacts")
    public List<ContactDto> getClientContact(@PathVariable Long id,
                                             @RequestParam(required = false, defaultValue = "ALL") ContactType type) {
        return clientService.getClientContact(id, type);
    }
}
