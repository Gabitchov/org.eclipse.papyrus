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
package org.eclipse.papyrus.infra.nattable.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * The abstract handler to use for the table actions
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractTableHandler extends AbstractHandler {

	/** the id used to find the NatEvent in the EclipseContext */
	public static final String NAT_EVENT_DATA_PARAMETER_ID = "natEventParameterId";

	/**
	 * the event which have declenched the call to setEnable(Object evaluationContext. This event contains the location of the mouse pointer when
	 * the popup menu for this handler have been created
	 */
	//FIXME : should maybe be remove with the future usage of e4 and the Eclispe Context
	protected NatEventData eventData;


	/**
	 * 
	 * @return
	 *         the current active part
	 */
	protected IWorkbenchPart getActivePart() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
	}

	/**
	 * 
	 * @return
	 *         the current table manager or <code>null</code> if not found
	 */
	protected INattableModelManager getCurrentNattableModelManager() {
		final IWorkbenchPart currentPart = getActivePart();
		if(currentPart != null) {
			final INattableModelManager manager = (INattableModelManager)currentPart.getAdapter(INattableModelManager.class);
			return manager;
		}
		return null;
	}


	/**
	 * Returns the EditingDomain associated to the table
	 * 
	 * @return
	 */
	protected EditingDomain getTableEditingDomain() {//duplicated code from NattableModelManager
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getCurrentNattableModelManager().getTable());
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
	protected EditingDomain getContextEditingDomain() {//duplicated code from NattableModelManager
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getCurrentNattableModelManager().getTable());
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}

		return null;
	}

	/**
	 * 
	 * @param evaluationContext
	 *        the evaluation context
	 * @return
	 *         the NatEventData from this evaluation context
	 */
	protected NatEventData getNatEventData(final Object evaluationContext) {
		if(evaluationContext instanceof NatEventData) {
			return (NatEventData)evaluationContext;
		}
		NatEventData eventData = null;
		if(evaluationContext instanceof IEvaluationContext) {
			Object value = ((IEvaluationContext)evaluationContext).getVariable(NAT_EVENT_DATA_PARAMETER_ID);
			if(value instanceof NatEventData) {
				eventData = (NatEventData)value;
			}
		}
		//FIXME : currently we can't have dependency on org.eclipse.e4.... 
		//that's why we can't add the variable NAT_EVENT_DATA_PARAMETER_ID and we need to create a NatEventData instead of to get it in evaluationContext
		if(eventData == null) {
			Point cursorLocation = Display.getDefault().getCursorLocation();
			Control control = Display.getDefault().getCursorControl();//FIXME doesn't work when we are selecting a command in a menu!
			if(control instanceof NatTable) {//FIXME : not nice, but required
				cursorLocation = control.toControl(cursorLocation);
				Event e = new Event();
				e.x = cursorLocation.x;
				e.y = cursorLocation.y;
				e.display = Display.getDefault();
				e.widget = control;
				MouseEvent event = new MouseEvent(e);
				eventData = NatEventData.createInstanceFromEvent(event);
			}
		}
		return eventData;
	}

	/**
	 * 
	 * @param evaluationContext
	 * @return
	 *         the index of the rows which are fully selected
	 */
	protected List<Integer> getFullSelectedRowsIndex(Object evaluationContext) {
		final INattableModelManager manager = getCurrentNattableModelManager();
		if(manager != null) {
			final NatEventData data = getNatEventData(evaluationContext);
			if(data != null) {
				final SelectionLayer layer = manager.getBodyLayerStack().getSelectionLayer();
				int[] fullSelectedColumnsPosition = layer.getFullySelectedRowPositions();
				List<Integer> positions = new ArrayList<Integer>();
				for(int i : fullSelectedColumnsPosition) {
					positions.add(layer.getRowIndexByPosition(i));
				}
				return positions;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * 
	 * @param evaluationContext
	 * @return
	 *         the index of the columns which are fully selected
	 */
	protected List<Integer> getFullSelectedColumnsIndex(Object evaluationContext) {
		final INattableModelManager manager = getCurrentNattableModelManager();
		if(manager != null) {
			final NatEventData data = getNatEventData(evaluationContext);
			if(data != null) {
				final SelectionLayer layer = manager.getBodyLayerStack().getSelectionLayer();
				int[] fullSelectedColumnsPosition = layer.getFullySelectedColumnPositions();
				List<Integer> positions = new ArrayList<Integer>();
				for(int i : fullSelectedColumnsPosition) {
					positions.add(layer.getColumnIndexByPosition(i));
				}
				return positions;
			}
		}
		return Collections.emptyList();
	}


	/**
	 * 
	 * @return
	 *         the row axis manager
	 */
	protected IAxisManager getRowAxisManager() {
		final INattableModelManager manager = getCurrentNattableModelManager();
		if(manager != null) {
			return manager.getRowAxisManager();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the column axis manager
	 */
	protected IAxisManager getColumnAxisManager() {
		final INattableModelManager manager = getCurrentNattableModelManager();
		if(manager != null) {
			return manager.getColumnAxisManager();
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		this.eventData = getNatEventData(evaluationContext);
		setBaseEnabled(getCurrentNattableModelManager() != null);
	}
}
