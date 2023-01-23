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
@Table(name = "promoter_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    private String name;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String description;

    @Column(columnDefinition = "DATE NOT NULL")
    private String beginDate;

    @Column(columnDefinition = "DATE NOT NULL")
    private String endDate;

    @Column(columnDefinition = "NUMBER(1) NOT NULL")
    private Integer archived;
}
