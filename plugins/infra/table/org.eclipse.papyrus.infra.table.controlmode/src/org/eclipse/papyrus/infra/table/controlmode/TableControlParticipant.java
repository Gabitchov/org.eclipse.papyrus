/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.controlmode;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;
import org.eclipse.papyrus.infra.table.instance.util.TableContentsUtils;


/**
 * Participant used to move tab in correct resources
 * 
 * @author adaussy
 * 
 */
public class TableControlParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	public String getID() {
		return "org.eclipse.papyrus.infra.table.controlmode.TableControlParticipant";////$NON-NLS-0$
	}

	public int getPriority() {
		return 40;
	}

	public boolean provideControlCommand(ControlModeRequest request) {
		EObject objectToControl = request.getTargetObject();
		//If the element is a package then it should be openable in stand alone
		if(objectToControl == null) {
			return false;
		}
		//Only do something if there is some table inside
		Iterable<EObject> ite = TableContentsUtils.createDescendantTablesIterable(objectToControl);
		return ite.iterator().hasNext();

	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		// don't create the di resource since it is handled by the sash participant
		return null;
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		return new ControlTableCommand(request);
	}

	public boolean provideUnControlCommand(ControlModeRequest request) {
		return provideControlCommand(request);
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		return new ControlTableCommand(request);
	}

	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		// don't remove the di resource since it is handled by the sash participant
		return null;
	}
}
