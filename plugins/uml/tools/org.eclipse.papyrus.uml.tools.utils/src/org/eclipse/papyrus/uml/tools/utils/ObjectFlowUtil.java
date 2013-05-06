/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Utility class for {@link ObjectFlow}
 */
public class ObjectFlowUtil {
	
	/**
	 * Return whether we can create a new object flow starting from this action by adding an intermediate output pin at it.
	 * 
	 * @param action
	 *        the action to start from
	 * @return whether action accept new output pin
	 */
	public static boolean canStartNewObjectFlow(Action action) {
		// CallOperationAction and CallBehaviorAction have pre-defined pins which are all represented.
		// SendObjectAction have only two input pins which are all represented.
		// SendSignalAction has only pre-defined input pins which are all represented.
		return (action instanceof OpaqueAction) || (action instanceof AcceptEventAction);
	}

	/**
	 * Return whether we can create a new object flow ending to this action by adding an intermediate input pin at it.
	 * 
	 * @param action
	 *        the action to end to
	 * @return whether action accept new input pin
	 */
	public static boolean canEndNewObjectFlow(Action action) {
		// CallOperationAction and CallBehaviorAction have pre-defined pins which are all represented.
		// SendObjectAction have only two input pins which are all represented.
		// SendSignalAction has only pre-defined input pins which are all represented.
		// AcceptEventAction has no input pin
		return action instanceof OpaqueAction;
	}
	
	/**
	 * Check condition on Object flows
	 * @param container container of the object flow
	 * @param linkInstance object flow itself
	 * @param source 
	 * @param target
	 * @return
	 */
	public static boolean canExistObjectFlow(Activity container, ObjectFlow linkInstance, ActivityNode source, ActivityNode target) {
		try {
			if(source instanceof Action) {
				// rule validateObjectFlow_validateNoActions
				// rule workaround by addition of pins in case of Action
				if(!ObjectFlowUtil.canStartNewObjectFlow((Action)source)) {
					return false;
				}
			}
			if(source instanceof InputPin) {
				// rule validateInputPin_validateOutgoingEdgesStructuredOnly
				if(source.getOwner() instanceof StructuredActivityNode) {
					if(target != null && !source.getOwner().equals(target.getInStructuredNode())) {
						return false;
					}
				} else {
					return false;
				}
			}
			if(source instanceof InitialNode) {
				// rule validateInitialNode_validateControlEdges
				return false;
			}
			if(source instanceof FinalNode) {
				// rule validateFinalNode_validateNoOutgoingEdges
				return false;
			}
			if(source instanceof JoinNode) {
				// rule validateJoinNode_validateOneOutgoingEdge
				if(!source.getOutgoings().isEmpty()) {
					return false;
				}
				/*
				 * rule validateJoinNode_validateIncomingObjectFlow :
				 * We do not prevent creation of an outgoing ObjectFlow even if there is no incoming ObjectFlow.
				 * We let the possibility that the user intends to add an incoming ObjectFlow later.
				 */
			}
			if(source instanceof ForkNode) {
				// rule validateForkNode_validateEdges on source Fork node
				ActivityEdge outgoingControlFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				ActivityEdge incomingControlFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null || incomingControlFlow != null) {
					// there is a ControlFlow which means there must be no ObjectFlow
					return false;
				}
			}
			if(source instanceof MergeNode) {
				//rule validateMergeNode_validateOneOutgoingEdge
				if(!source.getOutgoings().isEmpty()) {
					return false;
				}
				// rule validateMergeNode_validateEdges on source Merge node
				ActivityEdge outgoingControlFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				ActivityEdge incomingControlFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null || incomingControlFlow != null) {
					// there is a ControlFlow which means there must be no ObjectFlow
					return false;
				}
			}
			if(source instanceof DecisionNode) {
				// rule validateDecisionNode_validateEdges on source Decision node
				ActivityEdge outgoingControlFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				ActivityEdge incomingControlFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null || incomingControlFlow != null) {
					// there is a ControlFlow which means there must be no ObjectFlow
					return false;
				}
			}
			if(source instanceof ActivityParameterNode) {
				// rule validateActivityParameterNode_validateIncomingOrOutgoing
				EList<ActivityEdge> incomings = source.getIncomings();
				if(!incomings.isEmpty()) {
					return false;
				}
			}
			if(target instanceof Action) {
				// rule validateObjectFlow_validateNoActions
				// rule workaround by addition of pins in case of Action
				if(!ObjectFlowUtil.canEndNewObjectFlow((Action)target)) {
					return false;
				}
			}
			if(target instanceof OutputPin) {
				// rule validateOutputPin_validateIncomingEdgesStructuredOnly
				if(target.getOwner() instanceof StructuredActivityNode) {
					if(source != null && !target.getOwner().equals(source.getInStructuredNode())) {
						return false;
					}
				} else {
					return false;
				}
			}
			if(target instanceof InitialNode) {
				// rule validateInitialNode_validateNoIncomingEdges
				return false;
			}
			if(target instanceof JoinNode) {
				// rule validateJoinNode_validateIncomingObjectFlow
				ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null) {
					// the outgoing edge is a ControlFlow which means there must be no incoming ObjectFlow
					return false;
				}
			}
			if(target instanceof ForkNode) {
				// rule validateForkNode_validateOneIncomingEdge
				if(!target.getIncomings().isEmpty()) {
					return false;
				}
				// rule validateForkNode_validateEdges on target Fork node
				ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				ActivityEdge incomingControlFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null || incomingControlFlow != null) {
					// there is a ControlFlow which means there must be no ObjectFlow
					return false;
				}
			}
			if(target instanceof MergeNode) {
				// rule validateMergeNode_validateEdges on target Merge node
				ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				ActivityEdge incomingControlFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null || incomingControlFlow != null) {
					// there is a ControlFlow which means there must be no ObjectFlow
					return false;
				}
			}
			if(target instanceof DecisionNode) {
				// rule validateDecisionNode_validateIncomingOutgoingEdges
				if(target.getIncomings().size() >= 2) {
					// no more than two incoming edges
					return false;
				}
				// rule validateDecisionNode_validateEdges on target Decision node
				ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
				ActivityEdge incomingControlFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
				if(outgoingControlFlow != null || incomingControlFlow != null) {
					/*
					 * There is a ControlFlow which means there must be no
					 * ObjectFlow but the decision flow itself.
					 * We let the user insert up to one ObjectFlow for being
					 * able to select the decision flow among existing
					 * input flows.
					 */
					if(target.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow()) != null) {
						// there is already an object flow which is intended to become the decision flow
						return false;
					}
				}
			}
			if(target instanceof ActivityParameterNode) {
				// rule validateActivityParameterNode_validateIncomingOrOutgoing
				EList<ActivityEdge> outgoings = target.getOutgoings();
				if(!outgoings.isEmpty()) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			Activator.log.error(e);
			return false;
		}
	}

	/**
	 * Return whether a pin must be inserted to create a new object flow starting from this activity node.
	 * 
	 * @param node
	 *        the activity node to start from
	 * @return whether a pin must can inserted to create an object flow from this node
	 */
	public static boolean insertPinForStartingNewObjectFlow(ActivityNode node) {
		if(node instanceof Action) {
			return canStartNewObjectFlow((Action)node);
		}
		return false;
	}

	/**
	 * Return whether a pin must be inserted to create a new object flow ending to this activity node.
	 * 
	 * @param node
	 *        the activity node to end to
	 * @return whether a pin must can inserted to create an object flow to this node
	 */
	public static boolean insertPinForEndingNewObjectFlow(ActivityNode node) {
		if(node instanceof Action) {
			return canEndNewObjectFlow((Action)node);
		}
		return false;
	}

	/**
	 * Insert the created output pin in the parent action
	 * 
	 * @param parentAction
	 *        action to insert pin in
	 * @param outputPin
	 *        output pin to insert
	 */
	public static void insertOutputPin(Action parentAction, OutputPin outputPin) {
		if(parentAction instanceof OpaqueAction) {
			((OpaqueAction)parentAction).getOutputValues().add(outputPin);
		} else if(parentAction instanceof AcceptEventAction) {
			((AcceptEventAction)parentAction).getResults().add(outputPin);
		}
	}

	/**
	 * Insert the created input pin in the parent action
	 * 
	 * @param parentAction
	 *        action to insert pin in
	 * @param inputPin
	 *        input pin to insert
	 */
	public static void insertInputPin(Action parentAction, InputPin inputPin) {
		if(parentAction instanceof OpaqueAction) {
			((OpaqueAction)parentAction).getInputValues().add(inputPin);
		}
	}
}
