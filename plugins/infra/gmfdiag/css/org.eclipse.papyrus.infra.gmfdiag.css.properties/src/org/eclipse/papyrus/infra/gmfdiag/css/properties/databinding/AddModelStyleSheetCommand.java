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
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class AddModelStyleSheetCommand extends RecordingCommand {

	private Resource resource;

	private EObject object;

	public AddModelStyleSheetCommand(TransactionalEditingDomain domain, Resource resource, EObject object) {
		super(domain);
		this.resource = resource;
		this.object = object;
	}

	public void doExecute() {
		//add ModelSteelSheet
		resource.getContents().add(object);
	}
}
