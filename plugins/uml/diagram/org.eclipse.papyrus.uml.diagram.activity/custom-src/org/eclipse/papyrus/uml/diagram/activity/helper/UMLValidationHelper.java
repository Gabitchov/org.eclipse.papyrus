/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.activity.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;

public class UMLValidationHelper {

	/**
	 * Exception Handler constraint define in From UML Superstructure Version 2.4.1 with change bars
	 */
	private static final String EXCEPTION_HANDLER_CONSTRAINT_2 = "An edge that has a source in an exception handler structured node must also have its target in the handler, and vice versa.";

	/**
	 * Exception Handler constraint define in From UML Superstructure Version 2.4.1 with change bars
	 */
	private static final String EXCEPTION_HANDLER_CONSTRAINT_3 = "If the protected node is a StructuredActivityNode with output pins, then the exception handler body must also be a StructuredActivityNode with output pins that correspond in number and types to those of the protected node.";

	/**
	 * Exception Handler constraint define in From UML Superstructure Version 2.4.1 with change bars
	 */
	private static final String EXCEPTION_HANDLER_CONSTRAINT_4 = "The handler body has one input, and that input is the same as the exception input";

	/**
	 * Exception Handler constraint define in From UML Superstructure Version 2.4.1 with change bars
	 */
	private static final String EXCEPTION_HANDLER_CONSTRAINT_1 = "The exception handler and its input object node are not the source or target of any edge.";

	/**
	 * The source and target of an edge must be in the same activity as the
	 * edge.
	 * 
	 * @param context
	 *        The receiving '<em><b>Activity Edge</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateSourceAndTarget(ActivityEdge context, IValidationContext ctx) {
		Activity edgeActivity = context.getActivity();
		if(edgeActivity == null) {
			// edge is contained by activity or group. Its activity is by
			// consequence a parent of it
			Element edgeOwner = context.getOwner();
			while(edgeOwner != null && !(edgeOwner instanceof Activity)) {
				edgeOwner = edgeOwner.getOwner();
			}
			if(edgeOwner instanceof Activity) {
				edgeActivity = (Activity)edgeOwner;
			} else {
				// this case should not occur. But in such a case, model is
				// invalid for another
				// reason
				return ctx.createSuccessStatus();
			}
		}
		ActivityNode source = context.getSource();
		ActivityNode target = context.getTarget();
		if(source != null && target != null) {
			Activity sourceActivity = source.getActivity();
			if(sourceActivity == null) {
				// activity node is contained by activity or group. Its activity
				// is by consequence a
				// parent of it
				Element sourceOwner = source.getOwner();
				while(sourceOwner != null && !(sourceOwner instanceof Activity)) {
					sourceOwner = sourceOwner.getOwner();
				}
				if(sourceOwner instanceof Activity) {
					sourceActivity = (Activity)sourceOwner;
				} else {
					// this case should not occur. But in such a case, model is
					// invalid for another
					// reason
					return ctx.createSuccessStatus();
				}
			}
			Activity targetActivity = target.getActivity();
			if(targetActivity == null) {
				// activity node is contained by activity or group. Its activity
				// is by consequence a
				// parent of it
				Element targetOwner = target.getOwner();
				while(targetOwner != null && !(targetOwner instanceof Activity)) {
					targetOwner = targetOwner.getOwner();
				}
				if(targetOwner instanceof Activity) {
					targetActivity = (Activity)targetOwner;
				} else {
					// this case should not occur. But in such a case, model is
					// invalid for another
					// reason
					return ctx.createSuccessStatus();
				}
			}
			if(!edgeActivity.equals(sourceActivity) || !edgeActivity.equals(targetActivity)) {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Implementation of the constraint
	 * [1] Interrupting edges of a region must have their source node in the region and their target node outside the region in the
	 * same activity containing the region.
	 * From UML Superstructure Version 2.4.1 with change bars
	 * USE for validation framework
	 * 
	 * @param context
	 * @param ctx
	 * @param interrupts
	 * @return
	 */
	public static IStatus validateInterruptibleEdge(ActivityEdge context, IValidationContext ctx) {
		return validateInterruptibleEdge(context, context.getInterrupts()) ? ctx.createSuccessStatus() : ctx.createFailureStatus("Interrupting edges of a region must have their source node in the region and their target node outside the region in the same activity containing the region.");//
	}

	/**
	 * Implementation of the constraint on Exception Handler:
	 * [2] An edge that has a source in an exception handler structured node must also have its target in the handler, and vice versa.
	 * 
	 * @param context
	 * @param ctx
	 * @return
	 */
	public static IStatus validateException_StructuredActivityNode_Constraint2(ActivityEdge context, IValidationContext ctx) {
		/*
		 * Test the constraint un Exception handler section from Version 2.4.1 with change bars
		 * [2] An edge that has a source in an exception handler structured node must also have its target in the handler, and vice versa.
		 */
		ActivityNode source = context.getSource();
		ActivityNode target = context.getTarget();
		if(source != null && target != null) {
			StructuredActivityNode inStrucActNode = source.getInStructuredNode();
			if(inStrucActNode != null) {
				if(!inStrucActNode.equals(target.getInStructuredNode())) {
					return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_2);
				}
			} else {
				if(target.getInStructuredNode() != null) {
					return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_2);
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Implementation of the constraint on Exception Handler:
	 * [4] The handler body has one input, and that input is the same as the exception input
	 * 
	 * @param context
	 * @param ctx
	 * @return
	 */
	public static IStatus validateException_HandlerBody_Constraint4(ExceptionHandler context, IValidationContext ctx) {
		ExecutableNode handlerBody = context.getHandlerBody();
		/*
		 * [4] The handler body has one input, and that input is the same as the exception input
		 */
		if(handlerBody != null) {
			if(handlerBody instanceof Action) {
				Action handlerBodyAction = (Action)handlerBody;
				if(handlerBodyAction.getInputs() == null || handlerBodyAction.getInputs().size() != 1) {
					return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_4);//
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Implementation of the constraint:
	 * [3] If the protected node is a StructuredActivityNode with output pins, then the exception handler body must also be a
	 * StructuredActivityNode with output pins that correspond in number and types to those of the protected node.
	 * 
	 * @param context
	 * @param ctx
	 * @return
	 */
	public static IStatus validateException_SourceAndTargetEdge_Constraint1(ExceptionHandler context, IValidationContext ctx) {
		/*
		 * [1] The exception handler and its input object node are not the source or target of any edge.
		 */
		ObjectNode exceptionInput = context.getExceptionInput();
		if(exceptionInput != null) {
			EList<ActivityEdge> incominEdges = exceptionInput.getIncomings();
			EList<ActivityEdge> outgoingEdges = exceptionInput.getOutgoings();
			if((incominEdges != null && incominEdges.size() != 0) || (outgoingEdges != null && outgoingEdges.size() != 0)) {
				return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_1);
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Implementation of the constraint:
	 * [3] If the protected node is a StructuredActivityNode with output pins, then the exception handler body must also be a
	 * StructuredActivityNode with output pins that correspond in number and types to those of the protected node.
	 * 
	 * @param context
	 * @param ctx
	 * @return
	 */
	public static IStatus validateException_StructuredActivityNode_Constraint3(ExceptionHandler context, IValidationContext ctx) {
		/*
		 * [3] If the protected node is a StructuredActivityNode with output pins, then the exception handler body must also be a
		 * StructuredActivityNode with output pins that correspond in number and types to those of the protected node.
		 */
		ExecutableNode protectedNode = context.getProtectedNode();
		ExecutableNode handlerBody = context.getHandlerBody();
		if(protectedNode != null && handlerBody != null) {
			if(protectedNode instanceof StructuredActivityNode) {
				StructuredActivityNode structuredActNode = (StructuredActivityNode)protectedNode;
				if(handlerBody instanceof StructuredActivityNode) {
					EList<OutputPin> protectedNodeOutputPin = structuredActNode.getOutputs();
					EList<OutputPin> handlerBodyOutputPin = ((StructuredActivityNode)handlerBody).getOutputs();
					if(protectedNodeOutputPin.size() != handlerBodyOutputPin.size()) {
						return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_3);
					}
					for(int i = 0; i < protectedNodeOutputPin.size(); i++) {
						OutputPin outputPin = protectedNodeOutputPin.get(i);
						if(outputPin != null && outputPin.equals(handlerBodyOutputPin.get(i))) {
							return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_3);
						}
					}
				} else if(handlerBody != null) {
					return ctx.createFailureStatus(EXCEPTION_HANDLER_CONSTRAINT_3);
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Implementation of the constraint
	 * [1] Interrupting edges of a region must have their source node in the region and their target node outside the region in the
	 * same activity containing the region.
	 * From UML Superstructure Version 2.4.1 with change bars
	 * 
	 * @param context
	 * @param ctx
	 * @param interrupts
	 * @return
	 */
	public static boolean validateInterruptibleEdge(ActivityEdge context, InterruptibleActivityRegion interrupts) {
		if(interrupts != null) {
			//validate source
			Element source = context.getSource();
			boolean validSource = false;
			while(source instanceof ActivityNode && !validSource) {
				if(((ActivityNode)source).getInInterruptibleRegions().contains(interrupts)) {
					validSource = true;
				}
				source = source.getOwner();
			}
			if(!validSource) {
				return false;
			}
			//validate target
			Element target = context.getTarget();
			while(target instanceof ActivityNode) {
				if(((ActivityNode)target).getInInterruptibleRegions().contains(interrupts)) {
					return false;
				}
				target = target.getOwner();
			}
		}
		return true;
	}

	/**
	 * Object nodes connected by an object flow, with optionally intervening
	 * control nodes, must have compatible types. In particular, the downstream
	 * object node type must be the same or a supertype of the upstream object
	 * node type.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Flow</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateCompatibleTypes(ObjectFlow context, IValidationContext ctx) {
		/*
		 * In case object flow have transformation behavior, the basic
		 * constraint (which describes general case only) does not need to be
		 * respected. In such a case Type consistency is checked by
		 * validateTransformationBehaviour. The UML specification is not very
		 * precise on this point. The constraint must be relaxed when a
		 * transformation interferes.
		 */
		if(context.getTransformation() == null) {
			List<Type> srcTypes = getUpstreamExpectedTypes(context, new LinkedList<ObjectFlow>());
			for(Type srcType : srcTypes) {
				for(Type targetType : getDownstreamExpectedTypes(context, new LinkedList<ObjectFlow>())) {
					if(!isSuperType(targetType, srcType)) {
						return ctx.createFailureStatus();
					}
				}
			}
		}
		// if there is a transformation, validateTransformationBehaviour
		// applies.
		return ctx.createSuccessStatus();
	}

	/**
	 * Object nodes connected by an object flow, with optionally intervening
	 * control nodes, must have the same upper bounds.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Flow</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateSameUpperBounds(ObjectFlow context, IValidationContext ctx) {
		ActivityNode source = context.getSource();
		if(source instanceof ObjectNode) {
			ValueSpecification srcUpper = ((ObjectNode)source).getUpperBound();
			for(ObjectNode targetNode : getDownStreamObjectNodes(context)) {
				ValueSpecification targetUpper = targetNode.getUpperBound();
				if(!EcoreUtil.equals(srcUpper, targetUpper)) {
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * An edge with constant weight may not target an object node, or lead to an
	 * object node downstream with no intervening actions, that has an upper
	 * bound less than the weight.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Flow</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateTarget(ObjectFlow context, IValidationContext ctx) {
		int weight = 0;
		try {
			if(context.getWeight() != null) {
				weight = context.getWeight().integerValue();
			} else {
				// no weight specified
				return ctx.createSuccessStatus();
			}
		} catch (UnsupportedOperationException noValueExc) {
			return ctx.createSuccessStatus();
		}
		for(ObjectNode targetNode : getDownStreamObjectNodes(context)) {
			int targetUpper = 0;
			try {
				if(targetNode.getUpperBound() != null) {
					targetUpper = targetNode.getUpperBound().integerValue();
				} else {
					// no upper bound specified
					continue;
				}
			} catch (UnsupportedOperationException noValueExc) {
				continue;
			}
			if(targetUpper < weight) {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * A transformation behavior has one input parameter and one output
	 * parameter. The input parameter must be the same as or a supertype of the
	 * type of object token coming from the source end. The output parameter
	 * must be the same or a subtype of the type of object token expected
	 * downstream. The behavior cannot have side effects.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Flow</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateTransformationBehaviour(ObjectFlow context, IValidationContext ctx) {
		Behavior transformation = context.getTransformation();
		if(transformation != null) {
			int numberIn = 0;
			int numberOut = 0;
			Parameter paramIn = null;
			Parameter paramOut = null;
			for(Parameter param : transformation.getOwnedParameters()) {
				switch(param.getDirection()) {
				case IN_LITERAL:
					numberIn++;
					paramIn = param;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					numberOut++;
					paramOut = param;
					break;
				case INOUT_LITERAL:
					numberIn++;
					paramIn = param;
					numberOut++;
					paramOut = param;
					break;
				}
			}
			if(numberIn != 1 || numberOut != 1) {
				return ctx.createFailureStatus();
			}
			// check types coming in the flow
			List<Type> srcTypes = getUpstreamExpectedTypes(context, new LinkedList<ObjectFlow>());
			for(Type typeToCheck : srcTypes) {
				if(!isSuperType(paramIn.getType(), typeToCheck)) {
					ctx.createFailureStatus();
				}
			}
			// check types going out the flow
			List<Type> targetTypes = getDownstreamExpectedTypes(context, new LinkedList<ObjectFlow>());
			for(Type typeToCheck : targetTypes) {
				if(!isSuperType(typeToCheck, paramOut.getType())) {
					ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * A selection behavior has one input parameter and one output parameter.
	 * The input parameter must be a bag of elements of the same as or a
	 * supertype of the type of source object node. The output parameter must be
	 * the same or a subtype of the type of source object node. The behavior
	 * cannot have side effects.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Flow</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateInputAndOutputParameter(ObjectFlow context, IValidationContext ctx) {
		Behavior selection = context.getSelection();
		if(selection != null) {
			int numberIn = 0;
			int numberOut = 0;
			Parameter paramIn = null;
			Parameter paramOut = null;
			for(Parameter param : selection.getOwnedParameters()) {
				switch(param.getDirection()) {
				case IN_LITERAL:
					numberIn++;
					paramIn = param;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					numberOut++;
					paramOut = param;
					break;
				case INOUT_LITERAL:
					numberIn++;
					paramIn = param;
					numberOut++;
					paramOut = param;
					break;
				}
			}
			if(numberIn != 1 || numberOut != 1) {
				return ctx.createFailureStatus();
			}
			// check types coming in the flow
			List<Type> srcTypes = getUpstreamExpectedTypes(context, new LinkedList<ObjectFlow>());
			for(Type typeToCheck : srcTypes) {
				if(!isSuperType(paramIn.getType(), typeToCheck)) {
					ctx.createFailureStatus();
				}
			}
			// check types going out the flow
			List<Type> targetTypes = getDownstreamExpectedTypes(context, new LinkedList<ObjectFlow>());
			for(Type typeToCheck : targetTypes) {
				if(!isSuperType(typeToCheck, paramOut.getType())) {
					ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * The type of value specification must be compatible with the type of the
	 * value pin.
	 * 
	 * @param context
	 *        The receiving '<em><b>Value Pin</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateCompatibleType(ValuePin context, IValidationContext ctx) {
		ValueSpecification value = context.getValue();
		if(value != null) {
			if(!isSuperType(context.getType(), value.getType())) {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * If the decision node has no decision input flow and an incoming object
	 * flow, then a decision input behavior has one input parameter whose type
	 * is the same as or a supertype of the type of object tokens offered on the
	 * incoming edge.
	 * 
	 * @param context
	 *        The receiving '<em><b>Decision Node</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateIncomingObjectOneInputParameter(DecisionNode context, IValidationContext ctx) {
		Behavior behavior = context.getDecisionInput();
		if(behavior != null) {
			ObjectFlow decisionInputFlow = context.getDecisionInputFlow();
			ActivityEdge incomingObjectFlow = context.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow());
			if(decisionInputFlow == null && incomingObjectFlow != null) {
				ObjectFlow inFlow = (ObjectFlow)incomingObjectFlow;
				/*
				 * No decision input flow and an incoming object flow. There
				 * must be 1 in parameter with type compatibility with
				 * incomingObjectFlow
				 */
				boolean parameterFound = false;
				for(Parameter param : behavior.getOwnedParameters()) {
					if(ParameterDirectionKind.IN_LITERAL.equals(param.getDirection())) {
						if(!parameterFound) {
							// recover type coming from the flow
							List<Type> types = getTypeComingFromFlow(inFlow, new LinkedList<ObjectFlow>());
							for(Type comingType : types) {
								if(!isSuperType(param.getType(), comingType)) {
									// type of the parameter is not compatible
									// with incoming edge
									return ctx.createFailureStatus();
								}
							}
						} else {
							// unexpected second input parameter
							return ctx.createFailureStatus();
						}
					}
				}
				if(!parameterFound) {
					// expected input parameter not found
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * If the decision node has a decision input flow and an incoming control
	 * flow, then a decision input behavior has one input parameter whose type
	 * is the same as or a supertype of the type of object tokens offered on the
	 * decision input flow.
	 * 
	 * @param context
	 *        The receiving '<em><b>Decision Node</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateIncomingControlOneInputParameter(DecisionNode context, IValidationContext ctx) {
		Behavior behavior = context.getDecisionInput();
		if(behavior != null) {
			ObjectFlow decisionInputFlow = context.getDecisionInputFlow();
			ActivityEdge incomingControlFlow = context.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
			if(decisionInputFlow != null && incomingControlFlow != null) {
				/*
				 * Decision input flow and an incoming control flow. There must
				 * be 1 in parameter with type compatibility with
				 * decisionInputFlow
				 */
				boolean parameterFound = false;
				for(Parameter param : behavior.getOwnedParameters()) {
					if(ParameterDirectionKind.IN_LITERAL.equals(param.getDirection())) {
						if(!parameterFound) {
							// recover type coming from the flow
							List<Type> types = getTypeComingFromFlow(decisionInputFlow, new LinkedList<ObjectFlow>());
							for(Type comingType : types) {
								if(!isSuperType(param.getType(), comingType)) {
									// type of the parameter is not compatible
									// with incoming edge
									return ctx.createFailureStatus();
								}
							}
							parameterFound = true;
						} else {
							// unexpected second input parameter
							return ctx.createFailureStatus();
						}
					}
				}
				if(!parameterFound) {
					// expected input parameter not found
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * If the decision node has a decision input flow and an second incoming
	 * object flow, then a decision input behavior has two input parameters, the
	 * first of which has a type that is the same as or a supertype of the type
	 * of the type of object tokens offered on the nondecision input flow and
	 * the second of which has a type that is the same as or a supertype of the
	 * type of object tokens offered on the decision input flow.
	 * 
	 * @param context
	 *        The receiving '<em><b>Decision Node</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateTwoInputParameters(DecisionNode context, IValidationContext ctx) {
		Behavior behavior = context.getDecisionInput();
		if(behavior != null) {
			ObjectFlow decisionInputFlow = context.getDecisionInputFlow();
			ActivityEdge incomingObjectFlow = null;
			for(ActivityEdge incomingEdge : context.getIncomings()) {
				// filter the decision flow
				if(incomingEdge instanceof ObjectFlow && incomingEdge != decisionInputFlow) {
					incomingObjectFlow = incomingEdge;
				}
			}
			if(decisionInputFlow != null && incomingObjectFlow != null) {
				ObjectFlow inFlow = (ObjectFlow)incomingObjectFlow;
				/*
				 * Decision input flow and an other incoming object flow. There
				 * must be 2 in parameters with type compatibility with each
				 * flow
				 */
				int numberOfParameterFound = 0;
				for(Parameter param : behavior.getOwnedParameters()) {
					if(ParameterDirectionKind.IN_LITERAL.equals(param.getDirection())) {
						if(numberOfParameterFound == 0) {
							// recover type coming from the non decision flow
							List<Type> types = getTypeComingFromFlow(inFlow, new LinkedList<ObjectFlow>());
							for(Type comingType : types) {
								if(!isSuperType(param.getType(), comingType)) {
									// type of the parameter is not compatible
									// with incoming edge
									return ctx.createFailureStatus();
								}
							}
							numberOfParameterFound++;
						} else if(numberOfParameterFound == 1) {
							// recover type coming from the decision flow
							List<Type> types = getTypeComingFromFlow(decisionInputFlow, new LinkedList<ObjectFlow>());
							for(Type comingType : types) {
								if(!isSuperType(param.getType(), comingType)) {
									// type of the parameter is not compatible
									// with incoming edge
									return ctx.createFailureStatus();
								}
							}
							numberOfParameterFound++;
						} else {
							// unexpected third input parameter
							return ctx.createFailureStatus();
						}
					}
				}
				if(numberOfParameterFound < 2) {
					// expected input parameters not found
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * A selection behavior has one input parameter and one output parameter.
	 * The input parameter must be a bag of elements of the same type as the
	 * object node or a supertype of the type of object node. The output
	 * parameter must be the same or a subtype of the type of object node. The
	 * behavior cannot have side effects.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Node</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateInputOutputParameter(ObjectNode context, IValidationContext ctx) {
		Behavior selection = context.getSelection();
		if(selection != null) {
			Parameter inParam = null;
			Parameter outParam = null;
			for(Parameter param : selection.getOwnedParameters()) {
				switch(param.getDirection()) {
				case IN_LITERAL:
					if(inParam != null) {
						// second input found
						return ctx.createFailureStatus();
					}
					inParam = param;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					if(outParam != null) {
						// second output found
						return ctx.createFailureStatus();
					}
					outParam = param;
					break;
				case INOUT_LITERAL:
					if(inParam != null) {
						// second input found
						return ctx.createFailureStatus();
					}
					inParam = param;
					if(outParam != null) {
						// second output found
						return ctx.createFailureStatus();
					}
					outParam = param;
					break;
				}
			}
			if(inParam == null || outParam == null) {
				// missing a parameter
				return ctx.createFailureStatus();
			}
			// check type compatibility
			if(!isSuperType(inParam.getType(), context.getType())) {
				return ctx.createFailureStatus();
			}
			if(!isSuperType(context.getType(), outParam.getType())) {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Check that type is compatible with the first one as parent
	 * 
	 * @param superType
	 *        the type which should be supertype
	 * @param childType
	 *        the type which should be at lower level
	 * @return true if superType is a supertype of childType or if one of them
	 *         is null
	 */
	private static boolean isSuperType(Type superType, Type childType) {
		if(superType == null || childType == null) {
			return true;
		}
		return childType.conformsTo(superType);
	}

	/**
	 * Get all object nodes which are downstream this object flow. These are the
	 * target of the object flow, eventually by the intermediate of control
	 * nodes.
	 * 
	 * @param objectFlow
	 *        the object flow to explore
	 * @return list of object nodes downstream
	 */
	private static List<ObjectNode> getDownStreamObjectNodes(ObjectFlow objectFlow) {
		ActivityNode target = objectFlow.getTarget();
		if(target instanceof ObjectNode) {
			return Collections.singletonList((ObjectNode)target);
		} else if(target instanceof ControlNode) {
			List<ObjectNode> result = new LinkedList<ObjectNode>();
			for(ActivityEdge outgoingEdge : target.getOutgoings()) {
				if(outgoingEdge instanceof ObjectFlow && !outgoingEdge.equals(objectFlow)) {
					result.addAll(getDownStreamObjectNodes((ObjectFlow)outgoingEdge));
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the type which should be expected upstream an object flow
	 * (considering the source)
	 * 
	 * @param objectFlow
	 *        the object flow
	 * @param alreadyMetObjectFlows
	 *        the list of object flows which have already been visited to
	 *        avoid loops. Callers shall pass new LinkedList<ObjectFlow>()
	 * @return the list of types according to different incoming flows
	 *         (unspecified types omitted).
	 */
	private static List<Type> getUpstreamExpectedTypes(ObjectFlow objectFlow, List<ObjectFlow> alreadyMetObjectFlows) {
		ActivityNode src = objectFlow.getSource();
		// handle loops
		if(alreadyMetObjectFlows.contains(objectFlow)) {
			// We are engaged on a loop of object flows. Break it now.
			return Collections.emptyList();
		} else {
			alreadyMetObjectFlows.add(objectFlow);
		}
		// recover incoming types
		if(src instanceof ObjectNode) {
			// type of source object node
			Type type = ((ObjectNode)src).getType();
			if(type != null) {
				return Collections.singletonList(type);
			} else {
				return Collections.emptyList();
			}
		} else if(src instanceof ControlNode) {
			// type coming to the control node from object flows
			List<Type> result = new LinkedList<Type>();
			for(ActivityEdge incomingEdge : src.getIncomings()) {
				if(incomingEdge instanceof ObjectFlow) {
					ObjectFlow incomingFlow = (ObjectFlow)incomingEdge;
					// get the types the incoming flow sends
					result.addAll(getTypeComingFromFlow(incomingFlow, alreadyMetObjectFlows));
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the type which should be expected downstream an object flow
	 * (considering the target)
	 * 
	 * @param objectFlow
	 *        the object flow
	 * @param alreadyMetObjectFlows
	 *        the list of object flows which have already been visited to
	 *        avoid loops. Callers shall pass new LinkedList<ObjectFlow>()
	 * @return the list of types according to different outgoing flows
	 *         (unspecified types omitted).
	 */
	private static List<Type> getDownstreamExpectedTypes(ObjectFlow objectFlow, List<ObjectFlow> alreadyMetObjectFlows) {
		ActivityNode target = objectFlow.getTarget();
		// handle loops
		if(alreadyMetObjectFlows.contains(objectFlow)) {
			// We are engaged on a loop of object flows. Break it now.
			return Collections.emptyList();
		} else {
			alreadyMetObjectFlows.add(objectFlow);
		}
		// recover outgoing types
		if(target instanceof ObjectNode) {
			// type of target object node
			Type type = ((ObjectNode)target).getType();
			if(type != null) {
				return Collections.singletonList(type);
			} else {
				return Collections.emptyList();
			}
		} else if(target instanceof ControlNode) {
			// type coming to the control node from object flows
			List<Type> result = new LinkedList<Type>();
			for(ActivityEdge outgoingEdge : target.getOutgoings()) {
				if(outgoingEdge instanceof ObjectFlow) {
					ObjectFlow outgoingFlow = (ObjectFlow)outgoingEdge;
					// get the types the outgoing flow expects
					result.addAll(getTypeExpectedByFlow(outgoingFlow, alreadyMetObjectFlows));
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the types which an object flow sends (considering itself and its
	 * source)
	 * 
	 * @param inputFlow
	 *        the object flow
	 * @param alreadyMetObjectFlows
	 *        the list of object flows which have already been visited to
	 *        avoid loops. Callers shall pass new LinkedList<ObjectFlow>()
	 * @return the list of types according to different incoming flows
	 *         (unspecified types omitted).
	 */
	private static List<Type> getTypeComingFromFlow(ObjectFlow inputFlow, List<ObjectFlow> alreadyMetObjectFlows) {
		List<Type> result = new LinkedList<Type>();
		if(inputFlow.getTransformation() == null && inputFlow.getSelection() == null) {
			// type coming from other object flows' sources
			result.addAll(getUpstreamExpectedTypes(inputFlow, alreadyMetObjectFlows));
		} else if(inputFlow.getTransformation() != null) {
			// type coming from other object flows' transformation behavior
			for(Parameter transfParam : inputFlow.getTransformation().getOwnedParameters()) {
				switch(transfParam.getDirection()) {
				case IN_LITERAL:
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
				case INOUT_LITERAL:
					if(transfParam.getType() != null) {
						result.add(transfParam.getType());
					}
					break;
				}
			}
		} else if(inputFlow.getSelection() != null) {
			// type coming from other object flows' selection behavior
			for(Parameter selParam : inputFlow.getSelection().getOwnedParameters()) {
				switch(selParam.getDirection()) {
				case IN_LITERAL:
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
				case INOUT_LITERAL:
					if(selParam.getType() != null) {
						result.add(selParam.getType());
					}
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Get the types which an object flow handles (considering itself and its
	 * target)
	 * 
	 * @param outputFlow
	 *        the object flow
	 * @param alreadyMetObjectFlows
	 *        the list of object flows which have already been visited to
	 *        avoid loops. Callers shall pass new LinkedList<ObjectFlow>()
	 * @return the list of types according to different outgoing flows
	 *         (unspecified types omitted).
	 */
	private static List<Type> getTypeExpectedByFlow(ObjectFlow outputFlow, List<ObjectFlow> alreadyMetObjectFlows) {
		List<Type> result = new LinkedList<Type>();
		if(outputFlow.getTransformation() == null) {
			// type coming from other object flows' targets
			result.addAll(getDownstreamExpectedTypes(outputFlow, alreadyMetObjectFlows));
		} else {
			// type coming from other object flows' transformation behavior
			for(Parameter transfParam : outputFlow.getTransformation().getOwnedParameters()) {
				switch(transfParam.getDirection()) {
				case IN_LITERAL:
				case INOUT_LITERAL:
					if(transfParam.getType() != null) {
						result.add(transfParam.getType());
					}
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					break;
				}
			}
		}
		return result;
	}

	enum Direction {
		IN, OUT
	};

	/**
	 * Validate Call Operation Action,
	 * the validity of the parameters with pins
	 * 
	 * @param action
	 * @param ctx
	 * @return OK_STATUS if paramters and pins are synchronised
	 */
	@PinAndParameterSynchronizeValidator
	public static IStatus validateCallOperation(CallOperationAction action, IValidationContext ctx) {
		if(action.getOperation() == null) {
			return ctx.createFailureStatus(String.format("%s does not have operation", action.getName()));
		}
		// in check
		List<Parameter> ins = getParameters(action.getOperation(), Direction.IN);
		EList<InputPin> inputs = action.getArguments();
		if(ins.size() != inputs.size()) {
			return ctx.createFailureStatus(String.format("pins of %s does not have the same number of input pins as input parameters of the operation %s", action.getName(), action.getOperation().getName()));
		}
		int index = 0;
		for(Parameter p : ins) {
			IStatus status = validatePin(index, p, inputs, ctx);
			if(!status.isOK()) {
				return status;
			}
			index++;
		}
		// out check
		List<Parameter> outs = getParameters(action.getOperation(), Direction.OUT);
		int indexOuts = 0;
		EList<OutputPin> outputs = action.getOutputs();
		if(outs.size() != outputs.size()) {
			return ctx.createFailureStatus(String.format("pins of %s does not have the same number of output pins as output parameters of the operation %s", action.getName(), action.getOperation().getName()));
		}
		for(Parameter p : outs) {
			IStatus status = validatePin(indexOuts, p, outputs, ctx);
			if(!status.isOK()) {
				return status;
			}
			indexOuts++;
		}
		// chic type check
		return Status.OK_STATUS;
	}

	private static IStatus validatePin(int index, Parameter p, EList<? extends Pin> inputs, IValidationContext ctx) {
		Pin pin = inputs.get(index);
		for(EStructuralFeature a : pin.eClass().getEAllStructuralFeatures()) {
			EStructuralFeature feature = getFeature(a.getName(), p.eClass());
			if(!a.isDerived() && a.isChangeable() && feature != null) {
				if(!pin.eGet(a).equals(p.eGet(feature))) {
					return ctx.createFailureStatus(String.format("attribute %s and attribute %s are different for pin %s", a.getName(), feature.getName(), pin.getName()));
				}
			}
		}
		// check type
		if((pin.getType() == null || p.getType() == null) && p.getType() != pin.getType()) {
			return ctx.createFailureStatus(String.format("type of pin %s is different the parameter %s", pin.getName(), p.getName()));
		}
		if(pin.getType() != null && !pin.getType().conformsTo(p.getType())) {
			return ctx.createFailureStatus(String.format("type of pin %s is not compatible with the parameter %s", pin.getName(), p.getName()));
		}
		return Status.OK_STATUS;
	}

	private static EStructuralFeature getFeature(String name, EClass eclass) {
		for(EStructuralFeature a : eclass.getEAllAttributes()) {
			if(a.getName() != null && a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}

	private static List<Parameter> getParameters(Operation operation, Direction theDirection) {
		List<Parameter> parameters = new ArrayList<Parameter>(operation.getOwnedParameters().size());
		for(Parameter p : operation.getOwnedParameters()) {
			if(theDirection == Direction.IN) {
				if(p.getDirection() == ParameterDirectionKind.IN_LITERAL || p.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
					parameters.add(p);
				}
			} else if(theDirection == Direction.OUT) {
				if(p.getDirection() == ParameterDirectionKind.OUT_LITERAL || p.getDirection() == ParameterDirectionKind.INOUT_LITERAL || p.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
					parameters.add(p);
				}
			}
		}
		return parameters;
	}
}
