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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;

public class SetNodeVisibilityCommand extends RecordingCommand {

	/** view to modify */
	protected View view;

	/** visibility to set */
	protected Boolean isVisible;

	public SetNodeVisibilityCommand(TransactionalEditingDomain domain, View view, Boolean isVisible) {
		super(domain);
		this.view = view;
		this.isVisible = isVisible;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		if(view.isVisible() != isVisible) {
			view.setVisible(isVisible);
		}
	}
}
