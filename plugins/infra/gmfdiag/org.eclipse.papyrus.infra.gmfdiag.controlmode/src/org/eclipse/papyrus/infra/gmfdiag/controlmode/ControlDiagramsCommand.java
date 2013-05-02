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
package org.eclipse.papyrus.infra.gmfdiag.controlmode;

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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters;
import org.eclipse.papyrus.infra.services.controlmode.commands.AbstractControlCommand;

/**
 * Command handling control/uncontrol of diagram in new resource
 * 
 * @author adaussy
 * 
 */
public class ControlDiagramsCommand extends AbstractControlCommand {


	/**
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public ControlDiagramsCommand(ControlModeRequest request) {
		super("Move diagram to new resource", null, request);
		try {
			getAffectedFiles().addAll(getWorkspaceFiles(getDiagrams()));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Reference the diagram about to be moved into the request in order to be used by other particpants
	 * @param diags
	 */
	@SuppressWarnings("unchecked")
	protected void addMovedDiagramToRequest(List<Diagram> diags) {
		Collection<EObject> openables = (Collection<EObject>)getRequest().getParameter(ControlModeRequestParameters.MOVED_OPENABLES);
		if(openables == null) {
			openables = new ArrayList<EObject>();
		}
		openables.addAll(diags);
		getRequest().addParameters(Collections.singletonMap(ControlModeRequestParameters.MOVED_OPENABLES, openables));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject objectTOControl = getRequest().getTargetObject();
		EMFHelper.getUsages(objectTOControl);
		//Retrieve new notation resource created previously
		Resource newNotationResource = getRequest().getTargetResource(NotationModel.NOTATION_FILE_EXTENSION);
		if(newNotationResource == null) {
			return CommandResult.newErrorCommandResult("The notation model has not been created");
		}
		List<Diagram> diagrams = getDiagrams();
		if(!diagrams.isEmpty()) {
			newNotationResource.getContents().addAll(diagrams);
			addMovedDiagramToRequest(diagrams);
		}
		return CommandResult.newOKCommandResult(newNotationResource);
	}

	/**
	 * Get the list of all the diagrams to move
	 * @return
	 * @throws ExecutionException
	 */
	protected List<Diagram> getDiagrams() throws ExecutionException {
		Resource notationResource = null;
		try {
			notationResource = getRequest().getModelSet().getResource(getOldNotationURI(), true);
		} catch (Exception e) {
			notationResource = null;
		}
		if(notationResource == null) {
			throw new ExecutionException("unable to retrieve old notation resource");
		}
		return NotationUtils.getAllDescendantDiagramsInResource(getRequest().getTargetObject(), notationResource);
	}

	/**
	 * Get the old notation URI for request
	 * @return
	 * @throws ExecutionException
	 */
	protected URI getOldNotationURI() throws ExecutionException {
		URI uri = getRequest().getSourceURI();
		if(uri != null) {
			return uri.trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION);
		}
		throw new ExecutionException("Unable to retreive URI of the old notation model");
	}
}