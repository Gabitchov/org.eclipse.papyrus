/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.navigation.contributor;

import java.util.Collections;

import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

/**
 * Navigates from a TypedElement to its Type declaration
 * 
 * @author Camille Letavernier
 */
public class TypedNavigableElement implements NavigableElement {

	private final TypedElement typedElement;

	public TypedNavigableElement(TypedElement typedElement) {
		this.typedElement = typedElement;
	}

	public String getLabel() {
		String label = "Open type declaration" + getTypeLabel();
		return label;
	}

	public String getDescription() {
		return "Opens the type declaration of this TypedElement" + getTypeLabel();
	}

	private String getTypeLabel() {
		if(typedElement.getType() == null) {
			return " (Undefined)";
		} else {
			return " (" + typedElement.getType().getName() + ")";
		}
	}

	public void navigate(IRevealSemanticElement navigationContext) {
		if(!isEnabled()) {
			return;
		}

		Type type = typedElement.getType();
		navigationContext.revealSemanticElement(Collections.singletonList(type));
	}

	public Image getImage() {
		if(typedElement.getType() == null) {
			return null;
		}

		try {
			return ServiceUtilsForEObject.getInstance().getServiceRegistry(typedElement).getService(LabelProviderService.class).getLabelProvider().getImage(typedElement.getType());
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Enabled when the type is defined
	 */
	public boolean isEnabled() {
		return typedElement.getType() != null;
	}

}
