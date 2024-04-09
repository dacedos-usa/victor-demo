package vlezana.example.http.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoResponse {

    private String id;
    private List<DtoResponseItem> items;
    private Double subtotal;
    private Double saleTax;
    private Double coupons;
    private Double totalSale;

    @Getter
    @Builder(toBuilder = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DtoResponseItem {
        private String sku;
        private String itemName;
        private Double price;
    }


}
