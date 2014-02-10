/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.widgets.Composite;

/**
 * An abstract class to represent List Editors.
 * List editors are based on the Eclipse Databinding Framework
 * They take {@link IObservableList}s as Input
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractListEditor extends AbstractEditor {

	/**
	 * The IObservableList associated to the model property
	 */
	protected IObservableList modelProperty;

	/**
	 * The UpdateStrategy for binding data from widget to model
	 */
	protected UpdateListStrategy targetToModelStrategy;

	/**
	 * The UpdateStrategy for binding data from model to widget
	 */
	protected UpdateListStrategy modelToTargetStrategy;

	/**
	 * The IObservableList associated to the widget
	 */
	protected IObservableList widgetObservable;

	protected AbstractListEditor(Composite parent) {
		super(parent);
	}

	protected AbstractListEditor(Composite parent, int style, String label) {
		super(parent, style, label);
	}

	protected AbstractListEditor(Composite parent, int style) {
		super(parent, style);
	}

	protected AbstractListEditor(Composite parent, String label) {
		super(parent, label);
	}

	/**
	 * Sets this editor's IObservableList associated to the widget property
	 * 
	 * @param widgetObservable
	 * @param targetToModel
	 *        the IConverter to convert data from Widget to Model
	 * @param modelToTarget
	 *        the IConverter to convert data from Model to Widget
	 */
	protected void setWidgetObservable(IObservableList widgetObservable, IConverter targetToModel, IConverter modelToTarget) {
		this.widgetObservable = widgetObservable;
		setConverters(targetToModel, modelToTarget);
	}

	/**
	 * Sets this editor's IObservableList associated to the widget property
	 * 
	 * @param widgetObservable
	 */
	protected void setWidgetObservable(IObservableList widgetObservable) {
		this.widgetObservable = widgetObservable;
	}

	/**
	 * Sets this editor's IObservableList associated to the model property,
	 * and binds it to the Editor's Widget
	 * 
	 * @param modelProperty
	 */
	public void setModelObservable(IObservableList modelProperty) {
		this.modelProperty = modelProperty;
		doBinding();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setConverters(IConverter targetToModel, IConverter modelToTarget) {
		if(targetToModelStrategy == null) {
			targetToModelStrategy = new UpdateListStrategy();
		}
		if(modelToTargetStrategy == null) {
			modelToTargetStrategy = new UpdateListStrategy();
		}

		targetToModelStrategy.setConverter(targetToModel);
		modelToTargetStrategy.setConverter(modelToTarget);
	}

	/**
	 * Sets the UpdateStrategies for databinding between the widget and the model
	 * 
	 * @param targetToModelStrategy
	 *        The widget to model Update strategy
	 * @param modelToTargetStrategy
	 *        The model to widget Update strategy
	 */
	public void setUpdateStrategies(UpdateListStrategy targetToModelStrategy, UpdateListStrategy modelToTargetStrategy) {
		this.targetToModelStrategy = targetToModelStrategy;
		this.modelToTargetStrategy = modelToTargetStrategy;
	}

	/**
	 * Binds the Widget Observable to the Model observable property,
	 * using the specified converters or Update strategies when available
	 * 
	 * When overriding this method, you should also override {@link #refreshValue()}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.AbstractEditor#doBinding()
	 */
	@Override
	protected void doBinding() {

		if(modelProperty == null || widgetObservable == null) {
			return;
		}

		binding = getBindingContext().bindList(widgetObservable, modelProperty, targetToModelStrategy, modelToTargetStrategy);
	}
	
	protected Object getContextElement() {
		return (modelProperty instanceof IObserving) ? ((IObserving)modelProperty).getObserved() : null;
	}
}
