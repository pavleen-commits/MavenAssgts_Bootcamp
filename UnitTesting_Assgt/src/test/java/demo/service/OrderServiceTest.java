package demo.service;
import demo.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    static OrderService myservice;

    @BeforeAll
    public static void setup() {
        myservice = OrderService.getInstance();
    }

    @Test
    void testInstanceOfSingleton() {
        assertSame(OrderService.getInstance(), myservice);
    }

    @Test
    void placeOrder() {
        Order order = new Order(8, "bracelets", 10000.0);
        Executable executable = () -> myservice.placeOrder(order);
        assertThrows(RuntimeException.class, executable);
    }

    static Order[] myorders() {

        return new Order[]{
                new Order(1, "sunglasses", 10000),
                new Order(2, "laptop", 4000000)
        };
    }

    @ParameterizedTest
    @MethodSource("myorders")
    void placingOrderInBooleanPlaceOrder(Order o) {
        boolean result = myservice.placeOrder(o, o.getItemName());
        assertTrue(result);
    }
}


