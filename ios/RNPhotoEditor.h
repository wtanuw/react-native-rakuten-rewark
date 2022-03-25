
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import <UIKit/UIKit.h>
// @import iOSPhotoEditor;
@class iOSPhotoEditor;
@protocol PhotoEditorDelegate;
@class PhotoEditorViewController;

@interface RNPhotoEditor : NSObject <RCTBridgeModule, PhotoEditorDelegate>

@end
