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
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * Handler used to select all elements with the same type in a diagram
 * 
 * @author vl222926
 * 
 */
public class SelectElementWithTheSameTypeHandler extends AbstractDiagramHandler {

	protected IStructuredSelection selection;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(this.selection != null) {
			Object elem = selection.getFirstElement();
			IGraphicalEditPart part = (IGraphicalEditPart)elem;
			EObject o1 = getEObject(part);

			Map<?, ?> elements = part.getViewer().getEditPartRegistry();

			Object[] values = elements.values().toArray();

			ArrayList<Object> listElement = new ArrayList<Object>();
			add(listElement, part);

			for(int i = 0; i < values.length; i++) {
				if(values[i] instanceof IGraphicalEditPart) {
					IGraphicalEditPart nextPart = (IGraphicalEditPart)values[i];
					EObject o2 = getEObject(nextPart);
					// Views with no semantic element
					if(o1 == null || o2 == null) {
						if(part.getModel() instanceof View && nextPart.getModel() instanceof View) {
							View view1 = (View)part.getModel();
							View view2 = (View)nextPart.getModel();
							if(view1.getType() != null && view1.getType().equals(view2.getType())) {
								add(listElement, nextPart);
							}
						}
						continue;
					}

					// Views with a semantic element
					if(part instanceof ConnectionEditPart && nextPart instanceof ConnectionEditPart) {
						if(o1 != o2 && (o1.eClass().equals(o2.eClass()))) {
							add(listElement, nextPart);
						}
					} else if(o1 != o2 && (o1.eClass().equals(o2.eClass())) && (isEquivalent(part.getParent(), nextPart.getParent()))) {
						add(listElement, nextPart);
					}
				}
			}
			part.getViewer().setSelection(new StructuredSelection(listElement));
		}
		return null;
	}

	private void add(ArrayList<Object> listElement, IGraphicalEditPart nextPart) {
		if(nextPart.isSelectable()) {
			listElement.add(nextPart);
		}
	}



	/**
	 * Determines if the type of the model element linked to the first edit part is the same as the second edit part
	 * 
	 * @param part
	 *        the EditPart of the selected element in the diagram
	 * @param nextPart
	 *        EditPart of other element in the diagram
	 * @return
	 */
	private boolean isEquivalent(EditPart part, EditPart nextPart) {
		if(part instanceof GraphicalEditPart && nextPart instanceof GraphicalEditPart) {
			EObject eObject = getEObject((GraphicalEditPart)part);
			EObject eObject2 = getEObject((GraphicalEditPart)nextPart);
			return eObject != null && eObject2 != null && eObject.eClass().equals(eObject2.eClass());
		}
		return false;
	}

	/**
	 * Returns the eObject linked to the view
	 * 
	 * @param part
	 *        , the edit part
	 * @return
	 */
	private EObject getEObject(GraphicalEditPart part) {
		if(part.getModel() instanceof View) {
			return ((View)part.getModel()).getElement();
		}
		return null;
	}

	/**
	 * Verify equality of the type of selected elements in the diagram
	 * 
	 * @param selection
	 *        content the selected element
	 * @return true, if all element selected are the same type
	 */
	public static boolean verifySameTypeOfSelectedElements(ISelection selection) {
		if(!(selection instanceof StructuredSelection) || selection.isEmpty()) {
			return false;
		}

		Object[] elems = ((StructuredSelection)selection).toArray();

		if((elems.length == 1) && ((elems[0] instanceof DiagramEditPart))) {
			return false;
		}
		boolean selectable = true;
		for(int i = 0; i < elems.length - 1; i++) {
			Object elem1 = elems[i];
			Object elem2 = elems[i + 1];
			if((elem1 instanceof IGraphicalEditPart) && (elem2 instanceof IGraphicalEditPart)) {
				IGraphicalEditPart part1 = (IGraphicalEditPart)elem1;
				IGraphicalEditPart part2 = (IGraphicalEditPart)elem2;
				selectable &= (part1.isSelectable() && part2.isSelectable());
				View view1 = (View)part1.getModel();
				View view2 = (View)part2.getModel();
				if((view1 != null) && (view2 != null) && view1.getElement() != null && view2.getElement() != null) {
					if(view1.getElement().eClass() != view2.getElement().eClass()) {
						return false;
					}
				}
			}
		}
		return selectable;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		this.selection = null;
		buildSelection();
		boolean isEnabled = false;
		if(this.selection != null) {
			isEnabled = verifySameTypeOfSelectedElements(this.selection);
		}
		setBaseEnabled(isEnabled);
	}

	/**
	 * build the selection
	 */
	protected void buildSelection() {
		this.selection = null;
		final IDiagramWorkbenchPart diagramWorkbenchPart = getDiagramWorkbenchPart();
		if(diagramWorkbenchPart != null) {
			this.selection = (IStructuredSelection)diagramWorkbenchPart.getSite().getSelectionProvider().getSelection();
		}
	}
}
