package com.green.test1pf.serviceImpl;

import com.green.test1pf.model.Rate;
import com.green.test1pf.model.RateRepository;
import com.green.test1pf.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RateServiceImpl implements RateService {

    private final RateRepository repository;

    @Autowired
    private RateServiceImpl(RateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Rate rate) {
        repository.save(rate);
    }

    @Override
    public List<Rate> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
