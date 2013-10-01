/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationFlowConveyedLabelEditPart;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InformationFlow;

/**
 * This class manages the display of the conveyed classifiers by an {@linkInformationFlow}
 * 
 * 
 */
public class InformationFlowCustomLabelEditPolicy extends AbstractCustomLabelEditPolicy {

	/** constant for this edit policy role */
	public final static String SPECIFIC_NAME_LABEL_POLICY = "SpecificNameLabelEditPolicy";

	public final static int ADD_CONVEYED_CLASSIFIER = Notification.ADD;

	public final static int REMOVE_CONVEYED_CLASSIFER = Notification.REMOVE;

	public final static int CHANGE_NAME_OF_A_CONVOYED_CLASSIFIER = Notification.SET;

	public InformationFlowCustomLabelEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void addAdditionalListeners() {
		// adds a listener to the element itself, and to linked elements, like Type
		if(getUMLElement() instanceof InformationFlow) {
			// adds listener to each Convoyed Classifier
			EList<Classifier> conveyedClassifiers = ((InformationFlow)getUMLElement()).getConveyeds();
			for(int i = 0; i < conveyedClassifiers.size(); i++) {
				getDiagramEventBroker().addNotificationListener(conveyedClassifiers.get(i), this);
			}
		}
	}

	public void refreshDisplay() {
		refreshNameDisplay();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void removeAdditionalListeners() {
		if(getUMLElement() instanceof InformationFlow) {
			EList<Classifier> conveyedClassifiers = ((InformationFlow)getUMLElement()).getConveyeds();
			for(int i = 0; i < conveyedClassifiers.size(); i++) {
				getDiagramEventBroker().removeNotificationListener(conveyedClassifiers.get(i), this);
			}
		}
	}

	/**
	 * Refresh the name in the Label
	 * 
	 */
	protected void refreshNameDisplay() {
		if(getHost() instanceof InformationFlowConveyedLabelEditPart) {
			((InformationFlowConveyedLabelEditPart)getHost()).setLabelText(nameToDisplay());
		}
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void notifyChanged(Notification notification) {
		// change the label of the figure managed by the host edit part (managed by the parent edit
		// part in general...)
		// it must be changed only if:
		// - a convoyed classifier's name have changed
		// - add or remove of a convoyed classifier
		final int eventType = notification.getEventType();
		if(notification.getNotifier() instanceof InformationFlow) {
			switch(eventType) {
			case ADD_CONVEYED_CLASSIFIER:
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
				refreshDisplay();
				break;
			case REMOVE_CONVEYED_CLASSIFER:
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
				refreshDisplay();
				break;
			default:
				// Nothing to do
			}
		}
		if(eventType == CHANGE_NAME_OF_A_CONVOYED_CLASSIFIER) {
			refreshDisplay();
		}
	}

	/**
	 * 
	 * @return the name to display
	 */
	public String nameToDisplay() {
		String name = "";
		if(getUMLElement() instanceof InformationFlow) {
			EList<Classifier> classes = ((InformationFlow)getUMLElement()).getConveyeds();
			for(int i = 0; i < classes.size(); i++) {
				name += classes.get(i).getName();
				if(i != classes.size() - 1) {
					name += ", ";
				}
			}
		}
		return name;
	}
}
