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
package org.eclipse.papyrus.infra.services.controlmode.participants;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;

/**
 * Define a participant for complete the uncontrol command for specific use
 * 
 * @author adaussy
 * 
 */
public interface IUncontrolCommandParticipant extends IControlModeParticipant {

	/**
	 * The participant return true if it should handle this request
	 * 
	 * @param request
	 * @return
	 */
	public boolean provideUnControlCommand(ControlModeRequest request);

	/**
	 * Ask the participant for command that will be executed before the control/uncontrol command
	 * 
	 * @param request
	 * @return
	 */
	public ICommand getPreUncontrolCommand(ControlModeRequest request);

	/**
	 * Ask the participant for command that will be executed after the control/uncontrol command
	 * 
	 * @param request
	 * @return
	 */
	public ICommand getPostUncontrolCommand(ControlModeRequest request);

}
