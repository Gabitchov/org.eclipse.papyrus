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
 *  Patrick Tessier (CEA LIST) patrick.Tessuier@cea.fr - modification 
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category;

/**
 * Implementation of a category interface.
 * 
 * 
 */
public class CategoryImpl implements Category {


	private List<Category> subCategories = new ArrayList<Category>();

	private Category parentCategory;
	private String id;


	/**
	 * 
	 * Constructor.
	 *
	 * @param name the name of the category
	 * @param parentCategory
	 */
	public CategoryImpl(String name, Category parentCategory) {
		this.id = name;
		this.name = name;
		this.isMandatory = false;
		this.parentCategory = parentCategory;
	}

	/**
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category#getID()
	 *
	 */
	public String getID() {
		return this.id;
	}

/**
 * 
 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category#getName()
 *
 */
	public String getName() {
		return this.name;
	}

	private String name;

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category#isMandatory()
	 *
	 */
	public boolean isMandatory() {
		return this.isMandatory;
	}

	private boolean isMandatory;

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category#getSubcategories()
	 *
	 */
	public List<Category> getSubcategories() {
		return subCategories;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category#addSubcategories(java.util.List)
	 *
	 */
	public void addSubcategories(List<Category> subCategories) {
		this.subCategories.addAll(subCategories);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category#getParentCategory()
	 *
	 */
	public Category getParentCategory() {
		return this.parentCategory;
	}
}
