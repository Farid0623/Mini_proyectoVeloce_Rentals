package mapper;

import co.edu.cue.proyectoc2.mapping.dto.ProductDto;
import co.edu.cue.proyectoc2.models.Product;

public class ProductMapper {
    public static ProductDto mapFrom(Product product){
        return new ProductDto(product.getId(), product.getType(), product.getBrand(), product.getModel(), product.getCategory(), product.getPrice(), product.getAvailable(),product.getName());
    }
    public static Product mapFromDto(ProductDto productDto){
        return Product.builder()
                .id(productDto.id())
                .type(productDto.type())
                .brand(productDto.brand())
                .model(productDto.model())
                .category(productDto.category())
                .name(productDto.name())
                .price(productDto.price())
                .available(productDto.available())
                .build();
    }
}
