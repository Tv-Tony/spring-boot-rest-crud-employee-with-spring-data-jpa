package com.tvtoner.cruddemo.rest;

import com.tvtoner.cruddemo.entity.Employee;
import com.tvtoner.cruddemo.entity.Payroll;
import com.tvtoner.cruddemo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Define base URL mapping for this controller
public class PayrollRestController {

    private PayrollService payrollService;

    @Autowired
    public PayrollRestController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping("/payrolls")
    public List<Payroll> allPayrolls(){
        return payrollService.findAll();
    }

    @GetMapping("payrolls/{payrollId}")
    public Payroll getPayrollById(@PathVariable int payrollId){
        return payrollService.findById(payrollId);
    }

    @PutMapping("/payrolls")
    public Payroll addPayroll(Payroll thePayroll){
        thePayroll.setPayrollId(0);

        Payroll dbPayroll = payrollService.save(thePayroll);

        return dbPayroll;
    }

    @PostMapping("payrolls")
    public Payroll updatePayroll(Payroll thePayroll){
        Payroll dbPayroll = payrollService.save(thePayroll);

        return dbPayroll;
    }

    @DeleteMapping("payrolls")
    public String deletePayrollById(int payrollId){
        Payroll tempPayroll = payrollService.findById(payrollId);

        if (tempPayroll == null){
            throw new RuntimeException(("Employee id not found - " +payrollId));
        }

        payrollService.deleteById(payrollId);

        return "Deleted payroll id - " +payrollId;
    }
}

