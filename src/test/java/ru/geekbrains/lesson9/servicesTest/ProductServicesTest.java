package ru.geekbrains.lesson9.servicesTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.lesson9.dtos.ProductDto;
import ru.geekbrains.lesson9.entities.Product;
import ru.geekbrains.lesson9.repositories.ProductRepository;
import ru.geekbrains.lesson9.services.ProductService;

import java.util.Optional;

@SpringBootTest(classes = ProductService.class)
public class ProductServicesTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        Product testProduct = new Product();
        testProduct.setTitle("zzz");
        testProduct.setCost(500.00);
        testProduct.setId(10L);

        Mockito
                .doReturn(Optional.of(testProduct))
                .when(productRepository)
                .findById(10L);

        Product product = productService.findProductById(10L).get();
        Mockito.verify(productRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(10L));
        Assertions.assertEquals("zzz", product.getTitle());
        System.err.println(product.getTitle());
    }
}
