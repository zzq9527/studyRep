package com.demo.demo.repository;

import com.demo.demo.domain.GirlAll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<GirlAll,Integer> {

    //通过年龄查询
    public List<GirlAll> findByAge(int age);
}
