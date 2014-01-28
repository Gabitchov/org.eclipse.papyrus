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
package org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.commands;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.connector.svn.utils.SVNUtils;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.actions.CommitHandler;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.actions.LockAction;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.utils.CollabFunctionsFactory;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;


/**
 * The Class AddFileToCollabSVN.
 * This command is used to add file to a SVN repository using a {@link ControlModeRequest}.
 * The files shall be already serialized.
 */
public class AddFileToCollabSVN extends AbstractTransactionalCommand {

	//	private Collection<URI> uris;
	/** The request. */
	private ControlModeRequest request;

	/**
	 * Instantiates a new adds the file to collab svn.
	 * 
	 * @param domain
	 *        the domain
	 * @param request
	 *        the request
	 */
	public AddFileToCollabSVN(TransactionalEditingDomain domain, ControlModeRequest request) {
		super(domain, "Add fiel to collacb", null);
		this.request = request;
	}

	/**
	 * Adds the source resource.
	 * 
	 * @param extension
	 *        the extension
	 * @param resources
	 *        the resources
	 */
	protected void addSourceResource(String extension, Collection<Resource> resources) {
		Resource resource = request.getSourceResource(extension);
		if(resource != null) {
			resources.add(resource);
		}
	}

	/**
	 * Adds the target resource.
	 * 
	 * @param extension
	 *        the extension
	 * @param resources
	 *        the resources
	 */
	protected void addTargetResource(String extension, Collection<Resource> resources) {
		Resource resource = request.getTargetResource(extension);
		if(resource != null) {
			resources.add(resource);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		/*
		 * This part should be more generic
		 */
		Set<Resource> targetResource = new HashSet<Resource>();
		addTargetResource("uml", targetResource);
		addTargetResource("di", targetResource);
		addTargetResource("notation", targetResource);
		Set<Resource> sourceResource = new HashSet<Resource>();
		addSourceResource("uml", sourceResource);
		addSourceResource("di", sourceResource);
		addSourceResource("notation", sourceResource);

		//Add target resource to repository
		Collection<IFile> targetExtendedFiles = Collections2.transform(targetResource, CollabFunctionsFactory.getResourceToIFile());
		IStatus status = SVNUtils.addToRepository(UIUtils.getLabel(request.getTargetObject()), targetExtendedFiles);
		if(!status.isOK()) {
			throw new ExecutionException(status.getMessage(), status.getException());
		}
		//Commit source resources
		HashSet<IExtendedURI> sourceExtendedURIs = Sets.newHashSet(Collections2.transform(sourceResource, CollabFunctionsFactory.getResourceToExtendedURIWithContainment()));
		ResourceSet resourceSet = request.getEditingDomain().getResourceSet();
		StringBuilder commitMessage = new StringBuilder("Creation of new partition ");
		commitMessage.append(getPartitionName());
		status = CommitHandler.doCommit(sourceExtendedURIs, resourceSet, false, commitMessage.toString());
		if(!status.isOK()) {
			throw new ExecutionException(status.getMessage(), status.getException());
		}
		//Take lock in new resources
		Set<IExtendedURI> targetExtendedURIs = Sets.newHashSet(Collections2.transform(targetResource, CollabFunctionsFactory.getResourceToExtendedURIWithContainment()));
		status = LockAction.doSafeLock(resourceSet, targetExtendedURIs, false);
		if(!status.isOK()) {
			throw new ExecutionException(status.getMessage(), status.getException());
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Gets the partition name.
	 * 
	 * @return the partition name
	 */
	protected String getPartitionName() {
		return request.getTargetResource("uml").getURI().trimFileExtension().segment(1);
	}

}
