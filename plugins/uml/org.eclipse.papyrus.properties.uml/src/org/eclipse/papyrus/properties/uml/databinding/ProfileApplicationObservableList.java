/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.uml.databinding.command.ApplyProfileCommand;
import org.eclipse.papyrus.properties.uml.databinding.command.UnapplyProfileCommand;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProfileApplicationObservableList extends WritableList implements ICommitListener {

	private Package umlSource;

	private EditingDomain domain;

	private final List<Command> commands;

	public ProfileApplicationObservableList(Package umlSource, EditingDomain domain) {
		super(new LinkedList<Object>(umlSource.getAllAppliedProfiles()), Profile.class);
		this.umlSource = umlSource;
		this.domain = domain;
		commands = new LinkedList<Command>();
	}

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

		domain.getCommandStack().execute(compoundCommand);
		commands.clear();
	}

	private void refreshCacheList() {
		wrappedList.clear();
		wrappedList.addAll(umlSource.getAllAppliedProfiles());
		fireListChange(null);
	}

	@Override
	public void clear() {
		removeAll(new LinkedList<Object>(wrappedList));
	}

	@Override
	public boolean add(Object o) {
		if(!(o instanceof Profile)) {
			return false;
		}

		Profile profile = (Profile)o;
		Command command = new ApplyProfileCommand(umlSource, profile);

		commands.add(command);

		return wrappedList.add(o);
	}

	@Override
	public boolean remove(Object o) {

		if(!(o instanceof Profile)) {
			return false;
		}

		final Profile profile = (Profile)o;
		Command command = new UnapplyProfileCommand(umlSource, profile);

		commands.add(command);

		return wrappedList.remove(o);
	}

	@Override
	public boolean addAll(Collection c) {
		//We only apply the profiles that are not applied yet (To avoid removing them when undo is called)
		c.removeAll(wrappedList);

		Command command = new ApplyProfileCommand(umlSource, c);

		commands.add(command);

		return wrappedList.addAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		Command command = new UnapplyProfileCommand(umlSource, c);

		commands.add(command);

		return wrappedList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c) {
		List<Object> objectsToRemove = new LinkedList<Object>();
		for(Object object : c) {
			if(!contains(object)) {
				objectsToRemove.add(object);
			}
		}
		return removeAll(objectsToRemove);
	}


	//Unsupported operations. Some of them have a "proxy" implementation
	@Override
	public void add(int index, Object value) {
		add(value); //The list is not ordered
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return addAll(c); //The list is not ordered
	}

	@Override
	public Object set(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

}
