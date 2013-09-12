/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.controlmode.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.common.modelresource.PapyrusNattableModel;
import org.eclipse.papyrus.infra.nattable.controlmode.Activator;
import org.eclipse.papyrus.infra.nattable.controlmode.helpers.TableControlModeHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters;

import com.google.common.collect.Lists;


public class PapyrusNattableControlCommand extends AbstractTransactionalCommand {

	/**
	 * Control request used to control tabs
	 */
	protected ControlModeRequest request;

	/**
	 * @param request
	 *        {@link ControlTableCommand#request}
	 */
	@SuppressWarnings("unchecked")
	public PapyrusNattableControlCommand(ControlModeRequest request) {
		super(request.getEditingDomain(), "Move table to new resource", null);
		this.request = request;

		try {
			getAffectedFiles().addAll(getWorkspaceFiles(getTables()));
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Get all the tab that need to be moved
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	protected List<EObject> getTables() throws ExecutionException {
		return Lists.newArrayList(TableControlModeHelper.createDescendantTablesIterable(this.request.getTargetObject()));
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject objectTOControl = request.getTargetObject();
		EMFHelper.getUsages(objectTOControl);
		//Retrieve new notation resource created previously
		Resource newResource = getTargetResource();
		if(newResource == null) {
			return CommandResult.newErrorCommandResult(String.format("The target %s model has not been created", getTargetResourceFileExtension()));
		}
		List<EObject> tables = getTables();
		if(!tables.isEmpty()) {
			for(EObject tab : tables) {
				if(tab instanceof Table) {
					newResource.getContents().add(tab);
				}
			}
			addMovedTabToRequest(tables);
		}
		return CommandResult.newOKCommandResult(newResource);
	}

	/**
	 * Register the tab being moved to the request in ordert to be used by other participants
	 * 
	 * @param tables
	 */
	public void addMovedTabToRequest(List<EObject> tables) {
		@SuppressWarnings("unchecked")
		Collection<EObject> openables = (Collection<EObject>)request.getParameter(ControlModeRequestParameters.MOVED_OPENABLES);
		if(openables == null) {
			openables = new ArrayList<EObject>();
		}
		openables.addAll(tables);
		request.addParameters(Collections.singletonMap(ControlModeRequestParameters.MOVED_OPENABLES, openables));
	}

	/**
	 * Retrieve the target resource from the request
	 * 
	 * @return
	 */
	protected Resource getTargetResource() {
		return request.getTargetResource(getTargetResourceFileExtension());
	}

	/**
	 * 
	 * @return
	 *         the extension point of the target resource
	 */
	protected String getTargetResourceFileExtension() {
		return PapyrusNattableModel.TABLE_MODEL_FILE_EXTENSION;
	}
}
