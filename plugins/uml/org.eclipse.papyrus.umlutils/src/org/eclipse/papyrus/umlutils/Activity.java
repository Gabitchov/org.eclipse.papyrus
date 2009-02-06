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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Activity</code><BR>
 * 
 * @author Remi SCHNEKENBURGER, Chokri MRAIDHA
 */
public class Activity extends Behavior {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Activity uml2Activity;

	/**
	 * 
	 * 
	 * @param activity
	 */
	public Activity(org.eclipse.uml2.uml.Activity activity) {
		super(activity);
		this.uml2Activity = activity;
	}

	/**
	 * Get the encapsulated <code>Activity</code>.
	 * 
	 * @return Returns the uml2Activity.
	 */
	public org.eclipse.uml2.uml.Activity getUml2Activity() {
		return uml2Activity;
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
		org.eclipse.uml2.uml.CreateObjectAction uml2CreateObjectAction = (org.eclipse.uml2.uml.CreateObjectAction) (uml2Activity.createNode(name, UMLPackage.eINSTANCE.getCreateObjectAction()));
		if (uml2CreateObjectAction != null) {
			uml2CreateObjectAction.setClassifier(classifier.getUml2Class());
			// create result output pin
			OutputPin result = uml2CreateObjectAction.createResult(resultName, classifier.getUml2Class());
			result.setName(resultName);
			// set upper bound (necessary, or model is not valid
			LiteralInteger upperBound = (LiteralInteger) result.createUpperBound("", null, UMLPackage.eINSTANCE.getLiteralInteger());
			upperBound.setValue(1);
			result.setUpperBound(upperBound);
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
		ControlFlow uml2ControlFlow = (org.eclipse.uml2.uml.ControlFlow) (uml2Activity.createEdge("ControlFlow_" + sourceNode.getName() + "_" + targetNode.getName(), UMLPackage.eINSTANCE
				.getControlFlow()));

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
		InitialNode uml2initialNode = (org.eclipse.uml2.uml.InitialNode) (uml2Activity.createNode(name, UMLPackage.eINSTANCE.getInitialNode()));

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
		ActivityFinalNode uml2ActivityFinalNode = (org.eclipse.uml2.uml.ActivityFinalNode) (uml2Activity.createNode(name, UMLPackage.eINSTANCE.getActivityFinalNode()));

		return new org.eclipse.papyrus.umlutils.ActivityFinalNode(uml2ActivityFinalNode);
	}

	/**
	 * Creates an ActivityParameterNode.
	 * 
	 * @param operationParameter
	 * @param name
	 *            the name of the object
	 * 
	 * @return the created ActivityFinalNode
	 */
	public org.eclipse.papyrus.umlutils.ActivityParameterNode createActivityParameterNode(String name, Parameter operationParameter) {
		ActivityParameterNode uml2ActivityParameterNode = (org.eclipse.uml2.uml.ActivityParameterNode) (uml2Activity.createNode(name, UMLPackage.eINSTANCE.getActivityParameterNode()));

		if (uml2ActivityParameterNode != null) {
			uml2ActivityParameterNode.setType(operationParameter.getUml2Parameter().getType());
			org.eclipse.uml2.uml.Parameter newParam = uml2Activity.createOwnedParameter(name, operationParameter.getUml2Parameter().getType());
			newParam.setDirection(operationParameter.getUml2Parameter().getDirection());
			newParam.setEffect(operationParameter.getUml2Parameter().getEffect());
			uml2ActivityParameterNode.setParameter(newParam);
		}
		return new org.eclipse.papyrus.umlutils.ActivityParameterNode(uml2ActivityParameterNode);
	}

	/**
	 * Gives all uml2 initial nodes of an activity
	 * 
	 * @return
	 */
	public ArrayList<InitialNode> getUml2InitialNodes() {
		ArrayList<InitialNode> result = new ArrayList<InitialNode>();

		org.eclipse.uml2.uml.Activity uml2Activity = getUml2Activity();
		Iterator<org.eclipse.uml2.uml.ActivityNode> nodesIter = uml2Activity.getNodes().iterator();
		while (nodesIter.hasNext()) {
			ActivityNode currentNode = nodesIter.next();
			if (currentNode instanceof InitialNode) {
				result.add((InitialNode) currentNode);
			}
		}
		return result;
	}

	/**
	 * Gives all uml2 activity final nodes of an activity
	 * 
	 * @return
	 */
	public ArrayList<ActivityFinalNode> getUml2FinalNodes() {
		ArrayList<ActivityFinalNode> result = new ArrayList<ActivityFinalNode>();

		org.eclipse.uml2.uml.Activity uml2Activity = getUml2Activity();
		Iterator<org.eclipse.uml2.uml.ActivityNode> nodesIter = uml2Activity.getNodes().iterator();
		while (nodesIter.hasNext()) {
			ActivityNode currentNode = nodesIter.next();
			if (currentNode instanceof ActivityFinalNode) {
				result.add((ActivityFinalNode) currentNode);
			}
		}

		return result;
	}

	/**
	 * Gives all uml2 decision nodes of an activity
	 * 
	 * @return
	 */
	public ArrayList<DecisionNode> getUml2DecisionNodes() {
		ArrayList<DecisionNode> result = new ArrayList<DecisionNode>();

		org.eclipse.uml2.uml.Activity uml2Activity = getUml2Activity();
		Iterator<org.eclipse.uml2.uml.ActivityNode> nodesIter = uml2Activity.getNodes().iterator();
		while (nodesIter.hasNext()) {
			ActivityNode currentNode = nodesIter.next();
			if (currentNode instanceof DecisionNode) {
				result.add((DecisionNode) currentNode);
			}
		}
		return result;
	}

	/**
	 * Gives all activity nodes of an activity
	 * 
	 * @return
	 */
	public EList<ActivityNode> getUml2ActivityNodes() {
		org.eclipse.uml2.uml.Activity uml2Activity = getUml2Activity();
		return uml2Activity.getNodes();
	}

	/**
	 * Gives all activity edges of an activity
	 * 
	 * @return
	 */
	public EList<ActivityEdge> getUml2ActivityEdges() {
		org.eclipse.uml2.uml.Activity uml2Activity = getUml2Activity();
		return uml2Activity.getEdges();
	}

	/**
	 * Gives all control flows of an activity
	 * 
	 * @return
	 */
	public ArrayList<ControlFlow> getUml2ControlFlows() {
		ArrayList<ControlFlow> result = new ArrayList<ControlFlow>();

		Iterator<ActivityEdge> edgesIter = getUml2ActivityEdges().iterator();
		while (edgesIter.hasNext()) {
			ActivityEdge currentEdge = edgesIter.next();
			if (currentEdge instanceof ControlFlow) {
				result.add((ControlFlow) currentEdge);
			}
		}
		return result;
	}

	/**
	 * Gives next node of sourceNode in the activity control flow
	 * 
	 * @param sourceNode
	 *            is the current node of the activity
	 * @return
	 */
	public ActivityNode getNextActivityNode(ActivityNode sourceNode) {
		ActivityNode nextNode = null;

		Iterator<ActivityEdge> edgesIter = sourceNode.getOutgoings().iterator();
		while (edgesIter.hasNext()) {
			ActivityEdge currentEdge = edgesIter.next();
			if (currentEdge instanceof ControlFlow) {
				nextNode = currentEdge.getTarget();
				return nextNode;
			}
		}
		return nextNode;
	}

	/**
	 * Gives the next activityNodes following a decision node
	 * 
	 * @param decisionNode
	 * @return
	 */
	public ArrayList<ActivityNode> getNextActivityNode(DecisionNode decisionNode) {
		ArrayList<ActivityNode> nextNodes = new ArrayList<ActivityNode>();

		DecisionNode thisDecision = null;

		Iterator<DecisionNode> decisionsIter = getUml2DecisionNodes().iterator();
		while (decisionsIter.hasNext()) {
			DecisionNode currentDecision = decisionsIter.next();
			if (currentDecision.equals(decisionNode)) {
				thisDecision = currentDecision;
			}
		}

		// decision node found
		if (thisDecision != null) {
			Iterator<ActivityEdge> edgesIter = thisDecision.getOutgoings().iterator();
			while (edgesIter.hasNext()) {
				nextNodes.add(edgesIter.next().getTarget()); // adding target activityNode to the result
			}
		}

		return nextNodes;
	}

}
