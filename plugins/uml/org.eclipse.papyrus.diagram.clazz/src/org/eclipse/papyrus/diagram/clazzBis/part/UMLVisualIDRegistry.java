package org.eclipse.papyrus.diagram.clazzBis.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.clazz/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(view.getType())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package) domainElement)) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBody2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationIsSubstitutableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAliasEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAlias2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportVisibilityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getSubstitution().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getRealization().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getPackageImport().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getPackageMerge().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getProfileApplication().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getTemplateBinding().isSuperTypeOf(domainElement.eClass())) {
			return org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

}
