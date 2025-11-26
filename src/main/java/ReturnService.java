import java.time.LocalDateTime;

public class ReturnService {
    public boolean canReturnProduct(Order order) {
        if (order == null || order.soldAt == null) {
            return false;
        }

        LocalDateTime returnDeadline = order.soldAt.plusDays(Constants.DAYS_TO_RETURN);
        return !LocalDateTime.now().isAfter(returnDeadline);

    }
}
