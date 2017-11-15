import akka.actor.ActorSystem;
import controllers.AsyncController;
import controllers.CountController;
import io.jsonwebtoken.lang.Assert;

import org.junit.Test;
import play.mvc.Result;
import scala.concurrent.ExecutionContextExecutor;

import java.util.concurrent.CompletionStage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.*;
import static play.test.Helpers.contentAsString;

/**
 * Unit testing does not require Play application start up.
 *
 * https://www.playframework.com/documentation/latest/JavaTest
 */
public class UnitTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    // Unit test a controller
    @Test
    public void testCount() {
        final CountController controller = new CountController(() -> 49);
        Result result = controller.count();
        assertThat(contentAsString(result)).isEqualTo("49");
    }
    
    @Test 
    public void Test(){
    	int x = 5;
    	int y = 5;
    	assertEquals(x,y);
    }
    
    @Test 
    public void Test3(){
    	int x = 5;
    	int y = 4;
    	assertTrue(x>y) ;
    }
    
    
    
    @Test
    public void test2(){
    	int a = 1 + 3;
    	assertThat(a).isEqualTo(4);
    }
    @Test
    public void test4(){
    	String[] aass={"aa","ss"};
    	String[] bbss={"aa","ss"};
    	
    	assertArrayEquals(aass,bbss);
    }
    
    @Test
    public void Test5()
    {
    	String str1 = "Niriqsha";
    	String str2 = "Anurag";
    	assertNotSame(str1,str2);
    }
    // Unit test a controller with async return

}
