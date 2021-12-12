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
import src.domain.usecase.GetAllWorkersUsecase;
import src.domain.usecase.GetWorkerUsecase;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/workers")
public class WorkerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GetAllWorkersUsecase getAllWorkersService;

    @Autowired
    private GetWorkerUsecase getWorkerService;

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

        var worker = getWorkerService.getWorkerById(id);
        var response = new WorkerResponse(worker);

        return ResponseEntity.ok(response);
    }

}
