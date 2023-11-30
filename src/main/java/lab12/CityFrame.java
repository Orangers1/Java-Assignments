package lab12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class implements a GUI for drawing houses in a city.
 * 
 * This version has sliders for setting house size.
 * 
 * @author Prof. Heisler and ??
 * @version Nov. 14, 2023
 */
public class CityFrame extends JFrame implements ActionListener, ChangeListener{
	// Menu items for closing, clearing, and setting color.
	private JMenuItem closeItem;
	private JMenuItem clearItem;
	private JMenuItem colorItem;
	private JMenuItem saveItem;
	
	// TODO - JSliders for setting house size
	private JSlider horizontalSize;
	private JSlider verticalSize;
	
	private CityPanel cityPanel;
	
	/**
	 * The constructor starts with an empty city.
	 */
	public CityFrame(){

		// Make a panel for the content of this frame.
		cityPanel = new CityPanel();
		cityPanel.setPreferredSize(new Dimension(600, 400));
		this.setContentPane(cityPanel);




		// Add the menu items to a menu in the menu bar.
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Edit");
		this.clearItem = new JMenuItem("Clear");
		this.clearItem.addActionListener(this);
		menu.add(this.clearItem);
		this.colorItem = new JMenuItem("Choose color");
		this.colorItem.addActionListener(this);
		menu.add(this.colorItem);
		this.saveItem = new JMenuItem("Save");
		this.saveItem.addActionListener(this);
		menu.add(this.saveItem);
		this.closeItem = new JMenuItem("Close");
		this.closeItem.addActionListener(this);
		menu.add(this.closeItem);
		menubar.add(menu);
		this.setJMenuBar(menubar);

		// TODO - Set up and add sliders for setting house size.


		JPanel sliderPanel = new JPanel();
		JPanel labelPanel = new JPanel();

		JLabel horizontalLabel = new JLabel();
		JLabel verticalLabel = new JLabel();

		labelPanel.add(verticalLabel);
		labelPanel.add(horizontalLabel);


		horizontalSize = new JSlider(0, 200, 10);
		verticalSize = new JSlider(0, 200, 10);

			horizontalSize.setMajorTickSpacing(50);
			horizontalSize.setPaintTicks(true);
			horizontalSize.setPaintLabels(true);

			verticalSize.setMajorTickSpacing(50);
			verticalSize.setPaintTicks(true);
			verticalSize.setPaintLabels(true);

		sliderPanel.add(horizontalSize);
		sliderPanel.add(verticalSize);


		this.add(labelPanel);
		this.add(sliderPanel);





		// Setup this frame.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	/**
	 * The method is called when the user makes a menu selection.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == this.closeItem) 
			this.dispose();
		else if(src == this.clearItem) 
			this.cityPanel.clearHouses();
		else if(src == this.colorItem){
			Color newColor = JColorChooser.showDialog(this, "Select a color", Color.ORANGE);
			if(newColor != null)
				this.cityPanel.setColor(newColor); 
		}else if(src == this.saveItem) {
			JFileChooser chooser = new JFileChooser();
			chooser.setSelectedFile(new File("myCity.jpg"));
			chooser.setFileFilter(new FileNameExtensionFilter("JPG  Images", "jpg"));
			chooser.setDialogTitle("Select the location for the new file.");
			if(chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "Save file cancelled.");
				return;
			}		
			BufferedImage img = new BufferedImage(this.cityPanel.getWidth(), this.cityPanel.getHeight(), 
					BufferedImage.TYPE_INT_RGB);
			this.cityPanel.paint(img.getGraphics());
			try {
				ImageIO.write(img, "jpg", chooser.getSelectedFile());
			}
			catch(IOException ex) {
				JOptionPane.showMessageDialog(null, "The drawing cannot be written to file.");
			}
		}
	}
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;

	@Override
	public void stateChanged(ChangeEvent e) {

	}
}