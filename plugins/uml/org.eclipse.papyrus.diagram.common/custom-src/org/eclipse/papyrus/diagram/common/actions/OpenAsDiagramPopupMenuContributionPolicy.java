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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.Package;


// TODO: Auto-generated Javadoc
/**
 * The Class OpenAsDiagramPopupMenuContributionPolicy.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class OpenAsDiagramPopupMenuContributionPolicy implements IPopupMenuContributionPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy#appliesTo(org.eclipse.jface.viewers.ISelection,
	 * org.eclipse.core.runtime.IConfigurationElement)
	 */
	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = ((IStructuredSelection) selection);
			if (ss.size() <= 0 || ss.size() > 1) {
				return false;
			}
			Object first = ss.getFirstElement();
			if (first instanceof IGraphicalEditPart) {
				EObject element = ((IGraphicalEditPart) first).resolveSemanticElement();
				View view = ((IGraphicalEditPart) first).getNotationView();
				if (MultiDiagramUtil.getDiagramsAssociatedToView(view.getDiagram()).size() > 0 && element instanceof Package) {
					return true;
				}
			}
		}

		return false;
	}

}
