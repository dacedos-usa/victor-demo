package vlezana.example.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @ToString
public class SaltDto implements Serializable {
    private static final long serialVersionUID = 300002228479017363L;

    private String eventId;
    private String eventType;
    private String timestamp;
    private Payload payload;

    @Getter
    @Setter
    @NoArgsConstructor
    class Payload implements Serializable{

        private String serviceCode;
        private String keyword;
        private String mdn;
        private String mobileOriginated;
        private boolean subscribed;
        private String previousStatus;
        private String status;
        private String source;
        private String changeAt;
    }

    }

