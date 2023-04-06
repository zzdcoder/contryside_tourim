package tourim.contryside.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import tourim.contryside.inteceptor.LoginInteceptor;
import tourim.contryside.utils.ResultUtils;

/**
 * @author zhouzunda
 * @date 2023年03月19日 22:46
 * @description  定制化mvc
 */
@Configuration
@MapperScan(basePackages = "tourim.contryside.mappers")
public class Webconfig implements WebMvcConfigurer {
    /*
     *
     * @author zhouzunda
     * @date 2023/3/19 22:48
     * @param registry
     * @description   添加登录拦截器
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginInteceptor = registry.addInterceptor(new LoginInteceptor());
        loginInteceptor.addPathPatterns("/*");  //拦截所有
        loginInteceptor.excludePathPatterns("/static/");   //放行的路径
        loginInteceptor.excludePathPatterns("/templates/");
        loginInteceptor.excludePathPatterns("/"); //放行首页
        loginInteceptor.excludePathPatterns("/tourim");
        loginInteceptor.excludePathPatterns("/foodshop");
        loginInteceptor.excludePathPatterns("/contryside");
        loginInteceptor.excludePathPatterns("/news");
        loginInteceptor.excludePathPatterns("/senicdetail");
        loginInteceptor.excludePathPatterns("/goods_detail");
        loginInteceptor.excludePathPatterns("/gotologin");
        loginInteceptor.excludePathPatterns("/gotoregister");
        loginInteceptor.excludePathPatterns("/success");
        loginInteceptor.excludePathPatterns("/registersucc");
        loginInteceptor.excludePathPatterns("/checkregister");
        loginInteceptor.excludePathPatterns("/checklogin");
    }
    /*
     *
     * @author zhouzunda
     * @date 2023/3/21 21:19
     * @param registry
     * @description 视图控制器
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/gotologin").setViewName("login");
        registry.addViewController("/gotoregister").setViewName("register");
       // registry.addViewController("/tourim").setViewName("scenic_list");
       // registry.addViewController("/foodshop").setViewName("mall_list");
        //registry.addViewController("/contryside").setViewName("note_list");
        registry.addViewController("/news").setViewName("news_list");
        registry.addViewController("/tourim_activites").setViewName("activities_list");
        registry.addViewController("/activites").setViewName("activities");
        registry.addViewController("/hot_tourim").setViewName("scenic");
        registry.addViewController("/food_details").setViewName("project");
        //registry.addViewController("/jingdian_order").setViewName("submit_orders");
        registry.addViewController("/gotoexperence").setViewName("note");
        registry.addViewController("/pay_order").setViewName("confirm_order2");
        //registry.addViewController("/add_address").setViewName("my_contact");
        registry.addViewController("/gotomyinfo").setViewName("my_info");
        registry.addViewController("/gotomyhead").setViewName("my_head");
        registry.addViewController("/modifypass").setViewName("security");
    }
    //解决跨域问题
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            //重写父类提供的跨域请求处理的接口
            public void addCorsMappings(CorsRegistry registry) {
                //添加映射路径
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //放行哪些原始域(请求方式)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("*")
                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        .exposedHeaders("Header1", "Header2");
            }
        };
    }
}
