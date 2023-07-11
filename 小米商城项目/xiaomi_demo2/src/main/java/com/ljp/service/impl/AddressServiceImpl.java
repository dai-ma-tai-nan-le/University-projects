package com.ljp.service.impl;

import com.ljp.dao.AddressDao;
import com.ljp.entity.Address;
import com.ljp.service.AddressService;
import com.ljp.util.MyBatisUtils;

import java.util.List;

/**
 * @author wgy
 * @version v1.0
 * @date 2022/9/27 14:06
 */
public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = MyBatisUtils.getMapper(AddressDao.class);

    @Override
    public List<Address> findByUid(int uid) {
        List<Address> addresses = addressDao.selectByUid(uid);
        MyBatisUtils.closeSession();
        return addresses;
    }

    @Override
    public void addAddress(Address address) {
        try {
            addressDao.insert(address);
            MyBatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtils.rollback();
            throw e;
        }
    }

    @Override
    public void deleteById(int aid) {
        try {
            addressDao.deleteById(aid);
            MyBatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtils.rollback();
            throw e;
        }
    }

    @Override
    public void update(Address address) {
        try {
            addressDao.update(address);
            MyBatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtils.rollback();
            throw e;
        }
    }

    @Override
    public void defaultAddress(int uid, int aid) {
        try {
            addressDao.updateAll(uid);//0
            addressDao.updateDefault(aid);//1
            MyBatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtils.rollback();
            throw e;
        }
    }
}
