package mimuw.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promoter_event_person")
public class EventPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

//    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    @Column(nullable = false)
    private Long event;

//    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    @Column(nullable = false)
    private Long person;
}
