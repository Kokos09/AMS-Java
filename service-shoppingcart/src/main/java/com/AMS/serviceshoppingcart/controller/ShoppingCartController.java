package com.AMS.serviceshoppingcart.controller;

import com.AMS.serviceshoppingcart.model.ShoppingCart;
import com.AMS.serviceshoppingcart.service.ShoppingCartService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService service;

    @GetMapping("/list")
    public ResponseEntity<String> getAll() {
        JSONObject resp = service.findAll();
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
    }
    @GetMapping("/find-userCart/{userId}")
    public ResponseEntity<List<ShoppingCart>> getCartByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(service.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/find-article/{cartId}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable Long cartId) {
        return service.getCartById(cartId)
                .map(cart -> new ResponseEntity<>(cart, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<ShoppingCart> createCart(@RequestBody ShoppingCart cartData) {
        ShoppingCart createdCart = service.createCart(cartData);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<ShoppingCart> updateCart(@PathVariable Long cartId, @RequestBody ShoppingCart updatedCartData) {
        ShoppingCart updatedCart = service.updateCart(cartId, updatedCartData);
        if (updatedCart != null) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        service.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
