package com.ljp.service.impl;

import com.ljp.dao.CartDao;
import com.ljp.dao.OrderDao;
import com.ljp.dao.OrderDetailDao;
import com.ljp.entity.Order;
import com.ljp.entity.OrderDetail;
import com.ljp.service.OrderService;
import com.ljp.util.MyBatisUtils;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = MyBatisUtils.getMapper(OrderDao.class);
    private OrderDetailDao orderDetailDao = MyBatisUtils.getMapper(OrderDetailDao.class);
    private CartDao cartDao= MyBatisUtils.getMapper(CartDao.class);
    @Override
    public void saveOrder(Order order, List<OrderDetail> orderDetails) {
        //
        try {
            //向order表添加订单
            orderDao.add(order);
            //向订单详情表添加数据
            for (OrderDetail od : orderDetails) {
                orderDetailDao.add(od);
            }
            //清空购物车
            cartDao.deleteByUid(order.getUid());
            MyBatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtils.rollback();
            throw e;
        }
    }

    @Override
    public void updateStatus(String oid, String status) {
        try {
            orderDao.updateStatus(oid,status);
            MyBatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtils.rollback();
            throw e;
        }
    }
}
