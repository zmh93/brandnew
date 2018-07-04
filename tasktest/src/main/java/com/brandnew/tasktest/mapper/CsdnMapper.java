package com.brandnew.tasktest.mapper;

import com.brandnew.tasktest.domain.Csdn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CsdnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Csdn record);

    Csdn selectByPrimaryKey(Long id);

    List<Csdn> selectAll();

    int updateByPrimaryKey(Csdn record);

}