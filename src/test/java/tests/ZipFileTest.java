package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.zip.ZipException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTest {
    @Test
    void zipWithPasswordTest() throws IOException, ZipException, net.lingala.zip4j.exception.ZipException {
        String zipFilePath = "./src/test/resources/files/1.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "123";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/1.txt";
        String expectedData = "567az";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}
