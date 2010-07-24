/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.controlmode.commands;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * The Interface IUncontrolCommand that defines custom uncontrol action executed with the default Papyrus uncontrol action.
 */
public interface IUncontrolCommand {

	/**
	 * Uncontrol action applied on the specified selection
	 * 
	 * @param domain
	 * @param selection
	 * @param state
	 * @param source
	 * @param target
	 * @param commandToModify
	 */
	void uncontrol(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify);

	/**
	 * Provides method to enable/disable uncontrol action adding constraints
	 * 
	 * @param selection
	 * @param state
	 * @param source
	 * @param target
	 * @return true to enable uncontrol action, false to disable it
	 */
	boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target);

	/**
	 * The Enumeration STATE_CONTROL that specifies when the uncontrol action is performed
	 */
	public static enum STATE_CONTROL {

		/** before uncontrol action on notation resource */
		PRE_NOTATION,
		/** after uncontrol action on notation resource */
		POST_NOTATION,
		/** before uncontrol action on model resource */
		PRE_MODEL,
		/** after uncontrol action on model resource */
		POST_MODEL
	}

}

