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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.queries.tester;



import java.util.Collection;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.profilefacet.utils.ArgumentUtils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class IsAppliedRequiredStereotype implements IJavaModelQuery<Element, Boolean> {

	public Boolean evaluate(Element context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final String steQN = (String)parameterValues.getValueByParameterName(ArgumentUtils.STEREOTYPE_QUALIFIED_NAME);
		final Stereotype ste = context.getAppliedStereotype(steQN);
		if(ste == null) {
			for(final Stereotype appliedStereotype : context.getApplicableStereotypes()) {
				final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedStereotype);
				for(final Stereotype current : superClasses) {
					if(current.getQualifiedName().equals(steQN)) {
						return Boolean.TRUE;
					}
				}
			}
		} else {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
