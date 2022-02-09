#import "RakutenRewark.h"
#import "IOSNativeToast.h"

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

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

@end
