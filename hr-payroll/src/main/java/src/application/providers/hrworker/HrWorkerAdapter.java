package src.application.providers.hrworker;

import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import src.application.configs.exception.ExternalIntegrationException;
import src.application.configs.exception.ExternalTimeoutException;
import src.application.configs.exception.WorkerNotFoundException;
import src.domain.ports.HrWorkerIntegration;
import src.infrastructure.agents.hrworker.HrWorkerClient;
import src.infrastructure.agents.hrworker.response.WorkerResponse;

@Component
public class HrWorkerAdapter implements HrWorkerIntegration {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String MS_NAME = "HR-Worker";

    @Autowired
    private HrWorkerClient workerClient;

    @Override
    public WorkerResponse getWorkerById(Long workerId) {
        log.info("Sending request for get worker by id in Hr-Worker");

        try {
            return workerClient.getWorkerById(workerId);

        } catch (FeignException exception) {
            log.warn("Error in Hr-worker: {}", exception.getMessage());

            switch (exception.status()) {
                case 404:
                    throw new WorkerNotFoundException("Worker not found");
                case 504:
                    throw new ExternalTimeoutException(MS_NAME);
                default:
                    throw new ExternalIntegrationException(MS_NAME);
            }
        }
    }


}
