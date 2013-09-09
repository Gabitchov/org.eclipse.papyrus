/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.properties.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElementFactory;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;


public class NatTableFactory extends EMFModelElementFactory {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.EMFModelElementFactory#createFromSource(java.lang.Object,
	 *      org.eclipse.papyrus.views.properties.contexts.DataContextElement)
	 * 
	 * @param sourceElement
	 * @param context
	 * @return
	 */
	@Override
	public ModelElement createFromSource(final Object sourceElement, final DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if(source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}
		if(source instanceof Table) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
			return new NatTableModelElement((Table)source, domain);
		} else {
			return super.createFromSource(sourceElement, context);
		}
	}
}
