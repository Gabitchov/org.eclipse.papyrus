/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.dialogs.ConnectorSelectionDialog;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Implementation class for ClassAction action
 */
public class SelectConnectorHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		if((selectedEObject instanceof Connector) || (selectedEObject instanceof Property)) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// feature is a common superclass of Connector and Property
		if(!(selectedEObject instanceof Feature)) {
			return null;
		}
		// get selected connector
		final Feature selectedFeature = (Feature)selectedEObject;
		Shell shell = new Shell();

		// 1. select possible connectors according to port types
		// (only show compatible connectors check-box?)
		// 2. select implementation group according to connector type

		Model model = selectedFeature.getModel();

		ConnectorSelectionDialog elementSelector =
			new ConnectorSelectionDialog(shell, model, selectedFeature);
		elementSelector.setTitle("Select connector");
		elementSelector.setMessage("Select an implementation for connector " + selectedFeature.getName());
		elementSelector.open();
		if(elementSelector.getReturnCode() == IDialogConstants.OK_ID) {
			final Object[] result = elementSelector.getResult();
			if((result.length == 1) && (result[0] instanceof Class)) {
				CommandSupport.exec("Select connector", event, new Runnable() {

					public void run() {
						org.eclipse.papyrus.FCM.Connector fcmSelectedConnector = StereotypeUtil.applyApp(selectedFeature, org.eclipse.papyrus.FCM.Connector.class);
						InteractionComponent newConnType = UMLUtil.getStereotypeApplication((Class)result[0], InteractionComponent.class);
						fcmSelectedConnector.setIc(newConnType);
					}
				});
			}
		}
		return null;
	}
}
