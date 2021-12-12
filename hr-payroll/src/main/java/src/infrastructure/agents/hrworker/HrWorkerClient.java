package src.infrastructure.agents.hrworker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import src.infrastructure.agents.hrworker.response.WorkerResponse;

@FeignClient(name = "hr-worker", url = "${hr.worker.host}")
public interface HrWorkerClient {

    @GetMapping("/v1/workers/{workerId}")
    WorkerResponse getWorkerById(@PathVariable Long workerId);

}
