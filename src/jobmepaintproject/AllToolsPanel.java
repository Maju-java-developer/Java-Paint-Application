package jobmepaintproject;

import Appreances.Appreancess;
import Instances.Instances;
import core.Defaults;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AllToolsPanel extends JTabbedPane{
    
    int posX, posY, width, height;
    
    int iconX = 20, iconY = 20;
    
    int toolsSubPanelHeight = 40;
    int toolsSubPanelWidth = 30;
    
    boolean isbgColorSelected = false;
    boolean isForebgColorSelected = false;
    
    boolean isTextSelected = false;
    boolean isFillColorSelected = false;
    boolean isPecnilSelected = false;
    boolean iseraserSelected = false;
    boolean isColorPickerSelected = false;
    boolean isMagnifierSelected = false;
    
    int mouseX = 0, mouseY = 0;
    Point pencilPointX;
    Point pencilPointY;
    
    int brushLenth = 5;
    
    String textStr = "";

    ArrayList<DrawLine> lines;
    ArrayList<texts> texts = new ArrayList<texts>();
    ArrayList<ArrayList<DrawLine>> totalArrayList = new ArrayList<>();
    ArrayList<eraser> eraserList = new ArrayList<>();
    
    Fonts font;
    Tools tools;
    
    public AllToolsPanel(){}
    public AllToolsPanel(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        Instances.tools = this;
    }
    
    public void DrawTabbedPane(){
        intiComponends();
        actions();
    }
    
    public void intiComponends(){
        setBounds(posX, posY, width, height);
        // TabbedPane Main Menu:
        filePanel.setBackground(new Color(235, 235, 235));
        homePanel.setBackground(new Color(235, 235, 235));
        viewPanel.setBackground(new Color(235, 235, 235));
        
        // Font Section Panel:
        font = font = new Fonts(new Dimension(270, height));
        font.setBackground(Color.red);
        font.drawPanel();
        otherMenuSection.add(font);
        // Font Section Panel:

        // Tools Section Panel:
        tools = new Tools(new Dimension(94, height));
        tools.drawPanel();
        otherMenuSection.add(tools);
        // Tools Section Panel:

        brushLenthPanel.setPreferredSize(new Dimension(120, height));
        brushLenthPanel.setBackground(tools.getBackground());

        brushLenthSlider.setBounds(10, 35, 100, 30);
        brushLenthSlider.setBackground(brushLenthPanel.getBackground());
        brushLenthSlider.setValue(5);
        brushLenthSlider.setMinimum(1);
        brushLenthSlider.setMaximum(15);
        
        brushLenthPanel.add(brushLenthSlider);
        otherMenuSection.add(brushLenthPanel);
        
        // Other Function Section Panel:
        otherMenuSection.setPreferredSize(new Dimension(this.getWidth() / 2, this.getHeight()));
        otherMenuSection.setBackground(homePanel.getBackground());
 
        // Color Section Panel:
        colorSectionPanel.setPreferredSize(new Dimension(this.getWidth() / 2 - 10, this.getHeight()));
        colorSectionPanel.setBackground(homePanel.getBackground());
        
        bgColorContanir.setBounds(0, 0, 90, colorSectionPanel.getPreferredSize().height);
        bgColorContanir.setBackground(colorSectionPanel.getBackground());

        foreBgColorContanir.setBounds(bgColorContanir.getWidth() + 5, 0, 90, colorSectionPanel.getPreferredSize().height);
        foreBgColorContanir.setBackground(colorSectionPanel.getBackground());
        
        bgColorPanel.setBounds(10, 10, 70, 50);
        bgColorPanel.setBackground(Color.BLACK);
        
        bgColorTitle.setBounds(bgColorPanel.getX() + 20, bgColorPanel.getHeight() + bgColorPanel.getY(), 60, 20);
        bgColorTitle.setForeground(Color.BLACK);
        
        bgTypeLbl.setBounds(bgColorPanel.getX() + 30, bgColorTitle.getHeight() + bgColorTitle.getY(), 60, 20);
        bgTypeLbl.setForeground(Color.BLACK);
        
        foreBgColorPanel.setBounds(10 , 10, 60, 40);
        foreBgColorPanel.setBackground(Color.BLACK);
        
        foreBgColorTitle.setBounds(foreBgColorPanel.getX() + 15, bgColorPanel.getHeight(), 60, 20);
        foreBgColorTitle.setForeground(Color.BLACK);
        
        foreBgTypeLbl.setBounds(foreBgColorPanel.getX() + 30, bgColorTitle.getHeight() + bgColorTitle.getY() - 10, 60, 20);
        foreBgTypeLbl.setForeground(Color.BLACK);
        
        colorSectionPanel.add(colorChooser);
        colorSectionPanel.add(bgColorContanir);
        colorSectionPanel.add(foreBgColorContanir);
        
        bgColorContanir.add(bgColorPanel);
        bgColorContanir.add(bgColorTitle);
        bgColorContanir.add(bgTypeLbl);
        
        foreBgColorContanir.add(foreBgColorPanel);
        foreBgColorContanir.add(foreBgColorTitle);
        foreBgColorContanir.add(foreBgTypeLbl);
        // Color Section Panel:
        homePanel.add(otherMenuSection);
        homePanel.add(colorSectionPanel);
        // HomeMenu Section:

        addTab("Home", homePanel);
        addTab("File", filePanel);
        addTab("View", viewPanel);
        
        // TabbedPane Main Menu:
    }
    
    JPanel filePanel = new JPanel(null);
    JPanel homePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1));
    JPanel viewPanel = new JPanel(null);
    
    JPanel brushLenthPanel = new JPanel(null);
    JSlider brushLenthSlider = new JSlider();
    
    JPanel colorSectionPanel = new JPanel(null);
    
    JColorChooser colorChooser = new JColorChooser();
    
    JPanel bgColorContanir = new JPanel(null);
    
    JPanel bgColorPanel = new JPanel(null);
    JLabel bgColorTitle = new JLabel("Color");
    JLabel bgTypeLbl = new JLabel("1");

    JPanel foreBgColorContanir = new JPanel(null);
    
    JPanel foreBgColorPanel = new JPanel(null);
    JLabel foreBgColorTitle = new JLabel("Color");
    JLabel foreBgTypeLbl = new JLabel("2");

    JPanel otherMenuSection = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1));
    
    public void actions(){
        
        // Use Listener For BurshLenth For Pecnil:
        brushLenthSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                brushLenth = brushLenthSlider.getValue();
            }
        });
        // Use Listener For BurshLenth For Pecnil:

        // Use Listener For GetSelectedColor From ColorChooser:
        colorChooser.setBounds(200, - 25, 300, this.getHeight() + 80);
        colorChooser.setPreferredSize(new Dimension(300, this.getHeight()));
        colorChooser.addChooserPanel(new AbstractColorChooserPanel() {

            @Override
            public void updateChooser() {
                
                Color color = colorChooser.getColor();

                if (isbgColorSelected) {
                    bgColorPanel.setBackground(color);
                }else if (isForebgColorSelected) {
                    foreBgColorPanel.setBackground(color);
                }
            }
            @Override
            protected void buildChooser() {
            }
            @Override
            public String getDisplayName() {
                return null;
            }
            @Override
            public Icon getSmallDisplayIcon() {
                return null;
            }
            @Override
            public Icon getLargeDisplayIcon() {
                return null;
            }
        });
        // Use Listener For GetSelectedColor From ColorChooser:

        // Use Listener For Seclect Background Color Contanir:
        bgColorContanir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                isbgColorSelected = true;
                isForebgColorSelected = false;
                
                bgColorContanir.setBackground(Appreancess.enteredBgContanirColor);
                foreBgColorContanir.setBackground(colorSectionPanel.getBackground());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // Use Listener For Seclect Background Color Contanir:

        // Use Listener For Seclect ForeGround Color Contanir:
        foreBgColorContanir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {

                isbgColorSelected = false;
                isForebgColorSelected = true;
                
                foreBgColorContanir.setBackground(Appreancess.enteredBgContanirColor);
                bgColorContanir.setBackground(colorSectionPanel.getBackground());
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // Use Listener For Seclect Background Color Contanir:
        
        // Use Listener For Draw With Pencil In DrawBody:
        tools.pencilPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isTextSelected = false;
                isFillColorSelected = false;
                isPecnilSelected = true;
                iseraserSelected = false;
                isColorPickerSelected = false;
                isMagnifierSelected = false;

                tools.pencilPanel.setBackground(Appreancess.toolsSubPanelSelectedColor);
                tools.fillColorPanel.setBackground(Appreancess.toolsPanelColor);
                tools.textPanel.setBackground(Appreancess.toolsPanelColor);
                tools.eraserPanel.setBackground(Appreancess.toolsPanelColor);
                tools.colorPickerPanel.setBackground(Appreancess.toolsPanelColor);
                tools.magnifierPanel.setBackground(Appreancess.toolsPanelColor);
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                tools.pencilPanel.setBackground(Appreancess.toolsSubPanelHoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isPecnilSelected) {
                    tools.pencilPanel.setBackground(Appreancess.toolsPanelColor);
                }
            }
        });
        // Use Listener For Draw With Pencil In DrawBody:

        // Use Listener For FiilColor In DrawBody:
        tools.fillColorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isTextSelected = false;
                isFillColorSelected = true;
                isPecnilSelected = false;
                iseraserSelected = false;
                isColorPickerSelected = false;
                isMagnifierSelected = false;
                
                tools.fillColorPanel.setBackground(Appreancess.toolsSubPanelSelectedColor);
                tools.pencilPanel.setBackground(Appreancess.toolsPanelColor);
                tools.textPanel.setBackground(Appreancess.toolsPanelColor);
                tools.eraserPanel.setBackground(Appreancess.toolsPanelColor);
                tools.colorPickerPanel.setBackground(Appreancess.toolsPanelColor);
                tools.magnifierPanel.setBackground(Appreancess.toolsPanelColor);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                tools.fillColorPanel.setBackground(Appreancess.toolsSubPanelHoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isFillColorSelected) {
                    tools.fillColorPanel.setBackground(Appreancess.toolsPanelColor);
                }
            }
        });
        // Use Listener For FiilColor In DrawBody:

        // Use Listener For ShowDialog For Text:
        tools.textPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isTextSelected = true;
                isPecnilSelected = false;
                isFillColorSelected = false;
                iseraserSelected = false;
                isColorPickerSelected = false;
                isMagnifierSelected = false;

                tools.textPanel.setBackground(Appreancess.toolsSubPanelSelectedColor);
                tools.fillColorPanel.setBackground(Appreancess.toolsPanelColor);
                tools.pencilPanel.setBackground(Appreancess.toolsPanelColor);
                tools.eraserPanel.setBackground(Appreancess.toolsPanelColor);
                tools.colorPickerPanel.setBackground(Appreancess.toolsPanelColor);
                tools.magnifierPanel.setBackground(Appreancess.toolsPanelColor);
                repaint();
                revalidate();
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                tools.textPanel.setBackground(Appreancess.toolsSubPanelHoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isTextSelected) {
                    tools.textPanel.setBackground(Appreancess.toolsPanelColor);
                }
            }
        });        
        // Use Listener For ShowDialog For Text:
        
        // Use Listener For Eraser:
        tools.eraserPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isTextSelected = false;
                isPecnilSelected = false;
                isFillColorSelected = false;
                iseraserSelected = true;
                isColorPickerSelected = false;
                isMagnifierSelected = false;
                
                tools.eraserPanel.setBackground(Appreancess.toolsSubPanelSelectedColor);
                tools.fillColorPanel.setBackground(Appreancess.toolsPanelColor);
                tools.pencilPanel.setBackground(Appreancess.toolsPanelColor);
                tools.textPanel.setBackground(Appreancess.toolsPanelColor);
                tools.colorPickerPanel.setBackground(Appreancess.toolsPanelColor);
                tools.magnifierPanel.setBackground(Appreancess.toolsPanelColor);
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                tools.eraserPanel.setBackground(Appreancess.toolsSubPanelHoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!iseraserSelected) {
                    tools.eraserPanel.setBackground(Appreancess.toolsPanelColor);
                }
            }
        });
        // Use Listener For Eraser:
        
        // Use Listener For PickColor:
        tools.colorPickerPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isTextSelected = false;
                isPecnilSelected = false;
                isFillColorSelected = false;
                iseraserSelected = false;
                isColorPickerSelected = true;
                isMagnifierSelected = false;

                tools.colorPickerPanel.setBackground(Appreancess.toolsSubPanelSelectedColor);
                tools.fillColorPanel.setBackground(Appreancess.toolsPanelColor);
                tools.pencilPanel.setBackground(Appreancess.toolsPanelColor);
                tools.textPanel.setBackground(Appreancess.toolsPanelColor);
                tools.eraserPanel.setBackground(Appreancess.toolsPanelColor);
                tools.magnifierPanel.setBackground(Appreancess.toolsPanelColor);

            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                tools.colorPickerPanel.setBackground(Appreancess.toolsSubPanelHoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isColorPickerSelected) {
                    tools.colorPickerPanel.setBackground(Appreancess.toolsPanelColor);
                }
            }
        });
        // Use Listener For PickColor:
        
        // Use Listener For Magnifier:
        tools.magnifierPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isTextSelected = false;
                isPecnilSelected = false;
                isFillColorSelected = false;
                iseraserSelected = false;
                isColorPickerSelected = false;
                isMagnifierSelected = true;
                
                tools.magnifierPanel.setBackground(Appreancess.toolsSubPanelSelectedColor);
                tools.fillColorPanel.setBackground(Appreancess.toolsPanelColor);
                tools.pencilPanel.setBackground(Appreancess.toolsPanelColor);
                tools.textPanel.setBackground(Appreancess.toolsPanelColor);
                tools.eraserPanel.setBackground(Appreancess.toolsPanelColor);
                tools.colorPickerPanel.setBackground(Appreancess.toolsPanelColor);
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                tools.magnifierPanel.setBackground(Appreancess.toolsSubPanelHoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isMagnifierSelected) {
                    tools.magnifierPanel.setBackground(Appreancess.toolsPanelColor);
                }
            }
        });
        // Use Listener For Magnifier:
        
        // Use Listener For Drawing:
        Instances.drawingGenerator.addMouseListener(new MouseListener() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isTextSelected) {  
                    mouseX = e.getX();
                    mouseY = e.getY();
                    addTextBtnDialog();
                }else if (isPecnilSelected) {
                    pencilPointX = e.getPoint();
                    pencilPointY = e.getPoint();
                }else if (isFillColorSelected) {
                    Appreancess.fillBackgroundColor = bgColorPanel.getBackground();
                    Instances.drawingGenerator.repaint();
                    Instances.drawingGenerator.revalidate();
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                if (isPecnilSelected) {
                    Point pencilPointX = e.getPoint();
                    Point pencilPointY = e.getPoint();

                    lines = new ArrayList<>();
                    DrawLine drawLine = new DrawLine(
                            pencilPointX.x, 
                            pencilPointY.y, 
                            pencilPointX.x,
                            pencilPointY.y, 
                            brushLenth, 
                            foreBgColorPanel.getBackground()
                    );
                    lines.add(drawLine);

                    Instances.drawingGenerator.repaint();
                    Instances.drawingGenerator.revalidate();
                }
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isPecnilSelected) {
                    totalArrayList.add(lines);
                    Instances.drawingGenerator.repaint();
                    Instances.drawingGenerator.revalidate();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if (isPecnilSelected) {
                    Instances.mainApp.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon(Defaults.getPath("pencil30x30", "png")).getImage(),
                        new Point(0,0),"custom cursor")
                    );
                }else if (isFillColorSelected) {
                    Instances.mainApp.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon(Defaults.getPath("fillColor32x32", "png")).getImage(),
                        new Point(0,0),"custom cursor")
                    );
                }else if (iseraserSelected) {
                    Instances.mainApp.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon(Defaults.getPath("eraser30x30", "png")).getImage(),
                        new Point(0,0),"custom cursor")
                    );
                }else if (isTextSelected) {
                    Instances.mainApp.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon(Defaults.getPath("text32x32", "png")).getImage(),
                        new Point(0,0),"custom cursor")
                    );
                }else if (isColorPickerSelected) {
                    Instances.mainApp.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon(Defaults.getPath("colorPicker32x32", "png")).getImage(),
                        new Point(0,0),"custom cursor")
                    );
                }
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Instances.mainApp.setCursor(Cursor.DEFAULT_CURSOR);
            }
            
        });
        
        Instances.drawingGenerator.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isPecnilSelected) {
                    pencilPointX = e.getPoint();
                    pencilPointY = e.getPoint();
                    
                    DrawLine drawLine = new DrawLine(
                            pencilPointX.x, 
                            pencilPointY.y, 
                            pencilPointX.x, pencilPointY.y, 
                            brushLenth, 
                            foreBgColorPanel.getBackground()
                    );
                    lines.add(drawLine);

                    Instances.drawingGenerator.repaint();
                    Instances.drawingGenerator.revalidate();
                }else if (iseraserSelected) {
                    Point pencilPointX = e.getPoint();
                    Point pencilPointY = e.getPoint();
                    
                    eraser erase = new eraser(
                            pencilPointX.x, 
                            pencilPointY.y, 
                            pencilPointX.x, 
                            pencilPointX.y, 
                            5, 
                            Color.WHITE
                    );
                    eraserList.add(erase);
                    System.out.println("ErasetListSize: " +eraserList.size());
                    Instances.drawingGenerator.repaint();
                    Instances.drawingGenerator.revalidate();
                }
            }
            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        // Use Listener For Drawing:
        
        // Use Listener For getFontSize:
        font.fontSizeChooseBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Appreancess.fontSize = Integer.parseInt(font.fontSizeChooseBox.getSelectedItem().toString());
            }
        });
        // Use Listener For getFontSize:

        // Use Listener For getFontStyle:
        font.fontSizeChooseBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Appreancess.fontStyle = font.fontChooseBox.getSelectedItem().toString();
            }
        });
        // Use Listener For getFontStyle:
    }
    
    public void addTextBtnDialog(){
        JDialog textDialog = new JDialog(Instances.mainApp);
        
        textDialog.setTitle("Text Dialog");
        textDialog.setSize(300, 230);
        textDialog.setLayout(null);
        textDialog.setLocationRelativeTo(null);
        textDialog.setVisible(true);

        JTextArea writeText = new JTextArea();
        JButton addTextBtn = new JButton("Add Text");

        writeText.setBounds(10, 10, 260, 130);
        addTextBtn.setBounds(writeText.getX(), 150, writeText.getWidth(), 35);
        addTextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                textStr = writeText.getText();
                texts text = new texts(mouseX, mouseY, textStr , Appreancess.fontStyle, Appreancess.fontSize, foreBgColorPanel.getBackground());
                texts.add(text);

                Instances.drawingGenerator.repaint();
                Instances.drawingGenerator.revalidate();
                textDialog.dispose();
            }
        });
        
        textDialog.add(writeText);
        textDialog.add(addTextBtn);
    }
}