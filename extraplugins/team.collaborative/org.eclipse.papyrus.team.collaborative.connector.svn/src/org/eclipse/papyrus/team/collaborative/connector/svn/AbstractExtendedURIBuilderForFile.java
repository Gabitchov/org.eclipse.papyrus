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
package org.eclipse.papyrus.team.collaborative.connector.svn;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.participants.AbstractExtendedURIBuilder;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;


/**
 * Extends {@link AbstractExtendedURIBuilder} adding some utilitary method to manipulate files
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractExtendedURIBuilderForFile extends AbstractExtendedURIBuilder {

	public AbstractExtendedURIBuilderForFile(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	/**
	 * Transform resource to {@link IFile}
	 * 
	 * @param r
	 *        the r
	 * @return the i file
	 */
	protected IFile toIFile(Resource r) {
		if(r != null) {
			return TO_FILE_FUNCTION.apply(r);
		}
		return null;
	}

	/** The Constant TO_FILE_FUNCTION. */
	protected static final Function<Resource, IFile> TO_FILE_FUNCTION = new Function<Resource, IFile>() {

		@Override
		public IFile apply(Resource from) {

			return WorkspaceSynchronizer.getFile(from);
		}
	};

	/**
	 * Gets the target files.
	 * 
	 * @param resourcesToLock
	 *        the resources to lock
	 * @return the target files
	 */
	protected static IFile[] getTargetFiles(Collection<Resource> resourcesToLock) {
		Collection<IFile> iResourcesToLock = Collections2.transform(resourcesToLock, TO_FILE_FUNCTION);
		return iResourcesToLock.toArray(new IFile[iResourcesToLock.size()]);
	}


}
