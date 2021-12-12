package src.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.domain.entity.Payment;
import src.domain.ports.HrWorkerIntegration;
import src.domain.usecase.GetPaymentUsecase;

@Service
public class GetPaymentByWorkerIdService implements GetPaymentUsecase {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HrWorkerIntegration hrWorkerAdapter;

    @Override
    public Payment getPaymentByWorkerId(Long workerId, Integer workedDays) {
        log.info("Getting Payment by the Worker: {}", workerId);

        var workerResponse = hrWorkerAdapter.getWorkerById(workerId);

        return new Payment(
                workerResponse.getName(),
                workerResponse.getDailyIncome(),
                workedDays);

    }


}
