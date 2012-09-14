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
package org.eclipse.papyrus.infra.table.efacet.controlmode.handlers;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.notation.NotationModel;
import org.eclipse.papyrus.infra.services.controlmode.commands.IUncontrolCommand;
import org.eclipse.papyrus.infra.table.efacet.controlmode.helpers.PapyrusTableMoveHelper;


/**
 * Does the exact same thing as PapyrusTableControlCommand, but moves the tables back
 * to the resource they were initially created in.
 * 
 */
public class PapyrusTableUncontrolCommand implements IUncontrolCommand {

	/**
	 * {@inheritDoc}
	 */
	public void uncontrol(final EditingDomain domain, final EObject selection, final STATE_CONTROL state, final Resource source, final Resource target, final CompoundCommand commandToModify) {
		switch(state) {
		case POST_MODEL:
			PapyrusTableMoveHelper.addAllTableMoveCommands(domain, selection, target, commandToModify);
			break;
		default:
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(final EObject selection, final STATE_CONTROL state, final Resource source, final Resource target) {
		return NotationModel.NOTATION_FILE_EXTENSION.equals(target.getURI().fileExtension());
	}

}