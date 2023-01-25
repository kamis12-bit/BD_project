package mimuw.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mimuw.backend.entity.Person;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainViewEvent {
    private Long id;
    private String name;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Integer isPublished;
    private List<Person> persons;
}
