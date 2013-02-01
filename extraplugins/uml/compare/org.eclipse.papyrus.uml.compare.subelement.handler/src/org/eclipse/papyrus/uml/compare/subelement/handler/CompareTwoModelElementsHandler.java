/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.subelement.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.uml.compare.subelement.handlers.CompareTwoElementsHandler;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * This handler allows to open the compare editor for 2 elements which are not owned by the same resourceset
 * 
 */
public class CompareTwoModelElementsHandler extends CompareTwoElementsHandler {


	/**
	 * FIXME : this is not the best way to get elements selected by the user. (if there are 3 papyrus editor opened, with 3 selections availables, we
	 * are not sure to compare the elements selected by the user
	 * 
	 * @return
	 *         the selected elements
	 */
	protected List<EObject> getSelection() {
		final List<EObject> selection = new ArrayList<EObject>();
		final IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPart activePart = ww.getActivePage().getActivePart();
		if(activePart instanceof IEditorPart) {//if not we forbid to launch a comparison
			int nbPapyrus = 0;
			if(ww != null) {
				final IWorkbenchPage[] pages = ww.getPages();
				final IEditorReference[] refs = pages[0].getEditorReferences();
				for(IEditorReference iEditorReference : refs) {
					final IWorkbenchPart part = iEditorReference.getPart(false);
					if(part != null && part instanceof IMultiDiagramEditor) {
						nbPapyrus++;
						final ISelection currentSelection = part.getSite().getSelectionProvider().getSelection();
						if(currentSelection instanceof IStructuredSelection && ((IStructuredSelection)currentSelection).size() == 1) {
							final Object object = ((IStructuredSelection)currentSelection).getFirstElement();
							if(object instanceof IAdaptable) {
								final EObject res = (EObject)((IAdaptable)object).getAdapter(EObject.class);
								if(res != null && res instanceof Element) {
									selection.add(res);
								}
							}
						}
					}
				}
			}
			if(nbPapyrus != 2) {
				return Collections.emptyList();
			}
		}
		return selection;
	}
}
