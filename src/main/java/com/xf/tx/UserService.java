package com.xf.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xf
 * @date 2020-09-24 18:29
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional
    public void insertUser() {

        userDao.insert();
        System.out.println("插入完成-------");
        int i = 1 / 0;
    }

}
