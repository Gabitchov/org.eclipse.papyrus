/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.core.ui.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * Provides usefull utility methods for ICompositeCreator instances
 * 
 * @author vhemery
 */
public class CreatorUtils {

	/** The offset to use for form data */
	private static final int OFFSET = 5;

	/** The adapter factory to use as label provider */
	private static AdapterFactoryLabelProvider adapterFactory = null;

	/**
	 * Get the form layout data to place element at top of the parent composite
	 * 
	 * @return form data
	 */
	public static FormData getTopFormData() {
		FormData data = new FormData();
		data.right = new FormAttachment(100, -OFFSET);
		data.left = new FormAttachment(0, OFFSET);
		data.top = new FormAttachment(0, OFFSET);
		return data;
	}

	/**
	 * Get the form layout data to place element under another
	 * 
	 * @param upperControl
	 *        control under which the element must be located
	 * @return form data
	 */
	public static FormData getFormDataUnder(Control upperControl) {
		FormData data = new FormData();
		data.right = new FormAttachment(100, -OFFSET);
		data.left = new FormAttachment(0, OFFSET);
		data.top = new FormAttachment(upperControl, OFFSET);
		return data;
	}

	/**
	 * Get the form layout data to place element under another, aligned on the right of the parent composite
	 * 
	 * @param upperControl
	 *        control under which the element must be located
	 * @return form data
	 */
	public static FormData getFormDataRightAlignedUnder(Control upperControl) {
		FormData data = new FormData();
		data.right = new FormAttachment(100, -OFFSET);
		data.top = new FormAttachment(upperControl, OFFSET);
		return data;
	}

	/**
	 * Get the label of a graphical edit part
	 * 
	 * @param editPart
	 *        the input part
	 * @return the string label
	 */
	public static String getLabel(IGraphicalEditPart editPart) {
		EObject eObject = editPart.resolveSemanticElement();
		return getCustomLabelProvider().getText(eObject);
	}

	/**
	 * Gets the custom label provider that parses label for EClass
	 * 
	 * @return the custom label provider
	 */
	public static ILabelProvider getCustomLabelProvider() {
		if(adapterFactory == null) {
			adapterFactory = new AdapterFactoryLabelProvider(new UMLItemProviderAdapterFactory()) {

				/**
				 * Override label provider for EClass
				 * 
				 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
				 */
				@Override
				public String getText(Object object) {
					String text = super.getText(object);
					if(object instanceof EClass) {
						return text.substring(0, text.indexOf("[") - 1);
					} else {
						return text;
					}
				}
			};
		}
		return adapterFactory;
	}

}
