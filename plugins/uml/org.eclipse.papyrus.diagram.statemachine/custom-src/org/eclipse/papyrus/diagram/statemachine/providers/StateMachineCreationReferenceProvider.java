/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Francisco Javier Cano Mu�oz (Prodevelop) - Initial API 
 *  implementation.
 *  Marc Gil Sendra (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.providers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.statemachine.part.SelectStateMachineDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.StateMachine;


// TODO: Auto-generated Javadoc
/**
 * The Class StateMachineCreationReferenceProvider.
 */
public class StateMachineCreationReferenceProvider {

	/** The Selected state machine. */
	public static StateMachine SelectedStateMachine = null;

	/**
	 * Dialog select state machine.
	 * 
	 * @param domain
	 *        the domain
	 * 
	 * @return the state machine
	 */
	public static StateMachine DialogSelectStateMachine(
			TransactionalEditingDomain domain) {
		StateMachine subMachine = null;

		SelectedStateMachine = null;
		SelectStateMachineDialog selectDialog = new SelectStateMachineDialog(
				Display.getCurrent().getActiveShell(), domain);
		if(selectDialog.open() == Window.OK
				&& selectDialog.getSelectedModelElementURI() != null) {
			URI selectedModelElementURI = selectDialog
					.getSelectedModelElementURI();
			subMachine = (StateMachine)domain.getResourceSet().getEObject(
					selectedModelElementURI, true);
		}
		SelectedStateMachine = subMachine;
		return subMachine;
	}

}
