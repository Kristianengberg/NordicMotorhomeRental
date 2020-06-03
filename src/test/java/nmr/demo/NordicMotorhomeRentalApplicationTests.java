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
    Invoice invoice = new Invoice(1,new Date(2001,01,01),new Date(2001,01,03),"","",0,1,2,0,"AK 99938");

    @Test
    void contextLoads() {
    }

    @Test
    public void getdays() {
        int expected = 4;
        Date datestart = new Date(2020,01,01);
        Date dateend = new Date(2020,01,04);
        double actual = reservationService.getDays(datestart,dateend);
        actual = Math.ceil(actual);
        assertEquals(expected, actual);
    }
    @Test
    public void getDaysDifferentMonth() {
        int expected = 64;
        Date datestart = new Date(2020,01,01);
        Date dateend = new Date(2020,03,04);
        double actual = reservationService.getDays(datestart,dateend);
        actual = Math.ceil(actual);
        assertEquals(expected, actual);

    }
    @Test
    public void getNegativedays() {
        int expected = -3;
        Date datestart = new Date(2020,01,04);
        Date dateend = new Date(2020,01,01);
        double actual = reservationService.getDays(datestart,dateend);
        actual = Math.ceil(actual);
        System.out.println("Wrong output");
        assertEquals(expected, actual);

    }
    @Test
    public void getEngineBlockNumber(){
        int expected = 4232344;
        int actual = reservationService.returnEngineBlockNo("AI 11233");
        assertEquals(actual,expected);
    }


    @Test
    public void getWrongEngineBlockNumber(){
        int expected = 0;
        int actual = reservationService.returnEngineBlockNo("sælkfmnælkn");
        assertEquals(actual,expected);
    }

    @Test
    public void priceTest(){
       double actual =  reservationService.calculatePrice(invoice);
        System.out.println(actual);
       double expected = 883*3;
        assertEquals(actual,expected);

    }


}



