/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.common.providers.UMLAdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This class handles title label for tabbed properties.
 * 
 * @author Jerome Benois
 */
public class UMLObjectLabelProvider extends UMLAdapterFactoryLabelProvider implements ILabelProvider {

	public UMLObjectLabelProvider() {
		super();
	}

	@Override
	public String getText(Object element) {
		String title = "<unknown>";
		EObject model = getModel(element);
		if (model != null) {
			if (super.getText(model) != null) {
				title = super.getText(model);
			} else {
				ILabelProvider labelProvider = new AdapterFactoryLabelProvider(getAdapterFactory());
				title = labelProvider.getText(model);
			}
		}
		return title;
	}

	@Override
	public Image getImage(Object element) {
		EObject model = getModel(element);
		if (model != null) {
			return super.getImage(model);
		}
		return null;
	}

	private EObject getModel(Object element) {
		if (element != null && element instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) element;
			Object o = selection.getFirstElement();
			if (o instanceof IGraphicalEditPart) {
				IGraphicalEditPart editPart = (IGraphicalEditPart) o;
				EObject eObject = editPart.resolveSemanticElement();
				return eObject;
			}
		}
		return null;
	}

}
