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
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;
import org.eclipse.papyrus.xwt.internal.core.UpdateSourceTrigger;

public class MultiTrigger extends TriggerBase {

	private Condition[] conditions = Condition.EMPTY_ARRAY;

	private SetterBase[] setters;

	public Condition[] getConditions() {
		return conditions;
	}

	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
	}

	public SetterBase[] getSetters() {
		return setters;
	}

	public void setSetters(SetterBase[] setters) {
		this.setters = setters;
	}

	class ValueChangeListener extends AbstractChangeListener {

		public ValueChangeListener(Object element) {
			super(element);
		}

		public void handleChange(ChangeEvent event) {
			for(Condition condition : getConditions()) {
				if(!condition.evaluate(element)) {
					restoreValues();
					return;
				}
			}

			if(oldvalues != null && !oldvalues.isEmpty()) {
				return;
			}

			for(SetterBase setter : getSetters()) {
				try {
					Object oldValue = setter.applyTo(element, true);
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
	public void on(Object target) {
	}

	@Override
	public void prepare(Object target) {
		if(getConditions().length == 0) {
			return;
		}
		ValueChangeListener changeListener = new ValueChangeListener(target);
		for(Condition condition : getConditions()) {
			String propertyName = condition.getProperty();
			String sourceName = condition.getSourceName();

			Object source = getElementByName(target, sourceName);
			if(source == null) {
				throw new XWTException("No element is found with the name = " + sourceName);
			}
			IObservable observableValue = ScopeManager.observeValue(source, source, propertyName, UpdateSourceTrigger.PropertyChanged);
			observableValue.addChangeListener(changeListener);
		}
	}
}
