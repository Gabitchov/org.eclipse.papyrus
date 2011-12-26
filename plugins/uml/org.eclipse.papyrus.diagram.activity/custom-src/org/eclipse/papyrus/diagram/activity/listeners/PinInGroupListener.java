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

import java.util.Collections;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.listeners.AbstractModifcationTriggerListener;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * This listener will synchronize the Activity groups of pin with the Activity Group of their owner
 * 
 * @author arthur daussy
 * 
 */
public class PinInGroupListener extends AbstractModifcationTriggerListener<ActivityNode> {

	@Override
	protected ActivityNode getElement(Notification notif) {
		Object element = notif.getNotifier();
		if(element instanceof ActivityNode) {
			return (ActivityNode)element;
		}
		return null;
	}

	@Override
	protected boolean isCorrectStructuralfeature(EStructuralFeature eStructuralFeature) {
		if(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION.equals(eStructuralFeature) || UMLPackage.Literals.ACTIVITY_NODE__IN_PARTITION.equals(eStructuralFeature)) {
			return true;
		}
		return false;
	}

	@Override
	protected ICommand getModificationCommand(final Notification notif,TransactionalEditingDomain domain) {
		CompositeCommand cc = null;
		String label = null;
		Object feature = notif.getFeature();
		for(final Pin p : getContainedPins(notif)) {
			//init
			if(cc == null) {
				label = "Synchronize groups feature for pins";////$NON-NLS-0$
				cc = new CompositeCommand(label);
			}
			Command cmd = null;
			Object newValue = notif.getNewValue();
			if(((EStructuralFeature)feature).isMany()) {
				if(newValue == null) {
					cmd = new RemoveCommand(domain, p, (EStructuralFeature)feature, notif.getOldValue());
				} else {
					cmd = new AddCommand(domain, p, (EStructuralFeature)feature, newValue);
				}
			} else {
				cmd = new SetCommand(getDiagramEditPart().getEditingDomain(), p, (EStructuralFeature)feature, notif.getNewValue());
			}
			if(cmd != null && cmd.canExecute()) {
				cc.compose(new EMFtoGMFCommandWrapper(cmd));
			}
		}
		return cc;
	}

	/**
	 * Get the contained Pin by the notifier
	 * 
	 * @param notif
	 * @return
	 */
	protected Iterable<Pin> getContainedPins(Notification notif) {
		ActivityNode elem = getElement(notif);
		if(elem != null) {
			try {
				Iterable<Element> ite1 = Iterables.filter(elem.getOwnedElements(), new Predicate<Element>() {

					public boolean apply(Element input) {
						if(input instanceof Pin) {
							return true;
						}
						return false;
					}
				});
				return Iterables.transform(ite1, new Function<Element, Pin>() {

					public Pin apply(Element from) {
						return (Pin)from;
					}
				});
			} catch (NoSuchElementException e) {
				return Collections.emptyList();
			}
		}
		return Collections.emptyList();
	}
}
