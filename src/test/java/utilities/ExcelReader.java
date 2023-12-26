package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    //Excel dosyasını okumak için:
    Workbook workbook;
    Sheet sheet;

    public ExcelReader (String dosyayolu, String sayfaIsmi){
        try {
            FileInputStream fis = new FileInputStream(dosyayolu);
            workbook = WorkbookFactory.create(fis);
            sheet= workbook.getSheet(sayfaIsmi);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int satir, int sutun){
        Cell cell = sheet.getRow(satir).getCell(sutun);
        return cell.toString();

    }


    // bir excel sayfasındaki son satırın indexini döndürür, bunu da stepdef yazarken for döngüsü için kullanıcam
    public int rowCount() {
        return sheet.getLastRowNum();
    }
}
