package src.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import src.infrastructure.model.WorkerModel;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Worker {

    private Long id;
    private String name;
    private BigDecimal dailyIncome;

    public WorkerModel convertToModel() {
        return new WorkerModel(
                this.id,
                this.name,
                this.dailyIncome
        );
    }

}
