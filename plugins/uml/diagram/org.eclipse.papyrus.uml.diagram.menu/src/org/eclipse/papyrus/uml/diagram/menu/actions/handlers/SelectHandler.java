/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.uml.diagram.menu.actions.AbstractParametricAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.SelectAction;

/**
 * Handler for the {@link SelectAction}
 * 
 * 
 * 
 */
public class SelectHandler extends AbstractParametricHandler {

	/** id of the parameter for the ZOrderAction */
	public static final String parameterID = "select_parameter"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the command parameter
	 */
	public SelectHandler(String parameter) {
		super(parameterID, parameter);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SelectHandler() {
		super(parameterID);
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AbstractParametricAction action = new SelectAction(this.parameter, getSelectedElements());
		action.doRun(new NullProgressMonitor());
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		AbstractParametricAction action = new SelectAction(this.parameter, getSelectedElements());
		setBaseEnabled(action.isEnabled());
	}
}
