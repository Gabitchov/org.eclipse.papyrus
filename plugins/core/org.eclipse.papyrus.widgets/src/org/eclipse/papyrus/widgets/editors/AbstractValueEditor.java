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
package org.eclipse.papyrus.widgets.editors;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Composite;

/**
 * An abstract class to represent Single-value Editors.
 * Single-value editors are based on the Eclipse Databinding Framework
 * They take {@link IObservableValue}s as Input
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractValueEditor extends AbstractEditor {

	/**
	 * The IObservableValue associated to the model property
	 */
	protected IObservableValue modelProperty;

	/**
	 * The IObservableValue associated to the widget
	 */
	protected IObservableValue widgetObservable;

	/**
	 * The UpdateStrategy for binding data from widget to model
	 */
	protected UpdateValueStrategy targetToModelStrategy;

	/**
	 * The UpdateStrategy for binding data from model to widget
	 */
	protected UpdateValueStrategy modelToTargetStrategy;

	/**
	 * {@inheritDoc}
	 */
	public AbstractValueEditor(Composite parent) {
		super(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractValueEditor(Composite parent, int style, String label) {
		super(parent, style, label);
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractValueEditor(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractValueEditor(Composite parent, String label) {
		super(parent, label);
	}

	/**
	 * Sets this editor's IObservableValue associated to the widget property
	 * 
	 * @param widgetObservable
	 * @param targetToModel
	 *        the IConverter to convert data from Widget to Model
	 * @param modelToTarget
	 *        the IConverter to convert data from Model to Widget
	 */
	protected void setWidgetObservable(IObservableValue widgetObservable, IConverter targetToModel, IConverter modelToTarget) {
		this.widgetObservable = widgetObservable;
		setConverters(targetToModel, modelToTarget);
	}

	protected void setWidgetObservable(IObservableValue widgetObservable, boolean commitOnChange) {
		this.widgetObservable = widgetObservable;
		if(commitOnChange) {
			this.widgetObservable.addChangeListener(new IChangeListener() {

				public void handleChange(ChangeEvent event) {
					commit();
				}
			});
		}
	}

	/**
	 * Sets this editor's IObservableValue associated to the widget property
	 * 
	 * @param widgetObservable
	 */
	protected void setWidgetObservable(IObservableValue widgetObservable) {
		setWidgetObservable(widgetObservable, false);
	}

	/**
	 * Sets this editor's IObservableValue associated to the model property,
	 * and binds it to the Editor's Widget
	 * 
	 * @param modelProperty
	 */
	public void setModelObservable(IObservableValue modelProperty) {
		this.modelProperty = modelProperty;
		doBinding();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setConverters(IConverter targetToModel, IConverter modelToTarget) {
		if(targetToModelStrategy == null) {
			targetToModelStrategy = new UpdateValueStrategy();
		}
		if(modelToTargetStrategy == null) {
			modelToTargetStrategy = new UpdateValueStrategy();
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
	public void setUpdateStrategies(UpdateValueStrategy targetToModelStrategy, UpdateValueStrategy modelToTargetStrategy) {
		this.targetToModelStrategy = targetToModelStrategy;
		this.modelToTargetStrategy = modelToTargetStrategy;
	}

	/**
	 * Binds the Widget Observable to the Model observable property,
	 * using the specified converters or Update strategies when available
	 * 
	 * @see org.eclipse.papyrus.widgets.AbstractEditor#doBinding()
	 */
	@Override
	protected void doBinding() {

		if(modelProperty == null || widgetObservable == null)
			return;

		getBindingContext().bindValue(widgetObservable, modelProperty, targetToModelStrategy, modelToTargetStrategy);
	}

	/**
	 * Returns the value from the widget
	 * May be used even when the Model Observable is not set
	 * 
	 * @return
	 *         The current value for this editor
	 */
	public abstract Object getValue();
}
