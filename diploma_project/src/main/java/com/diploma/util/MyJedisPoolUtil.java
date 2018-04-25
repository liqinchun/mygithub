package com.diploma.util;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis缓存池工具类
 * @author malin@tsinghuabigdata.com
 * @date 2014-10-17下午5:42:55<br/>
 */
public class MyJedisPoolUtil {
	private static final Logger logger = Logger.getLogger(MyJedisPoolUtil.class);
	
	private static JedisPool pool = null;
	private static int reTryTimes = 1;
	public static long checkTime = 0;
	//初始化
	static {
		if(pool == null){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(1024);
			config.setMaxIdle(200);
			config.setMaxWaitMillis(30000);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
//			//增加鉴权
//			if(RedisConfig.getPasswd() != null){
//				String passwd = RedisConfig.getPasswd();
//				int timeout = 3000;
//				if(RedisConfig.getTimeout() != 0){
//					timeout = RedisConfig.getTimeout();
//				}
//				pool = new JedisPool(config, RedisConfig.getHost(), RedisConfig.getPort(), timeout, passwd);
//			}else{
//				pool = new JedisPool(config, RedisConfig.getHost(),
//				    RedisConfig.getPort());
//			}
			pool = new JedisPool(config,"localhost",3679);
			reTryTimes = 3;
			checkTime = 0;
		}
	}
	//获取资源
	public static Jedis getJedis(){
		Jedis jedis = null;
		for(int i = 0; i < reTryTimes; i++){
			try {
				jedis = pool.getResource();
				return jedis;
			} catch (Exception e) {
				logger.error("Could not get a redis connect resource from the pool, retrying "+(i+1)+" ......",e);
			}
		}
		return jedis;
	}
	//回收资源
	public static void returnJedis(Jedis jedis){
		pool.returnResource(jedis);
	}
	//回收损坏资源
	public static void returnBrokenJedis(Jedis jedis){
		pool.returnBrokenResource(jedis);
	}
}
