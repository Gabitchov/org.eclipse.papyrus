/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layers.stackmodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.uml2.uml.NamedElement;

import com.google.common.base.Predicate;

/**
 * A Predicate used to filter {@link View} allowed by {@link Layer}.
 * 
 * @author cedric dumoulin
 *
 */
public class LayerDiagramViewPredicate implements Predicate<View> {

	/**
	 * Singleton instnace.
	 */
	public static final LayerDiagramViewPredicate instance = new LayerDiagramViewPredicate();
	
	/**
	 * Return true if the view is allowed by Layers.
	 * 
	 * @see com.google.common.base.Predicate#apply(java.lang.Object)
	 *
	 * @param view
	 * @return
	 */
	@Override
	public boolean apply(View view) {
		
		// View should be Shape or Edge
		if( ! (view instanceof Shape || view instanceof Edge ) ) {
			return false;
		}

		// Domain element should be set and should be NamedElement
		EObject ele = view.getElement();
		if( ele == null || !(ele instanceof NamedElement) ) {
			return false;
		}
		// ok
		return true;
	}

}
