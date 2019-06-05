package com.baggio.dbandcache.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
/**
 * @MapperScan
 * 该注解用于指定扫描的mapper接口所在的包
 */
@MapperScan(basePackages = "com.baggio.dbandcache.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("microserivcedb1.jdbc.driverClassName"));
        props.put("url", env.getProperty("microserivcedb1.jdbc.url"));
        props.put("username", env.getProperty("microserivcedb1.jdbc.username"));
        props.put("password", env.getProperty("microserivcedb1.jdbc.password"));

        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();

        // 指定数据源
        fb.setDataSource(ds);
        // 设置基础包
        fb.setTypeAliasesPackage("com.baggio.dbandcache.model");
        // 指定XML文件位置
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));

        return fb.getObject();
    }
}
