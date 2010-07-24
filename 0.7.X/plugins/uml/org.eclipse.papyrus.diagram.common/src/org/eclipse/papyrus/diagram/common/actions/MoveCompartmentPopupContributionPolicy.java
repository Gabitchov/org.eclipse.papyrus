/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 

 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation 
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Checks if the selection is suitable to be moved within a compartment. This
 * will only happen when there is only one element selected and this element is
 * instance of CompartmentEditPart and it's parent is instance of
 * ListCompartmentEditPart.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class MoveCompartmentPopupContributionPolicy implements IPopupMenuContributionPolicy {

	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection ss = ((IStructuredSelection)selection);
			if(ss.size() <= 0 || ss.size() > 1) {
				return false;
			}
			Object first = ss.getFirstElement();
			if(first instanceof CompartmentEditPart) {
				CompartmentEditPart compEP = (CompartmentEditPart)first;
				// Check if he is really a children
				if(compEP.getParent() instanceof ListCompartmentEditPart)
					return true;
				else
					return false;
			}
		}
		return false;
	}

}
