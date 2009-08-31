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

import java.util.Collection;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.statemachine.part.SelectConnectionPointsDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.StateMachine;


// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionPointReferenceCreationReferenceProvider.
 */
public class ConnectionPointReferenceCreationReferenceProvider {

	/** The Selected connection point. */
	public static Pseudostate SelectedConnectionPoint = null;

	/**
	 * Select conection point dialog.
	 * 
	 * @param domain the domain
	 * @param stateMachine the state machine
	 * @param kind the kind
	 * 
	 * @return the pseudostate
	 */
	public static Pseudostate SelectConectionPointDialog(
			TransactionalEditingDomain domain, StateMachine stateMachine,
			PseudostateKind kind) {

		SelectConnectionPointsDialog selectDialog = new SelectConnectionPointsDialog(
				Display.getCurrent().getActiveShell(), stateMachine, kind);

		SelectedConnectionPoint = null;
		if (selectDialog.open() == Window.OK) {
			Collection<Pseudostate> selectedConnectionReferences = selectDialog
					.getSelectedConnectionPoints();

			if (!selectedConnectionReferences.isEmpty()) {
				for (Pseudostate ps : selectedConnectionReferences) {
					if (ps.getKind().equals(kind)) {
						SelectedConnectionPoint = ps;
						return SelectedConnectionPoint;
					}
				}
			}
		}
		SelectedConnectionPoint = null;

		return null;
	}

}
