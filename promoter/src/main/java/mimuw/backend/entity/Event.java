package mimuw.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promoter_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

//    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    @Column(length = 100, nullable = false)
    private String name;

//    @Column(columnDefinition = "VARCHAR2(1000)")
    @Column(length = 1000)
    private String description;

//    @Column(columnDefinition = "DATE NOT NULL")
    @Column(nullable = false)
    private LocalDateTime beginDate;

//    @Column(columnDefinition = "DATE NOT NULL")
    @Column(nullable = false)
    private LocalDateTime endDate;

//    @Column(columnDefinition = "NUMBER(1) NOT NULL")
    @Column(nullable = false)
    private Integer archived;

    public Event(Event event) {
        this.id = null;
        this.name = event.getName();
        this.description = event.getDescription();
        this.beginDate = event.getBeginDate();
        this.endDate = event.getEndDate();
        this.archived = event.getArchived();
    }
}
