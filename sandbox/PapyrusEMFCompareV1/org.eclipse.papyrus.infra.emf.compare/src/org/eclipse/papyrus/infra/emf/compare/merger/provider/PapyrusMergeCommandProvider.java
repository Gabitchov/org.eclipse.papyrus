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
package org.eclipse.papyrus.infra.emf.compare.merger.provider;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


public class PapyrusMergeCommandProvider {

	public static PapyrusMergeCommandProvider INSTANCE = new PapyrusMergeCommandProvider();

	private PapyrusMergeCommandProvider() {

	}

	public Command getDestroyCommand(final TransactionalEditingDomain domain, final EObject element) {
		final IEditCommandRequest request = new DestroyElementRequest(domain, element, false);
		return getCommand(element, request);
	}

	private Command getCommand(final EObject elementToEdit, final IEditCommandRequest request) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
		if(provider != null) {
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
	}

	public Command getSetCommand(final TransactionalEditingDomain domain, final EObject element, final EStructuralFeature feature, final Object value) {
		final IEditCommandRequest request = new SetRequest(domain, element, feature, value);
		return getCommand(element, request);
	}



}
