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
package org.eclipse.papyrus.infra.services.controlmode.participants;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;


/**
 * Define a participant to complete the control command for specific use
 * 
 * @author adaussy
 * 
 */
public interface IControlCommandParticipant extends IControlModeParticipant {

	
	/**
	 * The participant return true if it should handle this request
	 * 
	 * @param request
	 * @return
	 */
	public boolean provideControlCommand(ControlModeRequest request);
	

	/**
	 * Ask the participant for command that will be executed before the control command
	 * The returned command should not be null (use {@link UnexecutableCommand}
	 * 
	 * @param request
	 * @return
	 */
	public ICommand getPreControlCommand(ControlModeRequest request);

	/**
	 * Ask the participant for command that will be executed after the control command
	 * 
	 * @param request
	 * @return
	 */
	public ICommand getPostControlCommand(ControlModeRequest request);

}
