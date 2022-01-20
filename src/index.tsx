import { NativeModules, Platform } from 'react-native';

const { RNNativeToastLibrary } = NativeModules;

export default RNNativeToastLibrary;

const LINKING_ERROR =
  `The package 'react-native-rakuten-rewark' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const RakutenRewark = NativeModules.RakutenRewark
  ? NativeModules.RakutenRewark
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return RakutenRewark.multiply(a, b);
}
