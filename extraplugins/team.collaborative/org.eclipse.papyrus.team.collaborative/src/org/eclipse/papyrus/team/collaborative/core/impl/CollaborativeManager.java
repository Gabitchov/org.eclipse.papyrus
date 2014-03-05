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
package org.eclipse.papyrus.team.collaborative.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.Activator;
import org.eclipse.papyrus.team.collaborative.ICollabFactory;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.participants.version.IUpdater;
import org.eclipse.papyrus.team.collaborative.strategy.ILockingStrategy;


/**
 * The Class CollaborativeManager.
 * This the default implementation of {@link ICollaborativeManager}
 * 
 * @author adaussy
 */
public class CollaborativeManager implements ICollaborativeManager {

	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The instance. */
		private static ICollaborativeManager INSTANCE = new CollaborativeManager();
	}

	/**
	 * Private constructor.
	 */
	private CollaborativeManager() {
		init();
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static ICollaborativeManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/** The strategies. */
	protected Map<String, ILockingStrategy.Descriptor> strategies;


	/** The factories of all {@link ParticipantFactoryWrapper} */
	List<ParticipantFactoryWrapper> factories = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getStrategies()
	 */
	@Override
	public Map<String, ILockingStrategy.Descriptor> getStrategies() {
		return strategies;
	}


	/**
	 * Inits the manager.
	 */
	protected void init() {
		strategies = new HashMap<String, ILockingStrategy.Descriptor>();
		factories = new ArrayList<CollaborativeManager.ParticipantFactoryWrapper>();
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, "collaborative");
		for(IConfigurationElement conf : confs) {
			if("LockingStrategy".equals(conf.getName())) {
				try {
					ILockingStrategy strategy = (ILockingStrategy)conf.createExecutableExtension("impl");
					String id = conf.getAttribute("id");
					String name = conf.getAttribute("name");
					strategies.put(id, new ILockingStrategy.Descriptor(strategy, name));
				} catch (CoreException e) {
					e.printStackTrace();
				}

			} else if("ParticipantFactory".equals(conf.getName())) {
				try {
					ICollabFactory factory = (ICollabFactory)conf.createExecutableExtension("impl");
					String id = conf.getAttribute("id");
					Integer priority = Integer.parseInt(conf.getAttribute("priority"));
					factories.add(new ParticipantFactoryWrapper(factory, priority, id));
				} catch (CoreException e) {
					e.printStackTrace();
				}

			}
		}
		Collections.sort(factories);
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getLockingStrategy(java.lang.String)
	 */
	@Override
	public ILockingStrategy getLockingStrategy(String id) {
		return getStrategies().get(id).getStrategy();
	}

	/**
	 * Gets the factory.
	 * 
	 * @param objectToLock
	 *        the object to lock
	 * @param resourceSet
	 *        the resource set
	 * @return the factory
	 */
	protected ICollabFactory getFactory(Set<IExtendedURI> objectToLock, ResourceSet resourceSet) {
		for(ParticipantFactoryWrapper wrapper : factories) {
			if(wrapper.factory.provide(objectToLock, resourceSet)) {
				return wrapper.factory;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getLocker(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	public ILocker getLocker(Set<IExtendedURI> objectToLock, ResourceSet resourceSet) {
		ICollabFactory factory = getFactory(objectToLock, resourceSet);
		if(factory == null) {
			return null;
		}
		return factory.createLocker(objectToLock, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getUnlocker(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	public IUnlocker getUnlocker(Set<IExtendedURI> objectToLock, ResourceSet resourceSet) {
		ICollabFactory factory = getFactory(objectToLock, resourceSet);
		if(factory == null) {
			return null;
		}
		return factory.createUnlocker(objectToLock, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getUpdater(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	public IUpdater getUpdater(Set<IExtendedURI> objectToLock, ResourceSet resourceSet) {
		ICollabFactory factory = getFactory(objectToLock, resourceSet);
		if(factory == null) {
			return null;
		}
		return factory.createUpdater(objectToLock, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getCommitter(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	public ICommitter getCommitter(Set<IExtendedURI> objectToLock, ResourceSet resourceSet) {
		ICollabFactory factory = getFactory(objectToLock, resourceSet);
		if(factory == null) {
			return null;
		}
		return factory.createCommitter(objectToLock, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#getReverter(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	public IReverter getReverter(Set<IExtendedURI> objectToLock, ResourceSet resourceSet) {
		ICollabFactory factory = getFactory(objectToLock, resourceSet);
		if(factory == null) {
			return null;
		}
		return factory.createReverter(objectToLock, resourceSet);
	}


	/** The resource set cash. */
	protected Map<URI, ResourceSet> resourceSetCash = new HashMap<URI, ResourceSet>();


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.ICollaborativeManager#isCollab(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	public boolean isCollab(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		for(ParticipantFactoryWrapper wrapper : factories) {
			if(wrapper.factory.provide(uris, resourceSet)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The Class ParticipantFactoryWrapper.
	 */
	private static class ParticipantFactoryWrapper implements Comparable<ParticipantFactoryWrapper> {

		/** The factory. */
		public ICollabFactory factory;

		/** The priority. */
		public Integer priority;

		/** The id. */
		public String id;

		/**
		 * Instantiates a new participant factory wrapper.
		 * 
		 * @param factory
		 *        the factory
		 * @param priority
		 *        the priority
		 * @param id
		 *        the id
		 */
		public ParticipantFactoryWrapper(ICollabFactory factory, Integer priority, String id) {
			super();
			this.factory = factory;
			this.priority = priority;
			this.id = id;
		}



		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(ParticipantFactoryWrapper o) {
			return priority.compareTo(o.priority);
		}


	}



}
