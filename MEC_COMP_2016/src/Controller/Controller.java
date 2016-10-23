package Controller;

import java.util.List;
import java.util.UUID;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import Model.BuoyModel;
import UserInterface.ApplicationView;
import UserInterface.PrimaryComposite;
import UserInterface.Elements.BouyTableComposite;
import UserInterface.Elements.BouyTableItem;

public class Controller {

	private Shell parentShell;
	
	private Display display;
	private ApplicationView v;
	private PrimaryComposite pc;
	private BouyTableComposite bouyTable;
	private Table table;

	
	public Controller(ApplicationView v) {
		this.v = v;
		pc = v.getPrimaryComposite();
		parentShell = v.getParentShell();
		display = v.getDisplay();
		bouyTable = pc.getTable();
		table = bouyTable.getTable();
		setUpControls();
	}

	private void setUpControls() {
		pc.getButtonAdd().addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent arg0) {
			try{
				Double lattitude = pc.getLatText();
				Double longitude = pc.getLongText();
				
				if(lattitude > 90 || lattitude  < -90){
					pc.postConsoleMessage("Lattitude is bounded by +-90.", true);
					return;
				}
				if(longitude > 180 || lattitude  < -180){
					pc.postConsoleMessage("Longitude is bounded by +-180.", true);
					return;
				}
				pc.postConsoleMessage("Adding Buyo at Longitude: " + longitude + " Lattitude: " + lattitude, false);
				
				BuoyModel m = new BuoyModel(String.valueOf(pc.getLatText()), String.valueOf(pc.getLongText()));
				
				BouyTableItem item = new BouyTableItem(table, SWT.NULL);
				item.getSpeakButton().addSelectionListener(new SelectionAdapter(){
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						m.speak();
					}
				});
				
			} catch(NumberFormatException e) {
				pc.postConsoleMessage("INVALID LOCATION", true);
			}
		}
		
		});
		
		
		pc.getButtonRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				for(int i : table.getSelectionIndices()){
					if(i == -1)
						pc.postConsoleMessage("No selection for removal.", true);
					table.remove(i);
					pc.postConsoleMessage("Removed item " + i, false);
				}
			}
		});
	}
	
	
	

}
