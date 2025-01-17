package springdataredis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @author 杨李平
 * @date 2019/12/27 9:05
 */
public class TestList {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 右压栈：后添加的对象排在后边
     */
    @Test
    public void testSetValue1(){
        redisTemplate.boundListOps("namelist1").rightPush("刘备");
        redisTemplate.boundListOps("namelist1").rightPush("关羽");
        redisTemplate.boundListOps("namelist1").rightPush("张飞");
    }

    /**
     * 显示右压栈集合
     */
    @Test
    public void testGetValue1(){
        List list = redisTemplate.boundListOps("namelist1").range(0, 10);
        System.out.println(list);
    }




    /**
     * 左压栈：后添加的对象排在前边
     */
    @Test
    public void testSetValue2(){
        redisTemplate.boundListOps("namelist2").leftPush("刘备");
        redisTemplate.boundListOps("namelist2").leftPush("关羽");
        redisTemplate.boundListOps("namelist2").leftPush("张飞");
    }

    /**
     * 显示左压栈集合
     */
    @Test
    public void testGetValue2(){
        List list = redisTemplate.boundListOps("namelist2").range(0, 10);
        System.out.println(list);
    }



    /**
     * 查询集合某个元素
     */
    @Test
    public void testSearchByIndex(){
        String s = (String) redisTemplate.boundListOps("namelist1").index(1);
        System.out.println(s);
    }

    /**
     * 移除集合某个元素
     */
    @Test
    public void testRemoveByIndex(){
        redisTemplate.boundListOps("namelist1").remove(1, "关羽");
    }


}
