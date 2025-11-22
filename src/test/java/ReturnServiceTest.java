import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnServiceTest {

    private ReturnService service = new ReturnService();

    @Test
    void shouldReturnTrueWhen14Days() {

        Order order = new Order();
        order.soldAt = LocalDateTime.now().minusDays(14);

        boolean actualResult = service.canReturnProduct(order);

        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnFalseWhen15Days() {
        Order order = new Order();
        order.soldAt = LocalDateTime.now().minusDays(15);

        boolean actualResult = service.canReturnProduct(order);

        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }
}