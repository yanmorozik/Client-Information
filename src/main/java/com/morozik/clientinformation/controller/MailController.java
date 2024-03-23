package com.morozik.clientinformation.controller;

import com.morozik.clientinformation.dto.CreateMailDto;
import com.morozik.clientinformation.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mails")
public class MailController {

    private final MailService mailService;

    @PostMapping
    public void save(@RequestBody CreateMailDto createMailDto) {
        mailService.save(createMailDto);
    }
}
