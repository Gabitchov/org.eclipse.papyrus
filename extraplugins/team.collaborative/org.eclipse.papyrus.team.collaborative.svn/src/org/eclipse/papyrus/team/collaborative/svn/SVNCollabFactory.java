/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *     Philippe Roland (Atos) philippe.roland@atos.net - added workaround for eclipse bug 385394
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.svn;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.ICollabFactory;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.core.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IUpdater;
import org.eclipse.papyrus.team.collaborative.core.utils.CollabFunctionsFactory;
import org.eclipse.papyrus.team.collaborative.svn.locker.SVNLocker;
import org.eclipse.papyrus.team.collaborative.svn.locker.SVNUnlocker;
import org.eclipse.papyrus.team.collaborative.svn.versioncontroller.SVNCommitter;
import org.eclipse.papyrus.team.collaborative.svn.versioncontroller.SVNReverter;
import org.eclipse.papyrus.team.collaborative.svn.versioncontroller.SVNUpdater;
import org.eclipse.team.svn.core.utility.FileUtility;

import com.google.common.collect.Collections2;


/**
 * Factory to build element to do collaborative work with SVN.
 * 
 * @author adaussy
 */
public class SVNCollabFactory implements ICollabFactory {

	/** The Constant SVN_COLLAB_ID. */
	public static final String SVN_COLLAB_ID = "org.eclipse.papyrus.team.collaborative.core.connector.svn";

	/**
	 * Resource set svn status cache
	 */
	private WeakHashMap<ResourceSet, Boolean> alreadyOnSvnCache = new WeakHashMap<ResourceSet, Boolean>();
	
	/**
	 * Instantiates a new sVN collab factory.
	 */
	public SVNCollabFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.ICollabFactory#provide(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public boolean provide(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		/**
		 * Workaround for eclipse bug 385394. This bug causes property testers to be called very frequently
		 * even if no activity is taking place, causing important slowdowns when a right-click on a model explorer element is performed.
		 * a cache prevents these calls (and the subsequent calls to FileUtility.alreadyOnSVN) from being too taxing on system resources.
		 * 
		 * This bug was fixed on 16/01/2014 but its fix has not yet been released outside of integration builds. Remove this workaround when it is.
		 */
		if(alreadyOnSvnCache.containsKey(resourceSet)) {
			return alreadyOnSvnCache.get(resourceSet);
		}
		boolean result;
		Set<IProject> projects = new HashSet<IProject>();
		for(IResource iResource : Collections2.transform(uris, CollabFunctionsFactory.getExtendedURIToIResource(resourceSet))) {
			if(iResource != null) {
				projects.add(iResource.getProject());
			}
		}
		if(projects.isEmpty()) {
			result = false;
			alreadyOnSvnCache.put(resourceSet, result);
			return result;
		}
		for(IProject iProject : projects) {
			if(!FileUtility.alreadyOnSVN(iProject)) {
				result = false;
				alreadyOnSvnCache.put(resourceSet, result);
				return result;
			}
		}
		result = true;
		alreadyOnSvnCache.put(resourceSet, result);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.ICollabFactory#createLocker(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public ILocker createLocker(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		return new SVNLocker(uris, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.ICollabFactory#createUnlocker(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public IUnlocker createUnlocker(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		return new SVNUnlocker(uris, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.ICollabFactory#createReverter(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public IReverter createReverter(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		return new SVNReverter(uris, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.ICollabFactory#createCommitter(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public ICommitter createCommitter(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		return new SVNCommitter(uris, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.ICollabFactory#createUpdater(java.util.Set, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public IUpdater createUpdater(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		return new SVNUpdater(uris, resourceSet);
	}

}
