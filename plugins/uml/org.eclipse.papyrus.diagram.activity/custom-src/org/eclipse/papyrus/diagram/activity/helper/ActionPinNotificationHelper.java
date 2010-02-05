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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.adaptor.gmf.Activator;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * BorderContainerNotificationHelper is a particular NotificationHelper which manages the border editparts drawn on a particular part for particular
 * features. It automatically add or remove appropriate border parts when model is modified, so that all contained elements are represented once.
 */
public class ActionPinNotificationHelper extends NotificationHelper {

	/**
	 * Corresponding node types for OpaqueAction input pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> OPAQUEACTION_INPUT_TYPES;
	static {
		OPAQUEACTION_INPUT_TYPES = new HashMap<EClass, IHintedType>();
		OPAQUEACTION_INPUT_TYPES.put(UMLPackage.eINSTANCE.getValuePin(), (IHintedType)UMLElementTypes.ValuePin_3015);
		OPAQUEACTION_INPUT_TYPES.put(UMLPackage.eINSTANCE.getActionInputPin(), (IHintedType)UMLElementTypes.ActionInputPin_3016);
		OPAQUEACTION_INPUT_TYPES.put(UMLPackage.eINSTANCE.getInputPin(), (IHintedType)UMLElementTypes.InputPin_3013);
	}

	/**
	 * Corresponding node types for OpaqueAction output pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> OPAQUEACTION_OUTPUT_TYPES;
	static {
		OPAQUEACTION_OUTPUT_TYPES = new HashMap<EClass, IHintedType>();
		OPAQUEACTION_OUTPUT_TYPES.put(UMLPackage.eINSTANCE.getOutputPin(), (IHintedType)UMLElementTypes.OutputPin_3014);
	}

	/**
	 * Corresponding node types for CallBehaviorAction argument pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> CALLBEHAVIORACTION_ARGUMENT_TYPES;
	static {
		CALLBEHAVIORACTION_ARGUMENT_TYPES = new HashMap<EClass, IHintedType>();
		CALLBEHAVIORACTION_ARGUMENT_TYPES.put(UMLPackage.eINSTANCE.getValuePin(), (IHintedType)UMLElementTypes.ValuePin_3017);
		CALLBEHAVIORACTION_ARGUMENT_TYPES.put(UMLPackage.eINSTANCE.getActionInputPin(), (IHintedType)UMLElementTypes.ActionInputPin_3018);
		CALLBEHAVIORACTION_ARGUMENT_TYPES.put(UMLPackage.eINSTANCE.getInputPin(), (IHintedType)UMLElementTypes.InputPin_3019);
	}

	/**
	 * Corresponding node types for CallBehaviorAction result pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> CALLBEHAVIORACTION_RESULT_TYPES;
	static {
		CALLBEHAVIORACTION_RESULT_TYPES = new HashMap<EClass, IHintedType>();
		CALLBEHAVIORACTION_RESULT_TYPES.put(UMLPackage.eINSTANCE.getOutputPin(), (IHintedType)UMLElementTypes.OutputPin_3020);
	}

	/**
	 * Corresponding node types for CallOperationAction argument pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> CALLOPERATIONACTION_ARGUMENT_TYPES;
	static {
		CALLOPERATIONACTION_ARGUMENT_TYPES = new HashMap<EClass, IHintedType>();
		CALLOPERATIONACTION_ARGUMENT_TYPES.put(UMLPackage.eINSTANCE.getValuePin(), (IHintedType)UMLElementTypes.ValuePin_3022);
		CALLOPERATIONACTION_ARGUMENT_TYPES.put(UMLPackage.eINSTANCE.getActionInputPin(), (IHintedType)UMLElementTypes.ActionInputPin_3021);
		CALLOPERATIONACTION_ARGUMENT_TYPES.put(UMLPackage.eINSTANCE.getInputPin(), (IHintedType)UMLElementTypes.InputPin_3023);
	}

	/**
	 * Corresponding node types for CallOperationAction target pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> CALLOPERATIONACTION_TARGET_TYPES;
	static {
		CALLOPERATIONACTION_TARGET_TYPES = new HashMap<EClass, IHintedType>();
		CALLOPERATIONACTION_TARGET_TYPES.put(UMLPackage.eINSTANCE.getValuePin(), (IHintedType)UMLElementTypes.ValuePin_3025);
		CALLOPERATIONACTION_TARGET_TYPES.put(UMLPackage.eINSTANCE.getActionInputPin(), (IHintedType)UMLElementTypes.ActionInputPin_3026);
		CALLOPERATIONACTION_TARGET_TYPES.put(UMLPackage.eINSTANCE.getInputPin(), (IHintedType)UMLElementTypes.InputPin_3027);
	}

	/**
	 * Corresponding node types for CallOperationAction result pins of a given EClass
	 */
	protected final static Map<EClass, IHintedType> CALLOPERATIONACTION_RESULT_TYPES;
	static {
		CALLOPERATIONACTION_RESULT_TYPES = new HashMap<EClass, IHintedType>();
		CALLOPERATIONACTION_RESULT_TYPES.put(UMLPackage.eINSTANCE.getOutputPin(), (IHintedType)UMLElementTypes.OutputPin_3024);
	}

	/**
	 * The protected Constructor.
	 * Construct a new NotificationHelper which automatically manages contained pins for an action.
	 * 
	 * Use {@link ActionPinNotificationHelper#createHelper(AbstractBorderedShapeEditPart, EClass)} instead.
	 * 
	 * @param modelListener
	 *        the model listener (or null for no effect)
	 */
	private ActionPinNotificationHelper(UIAdapterImpl modelListener) {
		super(modelListener);
	}

	/**
	 * Construct a new NotificationHelper which automatically manages contained pins for an action.
	 * 
	 * @param actionBorderedPart
	 *        the parent action part whose pin parts must be managed
	 * @param actionEClass
	 *        the EClass of the concerned action
	 * @return the constructed notification helper
	 */
	public static ActionPinNotificationHelper createHelper(final AbstractBorderedShapeEditPart actionBorderedPart, final EClass actionEClass) {
		UIAdapterImpl adapter = null;
		// construct the adapter for the appropriate action class
		if(UMLPackage.eINSTANCE.getOpaqueAction().equals(actionEClass)) {
			adapter = new UIAdapterImpl() {

				@Override
				protected void safeNotifyChanged(Notification msg) {
					if(UMLPackage.eINSTANCE.getOpaqueAction_InputValue().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getOpaqueAction_InputValue(), OPAQUEACTION_INPUT_TYPES);
					} else if(UMLPackage.eINSTANCE.getOpaqueAction_OutputValue().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getOpaqueAction_OutputValue(), OPAQUEACTION_OUTPUT_TYPES);
					}
				}
			};
		} else if(UMLPackage.eINSTANCE.getCallBehaviorAction().equals(actionEClass)) {
			adapter = new UIAdapterImpl() {

				@Override
				protected void safeNotifyChanged(Notification msg) {
					if(UMLPackage.eINSTANCE.getInvocationAction_Argument().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getInvocationAction_Argument(), CALLBEHAVIORACTION_ARGUMENT_TYPES);
					} else if(UMLPackage.eINSTANCE.getCallAction_Result().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getCallAction_Result(), CALLBEHAVIORACTION_RESULT_TYPES);
					}
				}
			};
		} else if(UMLPackage.eINSTANCE.getCallOperationAction().equals(actionEClass)) {
			adapter = new UIAdapterImpl() {

				@Override
				protected void safeNotifyChanged(Notification msg) {
					if(UMLPackage.eINSTANCE.getInvocationAction_Argument().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getInvocationAction_Argument(), CALLOPERATIONACTION_ARGUMENT_TYPES);
					} else if(UMLPackage.eINSTANCE.getCallOperationAction_Target().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getCallOperationAction_Target(), CALLOPERATIONACTION_TARGET_TYPES);
					} else if(UMLPackage.eINSTANCE.getCallAction_Result().equals(msg.getFeature())) {
						updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getCallAction_Result(), CALLOPERATIONACTION_RESULT_TYPES);
					}
				}
			};
		}
		return new ActionPinNotificationHelper(adapter);
	}

	/**
	 * Update children edit parts so that each child is represented once with the appropriate view
	 * 
	 * @param actionBorderedPart
	 *        the bordered part containing children
	 * @param actionEClass
	 *        the EClass of the concerned action
	 */
	public static void updateChildrenPinParts(final AbstractBorderedShapeEditPart actionBorderedPart, final EClass actionEClass) {
		if(UMLPackage.eINSTANCE.getOpaqueAction().equals(actionEClass)) {
			// update inputs and outputs
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getOpaqueAction_InputValue(), OPAQUEACTION_INPUT_TYPES);
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getOpaqueAction_OutputValue(), OPAQUEACTION_OUTPUT_TYPES);
		} else if(UMLPackage.eINSTANCE.getCallBehaviorAction().equals(actionEClass)) {
			// update arguments and results
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getInvocationAction_Argument(), CALLBEHAVIORACTION_ARGUMENT_TYPES);
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getCallAction_Result(), CALLBEHAVIORACTION_RESULT_TYPES);
		} else if(UMLPackage.eINSTANCE.getCallOperationAction().equals(actionEClass)) {
			// update arguments, target and results
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getInvocationAction_Argument(), CALLOPERATIONACTION_ARGUMENT_TYPES);
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getCallOperationAction_Target(), CALLOPERATIONACTION_TARGET_TYPES);
			updateChildrenParts(actionBorderedPart, UMLPackage.eINSTANCE.getCallAction_Result(), CALLOPERATIONACTION_RESULT_TYPES);
		}
	}

	/**
	 * Update children edit parts so that each child is represented once with the appropriate view
	 * 
	 * @param borderedPart
	 *        the bordered part containing children
	 * @param childFeature
	 *        the feature containing children
	 * @param childTypes
	 *        the children's IHintedType represented as Node for each possible EClass
	 */
	public static void updateChildrenParts(AbstractBorderedShapeEditPart borderedPart, EStructuralFeature childFeature, Map<EClass, IHintedType> childTypes) {
		// Check parameter values
		if(borderedPart == null || childFeature == null || childTypes == null) {
			return;
		}
		Object modelElt = borderedPart.getModel();
		if(modelElt instanceof View) {
			View modelContainerView = (View)modelElt;
			Class<?> containerClass = childFeature.getContainerClass();
			if(containerClass.isInstance(modelContainerView.getElement())) {
				EObject containerObject = modelContainerView.getElement();
				Object untypedOwnedObjects = containerObject.eGet(childFeature);
				if(untypedOwnedObjects instanceof EObject) {
					// handle single value like a list
					untypedOwnedObjects = Collections.singletonList(untypedOwnedObjects);
				} else if(untypedOwnedObjects == null) {
					// handle no value like a list
					untypedOwnedObjects = Collections.emptyList();
				}
				if(untypedOwnedObjects instanceof List<?>) {
					List<?> ownedEObjectChildren = (List<?>)untypedOwnedObjects;
					List<EObject> drawnEObjectChildren = new ArrayList<EObject>(ownedEObjectChildren.size());
					// list children already drawn and remove old parts
					@SuppressWarnings("unchecked")
					List<Object> childrenViewsCopy = new ArrayList<Object>(modelContainerView.getChildren());
					for(Object childView : childrenViewsCopy) {
						if(childView instanceof View) {
							EObject child = ((View)childView).getElement();
							if(ownedEObjectChildren.contains(child) && !drawnEObjectChildren.contains(child)) {
								drawnEObjectChildren.add(child);
							} else if(childFeature.getEType().isInstance(child) && !child.equals(containerObject) && !containerObject.equals(child.eContainer())) {
								modelContainerView.removeChild((View)childView);
							}
						}
					}
					// draw remaining children
					List<Object> childrenToDraw = new ArrayList<Object>(ownedEObjectChildren);
					childrenToDraw.removeAll(drawnEObjectChildren);
					CompositeCommand drawChildrenCommand = new CompositeCommand("draw children nodes");
					for(Object child : childrenToDraw) {
						if(child instanceof EObject) {
							// draw child with adapted node type corresponding to its EClass
							IHintedType childType = childTypes.get(((EObject)child).eClass());
							if(childType != null) {
								IAdaptable adapter = new EObjectAdapter((EObject)child);
								ViewDescriptor descriptor = new ViewDescriptor(adapter, Node.class, childType.getSemanticHint(), ViewUtil.APPEND, false, borderedPart.getDiagramPreferencesHint());
								CreateCommand nodeCreationCommand = new CreateCommand(borderedPart.getEditingDomain(), descriptor, modelContainerView);
								drawChildrenCommand.add(nodeCreationCommand);
							}
						}
					}
					if(!drawChildrenCommand.isEmpty()) {
						try {
							OperationHistoryFactory.getOperationHistory().execute(drawChildrenCommand, new NullProgressMonitor(), null);
						} catch (ExecutionException e) {
							e.printStackTrace();
							Activator.getInstance().logError("Unable to create diagram elements", e); //$NON-NLS-1$
						}
					}
				}
			}
		}
	}
}
