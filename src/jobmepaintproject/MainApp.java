package jobmepaintproject;

import Instances.Instances;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame{

    AllToolsPanel tools;
    
    public MainApp(){
        Instances.mainApp = this;
        intiComponends();
    }
    
    public void intiComponends(){
        setTitle("Jobme Paint Project:");
        setSize(1280, 720);
        setLayout(new GridLayout(1, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        
        mainPanel.setBackground(Color.WHITE);

        drawingPanel = new DrawingGenerator(0, 140, getWidth(), getHeight());
        drawingPanel.drawPanel();

        tools = new AllToolsPanel(0, 0, getWidth(), 140);
        tools.DrawTabbedPane();
        
        mainPanel.add(tools);
        mainPanel.add(drawingPanel);
        add(mainPanel);
        
    }
    
    JPanel mainPanel = new JPanel(null);
    
    DrawingGenerator drawingPanel;  
    
    public static void main(String[] args) {
        new MainApp().setVisible(true);
    }
    
}
