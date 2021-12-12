package src.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.application.response.WorkerResponse;
import src.domain.usecase.GetAllWorkers;
import src.domain.usecase.GetWorker;

import java.util.List;
import java.util.stream.Collectors;

@RestController // TODO change path
@RequestMapping("/v1/worker")
public class WorkerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GetAllWorkers getAllWorkersService;

    @Autowired
    private GetWorker getWorker;

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> getAllWorkers() {
        log.info("Receiving request for Get All Workers");

        var workerList = getAllWorkersService
                .getWorkers()
                .stream()
                .map(WorkerResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(workerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponse> getWorkerById(@PathVariable Long id) {
        log.info("Receiving request for Get Worker by Id");

        var worker = getWorker.getWorkerById(id);
        var response = new WorkerResponse(worker);

        return ResponseEntity.ok(response);
    }

}
