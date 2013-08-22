/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.nattable.command.TableCommands;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;

/**
 * Observable value for the element type id
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractPasteObjectPostActionsObservableValue extends EMFObservableList {

	private Table table;

	private boolean isEditingColumn;

	private EObject editedObject;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 */
	public AbstractPasteObjectPostActionsObservableValue(final EditingDomain domain, final Table table, final boolean isEditingColumn) {
		super(Collections.EMPTY_LIST, domain, table, NattableaxisconfigurationPackage.eINSTANCE.getIPasteConfiguration_PostActions());
		this.table = table;
		this.isEditingColumn = isEditingColumn;
		updateList();
	}

	/**
	 * 
	 */
	protected void updateList() {
		final List<?> list = EMFProperties.list(NattableaxisconfigurationPackage.eINSTANCE.getIPasteConfiguration_PostActions()).observe(getEditedEObject());
		this.wrappedList = new LinkedList<Object>(list);
		this.concreteList = list;
	}


	/**
	 * 
	 * @return
	 *         the table
	 */
	protected Table getTable() {
		return this.table;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.observable.AbstractColumnPasteEObjectConfigurationObservableValue#getEditedEObject()
	 * 
	 * @return
	 */
	protected EObject getEditedEObject() {
		final EObject editedConfiguration = AxisConfigurationUtils.getIAxisConfigurationUsedInTable(getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), isEditingColumn);
		editedObject = editedConfiguration;
		return this.editedObject;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getAddAllCommand(java.util.Collection)
	 * 
	 * @param values
	 * @return
	 */
	@Override
	public Command getAddAllCommand(Collection<?> values) {
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		@SuppressWarnings("unchecked")
		final List<Object> newValues = new ArrayList<Object>(this.wrappedList);
		newValues.addAll(values);

		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		return new GMFtoEMFCommandWrapper(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 * 
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		@SuppressWarnings("unchecked")
		final List<Object> newValues = new ArrayList<Object>(this.wrappedList);
		newValues.addAll(index, values);;

		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		return new GMFtoEMFCommandWrapper(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getAddCommand(int, java.lang.Object)
	 * 
	 * @param index
	 * @param value
	 * @return
	 */
	@Override
	public Command getAddCommand(int index, Object value) {
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}

		@SuppressWarnings("unchecked")
		final List<String> newValues = new ArrayList<String>(this.wrappedList);
		newValues.add((String)value);;

		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		return new GMFtoEMFCommandWrapper(cmd);
	}


	@Override
	public List<Command> getMoveCommands(int oldIndex, int newIndex) {
		List<Command> commands = new LinkedList<Command>();
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		@SuppressWarnings("unchecked")
		final List<String> newValues = new ArrayList<String>(this.wrappedList);
		Object value = get(oldIndex);
		newValues.remove(value);
		newValues.add(newIndex, (String)value);

		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		commands.add(new GMFtoEMFCommandWrapper(cmd));

		return commands;
	}

	@Override
	public Command getRetainAllCommand(Collection<?> values) {
		return super.getRetainAllCommand(values);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getAddCommand(java.lang.Object)
	 * 
	 * @param value
	 * @return
	 */
	@Override
	public Command getAddCommand(Object value) {
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		@SuppressWarnings("unchecked")
		final List<String> newValues = new ArrayList<String>(this.wrappedList);
		newValues.add((String)value);
		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		return new GMFtoEMFCommandWrapper(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getRemoveAllCommand(java.util.Collection)
	 * 
	 * @param values
	 * @return
	 */
	public Command getRemoveAllCommand(Collection<?> values) {
		CompoundCommand cc = new CompoundCommand("Edit list"); //$NON-NLS-1$

		if(feature instanceof EReference && ((EReference)feature).isContainment() && values != null) {
			for(Object o : values) {
				if(o instanceof EObject) {
					addDestroyCommand(cc, (EObject)o);
				}
			}
		}

		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		@SuppressWarnings("unchecked")
		final List<String> newValues = new ArrayList<String>(this.wrappedList);
		newValues.removeAll(values);

		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		return new GMFtoEMFCommandWrapper(cmd);
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getSetCommand(int, java.lang.Object)
	 * 
	 * @param index
	 * @param value
	 * @return
	 */
	@Override
	public Command getSetCommand(int index, Object value) {
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		@SuppressWarnings("unchecked")
		final List<String> newValues = new ArrayList<String>(this.wrappedList);
		newValues.add(index, (String)value);

		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, feature, newValues, isEditingColumn);
		return new GMFtoEMFCommandWrapper(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#getRemoveCommand(java.lang.Object)
	 * 
	 * @param value
	 * @return
	 */
	public Command getRemoveCommand(Object value) {
		PasteEObjectConfiguration editedEObject = (PasteEObjectConfiguration)getEditedEObject();
		if(editedEObject != null && !editingDomain.isReadOnly(editedEObject.eResource())) {
			Command cmd = RemoveCommand.create(editingDomain, editedEObject, feature, value);
			if(value instanceof EObject && feature instanceof EReference && ((EReference)feature).isContainment()) {
				addDestroyCommand(cmd, (EObject)value);
			}
			return cmd;
		}
		return IdentityCommand.INSTANCE;
	}


}
