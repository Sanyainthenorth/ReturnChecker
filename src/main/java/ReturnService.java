import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReturnService {
    public boolean canReturnProduct(Order order) {
        if (order == null || order.soldAt == null) {
            return false;
        }

        LocalDate soldDate = order.soldAt.toLocalDate();
        LocalDate currentDate = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(soldDate, currentDate);

        return daysBetween <= Constants.DAYS_TO_RETURN;
    }
}
