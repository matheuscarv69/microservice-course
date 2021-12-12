package src.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.domain.entity.Worker;
import src.domain.exception.WorkerNotFoundException;
import src.domain.usecase.GetWorkerUsecase;
import src.infrastructure.repository.WorkerRepository;

@Service
public class GetWorkerByIdService implements GetWorkerUsecase {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker getWorkerById(Long id) {
        log.info("Getting worker by id");

        return workerRepository
                .findById(id)
                .orElseThrow(WorkerNotFoundException::new)
                .convertToDomain();
    }
}
