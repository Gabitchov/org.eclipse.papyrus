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
 * this command is used to remove a value in an ereference
 * 
 * @author patrick Tessier
 */
public class RemoveReferenceCommand extends RecordingCommand {

	private EObject element;

	private EStructuralFeature feature;

	private Object removedValue;

	/**
	 * this command is used to remove a value in an ereference
	 * 
	 * @param domain
	 *            the transactional editing domain
	 * @param element
	 *            the element that own the ereference
	 * @param feature
	 *            the ereference
	 * @param removedValue
	 *            the value that we want to remove
	 */
	public RemoveReferenceCommand(TransactionalEditingDomain domain, EObject element, EStructuralFeature feature, Object removedValue) {
		super(domain, "removeValue", "removeValue");
		this.element = element;
		this.feature = feature;
		this.removedValue = removedValue;
	}

	@Override
	/*
	 * @inheritedDoc
	 */
	protected void doExecute() {
		((EList) (element.eGet(feature))).remove(removedValue);
	}

}
