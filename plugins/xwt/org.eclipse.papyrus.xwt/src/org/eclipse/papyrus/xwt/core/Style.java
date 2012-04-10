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

/**
 * The class defines the in-line XAML style
 * 
 * @author yyang
 */
public class Style {

	protected Class<?> targetType;

	protected SetterBase[] setters;

	protected TriggerBase[] triggers;

	public TriggerBase[] getTriggers() {
		if(triggers == null) {
			return TriggerBase.EMPTY_ARRAY;
		}
		return triggers;
	}

	public void setTriggers(TriggerBase[] triggers) {
		this.triggers = triggers;
	}

	public Class<?> getTargetType() {
		return targetType;
	}

	public void setTargetType(Class<?> targetType) {
		this.targetType = targetType;
	}

	public SetterBase[] getSetters() {
		if(setters == null) {
			return SetterBase.EMPTY_SETTERS;
		}
		return setters;
	}

	public void setSetters(SetterBase[] setters) {
		this.setters = setters;
	}

	public void apply(Object target) {
		for(SetterBase setter : getSetters()) {
			setter.applyTo(target, true);
		}

		for(TriggerBase triggerBase : getTriggers()) {
			triggerBase.prepare(target);
		}

		for(TriggerBase triggerBase : getTriggers()) {
			triggerBase.on(target);
		}
	}
}
