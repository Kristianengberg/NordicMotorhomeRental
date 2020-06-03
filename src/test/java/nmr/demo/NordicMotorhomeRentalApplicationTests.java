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
    Invoice invoice = new Invoice(1,new Date(2001,01,01),new Date(2001,01,03),"","",0,1,2,0,"AI 11233");

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
    public void getEngineBlockNumber(){
        int expected = 4232344;
        int actual = reservationService.returnEngineBlockNo("AI 11233");
        assertEquals(actual,expected);
    }
    @Test
    public void getWrongEngineBlockNumber(){
        int expected = 0;
        int actual = reservationService.returnEngineBlockNo("sælkfmnælkn");
    }

    @Test
    public void tester(){
        
    }


}
/*










    public double calculatePrice(Invoice invoice){
        double price = 0;

        double days = getDays((Date) invoice.getDateStart(), (Date) invoice.getDateEnd());
        double diff = invoice.getDateStart().getTime() - invoice.getDateEnd().getTime();
        double days = (diff / (1000*60*60*24))*-1+1;


        price = motorhomeRepository.readByLicense(invoice.getLicensePlateNo()).getPrice();

                price = price * days;
                if(accessories != null) {
                price += accessories.getPrice();
                }
                return price;
                }

public double calculateExtraPrice(double kilometer, Invoice invoice, String gas) {

        double price = 0;

        double kilometersPerDay = (kilometer - this.motorhome.getKilometers()) / getDays((Date)invoice.getDateStart(),(Date) invoice.getDateEnd()) ;

        if( kilometersPerDay > maxKilometerPerDay )
        price = extraKilometerPrice * (kilometersPerDay - maxKilometerPerDay);
        if(gas == "true"){
        price += fullTankPrice;
        }

        return price;
        }
        }



        */
