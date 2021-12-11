package src.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import src.domain.entity.Worker;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "tb_worker")
public class WorkerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal dailyIncome;

    public Worker convertToDomain() {
        return new Worker(
                this.id,
                this.name,
                this.dailyIncome
        );
    }
}
