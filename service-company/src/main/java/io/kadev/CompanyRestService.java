package io.kadev;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CompanyRestService {
	@Value("${xParam}")
	private int xParam;
	@Value("${yParam}")
	private int yParam;
	@Value("${me}")
	private String me;
	@GetMapping("/configuration")
	public Map<String,Object> myConfig(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("xParam", xParam);
		params.put("yParam", yParam);
		params.put("me", me);
		params.put("thread name", Thread.currentThread().getName());
		return params;
	}
	
}
