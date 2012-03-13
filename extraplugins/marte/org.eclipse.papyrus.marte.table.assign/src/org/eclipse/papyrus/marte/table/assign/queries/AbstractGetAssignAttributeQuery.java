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

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;


@SuppressWarnings("restriction")
/**
 * AbstractQuery to get attribute values from a comment with the Assign stereotype.
 * @author omelois
 *
 */
public abstract class AbstractGetAssignAttributeQuery implements IJavaModelQuery<Comment, Collection<Element>> {

	public Collection<Element> evaluate(Comment context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Comment comment = (Comment)context;
		Assign assign = (Assign)comment.getStereotypeApplication(comment.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign"));
		return getAttribute(assign);
	}
	
	/**
	 * Generic method to get the required attribute.
	 * @param assign
	 * @return the needed attribute as a collection of elements.
	 */
	public abstract Collection<Element> getAttribute(Assign assign);

}
