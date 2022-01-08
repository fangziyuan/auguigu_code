import com.zhaokun.aop.MathCalculator;
import com.zhaokun.config.MainConfigOfAOP;
import com.zhaokun.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_EXT {




    @Test
    public void test01() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });

        applicationContext.close();
    }


}
