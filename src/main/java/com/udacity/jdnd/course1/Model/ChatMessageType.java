package com.udacity.jdnd.course1.Model;

public enum ChatMessageType {
  SAY("Say"),
  SHOUT("Shout"),
  WHISPER("Whisper");

  private final String displayValue;

  private ChatMessageType(String displayValue) {
    this.displayValue = displayValue;
  }

  public String getDisplayValue() {
    return this.displayValue;
  }

  static public ChatMessageType fromString(String string) {
    for (ChatMessageType messageType : ChatMessageType.values() ) {
        if (messageType.getDisplayValue().equalsIgnoreCase(string)) {
          return messageType;
        }
    }
    throw new IllegalArgumentException("No messsage type defined for given string");
  }

}
