package com.ljp.service;

import com.ljp.entity.Cart;
import com.ljp.entity.CartGoods;

import java.util.List;

public interface CartService {
    Cart findByUidAndPid(int uid, int pid);

    void add(Cart cart);

    void update(Cart cart);

    List<CartGoods> findByUid(int uid);

    void delete(int uid, int pid);

    void deleteByUid(int uid);
}
