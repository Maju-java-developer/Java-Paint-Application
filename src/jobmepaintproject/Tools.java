package jobmepaintproject;

import Appreances.Appreancess;
import core.Defaults;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Tools extends JPanel{

    Dimension size;
    
    public Tools() {
    }

    int toolsSubPanelHeight = 40;
    int toolsSubPanelWidth = 30;
    int iconX = 20, iconY = 20;

    public Tools(Dimension size) {
        this.size = size;
    }
    
    public void drawPanel(){
        intiComponends();
    }
    
    public void intiComponends(){
        setPreferredSize(size);
        setBackground(Appreances.Appreancess.toolsPanelColor);
        setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

        pencilPanel.setPreferredSize(new Dimension(toolsSubPanelWidth,toolsSubPanelHeight));
        pencilPanel.setBackground(getBackground());
        pencilIcon.setIcon(Defaults.rescaleImage(iconX, iconY, Defaults.getPath("pencil", "png")));
        pencilIcon.setHorizontalAlignment(SwingConstants.CENTER);
        
        fillColorPanel.setPreferredSize(new Dimension(toolsSubPanelWidth,toolsSubPanelHeight));
        fillColorPanel.setBackground(getBackground());
        fillColorIcon.setIcon(Defaults.rescaleImage(iconX, iconY, Defaults.getPath("fillColor", "png")));
        fillColorIcon.setHorizontalAlignment(SwingConstants.CENTER);
        
        textPanel.setPreferredSize(new Dimension(toolsSubPanelWidth,toolsSubPanelHeight));
        textPanel.setBackground(getBackground());
        
        TextIcon.setText("A");
        TextIcon.setFont(new Font("Souge UI Light", 0, 20));
        TextIcon.setHorizontalAlignment(SwingConstants.CENTER);
                
        eraserPanel.setPreferredSize(new Dimension(toolsSubPanelWidth,toolsSubPanelHeight));        
        eraserPanel.setBackground(getBackground());
        eraserIcon.setIcon(Defaults.rescaleImage(30, 30, Defaults.getPath("eraser", "png")));
        
        colorPickerPanel.setPreferredSize(new Dimension(toolsSubPanelWidth,toolsSubPanelHeight));
        colorPickerPanel.setBackground(getBackground());
        
        colorPickerIcon.setIcon(Defaults.rescaleImage(iconX, iconY, Defaults.getPath("colorPicker", "png")));
        colorPickerIcon.setHorizontalAlignment(SwingConstants.CENTER);
        
        magnifierPanel.setPreferredSize(new Dimension(toolsSubPanelWidth,toolsSubPanelHeight));
        magnifierPanel.setBackground(getBackground());
        magnifierIcon.setIcon(Defaults.rescaleImage(iconX, iconY, Defaults.getPath("magnifier", "png")));
        magnifierIcon.setHorizontalAlignment(SwingConstants.CENTER);
        
        toolsTitlePanel.setPreferredSize(new Dimension(getPreferredSize().width, 30));
        toolsTitlePanel.setBackground(Appreancess.toolsPanelColor);
        
        toolsTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);

        pencilPanel.add(pencilIcon);
        fillColorPanel.add(fillColorIcon);
        textPanel.add(TextIcon);
        eraserPanel.add(eraserIcon);
        colorPickerPanel.add(colorPickerIcon);
        magnifierPanel.add(magnifierIcon);
        toolsTitlePanel.add(toolsTitleLbl);
        
        add(pencilPanel);
        add(fillColorPanel);
        add(textPanel);
        add(eraserPanel);
        add(colorPickerPanel);
        add(magnifierPanel);
        add(toolsTitlePanel);
    }
    
    JPanel toolsTitlePanel = new JPanel(new GridLayout(1, 1));
    JLabel toolsTitleLbl = new JLabel("Tools");
    
    JPanel pencilPanel = new JPanel(new GridLayout(1, 1));
    JLabel pencilIcon = new JLabel();
    
    JPanel fillColorPanel = new JPanel(new GridLayout(1, 1));
    JLabel fillColorIcon = new JLabel();

    JPanel textPanel = new JPanel(new GridLayout(1, 1));
    JLabel TextIcon = new JLabel();

    JPanel eraserPanel = new JPanel(new GridLayout(1, 1));
    JLabel eraserIcon = new JLabel();

    JPanel colorPickerPanel = new JPanel(new GridLayout(1, 1));
    JLabel colorPickerIcon = new JLabel();

    JPanel magnifierPanel = new JPanel(new GridLayout(1, 1));
    JLabel magnifierIcon = new JLabel();
}
