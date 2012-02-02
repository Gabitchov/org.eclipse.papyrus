/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;


public class RedoHandler extends AbstractEMFCompareHandler {


	public RedoHandler() {
		int d = 0;
		d++;
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		final boolean enabled = super.isEnabled();
		if(enabled) {
			final boolean state = getEditingDomain().getCommandStack().canRedo();
			System.out.println("redo state = " + state);

			return getEditingDomain().getCommandStack().canUndo();
		}
		return false;
	}
	//	
	//	@Override
	//	public boolean isEnabled() {
	//		// TODO Auto-generated method stub
	//		return true;
	//	}

	//	public booleanisActive()

}
