package com.reactnativerakutenrewark;

import jp.co.rakuten.reward.rewardsdk.api.RakutenReward;
// import jp.co.rakuten.reward.rewardsdk.api.RakutenMissionEvent;
import jp.co.rakuten.reward.rewardsdk.api.RakutenRewardAds;
import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardBaseActivity;
import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardLifecycle;
import jp.co.rakuten.reward.rewardsdk.api.ui.RewardButton;
import jp.co.rakuten.reward.rewardsdk.api.ui.BadgeView;
import jp.co.rakuten.reward.rewardsdk.api.ui.RewardButtonManager;
import jp.co.rakuten.reward.rewardsdk.api.js.RakutenRewardSDKJS;
import jp.co.rakuten.reward.rewardsdk.api.status.BadgePosition;
import jp.co.rakuten.reward.rewardsdk.api.status.Status;
import jp.co.rakuten.reward.rewardsdk.api.status.RewardButtonColorType;
import jp.co.rakuten.reward.rewardsdk.api.status.RewardSigninErrorCode;
import jp.co.rakuten.reward.rewardsdk.api.data.MissionAchievementData;
import jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser;
import jp.co.rakuten.reward.rewardsdk.api.config.RewardConfiguration;
import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardListener;
import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardMissionDataListener;
import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardWebErrorListener;
import android.app.Activity;
import android.os.Bundle;

import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

public class RakutenReAct extends RakutenRewardBaseActivity {
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // ...
    RakutenRewardLifecycle.onCreate(this);
}
@Override
public void onStart() {
    super.onStart();
    // ...
        // RakutenReward.getInstance().setListener(this);
        RakutenRewardLifecycle.onStart(this);
    RakutenRewardAds.initialize("anAuY28ucmFrdXRlbi5yZXdhcmQuYW5kcm9pZC1SVGlhQWhrV0J+NHVEVnY3QkNSdF96b2NYZ2cten5TSQ==");

}

@Override
public void onResume() {
    super.onResume();
    // ...
}

@Override
public void onPause() {
    super.onPause();
    // ...
}

@Override
public void onDestroy() {
    super.onDestroy();
    // ...
}
    public void onUserUpdated(RakutenRewardUser rakutenRewardUser) {
      
     }

    public void onUnclaimedAchievement(MissionAchievementData missionAchievementData) { 
      
     }

    public void onSDKStateChanged(Status status) {
      if (status == Status.ONLINE) {
      }
    }


    public static RakutenReAct ob() {
        return new RakutenReAct();
        // return this;
    }

    public static void initiateCamera(Activity activity) {
        String actionCode = "sdsdad";
      boolean success = RakutenReward.getInstance().logAction(actionCode);
    }
    public static void logActionWithActionCode(Activity activity) {
        String actionCode = "sdsdad";
      RakutenReward.getInstance().logAction(actionCode);
    }
    public static String getAppCode(Context context) {
        String actionCode = "getAppCode";
    return RakutenRewardAds.getAppCode();
      
      }
    public void openPortal(Context context, Activity activity) {
        String actionCode = "openPortal";
    // RakutenRewardAds.initialize("vnbtjtewr");
    // RakutenRewardLifecycle.onStart(activity);
    // RakutenRewardLifecycle.onResume(activity);
    // RakutenRewardLifecycle.onPause(activity);
    // RakutenRewardLifecycle.onDestroy(activity);
    // RakutenRewardLifecycle.onSDKInitialize(activity);
    // RakutenRewardLifecycle.onSDKStarts(activity);
      boolean success = RakutenReward.getInstance().openPortal();
      // boolean success = RakutenReward.getInstance().openAdPortal(context);
      // boolean success = RakutenReward.getInstance().openSignin();
      if (success) {

      }
    // Toast.makeText(context, actionCode+success, Toast.LENGTH_SHORT).show();
    }
    public void openAdPortal(Context context, Activity activity) {
        String actionCode = "openAdPortal";
    RakutenRewardAds.initialize("anAuY28ucmFrdXRlbi5yZXdhcmQuYW5kcm9pZC1SVGlhQWhrV0J+NHVEVnY3QkNSdF96b2NYZ2cten5TSQ==");
    // RakutenRewardLifecycle.onCreate(activity);
    RakutenRewardLifecycle.onStart(activity);
      boolean success = RakutenReward.getInstance().openAdPortal(activity);
      // boolean success = RakutenReward.getInstance().openSignin();
      // if (success) {
        // Toast.makeText(context, actionCode+success, Toast.LENGTH_SHORT).show();
      // }
    }
    public void openSignin(Context context, Activity activity) {
      // RakutenRewardAds.initialize("rewr");
      // RakutenRewardLifecycle.onCreate(activity);
      // RakutenRewardLifecycle.onStart(activity);
        String actionCode = "openSignin";
      boolean success = RakutenReward.getInstance().openPortal();
      // RakutenRewardSDKJS sdkjs = new RakutenRewardSDKJS(context);
      // sdkjs.openWebViewActivityForRakutenRewardSDK("dfs");
      // boolean success = RakutenReward.getInstance().openAdPortal(context);
      // boolean success = RakutenReward.getInstance().openSignin();
      // boolean success = false;
      // Toast.makeText(context, actionCode+success, Toast.LENGTH_SHORT).show();
      RewardConfiguration.getInstance().setLocation(false);
      // RakutenReward.getInstance().openSignin();

    }

    // private RakutenReward() { /* compiled code */ }

    // public java.lang.String getVersion() { /* compiled code */ }

    // public boolean logAction(java.lang.String s) { /* compiled code */ }

    // public jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser getUser() { /* compiled code */ }

    // public jp.co.rakuten.reward.rewardsdk.api.status.Status getStatus() { /* compiled code */ }

    // public boolean openPortal() { /* compiled code */ }

    // public boolean openAdPortal(android.content.Context context) { /* compiled code */ }

    // public boolean openAdPortal(android.content.Context context, int i) { /* compiled code */ }

    // public boolean isOptedOut() { /* compiled code */ }

    // /**
    //  * @deprecated
    //  */
    // @java.lang.Deprecated
    // public boolean isUiEnabled() { /* compiled code */ }

    // public void setListener(jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardListener rakutenRewardListener) { /* compiled code */ }

    // @androidx.annotation.Nullable
    // public jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardWebErrorListener getWebErrorListener() { /* compiled code */ }

    // public void setWebErrorListener(jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardWebErrorListener rakutenRewardWebErrorListener) { /* compiled code */ }

    // public boolean isNotificationPresented() { /* compiled code */ }

    // public void syncUiEnabled(boolean b) { /* compiled code */ }

    // public void setUserAgent(java.lang.String s) { /* compiled code */ }

    // public boolean isAnalytics() { /* compiled code */ }

    // public void setAnalytics(boolean b) { /* compiled code */ }

    // /**
    //  * @deprecated
    //  */
    // @java.lang.Deprecated
    // public void setUiEnabled(android.content.Context context, boolean b) { /* compiled code */ }

    // public void setUser(jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser rakutenRewardUser) { /* compiled code */ }

    // @androidx.annotation.Nullable
    // public jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardListener getListener() { /* compiled code */ }

    // public void setOptedOut(boolean b) { /* compiled code */ }

    // public void setStatus(jp.co.rakuten.reward.rewardsdk.api.status.Status status) { /* compiled code */ }

    // public java.lang.String getCustomUserAgent() { /* compiled code */ }

    // /**
    //  * @deprecated
    //  */
    // @java.lang.Deprecated
    // public void syncUserData() { /* compiled code */ }

    // /**
    //  * @deprecated
    //  */
    // @java.lang.Deprecated
    // public void syncAppCode(android.app.Activity activity) { /* compiled code */ }

    // /**
    //  * @deprecated
    //  */
    // @java.lang.Deprecated
    // public void syncMissionData(jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardMissionDataListener rakutenRewardMissionDataListener) { /* compiled code */ }

    // /**
    //  * @deprecated
    //  */
    // @java.lang.Deprecated
    // public void syncAppData(android.content.Context context) { /* compiled code */ }
    
    public static Status getStatus(Context context) {
      Status status = RakutenReward.getInstance().getStatus();
      return status;
    }
    public static String getVersion(Context context) {
      String sdkVersion = RakutenReward.getInstance().getVersion();
      return sdkVersion;
    }
    public static Boolean isOptedOut(Context context) {
        String actionCode = "sdsdad";
      Boolean isOptedOut = RakutenReward.getInstance().isOptedOut();
      return isOptedOut;
    }
    public static Boolean isUIEnabled(Context context) {
        String actionCode = "sdsdad";
    Boolean isUIEnabled = RakutenReward.getInstance().isUiEnabled();
      return isUIEnabled;
    }
    public static RakutenRewardUser getUser(Context context) {
        String actionCode = "sdsdad";
      RakutenRewardUser user = RakutenReward.getInstance().getUser();
      return user;
    }
}