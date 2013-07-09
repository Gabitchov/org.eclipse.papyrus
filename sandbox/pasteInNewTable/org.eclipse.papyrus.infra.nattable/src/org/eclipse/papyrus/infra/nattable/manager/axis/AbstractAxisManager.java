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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.editors.InputDialog;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractAxisManager implements IAxisManager {

	/**
	 * the represented axis manager
	 */
	protected AxisManagerRepresentation representedAxisManager;

	/**
	 * the represented axis provider
	 */
	private AbstractAxisProvider representedContentProvider;

	/**
	 * the global manager for the table
	 */
	protected INattableModelManager tableManager;

	/**
	 * the listener on the axis
	 */
	protected Adapter axisListener;

	/**
	 * the context of the table. We need to keep it, to be able to remove listeners on it, when the table is destroying
	 */
	private EObject tableContext;

	/**
	 * 
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      java.lang.String, org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider)
	 * 
	 * @param manager
	 *        the globale table manager
	 * @param provider
	 *        the represented axis provider
	 * @param managerId
	 *        the id of this manager
	 */
	public void init(final INattableModelManager manager, final AxisManagerRepresentation rep, final AbstractAxisProvider provider) {
		this.tableManager = manager;
		this.representedAxisManager = rep;
		this.representedContentProvider = provider;
		this.tableContext = manager.getTable().getContext();
		this.axisListener = new AdapterImpl() {

			@Override
			public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
				getTableManager().updateAxisContents(getRepresentedContentProvider());
			}
		};
		this.representedContentProvider.eAdapters().add(this.axisListener);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getTableManager()
	 * 
	 * @return
	 */
	public NattableModelManager getTableManager() {
		return (NattableModelManager)this.tableManager;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canInsertAxis(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canCreateAxisElement(java.lang.String)
	 * 
	 * @param elementId
	 * @return
	 */
	@Override
	public boolean canCreateAxisElement(String elementId) {
		return ElementTypeRegistry.getInstance().getType(elementId)!=null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDropAxisElement(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 * @return
	 */
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	public void dispose() {
		if(this.axisListener != null) {
			this.representedContentProvider.eAdapters().remove(this.axisListener);
			this.axisListener = null;
		}
		this.tableContext = null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeUsedAsRowManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsRowManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeUsedAsColumnManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsColumnManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getInsertAxisCommand(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getRepresentedContentProvider()
	 * 
	 * @return
	 */
	public AbstractAxisProvider getRepresentedContentProvider() {
		return this.representedContentProvider;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#setHeaderDataValue(int, int, java.lang.Object)
	 * 
	 * @param columnIndex
	 * @param rowIndex
	 * @param newValue
	 */
	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return <code>true</code> if the object is not yet represented by an axis
	 */
	public boolean isAllowedContents(Object object) {
		return !getTableManager().getElementsList(getRepresentedContentProvider()).contains(object);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canMoveAxis()
	 * 
	 * @return
	 */
	public boolean canMoveAxis() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#createPossibleAxisContentProvider(boolean)
	 * 
	 * @param isRestricted
	 * @return
	 */
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted) {
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToDestroy
	 * @return
	 */
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
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {//FIXME must be done in the abstract class
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getRepresentedContentProvider());
		final CompositeCommand compositeCommand = new CompositeCommand("Destroy IAxis Command");
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current.getManager() == this.representedAxisManager) {
				if(objectToDestroy.contains(current) || objectToDestroy.contains(current.getElement())) {
					final DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)domain, current, false);
					compositeCommand.add(provider.getEditCommand(request));
				}
			}
		}
		if(!compositeCommand.isEmpty()) {
			return new GMFtoEMFCommandWrapper(compositeCommand);
		}
		return null;

	}


	/**
	 * 
	 * @return
	 *         the context of the managed table
	 */
	protected final EObject getTableContext() {
		return this.tableContext;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	public Collection<Object> getAllManagedAxis() {
		Set<Object> eObjects = new HashSet<Object>();
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current.getManager() == this.representedAxisManager) {
				eObjects.add(current.getElement());
			}
		}
		return eObjects;
	}

	/**
	 * Returns the EditingDomain associated to the table
	 * 
	 * @return
	 */
	protected EditingDomain getTableEditingDomain() {//Duplicated from NatTableModelManager
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getTableManager().getTable());
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}

		return null;
	}

	/**
	 * Returns the EditingDomain associated to the context
	 * 
	 * @return
	 */
	protected EditingDomain getContextEditingDomain() { //Duplicated from NatTableModelManager
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getTableContext());
			return registry.getService(TransactionalEditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}
		return null;
	}

	public void moveAxis(Object elementToMove, int newIndex) {
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#openEditAxisAliasDialog(org.eclipse.nebula.widgets.nattable.ui.NatEventData,
	 *      int)
	 * 
	 * @param event
	 * @param axisPosition
	 */
	@Override
	public void openEditAxisAliasDialog(final NatEventData event, int axisPosition) {
		final IAxis axis = this.representedContentProvider.getAxis().get(axisPosition);
		String alias = axis.getAlias();
		if(alias == null) {
			alias = ""; //$NON-NLS-1$
		}

		final String dialogMessage = String.format(Messages.AbstractAxisManager_InputDialogMessage, getElementAxisName(axis));
		Point location = new Point(event.getOriginalEvent().x, event.getOriginalEvent().y);
		Control natTable = event.getNatTable();
		location = natTable.toDisplay(location);
		final InputDialog dialog = new InputDialogWithLocation(Display.getDefault().getActiveShell(), Messages.AbstractAxisManager_InputDialogTitle, dialogMessage, alias, null, location);
		int result = dialog.open();
		if(result == IDialogConstants.OK_ID) {
			String newAlias = dialog.getText();
			if("".equals(newAlias)) { //$NON-NLS-1$
				newAlias = null;
			}
			final TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
			final SetRequest request = new SetRequest(domain, axis, NattableaxisPackage.eINSTANCE.getIAxis_Alias(), newAlias);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(axis);
			final ICommand cmd = provider.getEditCommand(request);
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		}
	}

	/**
	 * This method mustt be overriden by the children classes
	 * 
	 * @param axis
	 *        an axis
	 * @return
	 *         <code>null</code> or an {@link UnsupportedOperationException} when the method {@link #canEditAxisHeader()} returns <code>false</code>
	 */
	public String getElementAxisName(final IAxis axis) {
		if(canEditAxisHeader()) {
			return null;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getAxisManagerRepresentation()
	 * 
	 * @return
	 */
	@Override
	public AxisManagerRepresentation getAxisManagerRepresentation() {
		return this.representedAxisManager;
	}

	/**
	 * 
	 * @param axisPositions
	 * @return
	 */
	@Override
	public boolean canDestroyAxis(final List<Integer> axisPositions) {
		if(axisPositions.isEmpty()) {
			return false;
		}
		for(final Integer integer : axisPositions) {
			if(!canDestroyAxis(integer)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean canDestroyAxisElement(List<Integer> axisPositions) {
		if(axisPositions.isEmpty()) {
			return false;
		}
		for(final Integer integer : axisPositions) {
			if(!canDestroyAxisElement(integer)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param axisPositions
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#destroyAxis(java.util.List)
	 */
	@Override
	public void destroyAxis(final List<Integer> axisPositions) {
		final List<Object> toDestroy = getElements(axisPositions);
		EditingDomain domain = getTableEditingDomain();
		final Command cmd = getDestroyAxisCommand(domain, toDestroy);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxis(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	public boolean canDestroyAxis(final Integer axisPosition) {
		return !isDynamic();
	}


	/**
	 * 
	 * @param axisPositions
	 *        axis positions
	 * @return
	 *         the elements located at these axis position
	 */
	protected List<Object> getElements(final List<Integer> axisPositions) {
		final List<Object> elements = getElements();
		final List<Object> toDestroy = new ArrayList<Object>();
		for(final Integer position : axisPositions) {
			final Object element = elements.get(position);
			toDestroy.add(element);
		}
		return toDestroy;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#destroyAxisElement(java.util.List)
	 * 
	 * @param axisPosition
	 */
	@Override
	public void destroyAxisElement(final List<Integer> axisPosition) {
		final CompoundCommand cmd = new CompoundCommand("Destroy Axis Element Command");
		EditingDomain domain = getContextEditingDomain();
		for(Integer integer : axisPosition) {
			cmd.append(getDestroyAxisElementCommand(domain, integer));
		}

		domain.getCommandStack().execute(cmd);
	}

	/**
	 * 
	 * @return
	 *         the list owning the elements displayed on the managed axis
	 */
	protected List<Object> getElements() {
		return this.tableManager.getElementsList(getRepresentedContentProvider());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getPasteCommand(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration)
	 * 
	 * @param configuration
	 * @return
	 */
	@Override
	public ICommand getPasteCommand(IPasteConfiguration configuration) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canPaste(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration)
	 * 
	 * @param configuration
	 * @return
	 */
	@Override
	public boolean canPaste(IPasteConfiguration configuration) {
		return false;
	}
}
