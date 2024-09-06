package exercise2;

import exercise1.IceCream;
import org.junit.jupiter.api.*;
import util.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

public class SaleTest {
    private static final Method saveMethod = TestUtil.findAnnotatedMethod(2, 'a');
    private static final Method loadMethod = TestUtil.findAnnotatedMethod(2, 'b');

    private static String filePrefix;
    private static String file;

    private static List<Sale> sales;
    private static final Random rand = new Random();

    @BeforeAll
    static void CreateSales(){
        var path = System.getProperty("user.dir");
        filePrefix = path + "/src/test/";
        file = filePrefix + "testFile.txt";
        int numberOfSales = rand.nextInt(30,200);
        sales = new ArrayList<Sale>(numberOfSales);
        var locations = SaleLocation.values();
        var sorts = IceCream.values();

        for(int i = 0; i < numberOfSales; i++){
            var randomSort = sorts[rand.nextInt(sorts.length)];
            var randomDate = LocalDate.ofEpochDay(rand.nextInt(-100 * 365, 100 * 365) + 6000 * 365);
            var randomLocation = locations[rand.nextInt(locations.length)];
            sales.add(new Sale(randomSort.name(), randomDate, randomLocation.name()));
        }
    }

    @Test
    void testSave() throws InvocationTargetException, IllegalAccessException, IOException {
        if(saveMethod == null){
            Assertions.fail("Method to test not found");
        }
        saveMethod.invoke(null, sales, file);

        var salesTest = loadSalesHelper(file);
        Assertions.assertEquals(salesTest.size(), sales.size());
        Assertions.assertEquals(salesTest, sales);
    }

    @Test
    void testLoad() throws IOException, InvocationTargetException, IllegalAccessException {
        if(loadMethod == null){
            Assertions.fail("Method to test not found");
        }
        saveSalesHelper(sales, file);
        var object = loadMethod.invoke(null, file);
        //if(object.getClass() != ArrayList.class || ((ArrayList<?>)object).getFirst().getClass() != Sale.class)Assertions.fail("Returned type mismatch while trying to load Sales");
        var salesTest = (ArrayList<Sale>)object;
        Assertions.assertEquals(salesTest.size(), sales.size());
        Assertions.assertEquals(salesTest, sales);
    }

    public static void saveSalesHelper(List<Sale> sales, String filename) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (Sale sale : sales) {
                // build string
                String line = sale.sort() + ", " + sale.dateTime() + ", " + sale.location() + "\n";
                fileWriter.write(line);
            }
            fileWriter.flush();
        }
    }

    public static List<Sale> loadSalesHelper(String filename) throws IOException {
        var sales = new ArrayList<Sale>();

        try (FileInputStream fileReader = new FileInputStream(filename)) {
            var scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                var parts = line.split(",");
                if(parts.length != 3)break;
                sales.add(new Sale(parts[0].trim(), LocalDate.parse(parts[1].trim()), parts[2].trim()));
            }
        }catch (Exception e) {}

        return sales;
    }
}
