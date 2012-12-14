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

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlCommand;
import org.eclipse.papyrus.uml.profilefacet.utils.ProfileFacetSetMoveHelper;



/**
 * ControlCommand in charge of moving the tables when controlling a package.
 * 
 */
public class ProfileFacetSetControlCommand implements IControlCommand {

	/**
	 * {@inheritDoc}
	 */
	public void control(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case POST_NOTATION:
			ProfileFacetSetMoveHelper.addAllFacetSetMoveCommands(domain, selection, source, target, commandToModify);
			break;
//		case POST_DI:
//			TableMoveHelper.addAllTableMoveCommands(domain, selection, source, target, commandToModify);
//			//FIXME : it should exist a best way to get the SashWindowsMngr
//			SashWindowsMngr windowsMngr = null;
//			final Iterator<Adapter> iter = selection.eAdapters().iterator();
//			while(iter.hasNext() && windowsMngr == null) {
//				final Adapter current = iter.next();
//				if(current.isAdapterForType(SashWindowsMngr.class)) {
//					windowsMngr = (SashWindowsMngr)current.getTarget();
//				}
//			}
//			if(windowsMngr != null) {
//				TableMoveHelper.addAllPageRefTableMoveCommands((TransactionalEditingDomain)domain, selection, source, target, windowsMngr, commandToModify);
//			}
//			break;
		default:
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		return /*DiModel.DI_FILE_EXTENSION.equals(target.getURI().fileExtension()) ||*/ state == STATE_CONTROL.POST_NOTATION;
	}


}
