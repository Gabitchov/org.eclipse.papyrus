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
package org.eclipse.papyrus.infra.services.viewlabelprovider.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.viewlabelprovider.Activator;
import org.eclipse.papyrus.infra.services.viewlabelprovider.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * Adds a labelProvider to the LabelproviderService for GMF View that provides text and image of the semantic element represented by the View
 * 
 */
public class ViewLabelProvider implements IFilteredLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean accept(Object element) {
		if(element instanceof View) {
			if(!(element instanceof Diagram)) {
				EObject semanticElement = ((View)element).getElement();
				if(semanticElement != null) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the semantic element's image
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Image getImage(Object element) {
		if(element instanceof View) {
			EObject semanticElement = ((View)element).getElement();

			if(semanticElement != null) {
				try {
					LabelProviderService service = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, semanticElement);
					return service.getLabelProvider().getImage(semanticElement);
				} catch (ServiceException e) {
					Activator.log.warn(Messages.ViewLabelProvider_0 + semanticElement);
				}
			}
		}
		return null;
	}

	/**
	 * Returns the semantic element's text
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public String getText(Object element) {
		if(element instanceof View) {
			EObject semanticElement = ((View)element).getElement();

			if(semanticElement != null) {
				try {
					LabelProviderService service = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, semanticElement);
					return service.getLabelProvider().getText(semanticElement) + Messages.ViewLabelProvider_1;
				} catch (ServiceException e) {
					Activator.log.warn(Messages.ViewLabelProvider_0 + semanticElement);
				}
			}
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void addListener(ILabelProviderListener listener) {

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 * 
	 */
	public void dispose() {

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 * 
	 * @param element
	 * @param property
	 * @return
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void removeListener(ILabelProviderListener listener) {

	}
}
