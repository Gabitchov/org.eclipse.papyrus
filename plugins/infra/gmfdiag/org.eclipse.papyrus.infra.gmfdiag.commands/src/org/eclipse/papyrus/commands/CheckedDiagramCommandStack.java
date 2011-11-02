/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;

/**
 * This DiagramCommandStack uses CheckedOperationHistory instead of the default one.
 * 
 * @author vhemery
 */
public class CheckedDiagramCommandStack extends DiagramCommandStack {
	
	protected IOperationHistory operationHistory;

	public CheckedDiagramCommandStack(IDiagramEditDomain editDomain) {
		super(editDomain);
		operationHistory = CheckedOperationHistory.getInstance();
	}

	@Override
	protected IOperationHistory getOperationHistory() {
		return operationHistory;
	}

}
