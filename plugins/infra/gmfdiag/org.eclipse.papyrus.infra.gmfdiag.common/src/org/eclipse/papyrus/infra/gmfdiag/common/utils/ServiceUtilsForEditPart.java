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
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;

/**
 * A helper for manipulating the Papyrus services from an EditPart
 * 
 * @author Camille Letavernier
 */
public class ServiceUtilsForEditPart extends AbstractServiceUtils<EditPart> {

	@Override
	public ServicesRegistry getServiceRegistry(EditPart from) throws ServiceException {
		EObject semanticElement = EMFHelper.getEObject(from);
		if(semanticElement == null) {
			Object model = from.getModel();
			if(model instanceof EObject) {
				semanticElement = (EObject)model;
			}
		}

		if(semanticElement != null) {
			return ServiceUtilsForEObject.getInstance().getServiceRegistry(semanticElement);
		}

		throw new ServiceException("Cannot find the ServicesRegistry from the selected EditPart");
	}

	public static ServiceUtilsForEditPart getInstance() {
		return instance;
	}

	private static ServiceUtilsForEditPart instance = new ServiceUtilsForEditPart();

	private ServiceUtilsForEditPart() {
		//Singleton
	}

}
