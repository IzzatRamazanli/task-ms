package az.tarlan.taskms.controller;

import az.tarlan.taskms.dto.request.TaskCreationRequest;
import az.tarlan.taskms.dto.request.TaskUpdateRequest;
import az.tarlan.taskms.dto.response.TaskResponse;
import az.tarlan.taskms.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        log.info("Find all tasks request accepted");
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/search/assignee")
    public ResponseEntity<List<TaskResponse>> getTaskByAssignee(@RequestParam String assignee) {
        log.info("Task search with assignee accepted");
        return ResponseEntity.ok(taskService.searchOnAssignee(assignee));
    }

    @PostMapping("/new")
    public ResponseEntity<TaskResponse> createNewTask(@RequestBody TaskCreationRequest request) {
        log.info("Task creation request accepted");
        return ResponseEntity.ok(taskService.createTask(request));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id, @RequestBody TaskUpdateRequest request
    ) {
        log.info("Task update request accepted");
        return ResponseEntity.accepted().body(taskService.updateTask(id, request));
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        log.info("Task deletion request accepted");
        taskService.deleteTask(id);
    }
}
