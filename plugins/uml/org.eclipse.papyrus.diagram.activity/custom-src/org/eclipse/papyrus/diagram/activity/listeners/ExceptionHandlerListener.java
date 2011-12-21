/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.listeners.AbstractModifcationTriggerListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * When an Exception Input is set (for {@link ExceptionHandler}) then the Handler Body should be set automatically
 * 
 * @author arthur daussy
 * 
 */
public class ExceptionHandlerListener extends AbstractModifcationTriggerListener<ExceptionHandler> {

	@Override
	protected ExceptionHandler getElement(Notification notif) {
		Object elem = notif.getNotifier();
		if(elem instanceof ExceptionHandler) {
			return (ExceptionHandler)elem;
		}
		return null;
	}

	@Override
	protected boolean isCorrectStructuralfeature(EStructuralFeature eStructuralFeature) {
		if(UMLPackage.Literals.EXCEPTION_HANDLER__EXCEPTION_INPUT.equals(eStructuralFeature)) {
			return true;
		}
		return false;
	}

	@Override
	protected ICommand getModificationCommand(Notification notif,TransactionalEditingDomain domain) {
		if(Notification.SET == notif.getEventType()) {
			ExceptionHandler ex = getElement(notif);
			Object exceptionInput = notif.getNewValue();
			if(exceptionInput instanceof Pin) {
				Element owner = ((Pin)exceptionInput).getOwner();
				if(owner instanceof ExecutableNode) {
					SetCommand cmd = new SetCommand(domain, ex, UMLPackage.Literals.EXCEPTION_HANDLER__HANDLER_BODY, owner);
					return new EMFtoGMFCommandWrapper(cmd);
				}
			}
		}
		return null;
	}
}
