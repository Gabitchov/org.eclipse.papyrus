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
package org.eclipse.papyrus.diagram.activity.helper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;


public class UMLValidationHelper {

	/**
	 * The source and target of an edge must be in the same activity as the edge.
	 * 
	 * @param context
	 *        The receiving '<em><b>Activity Edge</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateSourceAndTarget(ActivityEdge context, IValidationContext ctx) {
		Activity edgeActivity = context.getActivity();
		if(edgeActivity == null) {
			// edge is contained by activity or group. Its activity is by consequence a parent of it
			Element edgeOwner = context.getOwner();
			while(edgeOwner != null && !(edgeOwner instanceof Activity)) {
				edgeOwner = edgeOwner.getOwner();
			}
			if(edgeOwner instanceof Activity) {
				edgeActivity = (Activity)edgeOwner;
			} else {
				// this case should not occur. But in such a case, model is invalid for another reason
				return ctx.createSuccessStatus();
			}
		}
		ActivityNode source = context.getSource();
		ActivityNode target = context.getTarget();
		if(source != null && target != null) {
			Activity sourceActivity = source.getActivity();
			if(sourceActivity == null) {
				// activity node is contained by activity or group. Its activity is by consequence a parent of it
				Element sourceOwner = source.getOwner();
				while(sourceOwner != null && !(sourceOwner instanceof Activity)) {
					sourceOwner = sourceOwner.getOwner();
				}
				if(sourceOwner instanceof Activity) {
					sourceActivity = (Activity)sourceOwner;
				} else {
					// this case should not occur. But in such a case, model is invalid for another reason
					return ctx.createSuccessStatus();
				}
			}
			Activity targetActivity = target.getActivity();
			if(targetActivity == null) {
				// activity node is contained by activity or group. Its activity is by consequence a parent of it
				Element targetOwner = target.getOwner();
				while(targetOwner != null && !(targetOwner instanceof Activity)) {
					targetOwner = targetOwner.getOwner();
				}
				if(targetOwner instanceof Activity) {
					targetActivity = (Activity)targetOwner;
				} else {
					// this case should not occur. But in such a case, model is invalid for another reason
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
	 * Object nodes connected by an object flow, with optionally intervening control nodes, must have compatible types. In particular, the downstream
	 * object node type must be the same or a supertype of the upstream object node type.
	 * 
	 * @param context
	 *        The receiving '<em><b>Object Flow</b></em>' model object.
	 * @param ctx
	 *        The cache of context-specific information.
	 */
	public static IStatus validateCompatibleTypes(ObjectFlow context, IValidationContext ctx) {
		/*
		 * In case object flow have transformation behavior, the basic constraint
		 * (which describes general case only) does not need to be respected.
		 * In such a case Type consistency is checked by validateTransformationBehaviour.
		 * The UML specification is not very precise on this point.
		 * The constraint must be relaxed when a transformation interferes.
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
		// if there is a transformation, validateTransformationBehaviour applies.
		return ctx.createSuccessStatus();
	}

	/**
	 * Object nodes connected by an object flow, with optionally intervening control nodes, must have the same upper bounds.
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
	 * An edge with constant weight may not target an object node, or lead to an object node downstream with no intervening actions, that has an upper
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
	 * A transformation behavior has one input parameter and one output parameter. The input parameter must be the same as or a supertype of the type
	 * of object token coming from the source end. The output parameter must be the same or a subtype of the type of object token expected downstream.
	 * The behavior cannot have side effects.
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
	 * A selection behavior has one input parameter and one output parameter. The input parameter must be a bag of elements of the same as or a
	 * supertype of the type of source object node. The output parameter must be the same or a subtype of the type of source object node. The behavior
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
	 * The type of value specification must be compatible with the type of the value pin.
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
	 * Check that type is compatible with the first one as parent
	 * 
	 * @param superType
	 *        the type which should be supertype
	 * @param childType
	 *        the type which should be at lower level
	 * @return true if superType is a supertype of childType or if one of them is null
	 */
	private static boolean isSuperType(Type superType, Type childType) {
		if(superType == null || childType == null) {
			return true;
		}
		return childType.conformsTo(superType);
	}

	/**
	 * Get all object nodes which are downstream this object flow. These are the target of the object flow, eventually by the intermediate of control
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
				if(outgoingEdge instanceof ObjectFlow) {
					result.addAll(getDownStreamObjectNodes((ObjectFlow)outgoingEdge));
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the type which should be expected upstream an object flow (considering the source)
	 * 
	 * @param objectFlow
	 *        the object flow
	 * @param alreadyMetObjectFlows
	 *        the list of object flows which have already been visited to avoid loops. Callers shall pass new LinkedList<ObjectFlow>()
	 * @return the list of types according to different incoming flows (unspecified types omitted).
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
					if(incomingFlow.getTransformation() == null && incomingFlow.getSelection() == null) {
						// type coming from other object flows' sources
						result.addAll(getUpstreamExpectedTypes(incomingFlow, alreadyMetObjectFlows));
					} else if(incomingFlow.getTransformation() != null) {
						// type coming from other object flows' transformation behavior
						for(Parameter transfParam : incomingFlow.getTransformation().getOwnedParameters()) {
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
					} else if(incomingFlow.getSelection() != null) {
						// type coming from other object flows' selection behavior
						for(Parameter selParam : incomingFlow.getSelection().getOwnedParameters()) {
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
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the type which should be expected downstream an object flow (considering the target)
	 * 
	 * @param objectFlow
	 *        the object flow
	 * @param alreadyMetObjectFlows
	 *        the list of object flows which have already been visited to avoid loops. Callers shall pass new LinkedList<ObjectFlow>()
	 * @return the list of types according to different outgoing flows (unspecified types omitted).
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
					if(outgoingFlow.getTransformation() == null) {
						// type coming from other object flows' sources
						result.addAll(getDownstreamExpectedTypes(outgoingFlow, alreadyMetObjectFlows));
					} else {
						// type coming from other object flows' transformation behavior
						for(Parameter transfParam : outgoingFlow.getTransformation().getOwnedParameters()) {
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
				}
			}
			return result;
		}
		return Collections.emptyList();
	}
}
