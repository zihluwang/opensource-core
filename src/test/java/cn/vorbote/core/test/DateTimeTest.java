package cn.vorbote.core.test;

import cn.vorbote.core.time.TimeSpan;
import lombok.extern.slf4j.Slf4j;

/**
 * DateTimeTest<br>
 * Created at 7/30/2022 3:14 AM
 *
 * @author theod
 */
@Slf4j
public class DateTimeTest {

    public static void main(String... args) {
        TimeSpan build = TimeSpan.builder().minutes(30).build();
        System.out.println(build);
    }

}
