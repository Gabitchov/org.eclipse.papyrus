/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
 * implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;

/**
 * A {@link LabelDecorator} that removes the type prefix that appears with some label providers.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
// fjcano #291192
public class NoTypePrefixLabelDecorator extends LabelDecorator {

	@Override
	public Image decorateImage(Image image, Object element, IDecorationContext context) {
		return image;
	}

	@Override
	public String decorateText(String text, Object element, IDecorationContext context) {
		return removeTypeName(element, text);
	}

	private static String prefixTypeReplacement = "";

	protected String removeTypeName(Object element, String label) {
		if (element != null && label != null) {
			String typePrefix = getTypePrefix(element);
			if (typePrefix != null) {
				label = label.replaceAll(typePrefix, prefixTypeReplacement);
				label = label.trim();
			}
		}
		return label;
	}

	protected String getTypePrefix(Object element) {
		String typeName = getTypeName(element);
		return typeName != null ? "<" + typeName + ">" : null;
	}

	protected String getTypeName(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			if (eObject.eClass() != null) {
				if (eObject.eClass().getName() != null) {
					return convertNameToDisplayName(eObject.eClass().getName());
				}
			}
		}
		return null;
	}

	protected String convertNameToDisplayName(String name) {
		if (name == null) {
			return name;
		}
		StringBuilder displayNameBuilder = new StringBuilder(name.length() + 5);
		char character = 'a';
		for (int index = 0; index < name.length(); index++) {
			character = name.charAt(index);
			if (Character.isUpperCase(character) && index > 0) {
				displayNameBuilder.append(" ");
				displayNameBuilder.append(character);
			} else {
				displayNameBuilder.append(character);
			}
		}
		return displayNameBuilder.toString();
	}

	@Override
	public boolean prepareDecoration(Object element, String originalText, IDecorationContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public Image decorateImage(Image image, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String decorateText(String text, Object element) {
		return removeTypeName(element, text);
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
