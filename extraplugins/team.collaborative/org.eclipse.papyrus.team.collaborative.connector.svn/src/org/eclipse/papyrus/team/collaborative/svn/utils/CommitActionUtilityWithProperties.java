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
package org.eclipse.papyrus.team.collaborative.connector.svn.utils;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.core.resources.IResource;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.action.IResourceSelector;
import org.eclipse.team.svn.ui.utility.CommitActionUtility;


/**
 * Same as {@link CommitActionUtility} however it add to commit set if the file has SVN properties changes
 * 
 * @author adaussy
 * 
 */
public class CommitActionUtilityWithProperties extends CommitActionUtility {

	public CommitActionUtilityWithProperties(IResourceSelector selector) {
		super(selector);
	}

	@Override
	public void initialize(IResourceSelector selector) {
		this.selector = selector;

		this.allResourcesSet = new HashSet<IResource>();
		this.allResourcesSet.addAll(Arrays.asList(this.selector.getSelectedResourcesRecursive(new IStateFilter.OrStateFilter(new IStateFilter[]{ IStateFilter.SF_COMMITABLE, IStateFilter.SF_CONFLICTING, IStateFilter.SF_TREE_CONFLICTING, IStateFilter.SF_NEW, IStateFilter.SF_HAS_PROPERTIES_CHANGES }))));

		this.newNonRecursive = new HashSet<IResource>(Arrays.asList(this.selector.getSelectedResources(IStateFilter.SF_IGNORED_BUT_NOT_EXTERNAL)));
		this.newRecursive = new HashSet<IResource>(Arrays.asList(FileUtility.getResourcesRecursive((IResource[])this.allResourcesSet.toArray(new IResource[this.allResourcesSet.size()]), IStateFilter.SF_NEW, IResource.DEPTH_ZERO)));

		HashSet<IResource> fullSet = new HashSet<IResource>(this.newNonRecursive);
		fullSet.addAll(this.newRecursive);
		this.parents = new HashSet<IResource>(Arrays.asList(FileUtility.getOperableParents((IResource[])fullSet.toArray(new IResource[fullSet.size()]), IStateFilter.SF_UNVERSIONED)));
		this.newNonRecursive.addAll(this.parents);
		fullSet.addAll(this.parents);

		this.allResourcesSet.addAll(fullSet);

		this.allResources = (IResource[])this.allResourcesSet.toArray(new IResource[this.allResourcesSet.size()]);
		this.allResourcesSet.addAll(Arrays.asList(FileUtility.addOperableParents(this.allResources, IStateFilter.SF_ADDED, true)));
		this.allResources = (IResource[])this.allResourcesSet.toArray(new IResource[this.allResourcesSet.size()]);

		this.canBeRecursiveCommit = FileUtility.getOperableParents(this.selector.getSelectedResources(), IStateFilter.SF_ADDED, false).length == 0;
		if(this.canBeRecursiveCommit && FileUtility.checkForResourcesPresence(this.allResources, IStateFilter.SF_SWITCHED, IResource.DEPTH_ZERO)) {
			this.canBeRecursiveCommit = false;
		}
	}

}
