package src.domain.usecase;

import src.domain.entity.Payment;

public interface GetPaymentUsecase {

    Payment getPaymentByWorkerId(Long workerId, Integer workedDays);

}
