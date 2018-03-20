package com.example.plugins.stringreplace;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

public class StringReplaceFunctionMetaData implements PluginMetaData {
    private static final String PLUGIN_PROPERTIES = "com.example.plugins.graylog-plugin-function-stringreplace/graylog-plugin.properties";

    @Override
    public String getUniqueId() {
        return "com.example.plugins.stringreplace.StringReplaceFunctionPlugin";
    }

    @Override
    public String getName() {
        return "String replace pipeline function";
    }

    @Override
    public String getAuthor() {
        return "John Doe <you@example.org>";
    }

    @Override
    public URI getURL() {
        return URI.create("https://github.com/YourGitHubUsername/graylog-plugin-function-stringreplace");
    }

    @Override
    public Version getVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "version", Version.from(0, 0, 0, "unknown"));
    }

    @Override
    public String getDescription() {
        return "Pipeline function that replaces characters in a string.";
    }

    @Override
    public Version getRequiredVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "graylog.version", Version.from(2, 3, 4));
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
