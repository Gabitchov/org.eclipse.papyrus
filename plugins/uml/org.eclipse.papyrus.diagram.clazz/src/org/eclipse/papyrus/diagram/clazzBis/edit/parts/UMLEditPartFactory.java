package org.eclipse.papyrus.diagram.clazzBis.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBodyEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBodyEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBody2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBody2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationIsSubstitutableEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationIsSubstitutableEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyNameEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyNameEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName3EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName3EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName4EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName4EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAliasEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAliasEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAlias2EditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAlias2EditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportVisibilityEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportVisibilityEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart(view);

			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new org.eclipse.papyrus.diagram.clazzBis.edit.parts.WrappingLabelEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
