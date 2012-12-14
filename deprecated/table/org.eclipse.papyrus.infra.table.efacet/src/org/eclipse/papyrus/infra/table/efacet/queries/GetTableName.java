/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.table.efacet.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/** Return the name for the table */
public class GetTableName implements IJavaModelQuery<PapyrusTable, String> {

	public String evaluate(final PapyrusTable context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		return context.getName() + " (new)"; //$NON-NLS-1$
	}
}
