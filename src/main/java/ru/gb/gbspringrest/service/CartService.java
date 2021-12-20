package ru.gb.gbspringrest.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.gb.gbspringrest.dao.CartDao;
import ru.gb.gbspringrest.entity.Cart;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Getter
@Setter
public class CartService {

    private final CartDao cartDao;


    public Cart findCartsById(Long id) {
        return cartDao.findCartsById(id);
    }

    public void deleteById(Long id) {
        try {
            cartDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("No such id in DB: " + e.getMessage());
        }
    }


    public Cart save(Cart cart) {
        if (cart.getId() != null) {
            Optional<Cart> cartOptional = cartDao.findById(cart.getId());
            if (cartOptional.isPresent()) {
                Cart cartFromDB = cartOptional.get();
                cartFromDB.setProducts(cart.getProducts());
                return cartDao.save(cartFromDB);
            }
        }
        return cartDao.save(cart);

    }
}
