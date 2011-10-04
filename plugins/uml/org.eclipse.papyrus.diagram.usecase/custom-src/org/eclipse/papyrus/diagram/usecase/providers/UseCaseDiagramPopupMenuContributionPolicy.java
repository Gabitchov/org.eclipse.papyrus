/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Policy class create to constraint this contribution on UseCase Diagram only
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 * TODO Refactor to eop.diagram.common : this in a PopupMenuContributionPolicy<T> class in eop.diagram.common
 */
public class UseCaseDiagramPopupMenuContributionPolicy implements IPopupMenuContributionPolicy {

	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart instanceof IMultiDiagramEditor) {
			editorPart = ((IMultiDiagramEditor)editorPart).getActiveEditor();
			if(editorPart instanceof DiagramEditor) {
				DiagramEditPart host = ((DiagramEditor)editorPart).getDiagramEditPart();
				return UseCaseDiagramEditPart.MODEL_ID.equals(host.getDiagramView().getType());
			}
		}
		return false;
	}

}
