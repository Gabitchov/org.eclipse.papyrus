/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.state;

import java.beans.PropertyChangeEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.controller.BeanPropertyEditorController;
import org.eclipse.papyrus.properties.runtime.state.IState;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;


/**
 * Controller for states for customization wizard
 */
public class StateBeanPropertyEditorController extends BeanPropertyEditorController {

	/** identifier for this controller */
	public final static String ID = "stateBeanPropertyEditorController";

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<? extends IState> getObjectsToEdit() {
		return (List<? extends IState>)super.getObjectsToEdit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultLabel() {
		return getDescriptor().getPropertyName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueInModel(Object value) {
		IState state = getObjectsToEdit().get(0);
		String propertyName = getDescriptor().getPropertyName();
		try {
			Method[] methods = state.getClass().getDeclaredMethods();
			String searchMethodName = "set" + propertyName;
			for(Method method : methods) {
				if(searchMethodName.equalsIgnoreCase(method.getName())) {
					method.setAccessible(true);
					method.invoke(state, value);
					return;
				}
			}
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getValueToEdit() {
		IState state = getObjectsToEdit().get(0);
		String propertyName = getDescriptor().getPropertyName();
		try {
			Field field = state.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			return field.get(state);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (NoSuchFieldException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addListenersToModel() {
		for(IState state : getObjectsToEdit()) {
			state.addPropertyChangeListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeListenersFromModel() {
		for(IState state : getObjectsToEdit()) {
			state.removePropertyChangeListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals(getDescriptor().getPropertyName())) {
			refreshDisplay();
		}
	}
}
