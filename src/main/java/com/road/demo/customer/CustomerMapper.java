package com.road.demo.customer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
	Customer findUserById(String id);
}
