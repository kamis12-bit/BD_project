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
@Table(name = "promoter_graphics")
public class Graphics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

//    @Column(columnDefinition = "NUMBER(1) NOT NULL")
    @Column(nullable = false)
    private Integer state;

//    @Column(columnDefinition = "VARCHAR2(1000)")
    @Column(length = 1000)
    private String reason;

//    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    @Column(length = 100, nullable = false)
    private String graphicsContent;

//    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    @Column(nullable = false)
    private Long supervisor;

    public Graphics(Graphics graphics) {
        this.id = null;
        this.state = graphics.getState();
        this.reason = graphics.getReason();
        this.graphicsContent = graphics.getGraphicsContent();
        this.supervisor = graphics.getSupervisor();
    }
}
