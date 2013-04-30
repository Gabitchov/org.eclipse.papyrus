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
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Type;

/**
 * Navigates from a TypedElement to its Type declaration
 * 
 * @author Camille Letavernier
 */
public class TypedNavigableElement implements NavigableElement {

	protected final Type type;

	/**
	 * 
	 * @param type
	 *        The Type to navigate to. May be null.
	 */
	public TypedNavigableElement(Type type) {
		this.type = type;
	}

	public String getLabel() {
		String label = "Go to type" + getTypeLabel();
		return label;
	}

	public String getDescription() {
		return "Go to the type declaration of this TypedElement" + getTypeLabel();
	}

	protected String getTypeLabel() {
		if(type == null) {
			return " (Undefined)";
		} else {
			return " (" + type.getName() + ")";
		}
	}

	@Deprecated
	public void navigate(IRevealSemanticElement navigationContext) {
		if(!isEnabled()) {
			return;
		}

		navigationContext.revealSemanticElement(Collections.singletonList(type));
	}

	public Image getImage() {
		if(type == null) {
			return null;
		}

		try {
			return ServiceUtilsForEObject.getInstance().getServiceRegistry(type).getService(LabelProviderService.class).getLabelProvider().getImage(type);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Enabled when the type is defined
	 */
	public boolean isEnabled() {
		return type != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean navigate(NavigationTarget navigationContext) {
		if(!isEnabled()) {
			return false;
		}
		return navigationContext.revealElement(type);
	}
}
