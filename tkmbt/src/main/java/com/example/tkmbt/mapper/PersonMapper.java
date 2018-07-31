package com.example.tkmbt.mapper;

import com.example.tkmbt.domain.Person;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PersonMapper extends Mapper<Person> {
}