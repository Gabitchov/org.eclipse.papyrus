/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Miguel Llacer San Fernando (Prodevelop) - initial API and implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowViewEditPolicy.
 */
public class ShowViewEditPolicy {

	/** The policy. */
	private static OpenEditPolicy policy = null;

	/**
	 * Gets the open edit policy.
	 * 
	 * @return the open edit policy
	 */
	private static OpenEditPolicy getOpenEditPolicy() {
		if(policy == null) {
			policy = new OpenEditPolicy() {

				@Override
				protected Command getOpenCommand(Request request) {

					String viewId = "org.eclipse.ui.views.PropertySheet";
					try {
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewId);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
					return null;
				}
			};
		}
		return policy;
	}

	/**
	 * Listens to double-click event over some element of the diagram and shows
	 * properties tab.
	 * 
	 * @return the open edit policy
	 */
	// @unused
	public static OpenEditPolicy createOpenEditPolicy() {
		return getOpenEditPolicy();
	}
}
