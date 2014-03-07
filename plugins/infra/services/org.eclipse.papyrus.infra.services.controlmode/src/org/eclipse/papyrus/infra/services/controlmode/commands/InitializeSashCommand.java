/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net- Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.exception.SashEditorException;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters;

/**
 * Initialize the di resource with all necessary informations
 * ex : Page Ref
 *
 * @author adaussy
 *
 */
public class InitializeSashCommand extends AbstractControlCommand {

	/**
	 * @param request
	 */
	public InitializeSashCommand(ControlModeRequest request) {
		super("Initialize sash model", null, request);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		/*
		 * Get from the request tab and diagrams being moved
		 */
		Collection<EObject> openables = getMovedOpenablesFromRequest();
		try {
			SashWindowsMngr sashMng = createSashWindowsMngr(openables);
			Resource diResource = getDiResource();
			if(diResource == null) {
				return CommandResult.newErrorCommandResult("Unable to find DI resource");
			}
			diResource.getContents().add(sashMng);
		} catch (SashEditorException e) {
			e.printStackTrace();
			return CommandResult.newErrorCommandResult(e);
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @return tables being moved from the request
	 */
	@SuppressWarnings("unchecked")
	protected Collection<EObject> getMovedOpenablesFromRequest() {
		Collection<EObject> tabs = (Collection<EObject>)getRequest().getParameter(ControlModeRequestParameters.MOVED_OPENABLES);
		if(tabs == null) {
			return new ArrayList<EObject>();
		}
		return tabs;
	}

	/**
	 * @return retrieve the di resource from the request
	 */
	protected Resource getDiResource() {
		return getRequest().getTargetResource(org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel.MODEL_FILE_EXTENSION);
	}

	/**
	 * Create a new {@link SashModel} and add page ref for each diagrams and tables being controlled
	 *
	 * @param openables
	 * @return
	 * @throws SashEditorException
	 */
	protected SashWindowsMngr createSashWindowsMngr(Collection<EObject> openables) throws SashEditorException {
		// Create a new SashWindowManager
		SashWindowsMngr windowsMngr = DiUtils.createDefaultSashWindowsMngr();
		Resource diResource = SashModelUtils.getSashModel(getRequest().getModelSet()).getResource();
		// add pages to the page list
		for(EObject openable : openables) {
			PageRef pageRef = DiUtils.getPageRef(diResource, openable);
			if(pageRef != null) {
				//windowsMngr.getPageList().addPage(pageRef.getPageIdentifier()); //The page list is not used anymore
				DiUtils.addPageToTabFolder(windowsMngr, pageRef);
			}
		}
		return windowsMngr;
	}

}
