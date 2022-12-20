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

public interface RakutenRewarkListener {
    void openPortal();
    void onUnclaimedAchievement();
    // void onUnclaimedAchievement(data.MissionAchievementData missionAchievementData);

    // void onUserUpdated(jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser rakutenRewardUser);

    // void onSDKStateChanged(jp.co.rakuten.reward.rewardsdk.api.status.Status status);
}
// public class MyCustomObject {
//   // Step 1 - This interface defines the type of messages I want to communicate to my owner  
//   public interface MyCustomObjectListener {
//       // These methods are the different events and 
//       // need to pass relevant arguments related to the event triggered
//       public void onObjectReady(String title);
//       // or when data has been loaded
//       public void onDataLoaded(SomeData data);
//   }
// }