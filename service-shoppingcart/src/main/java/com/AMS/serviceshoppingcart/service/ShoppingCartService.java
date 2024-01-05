package com.AMS.serviceshoppingcart.service;

import com.AMS.serviceshoppingcart.model.ShoppingCart;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;


@Service
public interface ShoppingCartService {

    public JSONObject findAll();
    List<ShoppingCart> findByUserId(Long userId);
    public Optional<ShoppingCart> getCartById(Long cartId);
    public ShoppingCart createCart(ShoppingCart shoppingCartData);
    public ShoppingCart updateCart(Long cartId, ShoppingCart updatedShoppingCartData);
    public void deleteCart (Long cartId);
}
