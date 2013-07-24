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
package org.eclipse.papyrus.infra.emf.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Represents a value replacement.
 * 
 * @author Camille Letavernier
 * 
 */
public interface Replacement extends EStructuralFeature.Setting {

	/**
	 * Returns the old value
	 * 
	 * @return
	 *         The value which has been replaced
	 */
	public EObject getOldValue();
}
