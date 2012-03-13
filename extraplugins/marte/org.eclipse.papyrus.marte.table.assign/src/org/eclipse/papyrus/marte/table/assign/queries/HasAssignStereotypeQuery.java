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

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Stereotype;

@SuppressWarnings("restriction")
/**
 * Makes sure the element is a package and has the stereotype "assign".
 * @author omelois
 *
 */
public class HasAssignStereotypeQuery implements IJavaModelQuery<Comment, Boolean> {

	public Boolean evaluate(Comment context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Stereotype stereotype = context.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign"); //$NON-NLS-1$
		return stereotype != null;
	}

}
