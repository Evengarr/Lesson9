package ru.geekbrains.lesson9.repositoryesTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.lesson9.entities.Product;
import ru.geekbrains.lesson9.repositories.ProductRepository;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void initDbTest() {
        List<Product> productList = productRepository.findAll();
        Assertions.assertEquals(16, productList.size());
        System.err.println(productList.size()); // с *.err.* сделал чтобы было видно значение в стена отчета
    }
}

/*столкнулся с тем что долго не мог заставить код, постоянно вылетало V1__init_productDataBaseTest.sql failed,
* в поисках решения оствил в .sql только продукты и таблицу из simple_products переименовал в products и все заработало,
* хз по чему так получилось
* Если запустить тест с .sql в папке migration код не запускается*/