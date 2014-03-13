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
package org.eclipse.papyrus.team.collaborative.core.participants.locker;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.team.collaborative.core.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.IExtendedURISuperSet;


/**
 * Object used to unlock Object.
 * 
 * @author adaussy
 * 
 */
public interface IUnlocker extends IExtendedURISuperSet {

	/**
	 * Unlock element in {@link IExtendedURISuperSet#getExtendedSet()}
	 * 
	 * @return A success status is everything went well
	 * @throws CollabException
	 */
	IStatus unlock();

	/**
	 * Return true is at least one of {@link ExtendedURI} is locked
	 * 
	 * @return
	 */
	IStatus isLocked(IExtendedURI uri);

}
