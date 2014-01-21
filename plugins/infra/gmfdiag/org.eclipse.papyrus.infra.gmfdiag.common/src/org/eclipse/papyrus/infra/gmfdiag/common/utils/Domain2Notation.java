/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;


/**
 * The Class Domain2Notation used for mapping between EObject and views
 */
public class Domain2Notation extends HashMap<EObject, Set<View>> {


	/**
	 * Maps view.
	 * 
	 * @param view
	 *        the view from which are mapped all subviews
	 */
	public void mapModel(View view) {
		if((view instanceof Connector || view instanceof Shape) && !(view instanceof BasicCompartment)) {
			putView(view);
		}
		@SuppressWarnings("unchecked")//$NON-NLS-1$
		List<View> children = view.getChildren();
		for(View child : children) {
			mapModel(child);
		}
		@SuppressWarnings("unchecked")//$NON-NLS-1$
		List<View> sourceEdges = view.getSourceEdges();
		for(View edge : sourceEdges) {
			mapModel(edge);
		}
	}


	/**
	 * Put view.
	 * 
	 * @param view
	 *        the view
	 */
	public void putView(View view) {
		EObject element = view.getElement();
		Set<View> set = this.get(element);
		if(set != null) {
			set.add(view);
		} else {
			Set<View> hashSet = new HashSet<View>();
			hashSet.add(view);
			put(element, hashSet);
		}
	}

	/**
	 * Put view.
	 * 
	 * @param element
	 *        the element
	 * @param view
	 *        the view
	 */
	public void putView(EObject element, View view) {
		Set<View> set = this.get(element);
		if(set != null) {
			set.add(view);
		} else {
			Set<View> hashSet = new HashSet<View>();
			hashSet.add(view);
			put(element, hashSet);
		}
	}

	/**
	 * Gets the first view, prefer the get(Object key) method to get all the views
	 * 
	 * @param key
	 *        the key
	 * @return the first view
	 */
	@Deprecated
	public View getFirstView(Object key) {
		Set<View> set = get(key);
		if(set != null) {
			return set.iterator().next();
		}
		return null;
	}
}
