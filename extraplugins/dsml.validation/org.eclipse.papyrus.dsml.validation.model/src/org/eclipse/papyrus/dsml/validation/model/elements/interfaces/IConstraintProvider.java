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

import org.eclipse.emf.ecore.EPackage;

/**
 * Interface representing constraint provider from the EMF Validation Framework
 */
public interface IConstraintProvider {
	/**
	 * 
	 * @return  the mode of this provider
	 */
	public Mode getMode();

	/**
	 * 
	 * @return the cache of the provider
	 */
	public boolean getCache();
	
	
	public EPackage getEPackage();
	
	public void setEPackage(EPackage ePackage);

	/**
	 * 
	 * @return the list of categories
	 */
	public List<IConstraintsCategory> getConstraintsCategories();

	/**
	 * add categories
	 * @param constraintCategories a list of categories
	 */
	public void addConstraintCategories(
			List<IConstraintsCategory> constraintCategories);

}
