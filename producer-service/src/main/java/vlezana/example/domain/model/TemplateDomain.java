package vlezana.example.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder(toBuilder = true)
public class TemplateDomain {

    private String id;
    private LocalDateTime created;

    private List<Item> items;
    private List<Coupon> coupons;

    @Getter
    @Builder
    public static class Item {
        private String sku;
        private String itemName;
        private double price;
    }

    @Getter
    @Builder
    public static class Coupon {
        private String couponName;
        private String appliedSku;
        private double discountPrice;
    }
}
