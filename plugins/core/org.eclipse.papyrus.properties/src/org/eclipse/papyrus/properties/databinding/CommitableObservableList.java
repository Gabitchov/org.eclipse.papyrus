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
package org.eclipse.papyrus.properties.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.widgets.editors.ICommitListener;

/**
 * @author Camille Letavernier
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommitableObservableList extends ObservableList implements ICommitListener {

	protected List<Command> commands = new LinkedList<Command>();

	protected EditingDomain editingDomain;

	protected EObject source;

	protected EStructuralFeature feature;

	protected List<?> concreteList;

	public CommitableObservableList(List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(new LinkedList<Object>(wrappedList), Object.class);
		this.concreteList = wrappedList;
		this.editingDomain = domain;
		this.source = source;
		this.feature = feature;
	}

	public void commit() {

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

			/**
			 * We have a sequential execution : the method canExecute() in
			 * the command n+1 depends on the result of the command n. We can't
			 * check every command's canExecute() method here, so we only
			 * check the first one.
			 * 
			 */
			@Override
			public boolean canExecute() {
				return commandList.isEmpty() ? false : commandList.get(0).canExecute();
			}

			//TODO : edit the execute() method to call the remaining canExecute() checks
			//during the execution
			//(n).canExecute()
			//(n).execute()
			//(n+1).canExecute()
			//(n+1).execute()
		};

		for(Command cmd : commands) {
			compoundCommand.append(cmd);
		}

		editingDomain.getCommandStack().execute(compoundCommand);
		commands.clear();
	}

	@Override
	protected void fireListChange(ListDiff diff) {
		super.fireListChange(diff);
	}

	protected void refreshCacheList() {
		wrappedList.clear();
		wrappedList.addAll(concreteList);
		fireListChange(null);
	}

	public void commit(AbstractEditor editor) {
		commit();
	}

	@Override
	public void add(int index, Object value) {
		Command command = AddCommand.create(editingDomain, source, feature, value, index);
		commands.add(command);

		wrappedList.add(index, value);
		fireListChange(null);
	}

	@Override
	public void clear() {
		Command command = RemoveCommand.create(editingDomain, source, feature, new LinkedList<Object>(wrappedList));
		commands.add(command);

		wrappedList.clear();
		fireListChange(null);
	}

	@Override
	public boolean add(Object o) {
		Command command = AddCommand.create(editingDomain, source, feature, o);
		commands.add(command);

		boolean result = wrappedList.add(o);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean remove(Object o) {
		Command command = RemoveCommand.create(editingDomain, source, feature, o);

		commands.add(command);

		boolean result = wrappedList.remove(o);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean addAll(Collection c) {
		Command command = AddCommand.create(editingDomain, source, feature, c);
		commands.add(command);

		boolean result = wrappedList.addAll(c);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		Command command = AddCommand.create(editingDomain, source, feature, c, index);
		commands.add(command);

		boolean result = wrappedList.addAll(index, c);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean removeAll(Collection c) {
		Command command = RemoveCommand.create(editingDomain, source, feature, c);
		commands.add(command);

		boolean result = wrappedList.removeAll(c);
		fireListChange(null);
		return result;
	}

	@Override
	public boolean retainAll(Collection c) {
		List<Object> objectsToRemove = new LinkedList<Object>();
		for(Object object : c) {
			if(!contains(object)) {
				objectsToRemove.add(object);
			}
		}
		if(!objectsToRemove.isEmpty()) {
			Command command = RemoveCommand.create(editingDomain, source, feature, objectsToRemove);
			commands.add(command);

		}

		boolean result = wrappedList.retainAll(c);
		fireListChange(null);
		return result;
	}

	@Override
	public Object set(int index, Object element) {
		Command command = SetCommand.create(editingDomain, source, feature, element, index);
		commands.add(command);

		Object result = wrappedList.set(index, element);
		fireListChange(null);
		return result;
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		Object value = get(oldIndex);
		if(value != null) {
			Command remove = RemoveCommand.create(editingDomain, source, feature, value);
			Command add = AddCommand.create(editingDomain, source, feature, value, newIndex);
			commands.add(remove);
			commands.add(add);

			wrappedList.remove(oldIndex);
			wrappedList.add(newIndex, value);

			fireListChange(null);
		}

		return value;
	}

	@Override
	public Object remove(int index) {
		Object value = get(index);
		if(value != null) {
			Command command = RemoveCommand.create(editingDomain, source, feature, value);
			commands.add(command);
		}

		Object result = wrappedList.remove(index);
		fireListChange(null);
		return result;
	}

}
