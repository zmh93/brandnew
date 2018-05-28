package com.brandnew.jtatest.service;

import com.brandnew.jtatest.domain.CasUser;
import com.brandnew.jtatest.domain.Person;
import com.brandnew.jtatest.mapper1.CasUserMapper;
import com.brandnew.jtatest.mapper2.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService1 {
    @Autowired
    private CasUserMapper casUserMapper;

    @Autowired
    private PersonMapper personMapper;

    /**
     *  测试在数据源不同的情况下，使用atomikos事务管理是否回滚
     * @createDate 2018/5/28
     */
    @Transactional
    public int addUser1 (){
        casUserMapper.insert(new CasUser(5L, "xxx", "xxx"));
        personMapper.insert(new Person(5L, "aaa", 25,"aaa"));
        int error = 1/0;
        return 1;
    }
}
