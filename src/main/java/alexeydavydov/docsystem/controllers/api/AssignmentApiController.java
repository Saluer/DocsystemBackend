package alexeydavydov.docsystem.controllers.api;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.services.api.AssignmentAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/assignments")
public class AssignmentApiController {

    private final Logger log = LoggerFactory.getLogger(AssignmentApiController.class);
    private final AssignmentAPIService assignmentAPIService;

    AssignmentApiController(AssignmentAPIService assignmentAPIService) {
        this.assignmentAPIService = assignmentAPIService;
    }

    @GetMapping("")
    public List<Assignment> allAssignments() {
        return assignmentAPIService.findAll();
    }

    @GetMapping("/to/me")
    public List<Assignment> allAssignmentsToMe() {
        return assignmentAPIService.findAssignmentsToMe();
    }

    @GetMapping("/from/me")
    public List<Assignment> allAssignmentsFromMe() {
        return assignmentAPIService.findAssignmentsFromMe();
    }

    @PostMapping("/create")
    public Assignment createAssignment(@RequestBody CreateAssignmentRequest request) {
        log.warn("Получен запрос на создание нового поручения: " + request);

        return assignmentAPIService.createAssignment(request);
    }

}
