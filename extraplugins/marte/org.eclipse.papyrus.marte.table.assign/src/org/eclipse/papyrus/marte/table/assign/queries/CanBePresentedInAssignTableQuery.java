/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Comment;

@SuppressWarnings("restriction")
/**
 * Query used during drag/drop onto the table, in order to allow only specific elements.
 * @author omelois
 *
 */
public class CanBePresentedInAssignTableQuery implements IJavaModelQuery<EObject, Boolean> {

	public Boolean evaluate(EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		//Only comments can be presented in the table
		return context instanceof Comment;
	}

}
