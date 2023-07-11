package com.ljp.service;

import com.ljp.entity.Order;
import com.ljp.entity.OrderDetail;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order, List<OrderDetail> orderDetails);

    void updateStatus(String oid, String status);
}
