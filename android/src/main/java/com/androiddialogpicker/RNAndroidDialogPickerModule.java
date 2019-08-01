
package com.androiddialogpicker;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import java.util.ArrayList;
import java.util.List;

public class RNAndroidDialogPickerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private AlertDialog.Builder mBuilder;
  private AlertDialog mDialog;
  protected Callback callback;

  public RNAndroidDialogPickerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAndroidDialogPicker";
  }


  @ReactMethod
  public void show(final ReadableMap options, final Callback callback) {
    Activity currentActivity  = getCurrentActivity();
    this.callback = callback;

    if (currentActivity == null) {
      return;
    }

    if (mDialog != null) {
      mDialog.dismiss();
    }

    mBuilder = new AlertDialog.Builder(getCurrentActivity());

    if (options.hasKey("title")) {
      mBuilder.setTitle(options.getString("title"));
    }

    if (options.hasKey("items")) {
      List<String> itemsList = new ArrayList<>();
      final ReadableArray optionItems = options.getArray("items");
      for (int i = 0; i < optionItems.size(); i++) {
        final String label = optionItems.getString(i);
        itemsList.add(label);
      }

      final String[] itemsArray = itemsList.toArray(new String[0]);

      mBuilder.setItems(itemsArray, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          callback.invoke(i);
          dialogInterface.dismiss();
        }
      });
    }

    if (options.hasKey("cancelText")) {
      mBuilder.setNegativeButton(options.getString("cancelText"), new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          dialogInterface.dismiss();
        }
      });
    }

    mDialog = mBuilder.create();
    mDialog.show();
  }
}