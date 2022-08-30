#import "RakutenRewarkMission.h"
#import "IOSNativeToast.h"
#import <RakutenRewardSDK/RakutenRewardSDK-Swift.h>

@interface RakutenRewarkMission()

@property (nonatomic, retain) IOSNativeToast *toast;

@end

@implementation RakutenRewarkMission

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

RCT_EXPORT_METHOD(startSessionWithAppCode:(NSString *)text)
{
  [[RakutenReward sharedInstance] startSessionWithAppCode:@"YOUR_APP_CODE"];
}

RCT_EXPORT_METHOD(logActionWithActionCode:(NSString *)text)
{
    [[RakutenReward sharedInstance] logActionWithActionCode: @"actionCode"];
}

RCT_EXPORT_METHOD(openPortal:(NSString *)text)
{
    [[RakutenReward sharedInstance] openPortal];
}

RCT_EXPORT_METHOD(getUnclaimed:(RCTResponseSenderBlock)callback)
{
  NSInteger unclaimeCount = [[[RakutenReward sharedInstance] getUser] getUnclaimed];
  callback(@[[NSNumber numberWithLong:unclaimeCount]]);
}

// @property (weak, nonatomic) IBOutlet RewardPortalButton *rewardPortalButton;
// // Change color type of button
// self.rewardPortalButton.colorType = ColorTypeDark;
// // Change image of button
// [self.rewardPortalButton.portalButton setImage:[UIImage imageNamed:@"sample_image"] forState:UIControlStateNormal];
// // Change badge position of button
// self.rewardportalButton.badgePosition = BadgePositionTopRight;



// - (dispatch_queue_t)methodQueue
// {
//     return dispatch_get_main_queue();
// }

@end
