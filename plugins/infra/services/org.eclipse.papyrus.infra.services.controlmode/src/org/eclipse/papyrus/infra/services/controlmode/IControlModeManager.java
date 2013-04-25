/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode;

import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * A control manger is able to compute a command in order to control or uncontrol an element from a {@link ControlModeRequest}.
 * 
 * @author adaussy
 * 
 */
public interface IControlModeManager {

	/**
	 * Return the command to control an element.
	 * 
	 * @param request
	 * @return
	 */
	public ICommand getControlCommand(ControlModeRequest request);
	
	
	/**
	 * Return the command to uncontrol an element
	 * 
	 * @param request
	 * @return
	 */
	public ICommand getUncontrolCommand(ControlModeRequest request);

}
