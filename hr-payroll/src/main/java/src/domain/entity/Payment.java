package src.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Payment {

    private String name;
    private BigDecimal dailyIncome;
    private Integer days;

    public BigDecimal getTotal() {
        return this.dailyIncome.multiply(new BigDecimal(days));
    }
}
