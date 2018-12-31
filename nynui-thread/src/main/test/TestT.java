import com.nynui.current.ThreadPoolExecutor;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  17:40 2018/10/31
 * @ Modified By :
 */
public class TestT {

    public static void main(String[] args) {

        ThreadPoolExecutor  executor=new ThreadPoolExecutor(0,1,new LinkedBlockingDeque<Runnable>());
        executor.Executors(new Runnable() {
            @Override
            public void run() {
                System.out.printf("okkkkkkkkkk");
            }
        });

    }



    @Test
    public void TestMap(){
        Map m=new HashMap(2);
      m.put(1,"1");
      m.put(2,"2");

      m.put(3,"3");
      m.put(4,"4");
      m.put(5,"5");
    }
}
