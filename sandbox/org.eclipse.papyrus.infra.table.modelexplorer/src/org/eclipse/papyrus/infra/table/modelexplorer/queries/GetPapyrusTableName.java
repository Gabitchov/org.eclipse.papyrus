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

package org.eclipse.papyrus.infra.table.modelexplorer.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.table.metamodel.papyrustable.PapyrusTable;


/** Return the name for the table */
public class GetPapyrusTableName implements IJavaModelQuery<PapyrusTable, String> {

	/**
	 * {@inheritDoc}
	 */
	public String evaluate(final PapyrusTable context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		return context.getName();
	}
}
