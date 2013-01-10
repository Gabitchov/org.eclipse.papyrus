/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorGroup;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLSheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

	/**
	 * @generated
	 */
	public String getText(Object element) {
		element = unwrap(element);
		if(element instanceof UMLNavigatorGroup) {
			return ((UMLNavigatorGroup)element).getGroupName();
		}
		final IElementType etype = getElementType(getView(element));
		return etype == null ? "" : etype.getDisplayName();
	}

	/**
	 * @generated
	 */
	public Image getImage(final Object element) {
		final IElementType etype = getElementType(getView(unwrap(element)));
		return etype == null ? null : UMLElementTypes.getImage(etype);
	}

	/**
	 * @generated
	 */
	private Object unwrap(final Object element) {
		if(element instanceof IStructuredSelection) {
			return ((IStructuredSelection)element).getFirstElement();
		}
		return element;
	}

	/**
	 * @generated
	 */
	private View getView(final Object element) {
		if(element instanceof View) {
			return (View)element;
		}
		if(element instanceof IAdaptable) {
			return (View)((IAdaptable)element).getAdapter(View.class);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getElementType(View view) {
		// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
		while(view != null) {
			final int vid = UMLVisualIDRegistry.getVisualID(view);
			final IElementType etype = UMLElementTypes.getElementType(vid);
			if(etype != null) {
				return etype;
			}
			view = view.eContainer() instanceof View ? (View)view.eContainer() : null;
		}
		return null;
	}

}
