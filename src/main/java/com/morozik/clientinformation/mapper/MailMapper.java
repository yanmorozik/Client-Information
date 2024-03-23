package com.morozik.clientinformation.mapper;

import com.morozik.clientinformation.dto.ContactDto;
import com.morozik.clientinformation.dto.MailDto;
import com.morozik.clientinformation.model.Client;
import com.morozik.clientinformation.model.Mail;

public class MailMapper {
    public static Mail toMail(Client client, String value) {
        return Mail.builder()
                .client(client)
                .value(value)
                .build();
    }

    public static MailDto toMailDto(Mail mail) {
        return MailDto.builder()
                .value(mail.getValue())
                .build();
    }

    public static ContactDto toContactDto(Mail mail) {
        return ContactDto.builder()
                .value(mail.getValue())
                .build();
    }
}
