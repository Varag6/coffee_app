package advanced.java.course.Coffee.ordering.Controller.dto;

import advanced.java.course.Coffee.ordering.Domain.Category;
import advanced.java.course.Coffee.ordering.Domain.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

        private Integer product_id;
        private String name;
        private Integer price;
        //private byte[] image;
        private CategoryDto category_id;

        public static ProductDto fromProduct(Product product) {
            return new ProductDto(
                    product.getProduct_id(),
                    product.getName(),
                    product.getPrice(),
                    //product.getImage(),
                    CategoryDto.fromCategory(product.getCategory())
            );
        }

}
