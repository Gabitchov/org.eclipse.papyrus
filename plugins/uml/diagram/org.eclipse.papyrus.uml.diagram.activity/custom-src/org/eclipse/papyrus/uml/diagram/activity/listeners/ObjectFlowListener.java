/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.listeners.AbstractPapyrusModifcationTriggerListener;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author tfaure
 * 
 */
public class ObjectFlowListener extends AbstractPapyrusModifcationTriggerListener {

	@Override
	public NotificationFilter getFilter() {
		// AN EDGE is contained only in activities and structured
		NotificationFilter filter1 = NotificationFilter.createEventTypeFilter(Notification.ADD).and(NotificationFilter.createNotifierTypeFilter(UMLPackage.Literals.STRUCTURED_ACTIVITY_NODE));
		return filter1.or(NotificationFilter.createEventTypeFilter(Notification.ADD).and(NotificationFilter.createNotifierTypeFilter(UMLPackage.Literals.ACTIVITY)));
	}

	@Override
	protected CompositeCommand getModificationCommand(Notification notif) {
		CompositeCommand cc = null;
		if(notif.getNewValue() instanceof ObjectFlow && notif.getFeature() instanceof EReference && ((EReference)notif.getFeature()).isContainment()) {
			cc = new CompositeCommand("Modify Flow");
			final ObjectFlow object = (ObjectFlow)notif.getNewValue();
			TransactionalEditingDomain domain = (TransactionalEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(object);
			if(object.getGuard() == null) {
				LiteralBoolean bool = UMLFactory.eINSTANCE.createLiteralBoolean();
				bool.setValue(true);
				cc.compose(new EMFtoGMFCommandWrapper(SetCommand.create(domain, object, UMLPackage.Literals.ACTIVITY_EDGE__GUARD, bool)));
			}
			if(object.getWeight() == null) {
				LiteralInteger literalInteger = UMLFactory.eINSTANCE.createLiteralInteger();
				literalInteger.setValue(1);
				cc.compose(new EMFtoGMFCommandWrapper(SetCommand.create(domain, object, UMLPackage.Literals.ACTIVITY_EDGE__WEIGHT, literalInteger)));
			}
		}
		return cc;
	}
}
