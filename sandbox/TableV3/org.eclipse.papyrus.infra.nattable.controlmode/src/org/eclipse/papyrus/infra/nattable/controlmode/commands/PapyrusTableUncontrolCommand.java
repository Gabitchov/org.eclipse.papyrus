/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.controlmode.commands;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.nattable.controlmode.helpers.TableMoveHelper;
import org.eclipse.papyrus.infra.services.controlmode.commands.IUncontrolCommand;


/**
 * Does the exact same thing as PapyrusTableControlCommand, but moves the tables back
 * to the resource they were initially created in.
 * 
 */
public class PapyrusTableUncontrolCommand implements IUncontrolCommand {

	/**
	 * {@inheritDoc}
	 */
	public void uncontrol(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case POST_NOTATION:
			final ModelSet set = (ModelSet)source.getResourceSet();
			final Resource sourceNotationFile = set.getAssociatedResource(source, NotationModel.NOTATION_FILE_EXTENSION);
			final Resource targetNotationFile = set.getAssociatedResource(target, NotationModel.NOTATION_FILE_EXTENSION);
			TableMoveHelper.addAllTableMoveCommands(domain, selection, sourceNotationFile, targetNotationFile, commandToModify);
			break;
		default:
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		if(state == STATE_CONTROL.POST_NOTATION) {
			return true;
		}
		return false;
	}

}
