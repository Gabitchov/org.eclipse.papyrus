/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.merger;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

public abstract class AbstractPapyrusDefaultMerger extends DefaultMerger {

	protected Command getCommand(final Object objectToEdit, final IEditCommandRequest request) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(objectToEdit);
		if(provider != null) {
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		//FIXME
		return TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
	}

	protected Command getDestroyElementCommand(final EObject element) {
		final TransactionalEditingDomain domain = getEditingDomain();
		Command command = null;
		if(domain != null) {
			final IEditCommandRequest request = new DestroyElementRequest(domain, element, false);
			command = getCommand(element, request);
		}
		return command;
	}

	protected boolean usePapyrusEditService() {
		return false;
	}



	public abstract Command doApplyInOriginCommand();

	public abstract Command doUndoInTargetCommand();
}
