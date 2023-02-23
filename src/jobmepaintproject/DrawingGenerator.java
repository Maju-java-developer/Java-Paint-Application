package jobmepaintproject;

import Appreances.Appreancess;
import Instances.Instances;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingGenerator extends JPanel{
    
    int posX, posY, width, height;
    
    public DrawingGenerator() {
    }

    public DrawingGenerator(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    
        Instances.drawingGenerator = this;
    }
  
    public void drawPanel(){
        intiComponends();
    }
   
    public void intiComponends(){
        setBounds(posX, posY, width, height);
        setLayout(null);
        setBackground(Color.WHITE);
        
    }
    
    ArrayList<ArrayList<DrawLine>> linesList = new ArrayList<ArrayList<DrawLine>>();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        final Graphics2D graphics2D = (Graphics2D) g;
        
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        graphics2D.setRenderingHints(hints);
        
        graphics2D.setColor(Appreancess.fillBackgroundColor);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        
        // DrawText:
        if (Instances.tools.isTextSelected) {
            for (texts text : Instances.tools.texts) {
                graphics2D.setFont(new Font(text.getFontStyle(), 0, text.getFontSize()));
                graphics2D.setColor(text.getColor());
                graphics2D.drawString(text.getText(), text.getMouseX(), text.getMouseY());
            }
        }
        // DrawText:
        
        // Erasering Any Things:

        // Draw LinesList Before Addting When We are drawing at current time: 
        if (Instances.tools.lines != null) {
            for (int index = 0; index < Instances.tools.lines.size(); index++) {
                graphics2D.setColor(Instances.tools.lines.get(index).getLineColor());
                graphics2D.setStroke(new BasicStroke(Instances.tools.lines.get(index).getStroke()));
                if (index > 0) {
                    graphics2D.drawLine(
                            Instances.tools.lines.get(index-1).getX1()-2,
                            Instances.tools.lines.get(index-1).getY1()+30,
                            Instances.tools.lines.get(index).getX2()-2,
                            Instances.tools.lines.get(index).getY2()+30
                    );
                }
            }
        }
        // Draw LinesList Before Addting When We are drawing at current time: 

        // Draw ArraYList of Lines After Addting:
        for (int i = 0; i < Instances.tools.totalArrayList.size(); i++) {
//            System.out.println("Inner List Size: " + Instances.tools.totalArrayList.get(i).size());
            linesList.add(Instances.tools.totalArrayList.get(i));
        }

        for (int x = 0; x < linesList.size(); x++) {
            for (int y = 0; y < linesList.get(x).size(); y++) {
                graphics2D.setColor(linesList.get(x).get(y).getLineColor());
                graphics2D.setStroke(new BasicStroke(linesList.get(x).get(y).getStroke()));
                if (x != y && y > 0) {
                    graphics2D.drawLine(
                        linesList.get(x).get(y-1).getX1()-2,
                        linesList.get(x).get(y-1).getY1()+30,
                        linesList.get(x).get(y).getX2()-2,
                        linesList.get(x).get(y).getY2()+30
                    );
                }
            }
        }
        // Draw ArraYList of Lines After Addting:

        // Erasering Any Things:
        for (int index = 0; index < Instances.tools.eraserList.size(); index++) {
            graphics2D.setColor(Instances.tools.eraserList.get(index).getColor());
            graphics2D.setStroke(new BasicStroke(Instances.tools.eraserList.get(index).getEraseLenth()));
            if (index > 0) {
                graphics2D.drawLine(
                        Instances.tools.eraserList.get(index-1).getX1()-2,
                        Instances.tools.eraserList.get(index-1).getY1()+30,
                        Instances.tools.eraserList.get(index).getX2()-2,
                        Instances.tools.eraserList.get(index).getY2()+30
                );
            }
        }

//            for (int i = 0; i < Instances.tools.totalArrayList.size(); i++) {
//                for (int j = 0; j < Instances.tools.totalArrayList.get(i).size(); j++) {
//                    graphics2D.setColor(Instances.tools.lines.get(j).getLineColor());
//                    graphics2D.setStroke(new BasicStroke(Instances.tools.lines.get(j).getStroke()));
//
//                    if (j > 0) {
//                        graphics2D.drawLine(
//                                Instances.tools.lines.get(j-1).getX1()-2,
//                                Instances.tools.lines.get(j-1).getY1()+30,
//                                Instances.tools.lines.get(j).getX2()-2,
//                                Instances.tools.lines.get(j).getY2()+30
//                        );
//                    }
//                }
//            }
//        }
        
//        for (int index = 0; index < Instances.tools.lines.size(); index++) {
//            
//            graphics2D.setColor(Instances.tools.lines.get(index).getLineColor());
//            graphics2D.setStroke(new BasicStroke(Instances.tools.lines.get(index).getStroke()));
//            
//            if (index > 0) {
//                graphics2D.drawLine(
//                        Instances.tools.lines.get(index-1).getX1()-2,
//                        Instances.tools.lines.get(index-1).getY1()+30,
//                        Instances.tools.lines.get(index).getX2()-2,
//                        Instances.tools.lines.get(index).getY2()+30
//                );
//            }
//        }
        
        Instances.graphics2D = graphics2D;
    }
    
    public void drawMyLine(int xPos, int yPos, Graphics2D graphics2D){
        Ellipse2D ellip = new Ellipse2D.Double(
                xPos,
                yPos,
                xPos,
                yPos
        );
        
        graphics2D.setColor(Color.RED);
        graphics2D.draw(ellip);
    }
}