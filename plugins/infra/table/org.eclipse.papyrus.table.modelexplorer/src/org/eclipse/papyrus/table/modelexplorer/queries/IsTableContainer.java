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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.table.modelexplorer.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.modelexplorer.queries.AbstractEditorContainerQuery;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.table.modelexplorer.messages.Messages;

/** Returns true if the element contains a Table */
public class IsTableContainer extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		// Walk on page references
		try {
			for(Object page : getPageMngr().allPages()) {
				if(!(page instanceof PapyrusTableInstance)) {
					continue;
				}
				// We have a GMF Diagram
				PapyrusTableInstance papyrusTableInstance = (PapyrusTableInstance)page;
				if(context.equals(papyrusTableInstance.getTable().getContext())) {
					return true;
				}

			}
		} catch (ServiceException e) {
			throw new ModelQueryExecutionException(Messages.IsTableContainer_EnableToFindTheServiceRegistry);
		}
		return false;
	}
}
