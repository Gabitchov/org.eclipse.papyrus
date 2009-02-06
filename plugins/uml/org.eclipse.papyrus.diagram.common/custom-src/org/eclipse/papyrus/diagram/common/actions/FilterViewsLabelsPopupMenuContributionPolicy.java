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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterViewsLabelsPopupMenuContributionPolicy.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class FilterViewsLabelsPopupMenuContributionPolicy implements IPopupMenuContributionPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy#appliesTo(org.eclipse.jface.viewers.ISelection,
	 * org.eclipse.core.runtime.IConfigurationElement)
	 */
	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			for (Object o : ss.toList()) {
				if (o instanceof IGraphicalEditPart) {
					if (((IGraphicalEditPart) o).getNotationView() instanceof Diagram) {

						return true;
					}
				}
			}
		}
		return false;
	}

}
