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
package org.eclipse.papyrus.team.collaborative.participants.version;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.team.collaborative.participants.IExtendedURISuperSet;


/**
 * Object to commit elements
 * 
 * @author adaussy
 * 
 */
public interface ICommitter extends IExtendedURISuperSet, IWorkOnModifiedElementParticipant {

	/**
	 * Commit {@link IExtendedURISuperSet#getExtendedSet()}
	 * 
	 * @param message
	 *        Message for the commit
	 * @param keepLock
	 *        If the lock has to be kept
	 * @return Success status is everything went fine
	 * @throws CollabException
	 */
	IStatus commit(String message, boolean keepLock);




}
