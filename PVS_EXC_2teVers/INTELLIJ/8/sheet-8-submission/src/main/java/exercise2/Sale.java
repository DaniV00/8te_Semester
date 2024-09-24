package exercise2;

import java.time.LocalDate;
import java.util.List;

public record Sale(String sort, LocalDate dateTime, String location) {

    public void saveSales(List<Sale> sales, String fileName){



    }


}
