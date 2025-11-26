package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileManager {

    @Autowired
    private MobileRepository repository;

    public List<Mobile> getAllMobile() {
        return repository.findAll();
    }

    public Mobile getMobileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void saveMobile(Mobile mobile) {
        repository.save(mobile);
    }

    public void deleteMobile(Long id) {
        repository.deleteById(id);
    }

    public Boolean exists(Long id) {
        return repository.existsById(id);
    }
}
