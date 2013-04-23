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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.namereferences;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A Parser Helper to replace references to NamedElements in a text
 * 
 * It relies on a parser to search references and replace them with a text value
 * 
 * @author Camille Letavernier
 * 
 */
public class NameReferencesHelper extends TextReferencesHelper {

	private Adapter listener;

	public NameReferencesHelper() {
		super();
		//Empty
	}

	/**
	 * 
	 * @param baseResource
	 *        The resource against which the link uris will be resolved
	 */
	public NameReferencesHelper(Resource baseResource, Adapter listener) {
		super(baseResource);
		this.listener = listener;
	}

	@Override
	protected String decorate(String text) {
		return "<u>" + text + "</u>";
	}

	/**
	 * Returns the String replacement for the given element
	 */
	@Override
	protected String getReplacement(EObject elementToReplace, String cachedValue) {
		if(elementToReplace == null) {
			return UNKNOWN_ELEMENT;
		}

		if(elementToReplace.eIsProxy()) {
			return PROXY_ELEMENT;
		}

		if(elementToReplace instanceof NamedElement) {
			NamedElement target = (NamedElement)elementToReplace;
			if(!target.eAdapters().contains(listener)) {
				//Listen on value changes (NamedElement#name)
				target.eAdapters().add(listener);
			}

			if(!target.eResource().eAdapters().contains(listener)) {
				//Listen on resource changes (Deletion)
				target.eResource().eAdapters().add(listener);
			}

			if(target.eContainer() != null && !target.eContainer().eAdapters().contains(listener)) {
				//Listen on the contents of the parent element (Deletion)
				target.eContainer().eAdapters().add(listener);
			}

			if(target.getName() == null) {
				return "UNNAMED";
			} else {
				return target.getName();
			}
		}

		if(cachedValue == null) {
			return UNKNOWN_ELEMENT;
		}

		return cachedValue + " (Missing)";
	}

}
