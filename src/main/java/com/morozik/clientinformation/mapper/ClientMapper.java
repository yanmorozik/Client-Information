package com.morozik.clientinformation.mapper;

import com.morozik.clientinformation.dto.ClientDto;
import com.morozik.clientinformation.dto.ClientExDto;
import com.morozik.clientinformation.dto.CreateClientDto;
import com.morozik.clientinformation.dto.MailDto;
import com.morozik.clientinformation.dto.PhoneDto;
import com.morozik.clientinformation.model.Client;

import java.util.List;

public class ClientMapper {
    public static Client toClient(CreateClientDto createClientDto) {
        return Client.builder()
                .name(createClientDto.getName())
                .surname(createClientDto.getSurname())
                .build();
    }

    public static ClientDto toClientDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .build();
    }

    public static ClientExDto toClientExDto(Client client, List<MailDto> mails, List<PhoneDto> phones) {
        return ClientExDto.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .mails(mails)
                .phones(phones)
                .build();
    }
}
