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
@Table(name = "promoter_description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

    @Column(columnDefinition = "NUMBER(1) NOT NULL")
    private Integer state;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String reason;

    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    private String descriptionContent;

    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    private Long supervisor;
}
