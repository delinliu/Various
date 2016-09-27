package cn.edu.sjtu.se.reins.contract.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.reins.contract.service.ContractService;
import cn.edu.sjtu.se.reins.contract.util.Util;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractServicecImpl;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "/WEB-INF/pages/logout.jsp";
	}

	@RequestMapping(value = "/create-contract", method = RequestMethod.GET)
	public String createContractPage() {
		return "/WEB-INF/pages/create-contract.jsp";
	}

	@RequestMapping(value = "/list-contracts", method = RequestMethod.GET)
	public String listContractsPage() {
		return "/WEB-INF/pages/list-contracts.jsp";
	}

	@RequestMapping(value = "/view-contract/{ContractID}", method = RequestMethod.GET)
	public String viewContractPage() {
		return "/WEB-INF/pages/view-contract.jsp";
	}

	@RequestMapping(value = "/comment-contract/{ContractID}", method = RequestMethod.GET)
	public String commentContractPage() {
		return "/WEB-INF/pages/comment-contract.jsp";
	}

	@RequestMapping(value = "/create-contract", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, Object> createContract(@RequestBody Map<String, Object> parameters) {
		try {
			contractServicecImpl.createContract(parameters);
			return Util.createMap(null);
		} catch (Exception e) {
			e.printStackTrace();
			return Util.createErrorMap("创建合同表失败，请稍后再试或联系管理员。");
		}
	}

	@RequestMapping(value = "/get-contracts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getContracts() {
		try {
			return Util.createMap(contractServicecImpl.getContracts());
		} catch (Exception e) {
			e.printStackTrace();
			return Util.createErrorMap("获取合同表失败，请稍后再试或联系管理员。");
		}
	}

	@RequestMapping(value = "/getdict/{tableName}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDict(@PathVariable("tableName") String tableName) {
		List<?> value = contractServicecImpl.getDict(tableName);
		Map<String, Object> map = new HashMap<>();
		map.put("value", value);
		return map;
	}

	@RequestMapping(value = "/get-contract", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getContract(@RequestParam("ContractID") int ContractID) {
		try {
			return Util.createMap(contractServicecImpl.getContract(ContractID));
		} catch (Exception e) {
			e.printStackTrace();
			return Util.createErrorMap("获取合同表失败，请稍后再试或联系管理员。");
		}
	}

	@RequestMapping(value = "/comment-contract", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, Object> commentContract(@RequestBody Map<String, Object> parameters) {
		try {
			contractServicecImpl.commentContract(parameters);
			return Util.createMap(null);
		} catch (Exception e) {
			e.printStackTrace();
			return Util.createErrorMap("提交失败，请稍后再试或联系管理员。");
		}
	}

}
