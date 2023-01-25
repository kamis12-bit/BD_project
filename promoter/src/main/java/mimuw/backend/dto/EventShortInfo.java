package mimuw.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventShortInfo {
    private Long id;
    private String name;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
}
