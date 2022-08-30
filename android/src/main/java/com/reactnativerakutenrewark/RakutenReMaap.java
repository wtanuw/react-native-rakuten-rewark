// package com.reactnativerakutenrewark;

// import jp.co.rakuten.reward.rewardsdk.api.RakutenReward;
// import jp.co.rakuten.reward.rewardsdk.api.RakutenMissionEvent;
// import jp.co.rakuten.reward.rewardsdk.api.RakutenRewardAds;
// import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardBaseActivity;
// import jp.co.rakuten.reward.rewardsdk.api.ui.RewardButton;
// import jp.co.rakuten.reward.rewardsdk.api.ui.BadgeView;
// import jp.co.rakuten.reward.rewardsdk.api.ui.RewardButtonManager;
// import jp.co.rakuten.reward.rewardsdk.api.status.BadgePosition;
// import jp.co.rakuten.reward.rewardsdk.api.status.Status;
// import jp.co.rakuten.reward.rewardsdk.api.status.RewardButtonColorType;
// import jp.co.rakuten.reward.rewardsdk.api.status.RewardSigninErrorCode;
// import jp.co.rakuten.reward.rewardsdk.api.data.MissionAchievementData;
// import jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser;
// import jp.co.rakuten.reward.rewardsdk.api.config.RewardConfiguration;
// import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardListener;
// import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardMissionDataListener;
// import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardWebErrorListener;
// import android.app.Activity;
// import android.os.Bundle;

// import android.content.Context;
// import android.widget.Toast;

// public class RakutenReMaap extends RakutenRewardBaseActivity {
// // @Override
// // protected void onCreate(Bundle savedInstanceState) {
// //     super.onCreate(savedInstanceState);

// //     RakutenRewardLifecycle.onCreate(this);
// // }

// // @Override
// // protected void onStart() {
// //     super.onStart();

// //     RakutenRewardLifecycle.onStart(this);
// // }

// // @Override
// // protected void onResume() {
// //     super.onResume();

// //     RakutenRewardLifecycle.onResume(this);
// // }

// // @Override
// // protected void onPause() {
// //     super.onPause();
// //     RakutenRewardLifecycle.onPause(this);
// // }

// // @Override
// // protected void onDestroy() {
// //     super.onDestroy();
// //     RakutenRewardLifecycle.onDestroy();
// // }



//     public static void initiateCamera(Activity activity) {
//         String actionCode = "sdsdad";
//       RakutenReward.getInstance().logAction(actionCode);
//     }
//     public static void logActionWithActionCode(Activity activity) {
//         String actionCode = "sdsdad";
//       RakutenReward.getInstance().logAction(actionCode);
//     }
//     public static void openPortal(Context context) {
//         String actionCode = "sdsdad";
//     Toast.makeText(context, actionCode, Toast.LENGTH_SHORT).show();
//       RakutenReward.getInstance().openPortal();
//     }
//     public static void getUnclaimed(Context context) {
//         String actionCode = "sdsdad";
//     }
//     public static Status getStatus(Context context) {
//       Status status = RakutenReward.getInstance().getStatus();
//       return status;
//     }
//     public static String getVersion(Context context) {
//       String sdkVersion = RakutenReward.getInstance().getVersion();
//       return sdkVersion;
//     }
//     public static Boolean isOptedOut(Context context) {
//         String actionCode = "sdsdad";
//       Boolean isOptedOut = RakutenReward.getInstance().isOptedOut();
//       return isOptedOut;
//     }
//     public static Boolean isUIEnabled(Context context) {
//         String actionCode = "sdsdad";
//     Boolean isUIEnabled = RakutenReward.getInstance().isUiEnabled();
//       return isUIEnabled;
//     }
//     public static RakutenRewardUser getUser(Context context) {
//         String actionCode = "sdsdad";
//       RakutenRewardUser user = RakutenReward.getInstance().getUser();
//       return user;
//     }

//     // public WritableMap convertJsonToMap(JSONObject jsonObject) throws JSONException {
//     //     WritableMap map = new WritableNativeMap();

//     //     Iterator<String> iterator = jsonObject.keys();
//     //     while (iterator.hasNext()) {
//     //         String key = iterator.next();
//     //         Object value = jsonObject.get(key);
//     //         if (value instanceof JSONObject) {
//     //             map.putMap(key, convertJsonToMap((JSONObject) value));
//     //         } else if (value instanceof JSONArray) {
//     //             map.putArray(key, convertJsonToArray((JSONArray) value));
//     //             if (("option_values").equals(key)) {
//     //                 map.putArray("options", convertJsonToArray((JSONArray) value));
//     //             }
//     //         } else if (value instanceof Boolean) {
//     //             map.putBoolean(key, (Boolean) value);
//     //         } else if (value instanceof Integer) {
//     //             map.putInt(key, (Integer) value);
//     //         } else if (value instanceof Double) {
//     //             map.putDouble(key, (Double) value);
//     //         } else if (value instanceof String) {
//     //             map.putString(key, (String) value);
//     //         } else {
//     //             map.putString(key, value.toString());
//     //         }
//     //     }
//     //     return map;
//     // }

//     // public WritableArray convertJsonToArray(JSONArray jsonArray) throws JSONException {
//     //     WritableArray array = new WritableNativeArray();

//     //     for (int i = 0; i < jsonArray.length(); i++) {
//     //         Object value = jsonArray.get(i);
//     //         if (value instanceof JSONObject) {
//     //             array.pushMap(this.convertJsonToMap((JSONObject) value));
//     //         } else if (value instanceof JSONArray) {
//     //             array.pushArray(convertJsonToArray((JSONArray) value));
//     //         } else if (value instanceof Boolean) {
//     //             array.pushBoolean((Boolean) value);
//     //         } else if (value instanceof Integer) {
//     //             array.pushInt((Integer) value);
//     //         } else if (value instanceof Double) {
//     //             array.pushDouble((Double) value);
//     //         } else if (value instanceof String) {
//     //             array.pushString((String) value);
//     //         } else {
//     //             array.pushString(value.toString());
//     //         }
//     //     }
//     //     return array;
//     // }

//     // public JSONObject convertMapToJson(ReadableMap readableMap) throws JSONException {
//     //     JSONObject object = new JSONObject();
//     //     ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
//     //     while (iterator.hasNextKey()) {
//     //         String key = iterator.nextKey();
//     //         switch (readableMap.getType(key)) {
//     //             case Null:
//     //                 object.put(key, JSONObject.NULL);
//     //                 break;
//     //             case Boolean:
//     //                 object.put(key, readableMap.getBoolean(key));
//     //                 break;
//     //             case Number:
//     //                 object.put(key, readableMap.getDouble(key));
//     //                 break;
//     //             case String:
//     //                 object.put(key, readableMap.getString(key));
//     //                 break;
//     //             case Map:
//     //                 object.put(key, convertMapToJson(readableMap.getMap(key)));
//     //                 break;
//     //             case Array:
//     //                 object.put(key, convertArrayToJson(readableMap.getArray(key)));
//     //                 break;
//     //         }
//     //     }
//     //     return object;
//     // }

//     // public JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {

//     //     JSONArray array = new JSONArray();

//     //     for (int i = 0; i < readableArray.size(); i++) {
//     //         switch (readableArray.getType(i)) {
//     //             case Null:
//     //                 break;
//     //             case Boolean:
//     //                 array.put(readableArray.getBoolean(i));
//     //                 break;
//     //             case Number:
//     //                 array.put(readableArray.getDouble(i));
//     //                 break;
//     //             case String:
//     //                 array.put(readableArray.getString(i));
//     //                 break;
//     //             case Map:
//     //                 array.put(convertMapToJson(readableArray.getMap(i)));
//     //                 break;
//     //             case Array:
//     //                 array.put(convertArrayToJson(readableArray.getArray(i)));
//     //                 break;
//     //         }
//     //     }
//     //     return array;
//     // }
// }