/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForWorkbenchPage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

/**
 * This class is to link form the model explorer to diagram
 * This code was to not put in the model explorer in order to avoid dependences with gmf in the more abstract explorer
 * 
 */

public class LinkHelper implements ILinkHelper {

	/**
	 * 
	 * @see org.eclipse.ui.navigator.ILinkHelper#findSelection(org.eclipse.ui.IEditorInput)
	 * 
	 */
	public IStructuredSelection findSelection(IEditorInput anInput) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.ui.navigator.ILinkHelper#activateEditor(org.eclipse.ui.IWorkbenchPage, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 */
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
		//no selection
		if(aSelection == null || aSelection.isEmpty()) {
			return;
		}
		ISelectionService selectService = aPage.getWorkbenchWindow().getSelectionService();
		ISelection selection = selectService.getSelection();

		//test if the selection come the tree viewer in order to avoid  cycle: Diagram -> tree-> diagram
		// if the diagram has been selected the selection is not a TreeSelection
		if(selection instanceof ITreeSelection) {
			try {
				ISashWindowsContainer windowsContainer = ServiceUtilsForWorkbenchPage.getInstance().getISashWindowsContainer(aPage);

				Iterator<IEditorPart> iterPart = windowsContainer.getVisibleIEditorParts().iterator();

				while(iterPart.hasNext()) {
					IEditorPart diagramEditor = iterPart.next();
					if(diagramEditor instanceof IRevealSemanticElement) {
						if(aSelection instanceof IStructuredSelection) {
							Iterator<?> selectionIterator = aSelection.iterator();
							ArrayList<Object> semanticElementList = new ArrayList<Object>();
							while(selectionIterator.hasNext()) {
								Object currentSelection = selectionIterator.next();
									Object semanticElement = EMFHelper.getEObject(currentSelection);
									if(semanticElement != null) {
										semanticElementList.add(semanticElement);
									}

							}
							((IRevealSemanticElement)diagramEditor).revealSemanticElement(semanticElementList);
						}
					}
				}
			} catch (ServiceException ex) {
				//We cannot access the service registry. The PapyrusEditor is probably closed.
			} catch (Exception ex) {
				Activator.log.error("Impossible to acces to windows Container", ex);
			}
		}
	}


}
