import com.zhaokun.aop.MathCalculator;
import com.zhaokun.config.MainConfigOfAOP;
import com.zhaokun.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {


    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

    @Test
    public void test01() {
        //1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        int div = bean.div(1, 0);
        applicationContext.close();
    }


}
