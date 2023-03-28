import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
public class CSVReaderDemo {

    public static void main(String[] args)throws IOException, CsvValidationException {
        String archCSV = "C:\\Users\\Matias\\Documents";
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;
            while((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0]
                        + " | " + fila[1]
                        + " |  " + fila[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (csvReader != null) {
                    csvReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

