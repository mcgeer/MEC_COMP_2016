package UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import org.eclipse.wb.swt.SWTResourceManager;

import UserInterface.Elements.BouyTableComposite;
import UserInterface.Elements.ColorPalette;
import UserInterface.Elements.Console;
public class PrimaryComposite extends Composite {

	// Things used for relative screen sizing.
	private int displayWidth, displayHeight;
	private final int edgePaddingWidth;
	private final int edgePaddingHeight;
	private final int compBuffer = 20;

	//Labels
	private Label lattitudeLabel;
	private Label longitudeLabel;
		
	//Text Boxes
	private Text lattitudeText;
	private Text longitudeText;
	
	//Buttons
	private Button buttonAdd;
	private Button buttonAnalyze;
	
	//Console
	private Console consoleScrolledComposite;

	// Tab Folders for holding the tabs
	private TabFolder tabOutputs;

	private Composite currentSubComposite = new Composite(this, SWT.None);
	private Composite[] subComposites;

	final private StackLayout layout = new StackLayout();
	private BouyTableComposite bouyTable;

	/**
	 * Primary Composite Constructor for the gui.
	 * 
	 * @param arg0
	 *            parent Composite
	 * @param arg1
	 *            style.
	 */
	public PrimaryComposite(Composite arg0, int arg1) {
		super(arg0, arg1);
		// setBackground(ColorPalette.CUSTOM_BLACK);
		// setForeground(ColorPalette.CUSTOM_BLUE);
		setBackground(null);
		setLayout(null);
		displayHeight = arg0.getBounds().height;
		displayWidth = arg0.getBounds().width;
		edgePaddingWidth = displayWidth / 50;
		edgePaddingHeight = displayHeight / 20;

		setBounds(0, 0, displayWidth, displayHeight);
		setElementsToComposite();
	}

	/**
	 * Adds the elements to this component of the view.
	 */
	private void setElementsToComposite() {
		// Console For interacting with user.
		consoleScrolledComposite = new Console(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL,
				ColorPalette.CUSTOM_WHITE, ColorPalette.CUSTOM_BLACK);
		consoleScrolledComposite.setBounds(edgePaddingWidth, (int) (displayHeight * 0.775),
				displayWidth - 2 * edgePaddingWidth, 150);

		//SUB COMPOSITES
		tabOutputs = new TabFolder(this, SWT.NONE);
		tabOutputs.setBounds((int) (displayWidth * 0.5), edgePaddingHeight, displayWidth / 2 - edgePaddingWidth,
				(int) (displayHeight * 0.65));

		//LABELS
		lattitudeLabel = new Label(this, SWT.SINGLE);
		lattitudeLabel.setBounds(8 * compBuffer, displayHeight / 4 + edgePaddingWidth + 10,
				displayWidth / 10, displayHeight / 30);
		lattitudeLabel.setText("Lattitude");
		lattitudeLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		longitudeLabel = new Label(this, SWT.SINGLE);
		
		longitudeLabel= new Label(this, SWT.SINGLE);
		longitudeLabel.setBounds(8 * compBuffer, displayHeight / 4 + edgePaddingWidth + 10 + lattitudeLabel.getBounds().height * 2, 
				displayWidth / 10, displayHeight / 30);
		longitudeLabel.setText("Longitude");
		longitudeLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		longitudeLabel = new Label(this, SWT.SINGLE);
		
		//Text boxes
		lattitudeText = new Text(this, SWT.BORDER);
		lattitudeText.setBackground(ColorPalette.CUSTOM_WHITE);
		lattitudeText.setBounds(8 * compBuffer + lattitudeLabel.getBounds().width , displayHeight / 4 + edgePaddingWidth + 10  + lattitudeLabel.getBounds().height * 2, 
				displayWidth / 6, displayHeight / 30);

		longitudeText = new Text(this, SWT.BORDER);
		longitudeText.setBackground(ColorPalette.CUSTOM_WHITE);
		longitudeText.setBounds(8 * compBuffer + lattitudeLabel.getBounds().width , displayHeight / 4 + edgePaddingWidth + 10, 
				displayWidth / 6, displayHeight / 30);

		
		//BUTTONS
		buttonAdd = new Button(this, SWT.NONE);
		buttonAdd.setBounds(displayWidth / 8 + 8 * compBuffer, displayHeight / 2 + edgePaddingWidth + 10,
				displayWidth / 10, displayHeight / 30);
		buttonAdd.setText("Add Buoy");

		
		//Table
		bouyTable = new BouyTableComposite(tabOutputs, SWT.BORDER | SWT.V_SCROLL, ColorPalette.CUSTOM_WHITE,
				ColorPalette.CUSTOM_BLACK);
		bouyTable.setBounds(tabOutputs.getBounds());
		
		TabItem tableOutTab = new TabItem(tabOutputs, SWT.NONE);
		tableOutTab.setText("Output Table");
		tableOutTab.setControl(bouyTable);
		
	}

	// =====================Behavioral Code====================== //
	/**
	 * Resets the composite, setting the combo box to the first element in it.
	 */
	public void refreshView() {
		consoleScrolledComposite.clearConsole();
	}

	// =====================Getters and Setter and Mcgeers======================
	/**
	 * Changes the sub composite.
	 */
	public void setSubComposite() {
		currentSubComposite.layout();
	}

	/**
	 * @return Gets the button to add
	 */
	public Button getButtonAdd() {
		return buttonAdd;
	}

	/**
	 * @return Gets the button to analyze
	 */
	public Button getButtonAnalyze() {
		return buttonAnalyze;
	}
	
	public Double getLatText() throws NumberFormatException{
		return Double.parseDouble(lattitudeText.getText());
	}

	public Double getLongText() throws NumberFormatException {
		return Double.parseDouble(longitudeText.getText());
	}
	
	public void postConsoleMessage(String message, boolean isError){
		consoleScrolledComposite.addToConsole(message, isError);
	}
	
}
