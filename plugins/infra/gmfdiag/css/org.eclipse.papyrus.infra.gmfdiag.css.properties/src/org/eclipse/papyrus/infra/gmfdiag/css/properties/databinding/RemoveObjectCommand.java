/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël Adam (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *  
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * 
 * Command to remove an EObject from its containing resource and/or its containing object.
 * 
 * @author Mickael ADAM
 *
 */
public class RemoveObjectCommand extends RecordingCommand {

	EObject object;

	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 * @param object
	 */
	public RemoveObjectCommand(TransactionalEditingDomain domain, EObject object) {
		super(domain);
		this.object = object;
	}

	@Override
	protected void doExecute() {
		EcoreUtil.remove(object);
	}
}
