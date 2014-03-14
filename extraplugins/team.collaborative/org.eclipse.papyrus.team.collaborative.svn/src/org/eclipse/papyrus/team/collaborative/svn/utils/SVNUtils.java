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
package org.eclipse.papyrus.team.collaborative.svn.utils;

import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.team.collaborative.svn.tracing.ITracingConstant;
import org.eclipse.papyrus.team.collaborative.svn.tracing.Tracer;
import org.eclipse.papyrus.team.collaborative.svn.versioncontroller.SVNCommitter;
import org.eclipse.team.svn.core.connector.SVNChangeStatus;
import org.eclipse.team.svn.core.extension.CoreExtensionsManager;
import org.eclipse.team.svn.core.extension.factory.ISVNConnectorFactory;
import org.eclipse.team.svn.core.utility.SVNUtility;

/**
 * The Class SVNUtils.
 */
public class SVNUtils {

	/** The Constant SVN_NEEDS_LOCK. */
	private static final String SVN_NEEDS_LOCK = "svn:needs-lock";

	/** The SVN connector factory. */
	static ISVNConnectorFactory svnConnectorFactory = CoreExtensionsManager.instance().getSVNConnectorFactory();


	/**
	 * Gets the resource SVN info.
	 * 
	 * @param resource
	 *        the resource
	 * @return the SVN info
	 */
	public static SVNChangeStatus getSVNInfo(IResource resource) {
		return SVNUtility.getSVNInfoForNotConnected(resource);
	}



	/**
	 * Add resources to the SVN repository.
	 * 
	 * @param message
	 *        Message for the Add operation
	 * @param resources
	 *        The resources to add
	 * @return the i status
	 */
	public static IStatus addToRepository(String message, Collection<? extends IResource> resources) {
		IResource[] iResources = new IResource[resources.size()];
		resources.toArray(iResources);
		IStatus status = SVNCommitter.doCommit(message, true, resources);
		if(!status.isOK()) {
			return status;
		}

		//Set need lock property
		if(ITracingConstant.COMMIT_TRACING) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Set need lock property on: ").append("\n");
			for(IResource r : iResources) {
				stringBuilder.append(r).append("\n");
			}
			Tracer.logInfo(stringBuilder.toString());
		}
		SetPropertyActionNow.doSetPropertyNow(iResources, SVN_NEEDS_LOCK, "*", "", false, true, 0, false, "*", false, null);

		//Commit the property change
		status = SVNCommitter.doCommit(message, true, resources);
		if(!status.isOK()) {
			return status;
		}
		return Status.OK_STATUS;
	}

	/**
	 * Test if a {@link IResource}.
	 * 
	 * @param resource
	 *        the resource
	 * @return true, if is added to repository
	 */
	public static boolean isAddedToRepository(IResource resource) {
		SVNChangeStatus svnInfo = getSVNInfo(resource);
		if(svnInfo != null) {
			String value = SVNUtility.getPropertyForNotConnected(resource, SVN_NEEDS_LOCK);
			return value != null && !value.isEmpty();
		}
		return false;

	}

}
