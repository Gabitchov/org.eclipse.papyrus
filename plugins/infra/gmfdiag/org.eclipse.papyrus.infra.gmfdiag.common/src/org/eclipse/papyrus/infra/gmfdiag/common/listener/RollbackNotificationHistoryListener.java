/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.gmfdiag.common.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.TriggeredOperations;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.IRollbackStatus;
import org.eclipse.papyrus.infra.core.resource.RollbackStatus;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.messages.Messages;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;


/**
 * An operation history listener that detects execution failures due to transaction rollback and presents dialogs to explain.
 */
public class RollbackNotificationHistoryListener implements IOperationHistoryListener {

	public RollbackNotificationHistoryListener() {
		super();
	}

	public void historyNotification(OperationHistoryEvent event) {
		switch(event.getEventType()) {
		case OperationHistoryEvent.OPERATION_NOT_OK:
			final long now = System.currentTimeMillis();

			IRollbackStatus rollback = RollbackStatus.findRollbackStatus(event.getStatus());
			if(rollback == null) {
				// Failure of a TriggeredOperations results in an event without a status
				rollback = findRollbackStatus(event.getOperation());
			}

			if(rollback != null) {
				Collection<?> causalObjects = rollback.getCausalObjects();
				Collection<String> labels = getObjectLabels(causalObjects);

				String message;
				switch(rollback.getCode()) {
				case IRollbackStatus.UNCAUGHT_EXCEPTION:
					message = labels.isEmpty() ? Messages.RollbackNotificationHistoryListener_exception : NLS.bind(Messages.RollbackNotificationHistoryListener_exceptionWithCause, labels);
					break;
				case IRollbackStatus.READ_ONLY_OBJECT:
					message = labels.isEmpty() ? Messages.RollbackNotificationHistoryListener_readOnly : NLS.bind(Messages.RollbackNotificationHistoryListener_readOnlyWithCause, labels);
					break;
				default:
					message = labels.isEmpty() ? Messages.RollbackNotificationHistoryListener_unknown : NLS.bind(Messages.RollbackNotificationHistoryListener_unknownWithCause, labels);
					break;
				}

				// Eclipse doesn't seem to use the status adapter explanation property, so we must create a new status with our message
				StatusAdapter adapter = new StatusAdapter(new Status(rollback.getSeverity(), rollback.getPlugin(), rollback.getCode(), message, rollback.getException()));
				adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.RollbackNotificationHistoryListener_title);
				adapter.setProperty(IStatusAdapterConstants.TIMESTAMP_PROPERTY, now);

				StatusManager.getManager().handle(adapter, StatusManager.SHOW);
			}
			break;
		}
	}

	protected List<String> getObjectLabels(Iterable<?> objects) {
		List<String> result = new ArrayList<String>();
		ILabelProvider labels = null;

		try {
			for(Object next : objects) {
				if(labels == null) {
					try {
						LabelProviderService labelService = null;
						if(next instanceof EObject) {
							labelService = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, (EObject)next);
						} else if(next instanceof Resource) {
							labelService = ServiceUtilsForResource.getInstance().getService(LabelProviderService.class, (Resource)next);
						}

						if(labelService != null) {
							labels = labelService.getLabelProvider();
						}
					} catch (ServiceException e) {
						// not in an editor context.  Fine
						labels = new EMFLabelProvider();
					}
				}

				if(labels != null) {
					result.add(labels.getText(next));
				}
			}
		} finally {
			if(labels != null) {
				labels.dispose();
			}
		}

		return result;
	}

	protected IRollbackStatus findRollbackStatus(IUndoableOperation operation) {
		IRollbackStatus result = null;

		if(operation instanceof ICommand) {
			CommandResult commandResult = ((ICommand)operation).getCommandResult();
			if(commandResult != null) {
				result = RollbackStatus.findRollbackStatus(commandResult.getStatus());
			}
		} else if(operation instanceof TriggeredOperations) {
			// We can't get the children out of a generic ICompositeOperation, and from this one only the initial triggering operation
			return findRollbackStatus(((TriggeredOperations)operation).getTriggeringOperation());
		}

		return result;
	}
}
