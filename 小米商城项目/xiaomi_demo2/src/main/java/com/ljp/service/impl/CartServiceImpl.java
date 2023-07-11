package com.ljp.service.impl;

import com.ljp.dao.CartDao;
import com.ljp.entity.Cart;
import com.ljp.entity.CartGoods;
import com.ljp.service.CartService;
import com.ljp.util.MyBatisUtils;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao= MyBatisUtils.getMapper(CartDao.class);
    @Override
    public Cart findByUidAndPid(int uid, int pid) {
        Cart cart=cartDao.selectByUidAndPid(uid,pid);
        MyBatisUtils.clearCache();
        return cart;
    }

    @Override
    public void add(Cart cart) {
        cartDao.insertCart(cart);
        MyBatisUtils.commit();
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
        MyBatisUtils.commit();
    }
    @Override
    public List<CartGoods> findByUid(int uid) {
        try {
            List<CartGoods> cartList=cartDao.selectByUid(uid);
//            System.out.println(cartList.toString()+"q   ");
            return cartList;
        } finally {
            MyBatisUtils.closeSession();
        }
    }

    @Override
    public void delete(int uid, int pid) {
        try {
            cartDao.delete(uid,pid);
            MyBatisUtils.commit();
        } catch (Exception e){
            MyBatisUtils.rollback();
            throw  e;
        }
    }

    @Override
    public void deleteByUid(int uid) {
        try {
            cartDao.deleteByUid(uid);
            MyBatisUtils.commit();
        } catch (Exception e){
            MyBatisUtils.rollback();
            throw  e;
        }
    }
}
