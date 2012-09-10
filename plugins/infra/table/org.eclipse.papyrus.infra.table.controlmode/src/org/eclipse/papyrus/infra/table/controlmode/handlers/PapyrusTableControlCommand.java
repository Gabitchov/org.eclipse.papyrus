/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Melois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.controlmode.handlers;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlCommand;
import org.eclipse.papyrus.infra.table.controlmode.helpers.TableMoveHelper;


/**
 * ControlCommand in charge of moving the tables when controlling a package.
 *
 */
public class PapyrusTableControlCommand implements IControlCommand {

	/**
	 * {@inheritDoc}
	 */
	public void control(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case POST_DI:
			TableMoveHelper.addAllTableMoveCommands(domain, selection, target, commandToModify);
			break;
		default:
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		return DiModel.DI_FILE_EXTENSION.equals(target.getURI().fileExtension());
	}


}
