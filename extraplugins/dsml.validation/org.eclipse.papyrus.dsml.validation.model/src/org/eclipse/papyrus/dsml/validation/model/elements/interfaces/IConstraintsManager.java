/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *   Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.interfaces;

import java.util.List;

/**
 * Interface which specifies methods for the manager taking charge of a
 * constraints defined in a profile.
 * 
 */
public interface IConstraintsManager {


	/**
	 * Access to the list of constraint providers which are necessary for the
	 * specification of a validation plugin.
	 * 
	 * @return list of constraint providers
	 */
	public List<IConstraintProvider> getConstraintsProviders();

 
	/**
	 * Access to the prime category.
	 * 
	 * @return prime category
	 */
	public Category getPrimeCategory();

}
