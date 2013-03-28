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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * A LabelProvider for unresolved "AnyType" elements
 * 
 * @author Camille Letavernier
 * 
 */
public class AnyTypeLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	@Override
	public String getText(Object element) {
		EObject eObject = EMFHelper.getEObject(element);

		if(!(eObject instanceof AnyType)) {
			return super.getText(element);
		}

		AnyType anyType = (AnyType)eObject;
		EClass eClass = anyType.eClass();
		if(eClass != null) {
			return "Missing " + eClass.getName();
		} else {
			return "Missing component";
		}
	}

	@Override
	public Image getImage(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if(!(eObject instanceof AnyType)) {
			return super.getImage(element);
		}

		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
	}

	public boolean accept(Object element) {
		return EMFHelper.getEObject(element) instanceof AnyType;
	}

}
