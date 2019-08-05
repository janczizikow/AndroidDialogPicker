declare module "react-native-android-dialog-picker" {
  export interface Options {
    title?: string;
    items: string[];
    cancelText?: string;
  }

  export interface AndroidDialogPicker {
    show: (
      options: Options,
      callback: (index: number) => number | void
    ) => void;
  }

  const AndroidDialogPicker: AndroidDialogPicker;
  export default AndroidDialogPicker;
}
