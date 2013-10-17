/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * A LabelProvider for a single Profile Definition (EPackage)
 * @author Camille Letavernier
 *
 */
public class ProfileDefinitionLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	@Override
	protected String getText(EObject element) {
		if(element instanceof EPackage) {
			EPackage definition = (EPackage)element;
			String label = String.format("%s (%s)", definition.getName(), Util.getDefinitionVersion(definition).toString());
			return label;

		}

		return super.getText(element);
	}

	public boolean accept(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if(eObject instanceof EPackage) {
			EPackage ePackage = (EPackage)eObject;
			return UMLUtil.getProfile(ePackage) != null;
		}

		return false;
	}

}
