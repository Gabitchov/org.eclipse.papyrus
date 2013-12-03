package org.eclipse.papyrus.qompass.designer.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.FCM.Connector;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * TODO: for testing, currently unused
 */
@Deprecated
public class GenCollaborationUseHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return null;
	}
	
	/**
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		updateSelectedEObject();

		org.eclipse.uml2.uml.Connector selectedConnector = (org.eclipse.uml2.uml.Connector)selectedEObject;
		Connector fcmConn = UMLUtil.getStereotypeApplication(selectedConnector, Connector.class);
		FCMUtil.generateCollaborationUse(fcmConn);
	}
}
