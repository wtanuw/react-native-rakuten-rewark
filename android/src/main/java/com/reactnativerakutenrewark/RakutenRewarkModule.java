package com.reactnativerakutenrewark;

import androidx.annotation.NonNull;
import android.content.Context;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
// import com.facebook.react.bridge.ReactApplicationContext;
// import com.facebook.react.bridge.ReactContextBaseJavaModule;
// import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;

// import java.util.ReadableMap;
// import java.util.Array;
// // import java.util.;
// import org.json.simple.JSONObject;
// import org.json.simple.JSONArray;

import com.facebook.react.bridge.LifecycleEventListener;

import jp.co.rakuten.reward.rewardsdk.api.RakutenReward;

import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardBaseActivity;
import android.os.Bundle;
import jp.co.rakuten.reward.rewardsdk.api.status.Status;
import jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser;
import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardLifecycle;
import jp.co.rakuten.reward.rewardsdk.api.RakutenRewardAds;


@ReactModule(name = RakutenRewarkModule.NAME)
public class RakutenRewarkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RakutenRewark";

    public RakutenRewarkModule(ReactApplicationContext reactContext) {
        super(reactContext);
    // reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    /**
     * Get Intent to start {@link UCropActivity}
     *
     * @return Intent for {@link UCropActivity}
     */
    private Intent mCropIntent;
    public Intent getIntent(@NonNull Context context) {
        mCropIntent.setClass(context, RakutenRewardBaseActivity.class);
        // mCropIntent.putExtras(mCropOptionsBundle);
        return mCropIntent;
    }

    public void start(@NonNull Activity activity, int requestCode) {
        activity.startActivityForResult(getIntent(activity), requestCode);
    }

    // /**
    //  * Send the crop Intent from an Activity
    //  *
    //  * @param activity Activity to receive result
    //  */
    // public void start(@NonNull Activity activity) {
    //     start(activity, REQUEST_CROP);
    // }

    // /**
    //  * Send the crop Intent from an Activity with a custom request code
    //  *
    //  * @param activity    Activity to receive result
    //  * @param requestCode requestCode for result
    //  */
    // public void start(@NonNull Activity activity, int requestCode) {
    //     activity.startActivityForResult(getIntent(activity), requestCode);
    // }

    // /**
    //  * Send the crop Intent from a Fragment
    //  *
    //  * @param fragment Fragment to receive result
    //  */
    // public void start(@NonNull Context context, @NonNull Fragment fragment) {
    //     start(context, fragment, REQUEST_CROP);
    // }

    // /**
    //  * Send the crop Intent from a support library Fragment
    //  *
    //  * @param fragment Fragment to receive result
    //  */
    // public void start(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment) {
    //     start(context, fragment, REQUEST_CROP);
    // }

    // /**
    //  * Send the crop Intent with a custom request code
    //  *
    //  * @param fragment    Fragment to receive result
    //  * @param requestCode requestCode for result
    //  */
    // @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    // public void start(@NonNull Context context, @NonNull Fragment fragment, int requestCode) {
    //     fragment.startActivityForResult(getIntent(context), requestCode);
    // }

    // /**
    //  * Send the crop Intent with a custom request code
    //  *
    //  * @param fragment    Fragment to receive result
    //  * @param requestCode requestCode for result
    //  */
    // public void start(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment, int requestCode) {
    //     fragment.startActivityForResult(getIntent(context), requestCode);
    // }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void multiply(int a, int b, Promise promise) {
        promise.resolve(a * b);
    }

    public static native int nativeMultiply(int a, int b);

  @ReactMethod
  public void show(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void toast(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void showL(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void showS(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }

@ReactMethod
public void createCalendarEventp(String name, String location, Promise promise) {
    try {
        // Integer eventId = ...
        promise.resolve(name);
    } catch(Exception e) {
        promise.reject("Create Event Error", e);
    }
}

@ReactMethod
public void createCalendarEventc(String name, String location, Callback callBack) {
       callBack.invoke(name);
}

  @ReactMethod
  public void startSessionWithAppCode(String name) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, "123", Toast.LENGTH_SHORT).show();
      //  callBack.invoke("123");
  }

  @ReactMethod
  public void reactLogActionWithActionCode(String name) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
      //  callBack.invoke("123");
  }

  @ReactMethod
  public void reactGetInfo(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
      RakutenRewardUser user = RakutenReAct.getUser(context);
      WritableMap map = Arguments.createMap();
      map.putString("yourKey", "yourValue");
      map.putString("appCode", ""+RakutenReAct.getAppCode(context));
      map.putString("version", ""+RakutenReAct.getVersion(context));
      map.putString("status", ""+RakutenReAct.getStatus(context));
      map.putString("statusName", ""+RakutenReAct.getStatus(context));
      map.putString("isOptedOut", ""+RakutenReAct.isOptedOut(context));
      map.putString("isUIEnabled", ""+RakutenReAct.isUIEnabled(context));
      if (user!=null) {
      map.putString("getPoint", ""+user.getPoint());
      map.putString("getUnclaimed", ""+user.getUnclaimed());
      map.putString("isSignin", ""+user.isSignin());
      }
      // Map<String, String> dictionary = new HashMap<String, String>();
      // dictionary.put("key1", ""+user.getUnclaimed());
      // dictionary.put("key2", ""+user.getPoint());
      // dictionary.put("key3", ""+user.isSignin());
      callBack.invoke(map);
        

  }
  
  @ReactMethod
  public void reactOnStart() {
    final Activity activity = getCurrentActivity();
    RakutenRewardLifecycle.onStart(activity);
  }
  
  @ReactMethod
  public void reactAdsInit(String text) {
    final Activity activity = getCurrentActivity();
    RakutenRewardAds.initialize(text);
  }

  @ReactMethod
  public void reactOpenPortal() {
    Context context = getReactApplicationContext();
    final Activity activity = getCurrentActivity();
    
    RakutenReward.getInstance().openPortal();
  }

  @ReactMethod
  public void mainActivityOpenPortal() {
    Context context = getReactApplicationContext();
    Context reactContext = getReactApplicationContext();
    final Activity activity = getCurrentActivity();
    final RakutenRewarkListener listener = (RakutenRewarkListener)activity;
    listener.onUnclaimedAchievement();
      //  callBack.invoke("123");
Toast.makeText(context, "listener"+listener, Toast.LENGTH_SHORT).show();

  }
  @ReactMethod
  public void reactOpenAdPortal() {
    Context context = getReactApplicationContext();
    Activity activity = getCurrentActivity();
    
    // RakutenReward.getInstance().openPortal();
    // if (context!=null) {
    //   Toast.makeText(context, ""+context, Toast.LENGTH_SHORT).show();
    // } else {
    //   Toast.makeText(context, "no context", Toast.LENGTH_SHORT).show();
    // }
    // if (activity!=null) {
    //   Toast.makeText(context, ""+activity, Toast.LENGTH_SHORT).show();
    // } else {
    //   Toast.makeText(context, "no activity", Toast.LENGTH_SHORT).show();
    // }
        RakutenReAct raku = RakutenReAct.ob();
        // raku.initiateCamera(null);
        raku.openAdPortal(context, activity);
  }

  @ReactMethod
  public void reactOpenSignin() {
    Context context = getReactApplicationContext();
    Context reactContext = getReactApplicationContext();
    final Activity activity = getCurrentActivity();
      //  callBack.invoke("123");

        // RakutenReAct raku = RakutenReAct.ob();
        // raku.openSignin(context, activity);

    // start(activity, 100);
    // LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() {
//   @Override
// public void onHostResume() {
//     Context context = getReactApplicationContext();
//    // Activity `onResume`
//           // RakutenRewardLifecycle.onCreate(activity);
//           RakutenRewardLifecycle.onStart(activity);
//           // RakutenRewardLifecycle.onResume(activity);

//       boolean success = RakutenReward.getInstance().openPortal();
//     Toast.makeText(context, success+"", Toast.LENGTH_SHORT).show();

//     Toast.makeText(context, RakutenReward.getInstance()+"onHostResume", Toast.LENGTH_SHORT).show();

// }
// @Override
// public void onHostPause() {
//     Context context = getReactApplicationContext();
//    // Activity `onPause`
//     Toast.makeText(context, RakutenReward.getInstance()+"onHostPause", Toast.LENGTH_SHORT).show();

// }
// @Override
// public void onHostDestroy() {
//     Context context = getReactApplicationContext();
//    // Activity `onDestroy`
//     Toast.makeText(context, RakutenReward.getInstance()+"onHostDestroy", Toast.LENGTH_SHORT).show();
// }
// };
// getReactApplicationContext().addLifecycleEventListener(lifecycleEventListener);

  }


  @ReactMethod
  public void getUnclaimed(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, "123", Toast.LENGTH_SHORT).show();
       callBack.invoke("123");
  }

  @ReactMethod
  public void getStatus(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
      Status status = RakutenReAct.getStatus(context);
      if (status == Status.ONLINE) {
       callBack.invoke("1");
      } else if (status == Status.OFFLINE	) {
       callBack.invoke("2");
      } else if (status == Status.APPCODEINVALID		) {
       callBack.invoke("3");
      } else {
       callBack.invoke("4");
      }
  }

  @ReactMethod
  public void getVersion(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
      String version = RakutenReAct.getVersion(context);
      callBack.invoke(version);
  }

  @ReactMethod
  public void isOptedOut(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
      Boolean isOptedOut = RakutenReAct.isOptedOut(context);
      callBack.invoke(isOptedOut);
  }

  @ReactMethod
  public void isUIEnabled(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
      Boolean isUIEnabled = RakutenReAct.isUIEnabled(context);
      callBack.invoke(isUIEnabled);
  }

  @ReactMethod
  public void getUser(Callback callBack) {
    Context context = getReactApplicationContext();
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
      RakutenRewardUser user = RakutenReAct.getUser(context);
      WritableMap map = Arguments.createMap();
      map.putString("yourKey", "yourValue");
      map.putString("key1", ""+user.getUnclaimed());
      map.putString("key2", ""+user.getPoint());
      map.putString("key3", ""+user.isSignin());
      // Map<String, String> dictionary = new HashMap<String, String>();
      // dictionary.put("key1", ""+user.getUnclaimed());
      // dictionary.put("key2", ""+user.getPoint());
      // dictionary.put("key3", ""+user.isSignin());
      callBack.invoke(map);

    // public int getUnclaimed() { /* compiled code */ }

    // public void setUnclaimed(int i) { /* compiled code */ }

    // public boolean isSignin() { /* compiled code */ }

    // public void setSignin(boolean b) { /* compiled code */ }

    // public int getPoint() { /* compiled code */ }

    // public void setPoint(int i) 
  }




// @Override
// protected void onCreate(Bundle savedInstanceState) {
//     super.onCreate(savedInstanceState);

//     RakutenRewardLifecycle.onCreate(this);
// }

// @Override
// protected void onStart() {
//     super.onStart();

//     RakutenRewardLifecycle.onStart(this);
// }

// @Override
// protected void onResume() {
//     super.onResume();

//     RakutenRewardLifecycle.onResume(this);
// }

// @Override
// protected void onPause() {
//     super.onPause();
//     RakutenRewardLifecycle.onPause(this);
// }

// @Override
// protected void onDestroy() {
//     super.onDestroy();
//     RakutenRewardLifecycle.onDestroy();
// }
}
