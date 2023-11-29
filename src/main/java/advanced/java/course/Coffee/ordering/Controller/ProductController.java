package advanced.java.course.Coffee.ordering.Controller;

import advanced.java.course.Coffee.ordering.Controller.dto.ProductDto;
import advanced.java.course.Coffee.ordering.Domain.Product;
import advanced.java.course.Coffee.ordering.repository.CustomProductRepository;
import advanced.java.course.Coffee.ordering.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE;


@Tag(name = "Product")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final CustomProductRepository customProductRepository;

    @Operation(summary = "Retrieve list of products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of products retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid url params supplied")
    })
    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false, defaultValue = "100") Integer limit,
                                  @RequestParam(required = false, defaultValue = "desc") String sort) {

        if ( !sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc") ) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "name") : Sort.by(Sort.Direction.DESC, "name");

        Page<Product> products = productRepository.findAll(PageRequest.of(0, limit, sortParam ));

        return products.toList();

    }



    @GetMapping(value ="/products/{id}", produces = APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable("id") Integer id) {

        return productRepository.findById(id).get();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody Product product) {
        return ProductDto.fromProduct(customProductRepository.createProduct(product));
    }
}
