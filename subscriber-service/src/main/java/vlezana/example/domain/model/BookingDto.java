package vlezana.example.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookingDto implements Serializable {
    private static final long serialVersionUID = 300002228479017363L;

    private LocalDateTime created;
    private String property;
    private String phoneNumber;
    private String customer;
    private String startDate;
    private String endDate;

}