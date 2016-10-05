package cn.edu.sjtu.se.reins.contract.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ContractMapper {

	List<Map<String, Object>> getDict(@Param("tableName") String tableName);

	void createContract(Map<String, Object> map);

	List<Map<String, Object>> getContracts();

	Map<String, Object> getContract(@Param("ContractID") int contractID);

	void createPayNode(Map<String, Object> map);
	void createReceiveNode(Map<String, Object> map);

	List<Map<String, Object>> getPayNodes(@Param("ContractID") int contractID);
	List<Map<String, Object>> getReceiveNodes(@Param("ContractID") int contractID);

	void updatePreRegisterContractManagerComments(Map<String, Object> map);
	void updatePreRegisterProjectManagerComments(Map<String, Object> map);
	void updateFormalRegisterContractManagerComments(Map<String, Object> map);
	void updateFormalRegisterProjectManagerComments(Map<String, Object> map);

	List<Map<String, Object>> getContractByState(@Param("State") int state);
	List<Map<String, Object>> getContractByStateAndOperator(@Param("State") int state, @Param("Operator") String operator);
	
	void updateContract(Map<String, Object> map);
}
