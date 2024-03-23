package com.morozik.clientinformation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientExDto {
    private Long id;
    private String name;
    private String surname;
    private List<MailDto> mails;
    private List<PhoneDto> phones;
}
