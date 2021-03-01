package demo.service;
import static org.junit.jupiter.api.Assertions.*;
import demo.domain.Order;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.function.Executable;
public class EmailServiceTest {

        static  EmailService myservice;
        @BeforeAll
        public static void setup()
        {
            myservice=EmailService.getInstance();
        }

        @Ignore
        @Test
        public void testSingletonEmailServiceInstance()
        {
            assertSame(EmailService.getInstance(),myservice);
        }

        @Test
        public void sendEmail() {
            Order order= new Order(2,"bracelet", 5000.0);
            Executable executable = () -> myservice.sendEmail(order);
            assertThrows(RuntimeException.class , executable);
        }

        @ParameterizedTest
        @CsvSource(value = {"3,WATCH, 4000.0, WATCH" , "2,Jeans, 4000.0, Jeans","3,papaya, 700.0,papaya"})
        public void testSendEmail(int items ,String item_name , double price , String msg)
        {
            Order order = new Order(items,item_name,price);
            String newmsg=msg;
            boolean result=myservice.sendEmail(order,newmsg);
            assertTrue(result);
        }
    }

/* PREVIOUS CODE
    private EmailService email ;
    private Order order;


    @BeforeAll
    public void setup(){

        this.order = new Order(2, "item", 100.00);
        this.email = new EmailService();
    }
    @Test
    void sendEmailTest (){
        //given
        this.order = new Order(2, "item", 100.00);
        this.email = new EmailService();
        //when
        Executable execute = () -> email.sendEmail(order);
        //then
        assertThrows(RuntimeException.class, execute);
    }


    @Test
    public void booleanSendEmailTest(){
        //given

        //when
        boolean send = email.sendEmail(order, "Hello");
        //then
        assertTrue(send);
    }


}


 */