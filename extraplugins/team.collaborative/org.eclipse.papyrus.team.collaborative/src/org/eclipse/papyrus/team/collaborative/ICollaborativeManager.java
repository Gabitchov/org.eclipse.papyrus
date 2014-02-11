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
package org.eclipse.papyrus.team.collaborative;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.impl.CollaborativeManager;
import org.eclipse.papyrus.team.collaborative.participants.ICollabParticipant;
import org.eclipse.papyrus.team.collaborative.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.participants.version.IUpdater;
import org.eclipse.papyrus.team.collaborative.strategy.ILockingStrategy;

/**
 * The Interface ICollaborativeManager.
 * Manager all {@link ICollabParticipant} such as {@link IUpdater}, {@link ICommitter}, {@link IReverter}, {@link ILocker}, {@link IUnlocker}.
 * It also handle {@link ILockingStrategy} items
 */
public interface ICollaborativeManager {

	/**
	 * Gets the strategies.
	 * 
	 * @return the strategies or null if not found
	 */
	public Map<String, ILockingStrategy.Descriptor> getStrategies();


	/**
	 * Gets the locking strategy.
	 * 
	 * @param id
	 *        the id
	 * @return the locking strategy or null if not found
	 */
	public ILockingStrategy getLockingStrategy(String id);

	/**
	 * Gets the locker.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return the locker or null if not found
	 */
	public ILocker getLocker(Set<IExtendedURI> objectToLock, ResourceSet resourceSet);

	/**
	 * Gets the unlocker.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return the unlocker or null if not found
	 */
	public IUnlocker getUnlocker(Set<IExtendedURI> objectToLock, ResourceSet resourceSet);

	/**
	 * Gets the updater.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return the updater or null if not found
	 */
	public IUpdater getUpdater(Set<IExtendedURI> objectToLock, ResourceSet resourceSet);

	/**
	 * Gets the committer.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return the committer or null if not found
	 */
	public ICommitter getCommitter(Set<IExtendedURI> objectToLock, ResourceSet resourceSet);

	/**
	 * Gets the reverter.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return the reverter or null if not found
	 */
	public IReverter getReverter(Set<IExtendedURI> objectToLock, ResourceSet resourceSet);

	/**
	 * Checks if is collab.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return true, if is collab
	 */
	public boolean isCollab(Set<IExtendedURI> objectToLock, ResourceSet resourceSet);

	/** The instance. */
	public static ICollaborativeManager INSTANCE = CollaborativeManager.getInstance();


}
