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

import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;


/**
 * Represent a element which participate to creation of a control/Uncontrol command
 * 
 * @author adaussy
 * 
 */
public interface IControlModeParticipant {

	/**
	 * ID of the participant
	 * 
	 * @return
	 */
	public String getID();

	/**
	 * Priority of the participant.
	 * This priority will define the order in which the {@link IControlCommandParticipant#getPreControlCommand(ControlModeRequest)} and
	 * {@link IControlCommandParticipant#getPostControlCommand(ControlModeRequest)} will be called
	 * The highest priority participant will be called first for the Pre command and last for the Post command.
	 * 
	 * @return
	 */
	public int getPriority();


}
