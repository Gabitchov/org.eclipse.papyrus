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
package org.eclipse.papyrus.views.properties.tabbed.customization.state;

import java.beans.PropertyChangeEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.papyrus.views.properties.runtime.controller.BeanPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Composite;


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
	public List<? extends IState> getObjectsToEdit() {
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

			Class<?> currentClass = state.getClass();
			// retrieve method in super classes...
			while(retrieveSuperClass(currentClass) != null) {
				currentClass = retrieveSuperClass(currentClass);
				methods = state.getClass().getDeclaredMethods();
				searchMethodName = "set" + propertyName;
				for(Method method : methods) {
					if(searchMethodName.equalsIgnoreCase(method.getName())) {
						method.setAccessible(true);
						method.invoke(state, value);
						return;
					}
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
			Method[] methods = state.getClass().getDeclaredMethods();
			String searchMethodName = "get" + propertyName;
			for(Method method : methods) {
				if(searchMethodName.equalsIgnoreCase(method.getName())) {
					method.setAccessible(true);
					return method.invoke(state);
				}
			}
			Class<?> currentClass = state.getClass();
			// retrieve method in super classes...
			while(retrieveSuperClass(currentClass) != null) {
				currentClass = retrieveSuperClass(currentClass);
				methods = currentClass.getDeclaredMethods();
				searchMethodName = "get" + propertyName;
				for(Method method : methods) {
					if(searchMethodName.equalsIgnoreCase(method.getName())) {
						method.setAccessible(true);
						return method.invoke(state);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}
		return null;
	}

	protected Class<?> retrieveSuperClass(Class<?> class_) {
		return class_.getSuperclass();
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

	public IUndoableOperation getMoveCurrentValuesOperation(List<Integer> indexes, int move) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canMoveValues(List<Integer> indexes, int move) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<IUndoableOperation> getCreateValueOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canCreateValueOperations() {
		// TODO Auto-generated method stub
		return false;
	}

	public IUndoableOperation getDeleteValueOperation(List<Integer> indexes) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canDeleteValueOperation() {
		// TODO Auto-generated method stub
		return false;
	}

	public IUndoableOperation getEditValueOperation(int index, Composite parent, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canCreateEditOperation(int index, Composite parent, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
