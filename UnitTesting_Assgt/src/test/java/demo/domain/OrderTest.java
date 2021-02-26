package demo.domain;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest  {

    @Test
        public void shouldReturnTrue_whenQuantity_isSame(){
        //given
        Order order = new Order();
        //when
        order.setQuantity(9);
        //then
        assertEquals(order.getQuantity(),9);
    }


    @Test
        public void shouldReturnTrue_whenItemName_isSame(){

        //given
        Order order = new Order();
        //when
        order.setItemName("item");
        //then
        assertEquals(order.getItemName(),"item");

    }

    @Test
       public  void shouldReturnTrue_whenPrice_isSame(){

        //given
        Order order = new Order();
        //when
        order.setPrice(90.0);
        //then
        assertEquals(90.0, order.getPrice(), 0 );

    }

    void shouldReturnTrue_whenPriceWithTex_isSame() {

        //given
        Order order = new Order();
        //when
        order.setPriceWithTex(99.0);
        //then
        assertEquals(order.getPriceWithTex(), 99.0, 0);
    }
}