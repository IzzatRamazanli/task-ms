package az.tarlan.taskms.service;

import az.tarlan.taskms.dto.request.TaskCreationRequest;
import az.tarlan.taskms.dto.response.TaskResponse;

public interface TaskService {
    TaskResponse createTask(TaskCreationRequest creationRequest);
}
