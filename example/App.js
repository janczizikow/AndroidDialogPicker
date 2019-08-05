/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, { Component } from "react";
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Button,
  ActionSheetIOS
} from "react-native";
import AndroidDialogPicker from "react-native-android-dialog-picker";

const instructions = Platform.select({
  ios: "Press Cmd+R to reload,\n" + "Cmd+D or shake for dev menu",
  android:
    "Double tap R on your keyboard to reload,\n" +
    "Shake or press menu button for dev menu"
});

type Props = {};
export default class App extends Component<Props> {
  showPicker = () => {
    if (Platform.OS === "android") {
      AndroidDialogPicker.show(
        {
          title: "Title",
          items: ["Item1", "Item2"],
          cancelText: "Cancel"
        },
        // only called when pressed on one of the items
        // won't be called if user pressed on cancel
        buttonIndex => {
          console.log(buttonIndex);
        }
      );
    } else {
      ActionSheetIOS.showActionSheetWithOptions(
        {
          title: "Test",
          options: ["item1", "item2", "Cancel"],
          cancelButtonIndex: 2
        },
        buttonIndex => {
          console.log(buttonIndex);
        }
      );
    }
  };

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>Welcome to React Native!</Text>
        <Text style={styles.instructions}>To get started, edit App.js</Text>
        <Text style={styles.instructions}>{instructions}</Text>
        <Button title="Show Me What You Got" onPress={this.showPicker} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF"
  },
  welcome: {
    fontSize: 20,
    textAlign: "center",
    margin: 10
  },
  instructions: {
    textAlign: "center",
    color: "#333333",
    marginBottom: 5
  }
});
