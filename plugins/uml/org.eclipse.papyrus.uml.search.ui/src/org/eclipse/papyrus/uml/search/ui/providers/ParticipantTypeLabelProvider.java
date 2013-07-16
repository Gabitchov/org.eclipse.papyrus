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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.swtdesigner.ResourceManager;

public class ParticipantTypeLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object object) {
		if(object instanceof ParticipantTypeElement)
			if(((ParticipantTypeElement)object).getElement() instanceof ENamedElement) {
				String imagePath = "/icons/full/obj16/" + ((ENamedElement)((ParticipantTypeElement)object).getElement()).getName() + ".gif"; //$NON-NLS-1$ //$NON-NLS-2$
				return ResourceManager.getPluginImage("org.eclipse.uml2.uml.edit", imagePath); //$NON-NLS-1$
			}

		return null;
	}

	@Override
	public String getText(Object object) {

		if(object instanceof ParticipantTypeElement) {
			return ((ParticipantTypeElement)object).getText();
		}

		return ""; //$NON-NLS-1$
		//
	}

}
