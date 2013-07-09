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
package org.eclipse.papyrus.infra.emf.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;

/**
 * An ObservableList using EMF Commands to edit the underlying list.
 * The commands are executed when the {@link #commit(AbstractEditor)} method is called.
 * However, the read operations (such as get, size, ...) return up-to-date
 * results, even when {@link #commit(AbstractEditor)} hasn't been called.
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EMFObservableList extends ObservableList implements ICommitListener {

	/**
	 * The list of commands that haven't been executed yet
	 */
	protected List<Command> commands = new LinkedList<Command>();

	/**
	 * The editing domain on which the commands will be executed
	 */
	protected EditingDomain editingDomain;

	/**
	 * The edited EObject
	 */
	protected EObject source;

	/**
	 * The feature being edited
	 */
	protected EStructuralFeature feature;

	/**
	 * The list to be updated only on #commit() calls
	 */
	protected List<?> concreteList;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param wrappedList
	 *        The list to be edited when #commit() is called
	 * @param domain
	 *        The editing domain on which the commands will be executed
	 * @param source
	 *        The EObject from which the list will be retrieved
	 * @param feature
	 *        The feature from which the list will be retrieved
	 */
	public EMFObservableList(List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(new LinkedList<Object>(wrappedList), Object.class);
		this.concreteList = wrappedList;
		this.editingDomain = domain;
		this.source = source;
		this.feature = feature;
	}

	/**
	 * Forces this list to commit all the pending commands. Only one composite command will
	 * be executed, and can be undone in a single operation.
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.ICommitListener#commit(AbstractEditor)
	 * 
	 */
	public void commit(AbstractEditor editor) {

		if(commands.isEmpty()) {
			return;
		}

		CompoundCommand compoundCommand = new CompoundCommand() {

			@Override
			public void execute() {
				super.execute();
				refreshCacheList();
			}

			@Override
			public void undo() {
				super.undo();
				refreshCacheList();
			}

			@Override
			public void redo() {
				super.redo();
				refreshCacheList();
			}

			@Override
			protected boolean prepare() {
				if(commandList.isEmpty()) {
					return false;
				} else {
					//We only test the first command, as the following ones might depend
					//on the first command's execution. StrictCompoundCommands don't seem
					//to be compatible with emf transaction (execute() is called by 
					//canExecute(), before the transaction is started)
					return commandList.get(0).canExecute();
				}
			}
		};

		for(Command cmd : commands) {
			compoundCommand.append(cmd);
		}

		editingDomain.getCommandStack().execute(compoundCommand);
		refreshCacheList();
		commands.clear();
	}

	/**
	 * Refresh the cached list by copying the real list
	 */
	protected void refreshCacheList() {
		if(isDisposed()) {
			//This observable can be disposed, but the commands might still be
			//in the command stack. Undo() or Redo() will call this method, which
			//should be ignored. The command should probably not call refresh directly ;
			//we should have listeners on the concrete list... but it is not necessarily
			//observable
			return;
		}
		wrappedList.clear();
		wrappedList.addAll(concreteList);
		fireListChange(null);
	}

	@Override
	public void add(int index, Object value) {
		Command command = getAddCommand(index, value);
		commands.add(command);

		wrappedList.add(index, value);
		fireListChange(null);
	}

	@Override
	public void clear() {
		Command command = getClearCommand();
		commands.add(command);

		wrappedList.clear();
		fireListChange(null);
	}

	@Override
	public boolean add(Object o) {
		Command command = getAddCommand(o);
		commands.add(command);

		boolean result = wrappedList.add(o);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean remove(Object o) {
		Command command = getRemoveCommand(o);

		commands.add(command);

		boolean result = wrappedList.remove(o);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean addAll(Collection c) {
		Command command = getAddAllCommand(c);
		commands.add(command);

		boolean result = wrappedList.addAll(c);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		Command command = getAddAllCommand(index, c);
		commands.add(command);

		boolean result = wrappedList.addAll(index, c);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean removeAll(Collection c) {
		Command command = getRemoveCommand(c);
		commands.add(command);

		boolean result = wrappedList.removeAll(c);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean retainAll(Collection c) {
		Command command = getRetainAllCommand(c);
		commands.add(command);

		boolean result = wrappedList.retainAll(c);
		fireListChange(null);
		return result;
	}

	@Override
	public Object set(int index, Object element) {
		Command command = getSetCommand(index, element);
		commands.add(command);

		Object result = wrappedList.set(index, element);
		fireListChange(null);
		return result;
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		commands.addAll(getMoveCommands(oldIndex, newIndex));

		Object value = get(oldIndex);
		wrappedList.remove(oldIndex);
		wrappedList.add(newIndex, value);

		fireListChange(null);

		return value;
	}

	@Override
	public Object remove(int index) {
		Object value = get(index);
		if(value != null) {
			Command command = getRemoveCommand(index);
			commands.add(command);
		}

		Object result = wrappedList.remove(index);
		fireListChange(null);
		return result;
	}

	public Command getAddCommand(int index, Object value) {
		return AddCommand.create(editingDomain, source, feature, value, index);
	}

	public Command getAddCommand(Object value) {
		return AddCommand.create(editingDomain, source, feature, value);
	}

	public Command getAddAllCommand(Collection<?> values) {
		return AddCommand.create(editingDomain, source, feature, values);
	}

	public Command getAddAllCommand(int index, Collection<?> values) {
		return AddCommand.create(editingDomain, source, feature, values, index);
	}

	public Command getClearCommand() {
		return getRemoveAllCommand(new LinkedList<Object>(wrappedList));
	}

	public Command getRemoveCommand(int index) {
		Object value = get(index);
		return getRemoveCommand(value);
	}

	public Command getRemoveCommand(Object value) {
		Command cmd = RemoveCommand.create(editingDomain, source, feature, value);
		if (value instanceof EObject && feature instanceof EReference && ((EReference)feature).isContainment()) {
			addDestroyCommand(cmd, (EObject)value);
		}
		return cmd;
	}

	public Command getRemoveAllCommand(Collection<?> values) {
		CompoundCommand cc = new CompoundCommand("Edit list");

		if (feature instanceof EReference && ((EReference)feature).isContainment() && values != null) {
			for (Object o : values) {
				if (o instanceof EObject) {
					addDestroyCommand(cc, (EObject)o);
				}
			}
		}

		cc.append(RemoveCommand.create(editingDomain, source, feature, values));
		return cc;
	}

	public List<Command> getMoveCommands(int oldIndex, int newIndex) {
		Object value = get(oldIndex);
		List<Command> commands = new LinkedList<Command>();
		commands.add(getRemoveCommand(value));
		commands.add(getAddCommand(newIndex, value));
		return commands;
	}

	public Command getRetainAllCommand(Collection<?> values) {
		List<Object> objectsToRemove = new LinkedList<Object>();
		for(Object object : values) {
			if(!contains(object)) {
				objectsToRemove.add(object);
			}
		}
		if(!objectsToRemove.isEmpty()) {
			return getRemoveAllCommand(objectsToRemove);
		} else {
			return null;
		}
	}

	public Command getSetCommand(int index, Object value) {
		Object oldValue = get(index);
		Command command = SetCommand.create(editingDomain, source, feature, value, index);
		if (oldValue instanceof EObject && feature instanceof EReference && ((EReference)feature).isContainment()) {
			addDestroyCommand(command, (EObject)oldValue);
		}
		return command;
	}
	
	protected void addDestroyCommand(Command cmd, EObject objToDestroy) {
		Command destroyCmd = DeleteCommand.create(editingDomain, objToDestroy);

		if (cmd instanceof CompoundCommand) {
			((CompoundCommand)cmd).append(destroyCmd);
		} else {
			cmd.chain(destroyCmd);
		}
	}

}
