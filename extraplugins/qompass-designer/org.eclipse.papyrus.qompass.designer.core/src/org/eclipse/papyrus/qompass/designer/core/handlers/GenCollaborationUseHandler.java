package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;
import org.eclipse.papyrus.FCM.Connector;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.qompass.designer.core.StUtils;

/**
 * currently unused
 * 
 * @author ansgar
 */
public class GenCollaborationUseHandler extends CmdHandler {

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
		updateSelectedEObject();

		org.eclipse.uml2.uml.Connector selectedConnector = (org.eclipse.uml2.uml.Connector)getSelectedEObject();
		Connector fcmConn = StUtils.getApplication(selectedConnector, Connector.class);
		FCMUtil.generateCollaborationUse(fcmConn);
	}
}
