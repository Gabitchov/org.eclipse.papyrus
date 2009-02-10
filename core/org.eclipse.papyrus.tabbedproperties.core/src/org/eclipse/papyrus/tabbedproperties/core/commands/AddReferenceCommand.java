/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * this command is used to add a reference to element of the model
 * 
 * @author Patrick Tessier
 * 
 */
public class AddReferenceCommand extends RecordingCommand {

	private EObject element;

	private EStructuralFeature feature;

	private Object addedValue;

	/**
	 * this command is used to add a reference to element of the model
	 * 
	 * @param domain
	 *            the transactional editing domain
	 * @param element
	 *            that has got this reference
	 * @param feature
	 *            thefeature that represents the reference
	 * @param addedValue
	 *            the value that will be added
	 */
	public AddReferenceCommand(TransactionalEditingDomain domain, EObject element, EStructuralFeature feature, Object addedValue) {
		super(domain, "addValue", "addValue");
		this.element = element;
		this.feature = feature;
		this.addedValue = addedValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	/*
	 * @inheritedDoc
	 */
	protected void doExecute() {
		((EList) (element.eGet(feature))).add(addedValue);
	}

}
