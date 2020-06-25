package RCC.utils;

import RCC.testBase.TestBase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ExcelDataReader extends TestBase {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;


    public  static Object[][] getExcelData(String filepath,String SheetName) throws Exception
    {

        String [][] list=null;

            FileInputStream data=new FileInputStream(filepath);
            ExcelWBook=new XSSFWorkbook(data);
            ExcelWSheet=ExcelWBook.getSheet(SheetName);
            int Startrow,StartCol;
            Startrow=1;
            StartCol=0;
            int lastrow=ExcelWSheet.getLastRowNum();
            int totalcolums=ExcelWSheet.getRow(0).getPhysicalNumberOfCells();

        //System.out.println(totalcolums);
        //System.out.println(lastrow);
            int rn,cn;
             list=new String[lastrow][totalcolums];
            rn=0;
            for(int i=Startrow;i<=lastrow;i++,rn++)
            {
                cn=0;
                for(int j=StartCol;j<totalcolums;j++,cn++)
                {
                    //System.out.println(lastrow);
                    Cell=ExcelWSheet.getRow(i).getCell(j);
                    String celldata=Cell.getStringCellValue();
                    //System.out.println(celldata);
                    list[rn][cn]=celldata;
                }
            }


        return (list);
    }

    public static String getCellData(int i,int j)
    {

            Cell=ExcelWSheet.getRow(i).getCell(j);
            String celldata=Cell.getStringCellValue();

            return celldata;


    }

    @DataProvider(name = "PodmoveData")

    public static Object[][] PodmoveData() throws Exception {
        //Object[][] podarray= ExcelDataReader.getExcelData("D:\\OCIAutomation\\Testdata.xlsx","Podmovelist");
        //return (podarray);
        Object PodmoveData[][]=ExcelDataReader.getExcelData("D:\\OCIAutomation\\Testdata.xlsx","podmovelist");
        return (PodmoveData);

    }

    @Test
    public void test() throws Exception
    {
        Object[][]test;
        test=ExcelDataReader.getExcelData("D:\\OCIAutomation\\Testdata.xlsx","podmovelist");

    }
}
