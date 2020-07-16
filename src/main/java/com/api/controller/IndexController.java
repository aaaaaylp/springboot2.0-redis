/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayiedu.service.RedisService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明: <br>
 * 创建作者:每特教育-余胜军<br>
 * 创建时间:2018年8月1日 下午9:51:42<br>
 * 教育机构:每特教育|蚂蚁课堂<br>
 * 版权说明:上海每特教育科技有限公司版权所有<br>
 * 官方网站:www.itmayiedu.com|www.meitedu.com<br>
 * 联系方式:qq644064779<br>
 * 注意:本内容有每特教育学员共同研发,请尊重原创版权
 */
@RestController
public class IndexController {
	@Autowired
	private RedisService redisService;
	public  static  Map<String,String> map=new HashMap<>();
	@RequestMapping("/setString")
	public String setString(String key, String object) {

		long curTime = System.currentTimeMillis();
		for (int i = 0; i < 30000; i++) {
			//redisService.set(key, object, 60l);
			map.put(curTime+""+i+key,object);
		}
		System.out.println(System.currentTimeMillis()-curTime);
		System.out.println(map.size());
		return curTime+"";
	}

	@RequestMapping("/get")
	public String get(String key) {
		int count=0;
		long curTime = System.currentTimeMillis();
		List<String> list=new ArrayList();
		for (String s : map.keySet()) {
			if (s.contains(key)){
				String s1 = map.remove(s);
				//map.remove(s);
				System.out.println(s+":"+s1);
				list.add(s);
				count++;
			}
		}
		for (String o : list) {
			String remove = map.remove(o);

		}
		System.out.println("*****"+count);
		System.out.println(System.currentTimeMillis()-curTime);
		return  "success";
		//return redisService.getString(key);
	}

}
