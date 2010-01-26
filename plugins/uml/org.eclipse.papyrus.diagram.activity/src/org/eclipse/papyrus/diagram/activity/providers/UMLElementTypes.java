/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.activity.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_2001 = getElementType("org.eclipse.papyrus.diagram.activity.Activity_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_3001 = getElementType("org.eclipse.papyrus.diagram.activity.Parameter_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3002 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3003 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InitialNode_3004 = getElementType("org.eclipse.papyrus.diagram.activity.InitialNode_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityFinalNode_3005 = getElementType("org.eclipse.papyrus.diagram.activity.ActivityFinalNode_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FlowFinalNode_3006 = getElementType("org.eclipse.papyrus.diagram.activity.FlowFinalNode_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OpaqueAction_3007 = getElementType("org.eclipse.papyrus.diagram.activity.OpaqueAction_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3015 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3016 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3013 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3014 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallBehaviorAction_3008 = getElementType("org.eclipse.papyrus.diagram.activity.CallBehaviorAction_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3017 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3018 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3019 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3020 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallOperationAction_3010 = getElementType("org.eclipse.papyrus.diagram.activity.CallOperationAction_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3021 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3022 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3023 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3024 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3025 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3026 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3027 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3011 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3012 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_3028 = getElementType("org.eclipse.papyrus.diagram.activity.Activity_3028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_3029 = getElementType("org.eclipse.papyrus.diagram.activity.Activity_3029"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionLocalPrecondition_4001 = getElementType("org.eclipse.papyrus.diagram.activity.ActionLocalPrecondition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionLocalPostcondition_4002 = getElementType("org.eclipse.papyrus.diagram.activity.ActionLocalPostcondition_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ObjectFlowSelection_4005 = getElementType("org.eclipse.papyrus.diagram.activity.ObjectFlowSelection_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ObjectFlowTransformation_4006 = getElementType("org.eclipse.papyrus.diagram.activity.ObjectFlowTransformation_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ObjectFlow_4003 = getElementType("org.eclipse.papyrus.diagram.activity.ObjectFlow_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ControlFlow_4004 = getElementType("org.eclipse.papyrus.diagram.activity.ControlFlow_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if(imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature)element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass && !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			if(!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if(imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if(image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap();

			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());


			elements.put(Activity_2001, UMLPackage.eINSTANCE.getActivity());


			elements.put(Parameter_3001, UMLPackage.eINSTANCE.getParameter());


			elements.put(Constraint_3002, UMLPackage.eINSTANCE.getConstraint());


			elements.put(Constraint_3003, UMLPackage.eINSTANCE.getConstraint());


			elements.put(InitialNode_3004, UMLPackage.eINSTANCE.getInitialNode());


			elements.put(ActivityFinalNode_3005, UMLPackage.eINSTANCE.getActivityFinalNode());


			elements.put(FlowFinalNode_3006, UMLPackage.eINSTANCE.getFlowFinalNode());


			elements.put(OpaqueAction_3007, UMLPackage.eINSTANCE.getOpaqueAction());


			elements.put(ValuePin_3015, UMLPackage.eINSTANCE.getValuePin());


			elements.put(ActionInputPin_3016, UMLPackage.eINSTANCE.getActionInputPin());


			elements.put(InputPin_3013, UMLPackage.eINSTANCE.getInputPin());


			elements.put(OutputPin_3014, UMLPackage.eINSTANCE.getOutputPin());


			elements.put(CallBehaviorAction_3008, UMLPackage.eINSTANCE.getCallBehaviorAction());


			elements.put(ValuePin_3017, UMLPackage.eINSTANCE.getValuePin());


			elements.put(ActionInputPin_3018, UMLPackage.eINSTANCE.getActionInputPin());


			elements.put(InputPin_3019, UMLPackage.eINSTANCE.getInputPin());


			elements.put(OutputPin_3020, UMLPackage.eINSTANCE.getOutputPin());


			elements.put(CallOperationAction_3010, UMLPackage.eINSTANCE.getCallOperationAction());


			elements.put(ActionInputPin_3021, UMLPackage.eINSTANCE.getActionInputPin());


			elements.put(ValuePin_3022, UMLPackage.eINSTANCE.getValuePin());


			elements.put(InputPin_3023, UMLPackage.eINSTANCE.getInputPin());


			elements.put(OutputPin_3024, UMLPackage.eINSTANCE.getOutputPin());


			elements.put(ValuePin_3025, UMLPackage.eINSTANCE.getValuePin());


			elements.put(ActionInputPin_3026, UMLPackage.eINSTANCE.getActionInputPin());


			elements.put(InputPin_3027, UMLPackage.eINSTANCE.getInputPin());


			elements.put(Constraint_3011, UMLPackage.eINSTANCE.getConstraint());


			elements.put(Constraint_3012, UMLPackage.eINSTANCE.getConstraint());


			elements.put(Activity_3028, UMLPackage.eINSTANCE.getActivity());


			elements.put(Activity_3029, UMLPackage.eINSTANCE.getActivity());

			elements.put(ActionLocalPrecondition_4001, UMLPackage.eINSTANCE.getAction_LocalPrecondition());

			elements.put(ActionLocalPostcondition_4002, UMLPackage.eINSTANCE.getAction_LocalPostcondition());

			elements.put(ObjectFlowSelection_4005, UMLPackage.eINSTANCE.getObjectFlow_Selection());

			elements.put(ObjectFlowTransformation_4006, UMLPackage.eINSTANCE.getObjectFlow_Transformation());


			elements.put(ObjectFlow_4003, UMLPackage.eINSTANCE.getObjectFlow());


			elements.put(ControlFlow_4004, UMLPackage.eINSTANCE.getControlFlow());
		}
		return (ENamedElement)elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Activity_2001);
			KNOWN_ELEMENT_TYPES.add(Parameter_3001);
			KNOWN_ELEMENT_TYPES.add(Constraint_3002);
			KNOWN_ELEMENT_TYPES.add(Constraint_3003);
			KNOWN_ELEMENT_TYPES.add(InitialNode_3004);
			KNOWN_ELEMENT_TYPES.add(ActivityFinalNode_3005);
			KNOWN_ELEMENT_TYPES.add(FlowFinalNode_3006);
			KNOWN_ELEMENT_TYPES.add(OpaqueAction_3007);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3015);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3016);
			KNOWN_ELEMENT_TYPES.add(InputPin_3013);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3014);
			KNOWN_ELEMENT_TYPES.add(CallBehaviorAction_3008);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3017);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3018);
			KNOWN_ELEMENT_TYPES.add(InputPin_3019);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3020);
			KNOWN_ELEMENT_TYPES.add(CallOperationAction_3010);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3021);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3022);
			KNOWN_ELEMENT_TYPES.add(InputPin_3023);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3024);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3025);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3026);
			KNOWN_ELEMENT_TYPES.add(InputPin_3027);
			KNOWN_ELEMENT_TYPES.add(Constraint_3011);
			KNOWN_ELEMENT_TYPES.add(Constraint_3012);
			KNOWN_ELEMENT_TYPES.add(Activity_3028);
			KNOWN_ELEMENT_TYPES.add(Activity_3029);
			KNOWN_ELEMENT_TYPES.add(ActionLocalPrecondition_4001);
			KNOWN_ELEMENT_TYPES.add(ActionLocalPostcondition_4002);
			KNOWN_ELEMENT_TYPES.add(ObjectFlowSelection_4005);
			KNOWN_ELEMENT_TYPES.add(ObjectFlowTransformation_4006);
			KNOWN_ELEMENT_TYPES.add(ObjectFlow_4003);
			KNOWN_ELEMENT_TYPES.add(ControlFlow_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ActivityDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case ActivityEditPart.VISUAL_ID:
			return Activity_2001;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_3001;
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return Constraint_3002;
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return Constraint_3003;
		case InitialNodeEditPart.VISUAL_ID:
			return InitialNode_3004;
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return ActivityFinalNode_3005;
		case FlowFinalNodeEditPart.VISUAL_ID:
			return FlowFinalNode_3006;
		case OpaqueActionEditPart.VISUAL_ID:
			return OpaqueAction_3007;
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return ValuePin_3015;
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return ActionInputPin_3016;
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return InputPin_3013;
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return OutputPin_3014;
		case CallBehaviorActionEditPart.VISUAL_ID:
			return CallBehaviorAction_3008;
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return ValuePin_3017;
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return ActionInputPin_3018;
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return InputPin_3019;
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return OutputPin_3020;
		case CallOperationActionEditPart.VISUAL_ID:
			return CallOperationAction_3010;
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return ActionInputPin_3021;
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return ValuePin_3022;
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return InputPin_3023;
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return OutputPin_3024;
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return ValuePin_3025;
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return ActionInputPin_3026;
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return InputPin_3027;
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return Constraint_3011;
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return Constraint_3012;
		case ActivityAsSelectionEditPart.VISUAL_ID:
			return Activity_3028;
		case ActivityAsTransformationEditPart.VISUAL_ID:
			return Activity_3029;
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return ActionLocalPrecondition_4001;
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return ActionLocalPostcondition_4002;
		case ObjectFlowSelectionEditPart.VISUAL_ID:
			return ObjectFlowSelection_4005;
		case ObjectFlowTransformationEditPart.VISUAL_ID:
			return ObjectFlowTransformation_4006;
		case ObjectFlowEditPart.VISUAL_ID:
			return ObjectFlow_4003;
		case ControlFlowEditPart.VISUAL_ID:
			return ControlFlow_4004;
		}
		return null;
	}

}
