#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>

@protocol RakutenRewardDelegate;
@protocol RakutenRewardSessionDelegate;
@protocol AdPortalDelegate;
#import <RakutenRewardSDK/RakutenRewardSDK-Swift.h>
@class User;

@interface RakutenRewark : RCTEventEmitter <RCTBridgeModule, RakutenRewardDelegate>

+ (void)startSessionWithAppCode:(NSString * _Nonnull)appCode;

@end

@interface RakutenRewark(RakutenRewardDelegated)<RakutenRewardDelegate>

@end

@interface RakutenRewark(RakutenRewardSessionDelegated)<RakutenRewardSessionDelegate>

@end

@interface RakutenRewark(AdPortalDelegated)<AdPortalDelegate>

@end

@interface RakutenRewark(RakutenReward)

- (void)startSessionWithAppCode:(NSString * _Nonnull)appCode;
- (void)logActionWithActionCode:(NSString * _Nonnull)actionCode;
- (void)logActionWithActionCode:(NSString * _Nonnull)actionCode isQueueEnabled:(BOOL)isQueueEnabled;
- (void)openPortal;
- (void)openAdPortalWithDelegate:(id <AdPortalDelegate> _Nullable)delegate;
- (void)openSignin;
- (void)doSignInUsername:(NSString * _Nonnull)username password:(NSString * _Nonnull)password delegate:(id <RakutenRewardSessionDelegate> _Nullable)delegate;
- (void)cancelSignIn;
- (void)doSignOutWithDelegate:(id <RakutenRewardSessionDelegate> _Nullable)delegate;
- (void)cancelSignOut;
- (void)addBlockListURLWithUrlSet:(NSSet<NSString *> * _Nonnull)urlSet;
- (void)updateMissionList;
- (NSString * _Nullable)getAppCode;
- (enum RakutenRewardStatus)getStatus;
- (User * _Nullable)getUser;
- (NSString * _Nonnull)getVersion;
- (BOOL)isOptedOut;
- (BOOL)isUIEnabled;
- (void)setUIEnabledWithEnabled:(BOOL)enabled;
- (void)didUpdateLocationWithLongitude:(double)longitude latitude:(double)latitude timeStamp:(NSDate * _Nonnull)timeStamp;
@end
