package az.tarlan.taskms.service.impl;

import az.tarlan.taskms.dto.request.TaskCreationRequest;
import az.tarlan.taskms.dto.response.TaskResponse;
import az.tarlan.taskms.mapper.TaskMapper;
import az.tarlan.taskms.model.Task;
import az.tarlan.taskms.repository.TaskRepository;
import az.tarlan.taskms.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(TaskCreationRequest creationRequest) {
        log.info("Task creation started");
        LocalDateTime taskDueDate = LocalDateTime.now().plusDays(7L);
        Task task = Task.builder()
                .title(creationRequest.title())
                .description(creationRequest.desc())
                .assignee(creationRequest.assignee())
                .dueDate(taskDueDate)
                .status(creationRequest.status())
                .build();
        taskRepository.save(task);
        log.info("Task saved, success response created!");
        return TaskMapper.INSTANCE.taskEntityToDto(task);
    }
}
