package UserInterface.Elements;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import Constants.FilePaths;

/**
 * SolarTableItem instance
 */
public class BouyTableItem {

	private TableEditor editor;
	private TableItem item;
	private Table solarTable;
	private Button speakItemButton;

	/**
	 * Solar table item instance
	 * 
	 * @param table
	 *            table this will belong to
	 * @param SWTargs
	 *            SWT arguments for the table item, Default pass SWT.NONE
	 */
	public BouyTableItem(Table table, int SWTargs) {
		solarTable = table;
		item = new TableItem(table, SWTargs);

		editor = new TableEditor(table);

		speakItemButton = new Button(table, SWT.NULL);

		
		InputStream SpeakInputStream = BouyTableItem.class.getResourceAsStream(FilePaths.SPEAKER_PATH);

		Image speakIcon = new Image(item.getDisplay(), SpeakInputStream);
		ImageData speakIconData = speakIcon.getImageData();
		speakIconData = speakIconData.scaledTo(20, 20);
		speakIcon = new Image(item.getDisplay(), speakIconData);
		speakItemButton.setImage(speakIcon);

		editor.setEditor(speakItemButton, item, 6);
		
		editor.grabHorizontal = true;
	}

	
	public Button getSpeakButton(){
		return this.speakItemButton;
	}
	
	//Behaviour
	/**
	 * Frees all memory for this item and removes it from the table
	 */
	public void destroy() {
		editor.dispose();
		item.dispose();
		solarTable.pack();
	}

	// SETTERS
	/**
	 * @param s
	 *            set Longitude to s on the view
	 */
	public void setLongitude(String s) {
		item.setText(0, s);
	}

	/**
	 * @param s
	 *            set Latitude to s on the view
	 */
	public void setLatitude(String s) {
		item.setText(1, s);
	}

	/**
	 * @param s
	 *            set wind speed to s on the view
	 */
	public void setWindSpeed(String s) {
		item.setText(2, s);
	}

	/**
	 * @param s
	 *            set the wind dir to s on the view
	 */
	public void setWindDir(String s) {
		item.setText(3, s);
	}

	/**
	 * @param s
	 *            set temp to s on the view
	 */
	public void setTemp(String s) {
		item.setText(4, s);
	}

	/**
	 * @param s
	 *            set if dangerous conds to s on the view
	 */
	public void setIsDangerous(String s) {
		item.setText(5, s);
	}

	//GETTERS
	/**
	 * @return items lat
	 */
	public String getLatitude() {
		return item.getText(1);
	}

	/**
	 * @return items long
	 */
	public String getLongitude() {
		return item.getText(0);
	}

	/**
	 * @return items wind speed
	 */
	public String getWindSpeed() {
		return item.getText(2);
	}

	/**
	 * @return items wind dir
	 */
	public String getWindDirection() {
		return item.getText(3);
	}

	/**
	 * @return items temp
	 */
	public String getTemp() {
		return item.getText(4);
	}

	/**
	 * @return item is dangerous
	 */
	public String getisDangerous() {
		return item.getText(5);
	}

	/**
	 * @return button to remove item
	 */
	public Table getTable() {
		return solarTable;
	}
}
