package src.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.infrastructure.model.WorkerModel;

public interface WorkerRepository extends JpaRepository<WorkerModel, Long> {
}
