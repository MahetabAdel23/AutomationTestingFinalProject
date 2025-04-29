package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private List<String[]> rows;

    public CsvReader(String filepath, int noOfColumns) throws IOException {
        rows = new ArrayList<>();
        readCsv(filepath, noOfColumns);
    }

    private void readCsv(String filepath, int noOfColumns) throws IOException {
        try (BufferedReader bfrreader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bfrreader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= noOfColumns) {
                    rows.add(data);
                }
            }
        }
    }
    public List<String[]> getRows() {
        return rows;
    }
}
