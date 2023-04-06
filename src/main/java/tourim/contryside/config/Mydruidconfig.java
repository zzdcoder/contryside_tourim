package tourim.contryside.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhouzunda
 * @date 2023年03月19日 22:34
 * @description  druid配置类
 */
@Configuration
public class Mydruidconfig {
    @ConfigurationProperties(prefix = "spring.datasource.druid")   //和指定前缀的配置文件内容进行绑定
    @Bean
    public DataSource getDruidDatasource(){
        return new DruidDataSource();
    }
}
