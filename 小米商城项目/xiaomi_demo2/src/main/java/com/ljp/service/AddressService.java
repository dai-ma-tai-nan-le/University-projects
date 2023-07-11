package com.ljp.service;

import com.ljp.entity.Address;

import java.util.List;

/**
 * @author wgy
 * @version v1.0
 * @date 2022/9/27 14:06
 */
public interface AddressService {
    List<Address> findByUid(int uid);

    void addAddress(Address address);

    void deleteById(int aid);

    void update(Address address);

    void defaultAddress(int uid, int aid);
}
