package RCC.utils;
import RCC.testBase.TestBase;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import java.nio.file.attribute.*;

/**
 * This Java program demonstrates how to compress a directory in ZIP format.
 *
 * @author www.codejava.net
 */
public class ZipReports extends TestBase {
    public static void Reports() throws Exception {
        try {
            String sourceFile = "D:\\RCCAutomation\\Reports\\";
            FileOutputStream fos = new FileOutputStream("Reports.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
            zipOut.close();
            fos.close();
        }
        catch (Exception e)
        {

        }
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws Exception {
        try {
            if (fileToZip.isHidden()) {
                return;
            }
            if (fileToZip.isDirectory()) {
                if (fileName.endsWith("/")) {
                    zipOut.putNextEntry(new ZipEntry(fileName));
                    zipOut.closeEntry();
                } else {
                    zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                    zipOut.closeEntry();
                }
                File[] children = fileToZip.listFiles();
                for (File childFile : children) {
                    zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
                }
                return;
            }
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        } catch (Exception e) {
        }
    }
    public static void zipDeleteReports () throws Exception
    {
        try {

            File folder = new File(System.getProperty("user.dir") + "/Reports");
            File fList[] = folder.listFiles();
// Searchs .lck
            for (File s : fList) {
                String pes = s.getName();
                //System.out.println(pes);
                if (pes.contains(".html") == true) {
                    // and deletes
                    s.delete();
                    //System.out.println(s+ "Deleted");

                }
            }
        }
        catch (Exception e)
        {
        }
    }
}