/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 350910
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.ui.PlatformUI;

/**
 * This handler allows to rename element in the Diagram. It works with the
 * org.eclipse.ui.edit.rename command. It is created to replace the initial
 * keybinding done by GMF. see bug 317424
 * 
 */
public class RenamedElementHandler extends AbstractHandler {

	/**
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */

	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<IGraphicalEditPart> selection = getSelectedElements();
		selection.get(0).performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		List<IGraphicalEditPart> selection = getSelectedElements();
		if(selection.size() == 1) {
			IGraphicalEditPart editpart = selection.get(0);
			DiagramEditPart diagramEP = DiagramEditPartsUtil.getDiagramEditPart(editpart);
			EObject modelElement = EMFHelper.getEObject(editpart);
				
			// we don't rename the diagram nor read-only objects
			return (editpart != diagramEP) && ((modelElement == null) || !EMFHelper.isReadOnly(modelElement));
		}
		return false;
	}

	/**
	 * Iterate over current selection and build a list of the {@link IGraphicalEditPart} contained in the selection.
	 * 
	 * @return the currently selected {@link IGraphicalEditPart}
	 */
	protected List<IGraphicalEditPart> getSelectedElements() {
		List<IGraphicalEditPart> editparts = new ArrayList<IGraphicalEditPart>();

		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				if(object instanceof IGraphicalEditPart) {
					editparts.add((IGraphicalEditPart)object);
				}
			}

		} else if(selection instanceof IGraphicalEditPart) {
			editparts.add((IGraphicalEditPart)selection);
		}

		return editparts;
	}
}
