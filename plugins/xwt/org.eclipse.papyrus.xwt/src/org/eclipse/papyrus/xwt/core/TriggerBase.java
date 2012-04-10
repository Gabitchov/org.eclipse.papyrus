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

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.widgets.Widget;

public abstract class TriggerBase {

	public final static TriggerBase[] EMPTY_ARRAY = new TriggerBase[0];

	protected TriggerAction[] entryActions;

	protected TriggerAction[] exitActions;

	public TriggerAction[] getEntryActions() {
		if(entryActions == null) {
			return TriggerAction.EMPTY_ARRAY;
		}
		return entryActions;
	}

	public void setEntryActions(TriggerAction[] entryActions) {
		this.entryActions = entryActions;
	}

	public TriggerAction[] getExitActions() {
		if(exitActions == null) {
			return TriggerAction.EMPTY_ARRAY;
		}
		return exitActions;
	}

	public void setExitActions(TriggerAction[] exitActions) {
		this.exitActions = exitActions;
	}

	public abstract void on(Object target);

	public abstract void prepare(Object target);

	abstract class AbstractChangeListener implements IChangeListener {

		protected HashMap<SetterBase, Object> oldvalues = null;

		protected Object element;

		public AbstractChangeListener(Object element) {
			this.element = element;
		}

		protected void restoreValues() {
			if(oldvalues == null) {
				return;
			}
			for(SetterBase setter : oldvalues.keySet()) {
				setter.undo(element, oldvalues.get(setter));
			}
		}
	}

	public static Object getElementByName(Object target, String elementName) {
		if(elementName != null && elementName.length() > 0) {
			Widget widget = UserData.getWidget(target);
			if(widget != null) {
				Object element = XWT.findElementByName(widget, elementName);
				if(element != null) {
					return element;
				}
				LoggerManager.log("EventTrigger: Source \n" + elementName + "\n is not found in " + target.getClass().getName());
			}
		}
		return target;
	}

}
