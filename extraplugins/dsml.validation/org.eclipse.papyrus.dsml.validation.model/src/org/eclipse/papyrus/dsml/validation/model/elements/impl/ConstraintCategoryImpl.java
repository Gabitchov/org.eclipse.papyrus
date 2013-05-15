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
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IValidationRule;

/**
 * Implementation of a constraint category interface.
 * 
 * 
 */
public class ConstraintCategoryImpl  extends CategoryImpl implements IConstraintsCategory {

	private List<IValidationRule> constraints = new ArrayList<IValidationRule>();

	private String categoriesList;


	/**
	 * 
	 * Constructor.
	 *
	 * @param category
	 */
	public ConstraintCategoryImpl(String name, Category parentCategory) {
		super(name, parentCategory);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory#getCategoriesList()
	 *
	 */
	public String getCategoriesList() {
		return this.categoriesList;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory#getConstraints()
	 *
	 */
	public List<IValidationRule> getConstraints() {
		return constraints;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory#addConstraints(java.util.List)
	 *
	 * @param constraints
	 */
	public void addConstraints(List<IValidationRule> constraints) {
		this.constraints.addAll(constraints);
	}

}
