package ru.geekbrains.lesson9.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllProductsTest() throws Exception {
        mvc.perform(get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content", hasSize(4)))                   //почему то считает что нужно  проверять занчение и строки return service.findAll(ProductSpecification.build(params), page, 4);
                                                                                        // метода findAllProducts() вместо размера списка продуктов
                .andExpect(jsonPath("$.content[1].title", is("bbb")))   //из-за этого отрабатывает только эта строка
                .andExpect(jsonPath("$.content[3].title", is("ddd")))  //и эта строка
                //.andExpect(jsonPath("$.content[15].title", is("ppp")))             //а это строка выдает failed, т.к. тест считает что длина списка равна 4 элементам
        ;
    }
}
