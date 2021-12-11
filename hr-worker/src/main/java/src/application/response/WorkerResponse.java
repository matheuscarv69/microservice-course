package src.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import src.domain.entity.Worker;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class WorkerResponse {

    private Long id;
    private String name;
    private BigDecimal dailyIncome;

    public WorkerResponse(Worker worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
    }

}
