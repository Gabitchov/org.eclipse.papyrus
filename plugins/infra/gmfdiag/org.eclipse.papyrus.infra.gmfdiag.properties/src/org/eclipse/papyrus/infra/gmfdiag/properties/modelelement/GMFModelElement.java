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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.ShapeDecorator;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.GradientObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.custom.CustomIntStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.providers.GMFLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.MapLabelProvider;
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

	private final static Map<Integer, String> labels = new HashMap<Integer, String>();
	static {
		labels.put(0, "North-West");
		labels.put(1, "North");
		labels.put(2, "North-East");
		labels.put(3, "West");
		labels.put(4, "Center");
		labels.put(5, "East");
		labels.put(6, "South-West");
		labels.put(7, "South");
		labels.put(8, "South-East");
	}

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IObservable doGetObservable(String propertyPath) {
		if(ShapeDecorator.SHAPE_DECORATOR_VISIBILITY.equals(propertyPath)) {
			return new CustomBooleanStyleObservableValue((View)source, domain, ShapeDecorator.SHAPE_DECORATOR_VISIBILITY);
		}

		if(ShapeDecorator.SHAPE_DECORATOR_DIRECTION.equals(propertyPath)) {
			return new CustomIntStyleObservableValue((View)source, domain, ShapeDecorator.SHAPE_DECORATOR_DIRECTION);
		}

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEditable(String propertyPath) {
		if(ShapeDecorator.SHAPE_DECORATOR_DIRECTION.equals(propertyPath)) {
			return true;
		}

		if(ShapeDecorator.SHAPE_DECORATOR_VISIBILITY.equals(propertyPath)) {
			return true;
		}

		return super.isEditable(propertyPath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {

		if(ShapeDecorator.SHAPE_DECORATOR_DIRECTION.equals(propertyPath)) {
			return new MapLabelProvider(labels);
		}

		return new GMFLabelProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(ShapeDecorator.SHAPE_DECORATOR_DIRECTION.equals(propertyPath)) {
			return new AbstractStaticContentProvider() {

				/**
				 * {@inheritDoc}
				 */
				public Object[] getElements() {
					return labels.keySet().toArray(new Integer[0]);
				}
			};
		}

		return super.getContentProvider(propertyPath);
	}
}
