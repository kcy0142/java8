
package com.messenger.translation.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




@Controller

public class TransController {

	private static final Logger LOG = LoggerFactory.getLogger(TransController.class);
	
	@RequestMapping("/translation.do")
	@ResponseBody
	public String commentList1 (@RequestParam(name="key", required=false) String key,
			@RequestParam(name="source", required=false) String source,
			@RequestParam(name="userID", required=false) String userID,
			@RequestParam(name="userIP", required=false) String userIP,
			@RequestParam(name="target", required=false) String target,
			@RequestParam(name="q", required=false) String q)  {
		
	
		//http://localhost:9080/translation.do?key=AIzaSyBd0yTCA0_p6fChOWO04M98SqA_fgdV9LU&source=ko&target=en&q=%EB%A1%9C%EB%B4%87
		//http://localhost:9080/translation.do?key=AIzaSyBd0yTCA0_p6fChOWO04M98SqA_fgdV9LU&source=00&target=en&q=Ch%C3%A0o%20h%E1%BB%8Fi
		RestTemplate restTemplate = new RestTemplate();
//		
//		if(StringUtils.isEmpty(key)){
//			key="AIzaSyBd0yTCA0_p6fChOWO04M98SqA_fgdV9LU";
//		}
		if(StringUtils.isEmpty(source)){
			source="ko";
		}
		if(StringUtils.isEmpty(target)){
			target="en";
		}
		if(StringUtils.isEmpty(q)){
			q="안녕";
		}
		
		String param="";
		String fooResourceUrl ="";
		String url  ="";
		param="?key="+key+"&source="+source+"&target="+target+"&q="+q;
		//언어감지 시작
		if(source.equals("00")){
			fooResourceUrl  = "https://translation.googleapis.com/language/translate/v2/detect"+param;
			ResponseEntity<String> response  = restTemplate.getForEntity(fooResourceUrl , String.class);
			
			String json   = restTemplate.getForObject(fooResourceUrl , String.class);
			
			Map<String,String> map = new HashMap<String,String>();
			ObjectMapper mapper = new ObjectMapper();
			
			JsonNode jsonNode=null;
			
			System.out.println("######json:"+json);
			 try {
				  jsonNode= mapper.readTree(json);  
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 String last_source=jsonNode.findValuesAsText("language").get(0);
			 System.out.println("#####last_source:"+last_source);
			 LOG.info("#####last_source:"+last_source);
			 source=last_source;
			
		}
		//언어감지 끝
		param="?key="+key+"&source="+source+"&target="+target+"&q="+q;
		//System.out.println("###TRANS PARAM===> userID:"+userID+",userIP:"+userIP+",key:"+key+",source:"+source+",target:"+target+",q:"+q);
		
		//http://10.64.151.198:8080/translation.do??key=AIzaSyBd0yTCA0_p6fChOWO04M98SqA_fgdV9LU&source=ko&target=en&q=%EB%A1%9C%EB%B4%87
		//http://localhost:8080/translation.do??key=AIzaSyBd0yTCA0_p6fChOWO04M98SqA_fgdV9LU&source=ko&target=en&q=%EB%A1%9C%EB%B4%87
		
		//2018.01.17 source와 target이 같으면 그냥 번역안하고 null값을 넘긴다.
		String json   ="";
		if(source.equals(target)){
			json   ="{ \"data\": { \"translations\": [ { \"translatedText\": \"\" } ] } }";
		}else{
			fooResourceUrl  = "https://translation.googleapis.com/language/translate/v2/"+param;
			url  = "https://translation.googleapis.com/language/translate/v2?key=AIzaSyBd0yTCA0_p6fChOWO04M98SqA_fgdV9LU&source=ko&target=en&q=안녕";
			ResponseEntity<String> response  = restTemplate.getForEntity(fooResourceUrl , String.class);
			
			json   = restTemplate.getForObject(fooResourceUrl , String.class);
			
			Map<String,String> map = new HashMap<String,String>();
			ObjectMapper mapper = new ObjectMapper();
			
			LOG.info("###TRANS PARAM===> userID:"+userID+",userIP:"+userIP+",key:"+key+",source:"+source+",target:"+target+",q:"+q+",result:"+json);
		}
		
		return json;
	}
	

}

