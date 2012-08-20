/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.table.efacet.common.factory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.browser.custom.AttributeView;
import org.eclipse.emf.facet.infra.browser.custom.CustomViewFeature;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.ReferenceView;
import org.eclipse.emf.facet.infra.browser.custom.StaticFeatureValue;
import org.eclipse.emf.facet.infra.browser.custom.TypeView;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Row;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.internal.painter.Customization;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;

/**
 * 
 * This factory is used by the Papyrus Table when the editing domain is an instanceof TransactionalEditingDomain
 * 
 */
@SuppressWarnings("restriction")
public class PapyrusCommandFactory extends DefaultCommandFactory {

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#handles(org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean handles(final EditingDomain editingDomain) {
		return editingDomain instanceof TransactionalEditingDomain;
	}

	/**
	 * 
	 * @param owner
	 *        the owner object
	 * @param feature
	 *        the feature to edit
	 * @return <code>true</code> if object is an {@link EObject} and feature a {@link EStructuralFeature}
	 */
	protected boolean testArgs(final Object owner, final Object feature) {
		if(feature != null) {
			if(feature instanceof EStructuralFeature) {
				/*
				 * The ElementEditService can be used for UML Element and for view and for... others things,
				 * but it doesn't work correctly with the nattable widget elements
				 */
				if(isEMFFacetElement(owner)) {
					return false;
				} else if(owner instanceof EObject) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * The ElementEditService can be used for UML Element and for view and for... others things, but it doesn't work correctly with the nattable
	 * widget
	 * elements
	 * 
	 * @param owner
	 *        an object
	 * @return
	 *         <code>true</code> if the object is an EMF-Facet object
	 */
	private boolean isEMFFacetElement(final Object owner) {
		if(owner instanceof TableInstance) {
			return true;
		} else if(owner instanceof MetamodelView) {
			return true;
		} else if(owner instanceof Row) {
			return true;
		} else if(owner instanceof Column) {
			return true;
		} else if(owner instanceof Facet) {
			return true;
		} else if(owner instanceof Customization) {
			return true;
		} else if(owner instanceof TypeView) {
			return true;
		} else if(owner instanceof ReferenceView) {
			return true;
		} else if(owner instanceof AttributeView) {
			return true;
		} else if(owner instanceof CustomViewFeature) {
			return true;
		} else if(owner instanceof StaticFeatureValue) {
			return true;
		}
		//we add this test,because, it is possible that we forget some emf-facet elements
		String className = owner.getClass().getCanonicalName();
		if(className.contains("org.eclipse.emf.facet")) { //$NON-NLS-1$
			String message = "the type " + className + " should be included in the test"; //$NON-NLS-1$ //$NON-NLS-2$
			Activator.getDefault().log.info(message);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Command createAddCommand(final EditingDomain editingDomain, final Object owner, final Object feature, final Object value) {
		//the ElementEditService doesn't work correctly with nattable elements, so we test the edited element
		if(isEMFFacetElement(owner)) {
			return super.createAddCommand(editingDomain, owner, feature, value);
		}
		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(owner);
		if(testArgs(owner, feature) && elementEditService != null) {
			EObject current = (EObject)owner;
			Object values = current.eGet((EStructuralFeature)feature);
			if(values instanceof List<?>) {
				ArrayList<Object> newList = new ArrayList<Object>();
				newList.addAll((List<?>)values);
				newList.add(value);
				SetRequest request = new SetRequest((TransactionalEditingDomain)editingDomain, current, (EStructuralFeature)feature, newList);
				ICommand command = elementEditService.getEditCommand(request);
				if(command.canExecute()) {
					return new GMFtoEMFCommandWrapper(command);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#createDeleteCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Command createDeleteCommand(final EditingDomain editingDomain, final Object elementToDestroy) {
		//the ElementEditService doesn't work correctly with nattable elements, so we test the edited element
		if(isEMFFacetElement(elementToDestroy)) {
			return super.createDeleteCommand(editingDomain, elementToDestroy);
		}
		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(elementToDestroy);
		if(testArgs(elementToDestroy, null) && elementEditService != null) {
			DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)editingDomain, (EObject)elementToDestroy, false);
			ICommand command = elementEditService.getEditCommand(request);
			if(command.canExecute()) {
				return new GMFtoEMFCommandWrapper(command);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#createMoveCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, int)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Command createMoveCommand(final EditingDomain editingDomain, final Object owner, final Object feature, final Object value, final int index) {
		//the ElementEditService doesn't work correctly with nattable elements, so we test the edited element
		if(isEMFFacetElement(owner)) {
			return super.createMoveCommand(editingDomain, owner, feature, value, index);
		}

		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(owner);
		if(testArgs(owner, feature) && elementEditService != null) {
			EObject current = (EObject)owner;
			Object values = current.eGet((EStructuralFeature)feature);
			if(values instanceof List<?>) {
				ArrayList<Object> newList = new ArrayList<Object>();
				newList.addAll((List<?>)values);
				int currentIndex = ((List<?>)values).indexOf(value);
				newList.remove(currentIndex);
				newList.add(index, value);
				SetRequest request = new SetRequest((TransactionalEditingDomain)editingDomain, (EObject)owner, (EStructuralFeature)feature, newList);
				ICommand command = elementEditService.getEditCommand(request);
				if(command.canExecute()) {
					return new GMFtoEMFCommandWrapper(command);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#createRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Command createRemoveCommand(final EditingDomain editingDomain, final Object owner, final Object feature, final Object value) {
		//the ElementEditService doesn't work correctly with nattable elements, so we test the edited element
		if(isEMFFacetElement(owner)) {
			return super.createRemoveCommand(editingDomain, owner, feature, value);
		}
		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(owner);
		if(testArgs(owner, feature) && elementEditService != null) {
			DestroyReferenceRequest request = new DestroyReferenceRequest((TransactionalEditingDomain)editingDomain, (EObject)owner, (EReference)feature, (EObject)value, false);
			ICommand command = elementEditService.getEditCommand(request);
			if(command.canExecute()) {
				return new GMFtoEMFCommandWrapper(command);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Command createSetCommand(final EditingDomain editingDomain, final Object owner, final Object feature, final Object value) {
		//the ElementEditService doesn't work correctly with nattable elements, so we test the edited element
		if(isEMFFacetElement(owner)) {
			return super.createSetCommand(editingDomain, owner, feature, value);
		}
		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(owner);
		if(testArgs(owner, feature) && elementEditService != null) {
			SetRequest request = new SetRequest((TransactionalEditingDomain)editingDomain, (EObject)owner, (EStructuralFeature)feature, value);
			ICommand command = elementEditService.getEditCommand(request);
			if(command.canExecute()) {
				return new GMFtoEMFCommandWrapper(command);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.DefaultCommandFactory#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, int)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Command createSetCommand(final EditingDomain editingDomain, final Object owner, final Object feature, final Object value, final int index) {
		//the ElementEditService doesn't work correctly with nattable elements, so we test the edited element
		if(isEMFFacetElement(owner)) {
			return super.createSetCommand(null, owner, feature, value, index);
		}
		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(owner);
		if(testArgs(owner, feature) && elementEditService != null) {
			EObject current = (EObject)owner;
			Object values = current.eGet((EStructuralFeature)feature);
			if(values instanceof List<?>) {
				ArrayList<Object> newList = new ArrayList<Object>();
				newList.addAll((List<?>)values);
				newList.set(index, value);
				SetRequest request = new SetRequest((TransactionalEditingDomain)editingDomain, (EObject)owner, (EStructuralFeature)feature, newList);
				ICommand command = elementEditService.getEditCommand(request);
				if(command.canExecute()) {
					return new GMFtoEMFCommandWrapper(command);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}
