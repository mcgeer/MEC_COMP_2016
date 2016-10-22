package Controller;

import java.util.UUID;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import UserInterface.ApplicationView;
import UserInterface.PrimaryComposite;

public class Controller {

	private Shell parentShell;
	
	private Display display;
	private ApplicationView v;
	private PrimaryComposite pc;
	
	public Controller(ApplicationView v) {
		this.v = v;
		pc = v.getPrimaryComposite();
		parentShell = v.getParentShell();
		display = v.getDisplay();
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
				UUID itemID = UUID.randomUUID();
				pc.postConsoleMessage("Adding Buyo at Longitude: " + longitude + " Lattitude: " + lattitude, false);
				
			
			} catch(NumberFormatException e) {
				pc.postConsoleMessage("INVALID LOCATION", true);
			}
		}
		
		});
	}

}
