package com.be_casemodule5.repo;

import com.be_casemodule5.model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IImageRepo extends CrudRepository<Image,Integer> {
    @Query(nativeQuery = true,value = "SELECT * from image where product_id = :id")
    Image findImageById(@Param("id") Long id);
}
