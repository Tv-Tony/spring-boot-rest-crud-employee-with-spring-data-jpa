package com.tvtoner.cruddemo.service;

import com.tvtoner.cruddemo.dao.PayrollRepository;
import com.tvtoner.cruddemo.entity.Payroll;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService{

    private PayrollRepository payrollRepository;

    public PayrollServiceImpl(PayrollRepository payrollRepository){
        this.payrollRepository = payrollRepository;
    }

    @Override
    public List<Payroll> findAll() {
        return payrollRepository.findAll();
    }

    @Override
    public Payroll findById(int theId) {
        Optional<Payroll> result = payrollRepository.findById(theId);

        Payroll thePayroll = null;

        if (result.isPresent()){
            thePayroll = result.get();
        }
        else {
            throw new RuntimeException("The Payroll Id is not present: " +theId);
        }

        return thePayroll;

    }

    @Override
    @Transactional
    public Payroll save(Payroll thePayroll) {
        return payrollRepository.save(thePayroll);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        payrollRepository.deleteById(theId);
    }
}
