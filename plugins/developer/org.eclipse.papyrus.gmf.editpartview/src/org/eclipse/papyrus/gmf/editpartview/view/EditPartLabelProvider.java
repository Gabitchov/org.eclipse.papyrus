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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Based on edit policy view from patrick.tessier@cea.fr
 */
package org.eclipse.papyrus.gmf.editpartview.view;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;


/**
 * This is the label provider to display edit parts
 * 
 */
public class EditPartLabelProvider implements ITableLabelProvider, ITableColorProvider {

	protected Color papyrusColor = new Color(Display.getDefault(), 0, 127, 14);

	protected Color customizableDropEditPolicyColor = new Color(Display.getDefault(), 0, 38, 255);

	public void removeListener(ILabelProviderListener listener) {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void dispose() {
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof GraphicalEditPart) {
			GraphicalEditPart editPart = (GraphicalEditPart)element;
			IFigure figure = editPart.getContentPane();
			Object model = editPart.getAdapter(EObject.class);
			switch(columnIndex) {
			case 0:
				return editPart.getClass().getSimpleName();
			case 1:
				if(model instanceof NamedElement) {
					return ((NamedElement)model).getName();
				}
				return "not a named element";
			case 2:
				return figure.getClass().getSimpleName();
			case 3:
				return figure.getBounds().toString();
			}
		}
		return "cannot display it: " + element;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public Color getForeground(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getBackground(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
};
