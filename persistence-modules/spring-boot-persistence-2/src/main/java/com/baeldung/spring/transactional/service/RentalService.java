package com.baeldung.spring.transactional.service;

import com.baeldung.spring.transactional.entity.Car;
import com.baeldung.spring.transactional.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

@Service
@Transactional(Transactional.TxType.SUPPORTS)
public class RentalService {

    @Autowired
    private CarRepository carRepository;

    @Transactional(rollbackOn = IllegalArgumentException.class, dontRollbackOn = EntityExistsException.class)
    public Car rent(Car car) {
        return carRepository.save(car);
    }
}
