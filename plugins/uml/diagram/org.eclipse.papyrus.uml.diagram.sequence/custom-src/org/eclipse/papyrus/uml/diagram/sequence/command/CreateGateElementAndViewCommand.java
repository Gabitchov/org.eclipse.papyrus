/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CreateGateElementAndViewCommand extends CreateGateViewCommand {

	private boolean createInnerCFGate;

	/**
	 * Mark the gate as volatiled one, so the name can be changed.
	 */
	private boolean volatiled;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 * @param location
	 * @param label
	 * @param affectedFiles
	 */
	public CreateGateElementAndViewCommand(TransactionalEditingDomain domain, IAdaptable parentAdapter, Point location) {
		super(domain, parentAdapter, location, new ObjectAdapter());
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecute(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Gate gate = GateHelper.createGate((Element)getParentElement(), isCreateInnerCFGate());
		((ObjectAdapter)getGateAdapter()).setObject(gate);
		if(isVolatiled()) {
			GateHelper.setVolatile(gate, true);
		}
		return super.doExecute(monitor, info);
	}

	/**
	 * @return the createInnerGateForCombinedFragment
	 */
	public boolean isCreateInnerCFGate() {
		return createInnerCFGate;
	}

	/**
	 * @param createInnerCFGate
	 *        the createInnerGateForCombinedFragment to set
	 */
	public void setCreateInnerCFGate(boolean createInnerCFGate) {
		this.createInnerCFGate = createInnerCFGate;
	}

	/**
	 * @return the volatiled
	 */
	public boolean isVolatiled() {
		return volatiled;
	}

	/**
	 * @param volatiled
	 *        the volatiled to set
	 */
	public void setVolatiled(boolean volatiled) {
		this.volatiled = volatiled;
	}
}
