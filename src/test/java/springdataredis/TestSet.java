package springdataredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSet {
	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	public void setValue(){
		redisTemplate.boundSetOps("nameset").add("曹操");		
		redisTemplate.boundSetOps("nameset").add("刘备");	
		redisTemplate.boundSetOps("nameset").add("孙权");
	}
	@Test
	public void getValue(){
		Set members = redisTemplate.boundSetOps("nameset").members();
		System.out.println(members);
	}
	@Test
	public void deleteValue(){
		redisTemplate.boundSetOps("nameset").remove("孙权");
	}

	@Test
	public void deleteAllValue(){
		redisTemplate.delete("nameset");
	}


}

