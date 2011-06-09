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
package org.eclipse.papyrus.properties.uml.databinding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.properties.databinding.EMFObservableList;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.widgets.editors.ICommitListener;

/**
 * An ObservableList used to edit collections of EObjects through
 * Papyrus commands
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings("unchecked")
public class PapyrusObservableList extends EMFObservableList implements ICommitListener {

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
	public PapyrusObservableList(List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(wrappedList, domain, source, feature);
	}

	protected IElementEditService getProvider() {
		return ElementEditServiceUtils.getCommandProvider(source);
	}

	protected Command getCommandFromRequest(IElementEditService provider, SetRequest request) {
		ICommand createGMFCommand = provider.getEditCommand(request);

		return new GMFtoEMFCommandWrapper(createGMFCommand);
	}

	@Override
	protected Command getAddCommand(int index, Object value) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.add(index, value);
			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}

		return super.getAddCommand(index, value);
	}

	@Override
	protected Command getAddCommand(Object value) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.add(value);
			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}

		return super.getAddCommand(value);
	}

	@Override
	protected Command getAddAllCommand(Collection<?> values) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> result = new LinkedList<Object>(this);
			result.addAll(values);

			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}

		return super.getAddAllCommand(values);
	}

	@Override
	protected Command getAddAllCommand(int index, Collection<?> values) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> result = new LinkedList<Object>(this);
			result.addAll(index, values);
			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}
		return super.getAddAllCommand(index, values);
	}

	@Override
	protected Command getClearCommand() {
		IElementEditService provider = getProvider();
		if(provider != null) {
			SetRequest request = new SetRequest(source, feature, Collections.EMPTY_LIST);
			return getCommandFromRequest(provider, request);
		}
		return super.getClearCommand();
	}

	@Override
	protected Command getRemoveCommand(int index) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.remove(index);
			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}

		return null;
	}

	@Override
	protected Command getRemoveCommand(Object value) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.remove(value);
			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}

		return super.getRemoveCommand(value);
	}

	@Override
	protected Command getRemoveAllCommand(Collection<?> values) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> result = new LinkedList<Object>(this);
			values.removeAll(values);
			SetRequest request = new SetRequest(source, feature, result);
			return getCommandFromRequest(provider, request);
		}
		return super.getRemoveAllCommand(values);
	}

	@Override
	protected List<Command> getMoveCommands(int oldIndex, int newIndex) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			Object result = values.remove(oldIndex);
			values.add(newIndex, result);
			SetRequest request = new SetRequest(source, feature, values);
			return Collections.singletonList(getCommandFromRequest(provider, request));
		}

		return super.getMoveCommands(oldIndex, newIndex);
	}

	@Override
	protected Command getSetCommand(int index, Object value) {
		IElementEditService provider = getProvider();
		if(provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.set(index, value);
			SetRequest request = new SetRequest(source, feature, values);
			return getCommandFromRequest(provider, request);
		}

		return super.getSetCommand(index, value);
	}
}
