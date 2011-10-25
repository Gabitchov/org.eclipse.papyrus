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
package org.eclipse.papyrus.properties.customization.modelelement;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.customization.providers.ConstraintDescriptorContentProvider;
import org.eclipse.papyrus.properties.customization.providers.ContextLabelProvider;
import org.eclipse.papyrus.properties.customization.providers.DataContextElementContentProvider;
import org.eclipse.papyrus.properties.customization.providers.DependencyContentProvider;
import org.eclipse.papyrus.properties.customization.providers.EnvironmentContentProvider;
import org.eclipse.papyrus.properties.customization.providers.PropertyContentProvider;
import org.eclipse.papyrus.properties.customization.providers.PropertyEditorTypeContentProvider;
import org.eclipse.papyrus.properties.customization.providers.TabContentProvider;
import org.eclipse.papyrus.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.properties.modelelement.DataSource;
import org.eclipse.papyrus.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.properties.ui.PropertyEditor;
import org.eclipse.papyrus.properties.ui.UiPackage;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

/**
 * A {@link ModelElement} for customization specific properties
 * For performance issues, the default EMF Content Providers cannot
 * be used, as they usually load the whole ResourceSet, which is
 * really expensive in a Context Model : most of the resources
 * are XWT Files which are expensive to load, and never contain
 * any referenceable object. Hence, this ModelElement replaces
 * most EMF Content Providers by custom ones, much lighter. When such
 * a content provider cannot be found, the default EMF one is used.
 * 
 * @author Camille Letavernier
 */
public class CustomizationModelElement extends AbstractModelElement {

	private EMFModelElement delegate;

	private static Map<EClassifier, IStaticContentProvider> providers;

	/**
	 * Constructs a new ModelElement.
	 * 
	 * @param delegate
	 *        If this model element cannot handle a given property, it will
	 *        delegate the call to a standard EMF ModelElement
	 */
	public CustomizationModelElement(EMFModelElement delegate) {
		this.delegate = delegate;
		if(providers == null) {
			initializeProviders();
		}
	}

	private static void initializeProviders() {
		providers = new HashMap<EClassifier, IStaticContentProvider>();
		providers.put(EnvironmentPackage.eINSTANCE.getCompositeWidgetType(), new EnvironmentContentProvider(EnvironmentPackage.eINSTANCE.getEnvironment_CompositeWidgetTypes()));
		providers.put(EnvironmentPackage.eINSTANCE.getStandardWidgetType(), new EnvironmentContentProvider(EnvironmentPackage.eINSTANCE.getEnvironment_WidgetTypes()));
		providers.put(EnvironmentPackage.eINSTANCE.getConstraintType(), new EnvironmentContentProvider(EnvironmentPackage.eINSTANCE.getEnvironment_ConstraintTypes()));
		providers.put(EnvironmentPackage.eINSTANCE.getLayoutType(), new EnvironmentContentProvider(EnvironmentPackage.eINSTANCE.getEnvironment_LayoutTypes()));
		providers.put(EnvironmentPackage.eINSTANCE.getModelElementFactoryDescriptor(), new EnvironmentContentProvider(EnvironmentPackage.eINSTANCE.getEnvironment_ModelElementFactories()));
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		EStructuralFeature feature = delegate.getFeature(propertyPath);
		if(ContextsPackage.eINSTANCE.getSection_Name() == feature) {
			return new SectionNameObservableValue(delegate.getSource(), feature, delegate.getDomain());
		}
		return delegate.getObservable(propertyPath);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		EStructuralFeature feature = delegate.getFeature(propertyPath);
		if(feature == null) {
			return EmptyContentProvider.instance;
		}

		EClassifier classifier = feature.getEType();
		if(providers.containsKey(classifier)) {
			return providers.get(classifier);
		} else if(classifier == ContextsPackage.eINSTANCE.getProperty()) {
			return new PropertyContentProvider(delegate.getSource());
		} else if(classifier == ContextsPackage.eINSTANCE.getTab()) {
			//Sections can only be moved to tabs from non-plugin contexts
			boolean editableTabsOnly = delegate.getSource() instanceof Section;
			return new TabContentProvider(delegate.getSource(), editableTabsOnly);
		} else if(classifier instanceof EClass && EMFHelper.isSubclass((EClass)classifier, ContextsPackage.eINSTANCE.getConstraintDescriptor())) {
			return new ConstraintDescriptorContentProvider(delegate.getSource(), (EClass)classifier);
		} else if(isDataContextElement(classifier)) {
			return new DataContextElementContentProvider((DataContextElement)delegate.getSource());
		} else if(classifier == ContextsPackage.eINSTANCE.getContext()) {
			return new DependencyContentProvider((Context)delegate.getSource());
		} else if(feature == UiPackage.eINSTANCE.getPropertyEditor_WidgetType()) {
			return new PropertyEditorTypeContentProvider((PropertyEditor)delegate.getSource());
		} else {
			return delegate.getContentProvider(propertyPath);
		}
	}

	private boolean isDataContextElement(EClassifier classifier) {
		if(classifier == ContextsPackage.eINSTANCE.getDataContextElement()) {
			return true;
		}

		if(classifier instanceof EClass) {
			EClass eClass = (EClass)classifier;
			return eClass.getEAllSuperTypes().contains(ContextsPackage.eINSTANCE.getDataContextElement());
		}

		return false;
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		return new ContextLabelProvider();
		//		return new EMFObjectLabelProvider();
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		return delegate.isOrdered(propertyPath);
	}

	@Override
	public boolean isUnique(String propertyPath) {
		return delegate.isUnique(propertyPath);
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		return delegate.isMandatory(propertyPath);
	}

	@Override
	public boolean isEditable(String propertyPath) {
		if(delegate.getFeature(propertyPath) == ContextsPackage.eINSTANCE.getSection_SectionFile()) {
			return false;
		}
		return delegate.isEditable(propertyPath);
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		return delegate.getValueFactory(propertyPath);
	}

	@Override
	public boolean getDirectCreation(String propertyPath) {
		return delegate.getDirectCreation(propertyPath);
	}

	@Override
	public boolean forceRefresh(String localPropertyPath) {
		return false;
	}

	@Override
	public Object getDefaultValue(String propertyPath) {
		return delegate.getDefaultValue(propertyPath);
	}

	@Override
	public void setDataSource(DataSource source) {
		delegate.setDataSource(source);
	}

	@Override
	public void dispose() {
		super.dispose();
		delegate.dispose();
	}
}
