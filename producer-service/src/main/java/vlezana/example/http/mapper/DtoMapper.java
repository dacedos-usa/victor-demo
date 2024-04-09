package vlezana.example.http.mapper;

import vlezana.example.domain.model.TemplateDomain;
import vlezana.example.http.model.DtoRequestItem;
import vlezana.example.http.model.DtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface DtoMapper {

    List<TemplateDomain.Item> toDomain(List<DtoRequestItem> requestItem);

    @Mapping(source = "coupons", target = "coupons", qualifiedByName = "couponsAmount")
    DtoResponse fromDomain(TemplateDomain domain);

    @Named("couponsAmount")
    static double couponsAmount(List<TemplateDomain.Coupon> coupons) {
        return Optional.ofNullable(coupons)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .mapToDouble(TemplateDomain.Coupon::getDiscountPrice)
                .sum();
    }
}