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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class AttributeMatchLabelProvider implements IFilteredLabelProvider {

	public Image getImage(Object element) {
		if(element instanceof AttributeMatch) {
			LabelProviderService service = new LabelProviderServiceImpl();
			try {
				service.startService();
				return service.getLabelProvider().getImage(((AttributeMatch)element).getSource());
			} catch (ServiceException e) {
				Activator.log.warn(Messages.AttributeMatchLabelProvider_0 + ((AttributeMatch)element).getSource());
			}
		}
		return null;
	}

	private String printResult(String sectionThatMatch, String value, int offset, int lenght, String attributeName) {
		return "\"" + sectionThatMatch + "\"" + Messages.AttributeMatchLabelProvider_3 + "\"" + value + "\" [" + offset + "," + lenght + "] (" + attributeName + Messages.AttributeMatchLabelProvider_8 + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-9$
	}

	public String getText(Object element) {

		if(element instanceof AttributeMatch) {
			AttributeMatch attributeMatch = ((AttributeMatch)element);
			if((attributeMatch).getTarget() instanceof EObject) {
				EObject target = (EObject)attributeMatch.getTarget();
				if(attributeMatch.getSource() instanceof EAttribute) {
					EAttribute source = (EAttribute)attributeMatch.getSource();
					if(target.eGet(source) instanceof String) {
						String value = (String)target.eGet(source);
						return printResult(value.substring(attributeMatch.getOffset(), attributeMatch.getLength()), value, attributeMatch.getOffset(), attributeMatch.getLength(), source.getName());

					}
				} else if(attributeMatch.getSource() instanceof Property) {
					Property source = (Property)attributeMatch.getSource();
					Class containingClass = source.getClass_();
					if(containingClass instanceof Stereotype) {
						if(target instanceof Element) {
							Object tagValue = ((Element)target).getValue((Stereotype)containingClass, source.getName());
							if(tagValue instanceof String) {
								String value = (String)tagValue;
								return printResult(value.substring(attributeMatch.getOffset(), attributeMatch.getLength()), value, attributeMatch.getOffset(), attributeMatch.getLength(), source.getName());
							}
						}
					}
				}
			}
		}

		return ""; //$NON-NLS-1$

	}

	public void addListener(ILabelProviderListener listener) {

	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}

	public boolean accept(Object element) {
		if(element instanceof AttributeMatch) {
			return true;

		}
		return false;
	}

}
