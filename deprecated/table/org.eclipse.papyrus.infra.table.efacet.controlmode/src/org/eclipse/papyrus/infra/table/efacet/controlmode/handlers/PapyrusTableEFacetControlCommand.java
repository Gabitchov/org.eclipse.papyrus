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

package org.eclipse.papyrus.infra.table.efacet.controlmode.handlers;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.notation.NotationModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlCommand;
import org.eclipse.papyrus.infra.table.efacet.controlmode.helpers.PapyrusTableEFacetMoveHelper;



/**
 * ControlCommand in charge of moving the tables efacetwhen controlling a package.
 *
 */
public class PapyrusTableEFacetControlCommand implements IControlCommand {

	/**
	 * {@inheritDoc}
	 */
	public void control(final EditingDomain domain, final EObject selection, final STATE_CONTROL state, final Resource source, final Resource target, final CompoundCommand commandToModify) {
		switch(state) {
		case POST_NOTATION:
			PapyrusTableEFacetMoveHelper.addAllTableMoveCommands(domain, selection, source, target, commandToModify);
			break;
		case POST_DI:
			//FIXME : it should exist a best way to get the SashWindowsMngr
			SashWindowsMngr windowsMngr = null;
			final Iterator<Adapter> iter = selection.eAdapters().iterator();
			while(iter.hasNext() && windowsMngr == null) {
				final Adapter current = iter.next();
				if(current.isAdapterForType(SashWindowsMngr.class)) {
					windowsMngr = (SashWindowsMngr)current.getTarget();
				}
			}
			if(windowsMngr != null) {
				PapyrusTableEFacetMoveHelper.addAllPageRefTableMoveCommands((TransactionalEditingDomain)domain, selection, source, target, windowsMngr, commandToModify);
			}
			break;
		default:
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(final EObject selection, final STATE_CONTROL state, final Resource source, final Resource target) {
		return NotationModel.NOTATION_FILE_EXTENSION.equals(target.getURI().fileExtension()) || DiModel.DI_FILE_EXTENSION.equals(target.getURI().fileExtension());
	}


}
