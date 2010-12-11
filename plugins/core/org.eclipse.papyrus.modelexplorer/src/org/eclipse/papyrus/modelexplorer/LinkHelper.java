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
package org.eclipse.papyrus.modelexplorer;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.ui.IRevealSemanticElement;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
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
		if (aSelection == null || aSelection.isEmpty())
			return;

		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();

		IEditorPart diagramEditor= papyrusEditor.getActiveEditor();

		if (diagramEditor instanceof IRevealSemanticElement){
			if( aSelection instanceof IStructuredSelection){
				Iterator<?> selectionIterator=((IStructuredSelection)aSelection).iterator();
				ArrayList<Object> semanticElementList= new ArrayList<Object>();
				while(selectionIterator.hasNext()) {
					Object currentSelection = (Object)selectionIterator.next();
					if( currentSelection instanceof IAdaptable){
						Object semanticElement=((IAdaptable)currentSelection).getAdapter(EObject.class);
						if( semanticElement!=null){
							semanticElementList.add(semanticElement);
						}
					}

				}
				((IRevealSemanticElement)diagramEditor).revealSemanticElement(semanticElementList);
			}
		}

	}


}
