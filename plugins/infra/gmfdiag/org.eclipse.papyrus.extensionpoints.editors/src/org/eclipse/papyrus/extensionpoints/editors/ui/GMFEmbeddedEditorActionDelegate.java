/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Action delegate for direct editors embedded in GMF editors
 */
public class GMFEmbeddedEditorActionDelegate extends OpenEmbeddedTextEditorObjectActionDelegate {

	/** selected element in the diagram */
	protected IGraphicalEditPart selectedElement;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control getControl() {
		IDiagramGraphicalViewer viewer = null;
		if(part instanceof IDiagramGraphicalViewer) {
			viewer = (IDiagramGraphicalViewer)part;
		} else if(part instanceof IAdaptable) {
			viewer = (IDiagramGraphicalViewer)((IAdaptable)part).getAdapter(IDiagramGraphicalViewer.class);
		}

		if(viewer != null) {
			return viewer.getControl();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EObject getEditedObject() {
		// should never happened, but...
		if(selectedElement == null) {
			throw new RuntimeException("Impossible to get an element from no selection.");
		}

		// retrieves the current model element associated to the graphical selected edit part
		Object model = selectedElement.getModel();
		if(model instanceof View) {
			return ((View)model).getElement();
		}

		// nothing was found. throw an exception
		throw new RuntimeException("Impossible to get an element from selected Element " + selectedElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Point getPosition() {
		// calculate position in 2 steps:
		// 1. position of the element from the top left corner of he gmf viewer
		// 2. position of the viewer from the top left corner of the screen
		Rectangle rect = selectedElement.getFigure().getBounds().getCopy();
		selectedElement.getFigure().translateToAbsolute(rect);

		Point viewerPosition = getViewerPosition();
		return new Point(rect.x + viewerPosition.x, rect.y + viewerPosition.y);
	}

	/**
	 * Returns the viewer position
	 * 
	 * @return the GMF viewer position
	 */
	protected Point getViewerPosition() {
		Control viewerControl = selectedElement.getViewer().getControl();

		// get the position of this control in its parent
		Composite parent = viewerControl.getParent();
		Point selectionPoint = new Point(0, 0);
		while(parent.getParent() != null) {
			selectionPoint.x += parent.getLocation().x;
			selectionPoint.y += parent.getLocation().y;
			parent = parent.getParent();
			if(parent.getParent() == null) {
				// this is the display
				selectionPoint.x += parent.getDisplay().getActiveShell().getLocation().x;
				selectionPoint.y += parent.getDisplay().getActiveShell().getLocation().y;
			}
		}
		return selectionPoint;
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection)selection).getFirstElement();
			if(o instanceof IGraphicalEditPart) {
				selectedElement = ((IGraphicalEditPart)o);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Composite getParentComposite() {
		Composite parentComposite = (Composite)selectedElement.getViewer().getControl();
		return new Composite(parentComposite, SWT.BORDER);
	}

	@Override
	protected org.eclipse.gef.GraphicalEditPart getSelectedElement() {
		return selectedElement;
	}

}
