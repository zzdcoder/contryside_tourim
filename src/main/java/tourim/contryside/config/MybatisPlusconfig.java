package tourim.contryside.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouzunda
 * @date 2023年03月29日 23:54
 * @description
 */
@Configuration
public class MybatisPlusconfig {
    @Bean
    public MybatisPlusInterceptor mybatisplusIntercepor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        PaginationInnerInterceptor pageInterceptor = new PaginationInnerInterceptor();
        //添加乐观锁插件 只需要为version属性加上@version注解就可以做到当进行修改操作的时候会判断版本号一不一致
        //版本号一致就进行更新不一致就不能进行更新操作（需要手动重试）
        OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor = new OptimisticLockerInnerInterceptor();
        // 设置请求的页面大于最大页后操作，true调回到首页，false继续请求。默认false
        pageInterceptor.setOverflow(true);
        // 单页分页条数限制，默认无限制
        pageInterceptor.setMaxLimit(500L);
        // 设置数据库类型 因为不同的数据库分页有所不同
        pageInterceptor.setDbType(DbType.MYSQL);
        interceptor.addInnerInterceptor(pageInterceptor);
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);
        return interceptor;
    }
}
