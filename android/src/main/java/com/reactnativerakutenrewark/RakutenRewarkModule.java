package com.reactnativerakutenrewark;

import androidx.annotation.NonNull;
import android.content.Context;
import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import com.ahmedadeltito.photoeditor.PhotoEditorActivity;

@ReactModule(name = RakutenRewarkModule.NAME)
public class RakutenRewarkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RakutenRewark";

    public RakutenRewarkModule(ReactApplicationContext reactContext) {
        super(reactContext);
    reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void multiply(int a, int b, Promise promise) {
        promise.resolve(a * b);
    }

    public static native int nativeMultiply(int a, int b);

  @ReactMethod
  public void show(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void toast(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void showL(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void showS(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }


  private static final int PHOTO_EDITOR_REQUEST = 1;
  private static final String E_PHOTO_EDITOR_CANCELLED = "E_PHOTO_EDITOR_CANCELLED";


  private Callback mDoneCallback;
  private Callback mCancelCallback;

  private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
      if (requestCode == PHOTO_EDITOR_REQUEST) {

        if (mDoneCallback != null) {

          if (resultCode == Activity.RESULT_CANCELED) {
            mCancelCallback.invoke(resultCode);
          } else {
            mDoneCallback.invoke(intent.getExtras().getString("imagePath"));
          }

        }

        mCancelCallback = null;
        mDoneCallback = null;
      }
    }
  };

  // public RNPhotoEditorModule(ReactApplicationContext reactContext) {
  //   super(reactContext);

  //   reactContext.addActivityEventListener(mActivityEventListener);

  // }


  @ReactMethod
  public void Edit(final ReadableMap props, final Callback onDone, final Callback onCancel) {
    String path = props.getString("path");

    //Process Stickers
    ReadableArray stickers = props.getArray("stickers");
    ArrayList<Integer> stickersIntent = new ArrayList<Integer>();

    for (int i = 0;i < stickers.size();i++) {
      int drawableId = getReactApplicationContext().getResources().getIdentifier(stickers.getString(i), "drawable", getReactApplicationContext().getPackageName());

      stickersIntent.add(drawableId);
    }

    //Process Hidden Controls
    ReadableArray hiddenControls = props.getArray("hiddenControls");
    ArrayList hiddenControlsIntent = new ArrayList<>();

    for (int i = 0;i < hiddenControls.size();i++) {
      hiddenControlsIntent.add(hiddenControls.getString(i));
    }

    //Process Colors
    ReadableArray colors = props.getArray("colors");
    ArrayList colorPickerColors = new ArrayList<>();

    for (int i = 0;i < colors.size();i++) {
      colorPickerColors.add(Color.parseColor(colors.getString(i)));
    }


    Intent intent = new Intent(getCurrentActivity(), PhotoEditorActivity.class);
    intent.putExtra("selectedImagePath", path);
    intent.putExtra("colorPickerColors", colorPickerColors);
    intent.putExtra("hiddenControls", hiddenControlsIntent);
    intent.putExtra("stickers", stickersIntent);


    mCancelCallback = onCancel;
    mDoneCallback = onDone;

    getCurrentActivity().startActivityForResult(intent, PHOTO_EDITOR_REQUEST);
  }


}
