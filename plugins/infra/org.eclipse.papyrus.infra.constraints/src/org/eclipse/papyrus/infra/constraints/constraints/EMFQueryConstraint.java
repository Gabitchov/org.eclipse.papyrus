/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.constraints.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.facet.infra.query.OCLModelQuery;
import org.eclipse.emf.facet.infra.query.QueryFactory;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.papyrus.infra.constraints.Activator;
import org.eclipse.papyrus.infra.constraints.ConfigProperty;
import org.eclipse.papyrus.infra.constraints.ReferenceProperty;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.ValueProperty;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A constraint applying an EMF Query on a selection. The Query should return
 * a Boolean.
 * 
 * @author Camille Letavernier
 */
public class EMFQueryConstraint extends AbstractConstraint {

	private OCLModelQuery query;

	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		ConfigProperty property = getProperty("query"); //$NON-NLS-1$
		if(property instanceof ReferenceProperty) {
			query = (OCLModelQuery)getReferenceValue("query"); //$NON-NLS-1$
		} else {
			String queryExpression = ((ValueProperty)property).getValue();
			query = QueryFactory.eINSTANCE.createOCLModelQuery();
			query.setQuery(queryExpression);
			query.setReturnType(EcorePackage.eINSTANCE.getEBoolean());
			query.getScope().add(EcorePackage.eINSTANCE.getEObject());
			throw new UnsupportedOperationException();
		}
	}

	public boolean match(Object selection) {
		if(query == null) {
			return false;
		}

		EObject selectedItem = EMFHelper.getEObject(selection);

		if(selectedItem != null) {
			try {
				ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
				AbstractModelQuery abstractQuery = catalog.getModelQueryImpl(query);
				ModelQueryResult result = abstractQuery.evaluate(selectedItem);
				Object value = result.getValue();
				return value == null ? false : (Boolean)value;
			} catch (Exception ex) {
				Activator.log.error(ex);
			}

		}
		return false;
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint != null && constraint instanceof EMFQueryConstraint) {
			EMFQueryConstraint other = (EMFQueryConstraint)constraint;
			return other.query.equals(query);
		}
		return false;
	}

}
