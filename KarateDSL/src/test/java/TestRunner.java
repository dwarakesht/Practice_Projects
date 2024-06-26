import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//    @Karate.Test
//    Karate testSample() {
//        return Karate.run("classpath:karateTest").tags("@GetUserData");
//
//    }

    class TestRunner {

        @Test
        void testParallel() {
            Results results = Runner.path("classpath:features").tags("~@ignore")
                    .outputCucumberJson(true).parallel(5);
            generateReport(results.getReportDir());
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }

        public static void generateReport(String karateOutputPath) {
            Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
            List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
            jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
            Configuration config = new Configuration(new File("target"), "demo");
            ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
            reportBuilder.generateReports();
        }

    }
