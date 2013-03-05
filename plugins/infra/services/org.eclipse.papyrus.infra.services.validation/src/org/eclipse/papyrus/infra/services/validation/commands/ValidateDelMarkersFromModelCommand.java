/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;


public class ValidateDelMarkersFromModelCommand extends AbstractValidateCommand {

	public ValidateDelMarkersFromModelCommand(EObject selectedElement) {
		super("Delete markers from model", TransactionUtil.getEditingDomain(selectedElement), selectedElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Resource resource = getValidationResource();
		if (resource != null) {
			try {
				MarkerListenerUtils.getMarkerProvider(getValidationResource())
					.deleteMarkers(resource, monitor);
			} catch (CoreException e) {
				throw new ExecutionException("Failed to delete all markers.", e);
			}
		}
		return null;
	}
}
