package com.morozik.clientinformation.service;

import com.morozik.clientinformation.dto.CreatePhoneDto;
import com.morozik.clientinformation.model.Phone;
import com.morozik.clientinformation.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.morozik.clientinformation.mapper.PhoneMapper.toPhone;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final ClientService clientService;

    @Transactional
    public void save(CreatePhoneDto createPhoneDto) {
        phoneRepository.save(toPhone(clientService.findById(createPhoneDto.getClientId()), createPhoneDto.getValue()));
    }

    @Transactional(readOnly = true)
    public List<Phone> findByClientId(Long clientId) {
        return phoneRepository.findByClientId(clientId);
    }
}
