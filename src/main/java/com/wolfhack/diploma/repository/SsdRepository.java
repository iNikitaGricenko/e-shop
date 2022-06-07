package com.wolfhack.diploma.repository;
import com.wolfhack.diploma.models.products.Ssd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.net.ssl.SSLContext;

@Repository
public interface SsdRepository extends MongoRepository<Ssd, String> {

    boolean existsProductByNameAndModel(String name, String model);
    SSLContext findByNameIsLikeAndModelIsLike(String name, String model);

}
