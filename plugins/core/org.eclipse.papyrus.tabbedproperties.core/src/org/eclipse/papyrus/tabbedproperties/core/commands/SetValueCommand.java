/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Goulwen Le Fur (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * this command is used to change the value of Eattribute
 * 
 */
public class SetValueCommand extends RecordingCommand {

	private EObject element;

	private EStructuralFeature feature;

	private Object newValue;

	/**
	 * this command is used to change the value of Eattribute
	 * 
	 * @param domain
	 *            the transactional editing domain
	 * @param element
	 *            the element which we would like to change a value
	 * @param feature
	 *            the attribute that we change the value
	 * @param newValue
	 *            the new value
	 */
	public SetValueCommand(TransactionalEditingDomain domain, EObject element, EStructuralFeature feature, Object newValue) {
		super(domain, "SetValue", "SetValue");
		this.element = element;
		this.feature = feature;
		this.newValue = newValue;
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
		element.eSet(feature, newValue);
	}

}
