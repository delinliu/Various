package cn.edu.sjtu.se.reins.contract.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ContractMapper {

	List<Map<String, Object>> getDict(@Param("tableName") String tableName);
}
