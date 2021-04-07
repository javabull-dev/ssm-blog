package com.javabull.ssm.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ItemDao {
    @Insert("insert into tb_item(id, name) values(#{id},#{name})")
    void batchInsert(@Param("id") Integer id, @Param("name") String name);
}
