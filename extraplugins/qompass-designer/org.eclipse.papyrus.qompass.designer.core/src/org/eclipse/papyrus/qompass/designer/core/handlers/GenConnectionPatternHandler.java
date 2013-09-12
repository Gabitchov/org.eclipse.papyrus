package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.util.UMLUtil;

public class GenConnectionPatternHandler extends CmdHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		//only one model is selected
		Class selectedClass = (Class)getSelectedEObject();
		Log.log(Status.INFO, Log.DIALOGS, "GenConnectionPattern.run: " + selectedClass.getName());
		InteractionComponent connType = UMLUtil.getStereotypeApplication(selectedClass, InteractionComponent.class);
		FCMUtil.generateDefaultConnectionPattern(connType);
	}
}
