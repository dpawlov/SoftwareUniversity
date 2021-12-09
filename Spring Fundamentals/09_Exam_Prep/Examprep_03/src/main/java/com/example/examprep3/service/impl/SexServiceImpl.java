package com.example.examprep3.service.impl;

import com.example.examprep3.model.entity.Sex;
import com.example.examprep3.model.enums.SexType;
import com.example.examprep3.repository.SexRepository;
import com.example.examprep3.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SexServiceImpl implements SexService {

    private final SexRepository sexRepository;

    @Autowired
    public SexServiceImpl(SexRepository sexRepository) {
        this.sexRepository = sexRepository;
    }

    @Override
    public void initSexes() {
        if (sexRepository.count() == 0) {

            Arrays.stream(SexType.values())
                    .forEach(value -> {
                        Sex sex = new Sex();
                        sex.setSex(value);

                        this.sexRepository.save(sex);
                    });
        }
    }

    @Override
    public Sex findBySex(SexType sex) {
        return this.sexRepository.findBySex(sex).orElse(null);
    }
}
