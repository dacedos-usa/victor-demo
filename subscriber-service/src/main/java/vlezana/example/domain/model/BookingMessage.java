package vlezana.example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("reservation")
public class BookingMessage implements Serializable {
    private static final long serialVersionUID = 300002228479017363L;

    private String eventId;
    private String eventType;
    private String timestamp;

    private BookingDto payload;

}

