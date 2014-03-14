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
package org.eclipse.papyrus.team.collaborative.svn;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.extension.CoreExtensionsManager;
import org.eclipse.team.svn.core.operation.AbstractActionOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.SVNUIMessages;
import org.eclipse.team.svn.ui.action.IResourceSelector;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;


/**
 * The Class CollabResourceSelector.
 * Implementation of {@link IResourceSelector} for use in collaboration
 */
public class CollabResourceSelector implements IResourceSelector {

	/** The resources. */
	private IResource[] resources;

	/** The shell. */
	private Shell shell;

	/**
	 * Instantiates a new collab resource selector.
	 * 
	 * @param resources
	 *        the resources
	 * @param shell
	 *        the shell
	 */
	public CollabResourceSelector(IResource[] resources, Shell shell) {
		super();
		this.resources = resources;
		this.shell = shell;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.team.svn.ui.action.IRecursiveResourceSelector#getSelectedResourcesRecursive(org.eclipse.team.svn.core.IStateFilter)
	 */
	public IResource[] getSelectedResourcesRecursive(IStateFilter filter) {
		return this.getSelectedResourcesRecursive(filter, IResource.DEPTH_INFINITE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.team.svn.ui.action.IRecursiveResourceSelector#getSelectedResourcesRecursive(org.eclipse.team.svn.core.IStateFilter, int)
	 */
	public IResource[] getSelectedResourcesRecursive(final IStateFilter filter, final int depth) {
		final IResource[][] retVal = new IResource[][]{ new IResource[0] };
		IActionOperation op = new AbstractActionOperation("Operation_CollectingResources", SVNUIMessages.class) { //$NON-NLS-1$

			protected void runImpl(IProgressMonitor monitor) throws Exception {
				retVal[0] = FileUtility.getResourcesRecursive(getSelectedResources(), filter, depth, this, monitor);
			}
		};
		if(CoreExtensionsManager.instance().getOptionProvider().isSVNCacheEnabled()) {
			UIMonitorUtility.doTaskBusyDefault(op);
		} else {
			UIMonitorUtility.doTaskNowDefault(shell, op, true);
		}
		return retVal[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.team.svn.ui.action.IPlainResourceSelector#getSelectedResources()
	 */
	public IResource[] getSelectedResources() {
		return resources;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.team.svn.ui.action.IPlainResourceSelector#getSelectedResources(org.eclipse.team.svn.core.IStateFilter)
	 */
	public IResource[] getSelectedResources(IStateFilter filter) {
		return FileUtility.getResourcesRecursive(this.getSelectedResources(), filter, IResource.DEPTH_ZERO);
	}

}
