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
package org.eclipse.papyrus.uml.diagram.clazz.custom.providers;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.style.ILabelMaskProvider;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.AssociationEndSourceLabelHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.AssociationEndTargetLabelHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.uml2.uml.Association;

/**
 * An IAdapterFactory for retrieving the {@link ILabelMaskProvider} from a UML
 * Property
 *
 * @author Camille Letavernier
 *
 */
public class AssociationLabelMaskProviderAdapterFactory implements IAdapterFactory {

	@Override
	public ILabelMaskProvider getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == ILabelMaskProvider.class && adaptableObject instanceof View) {
			View view = (View)adaptableObject;
			if(view.getDiagram() == null || !ModelEditPart.MODEL_ID.equals(view.getDiagram().getType())) {
				return null;
			}

			if(view.getElement() instanceof Association) {
				String type = view.getType();

				if("6003".equals(type)) {
					return AssociationEndSourceLabelHelper.getInstance();
				}

				if("6005".equals(type)) {
					return AssociationEndTargetLabelHelper.getInstance();
				}

				if("6033".equals(type)) {
					return AssociationEndSourceLabelHelper.getInstance();
				}

				if("6034".equals(type)) {
					return AssociationEndTargetLabelHelper.getInstance();
				}

				if("6024".equals(type)) {
					return AssociationEndTargetLabelHelper.getInstance();
				}

				if("6035".equals(type)) {
					return AssociationEndTargetLabelHelper.getInstance();
				}

			}
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[]{ ILabelMaskProvider.class };
	}

}
