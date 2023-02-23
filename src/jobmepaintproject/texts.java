package jobmepaintproject;

import java.awt.Color;

public class texts {
    
    int mouseX, mouseY;
    String text, fontStyle;
    int fontSize;
    Color color;
    
    public texts() {
    }

    public texts(int mouseX, int mouseY, String text, String fontStyle, int fontSize, Color color) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.text = text;
        this.fontStyle = fontStyle;
        this.fontSize = fontSize;
        this.color = color;
    }
    
    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
