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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintProvider;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Mode;

/**
 * this is constraint constraint provider see extension point 
 *
 */
public class ConstraintProviderImpl implements IConstraintProvider {

	private List<IConstraintsCategory> constraintsCategories = new ArrayList<IConstraintsCategory>();
	private Mode mode;
	private boolean cache;
	private EPackage ePackage=null;


/**
 * 
 * Constructor.
 *
 */
	public ConstraintProviderImpl() {

		this.mode = Mode.Batch;

		this.cache = false;

	}

	public Mode getMode() {
		// TODO Auto-generated method stub
		return this.mode;
	}

	public boolean getCache() {
		// TODO Auto-generated method stub
		return this.cache;
	}


	public List<IConstraintsCategory> getConstraintsCategories() {
		// TODO Auto-generated method stub
		return constraintsCategories;
	}


	public void addConstraintCategories(
			List<IConstraintsCategory> constraintCategories) {
		// TODO Auto-generated method stub
		this.constraintsCategories.addAll(constraintCategories);
	}

	public EPackage getEPackage() {
		return ePackage;
	}

	public void setEPackage(EPackage ePackage){
		this.ePackage=ePackage;
	}
}
