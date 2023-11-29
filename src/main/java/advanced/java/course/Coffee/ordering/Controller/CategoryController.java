package advanced.java.course.Coffee.ordering.Controller;

import advanced.java.course.Coffee.ordering.Controller.dto.CategoryDto;
import advanced.java.course.Coffee.ordering.Domain.Category;
import advanced.java.course.Coffee.ordering.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> CategoryDto.fromCategory(category))
                .toList();
    }

    @GetMapping(value = "/{category_id}")
    public Category getCategory(@PathVariable("category_id") Integer category_id) {
        return categoryRepository.findById(category_id).get();
    }


}
