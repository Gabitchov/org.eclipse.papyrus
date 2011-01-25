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
package org.eclipse.papyrus.properties.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.facet.infra.query.OCLModelQuery;
import org.eclipse.emf.facet.infra.query.QueryFactory;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.ReferenceProperty;
import org.eclipse.papyrus.properties.contexts.ValueProperty;
import org.eclipse.papyrus.properties.util.EMFHelper;

/**
 * A constraint applying an EMF Query on a selection. The Query should return
 * a Boolean.
 * 
 * @author Camille Letavernier
 */
public class EMFQueryConstraint extends AbstractConstraint {

	private OCLModelQuery query;

	@Override
	public void setConstraintDescriptor(ConstraintDescriptor descriptor) {
		for(ConfigProperty property : descriptor.getProperties()) {
			if(property.getName().equals("query")) { //$NON-NLS-1$

				if(property instanceof ReferenceProperty) {
					query = (OCLModelQuery)((ReferenceProperty)property).getValue();
				} else if(property instanceof ValueProperty) {
					String queryExpression = ((ValueProperty)property).getValue();
					query = QueryFactory.eINSTANCE.createOCLModelQuery();
					query.setQuery(queryExpression);
					query.setReturnType(EcorePackage.eINSTANCE.getEBoolean());
					query.getScope().add(EcorePackage.eINSTANCE.getEObject());
					throw new UnsupportedOperationException();
				}
			}
		}
		super.setConstraintDescriptor(descriptor);
	}

	public boolean match(Object selection) {
		//return true;

		//@TODO : instantiate & evaluate a MoDisco query from a String (OCL) OR define the MoDisco query in the Properties model

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
				return (Boolean)value;
			} catch (Exception ex) {
				Activator.log.error(ex);
			}

		}
		return false;
	}

}
