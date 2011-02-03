/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigation;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface allows to set the base name of an element.
 * The base can then be used to derive a more useful name,
 * containing the name of the element type for example.
 * @author mvelten
 *
 */
public interface IBaseNameSetter {
	public void setBaseName(String base, EObject toName);
}
