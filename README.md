
# react-native-android-dialog-picker

## Getting started

`$ npm install react-native-android-dialog-picker --save`

### Mostly automatic installation

`$ react-native link react-native-android-dialog-picker`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-android-dialog-picker` and add `RNAndroidDialogPicker.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAndroidDialogPicker.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.androiddialogpicker.RNAndroidDialogPickerPackage;` to the imports at the top of the file
  - Add `new RNAndroidDialogPickerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-android-dialog-picker'
  	project(':react-native-android-dialog-picker').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-android-dialog-picker/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-android-dialog-picker')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNAndroidDialogPicker.sln` in `node_modules/react-native-android-dialog-picker/windows/RNAndroidDialogPicker.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Android.Dialog.Picker.RNAndroidDialogPicker;` to the usings at the top of the file
  - Add `new RNAndroidDialogPickerPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNAndroidDialogPicker from 'react-native-android-dialog-picker';

// TODO: What to do with the module?
RNAndroidDialogPicker;
```
