package week_6.brad.topView;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;

/**
 * Created by betterfly
 * Date : 2019.10.02
 */
public class SolutionTest {
    // 1 14 3 7 4 5 15 6 13 10 11 2 12 8 9 -> 2  1  14  15  12
    // 1 2 5 3 6 4 ->  1 2 5 6
    @Test
    public void 검증() throws IOException {
        String testJson =
                new String(Files.readAllBytes(Paths.get(getClass().getResource("/brad_topView.json").toString())));
    }
}