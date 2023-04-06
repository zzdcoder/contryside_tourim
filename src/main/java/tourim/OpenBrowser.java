package tourim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhouzunda
 * @date 2023年03月21日 21:22
 * @description   指定义服务器启动后跳转的页面
 */
@Component
public class OpenBrowser implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始自动加载指定的页面");
        try {
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8088");//可以指定自己的路径
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
