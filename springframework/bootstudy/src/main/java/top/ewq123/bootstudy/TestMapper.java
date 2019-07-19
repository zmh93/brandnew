package top.ewq123.bootstudy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TestMapper {

    @Select("SELECT * FROM information_schema.TABLES where table_schema  not in " +
            "('information_schema','sys','performance_schema','mysql')")
    List<Map<String, Object>> getBaseInfor();
}
