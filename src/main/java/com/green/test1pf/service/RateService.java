package com.green.test1pf.service;

import com.green.test1pf.model.Rate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateService {

    void save(Rate rate);

    List<Rate> findAll();

    Long count();

}
