package com.xu.combootcomponnent.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author xuhongda on 2018/8/2
 * com.xu.combootcomponnent.datasource
 * com-boot-ex
 */
@Configuration
@MapperScan(basePackages = "com.xu.combootcomponnent.mapper.mysql1Mapper.UserMapper",sqlSessionTemplateRef = "mysql1SqlSessionTemplate")
public class DataSource1Config {

    @Bean(name = "mysql1")
    @ConfigurationProperties(prefix = "spring.datasource.mysql1")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysql1SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mysql1")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/mysql1Mapper/*.xml") );
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mysql1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("mysql1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mysql1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mysql1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
