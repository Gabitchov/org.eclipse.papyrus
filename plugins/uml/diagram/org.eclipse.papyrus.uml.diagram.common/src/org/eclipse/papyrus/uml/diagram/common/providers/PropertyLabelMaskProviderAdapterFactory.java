/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.emf.appearance.style.ILabelMaskProvider;
import org.eclipse.papyrus.uml.diagram.common.helper.PortLabelHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

/**
 * An IAdapterFactory for retrieving the {@link ILabelMaskProvider} from a UML
 * Property
 *
 * @author Camille Letavernier
 *
 */
public class PropertyLabelMaskProviderAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == ILabelMaskProvider.class) {
			if(adaptableObject instanceof Port) {
				return PortLabelHelper.getInstance();
			} else if(adaptableObject instanceof Property) {
				Property property = (Property)adaptableObject;
				if(property.getAssociation() != null) {
					//					Association association = property.getAssociation();
					//					int index = association.getMemberEnds().indexOf(property);
					//					if (index == 0){
					//						return AssociationEndSourceLabelHelper.getInstance();
					//					} else {
					//						return AssociationEndTargetLabelHelper.getInstance();
					//					}
				}

				return PropertyLabelHelper.getInstance();
			}
		}
		return null;
	}

	public Class<?>[] getAdapterList() {
		return new Class[]{ ILabelMaskProvider.class };
	}

}
