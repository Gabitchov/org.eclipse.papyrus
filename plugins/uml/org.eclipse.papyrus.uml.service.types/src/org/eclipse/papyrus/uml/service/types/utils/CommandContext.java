/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Context holder for model element creation commands.
 */
public class CommandContext implements ICommandContext {

	private EObject container;

	private EReference reference;

	/** Constructor */
	public CommandContext(EObject container) {
		this.container = container;
	}

	/** Constructor */
	public CommandContext(EObject container, EReference reference) {
		this.container = container;
		this.reference = reference;
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getContainer() {
		return container;
	}

	/**
	 * {@inheritDoc}
	 */
	public EReference getReference() {
		return reference;
	}
}
