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

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.ui.services.IDisposable;

/**
 * The common interface used by the axis manager
 * 
 * @author Vincent Lorenzo
 * 
 */
public interface IAxisManager extends IDisposable {

	/**
	 * 
	 * @return <code>true</code> if the manager can be used horizontally
	 */
	public boolean canBeUsedAsRowManager();

	/**
	 * 
	 * @return <code>true</code> if the manager can be used vertically
	 */
	public boolean canBeUsedAsColumnManager();

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return the command to add an axis to the emf model
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return the complementary command, which is called by the master on the
	 *         slave to add required axis
	 */
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	/**
	 * 
	 * @param manager
	 *        the table model manager
	 * @param managerRep
	 *        its axis manager representation
	 * @param provider
	 *        //FIXME : realy usefule?
	 *        the managed axis provider
	 */
	public void init(final INattableModelManager manager, AxisManagerRepresentation managerRep, final AbstractAxisProvider provider);

	public void setHeaderDataValue(int columnIndex, int rowIndex, Object newValue);

	/**
	 * 
	 * @return
	 *         the managed axis provider
	 */
	public AbstractAxisProvider getRepresentedContentProvider();

	/**
	 * 
	 * 
	 * @return
	 *         the table manager using this axis manager
	 */
	public NattableModelManager getTableManager(); //FIXME : we must use an interface with a small set of accessible method... 



	/**
	 * 
	 * @return
	 *         <code>true</code> if the contents provided by the axis manager is derived of the contents provided by the others axis manager
	 */
	public boolean isSlave();

	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index);

	public boolean canDropAxisElement(Collection<Object> objectsToAdd);

	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index);

	/**
	 * 
	 * @param object
	 *        an object
	 * @return
	 *         <code>true</code> if the object can be managed by the AxisManager
	 */
	public boolean isAllowedContents(final Object object);

	/**
	 * 
	 * @return <code>true</code> if we can move elements on the axis
	 */
	public boolean canMoveAxis();

	/**
	 * 
	 * @param isRestricted
	 * @return
	 *         a content provider or <code>null</code> if the dialog to add/destroy axis is not supported
	 */
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted);


	/**
	 * 
	 * @param domain
	 * @param objectToDestroy
	 * @return
	 */
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy);

	/**
	 * 
	 * @return
	 *         the list of the existing axis managed by the axis manager
	 */
	public Collection<Object> getAllManagedAxis();

	/**
	 * 
	 * @return
	 *         <code>true</code> if the contents provided by this axis manager is derived of the (UML) model
	 */
	public boolean isDynamic();

	/**
	 * 
	 * @param newIndex
	 * @param axisToMove
	 */
	public void moveAxis(final Object elementToMove, final int newIndex);

	/**
	 * 
	 * @param elementId
	 *        the id of the element to create
	 * @return
	 *         <code>true</code> if the element can be created
	 */
	public boolean canCreateAxisElement(final String elementId);

	/**
	 * 
	 * @return
	 *         <code>true</code> if we allows to edit the string of all axis headers.
	 */
	public boolean canEditAxisHeader();

	/**
	 * Open a dialog to edit the alias of an axis and set the value
	 * 
	 * @param event
	 *        the event
	 * @param axisIndex
	 *        the position of the axis
	 */
	public void openEditAxisAliasDialog(final NatEventData event, int axisIndex);

	/**
	 * 
	 * @return
	 *         the axis manager representation
	 */
	public AxisManagerRepresentation getAxisManagerRepresentation();

	/**
	 * 
	 * @param axis
	 *        an axis
	 * @return
	 *         the name used for this axis
	 */
	public String getElementAxisName(final IAxis axis);//FIXME pb if the axisManager returns Object and not IAxis...
}
