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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.sysml.table.efacet.requirement.handler;



public class CreateRequirementEditorHandlerWithoutDialog extends CreateRequirementTableEditorHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateRequirementEditorHandlerWithoutDialog() {
		super();
	}


	@Override
	protected boolean shouldOpenNameDialog() {
		return false;
	}
}
