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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IUpdater;
import org.eclipse.papyrus.team.collaborative.svn.tracing.ITracingConstant;
import org.eclipse.papyrus.team.collaborative.svn.tracing.Tracer;
import org.eclipse.team.svn.core.connector.SVNEntryInfo;
import org.eclipse.team.svn.core.connector.SVNLogEntry;
import org.eclipse.team.svn.core.connector.SVNRevision;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.operation.local.InfoOperation;
import org.eclipse.team.svn.core.operation.remote.GetLogMessagesOperation;
import org.eclipse.team.svn.core.resource.IRepositoryResource;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.eclipse.team.svn.ui.action.local.UpdateAction;
import org.eclipse.team.svn.ui.utility.ICancellableOperationWrapper;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;


/**
 * SVN implementation of {@link IUpdater}
 * 
 * @author adaussy
 * 
 */
public class SVNUpdater extends AbstractSVNVersionController implements IUpdater {

	/**
	 * Instantiates a new sVN updater.
	 * 
	 * @param uris
	 *        the uris
	 * @param resourceSet
	 *        the resource set
	 */
	public SVNUpdater(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	public IStatus update() {
		IFile[] resourcesToProcess = getTargetFiles(getTargetResources());
		//The all project of each file shall be updated (In order to see if new files appeared (New control))
		Set<IProject> projects = new HashSet<IProject>();
		for(IFile f : resourcesToProcess) {
			projects.add(f.getProject());
		}

		IProject[] projectsToUpdate = new IProject[projects.size()];
		projects.toArray(projectsToUpdate);
		if(ITracingConstant.UPDATE_TRACING) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Updating projects: ").append("\n");
			for(IProject p : projectsToUpdate) {
				stringBuilder.append(p.getFullPath()).append("\n");
			}
			Tracer.logInfo(stringBuilder.toString());
		}
		CompositeOperation op = UpdateAction.getUpdateOperation(projectsToUpdate, SVNRevision.HEAD);
		ICancellableOperationWrapper runnable = UIMonitorUtility.doTaskNowDefault(op, false);
		IActionOperation resultStatus = runnable.getOperation();

		return resultStatus.getStatus();
	}

	@Override
	protected Set<IExtendedURI> doBuild() {
		for(IExtendedURI extendedURI : getUris()) {
			IExtendedURI resourceURI = getResourceURI(extendedURI);
			if(resourceURI != null) {
				IFile file = toIFile(toResource(resourceURI.getUri()));
				if(file != null && file.exists()) {
					if(!isUpToDate(resourceURI).isUpToDate()) {
						getExtendedSet().add(resourceURI);
					}
				}
			}
		}
		return getExtendedSet();
	}


	/**
	 * Checks if is up to date.
	 * 
	 * @param uri
	 *        the uri
	 * @return the i status
	 */
	public UpToDateStatus isUpToDate(IExtendedURI uri) {
		IExtendedURI resourceEURI = getResourceURI(uri);
		if(resourceEURI == null) {
			return UpToDateStatus.createErrorDuringUpToDataStatus("The URI is null");
		}
		UpToDateStatus status = getCache().get(resourceEURI);
		if(status == null) {
			URI resourceURI = resourceEURI.getUri();
			Resource resource = toResource(resourceURI);
			if(resource == null) {
				return UpToDateStatus.createErrorDuringUpToDataStatus(resourceURI + " is not a URI pointing to a resource");
			}
			IFile file = toIFile(resource);
			if(file == null || !file.exists()) {
				return UpToDateStatus.createErrorDuringUpToDataStatus(resourceURI + " is not a URI pointing to a existing file");
			}

			SVNLogEntry log = getRemoteHEADRevision(file);
			if(log == null) {
				return UpToDateStatus.createErrorDuringUpToDataStatus("Unable to get remote HEAD revision for file " + file.getFullPath());
			}
			InfoOperation refreshOperation = new InfoOperation(file);
			refreshOperation.run(new NullProgressMonitor());
			SVNEntryInfo info = refreshOperation.getInfo();
			long localRevision = info.revision;
			if(log.revision > localRevision) {
				status = UpToDateStatus.createNotUpToDataStatus(log.author, log.date, log.revision);
				getCache().put(resourceEURI, status);
				return status;
			} else {
				status = UpToDateStatus.createUpToDataStatus(log.author, log.date, log.revision);
				getCache().put(resourceEURI, status);
			}
		}
		return status;
	}




	protected Map<IExtendedURI, UpToDateStatus> getCache() {
		if(cache == null) {
			cache = new HashMap<IExtendedURI, IUpdater.UpToDateStatus>();
		}
		return cache;
	}



	private Map<IExtendedURI, UpToDateStatus> cache = null;

	public static final long INVALID_REVISION = -1;


	public SVNLogEntry getRemoteHEADRevision(IResource resource) {
		IRepositoryResource remote = SVNRemoteStorage.instance().asRepositoryResource(resource);
		GetLogMessagesOperation logOp = new GetLogMessagesOperation(remote);
		logOp.setLimit(1);
		logOp.run(new NullProgressMonitor());
		if(logOp.getExecutionState() == IActionOperation.OK && logOp.getMessages() != null) {
			SVNLogEntry[] messages = logOp.getMessages();
			if(messages.length > 0) {
				return messages[0];
			}
		}
		return null;
	}





}
