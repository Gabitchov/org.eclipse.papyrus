/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.utils.ExtendedURIUtil;
import org.eclipse.uml2.uml.Element;

import com.google.common.base.Predicate;


/**
 * The Class MatchingURIObject.
 * Predicate that will return true if the EObject belong to the set of {@link IExtendedURI}
 */
public class MatchingURIObject implements Predicate<EObject> {

	private Set<IExtendedURI> uris;

	public MatchingURIObject(Set<IExtendedURI> uris) {
		super();
		this.uris = uris;
	}

	public boolean apply(EObject input) {
		List<EObject> objectToTEObjects = new ArrayList<EObject>();
		objectToTEObjects.add(input);
		objectToTEObjects.addAll(NotationUtils.getLoadedAssociatedDiagrams(input));
		for(IExtendedURI extendedURI : uris) {
			for(EObject o : objectToTEObjects) {
				boolean contained = ExtendedURIUtil.isIncluded(o, extendedURI);

				if(contained) {
					return contained;
				}
			}
		}
		return false;
	}


	protected EObject getSemanticObject(EObject eObject) {
		EObject result = null;
		if(eObject instanceof Element) {
			result = eObject;
		} else if(eObject instanceof View) {
			//Handle view
			result = ((View)eObject).getElement();
		} else {
			//Handle setereotype
			Element baseElement = org.eclipse.uml2.uml.util.UMLUtil.getBaseElement(eObject);
			if(baseElement != null) {
				result = baseElement;
			}
			//TODO handle tab
		}
		return result;
	}




}
