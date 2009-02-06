/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.codegen.actions;

import org.eclipse.gmf.internal.codegen.popup.actions.ExecuteTemplatesAction;
import org.eclipse.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation;
import org.eclipse.papyrus.codegen.PapyrusExecuteTemplatesOperation;

/**
 * Define the Papyrus Generate Action
 * 
 * @author tlandre
 */
public class PapyrusExecuteTemplateAction extends ExecuteTemplatesAction {

	@Override
	protected ExecuteTemplatesOperation createOperation() {
		return new PapyrusExecuteTemplatesOperation();
	}
}
