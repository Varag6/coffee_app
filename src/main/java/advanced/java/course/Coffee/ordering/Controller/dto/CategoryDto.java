package advanced.java.course.Coffee.ordering.Controller.dto;

import advanced.java.course.Coffee.ordering.Domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

            private Integer category_id;
            private String name;

            public static CategoryDto fromCategory(Category category) {
                return new CategoryDto(
                        category.getCategory_id(),
                        category.getName()
                );
            }
}
