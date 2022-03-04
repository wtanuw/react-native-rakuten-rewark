@objc(NativeModuleManager)
class NativeModuleManager : NSObject {
    @objcfunc constantsToExport() -> [AnyHashable:Any]! {
        return ["message": "Hello from native code"]
    }
}