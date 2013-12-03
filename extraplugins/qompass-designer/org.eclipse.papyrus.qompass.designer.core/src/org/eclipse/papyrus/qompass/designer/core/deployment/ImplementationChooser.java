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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.deployment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;

/**
 * Choose a component implementation for a given component type
 */
public interface ImplementationChooser {
	/**
	 * Choose a component implementation from a list of available implementations
	 * @param componentType a (abstract) component
	 * @param implList a list of available component implementations
	 * @return the chosen implementation.
	 */
	public Class chooseImplementation(Class componentType, EList<Class> implList);
};
