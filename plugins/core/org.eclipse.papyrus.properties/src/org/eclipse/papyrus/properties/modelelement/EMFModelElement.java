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
package org.eclipse.papyrus.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.databinding.CommitableObservableList;
import org.eclipse.papyrus.properties.databinding.EMFObservableValue;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;
import org.eclipse.papyrus.properties.providers.EcoreEnumeratorContentProvider;
import org.eclipse.papyrus.properties.providers.EcoreReferenceContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

public class EMFModelElement implements ModelElement {

	protected EObject source;

	protected EditingDomain domain;

	protected ILabelProvider labelProvider;

	//	private static ILabelProvider initLabelProvider() {
	//		final ILabelProvider provider = DisplayUtils.getLabelProvider();
	//		if(provider != null) {
	//			return provider;
	//		}
	//
	//		AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	//
	//		Activator.log.warn("Impossible to find the label provider from the service registry"); //$NON-NLS-1$
	//		// adapter factory used by EMF objects
	//		return new AdapterFactoryLabelProvider(factory) {
	//
	//			/**
	//			 * This implements {@link ILabelProvider}.getText by forwarding it
	//			 * to an object that implements {@link IItemLabelProvider#getText
	//			 * IItemLabelProvider.getText}
	//			 */
	//			@Override
	//			public String getText(Object object) {
	//				// Get the adapter from the factory.
	//				//
	//				IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(object, IItemLabelProvider.class);
	//				if(object instanceof EObject) {
	//					if(((EObject)object).eIsProxy()) {
	//						return "Proxy - " + object; //$NON-NLS-1$
	//					}
	//				}
	//				return itemLabelProvider != null ? itemLabelProvider.getText(object) : object == null ? "" : object.toString(); //$NON-NLS-1$
	//			}
	//		};
	//	}

	public EMFModelElement(EObject source) {
		this.source = source;
	}

	public EMFModelElement(EObject source, EditingDomain domain) {
		this.source = source;
		this.domain = domain;
	}

	public EditingDomain getDomain() {
		return domain;
	}

	public EObject getSource() {
		return source;
	}

	public IObservable getObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature.getUpperBound() != 1) {
			IObservableList list = domain == null ? EMFProperties.list(featurePath).observe(source) : new CommitableObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
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
	 * @return
	 */
	public EObject getSource(FeaturePath featurePath) {
		EObject currentSource = source;
		EStructuralFeature[] features = featurePath.getFeaturePath();
		for(int i = 0; i < features.length - 1; i++) {
			currentSource = (EObject)currentSource.eGet(features[i]);
		}
		return currentSource;
	}

	public String getLabel(String propertyPath) {
		return null;
	}

	public EStructuralFeature getFeature(FeaturePath featurePath) {
		EStructuralFeature[] features = featurePath.getFeaturePath();
		return features[features.length - 1];
	}

	public EStructuralFeature getFeature(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		return getFeature(featurePath);
	}

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

	public IStaticContentProvider getContentProvider(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);
		EClassifier type = feature.getEType();
		if(type instanceof EEnum) {
			return new EcoreEnumeratorContentProvider(feature);
		} else if(type instanceof EClass) {
			return new EcoreReferenceContentProvider(feature, getSource(featurePath));
		}

		return null;
	}

	public ILabelProvider getLabelProvider(String propertyPath) {
		return new EMFObjectLabelProvider();
	}

	public boolean isOrdered(String propertyPath) {

		EStructuralFeature feature = getFeature(propertyPath);
		return feature.isOrdered();
	}

	public boolean isUnique(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		return feature.isUnique();
	}

	public boolean isMandatory(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		return feature.isRequired();
	}

	public boolean isEditable(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		return !feature.isDerived() && feature.isChangeable();
	}
}
