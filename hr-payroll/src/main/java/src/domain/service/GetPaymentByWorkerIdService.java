package src.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import src.domain.entity.Payment;
import src.domain.usecase.GetPaymentUsecase;

import java.math.BigDecimal;

@Service
public class GetPaymentByWorkerIdService implements GetPaymentUsecase {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Payment getPaymentByWorkerId(Long workerId, Integer workedDays) {
        log.info("Getting Payment by the Worker: {}", workerId);

        return new Payment("Bob", BigDecimal.valueOf(200.0), workedDays);

    }


}
