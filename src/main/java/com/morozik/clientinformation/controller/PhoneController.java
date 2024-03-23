package com.morozik.clientinformation.controller;

import com.morozik.clientinformation.dto.CreatePhoneDto;
import com.morozik.clientinformation.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping
    public void save(@RequestBody CreatePhoneDto createPhoneDto) {
        phoneService.save(createPhoneDto);
    }
}
