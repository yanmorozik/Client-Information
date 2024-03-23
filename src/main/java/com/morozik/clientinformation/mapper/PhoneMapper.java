package com.morozik.clientinformation.mapper;

import com.morozik.clientinformation.dto.ContactDto;
import com.morozik.clientinformation.dto.PhoneDto;
import com.morozik.clientinformation.model.Client;
import com.morozik.clientinformation.model.Phone;

public class PhoneMapper {
    public static Phone toPhone(Client client, String value) {
        return Phone.builder()
                .client(client)
                .value(value)
                .build();
    }

    public static PhoneDto toPhoneDto(Phone phone) {
        return PhoneDto.builder()
                .value(phone.getValue())
                .build();

    }

    public static ContactDto toContactDto(Phone phone) {
        return ContactDto.builder()
                .value(phone.getValue())
                .build();
    }
}
