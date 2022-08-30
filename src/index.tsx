import { NativeModules, Platform } from 'react-native';
import RNPickerSelect from './psindex'


export {RNPickerSelect}

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
    const RakutenRewarkMission = NativeModules.RakutenRewarkMission
      ? NativeModules.RakutenRewarkMission
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
export {RakutenRewarkMission}

/* Toast */

export function mmultiply(a: number, b: number): Promise<number> {
  return RakutenRewark.multiply(a, b);
}

export function show(a: string) {
  return RakutenRewark.show(a);
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

export function startSessionWithAppCode(a: string) {
  return RakutenRewark.startSessionWithAppCode(a);
}

export function logActionWithActionCode(a: string) {
  return RakutenRewark.logActionWithActionCode(a);
}

export function openPortal(a: string) {
  return RakutenRewark.openPortal(a);
}

export function getUnclaimed(a: string) {
  return RakutenRewark.getUnclaimed(a);
}

/* Rakuten */
