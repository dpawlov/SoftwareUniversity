package com.example.examprep3.service;


import com.example.examprep3.model.entity.Sex;
import com.example.examprep3.model.enums.SexType;

public interface SexService {
    void initSexes();

    Sex findBySex(SexType sex);
}
