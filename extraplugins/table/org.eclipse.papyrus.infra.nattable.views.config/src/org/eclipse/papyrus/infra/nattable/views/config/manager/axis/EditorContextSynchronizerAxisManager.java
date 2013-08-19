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
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EditorContextSynchronizerAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	/**
	 * we keep it to be able to remove the listener during the destruction of the table
	 */
	private PageList pageList;


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#addContextFeatureValueListener()
	 * 
	 */
	@Override
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification msg) {
				if(msg.getFeature() == DiPackage.eINSTANCE.getPageList_AvailablePage()) {
					featureValueHasChanged(msg);
				}
			}
		};
		getPageList().eAdapters().add(this.featureListener);
	}

	private PageList getPageList() {
		if(this.pageList == null) {
			this.pageList = Utils.getPageList(getTableManager().getTable());
		}
		return this.pageList;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#getFeaturesValue()
	 * 
	 * @return
	 */
	@Override
	protected List<Object> getFeaturesValue() {
		final List<Object> pages = new ArrayList<Object>();
		for(final PageRef current : getPageList().getAvailablePage()) {
			final Object pageIdentifier = current.getPageIdentifier();
			if(pageIdentifier != null) {
				pages.add(pageIdentifier);
			}
		}
		return pages;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#verifyValues()
	 * 
	 */
	@Override
	protected void verifyValues() {
		//nothing to do
	}

	@Override
	protected boolean isAllowed(Object object) {
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
		if(getPageList() != null) {
			getPageList().eAdapters().remove(this.featureListener);
		}
		this.pageList = null;
		super.dispose();
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
			if(isAllowed(newValue)) {
				toAdd.add(newValue);
			}
			break;
		case Notification.ADD_MANY:
			Collection<?> newValues = (Collection<?>)notification.getNewValue();
			for(Object current : newValues) {
				if(current instanceof PageRef) {
					current = ((PageRef)current).getPageIdentifier();
				}
				if(isAllowed(current)) {
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
				newValue = ((PageRef)oldValue).getPageIdentifier();
			}
			if(this.managedObject.contains(oldValue)) {
				toRemove.add(oldValue);
			}
			break;
		case Notification.REMOVE_MANY:
			Collection<?> oldValues = (Collection<?>)notification.getOldValue();
			for(Object current : oldValues) {
				if(current instanceof PageRef) {
					newValue = ((PageRef)current).getPageIdentifier();
				}
				if(this.managedObject.contains(oldValues)) {
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
