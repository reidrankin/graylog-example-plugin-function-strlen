package com.example.plugins.stringreplace;

import org.graylog2.plugin.Plugin;
import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.PluginModule;

import java.util.Collection;
import java.util.Collections;

public class StringReplaceFunctionPlugin implements Plugin {
    @Override
    public PluginMetaData metadata() {
        return new StringReplaceFunctionMetaData();
    }

    @Override
    public Collection<PluginModule> modules() {
        return Collections.singleton(new StringReplaceFunctionModule());
    }
}
