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

import java.util.Collection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.marte.table.assign.utils.AssignCommentDeleter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;


@SuppressWarnings("restriction")
/**
 * Query to assign values to the "to" attribute of a comment with an Assign stereotype.
 * @author omelois
 *
 */
public class SetToQuery extends AbstractSetAttributeQuery<Comment> {


	@Override
	public Collection<Element> evaluate(Comment context, ParameterValueList parameterValues, EditingDomain editingDomain)
		throws ModelQueryExecutionException {
		Collection<Element> result = super.evaluate(context, parameterValues, editingDomain);
		AssignCommentDeleter.deleteCommentWhenToAndFromAreEmpty(editingDomain, context);
		return result;
	}
	
	/**
	 * see {@link AbstractSetAttributeQuery}
	 */
	@Override
	protected EReference getNeededStructuralFeature() {
		return AllocPackage.Literals.ASSIGN__TO;
	}


}
