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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
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
			Control control = Display.getDefault().getCursorControl();
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

}
