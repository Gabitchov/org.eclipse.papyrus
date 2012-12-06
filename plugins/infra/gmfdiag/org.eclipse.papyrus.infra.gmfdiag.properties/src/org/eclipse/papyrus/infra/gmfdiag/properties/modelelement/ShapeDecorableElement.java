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

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.ShapeDecorator;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.custom.CustomIntStyleObservableValue;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;


/**
 * Element that can be decorated with shapes
 */
public class ShapeDecorableElement extends GMFModelElement {

	/**
	 * Constructor.
	 *
	 * @param source the source view
	 * @param domain the editing domain that interacts with the view
	 */
	public ShapeDecorableElement(View source, EditingDomain domain) {
		super(source, domain);
	}
	
	/**
	 * Constructor.
	 *
	 * @param source the source view
	 */
	public ShapeDecorableElement(EObject source) {
		super(source);
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
					return new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 };
				}
			};
		}
		
		
		return super.getContentProvider(propertyPath);
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
		return super.doGetObservable(propertyPath);
	}
	
	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		if(ShapeDecorator.SHAPE_DECORATOR_VISIBILITY.equals(propertyPath)) {
			return new LabelProvider() {
				
				/**
				 * {@inheritDoc}
				 */
				@Override
				public String getText(Object element) {
					return super.getText(element);
				}
			};
		}
		
		if(ShapeDecorator.SHAPE_DECORATOR_DIRECTION.equals(propertyPath)) {
			return new LabelProvider() {
				/**
				 * {@inheritDoc}
				 */
				@Override
				public String getText(Object element) {
					return super.getText(element);
				}
			};
		}
		
		return super.getLabelProvider(propertyPath);
	}
	
}
