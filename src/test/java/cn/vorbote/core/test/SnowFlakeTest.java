package cn.vorbote.core.test;

import cn.vorbote.core.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * SnowFlakeTest<br>
 * Created at Jun 19, 2022 00:12:07 AM
 *
 * @author vorbote
 */
@Slf4j
public class SnowFlakeTest {

    @Test
    public void test() {
        var snowFlake = new SnowFlake(0, 0);
        for (var i = 0; i < 5; ++i) {
            var id = snowFlake.nextId();
            log.info(id + " " + String.valueOf(id).length());
        }
    }

}
