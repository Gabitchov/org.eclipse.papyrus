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
 *  Patrick Tessier( CEA LIST) patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.interfaces;

import java.util.List;

/**
 * Interface representing category from the EMF Validation Framework.
 * 
 * 
 */
public interface Category {

	/**
	 *
	 * 
	 * @return  ID of a category
	 */
	public String getID();

	/**
	 * 
	 * 
	 * @return Name of a category
	 */
	public String getName();

	/**
	 * 
	 * @return  Information whether category is mandatory
	 */
	public boolean isMandatory();

	/**
	 * 
	 * @return Sub-categories of a given category
	 */
	public List<Category> getSubcategories();


	/**
	 * Adding list of sub-categories
	 * 
	 * @param subCategories
	 *            list of sub-categories to add
	 */
	public void addSubcategories(List<Category> subCategories);

	/**
	 * @return Access to parent category
	 */
	public Category getParentCategory();

}
