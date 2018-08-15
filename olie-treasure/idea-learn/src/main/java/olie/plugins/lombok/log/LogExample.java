package olie.plugins.lombok.log;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/15 15:31
 * @Description:
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic="loggerName")
public class LogExample {

    public static void main(String... args) {
        log.error("Something's wrong here");
    }
}


