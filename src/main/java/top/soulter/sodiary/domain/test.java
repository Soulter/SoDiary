package top.soulter.sodiary.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@ConfigurationProperties(prefix = "sodiary")
public class test {
    private String name;
    private String version;
}
