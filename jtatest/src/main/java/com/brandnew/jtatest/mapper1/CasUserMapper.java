package com.brandnew.jtatest.mapper1;

import com.brandnew.jtatest.domain.CasUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CasUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CasUser record);

    CasUser selectByPrimaryKey(Long id);

    List<CasUser> selectAll();

    int updateByPrimaryKey(CasUser record);
}