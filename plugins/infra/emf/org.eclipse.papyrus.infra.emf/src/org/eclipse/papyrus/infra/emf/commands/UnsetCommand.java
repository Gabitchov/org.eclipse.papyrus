/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


public class UnsetCommand extends RecordingCommand {

	/**
	 * the source eobject
	 */
	private final EObject source;

	/**
	 * the feature
	 */
	private final EStructuralFeature feature;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param source
	 *        the eobject to modify
	 * @param feature
	 *        the feature to unset
	 */
	public UnsetCommand(final TransactionalEditingDomain domain, final EObject source, final EStructuralFeature feature) {
		super(domain, "Unset Command"); //$NON-NLS-1$
		this.source = source;
		this.feature = feature;
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 * 
	 */
	@Override
	protected void doExecute() {
		source.eUnset(feature);
	}

}
