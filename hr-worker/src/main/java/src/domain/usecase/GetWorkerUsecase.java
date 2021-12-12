package src.domain.usecase;

import src.domain.entity.Worker;

public interface GetWorkerUsecase {

    Worker getWorkerById(Long id);

}
