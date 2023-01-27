package mimuw.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mimuw.backend.entity.Person;
import mimuw.backend.entity.PromoMessage;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DetailViewEvent {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Integer archived;
    private Integer isPublished;
    private List<Person> persons;
    private List<PromoMessage> promoMessages;
}
