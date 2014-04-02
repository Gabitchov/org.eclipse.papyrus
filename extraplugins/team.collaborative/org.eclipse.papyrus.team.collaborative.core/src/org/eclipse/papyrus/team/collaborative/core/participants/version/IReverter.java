/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core.participants.version;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.team.collaborative.core.participants.IExtendedURISuperSet;


/**
 * Do a reverter action
 * 
 * @author adaussy
 * 
 */
public interface IReverter extends IExtendedURISuperSet, IWorkOnModifiedElementParticipant {

	/**
	 * Revert changes on {@link IExtendedURISuperSet#getExtendedSet()}
	 * 
	 * @return
	 * @throws CollabException
	 */
	IStatus revert();

}
