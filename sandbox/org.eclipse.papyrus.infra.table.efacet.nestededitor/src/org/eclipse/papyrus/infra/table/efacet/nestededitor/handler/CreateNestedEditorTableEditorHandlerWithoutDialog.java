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
package org.eclipse.papyrus.infra.table.efacet.nestededitor.handler;



public class CreateNestedEditorTableEditorHandlerWithoutDialog extends CreateNestedEditorTableEditorHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNestedEditorTableEditorHandlerWithoutDialog() {
		super();
	}


	@Override
	protected boolean shouldOpenNameDialog() {
		return false;
	}
}
