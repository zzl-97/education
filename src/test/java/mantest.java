import UserTest.Boot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Boot.class})
public class mantest {


    @Test
    public  void select(){

        System.out.println("这是一个测试方法");
    }


}
