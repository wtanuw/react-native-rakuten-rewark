import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-rakuten-rewark??' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const RakutenReward = NativeModules.RakutenReward
  // ? NativeModules.RakutenReward
  // : new Proxy(
  //     {},
  //     {
  //       get() {
  //         throw new Error(LINKING_ERROR);
  //       },
  //     }
  //   );

export function multiply(a: number, b: number): Promise<number> {
  return RakutenReward.multiply(a, b);
}

export default RakutenReward;
export {RakutenReward};

const { CalendarModule } = NativeModules;
export {CalendarModule};
interface CalendarInterface {
   createCalendarEvent(name: string, location: string): void;
}
export {CalendarModule as CalendarInterface};

const { RNNativeToastLibrary } = NativeModules;
export {RNNativeToastLibrary};