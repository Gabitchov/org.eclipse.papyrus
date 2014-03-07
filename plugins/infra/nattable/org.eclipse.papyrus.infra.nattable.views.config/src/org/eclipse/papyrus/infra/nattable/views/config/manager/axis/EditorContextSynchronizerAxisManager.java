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
package org.eclipse.papyrus.infra.nattable.views.config.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.emf.adapters.ResourceSetRootsAdapter;
import org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.views.config.Activator;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;

/**
 *
 * @author Vincent Lorenzo
 *
 */
public class EditorContextSynchronizerAxisManager extends AbstractSynchronizedOnEStructuralFeatureAxisManager {

	private IPageManager pageManager;

	private ModelSet modelSet;

	/**
	 *
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager#addContextFeatureValueListener()
	 *
	 */
	@Override
	protected void addContextFeatureValueListener() {
		this.featureListener = new ResourceSetRootsAdapter() {

			@Override
			protected void doNotify(Notification msg) {
				switch(msg.getEventType()) {
				case Notification.ADD:
				case Notification.ADD_MANY:
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					featureValueHasChanged(msg);
				}
			}
		};

		try {
			modelSet = ServiceUtilsForEObject.getInstance().getModelSet(getTableManager().getTable());
			this.featureListener.setTarget(modelSet);
			//modelSet.eAdapters().add(this.featureListener);
		} catch (Exception ex) {
			Activator.log.error("An error occurred when trying to install a listener on the available pages", ex);
		}
	}

	@Override
	protected void removeListeners() {
		if(modelSet != null && featureListener != null) {
			((ResourceSetRootsAdapter)featureListener).unsetTarget(modelSet);
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager#getFeaturesValue()
	 *
	 * @return
	 */
	@Override
	protected List<Object> getFeaturesValue() {
		if(pageManager == null) {
			try {
				pageManager = ServiceUtilsForEObject.getInstance().getIPageManager(getTableManager().getTable());
			} catch (Exception ex) {
				Activator.log.error("The page manager is not accessible", ex);
				return Collections.emptyList();
			}
		}
		return new LinkedList<Object>(pageManager.allPages());
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager#verifyValues()
	 *
	 */
	@Override
	protected void verifyValues() {
		//nothing to do
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#isAllowedContents(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		if(object instanceof PageRef) {
			return mustBeDisplayedInThisTable(((PageRef)object).getPageIdentifier());
		}
		return mustBeDisplayedInThisTable(object);
	}

	/**
	 *
	 * @param page
	 *        a page
	 * @return
	 *         <code>true</code> if the page is referenced by a child of the context of the table or by the context itself
	 */
	private boolean mustBeDisplayedInThisTable(final Object page) {
		final Object value = Utils.getEditorContext(page);
		if(value instanceof EObject) {
			final EObject tableContext = getTableContext();
			EObject container = (EObject)value;
			while(container != null) {
				if(container == tableContext) {
					return true;
				}
				container = container.eContainer();
			}
		}
		return false;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#dispose()
	 *
	 */
	@Override
	public void dispose() {
		this.pageManager = null;
		super.dispose();
		this.modelSet = null;
		this.featureListener = null;
	}


	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canEditAxisHeader()
	 *
	 * @return
	 */
	@Override
	public boolean canEditAxisHeader() {
		return false;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(java.lang.Integer)
	 *
	 * @param axisPosition
	 * @return
	 */
	@Override
	public boolean canDestroyAxisElement(Integer axisPosition) {
		return false;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(TransactionalEditingDomain, java.lang.Integer)
	 *
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	@Override
	public Command getDestroyAxisElementCommand(TransactionalEditingDomain domain, Integer axisPosition) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 *
	 * @param notification
	 *        update the list of the managed objects if its required
	 */
	@Override
	protected void featureValueHasChanged(final Notification notification) {
		if(notification.isTouch()) {
			return;
		}

		int eventType = notification.getEventType();
		List<Object> toAdd = new ArrayList<Object>();
		List<Object> toRemove = new ArrayList<Object>();
		switch(eventType) {
		case Notification.REMOVING_ADAPTER:
			break;//nothing to do
		case Notification.ADD:
			Object newValue = notification.getNewValue();
			if(newValue instanceof PageRef) {
				newValue = ((PageRef)newValue).getPageIdentifier();
			}
			if(isAllowedContents(newValue)) {
				toAdd.add(newValue);
			}
			break;
		case Notification.ADD_MANY:
			Collection<?> newValues = (Collection<?>)notification.getNewValue();
			for(Object current : newValues) {
				if(current instanceof PageRef) {
					current = ((PageRef)current).getPageIdentifier();
				}
				if(isAllowedContents(current)) {
					toAdd.add(current);
				}
			}
			break;
		case Notification.EVENT_TYPE_COUNT:
			break;
		case Notification.MOVE:
			//we ignore it
			break;
		case Notification.REMOVE:
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof PageRef) {
				oldValue = ((PageRef)oldValue).getPageIdentifier();
			}
			if(this.managedObject.contains(oldValue)) {
				toRemove.add(oldValue);
			}
			break;
		case Notification.REMOVE_MANY:
			Collection<?> oldValues = (Collection<?>)notification.getOldValue();
			for(Object current : oldValues) {
				if(current instanceof PageRef) {
					current = ((PageRef)current).getPageIdentifier();
				}
				if(this.managedObject.contains(current)) {
					toRemove.add(current);
				}
			}
			break;
		case Notification.RESOLVE:
		case Notification.SET:
		case Notification.UNSET:
			//case Notification.NO_FEATURE_ID:
			//case Notification.NO_INDEX:

		default:
			break;
		}
		if(toAdd.size() > 0 || toRemove.size() > 0) {
			updateManagedList(toAdd, toRemove);
		}
	}

}
