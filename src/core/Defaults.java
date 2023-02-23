package core;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class Defaults {
    
    public static ImageIcon rescaleImage(int posX, int posY, String path){

        ImageIcon icon = new ImageIcon(
                new ImageIcon(path).
                        getImage().
                        getScaledInstance(
                                posX, 
                                posY, 
                                Image.SCALE_SMOOTH)
        );
        
        return icon;
    }
    
    public static String getPath(String type, String extention){
        return new File("").getAbsolutePath() + "\\src\\res\\" + type + "."+extention;
    }
    
    
}
