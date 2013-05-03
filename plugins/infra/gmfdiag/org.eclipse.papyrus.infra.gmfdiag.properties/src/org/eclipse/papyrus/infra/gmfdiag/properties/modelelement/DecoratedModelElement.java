/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomIntStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.ShapeDecorator;
import org.eclipse.papyrus.infra.gmfdiag.properties.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.MapLabelProvider;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement;

/**
 * Model element for the decorated view in GMF. This is not a model element, as the properties to search are non-EMF Properties
 */
public class DecoratedModelElement extends AbstractModelElement {
 
	private final static Map<Object, String> labels = new HashMap<Object, String>();
	static {
		labels.put(0, Messages.DecoratedModelElement_NORTH_WEST);
		labels.put(1, Messages.DecoratedModelElement_NORTH);
		labels.put(2, Messages.DecoratedModelElement_NORTH_EAST);
		labels.put(3, Messages.DecoratedModelElement_WEST);
		labels.put(4, Messages.DecoratedModelElement_CENTER);
		labels.put(5, Messages.DecoratedModelElement_EAST);
		labels.put(6, Messages.DecoratedModelElement_SOUTH_WEST);
		labels.put(7, Messages.DecoratedModelElement_SOUTH);
		labels.put(8, Messages.DecoratedModelElement_SOUTH_EAST);
	}
	
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
	public DecoratedModelElement(EObject source) {
		this(source, null);
	}

	/**
	 * 
	 * Constructs a new EMFModelElement for the given EObject and Editing Domain
	 * 
	 * @param source
	 * @param domain
	 */
	public DecoratedModelElement(EObject source, EditingDomain domain) {
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
		return super.getObservable(propertyPath);
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
		return super.getLabelProvider(propertyPath);
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
