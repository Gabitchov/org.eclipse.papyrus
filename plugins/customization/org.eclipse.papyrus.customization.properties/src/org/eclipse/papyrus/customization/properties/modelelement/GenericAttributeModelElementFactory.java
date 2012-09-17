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
package org.eclipse.papyrus.customization.properties.modelelement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.papyrus.views.properties.ui.UiFactory;
import org.eclipse.papyrus.views.properties.ui.UiPackage;

/**
 * A ModelElementFactory for handling {@link WidgetAttribute} properties
 * 
 * @author Camille Letavernier
 */
public class GenericAttributeModelElementFactory implements ModelElementFactory {

	//Source : Group
	//context : Custom:Attribute:Group
	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if(source == null) {
			Activator.log.warn("Unable to resolve the source element to an EObject"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);

		EClass valueAttribute = UiPackage.eINSTANCE.getValueAttribute();
		EClass referenceAttribute = UiPackage.eINSTANCE.getReferenceAttribute();
		EStructuralFeature attributes = UiPackage.eINSTANCE.getUIComponent_Attributes();

		return new GenericAttributeModelElement(source, domain, attributes, UiFactory.eINSTANCE, valueAttribute, referenceAttribute);
	}

	//	public List<ModelElement> createFromDataSource(ModelElement currentElement, DataSource source, String propertyPath, DataContextElement context) {
	//		throw new UnsupportedOperationException();
	//	}

}
