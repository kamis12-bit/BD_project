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
@Table(name = "promoter_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

    @Column(columnDefinition = "VARCHAR2(40) NOT NULL")
    String firstName;

    @Column(columnDefinition = "VARCHAR2(40) NOT NULL")
    String lastName;

    @Column(columnDefinition = "VARCHAR2(100)")
    String avatar;
}
