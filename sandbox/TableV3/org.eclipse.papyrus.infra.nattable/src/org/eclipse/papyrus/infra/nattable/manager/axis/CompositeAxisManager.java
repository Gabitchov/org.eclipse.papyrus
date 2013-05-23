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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
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


public class CompositeAxisManager extends AbstractAxisManager implements ICompositeAxisManager {

	/**
	 * the id of this manager
	 */
	private static final String MANAGER_ID = "org.eclipse.papyrus.infra.nattable.composite.axis.manager"; //$NON-NLS-1$

	/**
	 * the sub managers
	 */
	protected List<IAxisManager> subManagers;

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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
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
		final List<Object> displayedElement = getTableManager().getElementsList(getRepresentedContentProvider());
		synchronized(displayedElement) {
			displayedElement.clear();
			displayedElement.addAll(getRepresentedContentProvider().getAxis());
			if(this.subManagers != null) {
				for(final IAxisManager current : this.subManagers) {
					if(current.isDynamic()) {
						displayedElement.addAll(current.getAllManagedAxis());
					}
				}
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getDestroyAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToDestroy
	 * @return
	 */
	@Override
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {
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
		Set<Object> allExistingAxis = new HashSet<Object>();
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
			EditingDomain domain = getTableEditingDomain();
			final Command command = MoveCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), elementToMove, newIndex);
			domain.getCommandStack().execute(command);
		};
	}

	@Override
	public boolean canEditAxisHeader(final NatEventData axisIndex) {
		axisIndex.getColumnPosition();//FIXME
		if(canEditAxisHeader()) {//FIXME
			return true;
		} else {
			return false;//FIXME : we need to iterate on the contents to know if it is possible or not
		}
	}

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
		final List<Object> elements = tableManager.getElementsList(getRepresentedContentProvider());//FIXME create a util method for that
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
		final List<Object> elements = tableManager.getElementsList(getRepresentedContentProvider());//FIXME create a util method for that
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Integer)
	 * 
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	@Override
	public Command getDestroyAxisElementCommand(EditingDomain domain, Integer axisPosition) {
		final List<Object> elements = tableManager.getElementsList(getRepresentedContentProvider());//FIXME create a util method for that
		final Object element = elements.get(axisPosition);
		if(element instanceof IAxis) {
			return getAxisManager((IAxis)element).getDestroyAxisElementCommand(domain, axisPosition);
		} else if(subManagers.size() == 1) {
			return subManagers.get(0).getDestroyAxisElementCommand(domain, axisPosition);
		}
		//not yet managed
		return UnexecutableCommand.INSTANCE;
	}





}
