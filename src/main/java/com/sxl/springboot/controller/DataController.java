package com.sxl.springboot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.common.Config;
import com.sxl.springboot.model.School;
import com.sxl.springboot.model.Sight;
import com.sxl.springboot.model.User;
import com.sxl.springboot.service.SchoolService;
import com.sxl.springboot.service.SightService;
import com.sxl.springboot.service.UserService;

@RestController
@SpringBootApplication
@RequestMapping("/data")
public class DataController {
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SightService sightService;
	
	@RequestMapping("/listUser")
	public BaseModelResult<List<User>> listUser(){
		BaseModelResult<List<User>> result = new BaseModelResult<List<User>>();
		result.setData(userService.listUsers());
		return result;
	}
	
	@RequestMapping("/getUserById")
	@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
	public BaseModelResult<User> getUserById(Integer id){
		return userService.getUser(id);
	}
	
	@RequestMapping("/listSchool")
	public BaseModelResult<List<School>> listSchool(){
		return schoolService.getAllSchool();
	}

	@RequestMapping("/getSchoolById")
	public BaseModelResult<School> getSchoolById(Integer id){
		return schoolService.getSchoolInfo(id);
	}
	
	@RequestMapping("/editUser")
	public BaseModelResult<Integer> editUser(User user){
		return userService.editUser(user);
	}
	
	@RequestMapping("/editSchool")
	public BaseModelResult<Integer> editSchool(@RequestBody School school){
		return schoolService.editSchool(school);
	}
	
	@RequestMapping("/getSchoolSights")
	public BaseModelResult<List<Sight>> getSightOfSchool(int schoolId){		
		return sightService.getSchoolSight(schoolId);
	}
	
	@RequestMapping("/getSightById")
	public BaseModelResult<Sight> getSightById(int sightId){		
		return sightService.getSight(sightId);
	}
	
	@RequestMapping("/editSight")
	public BaseModelResult<Integer> editSight(MultipartFile file,
            HttpServletRequest request) throws IOException, Exception{		
		String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String name = request.getParameter("name");
        String intro = request.getParameter("intro");
        String id = request.getParameter("id");
        Sight s = new Sight();
        s.setId(Integer.parseInt(id));
        s.setName(name);
        s.setDescription(intro);
        String filePath =request.getSession().getServletContext().getRealPath("admin/");
        System.out.println(filePath);
        if("".equals(fileName.trim())) {
        	
        }else {
        	uploadFile(file.getBytes(), filePath, fileName);        	
        }
        return sightService.editSight(Integer.parseInt(id),name,intro,fileName);
	}
	
	@RequestMapping("/uploadFile")
	public Map ossUpload(String filename,String dir) {
		String endpoint = Config.oss_endpoint_name;
        String accessId = Config.access_id;
        String accessKey = Config.access_secret;
        String bucket = Config.oss_file_bucket;
        String host = "http://" + bucket + "." + endpoint + ".aliyuncs.com";
        OSSClient client = new OSSClient(endpoint, accessId, accessKey);
        
        long expireTime = 3600;
    	long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
        
        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        
        byte[] binaryData = null;
        String encodedPolicy = null;
		try {
			binaryData = postPolicy.getBytes("utf-8");
			encodedPolicy = BinaryUtil.toBase64String(binaryData);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
        String postSignature = client.calculatePostSignature(postPolicy);
        
        Map map = new HashMap();
        map.put("access_id", accessId);
        map.put("policy", encodedPolicy);
        map.put("signature", postSignature);
        map.put("dir", dir);
        map.put("host", host);
        map.put("expire", String.valueOf(expireEndTime / 1000));
        return map;
	}
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+System.getProperty("file.separator")+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
