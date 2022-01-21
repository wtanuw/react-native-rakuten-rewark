import { NativeModules, Platform } from 'react-native';

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

// export default RakutenRewark;
// export { RakutenRewark };

// const { RakutenRewark } = NativeModules
// interface CalendarInterface {
//    toast(message);
// }
// export default RakutenRewark as CalendarInterface;
export default RakutenRewark
export {RakutenRewark}

export function mmultiply(a: number, b: number): Promise<number> {
  return RakutenRewark.multiply(a, b);
}

export function ttoast(a: string) {
  return RakutenRewark.toast(a);
}

export function sshowL(a: string) {
  return RakutenRewark.showL(a);
}

export function sshowS(a: string) {
  return RakutenRewark.showS(a);
}