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
package org.eclipse.papyrus.uml.profilefacet.controlmode;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.services.controlmode.commands.IUncontrolCommand;
import org.eclipse.papyrus.uml.profilefacet.utils.ProfileFacetSetMoveHelper;


/**
 * Does the exact same thing as PapyrusTableControlCommand, but moves the tables back
 * to the resource they were initially created in.
 * 
 */
public class ProfileFacetSetUncontrolCommand implements IUncontrolCommand {

	/**
	 * {@inheritDoc}
	 */
	public void uncontrol(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case POST_NOTATION:
			ProfileFacetSetMoveHelper.addAllFacetSetMoveCommands(domain, selection, source, target, commandToModify);
			//FIXME : the control mode should provides POST_DI for uncontrol action
//			final ModelSet set = (ModelSet)source.getResourceSet();
//			final Resource sourceDi = set.getAssociatedResource(source, DiModel.MODEL_FILE_EXTENSION);
//			final Resource targetDi = set.getAssociatedResource(target, DiModel.MODEL_FILE_EXTENSION);
//			TableMoveHelper.addAllTableMoveCommands(domain, selection, sourceDi, targetDi, commandToModify);
			break;
		default:
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		if(state == STATE_CONTROL.POST_NOTATION) {//FIXME : the control mode should allow to uncontrol di file
			return true;
		}
		return false;
//		return DiModel.DI_FILE_EXTENSION.equals(target.getURI().fileExtension());
	}

}
