package com.imooc.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * spring and junit integration
 * on junit start, load springIOC container
 * 
 * 
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
// tell junit spring config location
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class BaseTest {
    
}
