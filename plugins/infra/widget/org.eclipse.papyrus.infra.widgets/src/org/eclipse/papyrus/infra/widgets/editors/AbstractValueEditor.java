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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;


import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.papyrus.infra.widgets.validator.AbstractValidator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * An abstract class to represent Single-value Editors. Single-value editors are
 * based on the Eclipse Databinding Framework They take {@link IObservableValue} s as Input
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
	 * the Validator for the target
	 */
	protected AbstractValidator targetValidator;

	/**
	 * the Validator for the model
	 */
	protected IValidator modelValidator;

	protected boolean errorBinding = false;

	protected ControlDecoration controlDecoration;


	protected final Color VALIDE = new Color(Display.getCurrent(), 153, 255, 153);

	protected final Color DEFAULT = new Color(Display.getCurrent(), 255, 255, 255);

	protected final Color EDIT = new Color(Display.getCurrent(), 255, 204, 153);

	protected final Color ERROR = new Color(Display.getCurrent(), 255, 153, 153);

	protected AbstractValueEditor(Composite parent) {
		super(parent);
	}

	protected AbstractValueEditor(Composite parent, int style, String label) {
		super(parent, style, label);
	}

	protected AbstractValueEditor(Composite parent, int style) {
		super(parent, style);
	}

	protected AbstractValueEditor(Composite parent, String label) {
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

	/**
	 * Sets this editor's widgetObservable
	 *
	 * @param widgetObservable
	 *        The widget observable value
	 * @param commitOnChange
	 *        If true, CommitListeners will be notified when the widget
	 *        observable changes
	 */
	protected void setWidgetObservable(IObservableValue widgetObservable, boolean commitOnChange) {
		this.widgetObservable = widgetObservable;

		if(commitOnChange) {
			this.widgetObservable.addChangeListener(new IChangeListener() {

				@Override
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
	 * Sets this editor's IObservableValue associated to the model property, and
	 * binds it to the Editor's Widget
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
	 * Sets the UpdateStrategies for databinding between the widget and the
	 * model
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
	 * Binds the Widget Observable to the Model observable property, using the
	 * specified converters or Update strategies when available
	 *
	 * When overriding this method, you should also override {@link #refreshValue()}
	 *
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#doBinding()
	 */
	@Override
	protected void doBinding() {
		if(modelProperty == null || widgetObservable == null) {
			return;
		}

		setBinding();
	}

	/**
	 * Returns the value from the widget May be used even when the Model
	 * Observable is not set
	 *
	 * @return The current value for this editor
	 */
	public abstract Object getValue();

	/**
	 * Initialize binding
	 */

	private void setBinding() {
		binding = getBindingContext().bindValue(widgetObservable, modelProperty, targetToModelStrategy, modelToTargetStrategy);
		binding.getValidationStatus().addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus)binding.getValidationStatus().getValue();
				updateStatus(status);

				if(!isReadOnly()) {
					changeColorField();
				}
			}

		});


	}

	public void updateStatus(IStatus status) {

	}

	/**
	 * Set the target to model Strategy to after get validation
	 *
	 * @param targetToModelValidator
	 */

	public void setTargetAfterGetValidator(AbstractValidator targetToModelValidator) {
		if(targetToModelValidator != null) {
			targetToModelStrategy.setAfterGetValidator(targetToModelValidator);
		}
	}

	/**
	 * Set the model strategy with After get validation
	 * Set the target strategy with before set validation
	 *
	 * @param modelValidator
	 */

	public void setModelValidator(IValidator targetToModelValidator) {
		if(targetToModelValidator != null) {
			this.modelValidator = targetToModelValidator;
			targetToModelStrategy.setBeforeSetValidator(targetToModelValidator);
			modelToTargetStrategy.setAfterGetValidator(targetToModelValidator);

		}
	}

	/**
	 * Initialize both strategies with default values
	 */

	public void setStrategies() {
		if(modelToTargetStrategy == null) {
			modelToTargetStrategy = new UpdateValueStrategy();
		}
		if(targetToModelStrategy == null) {
			targetToModelStrategy = new UpdateValueStrategy();
		}

	}


	@Override
	protected Object getContextElement() {
		// Our observables for features of EMF objects are expected to implement IObserving because
		// the observe the value of the object's feature
		return (modelProperty instanceof IObserving) ? ((IObserving)modelProperty).getObserved() : null;
	}

}
