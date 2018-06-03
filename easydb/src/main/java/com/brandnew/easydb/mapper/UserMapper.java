package com.brandnew.easydb.mapper;

import com.brandnew.easydb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends JpaRepository<User,Long> {
    <S extends User> List<S> save(Iterable<S> user);
}
