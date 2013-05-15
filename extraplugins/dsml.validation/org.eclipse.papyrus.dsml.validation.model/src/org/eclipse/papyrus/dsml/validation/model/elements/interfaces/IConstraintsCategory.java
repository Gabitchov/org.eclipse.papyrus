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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.interfaces;

import java.util.List;

/**
 * Interface representing constraint category from EMF Validation Framework
 * 
 * 
 */
public interface IConstraintsCategory extends Category{
	/**
	 * 
	 * @return constraints
	 */

	public List<IValidationRule> getConstraints();

	/**
	 * 
	 * @return the list of categories as a string
	 */
	public String getCategoriesList();


	/**
	 * add a list of constraint
	 * @param constraints
	 */
	public void addConstraints(List<IValidationRule> constraints);

}
