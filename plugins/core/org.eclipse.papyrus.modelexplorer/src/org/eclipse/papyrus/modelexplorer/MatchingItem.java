/*****************************************************************************
 * Copyright (c) 2011 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;

/**
 * This class is only useful to create a fake item
 * to match an existing facet item in a facet viewer.
 * To do that it mimics the behavior of the equals and hashCode methods
 * of the facet items.
 * 
 * @author mvelten
 * 
 */
public class MatchingItem {

	protected EObject element;

	protected EReference ref;

	/**
	 * create a MatchingItem which will match ModelElementItem items
	 * having element returned by {@link ModelElementItem#getEObject()}
	 * 
	 * @param element
	 */
	public MatchingItem(EObject element) {
		this(element, null);
	}

	/**
	 * create a MatchingItem which will match LinkItem items
	 * having parent returned by {@link LinkItem#getParent()} and ref returned by {@link LinkItem#getReference()}
	 * 
	 * @param parent
	 * @param ref
	 */
	public MatchingItem(EObject parent, EReference ref) {
		this.element = parent;
		this.ref = ref;
	}

	public EObject getElement() {
		return element;
	}

	public EReference getParentRef() {
		return ref;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ModelElementItem) {
			// don't match if ref is null since we want a LinkItem in this case
			if(ref == null && element != null) {
				return element.equals(((ModelElementItem)obj).getEObject());
			}
		}
		if(obj instanceof LinkItem) {
			if(ref != null && element != null) {
				return element.equals(((LinkItem)obj).getParent()) && ref.equals(((LinkItem)obj).getReference());
			}
		}

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		if(element != null) {
			if(ref != null) {
				// use LinkItem algo
				final int hashPrime1 = 47;
				final int hashPrime2 = 13;
				return ref.hashCode() * hashPrime1 + element.hashCode() + hashPrime2;
			} else {
				// use ModelElementItem algo
				return element.hashCode();
			}
		}
		return 0;
	}
}
