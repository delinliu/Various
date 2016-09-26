package cn.edu.sjtu.se.reins.contract.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.reins.contract.service.ContractService;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractServicecImpl;

	@RequestMapping(value = "/create-contract", method = RequestMethod.GET)
	public String createContractPage() {
		return "WEB-INF/pages/create-contract.jsp";
	}

	@RequestMapping(value = "/create-contract", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createContract(Map<String, Object> params) {
		System.out.println(params);
		return null;
	}

	@RequestMapping(value = "/getdict/{tableName}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDict(@PathVariable("tableName") String tableName) {
		List<?> value = contractServicecImpl.getDict(tableName);
		Map<String, Object> map = new HashMap<>();
		map.put("value", value);
		return map;
	}

}
