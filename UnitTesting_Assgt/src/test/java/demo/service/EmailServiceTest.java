package demo.service;
import static org.junit.Assert.*;
import demo.domain.Order;
import org.junit.Test;
import java.lang.reflect.Executable;

public class EmailServiceTest {

    private EmailService email ;
    private Order order;

    /*
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
     */

    @Test
    public void booleanSendEmailTest(){
        //given
        this.order = new Order(2, "item", 100.00);
        this.email = new EmailService();
        //when
        boolean send = email.sendEmail(order, "Hello");
        //then
        assertTrue(send);
    }


}