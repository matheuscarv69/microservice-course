package src.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.domain.entity.Worker;
import src.domain.usecase.GetAllWorkersUsecase;
import src.infrastructure.model.WorkerModel;
import src.infrastructure.repository.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllWorkersService implements GetAllWorkersUsecase {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getWorkers() {
        log.info("Getting all workers");

        return workerRepository.findAll()
                .stream()
                .map(WorkerModel::convertToDomain)
                .collect(Collectors.toList());
    }
}
