package alexeydavydov.docsystem.controllers.api;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.requests.UpdateAssignmentRequest;
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


    //TODO подумать над добавление find в начале
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
    public Assignment createAssignment(CreateAssignmentRequest request) {
        log.info("Получен запрос на создание нового поручения: " + request);

        return assignmentAPIService.createAssignment(request);
    }

    @PostMapping("/update/{id}")
    public Assignment updateAssignment(@PathVariable("id") int id, UpdateAssignmentRequest request) {
        log.info("Получен запрос на редактирование поручения по следующему id: " + id + ". Данные запроса: " + request);

        return assignmentAPIService.updateAssignment(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable("id") int id) {
        log.info("Получен запрос на удаление поручения по следующему id: " + id);

        assignmentAPIService.deleteAssignment(id);
    }

    @GetMapping("/{id}")
    public Assignment findAssignment(@PathVariable("id") int id) {
        log.info("Получен запрос на получение поручения по следующему id: " + id);

        return assignmentAPIService.findAssignmentById(id);
    }

}
