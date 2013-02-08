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

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.nattable.controlmode.helpers.TableMoveHelper;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlCommand;


public class PapyrusTableControlCommand implements IControlCommand {

	public PapyrusTableControlCommand() {
		// TODO Auto-generated constructor stub
	}

	public void control(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify) {
		switch(state) {
		case POST_NOTATION:
			TableMoveHelper.addAllTableMoveCommands(domain, selection, source, target, commandToModify);
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
				TableMoveHelper.addAllPageRefTableMoveCommands((TransactionalEditingDomain)domain, selection, source, target, windowsMngr, commandToModify);
			}
			break;
		case POST_MODEL:
			break;
		case PRE_DI:
			break;
		case PRE_MODEL:
			break;
		case PRE_NOTATION:
			break;
		default:
			break;
		}
	}

	public boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target) {
		if(state == STATE_CONTROL.POST_NOTATION || state == STATE_CONTROL.POST_DI) {
			return true;
		}
		return false;
	}

}
