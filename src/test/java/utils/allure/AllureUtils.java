package utils.allure;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;
import static utils.reader.ConfigHandler.envProperty;
import static utils.reader.ConfigHandler.urlProperty;

public class AllureUtils {
    static String resultsPath= System.getProperty("user.dir")+ "/allure-results/";
    static String reportPath= System.getProperty("user.dir")+ "/allure-report";

    public static void cleanAllureResult(){
        try {
            FileUtils.deleteDirectory(new File(resultsPath));
            System.out.println("Allure results folder deleted successfully");

        } catch (IOException e) {
            System.out.println("Failed to delete allure result");
            throw new RuntimeException(e);

        }
    }

    public static void cleanAllureReport(){
        try {
            FileUtils.deleteDirectory(new File(reportPath));
            System.out.println("Allure Report folder deleted successfully");

        } catch (IOException e) {
            System.out.println("Failed to delete allure Report");
            throw new RuntimeException(e);

        }
    }

    public static void createAllureReportInSingleFile(){
        try {
            Runtime.getRuntime().exec("cmd /c allure generate allure-results --single-file --clean -o allure-report");
            System.out.println("Allure Report is generated successfully");
        } catch (IOException e) {

            System.out.println("Failed to generate Allure Report");
            throw new RuntimeException(e);
        }
    }

    public static void setAllureEnvironment(){
        System.out.println("Before Environment");
            allureEnvironmentWriter(
                    ImmutableMap.<String, String>builder()
                            .put("Browser", envProperty.getProperty("browser-type"))
                            .put("Java Version", envProperty.getProperty("java-version"))
                            .put("Tester", envProperty.getProperty("tester"))
                            .put("env-type", envProperty.getProperty("env-type"))
                            .put("URL", urlProperty.getProperty("base-url"))
                            .build(), resultsPath);
                             System.out.println("After Environment");
    }

    public static void addAttachmentInAllureReport(String screenName, String screenPath ){
        try {
            Allure.addAttachment(screenName, newInputStream(Path.of(screenPath)));
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    }

