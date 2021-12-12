package src.domain.ports;

import src.infrastructure.agents.hrworker.response.WorkerResponse;

public interface HrWorkerIntegration {

    WorkerResponse getWorkerById(Long workerId);

}
