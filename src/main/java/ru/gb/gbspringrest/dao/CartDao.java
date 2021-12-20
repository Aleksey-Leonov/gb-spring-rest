package ru.gb.gbspringrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbspringrest.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

    Cart findCartsById(Long id);

}
