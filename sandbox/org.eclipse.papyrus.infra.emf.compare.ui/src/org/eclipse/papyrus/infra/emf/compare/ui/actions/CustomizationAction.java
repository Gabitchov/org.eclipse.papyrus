package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;


public class CustomizationAction extends Action {


	private static final String TOOLTIPTEXT = "Manage the applied customization";

	//TODO : avoid to duplicate this image?
	private static final String CUSTOMIZATION_IMAGE_PATH = "icons/addUiCustom.gif";

	public CustomizationAction() {
		setToolTipText(TOOLTIPTEXT);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, CUSTOMIZATION_IMAGE_PATH));
	}
	
	@Override
	public void run() {
		//TODO
		// TODO Auto-generated method stub
	//	super.run();
	}
}
