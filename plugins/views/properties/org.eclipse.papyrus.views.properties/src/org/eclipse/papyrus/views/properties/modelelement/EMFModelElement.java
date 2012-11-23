/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableValue;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;

/**
 * A ModelElement to manipulate EMF objects.
 * This ModelElement uses EMFProperties to retrieve Observables when there
 * is no Editing Domain, and {@link EMFObservableValue} / {@link EMFObservableList} when
 * an Editing domain is available
 * 
 * @author Camille Letavernier
 */
public class EMFModelElement extends AbstractModelElement {

	/**
	 * The EObject manipulated by this ModelElement
	 */
	protected EObject source;

	/**
	 * The Editing Domain of the EObject for this ModelElement
	 */
	protected EditingDomain domain;

	/**
	 * 
	 * Constructs a new EMFModelElement for the given EObject
	 * 
	 * @param source
	 */
	public EMFModelElement(EObject source) {
		this(source, null);
	}

	/**
	 * 
	 * Constructs a new EMFModelElement for the given EObject and Editing Domain
	 * 
	 * @param source
	 * @param domain
	 */
	public EMFModelElement(EObject source, EditingDomain domain) {
		this.source = source;
		this.domain = domain;
	}

	/**
	 * @return the EditingDomain for this ModelElement
	 */
	public EditingDomain getDomain() {
		return domain;
	}

	/**
	 * @return the EObject for this ModelElement
	 */
	public EObject getSource() {
		return source;
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return null;
		}

		if(feature.getUpperBound() != 1) {
			IObservableList list = domain == null ? EMFProperties.list(featurePath).observe(source) : new EMFObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
			return list;
		}

		IObservableValue value = domain == null ? EMFProperties.value(featurePath).observe(source) : new EMFObservableValue(getSource(featurePath), feature, domain);
		return value;
	}

	/**
	 * Returns the last EObject by following the given featurePath from the {@link #source} EObject
	 * The last feature of the featurePath can be used to retrieve value from the returned EObject
	 * 
	 * @param featurePath
	 * @return the EObject found by resolving to the given FeaturePath
	 */
	public EObject getSource(FeaturePath featurePath) {
		EObject currentSource = source;
		EStructuralFeature[] features = featurePath.getFeaturePath();
		for(int i = 0; i < features.length - 1; i++) {
			currentSource = (EObject)currentSource.eGet(features[i]);
		}
		return currentSource;
	}

	/**
	 * Returns the feature represented by the given FeaturePath
	 * 
	 * @param featurePath
	 * @return
	 *         The last feature obtained by navigating the feature path
	 */
	public EStructuralFeature getFeature(FeaturePath featurePath) {
		EStructuralFeature[] features = featurePath.getFeaturePath();
		return features[features.length - 1];
	}

	/**
	 * Returns the feature represented by the given propertyPath.
	 * 
	 * @param propertyPath
	 *        The property path may contain one or more dots to navigate the properties (e.g. : feature1.feature2.feature3)
	 * @return
	 *         The last feature obtained by resolving the full property path
	 */
	public EStructuralFeature getFeature(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		return getFeature(featurePath);
	}

	/**
	 * Returns the featurePath corresponding to the given propertyPath
	 * 
	 * @param propertyPath
	 *        The property path may contain one or more dots to navigate the properties (e.g. : feature1.feature2.feature3)
	 * @return
	 *         The featurePath corresponding to the given propertyPath
	 */
	public FeaturePath getFeaturePath(String propertyPath) {
		String[] featureNames = propertyPath.split("\\."); //$NON-NLS-1$
		EStructuralFeature[] features = new EStructuralFeature[featureNames.length];

		int i = 0;
		EClass currentClass = source.eClass();
		for(String featureName : featureNames) {
			EStructuralFeature feature = currentClass.getEStructuralFeature(featureName);
			features[i++] = feature;
			if(i < featureNames.length) {
				if(feature instanceof EReference) {
					EReference reference = (EReference)feature;
					EClassifier type = reference.getEType();
					if(type instanceof EClass) {
						currentClass = (EClass)type;
						continue;
					}
				}

				Activator.log.warn("Cannot find feature path " + propertyPath + " for EClass " + source.eClass()); //$NON-NLS-1$ //$NON-NLS-2$
				return null;
			}
		}

		return FeaturePath.fromList(features);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);
		if(feature != null) {
			return new EMFContentProvider(getSource(featurePath), feature);
		}
		return super.getContentProvider(propertyPath);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		try {
			return ServiceUtilsForResource.getInstance().getServiceRegistry(source.eResource()).getService(LabelProviderService.class).getLabelProvider();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return new EMFLabelProvider();
		}
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return true;
		}
		return feature.isOrdered();
	}

	@Override
	public boolean isUnique(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return false;
		}
		return feature.isUnique();
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return false;
		}

		return EMFHelper.isRequired(feature);
	}

	@Override
	public boolean isEditable(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return false;
		}
		return feature.isChangeable() && !EMFHelper.isReadOnly(source);
	}

	@Override
	public boolean forceRefresh(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return false;
		}
		return feature.isDerived();
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature != null) {
			if(feature instanceof EReference) {
				EReference reference = (EReference)feature;
				if(reference.isContainment()) {
					return new EcorePropertyEditorFactory(reference);
				}
			}
		}

		return super.getValueFactory(propertyPath);
	}

	@Override
	public Object getDefaultValue(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return null;
		}
		return feature.getDefaultValue();
	}

	@Override
	public boolean getDirectCreation(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return false;
		}

		if(feature instanceof EAttribute) {
			return false;
		}

		return ((EReference)feature).isContainment();
	}
}
