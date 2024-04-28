package com.utdallas.capstone.props;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = "envconfig.properties")
public class CapstoneEnvironmentProp {
    private String clientSecret;
    @Value("${envconfig.properties.authorizedUsers:usmannaruhina@gmail.com}")
    private Set<String> authorizedUsers;
//    private Set<String> authorizedUsersSet = new HashSet<>(Arrays.asList(authorizedUsers.split(",")));

}
