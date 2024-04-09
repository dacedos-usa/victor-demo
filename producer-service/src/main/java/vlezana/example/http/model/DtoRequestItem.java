package vlezana.example.http.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DtoRequestItem {
    private final @NotBlank String itemName;
    private final int sku;
    private final boolean isTaxable;
    private final boolean ownBrand;
    private final double price;
}
