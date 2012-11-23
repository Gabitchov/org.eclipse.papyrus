/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchPart;

/**
 * ServicesUtils based on the Handler's ExecutionEvent
 * 
 * It first tests the current selection, then the IWorkbenchPart on which the handler is executed.
 * The IWorkbenchPart is expected to be adaptable to a ServiceRegistry.
 * 
 * @author Camille Letavernier
 * 
 * @see ServiceUtilsForSelection
 */
public class ServiceUtilsForHandlers extends AbstractServiceUtils<ExecutionEvent> {

	private ServiceUtilsForHandlers() {
		//Singleton
	}

	@Override
	public ServicesRegistry getServiceRegistry(ExecutionEvent from) throws ServiceException {
		Object context = from.getApplicationContext();
		if(context instanceof IEvaluationContext) {
			IEvaluationContext evaluationContext = (IEvaluationContext)context;
			Object selection = evaluationContext.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);

			ServicesRegistry registry;

			//First, try to resolve the ServicesRegistry from the current selection
			if(selection instanceof ISelection && !((ISelection)selection).isEmpty()) {
				try {
					registry = ServiceUtilsForSelection.getInstance().getServiceRegistry((ISelection)selection);
					if(registry != null) {
						return registry;
					}
				} catch (ServiceException ex) {
					//Ignore and try another ServiceUtils
				}
			}

			//We couldn't retrieve the ServiceRegistry from the current selection.

			//Try to adapt the current part to the ServicesRegistry
			IWorkbenchPart part = (IWorkbenchPart)evaluationContext.getVariable(ISources.ACTIVE_PART_NAME);
			if(part instanceof IAdaptable) {
				registry = (ServicesRegistry)((IAdaptable)part).getAdapter(ServicesRegistry.class);
				if(registry != null) {
					return registry;
				}
			}
		}

		throw new ServiceNotFoundException("The ServiceRegistry cannot be resolved");
	}

	public static ServiceUtilsForHandlers getInstance() {
		return instance;
	}

	private static final ServiceUtilsForHandlers instance = new ServiceUtilsForHandlers();
}
