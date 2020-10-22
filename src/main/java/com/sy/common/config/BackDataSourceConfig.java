package com.sy.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Data
@Configuration
@MapperScan(basePackages = BackDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "backSqlSessionFactory")
public class BackDataSourceConfig {
    /**
     * dao层的包路径
     */
    static final String PACKAGE = "com.sy.dao.back";
    /**
     * mapper文件的相对路径
     */
    private static final String MAPPER_LOCATION = "classpath:mapper/back/*.xml";

    @ConfigurationProperties(prefix = "spring.datasource.back")
    @Bean(name = "backDataSource")
    public DataSource backDataSource() throws SQLException {
        return new DruidDataSource();
    }

    // 创建该数据源的事务管理
    @Bean(name = "backTransactionManager")
    public DataSourceTransactionManager backTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(backDataSource());
    }

    // 创建Mybatis的连接会话工厂实例
    @Bean(name = "backSqlSessionFactory")
    public SqlSessionFactory backSqlSessionFactory(@Qualifier("backDataSource") DataSource backDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 设置数据源bean
        sessionFactory.setDataSource(backDataSource);
        // 设置mapper文件路径
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(BackDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
