/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.nattable.provider;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.swt.graphics.Image;


public class EMFFeatureHeaderLabelProvider implements IFilteredLabelProvider {

	private boolean displayName = true;

	private boolean displayMultiplicity = true;

	private boolean displayType = true;

	private boolean displayIsDerived = true;

	public EMFFeatureHeaderLabelProvider() {
	}

	public Image getImage(Object element) {
		return null;
	}

	public String getText(Object element) {
		EStructuralFeature feature = (EStructuralFeature)element;
		String txt = getText(feature.getName(), feature.getEType(), feature.isDerived(), feature.getLowerBound(), feature.getUpperBound());
		if(feature instanceof EReference && ((EReference)feature).isContainment()) {
			txt = "CF " + txt;
		}
		return txt;
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
		return element instanceof EStructuralFeature;
	}

	protected String getText(final String name, final Object type, final boolean isDerived, final int lowerBound, final int upperBounds) {
		String displayedText = "";
		if(isDerived && displayIsDerived) {
			displayedText += "/";
		}
		if(displayName) {
			displayedText += name;
		}
		if(displayType) {
			if(displayName) {
				displayedText += " : ";
			}
			displayedText += getTypeName(type);
		}
		if(displayMultiplicity) {
			displayedText += " [";
			if(upperBounds == -1 && lowerBound <= 1) {
				displayedText += "*";
			} else if(lowerBound == upperBounds) {
				displayedText += Integer.toString(lowerBound);
			} else {
				displayedText += Integer.toString(lowerBound);
				displayedText += "..";
				if(upperBounds == -1) {
					displayedText += "*";
				} else {
					displayedText += Integer.toString(upperBounds);
				}
			}
			displayedText += "]";
		}

		return displayedText;
	}

	protected String getTypeName(final Object type) {
		if(type instanceof EObject) {
			if(type instanceof EClassifier) {
				return ((EClassifier)type).getName();
			} else {
				return getLabelForEObject((EObject)type);//((EClassifier)type).getName();//FIXME : use the label provider service for it?
			}
		}
		return "";
	}

	private String getLabelForEObject(final EObject object) {
		LabelProviderService service = getLabelProviderService(object);
		if(service == null) {
			//			service = serv;
			service = new LabelProviderServiceImpl();
		}
		if(service != null) {
			final ILabelProvider provider = service.getLabelProvider();
			return provider.getText(object);
		}
		return ""; //$NON-NLS-1$
	}

	private LabelProviderService getLabelProviderService(final EObject eobject) {
		final ServicesRegistry registry = getServiceRegistry(eobject);
		if(registry != null) {
			try {
				return registry.getService(LabelProviderService.class);
			} catch (final ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private ServicesRegistry getServiceRegistry(final EObject object) {
		try {
			return ServiceUtilsForResource.getInstance().getServiceRegistry(object.eResource());
		} catch (final ServiceException e) {
			//			Activator.log.error("ServiceRegistry not found", e);
		}
		return null;
	}
}
