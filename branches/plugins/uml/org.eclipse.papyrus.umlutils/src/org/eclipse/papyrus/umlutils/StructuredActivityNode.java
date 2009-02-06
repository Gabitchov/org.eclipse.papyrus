/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * 
 * @author Remi SCHNEKENBURGER
 */
public class StructuredActivityNode extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.StructuredActivityNode uml2StructuredActivityNode;

	/**
	 * 
	 * 
	 * @param structuredActivityNode
	 */
	public StructuredActivityNode(org.eclipse.uml2.uml.StructuredActivityNode structuredActivityNode) {
		super(structuredActivityNode);
		this.uml2StructuredActivityNode = structuredActivityNode;
	}

	/**
	 * Get the encapsulated <code>StructuredActivityNode</code>.
	 * 
	 * @return Returns the uml2StructuredActivityNode.
	 */
	public org.eclipse.uml2.uml.StructuredActivityNode getUml2StructuredActivityNode() {
		return uml2StructuredActivityNode;
	}

	/**
	 * Creates a CreateObjectAction.
	 * 
	 * @param classifier
	 *            the type of the created object
	 * @param resultName
	 *            the name of the output pin 'result'
	 * @param name
	 *            the name of the action
	 * 
	 * @return the created Action
	 * 
	 * @see org.eclipse.uml2.uml.CreateObjectAction
	 */
	public org.eclipse.papyrus.umlutils.CreateObjectAction createCreateObjectAction(String name, String resultName, org.eclipse.papyrus.umlutils.Class classifier) {
		org.eclipse.uml2.uml.CreateObjectAction uml2CreateObjectAction = (org.eclipse.uml2.uml.CreateObjectAction) (uml2StructuredActivityNode.createNode(name, UMLPackage.eINSTANCE
				.getCreateObjectAction()));
		if (uml2CreateObjectAction != null) {
			uml2CreateObjectAction.setClassifier(classifier.getUml2Class());
			// create result output pin
			OutputPin result = uml2CreateObjectAction.createResult(resultName, classifier.getUml2Class());
			result.setName(resultName);
			// set upper bound (necessary, or model is not valid
			LiteralInteger upperBound = (LiteralInteger) result.createUpperBound("", null, UMLPackage.eINSTANCE.getLiteralInteger());
			upperBound.setValue(1);
			result.setUpperBound(upperBound);
			// sets the type of classifier created.
		}
		return new org.eclipse.papyrus.umlutils.CreateObjectAction(uml2CreateObjectAction);
	}

	/**
	 * Creates a ControlFlow between 2 ActivityNodes.
	 * 
	 * @param targetNode
	 *            the target ActivityNode
	 * @param sourceNode
	 *            the source ActivityNode
	 * 
	 * @return the created ControlFlow
	 */
	public org.eclipse.papyrus.umlutils.ControlFlow createControlFlow(org.eclipse.papyrus.umlutils.ActivityNode sourceNode, org.eclipse.papyrus.umlutils.ActivityNode targetNode) {
		ControlFlow uml2ControlFlow = (org.eclipse.uml2.uml.ControlFlow) (uml2StructuredActivityNode.createEdge("ControlFlow_" + sourceNode.getName() + "_" + targetNode.getName(),
				UMLPackage.eINSTANCE.getControlFlow()));

		if (uml2ControlFlow != null) {
			uml2ControlFlow.setSource(sourceNode.getUml2ActivityNode());
			uml2ControlFlow.setTarget(targetNode.getUml2ActivityNode());
			// set the guard and the weight (necessary for a valid model)
			LiteralNull guard = (LiteralNull) uml2ControlFlow.createGuard("", null, UMLPackage.eINSTANCE.getLiteralNull());
			uml2ControlFlow.setGuard(guard);
			LiteralInteger weight = (LiteralInteger) uml2ControlFlow.createWeight("", null, UMLPackage.eINSTANCE.getLiteralInteger());
			weight.setValue(1);
			uml2ControlFlow.setWeight(weight);
		}
		return new org.eclipse.papyrus.umlutils.ControlFlow(uml2ControlFlow);
	}

	/**
	 * Creates an InitialNode.
	 * 
	 * @param name
	 *            the name of the InitialNode
	 * 
	 * @return the created InitialNode
	 */
	public org.eclipse.papyrus.umlutils.InitialNode createInitialNode(String name) {
		InitialNode uml2initialNode = (org.eclipse.uml2.uml.InitialNode) (uml2StructuredActivityNode.createNode(name, UMLPackage.eINSTANCE.getInitialNode()));
		return new org.eclipse.papyrus.umlutils.InitialNode(uml2initialNode);
	}

	/**
	 * Creates an ActivityFinalNode.
	 * 
	 * @param name
	 *            the name of the object
	 * 
	 * @return the created ActivityFinalNode
	 */
	public org.eclipse.papyrus.umlutils.ActivityFinalNode createActivityFinalNode(String name) {
		ActivityFinalNode uml2ActivityFinalNode = (org.eclipse.uml2.uml.ActivityFinalNode) (uml2StructuredActivityNode.createNode(name, UMLPackage.eINSTANCE.getActivityFinalNode()));

		return new org.eclipse.papyrus.umlutils.ActivityFinalNode(uml2ActivityFinalNode);
	}
}
