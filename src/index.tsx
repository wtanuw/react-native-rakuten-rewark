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

/* Rakuten */

/* PhotoEditor */

const { RNPhotoEditor } = NativeModules

export interface PhotoEditorProps {
    path: string
    colors?: string[]
    stickers?: string[]
    hiddenControls?: ('text' | 'clear' | 'draw' | 'save' | 'share' | 'sticker' | 'crop')[]

    onDone?: (imagePath: string) => void
    onCancel?: (resultCode: number) => void
}

export class PhotoEditor {
    private static defaultProps = {
        stickers: [],
        hiddenControls: [],
        colors: [
            '#000000',
            '#808080',
            '#a9a9a9',
            '#FFFFFE',
            '#0000ff',
            '#00ff00',
            '#ff0000',
            '#ffff00',
            '#ffa500',
            '#800080',
            '#00ffff',
            '#a52a2a',
            '#ff00ff'
        ]
    }

    static Edit({
        stickers,
        hiddenControls,
        colors,
        onDone,
        onCancel,
        ...props
    }: PhotoEditorProps) {
        if (stickers === undefined) {
            stickers = this.defaultProps.stickers
        }
        if (hiddenControls === undefined) {
            hiddenControls = this.defaultProps.hiddenControls
        }
        if (colors === undefined) {
            colors = this.defaultProps.colors
        }

        if (Platform.OS === 'ios') {
          RNPhotoEditor.Edit(
            { colors, hiddenControls, stickers, ...props },
            (imagePath: string) => {
                onDone && onDone(imagePath)
            },
            (resultCode: number) => {
                onCancel && onCancel(resultCode)
            }
          )
        } else {
          RakutenRewark.Edit(
            { colors, hiddenControls, stickers, ...props },
            (imagePath: string) => {
                onDone && onDone(imagePath)
            },
            (resultCode: number) => {
                onCancel && onCancel(resultCode)
            }
          )
        }
    }
}
