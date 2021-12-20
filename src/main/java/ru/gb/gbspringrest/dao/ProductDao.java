package ru.gb.gbspringrest.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbspringrest.entity.Product;
import ru.gb.gbspringrest.entity.enums.Status;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);
    List<Product> findAllByTitleContaining(String title);

    List<Product> findAllByStatus(Status status);
    List<Product> findAllByStatus(Status status, Pageable pageable);
    List<Product> findAllByStatus(Status status, Sort sort);
}
