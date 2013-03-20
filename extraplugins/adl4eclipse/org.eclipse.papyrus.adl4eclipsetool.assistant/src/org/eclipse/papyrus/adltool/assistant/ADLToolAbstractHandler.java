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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.assistant;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;

/**
 * Abstract handler in order to connect to papyrus
 *
 */
public abstract class ADLToolAbstractHandler extends AbstractHandler {

	protected TransactionalEditingDomain transactionalEditingDomain=null;
	protected PapyrusMultiDiagramEditor papyrusEditor;

	/**
	 * getSelected element in the diagram or in hte model explorer
	 * @return Element or null
	 */
	protected Element getSelection(){
		org.eclipse.uml2.uml.Element selectedElement =null;
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		//look for papyrus
		int i=0;
		while(!(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() instanceof IMultiDiagramEditor)&&i<100000) {
			i++;
		}
		if((PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){
			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			papyrusEditor = ((PapyrusMultiDiagramEditor)editorPart);

			if(selection instanceof IStructuredSelection) {
				Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
				if(selectedobject instanceof GraphicalEditPart) {
					Object graphicalElement = ((GraphicalEditPart)selectedobject).getModel();
					if((graphicalElement instanceof View) && ((View)graphicalElement).getElement() instanceof org.eclipse.uml2.uml.Element) {
						selectedElement = (org.eclipse.uml2.uml.Element)((View)graphicalElement).getElement();
					}
				}
				else if(selectedobject instanceof IAdaptable) {
					EObject selectedEObject = (EObject)((IAdaptable)selectedobject).getAdapter(EObject.class);
					if (selectedEObject instanceof org.eclipse.uml2.uml.Element){
						selectedElement=(Element)selectedEObject;
					}
				}

			}
			return selectedElement;
		}
		return null;
	}
	/**
	 * getSelected element in the diagram or in hte model explorer
	 * @return Element or null
	 */
	protected ArrayList<Element> getSelectionSet(){
		ArrayList<Element> selectedSet =new ArrayList<Element>();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();

		//look for papyrus
		int i=0;
		while(!(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() instanceof IMultiDiagramEditor)&&i<100000) {
			i++;
		}
		if((PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){
			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			papyrusEditor = ((PapyrusMultiDiagramEditor)editorPart);

			if(selection instanceof IStructuredSelection) {
				@SuppressWarnings("rawtypes")
				Iterator selectedobjectIteractor = ((IStructuredSelection)selection).iterator();
				while (selectedobjectIteractor.hasNext()) {
					Object currentSelection = selectedobjectIteractor.next();
					if(currentSelection instanceof GraphicalEditPart) {
						Object graphicalElement = ((GraphicalEditPart)currentSelection).getModel();
						if((graphicalElement instanceof View) && ((View)graphicalElement).getElement() instanceof org.eclipse.uml2.uml.Element) {
							selectedSet.add( (org.eclipse.uml2.uml.Element)((View)graphicalElement).getElement());
						}
					}
					else if(currentSelection instanceof IAdaptable) {
						EObject selectedEObject = (EObject)((IAdaptable)currentSelection).getAdapter(EObject.class);
						if (selectedEObject instanceof org.eclipse.uml2.uml.Element){
							selectedSet.add((Element)selectedEObject);
						}
					}
				}
				

			}
			return selectedSet;
		}
		return selectedSet;
	}
}
