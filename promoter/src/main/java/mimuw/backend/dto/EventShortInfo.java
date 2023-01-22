package mimuw.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventShortInfo {
    private Long id;
    private String name;
    private String beginDate;
    private String endDate;
}
