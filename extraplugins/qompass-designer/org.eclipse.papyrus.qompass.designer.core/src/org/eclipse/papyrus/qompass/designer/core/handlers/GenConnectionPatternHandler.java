package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Class;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.StUtils;

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
		Log.log(Log.INFO_MSG, Log.DIALOGS, "GenConnectionPattern.run: " + selectedClass.getName());
		InteractionComponent connType = StUtils.getApplication(selectedClass, InteractionComponent.class);
		FCMUtil.generateDefaultConnectionPattern(connType);
	}
}
