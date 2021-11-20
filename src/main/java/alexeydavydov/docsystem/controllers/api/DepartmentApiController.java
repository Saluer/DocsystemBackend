package alexeydavydov.docsystem.controllers.api;

import alexeydavydov.docsystem.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/departments")
public class DepartmentApiController {
    private final DepartmentRepository departmentRepository;

    DepartmentApiController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

}
