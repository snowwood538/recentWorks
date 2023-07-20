package com.a1qa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ConfigModel {
    @JsonProperty
    String browser;
    @JsonProperty
    String URL;
    @JsonProperty
    int timeout;

    public ConfigModel(String nameOfBrowser, String URL, int timeout) {
        this.browser = nameOfBrowser;
        this.URL = URL;
        this.timeout = timeout;
    }

    public ConfigModel() {
    }

    public String getBrowser() {
        return browser;
    }

    public String getURL() {
        return URL;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConfigModel)) return false;
        ConfigModel that = (ConfigModel) o;
        return getTimeout() == that.getTimeout() && Objects.equals(getBrowser(), that.getBrowser()) && Objects.equals(getURL(), that.getURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrowser(), getURL(), getTimeout());
    }
}
