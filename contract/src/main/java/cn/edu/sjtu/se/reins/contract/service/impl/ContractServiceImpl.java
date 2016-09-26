package cn.edu.sjtu.se.reins.contract.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.reins.contract.mapper.ContractMapper;
import cn.edu.sjtu.se.reins.contract.service.ContractService;

@Service("contractServiceImpl")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractMapper contractMapper;

	public List<Map<String, Object>> getDict(String tableName) {
		if (tableName.contains(" ")) {
			return null;
		}
		try {
			return contractMapper.getDict(tableName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
