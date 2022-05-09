package com.reactnativerakutenrewark;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.facebook.react.bridge.JavaScriptModule;

public class RakutenRewarkPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new RakutenRewarkModule(reactContext));
        modules.add(new PickerModule(reactContext));
        modules.add(new DatePickerModule(reactContext));
        return modules;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        // return Collections.emptyList();
        context = reactContext;
        return Arrays.<ViewManager> asList(
                new DatePickerManager()
        );
    }
}
