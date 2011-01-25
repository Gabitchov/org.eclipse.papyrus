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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EObjectObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * An ObservableList used to edit collections of EObjects through
 * Papyrus commands
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PapyrusObservableList extends EObjectObservableList {

	private EditingDomain domain;

	public PapyrusObservableList(EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(eObject, eStructuralFeature);
		this.domain = domain;
	}

	public PapyrusObservableList(Realm realm, EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(realm, eObject, eStructuralFeature);
		this.domain = domain;
	}

	@Override
	public void add(int index, Object value) {
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				values.add(index, value);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void clear() {
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				SetRequest request = new SetRequest(eObject, eStructuralFeature, Collections.EMPTY_LIST);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public boolean add(Object o) {
		boolean result = false;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.add(o);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public boolean remove(Object o) {
		boolean result = false;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.remove(o);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public boolean addAll(Collection c) {
		boolean result = false;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.addAll(c);

				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		boolean result = false;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.addAll(index, c);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public boolean removeAll(Collection c) {
		boolean result = false;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.removeAll(c);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
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

		boolean result = false;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.removeAll(objectsToRemove);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public Object set(int index, Object element) {
		Object result = null;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.set(index, element);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		Object result = null;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.remove(oldIndex);
				values.add(newIndex, result);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}

	@Override
	public Object remove(int index) {
		Object result = null;
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());
			if(provider != null) {
				List<Object> values = new LinkedList<Object>(this);
				result = values.remove(index);
				SetRequest request = new SetRequest(eObject, eStructuralFeature, values);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return result;
	}
}
