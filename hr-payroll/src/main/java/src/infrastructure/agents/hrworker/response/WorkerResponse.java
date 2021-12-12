package src.infrastructure.agents.hrworker.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class WorkerResponse {

    private Long id;
    private String name;
    private BigDecimal dailyIncome;

}
