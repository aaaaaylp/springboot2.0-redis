package springdataredis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * @author 杨李平
 * @date 2019/12/27 9:22
 */
public class TestHash {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testSetValue(){
        redisTemplate.boundHashOps("namehash").put("a", "唐僧");
        redisTemplate.boundHashOps("namehash").put("b", "悟空");
        redisTemplate.boundHashOps("namehash").put("c", "八戒");
        redisTemplate.boundHashOps("namehash").put("d", "沙僧");
    }
    @Test
    public void testGetKeys(){
        Set s = redisTemplate.boundHashOps("namehash").keys();
        System.out.println(s);
    }
    @Test
    public void testGetValueByKey(){
        Object object = redisTemplate.boundHashOps("namehash").get("b");
        System.out.println(object);
    }
    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }
}
