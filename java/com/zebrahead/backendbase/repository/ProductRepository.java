package com.zebrahead.backendbase.repository;

import com.zebrahead.backendbase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
