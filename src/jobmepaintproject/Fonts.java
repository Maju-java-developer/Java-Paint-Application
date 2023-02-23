package jobmepaintproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Fonts extends JPanel{
    
    Dimension size;

    public Fonts() {
    }

    public Fonts(Dimension size) {
        this.size = size;
    }
    
    public void drawPanel(){
        intiComponends();
    }
    
    private int fontSubPanelHeight = 37;
    
    private void intiComponends(){
        setPreferredSize(new Dimension(size));
        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        
        System.out.println("PanelSize : " + (size.height / 3));

        // Font SectionPanel:
        fontSectionPanel.setPreferredSize(new Dimension(size.width, fontSubPanelHeight));
        fontSectionPanel.setBackground(Color.WHITE);
        
        fontChooseBox.setPreferredSize(new Dimension(140, fontSectionPanel.getPreferredSize().height - 5));
        fontSizeChooseBox.setPreferredSize(new Dimension(60, fontSectionPanel.getPreferredSize().height - 5));
        
        fontSizeUpPanel.setPreferredSize(new Dimension(30, fontSectionPanel.getPreferredSize().height - 5));
        fontSizeUpPanel.setBackground(fontSectionPanel.getBackground());
        
        fontSizeUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
        fontSizeUpLbl.setFont(new Font("", 0, 20));
        
        fontSizeDownPanel.setPreferredSize(new Dimension(30, fontSectionPanel.getPreferredSize().height - 5));
        fontSizeDownPanel.setBackground(fontSectionPanel.getBackground());
        
        fontSizeDownLbl.setHorizontalAlignment(SwingConstants.CENTER);
        fontSizeDownLbl.setFont(new Font("", 0, 12));

        fontSectionPanel.add(fontChooseBox);
        fontSectionPanel.add(fontSizeChooseBox);
        fontSectionPanel.add(fontSizeUpPanel);
        fontSizeUpPanel.add(fontSizeUpLbl);
        fontSizeDownPanel.add(fontSizeDownLbl);
        fontSectionPanel.add(fontSizeDownPanel);
        // Font SectionPanel:

        // Center Panel Section:
        centerPanel.setPreferredSize(new Dimension(size.width, fontSubPanelHeight));
        centerPanel.setBackground(Color.WHITE);

        boldPanel.setPreferredSize(new Dimension(35, centerPanel.getPreferredSize().height - 5));
        boldPanel.setBackground(centerPanel.getBackground());
        
        boldLbl.setHorizontalAlignment(SwingConstants.CENTER);
        boldLbl.setFont(new Font("BOLD", 0, 12));
        
        italicPanel.setPreferredSize(new Dimension(35, centerPanel.getPreferredSize().height - 5));
        italicPanel.setBackground(centerPanel.getBackground());
        italicLbl.setHorizontalAlignment(SwingConstants.CENTER);
        italicLbl.setFont(new Font("Freestyle Script", 0, 12));

        underLinePanel.setPreferredSize(new Dimension(35, centerPanel.getPreferredSize().height - 5));
        underLinePanel.setBackground(centerPanel.getBackground());
        underLineLbl.setHorizontalAlignment(SwingConstants.CENTER);

        centerPanel.add(boldPanel);
        boldPanel.add(boldLbl);
        centerPanel.add(italicPanel);
        italicPanel.add(italicLbl);
        centerPanel.add(underLinePanel);
        underLinePanel.add(underLineLbl);
        // Center Panel Section:

        // Font Section Panel:
        fontTitlePanel.setPreferredSize(new Dimension(size.width, fontSubPanelHeight));
        fontTitlePanel.setBackground(Color.WHITE);
        
        fontTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        fontTitlePanel.add(fontTitleLbl);
        // Font Section Panel:
        
        add(fontSectionPanel);
        add(centerPanel);
        add(fontTitlePanel);
    }
    
    JPanel fontSectionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
    
    JComboBox fontChooseBox = new JComboBox(Appreances.Appreancess.fontFamily);
    JComboBox fontSizeChooseBox = new JComboBox(Appreances.Appreancess.fontSizeFamily);

    JPanel fontSizeUpPanel = new JPanel(new GridLayout(1, 1));
    JLabel fontSizeUpLbl = new JLabel("A");
    
    JPanel fontSizeDownPanel = new JPanel(new GridLayout(1, 1));
    JLabel fontSizeDownLbl = new JLabel("A");

    JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING , 1, 1));
    
    JPanel boldPanel = new JPanel(new GridLayout(1, 1));
    JLabel boldLbl = new JLabel("B");
    
    JPanel italicPanel = new JPanel(new GridLayout(1, 1));
    JLabel italicLbl = new JLabel("I");
    
    JPanel underLinePanel = new JPanel(new GridLayout(1, 1));
    JLabel underLineLbl = new JLabel("U");
    
    JPanel fontTitlePanel = new JPanel(new GridLayout(1, 1));
    JLabel fontTitleLbl = new JLabel("Font");

}
