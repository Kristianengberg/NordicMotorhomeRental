package nmr.demo;

import nmr.demo.businessLogic.ReservationService;
import nmr.demo.models.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NordicMotorhomeRentalApplicationTests {

    ReservationService reservationService = new ReservationService();
    Invoice invoice = new Invoice(1,new Date(2001-01-01),new Date(2001-01-03),"","",2,1,2,3,"12");

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        int expected = 0;
        double actual = reservationService.calculatePrice(invoice);
        assertEquals(expected, actual);
    }

}
