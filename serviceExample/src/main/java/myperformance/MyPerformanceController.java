package myperformance;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MyPerformanceController {
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	@ResponseBody
	public String api() throws IOException {
		return "timestamp: " + System.currentTimeMillis();
	}
}
