import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnServiceTest {

    private ReturnService service = new ReturnService();

    @Test
    void shouldReturnTrueWhen13Days() {
        Order order = new Order();
        order.soldAt = LocalDateTime.now().minusDays(13);

        assertTrue(service.canReturnProduct(order));
    }

    @Test
    void shouldReturnTrueWhen14Days() {
        Order order = new Order();
        order.soldAt = LocalDateTime.now().minusDays(14).plusSeconds(1);

        boolean actualResult = service.canReturnProduct(order);

        assertTrue(actualResult);
    }

    @Test
    void shouldReturnFalseWhen15Days() {
        Order order = new Order();
        order.soldAt = LocalDateTime.now().minusDays(15);

        assertFalse(service.canReturnProduct(order));
    }
}