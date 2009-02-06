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
 * @author Patrick Tessier
 * 
 *        this command is to change the position of a reference value in to a set
 */
public class MoveReferenceCommand extends RecordingCommand {

	private EObject element;

	private EStructuralFeature feature;

	private Object value;

	private int index;

	/**
	 * this command is to change the position of a reference value in to a set
	 * 
	 * @param domain
	 *            the transactional editing domain
	 * @param element
	 *            the element that own the ereference
	 * @param feature
	 *            the ereference
	 * @param value
	 *            the value which the position will change
	 * @param index
	 *            the new position of the value
	 */
	public MoveReferenceCommand(TransactionalEditingDomain domain, EObject element, EStructuralFeature feature, Object value, int index) {
		super(domain, "addValue", "addValue");
		this.element = element;
		this.feature = feature;
		this.value = value;
		this.index = index;
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
		((EList) (element.eGet(feature))).move(index, value);
	}

}
