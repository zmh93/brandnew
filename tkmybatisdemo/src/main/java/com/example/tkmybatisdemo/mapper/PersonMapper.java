package com.testcase.plaintest.security.mapper;

import com.testcase.plaintest.domain.Person;
import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    Person selectByPrimaryKey(Integer id);

    List<Person> selectAll();

    int updateByPrimaryKey(Person record);
}