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
@Table(name = "promoter_promo_message")
public class PromoMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    private String name;

    @Column(columnDefinition = "DATE NOT NULL")
    private LocalDateTime publicationDate;

    @Column(columnDefinition = "NUMBER(1) NOT NULL")
    private Integer published;

    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    private Long event;

    @Column(columnDefinition = "NUMBER(10)")
    private Long graphics;

    @Column(columnDefinition = "NUMBER(10)")
    private Long description;

    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    private Long hasType;
}
