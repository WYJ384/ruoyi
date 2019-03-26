package com.ruoyi.web.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by m on 2019/3/26.
 */
@Component
@ConfigurationProperties(prefix="ruoyi")
public class RuoYiProfile {
    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}

