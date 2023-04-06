package tourim;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouzunda
 * @date 2023年03月19日 22:33
 * @description  springboot主程序类
 */
@SpringBootApplication
@MapperScan(basePackages = "tourim.contryside.mappers")
public class mainapplication {
    public static void main(String[] args) {
        SpringApplication.run(mainapplication.class, args);
        System.out.println("hot-fix");
        System.out.println("master-test");
        System.out.println("hot-fix test");
    }

}
