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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.modelexplorer.queries.AbstractEditorContainerQuery;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;

/** Get the collection of all contained tables */
public class GetContainedTables extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<PapyrusTableInstance>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<PapyrusTableInstance> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Collection<PapyrusTableInstance> tables = new ArrayList<PapyrusTableInstance>();

		try {
			for(Object page : getPageMngr().allPages()) {
				if(!(page instanceof PapyrusTableInstance)) {
					continue;
				}
				// We have a GMF Diagram
				PapyrusTableInstance diagram = (PapyrusTableInstance)page;
				if(context.equals(diagram.getTable().getContext())) {
					tables.add(diagram);
				}
			}
		} catch (ServiceException e) {
			//When the customization is not loaded in a Papyrus context, it simply evaluates to false
			//nothing to do
		}
		return tables;
	}

}
