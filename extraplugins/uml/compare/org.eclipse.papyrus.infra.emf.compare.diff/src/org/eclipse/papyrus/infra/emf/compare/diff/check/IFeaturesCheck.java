/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.check;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * 
 * This interface allows to define checker enable to ignore differences following the context
 * 
 */
public interface IFeaturesCheck {

	/**
	 * return <code>true</code> if the feature should be ignored
	 * 
	 * @param feature
	 * @return
	 */
	public boolean shouldBeIgnored(final EStructuralFeature feature);

	/**
	 * return <code>true</code> if the feature should be ignored in this context
	 * 
	 * @param feature
	 *        a feature
	 * @param context
	 *        the context of this attribute
	 * @return
	 */
	public boolean shouldBeIgnored(final EStructuralFeature feature, final EObject context);

}
