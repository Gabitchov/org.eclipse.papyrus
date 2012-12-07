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
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.UnsetCommand;

/**
 * 
 * This class allows to do unset on a feature using a command
 * 
 */
public class TransactionalUnsetter {


	/**
	 * the source eobject
	 */
	private final Command cmd;

	/**
	 * the editing domain used for the command
	 */

	private final TransactionalEditingDomain domain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        the eobject to modify
	 * @param feature
	 *        the feature on which we want to do an unset
	 */
	public TransactionalUnsetter(final EObject source, final EStructuralFeature feature) {
		domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(source);
		cmd = new UnsetCommand((TransactionalEditingDomain)domain, source, feature);
	}

	/**
	 * this method do the unset
	 */
	public void doUnset() {
		domain.getCommandStack().execute(cmd);
	}
}
