package com.wolfhack.diploma.repository;
import com.wolfhack.diploma.models.products.Product;
import com.wolfhack.diploma.models.products.Ssd;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.net.ssl.SSLContext;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
public interface SsdRepository extends MongoRepository<Ssd, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Ssd findByNameIsLikeAndModelIsLike(String name, String model);

}
