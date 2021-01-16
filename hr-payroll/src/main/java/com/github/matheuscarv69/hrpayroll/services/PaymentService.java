package com.github.matheuscarv69.hrpayroll.services;

import com.github.matheuscarv69.hrpayroll.entities.Payment;
import com.github.matheuscarv69.hrpayroll.entities.Worker;
import com.github.matheuscarv69.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
       Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
