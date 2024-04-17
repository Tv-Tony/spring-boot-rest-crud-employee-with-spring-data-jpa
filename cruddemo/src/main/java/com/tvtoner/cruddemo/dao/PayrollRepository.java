package com.tvtoner.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tvtoner.cruddemo.entity.Payroll;
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {


}
