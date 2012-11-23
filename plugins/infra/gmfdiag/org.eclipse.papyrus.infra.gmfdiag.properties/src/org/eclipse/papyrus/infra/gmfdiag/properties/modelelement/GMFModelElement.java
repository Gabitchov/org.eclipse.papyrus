/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.properties.Activator;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.GradientObservableValue;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;

/**
 * A ModelElement to represent an element of the GMF Notation metamodel
 * 
 * @author Camille Letavernier
 * 
 */
public class GMFModelElement extends EMFModelElement {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The source element (from the Notation metamodel)
	 */
	public GMFModelElement(EObject source) {
		super(source);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The source element (from the Notation metamodel)
	 * @param domain
	 *        The editing domain on which the commands will be executed.
	 *        May be null
	 */
	public GMFModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(propertyPath);

		if(feature == null) {
			return null;
		}

		if(feature.getEType() == NotationPackage.eINSTANCE.getGradientData()) {
			return new GradientObservableValue(source, feature, domain);
		}

		if(feature.getUpperBound() != 1) {
			IObservableList list = domain == null ? EMFProperties.list(featurePath).observe(source) : new PapyrusObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
			return list;
		}

		IObservableValue value = domain == null ? EMFProperties.value(featurePath).observe(source) : new PapyrusObservableValue(getSource(featurePath), feature, domain);
		return value;
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		try {
			return ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, source).getLabelProvider();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return new LabelProvider();
		}
	}

}
