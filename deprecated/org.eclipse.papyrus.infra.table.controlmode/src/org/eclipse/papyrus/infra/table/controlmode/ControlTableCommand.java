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
package org.eclipse.papyrus.infra.table.controlmode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.util.TableContentsUtils;

import com.google.common.collect.Lists;

/**
 * Command to control tab in correct resources
 * 
 * @author adaussy
 * 
 */
public class ControlTableCommand extends AbstractTransactionalCommand {

	/**
	 * Control request used to control tabs
	 */
	protected ControlModeRequest request;

	/**
	 * @param request
	 *        {@link ControlTableCommand#request}
	 */
	@SuppressWarnings("unchecked")
	public ControlTableCommand(ControlModeRequest request) {
		super(request.getEditingDomain(), "Move table to new resource", null);
		this.request = request;

		try {
			getAffectedFiles().addAll(getWorkspaceFiles(getTables()));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject objectTOControl = request.getTargetObject();
		EMFHelper.getUsages(objectTOControl);
		//Retrieve new di resource created previously
		Resource newDiResource = getTargetDiResource();
		if(newDiResource == null) {
			return CommandResult.newErrorCommandResult("The di model has not been created");
		}
		List<EObject> tables = getTables();
		if(!tables.isEmpty()) {
			for(EObject tab : tables) {
				if(tab instanceof PapyrusTableInstance) {
					newDiResource.getContents().add(tab);
					newDiResource.getContents().add(((PapyrusTableInstance)tab).getTable());
				}
			}
			addMovedTabToRequest(tables);
		}
		return CommandResult.newOKCommandResult(newDiResource);
	}

	/**
	 * Retrieve the DI target resource from the request
	 * 
	 * @return
	 */
	protected Resource getTargetDiResource() {
		return request.getTargetResource(SashModel.MODEL_FILE_EXTENSION);
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
	 * Get all the tab that need to be moved
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	protected List<EObject> getTables() throws ExecutionException {
		return Lists.newArrayList(TableContentsUtils.createDescendantTablesIterable(request.getTargetObject()));
	}

	/**
	 * Retreive the URI of the old di resource
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	public URI getOldNotationURI() throws ExecutionException {
		URI uri = request.getSourceURI();
		if(uri != null) {
			return uri.trimFileExtension().appendFileExtension(SashModel.MODEL_FILE_EXTENSION);
		}
		throw new ExecutionException("Unable to retreive URI of the old di model");
	}

}