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
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.actions;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * IPopupMenuContributionPolicy for Arrange port action
 * @author adaussy
 *
 */
public class ArrangePortInInternalBlockDiagramContributionPolicyClass implements IPopupMenuContributionPolicy{

	
	/**
	 * {@inheritDoc}
	 */
	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart instanceof IMultiDiagramEditor) {
			editorPart = ((IMultiDiagramEditor)editorPart).getActiveEditor();
			if(editorPart instanceof DiagramEditor) {
				DiagramEditPart host = ((DiagramEditor)editorPart).getDiagramEditPart();
				boolean correctDiagram = ElementTypes.DIAGRAM_ID.equals(host.getDiagramView().getType());
				return correctDiagram && isCorrectView(selection);
			}
		}
		return false;
	}

	/**
	 * @param selection
	 * @return
	 */
	protected boolean isCorrectView(ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection strSelection = (IStructuredSelection)selection;
			boolean result = true;
			for (Object o : strSelection.toArray()){
				if(o instanceof IGraphicalEditPart) {
					IGraphicalEditPart editPart = (IGraphicalEditPart)o;
					View notationView = editPart.getNotationView();
					if (notationView == null){
						return false;
					}
					result &= SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(notationView.getType());
				}
			}
			return result;
		}
		return false;
	}
}
