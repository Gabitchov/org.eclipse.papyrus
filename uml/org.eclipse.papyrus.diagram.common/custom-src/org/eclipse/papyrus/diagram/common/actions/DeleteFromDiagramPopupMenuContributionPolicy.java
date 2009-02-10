/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class DeleteFromDiagramPopupMenuContributionPolicy.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class DeleteFromDiagramPopupMenuContributionPolicy implements IPopupMenuContributionPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy#appliesTo(org.eclipse.jface.viewers.ISelection,
	 * org.eclipse.core.runtime.IConfigurationElement)
	 */
	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		List<EObject> eObjects = MDTUtil.getEObjectsFromSelection(selection);
		if (eObjects != null && eObjects.size() > 0) {
			return true;
		}
		return false;
	}

}
