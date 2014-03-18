/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;


public class RemoveAllModelStyleSheetValueCommand extends RecordingCommand {

	private Collection<?> values;

	private Resource resource;

	public RemoveAllModelStyleSheetValueCommand(TransactionalEditingDomain domain, Resource resource, Collection<?> values) {
		super(domain);
		this.resource = resource;
		this.values = values;
	}

	@Override
	public void doExecute() {
		for(Object value : values) {
			if(value instanceof StyleSheetReference) {
				resource.getContents().remove((StyleSheetReference)value);
			}
		}
	}

}
