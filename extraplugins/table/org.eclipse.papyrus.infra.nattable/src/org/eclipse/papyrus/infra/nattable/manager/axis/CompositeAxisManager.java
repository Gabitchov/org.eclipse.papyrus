/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.utils.AxisComparator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.providers.CompoundFilteredRestrictedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;

/**
 * This axis manager allows to encapsulated others axis manager. It allows to manage the contents of the table.
 * When this contents is stored in the table metamodel, It is able to manage the Add/Remove and Move elements in the list of the displayed elements
 * 
 * @author VL222926
 * 
 */
public class CompositeAxisManager extends AbstractAxisManager implements ICompositeAxisManager {

	/**
	 * the id of this manager
	 */
	@SuppressWarnings("unused")
	private static final String MANAGER_ID = "org.eclipse.papyrus.infra.nattable.composite.axis.manager"; //$NON-NLS-1$

	/**
	 * the sub managers
	 */
	protected List<IAxisManager> subManagers;

	/**
	 * the comparator used to sort the axis
	 */
	protected Comparator<Object> axisComparator;

	/**
	 * 
	 * @param notification
	 *        the notification
	 */
	protected void axisManagerHasChanged(final Notification notification) {
		if(notification.isTouch()) {
			return;
		}
		final List<Object> newListValue = new ArrayList<Object>(this.managedObject);
		boolean needRefresh = false;
		int eventType = notification.getEventType();
		switch(eventType) {
		case Notification.ADD:
			final Object addedValue = notification.getNewValue();
			final int index = notification.getPosition();

			newListValue.add(index, addedValue);
			needRefresh = true;
			break;
		case Notification.ADD_MANY:
			final Collection<?> addedValues = (Collection<?>)notification.getNewValue();
			//			final int lisIndex = notification.getPosition();
			newListValue.addAll(addedValues);
			needRefresh = true;
			break;
		case Notification.EVENT_TYPE_COUNT:
			break;
		case Notification.MOVE:
			final Object movedObject = notification.getNewValue();
			final int newPos = notification.getPosition();
			newListValue.remove(movedObject);
			newListValue.add(newPos, movedObject);
			needRefresh = true;
			break;
		case Notification.REMOVE:
			final Object removedObject = notification.getOldValue();
			newListValue.remove(removedObject);
			needRefresh = true;
			break;
		case Notification.REMOVE_MANY:
			final Collection<?> removedValues = (Collection<?>)notification.getOldValue();
			newListValue.removeAll(removedValues);
			needRefresh = true;
			break;
		case Notification.REMOVING_ADAPTER:
			break;
		case Notification.RESOLVE:
			break;
		case Notification.SET:
			break;
		case Notification.UNSET:
			break;
		//		case Notification.NO_FEATURE_ID:
		//			break;
		//		case Notification.NO_INDEX:
		//			break;
		default:
			break;
		}
		if(needRefresh) {
			this.managedObject.clear();
			this.managedObject.addAll(newListValue);
			newListValue.clear();
			getTableManager().updateAxisContents(getRepresentedContentProvider());
		}

	}


	/**
	 * Initialize the list of the managed elements which are owned by the model
	 */
	protected void initializeManagedObjectList() {
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			this.managedObject.add(current);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager#setSubAxisManager(java.util.List)
	 * 
	 * @param managers
	 */
	public void setSubAxisManager(final List<IAxisManager> managers) {
		this.subManagers = managers;
		updateAxisContents();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		for(final IAxisManager current : this.subManagers) {
			current.dispose();
		}
		this.subManagers.clear();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canBeUsedAsRowManager()
	 * 
	 * @return
	 */
	@Override
	public boolean canBeUsedAsRowManager() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.subManagers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedAsRowManager();
		}
		return answer;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canBeUsedAsColumnManager()
	 * 
	 * @return
	 */
	@Override
	public boolean canBeUsedAsColumnManager() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.subManagers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedAsColumnManager();
		}
		return answer;
	}

	@Override
	public boolean canCreateAxisElement(String elementId) {
		boolean canCreateAxisElement = false;
		for(IAxisManager manager : subManagers) {
			canCreateAxisElement |= manager.canCreateAxisElement(elementId);
		}
		return canCreateAxisElement;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAddAxisCommand(TransactionalEditingDomain, java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand(Messages.CompositeAxisManager_AddAxisCommand);
		for(final IAxisManager current : this.subManagers) {
			final Command tmp = current.getAddAxisCommand(domain, objectToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getComplementaryAddAxisCommand(TransactionalEditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand(Messages.CompositeAxisManager_AddAxisCommand);
		for(final IAxisManager current : this.subManagers) {
			final Command tmp = current.getComplementaryAddAxisCommand(domain, objectToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager#updateAxisContents()
	 * 
	 */
	public synchronized void updateAxisContents() {
		final List<Object> displayedElement = getElements();
		synchronized(displayedElement) {
			displayedElement.clear();
			displayedElement.addAll(this.managedObject);
			if(this.subManagers != null) {
				for(final IAxisManager current : this.subManagers) {
					if(current.isDynamic()) {
						displayedElement.addAll(current.getAllManagedAxis());
					}
				}
			}
			if(this.axisComparator != null) {
				Collections.sort(displayedElement, this.axisComparator);
			} else {

			}
		}
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
		for(final IAxisManager current : this.subManagers) {
			if(current.isAllowedContents(object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canMoveAxis()
	 * 
	 * @return
	 */
	@Override
	public boolean canMoveAxis() {
		for(final IAxisManager current : this.subManagers) {
			if(!current.canMoveAxis() || current.isDynamic()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#sortAxisByName(boolean,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param inverted
	 * @param configRegistry
	 */
	public void sortAxisByName(boolean alphabeticOrder, final IConfigRegistry configRegistry) {
		if(canMoveAxis()) {
			final List<IAxis> axis = new ArrayList<IAxis>(getRepresentedContentProvider().getAxis());
			Collections.sort(axis, new AxisComparator(alphabeticOrder, configRegistry));
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getRepresentedContentProvider());
			final AbstractEditCommandRequest request = new SetRequest(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), axis);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getRepresentedContentProvider());
			final ICommand cmd = provider.getEditCommand(request);
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		}
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#createPossibleAxisContentProvider(boolean)
	 * 
	 * @param isRestricted
	 * @return a contents provider for this axis or <code>null</code> if it is not allowed
	 */
	@Override
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted) {

		CompoundFilteredRestrictedContentProvider compoundContentProvider = null;
		for(final IAxisManager current : this.subManagers) {
			IRestrictedContentProvider contentProvider = current.createPossibleAxisContentProvider(isRestricted);
			if(contentProvider != null) {
				if(compoundContentProvider == null) {
					compoundContentProvider = new CompoundFilteredRestrictedContentProvider();
				}
				compoundContentProvider.add(contentProvider);
			}
		}
		return compoundContentProvider;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getDestroyAxisCommand(TransactionalEditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToDestroy
	 * @return
	 */
	@Override
	public Command getDestroyAxisCommand(TransactionalEditingDomain domain, Collection<Object> objectToDestroy) {
		final CompoundCommand cmd = new CompoundCommand(Messages.CompositeAxisManager_DestroyAxisCommand);
		for(final IAxisManager current : this.subManagers) {
			final Command tmp = current.getDestroyAxisCommand(domain, objectToDestroy);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	@Override
	public Collection<Object> getAllManagedAxis() {
		final Set<Object> allExistingAxis = new HashSet<Object>();
		for(IAxisManager manager : this.subManagers) {
			Collection<Object> managerPossibleElements = manager.getAllManagedAxis();
			if(managerPossibleElements != null) {
				allExistingAxis.addAll(managerPossibleElements);
			}
		}
		return allExistingAxis;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isSlave()
	 * 
	 * @return
	 *         <code>true</code> if one of the encapsulated manager is a slave
	 */
	public boolean isSlave() {
		for(final IAxisManager manager : this.subManagers) {
			if(manager.isSlave()) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isDynamic()
	 * 
	 * @return
	 *         <code>true</code> if one of the embedded axis manager is dynamic
	 */
	public boolean isDynamic() {
		for(final IAxisManager manager : this.subManagers) {
			if(manager.isDynamic()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canDropAxisElement(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 * @return
	 */
	@Override
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		for(final IAxisManager current : this.subManagers) {
			if(current.canDropAxisElement(objectsToAdd)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 
	 * @param elementToMove
	 * @param newIndex
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#moveAxis(java.lang.Object, int)
	 */
	public void moveAxis(Object elementToMove, int newIndex) {
		if(!isDynamic() && elementToMove instanceof IAxis) {
			TransactionalEditingDomain domain = getTableEditingDomain();
			final Command command = MoveCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), elementToMove, newIndex);
			domain.getCommandStack().execute(command);
		};
	}

	@Override
	public boolean canEditAxisHeader(final NatEventData axisIndex) {
		axisIndex.getColumnPosition();//TODO
		if(canEditAxisHeader()) {//TODO
			return true;
		} else {
			return false;//TODO : we need to iterate on the contents to know if it is possible or not
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canEditAxisHeader()
	 * 
	 * @return
	 */
	@Override
	public boolean canEditAxisHeader() {
		for(final IAxisManager current : this.subManagers) {
			if(!current.canEditAxisHeader()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getElementAxisName(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis)
	 * 
	 * @param axis
	 * @return
	 */
	public String getElementAxisName(final IAxis axis) {
		final AxisManagerRepresentation manager = axis.getManager();
		for(final IAxisManager man : this.subManagers) {
			if(man.getAxisManagerRepresentation() == manager) {
				return man.getElementAxisName(axis);
			}
		}
		if(canEditAxisHeader()) {
			return null;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * 
	 * @param axis
	 *        an axis
	 * @return
	 *         the axis manager managing this axis
	 */
	protected IAxisManager getAxisManager(final IAxis axis) {
		final AxisManagerRepresentation rep = axis.getManager();
		for(final IAxisManager man : this.subManagers) {
			if(man.getAxisManagerRepresentation() == rep) {
				return man;
			}
		}
		return null;//must be impossible
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canDestroyAxis(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	@Override
	public boolean canDestroyAxis(final Integer axisPosition) {
		final List<Object> elements = getElements();
		final Object element = elements.get(axisPosition);
		if(element instanceof IAxis) {
			return getAxisManager((IAxis)element).canDestroyAxis(axisPosition);
		}
		//not yet managed
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
		final List<Object> elements = getElements();
		final Object element = elements.get(axisPosition);
		if(element instanceof IAxis) {
			return getAxisManager((IAxis)element).canDestroyAxisElement(axisPosition);
		} else if(subManagers.size() == 1) {
			return subManagers.get(0).canDestroyAxisElement(axisPosition);
		}
		//not yet managed
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
		final List<Object> elements = getElements();
		final Object element = elements.get(axisPosition);
		if(element instanceof IAxis) {
			return getAxisManager((IAxis)element).getDestroyAxisElementCommand(domain, axisPosition);
		} else if(subManagers.size() == 1) {
			return subManagers.get(0).getDestroyAxisElementCommand(domain, axisPosition);
		}
		//not yet managed
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public boolean canBeSavedAsConfig() {
		boolean canBeSavedAsConfig = true;
		for(IAxisManager manager : subManagers) {
			canBeSavedAsConfig &= manager.canBeSavedAsConfig();
		}
		return canBeSavedAsConfig;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAdapter(java.lang.Class)
	 * 
	 * @param adapter
	 * @return
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		for(final IAxisManager current : this.subManagers) {
			if(current.getClass() == adapter) {
				return current;
			}
		}
		return super.getAdapter(adapter);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager#isInSortedState()
	 * 
	 * @return
	 */
	@Override
	public boolean isInSortedState() {
		return this.axisComparator != null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager#setAxisComparator(java.util.Comparator)
	 * 
	 * @param comp
	 */
	public void setAxisComparator(final Comparator<Object> comp) {
		this.axisComparator = comp;
		if(this.axisComparator != null) {
			List<Object> displayedElement = getElements();
			synchronized(displayedElement) {
				Collections.sort(displayedElement, comp);
				getTableManager().refreshNatTable();//useful?
			}
		} else {
			getTableManager().updateAxisContents(getRepresentedContentProvider());
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#isAlreadyManaged(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAlreadyManaged(final Object object) {
		for(final IAxisManager current : this.subManagers) {
			if(current.isAlreadyManaged(object)) {
				return true;
			}
		}
		return false;
	}
}
