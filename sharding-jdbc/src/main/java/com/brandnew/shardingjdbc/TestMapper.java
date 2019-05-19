package com.brandnew.shardingjdbc;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Test record);

    Test selectByPrimaryKey(Long id);

    List<Test> selectAll();

    int updateByPrimaryKey(Test record);
}