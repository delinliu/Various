package cn.edu.sjtu.se.reins.contract.service;

import java.util.List;
import java.util.Map;

public interface ContractService {

	List<Map<String, Object>> getDict(String tableName);

	void createContract(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getContracts();

	Map<String, Object> getContract(int contractID);
}