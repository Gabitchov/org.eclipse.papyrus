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
package org.eclipse.papyrus.team.collaborative.svn.versioncontroller;



import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.IExtendedURISuperSet;
import org.eclipse.papyrus.team.collaborative.svn.CollabResourceSelector;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.svn.ui.utility.CommitActionUtility;

/**
 * Abstract class used to SVN action which used modified files ad {@link IExtendedURISuperSet#getExtendedSet()}
 * 
 * @author adaussy
 * 
 */
public abstract class SVNWorkOnModifiedFile extends AbstractSVNVersionController {

	public SVNWorkOnModifiedFile(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	/**
	 * Gets the modified file.
	 * 
	 * @param input
	 *        the input
	 * @return the modified file
	 */
	protected static File[] getModifiedFile(Collection<Resource> input) {
		IFile[] resourcesToProcess = getTargetFiles(input);
		File[] result = new File[resourcesToProcess.length];
		for(int i = 0; i < resourcesToProcess.length; i++) {
			result[i] = resourcesToProcess[i].getRawLocation().makeAbsolute().toFile();
		}
		return result;
	}

	@Override
	protected Set<IExtendedURI> doBuild() {
		List<IResource> toCommit = new ArrayList<IResource>();
		Map<IResource, IExtendedURI> cach = new HashMap<IResource, IExtendedURI>();
		for(IExtendedURI extendedURI : getUris()) {
			IExtendedURI resourceURI = getResourceURI(extendedURI);
			if(resourceURI != null) {
				IFile file = toIFile(toResource(resourceURI.getUri()));
				if(file != null && file.exists()) {
					if(isModified(resourceURI).isOK()) {
						toCommit.add(file);
						cach.put(file, resourceURI);
					}
				}
			}
		}
		CommitActionUtility commitUtility = new CommitActionUtility(new CollabResourceSelector(toCommit.toArray(new IResource[toCommit.size()]), Display.getDefault().getActiveShell()));
		IResource[] allResources = commitUtility.getAllResources();
		for(int i = 0; i < allResources.length; i++) {
			getExtendedSet().add(cach.get(allResources[i]));
		}
		return getExtendedSet();
	}

}
