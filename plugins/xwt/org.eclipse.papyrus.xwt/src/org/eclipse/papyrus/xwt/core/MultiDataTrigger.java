/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.core;

import java.util.HashMap;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.widgets.Widget;

public class MultiDataTrigger extends TriggerBase {

	private Condition[] conditions = Condition.EMPTY_ARRAY;

	private Setter[] setters;

	private ValueChangeListener changeListener;

	public Condition[] getConditions() {
		return conditions;
	}

	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
	}

	public Setter[] getSetters() {
		return setters;
	}

	public void setSetters(Setter[] setters) {
		this.setters = setters;
	}

	class ValueChangeListener extends AbstractChangeListener {

		public ValueChangeListener(Object element) {
			super(element);
		}

		public void handleChange(ChangeEvent event) {
			doHandleChange(true);
		}

		public void doHandleChange(boolean update) {
			for(Condition condition : getConditions()) {
				if(!condition.evaluate(element)) {
					restoreValues();
					return;
				}
			}

			for(SetterBase setter : getSetters()) {
				try {
					Object oldValue = setter.applyTo(element, update);
					if(oldvalues == null) {
						oldvalues = new HashMap<SetterBase, Object>();
					}
					oldvalues.put(setter, oldValue);
				} catch (RuntimeException e) {
					continue;
				}
			}
		}
	}

	@Override
	public void prepare(Object target) {
		if(getConditions().length == 0) {
			return;
		}
		Widget widget = UserData.getWidget(target);
		if(widget == null) {
			return;
		}

		changeListener = new ValueChangeListener(target);
		for(Condition condition : getConditions()) {
			String sourceName = condition.getSourceName();

			IBinding binding = condition.getBinding();
			Object bindingTarget = null;
			if(binding != null) {
				if(binding instanceof IDynamicBinding) {
					IDynamicBinding dynamicBinding = (IDynamicBinding)binding;
					bindingTarget = dynamicBinding.createBoundSource();
				} else {
					bindingTarget = binding.getValue(null);
				}
			} else {
				Object sourceObject = getElementByName(target, sourceName);
				Widget sourceWidget = UserData.getWidget(sourceObject);
				bindingTarget = XWT.getDataContext(sourceWidget);
			}

			if(!(bindingTarget instanceof IObservableValue)) {
				return;
			}
			IObservableValue observableValue = (IObservableValue)bindingTarget;
			observableValue.addChangeListener(changeListener);
		}
		changeListener.doHandleChange(false);
	}

	public void on(Object target) {
		changeListener.doHandleChange(true);
	}
}
