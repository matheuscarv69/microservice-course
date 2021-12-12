package src.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.application.response.PaymentResponse;
import src.domain.usecase.GetPaymentUsecase;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GetPaymentUsecase getPaymentService;

    @GetMapping("/{workerId}/days/{workedDays}")
    public ResponseEntity<PaymentResponse> getPaymentByWorkerIdAndWorkedDays(
            @PathVariable Long workerId,
            @PathVariable Integer workedDays
    ) {
        log.info("Receiving request for get Payment of Worker: {}", workerId);
        var payment = getPaymentService.getPaymentByWorkerId(workerId, workedDays);

        return ResponseEntity.ok(new PaymentResponse(payment));

    }

}
