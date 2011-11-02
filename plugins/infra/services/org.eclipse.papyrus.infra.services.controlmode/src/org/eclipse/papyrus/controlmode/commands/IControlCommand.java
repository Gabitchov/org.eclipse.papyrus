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
 * The Interface IControlCommand that defines custom control action executed with the default Papyrus control action.
 */
public interface IControlCommand {

	/**
	 * Control action applied on the specified selection
	 * 
	 * @param domain
	 * @param selection
	 * @param state
	 * @param source
	 * @param target
	 * @param commandToModify
	 */
	void control(EditingDomain domain, EObject selection, STATE_CONTROL state, Resource source, Resource target, CompoundCommand commandToModify);

	/**
	 * Provides method to enable/disable control action adding constraints
	 * 
	 * @param selection
	 * @param state
	 * @param source
	 * @param target
	 * @return true to enable control action, false to disable it
	 */
	boolean provides(EObject selection, STATE_CONTROL state, Resource source, Resource target);

	/**
	 * The Enumeration STATE_CONTROL that specifies when the control action is performed
	 */
	public static enum STATE_CONTROL {

		/** before control action on di resource */
		PRE_DI,
		/** after control action on di resource */
		POST_DI,
		/** before control action on notation resource */
		PRE_NOTATION,
		/** after control action on notation resource */
		POST_NOTATION,
		/** before control action on model resource */
		PRE_MODEL,
		/** after control action on model resource */
		POST_MODEL
	}

}
