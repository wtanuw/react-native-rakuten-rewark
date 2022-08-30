#import "RakutenRewark.h"
#import "IOSNativeToast.h"
#import <RakutenRewardSDK/RakutenRewardSDK-Swift.h>

@interface RakutenRewark()

@property (nonatomic, retain) IOSNativeToast *toast;

@end

@implementation RakutenRewark

RCT_EXPORT_MODULE()

// Example method
// See // https://reactnative.dev/docs/native-modules-ios
RCT_REMAP_METHOD(multiply,
                 multiplyWithA:(nonnull NSNumber*)a withB:(nonnull NSNumber*)b
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)
{
  NSNumber *result = @([a floatValue] * [b floatValue]);

  resolve(result);
}

- (instancetype)init {
    self = [super init];
    if (self) {
        self.toast = [[IOSNativeToast alloc] init];
    }
    return self;
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(show:(NSString *)text)
{
    [self.toast showToast:text];
}

RCT_EXPORT_METHOD(toast:(NSString *)text)
{
    [self.toast showToast:text];
}

RCT_EXPORT_METHOD(showL:(NSString *)text)
{
    [self.toast showToast:text duration:3.5];
}

RCT_EXPORT_METHOD(showS:(NSString *)text)
{
    [self.toast showToast:text duration:2.0];
}

+(void)startSessionWithAppCode:(NSString *)appCode
{
  [[RakutenReward sharedInstance] startSessionWithAppCode:appCode];
}


RCT_EXPORT_METHOD(reactStartSessionWithAppCode:(NSString *)appCode)
{
    [self startSessionWithAppCode:appCode];
}

RCT_EXPORT_METHOD(reactGetInfo:(RCTResponseSenderBlock)callback)
{
    NSString *appCode = [[RakutenReward sharedInstance] getAppCode];
    NSString *version = [[RakutenReward sharedInstance] getVersion];
    RakutenRewardStatus status = [[RakutenReward sharedInstance] getStatus];
    BOOL isOptedOut = [[RakutenReward sharedInstance] isOptedOut];
    BOOL isUIEnabled = [[RakutenReward sharedInstance] isUIEnabled];
    
    NSMutableDictionary *dict = [NSMutableDictionary new];
    dict[@"appCode"] = appCode;
    dict[@"version"] = version;
    dict[@"status"] = [NSNumber numberWithInt:status];
    dict[@"isOptedOut"] = [NSNumber numberWithBool:isOptedOut];
    dict[@"isUIEnabled"] = [NSNumber numberWithBool:isUIEnabled];
    
    if (status == RakutenRewardStatusOnline) {
        dict[@"statusName"] = @"RakutenRewardStatusOnline";
    } else if (status == RakutenRewardStatusOffline) {
        dict[@"statusName"] = @"RakutenRewardStatusOffline";
    } else if (status == RakutenRewardStatusAppCodeInvalid) {
        dict[@"statusName"] = @"RakutenRewardStatusAppCodeInvalid";
    }

    
    User *user = [[RakutenReward sharedInstance] getUser];
        if (user) {
            dict[@"getPoint"] = [NSNumber numberWithLong:[user getPoint]];
            dict[@"getUnclaimed"] = [NSNumber numberWithLong:[user getUnclaimed]];
            dict[@"isSignin"] = [NSNumber numberWithBool:[user isSignin]];
            dict[@"getAchievementsList"] = [user getAchievementsList];
            
        } else {
      }
      callback(@[dict]);
}

RCT_EXPORT_METHOD(reactLogActionWithActionCode:(NSString *)actionCode)
{
    [self logActionWithActionCode:actionCode];
}

RCT_EXPORT_METHOD(reactOnStart)
{
}

RCT_EXPORT_METHOD(reactOpenPortal)
{
    [self openPortal];
}

RCT_EXPORT_METHOD(mainActivityOpenPortal)
{
    [self openPortal];
}

RCT_EXPORT_METHOD(reactOpenAdPortal)
{
    [self openAdPortalWithDelegate:self];
}

RCT_EXPORT_METHOD(reactOpenSignin)
{
    [self openSignin];
}

//RCT_EXPORT_METHOD(findEvents:(RCTResponseSenderBlock)callback)
//{
////  NSArray *events = ...
////  callback(@[[NSNull null], events]);
//}
//RCT_EXPORT_METHOD(getUnclaimed:(RCTResponseSenderBlock)callback)
//{
//  NSInteger unclaimeCount = [[[RakutenReward sharedInstance] getUser] getUnclaimed];
//  callback(@[[NSNumber numberWithLong:unclaimeCount]]);
//}

//RCT_EXPORT_METHOD(getStatus:(RCTResponseSenderBlock)callback)
//{
//  RakutenRewardStatus status = [[RakutenReward sharedInstance] getStatus];
//  callback(@[[NSNumber numberWithLong:status]]);
//}
//
//// getVersion
//RCT_EXPORT_METHOD(getVersion:(RCTResponseSenderBlock)callback)
//{
//  NSString *version = [[RakutenReward sharedInstance] getVersion];
//  callback(@[version]);
//}
//
//// isOptedOut
//RCT_EXPORT_METHOD(isOptedOut:(RCTResponseSenderBlock)callback)
//{
//  Boolean isOptedout = [[RakutenReward sharedInstance] isOptedOut];
//  callback(@[[NSNumber numberWithBool:isOptedout]]);
//}
//
//// isUIEnabled
//RCT_EXPORT_METHOD(isUIEnabled:(RCTResponseSenderBlock)callback)
//{
//  Boolean isUIEnabled = [[RakutenReward sharedInstance] isUIEnabled];
//  callback(@[[NSNumber numberWithBool:isUIEnabled]]);
//}
//
//// User クラス
//RCT_EXPORT_METHOD(getUser:(RCTResponseSenderBlock)callback)
//{
//}
//RCT_EXPORT_METHOD(getAppCode:(RCTResponseSenderBlock)callback)
//{
//    RakutenRewardAds *ad = [RakutenRewardAds sharedInstance];
//    NSString *appcode = [ad getAppCode];
//      callback(@[appcode]);
//
//}

/* MissionAchievementData クラス */

// プロパティ	型	説明
// name	String	ミッション名
// iconUrl	String	アイコン画像の URL
// instruction	String	ミッションの説明
// action	String	アクションコード
// notificationType	String	通知タイプ
// achievedDate	Date	ミッション達成日
// point	Int	達成時に得られるポイント数
// custom	Bool	通知タイプが Custom の場合は true, それ以外の場合は false
// RakutenRewardDelegate
// RakutenRewardDelegate は、下記のメソッドを定義したプロトコルです。 これを実装することにより、ステータスやユーザ情報の変更、ミッションの達成等があった場合に通知を受け取ることがで きます。

// public protocol RakutenRewardDelegate {
//   optional func didSDKStateChange(status: RakutenRewardStatus)
//   optional func didUpdateUnclaimedAchievement(missionAchievement: MissionAchievementData)
//   optional func didUpdateUser(user: User) 
// }
// 実装方法
// 上記の通知を受け取りたい場合、下記の例を参考に RakutenRewardDelegate の実装を行なってください。

// Swift
// public class ViewController : RakutenRewardDelegate { 
//   override func viewDidLoad() {
//     RakutenReward.sharedInstance.delegate = self 
//   }
// }
// Objective-C
// @interface ViewController : UIViewController<RakutenRweardDelegate> { }
// @implementation ViewController {
//  - (void) viewDidLoad {
//   [super viewDidLoad];
//   [RakutenReward sharedInstance].delegate = self;
//  }
// }
// didUpdateUser(user: User)
// didUpdateUser メソッドはユーザ情報に変更があった時に呼ばれます。 (例:ユーザがログイン又はログアウトした時)

// didUpdateUnclaimedAchievement(missionAchievemnet: MissionAchievementData)
// didUpdateUnclaimedAchievement メソッドは、ユーザがミッションを達成した際に呼ばれます。 ミッションの達成通知 UI をカスタムに設定している場合、 このメソッド内に独自 UI を表示する処理を 実装することで、独自 UI を表示することができます。

// Swift
// func didUpdateUnclaimedAchievement(missionAchievement: MissionAchievementData) { 
//   if (missionAchivement.isCustom()) {
//     // Show Custom UI here 
//   }
// }
// Objective-C
// - (void) didUpdateUnclaimedAchievement: (MissionAchievementData *)missionAchievement {
//   switch(status) {
//     case RakutenRewardStatusOnline:
//       [[RakutenReward sharedInstance] logAction:@"actionCodeOfLaunchMission"];
//       break;
//     case RakutenRewardStatusOffline:
//       break;
//     case RakutenRewardStatusAppCodeInvalid:
//       break;
//   }   
// }
// didSDKStateChange(status: RakutenRewardStatus)
// didSDKStateChange メソッドは RakutenRewardStatus の値に変更があった時に呼ばれます。 例えば1 日1回、初回起動時にミッションを達成させたい場合、didSDKStateChange を利用して実装することが可能です。 下記のように、ステータスが Online になったタイミングを検知して、logAction メソッ ドを呼んでください。 ※1日1回等の判定は別途必要です

// Swift
// func didSDKStateChange(status: RakutenRewardStatus) { 
//   switch(status) {
//     case .Online: RakutenReward.sharedInstance.logAction(actionCodeOfLaunchMission) break
//     case .Offline: break
//     case .AppCodeInvalid: break
//   }
// }
// Objective-C
// - (void) didUpdateUnclaimedAchievement: (MissionAchievementData *)missionAchievement {
//   switch(status) {
//     case RakutenRewardStatusOnline:
//       [[RakutenReward sharedInstance] logAction:@"actionCodeOfLaunchMission"];
//       break;
//     case RakutenRewardStatusOffline:
//       break;
//     case RakutenRewardStatusAppCodeInvalid:
//       break; 
//   }
// }
// ミッション達成通知にカスタムのUIを実装する方法
// アクションを送信する
// RakutenReward.sharedInstance.logAction(actionCode: "Example")
// RakutenRewardDelegateの didUpdateUnclaimedAchievement でミッション達成の通知を受け取る
// RakutenRewardDelegate {
//     didUpdateUnclaimedAchievement(_ missionAchievement: MissionAchievementData)
// }
// didUpdateUnclaimedAchievement で UI を表示するコードを実装する
// func didUpdateUnclaimedAchievement(missionAchievement: MissionAchievementData) {
 
//     // UIの表示/非表示設定を確認します
//     guard RewardConfiguration.isUserSettingUIEnabled else {
//       return
//     }
 
//     //  ノーティフィケーションタイプがカスタムであるかどうかを確認 
//     if missionAchievement.isCustom() {
//       // カスタムUIをメインスレッドで表示させる
//     }
// }
// ポイントは、missionAchievement オブジェクトの claim メソッドをコールすることでできます

// func didUpdateUnclaimedAchievement(missionAchievement: MissionAchievementData) {
//     // UIのコードは書いておく
//     // この操作は、例えばユーザーがクレイムのためのボタンを押したときなどにご使用ください
//     missionAchievement.claim()
// }
// ミッションが複数ある場合
// actionCode により分類することで複数のミッションで異なるUIを表示させることができます

// func didUpdateUnclaimedAchievement(missionAchievement: MissionAchievementData) {
 
//     // UIの表示/非表示設定を確認します
//     guard RewardConfiguration.isUserSettingUIEnabled else {
//       return
//     }
 
 
//     //  ノーティフィケーションタイプがカスタムであるかどうかを確認
//     if missionAchievement.isCustom() {
//       if missionAchievement.getAction() == "ExampleMission1ActionCode" {
//         // ExampleMission1ActionCodeに対応するUIを表示させる
//       } else {
//         // 違うUIを表示させる
//       }
//     }
// }
// 広告ポータルの実装
// こちらの機能はSDKバージョン8.3.0以降になります。

 
// 広告ポータルを開く
// openAdPortal(delegate: AdPortalDelegate)

// Swift
// RakutenReward.sharedInstance.openAdPortal(delegate: self)
// Objective-C
// [[RakutenReward sharedInstance] openAdPortalWithDelegate:self];
// AdPortalDelegateについて
// 広告ポータルのイベントのコールバックを受け取ることができます

// public protocol AdPortalDelegate {
//     optional func didOpenAdPortal()
//     optional func didFailOpenAdPortal(error: OpenAdPortalError)
//     optional func didCloseAdPortal()
// }
// OpenAdPortalError
// didFailOpenAdPortal メソッドでのエラータイプになります。

// public enum OpenAdPortalError : Int  {

//       case AppCodeInvalid

//       case URLInvalid

// }
// ステータス	説明
// AppCodeInvalid	アプリキーが無効です
// URLInvalid	URLが無効です
// 実装例
// Swift
// extension ViewController: AdPortalDelegate {
//     func didOpenAdPortal() {}
//     func didFailOpenAdPortal(error: OpenAdPortalError) {
//         switch error {
//         case .AppCodeInvalid:
//             break
//         case .URLInvalid:
//             break
//         }
//     }
//      func didCloseAdPortal() {}
// }
// Objetive-C
// [[RakutenReward sharedInstance] openAdPortalWithDelegate:self];
// - (void)didOpenAdPortal {}
// - (void)didFailOpenAdPortalWithError:(enum OpenAdPortalError)error {
//     switch (error) {
//         case OpenAdPortalErrorURLInvalid:
//             break;
//         case OpenAdPortalErrorAppCodeInvalid:
//             break;
//     }
// }
// - (void)didCloseAdPortal {}
// その他の機能について
// 楽天会員のサインインページの表示 をコードから行う
// Swift
// RakutenReward.sharedInstance.openSignin()
// Objective-C
// [[RakutenReward sharedInstance] openSignin];
// 位置情報の設定について
// 楽天リワードでは広告の最適化のため位置情報の取得を行なっていますが、これを開発者様側の設定でオフにすることが 可能です。 ※こちらの機能はVer 6.0.2は無効となっております。(位置情報の取得はSDKでは行なっておりません)

// Swift
// RewardConfiguration.enableManualLocationPermissionRequest = true
// RakutenReward.sharedInstance.startSession(appCode: "YOUR_APPLICATION_KEY")
// Objective-C
// [RewardConfiguration setEnableManualLocationPermissionRequest:YES];
// [[RakutenReward sharedInstance] startSessionWithAppCode:@"YOUR_APPLICATION_KEY"];
// これらのAPIはリワードSDKの初期化の前に呼び出す必要があります。
// - (dispatch_queue_t)methodQueue
// {
//     return dispatch_get_main_queue();
// }
@end

@implementation RakutenRewark(AdPortalDelegate)

- (void)didOpenAdPortal
{
    NSLog(@"aaa 999");
}

- (void)didFailOpenAdPortalWithError:(OpenAdPortalError)error
{
    NSLog(@"bbb %ld",(long)error);
}

- (void)didCloseAdPortal
{
    NSLog(@"ccc 999");
}

@end




@implementation RakutenRewark(MissionAchievementData)

- (void)claim
{
    
}
- (NSString * _Nullable)getAction
{
    return [[MissionAchievementData alloc] init].getAction;
}

- (NSString * _Nullable)getInstruction
{
    return [[MissionAchievementData alloc] init].getInstruction;
}

- (NSString * _Nullable)getIconUrl
{
    return [[MissionAchievementData alloc] init].getIconUrl;
}

- (NSString * _Nullable)getNotificationType
{
    return [[MissionAchievementData alloc] init].getNotificationType;
}

- (NSString * _Nullable)getName
{
    return [[MissionAchievementData alloc] init].getName;
}

- (NSDate * _Nullable)getAchievedDate
{
    return [[MissionAchievementData alloc] init].getAchievedDate;
}

- (NSNumber * _Nullable)getPoint
{
    return [[MissionAchievementData alloc] init].getPoint;
}

- (BOOL)isCustom
{
    return [[MissionAchievementData alloc] init].isCustom;
}

- (void)setActionWithAction:(NSString * _Nonnull)action
{
    
}

- (void)setAchievedDateStrWithAchievedDateStr:(NSString * _Nullable)achievedDateStr
{
    
}

@end

// SWIFT_CLASS("_TtC16RakutenRewardSDK13RakutenAdView")
// @interface RakutenAdView : UIView
// @property (nonatomic) enum RAdSize adSize;
// @property (nonatomic, copy) NSString * _Nullable keyword;
// @property (nonatomic, copy) NSString * _Nullable locationId;
// @property (nonatomic, weak) id <RakutenADBannerViewDelegate> _Nullable delegate;
// - (void)awakeFromNib;
// /// updateConstraints on UIView
// - (void)updateConstraints;
// - (nonnull instancetype)initWithFrame:(CGRect)frame OBJC_DESIGNATED_INITIALIZER;
// - (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)coder OBJC_DESIGNATED_INITIALIZER;
// @end
//
// enum RakutenMissionEventTrackingType : NSInteger;
//
// SWIFT_CLASS("_TtC16RakutenRewardSDK19RakutenMissionEvent")
// @interface RakutenMissionEvent : NSObject
// SWIFT_CLASS_PROPERTY(@property (nonatomic, class, strong) RakutenMissionEvent * _Nonnull shared;)
// + (RakutenMissionEvent * _Nonnull)shared SWIFT_WARN_UNUSED_RESULT;
// + (void)setShared:(RakutenMissionEvent * _Nonnull)value;
// - (nonnull instancetype)init SWIFT_UNAVAILABLE;
// + (nonnull instancetype)new SWIFT_UNAVAILABLE_MSG("-init is unavailable");
// - (void)logActionWithEventCode:(NSString * _Nonnull)eventCode eventTrackingType:(enum RakutenMissionEventTrackingType)eventTrackingType parameters:(NSDictionary<NSString *, id> * _Nullable)parameters;
// @end

@implementation RakutenRewark(RakutenReward)
// SWIFT_CLASS_PROPERTY(@property (nonatomic, class, readonly, strong) RakutenReward * _Nonnull sharedInstance;)
// + (RakutenReward * _Nonnull)sharedInstance SWIFT_WARN_UNUSED_RESULT;
// @property (nonatomic, weak) id <RakutenRewardDelegate> _Nullable delegate;
// @property (nonatomic) BOOL isDebug;
// @property (nonatomic, copy) NSString * _Nullable advertisingID;

- (void)startSessionWithAppCode:(NSString *)appCode
{
    [[RakutenReward sharedInstance] startSessionWithAppCode:appCode];
    [[RakutenReward sharedInstance] setDelegate:self];
}

- (void)logActionWithActionCode:(NSString * _Nonnull)actionCode
{
    [[RakutenReward sharedInstance] logActionWithActionCode:actionCode];
}

- (void)logActionWithActionCode:(NSString * _Nonnull)actionCode isQueueEnabled:(BOOL)isQueueEnabled
{
    [[RakutenReward sharedInstance] logActionWithActionCode:actionCode isQueueEnabled:isQueueEnabled];
}

 - (void)openPortal
{
    [[RakutenReward sharedInstance] openPortal];
}

 - (void)openAdPortalWithDelegate:(id <AdPortalDelegate> _Nullable)delegate
{
    [[RakutenReward sharedInstance] openAdPortalWithDelegate:delegate];
}

- (void)openSignin
{
    [[RakutenReward sharedInstance] openSignin];
}


- (void)doSignInUsername:(NSString * _Nonnull)username password:(NSString * _Nonnull)password delegate:(id <RakutenRewardSessionDelegate> _Nullable)delegate
{
    [[RakutenReward sharedInstance] doSignInUsername:username password:password delegate:delegate];
}

- (void)cancelSignIn
{
    [[RakutenReward sharedInstance] cancelSignIn];
}

- (void)doSignOutWithDelegate:(id <RakutenRewardSessionDelegate> _Nullable)delegate
{
    [[RakutenReward sharedInstance] doSignOutWithDelegate:delegate];
}

- (void)cancelSignOut
{
    [[RakutenReward sharedInstance] cancelSignOut];
}

- (void)addBlockListURLWithUrlSet:(NSSet<NSString *> * _Nonnull)urlSet
{
    [[RakutenReward sharedInstance] addBlockListURLWithUrlSet:urlSet];
}


- (void)updateMissionList
{
    [[RakutenReward sharedInstance] updateMissionList];
}

- (NSString * _Nullable)getAppCode SWIFT_WARN_UNUSED_RESULT
{
    return [[RakutenReward sharedInstance] getAppCode];
}

- (enum RakutenRewardStatus)getStatus SWIFT_WARN_UNUSED_RESULT
{
    return [[RakutenReward sharedInstance] getStatus];
}

- (User * _Nullable)getUser SWIFT_WARN_UNUSED_RESULT
{
    return [[RakutenReward sharedInstance] getUser];
}

- (NSString * _Nonnull)getVersion SWIFT_WARN_UNUSED_RESULT
{
    return [[RakutenReward sharedInstance] getVersion];
}


- (BOOL)isOptedOut SWIFT_WARN_UNUSED_RESULT
{
    return [[RakutenReward sharedInstance] isOptedOut];
}

- (BOOL)isUIEnabled SWIFT_WARN_UNUSED_RESULT
{
    return [[RakutenReward sharedInstance] isUIEnabled];
}

- (void)setUIEnabledWithEnabled:(BOOL)enabled
{
    return [[RakutenReward sharedInstance] setUIEnabledWithEnabled:enabled];
}

- (void)didUpdateLocationWithLongitude:(double)longitude latitude:(double)latitude timeStamp:(NSDate * _Nonnull)timeStamp
{
    [[RakutenReward sharedInstance] didUpdateLocationWithLongitude:longitude latitude:latitude timeStamp:timeStamp];
}

@end

@implementation RakutenRewark(RakutenRewardDelegate)

- (void)didSDKStateChange:(enum RakutenRewardStatus)status
{
    NSLog(@"111");
}

- (void)didUpdateUnclaimedAchievement:(MissionAchievementData * _Nonnull)missionAchievement
{
    NSLog(@"222");
}

- (void)didUpdateUser:(User * _Nonnull)user
{
    NSLog(@"333");
}

@end


@implementation RakutenRewark(RakutenRewardSessionDelegate)

 - (void)didFinishSignIn
{
    NSLog(@"444");
}

 - (void)didFailSignInError:(enum RewardSessionErrorCode)error
{
    NSLog(@"555");
}

- (void)didFinishSignOut
{
    NSLog(@"666");
}

- (void)didFailSignOutWithError:(enum RewardSessionErrorCode)error
{
    NSLog(@"777");
}

- (void)didFailCancelSignOutWithError:(enum RewardSessionErrorCode)error
{
    NSLog(@"888");
}

- (void)didFailCancelSignInError:(enum RewardSessionErrorCode)error
{
    NSLog(@"999");
}

@end

@implementation RakutenRewark(RakutenADBannerViewDelegate)

- (void)didReceiveAdWithBannerView:(RakutenADBannerView * _Nonnull)bannerView
{
    
}

- (void)didFailToReceiveAdWithBannerView:(RakutenADBannerView * _Nonnull)bannerView message:(NSString * _Nonnull)message code:(enum RADErrorCode)code
{
    
}

- (void)didClickAdWithBannerView:(RakutenAdView * _Nonnull)bannerView
{
    
}

- (void)adVisibleStatusUpdatedWithVisible:(BOOL)visible
{
    
}

@end

 @protocol RakutenADInterstitialDelegate;
 @class NSBundle;

// SWIFT_CLASS_NAMED("RewardAdInterstitial")
// @interface RakutenADInterstitial : UIViewController
// @property (nonatomic, copy) NSString * _Nonnull locationId;
// @property (nonatomic, weak) UIViewController * _Nullable rootViewController;
// @property (nonatomic, weak) id <RakutenADInterstitialDelegate> _Nullable delegate;
// - (void)viewDidLoad;
// - (void)viewDidAppear:(BOOL)animated;
// - (void)loadAd:(BOOL)showing;
// /// Showing Interstitial on top
// /// Main Queue already been handle
// - (void)showAd;
// @property (nonatomic, readonly) BOOL shouldAutorotate;
// @property (nonatomic, readonly) UIInterfaceOrientationMask supportedInterfaceOrientations;
// + (RakutenADInterstitial * _Nonnull)instantiate SWIFT_WARN_UNUSED_RESULT;
// - (nonnull instancetype)initWithNibName:(NSString * _Nullable)nibNameOrNil bundle:(NSBundle * _Nullable)nibBundleOrNil OBJC_DESIGNATED_INITIALIZER;
// - (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)coder OBJC_DESIGNATED_INITIALIZER;
// @end


@implementation RakutenRewark(RakutenADInterstitialDelegate)

- (void)interstitialDidReceiveAdWithAd:(RakutenADInterstitial * _Nonnull)ad
{
    
}


- (void)interstitialDidFailToReceiveAdWithAd:(RakutenADInterstitial * _Nonnull)ad message:(NSString * _Nonnull)message code:(enum RADErrorCode)code
{
    
}

- (void)interstitialWillPresentScreenWithAd:(RakutenADInterstitial * _Nonnull)ad
{
    
}

- (void)interstitialWillDismissScreenWithAd:(RakutenADInterstitial * _Nonnull)ad
{
    
}

- (void)interstitialDidDismissScreenWithAd:(RakutenADInterstitial * _Nonnull)ad
{
    
}

- (void)interstitialWillLeaveApplicationWithAd:(RakutenADInterstitial * _Nonnull)ad
{
    
}

@end


// SWIFT_CLASS_NAMED("RewardAdbannerView")
// @interface RakutenADBannerView : RakutenAdView
// - (nonnull instancetype)initWithFrame:(CGRect)frame OBJC_DESIGNATED_INITIALIZER;
// - (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)coder SWIFT_UNAVAILABLE;
// - (void)load;
// - (void)loadWithAdSize:(enum RAdSize)adSize;
// - (void)didMoveToSuperview;
// - (void)didMoveToWindow;
// @end


// SWIFT_CLASS("_TtC16RakutenRewardSDK19RewardConfiguration")
// @interface RewardConfiguration : NSObject
// - (nonnull instancetype)init SWIFT_UNAVAILABLE;
// + (nonnull instancetype)new SWIFT_UNAVAILABLE_MSG("-init is unavailable");
// /// set variable to true, Reward SDK will not request location permission at beginning of the app
// /// default is false
// SWIFT_CLASS_PROPERTY(@property (nonatomic, class) BOOL enableManualLocationPermissionRequest;)
// + (BOOL)enableManualLocationPermissionRequest SWIFT_WARN_UNUSED_RESULT;
// + (void)setEnableManualLocationPermissionRequest:(BOOL)value;
// /// if the app is tested in DEBUG mode, <code>isDebug</code> can be toggled to <code>true</code> to print more logs from Reward SDK
// /// default is false
// SWIFT_CLASS_PROPERTY(@property (nonatomic, class) BOOL isDebug;)
// + (BOOL)isDebug SWIFT_WARN_UNUSED_RESULT;
// + (void)setIsDebug:(BOOL)value;
// /// Set SDK Notification UI enabled or not
// /// The user can change this setting on Reward SDK Portal, too
// SWIFT_CLASS_PROPERTY(@property (nonatomic, class) BOOL isUserSettingUIEnabled;)
// + (BOOL)isUserSettingUIEnabled SWIFT_WARN_UNUSED_RESULT;
// + (void)setIsUserSettingUIEnabled:(BOOL)newValue;
// SWIFT_CLASS_PROPERTY(@property (nonatomic, class) BOOL isMissionEventFeatureEnabled;)
// + (BOOL)isMissionEventFeatureEnabled SWIFT_WARN_UNUSED_RESULT;
// + (void)setIsMissionEventFeatureEnabled:(BOOL)value;
// @end

// SWIFT_CLASS("_TtC16RakutenRewardSDK25RewardPortalBarButtonItem")
// @interface RewardPortalBarButtonItem : UIBarButtonItem
// - (nonnull instancetype)init OBJC_DESIGNATED_INITIALIZER;
// - (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)coder SWIFT_UNAVAILABLE;
// @end

// /// Rakuten Reward default portal button UI
// SWIFT_CLASS("_TtC16RakutenRewardSDK18RewardPortalButton")
// @interface RewardPortalButton : UIView
// @property (nonatomic, weak) IBOutlet UIButton * _Null_unspecified portalButton;
// - (void)awakeFromNib;
// - (nonnull instancetype)initWithFrame:(CGRect)frame OBJC_DESIGNATED_INITIALIZER;
// - (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)aDecoder SWIFT_UNAVAILABLE;
// - (void)layoutSubviews;
// /// Color type of button image
// @property (nonatomic) enum ColorType colorType;
// /// Position of badge
// @property (nonatomic) enum BadgePosition badgePosition;
// /// Badge position by point
// @property (nonatomic) CGPoint badgePositionPoint;
// @end











 
 
 
