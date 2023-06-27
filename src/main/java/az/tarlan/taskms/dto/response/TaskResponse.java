package az.tarlan.taskms.dto.response;

import az.tarlan.taskms.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskResponse(String title,
                           String description,
                           TaskStatus status,
                           String assignee,
                           @JsonFormat(pattern = "yyyy-MM-dd")
                           LocalDateTime dueDate) {
}
