package com.AMS.serviceshoppingcart.service.impl;

import com.AMS.serviceshoppingcart.model.ShoppingCart;
import com.AMS.serviceshoppingcart.repository.ShoppingCartRepository;
import com.AMS.serviceshoppingcart.service.ShoppingCartService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;


    @Override
    public JSONObject findAll() {
        JSONObject resp=new JSONObject();
        resp.put("data",repository.findAll());
        resp.put("code", HttpStatus.OK);
        return resp;
    }

    @Override
    public List<ShoppingCart> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Optional<ShoppingCart> getCartById(Long cartId) {
        Optional<ShoppingCart> shoppingCartOptional = repository.findById(cartId);
        return shoppingCartOptional;
    }

    @Override
    public ShoppingCart createCart(ShoppingCart shoppingCartData) {
        ShoppingCart newShoppingCart = new ShoppingCart();
        newShoppingCart.setUserId(shoppingCartData.getUserId());
        newShoppingCart.setItems(shoppingCartData.getItems());
        newShoppingCart.setQuantity(shoppingCartData.getQuantity());
        newShoppingCart.setTotalPrice(shoppingCartData.getTotalPrice());
        ShoppingCart savedShoppingCart = repository.saveAndFlush(newShoppingCart);
        return savedShoppingCart;
    }

    @Override
    public ShoppingCart updateCart(Long cartId, ShoppingCart updatedShoppingCartData) {
        Optional<ShoppingCart> existingCartOptional = repository.findById(cartId);
        if (existingCartOptional.isPresent()) {
            ShoppingCart existingCart = existingCartOptional.get();
            existingCart.setUserId(updatedShoppingCartData.getUserId());
            existingCart.setItems(updatedShoppingCartData.getItems());
            existingCart.setTotalPrice(updatedShoppingCartData.getTotalPrice());
            existingCart.setQuantity(updatedShoppingCartData.getQuantity());
            ShoppingCart updatedCart = repository.save(existingCart);
            return updatedCart;
        } else {
            return null;
        }
    }

    @Override
    public void deleteCart(Long cartId) {
        repository.deleteById(cartId);
    }
}
