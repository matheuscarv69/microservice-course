package src.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import src.domain.entity.Payment;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class PaymentResponse {

    private String name;
    private BigDecimal dailyIncome;
    private Integer days;
    private BigDecimal total;

    public PaymentResponse(Payment payment) {
        this.name = payment.getName();
        this.dailyIncome = payment.getDailyIncome();
        this.days = payment.getDays();
        this.total = payment.getTotal();
    }

}
