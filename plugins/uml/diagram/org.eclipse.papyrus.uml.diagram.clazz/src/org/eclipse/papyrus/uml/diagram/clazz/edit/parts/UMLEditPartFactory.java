/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.edit.parts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
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
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			case ModelEditPart.VISUAL_ID:
				return new ModelEditPart(view);
			case DependencyNodeEditPart.VISUAL_ID:
				return new DependencyNodeEditPart(view);
			case MultiDependencyLabelEditPart.VISUAL_ID:
				return new MultiDependencyLabelEditPart(view);
			case AssociationClassEditPart.VISUAL_ID:
				return new AssociationClassEditPart(view);
			case AssociationClassNameEditPart.VISUAL_ID:
				return new AssociationClassNameEditPart(view);
			case AssociationNodeEditPart.VISUAL_ID:
				return new AssociationNodeEditPart(view);
			case InstanceSpecificationEditPart.VISUAL_ID:
				return new InstanceSpecificationEditPart(view);
			case InstanceSpecificationNameEditPart.VISUAL_ID:
				return new InstanceSpecificationNameEditPart(view);
			case ComponentEditPart.VISUAL_ID:
				return new ComponentEditPart(view);
			case ComponentNameEditPart.VISUAL_ID:
				return new ComponentNameEditPart(view);
			case SignalEditPart.VISUAL_ID:
				return new SignalEditPart(view);
			case SignalNameEditPart.VISUAL_ID:
				return new SignalNameEditPart(view);
			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);
			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);
			case ModelEditPartTN.VISUAL_ID:
				return new ModelEditPartTN(view);
			case ModelNameEditPartTN.VISUAL_ID:
				return new ModelNameEditPartTN(view);
			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);
			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);
			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);
			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);
			case InformationItemEditPart.VISUAL_ID:
				return new InformationItemEditPart(view);
			case InformationItemNameEditPart.VISUAL_ID:
				return new InformationItemNameEditPart(view);
			case ClassEditPart.VISUAL_ID:
				return new ClassEditPart(view);
			case ClassNameEditPart.VISUAL_ID:
				return new ClassNameEditPart(view);
			case PrimitiveTypeEditPart.VISUAL_ID:
				return new PrimitiveTypeEditPart(view);
			case PrimitiveTypeNameEditPart.VISUAL_ID:
				return new PrimitiveTypeNameEditPart(view);
			case DataTypeEditPart.VISUAL_ID:
				return new DataTypeEditPart(view);
			case DataTypeNameEditPart.VISUAL_ID:
				return new DataTypeNameEditPart(view);
			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);
			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);
			case ConstraintBodyEditPart.VISUAL_ID:
				return new ConstraintBodyEditPart(view);
			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);
			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);
			case ShortCutDiagramEditPart.VISUAL_ID:
				return new ShortCutDiagramEditPart(view);
			case DiagramNameEditPart.VISUAL_ID:
				return new DiagramNameEditPart(view);
			case DurationObservationEditPart.VISUAL_ID:
				return new DurationObservationEditPart(view);
			case DurationObservationNameEditPart.VISUAL_ID:
				return new DurationObservationNameEditPart(view);
			case DurationObservationStereotypeLabelEditPart.VISUAL_ID:
				return new DurationObservationStereotypeLabelEditPart(view);
			case TimeObservationEditPart.VISUAL_ID:
				return new TimeObservationEditPart(view);
			case TimeObservationNameEditPart.VISUAL_ID:
				return new TimeObservationNameEditPart(view);
			case TimeObservationStereotypeLabelEditPart.VISUAL_ID:
				return new TimeObservationStereotypeLabelEditPart(view);
			case DefaultNamedElementEditPart.VISUAL_ID:
				return new DefaultNamedElementEditPart(view);
			case DefaultNamedElementNameEditPart.VISUAL_ID:
				return new DefaultNamedElementNameEditPart(view);
			case ShapeNamedElementEditPart.VISUAL_ID:
				return new ShapeNamedElementEditPart(view);
			case ShapeNamedElementNameEditPart.VISUAL_ID:
				return new ShapeNamedElementNameEditPart(view);
			case PropertyForClassEditPart.VISUAL_ID:
				return new PropertyForClassEditPart(view);
			case PropertyForComponentEditPart.VISUAL_ID:
				return new PropertyForComponentEditPart(view);
			case PropertyForSignalEditPart.VISUAL_ID:
				return new PropertyForSignalEditPart(view);
			case PropertyForInterfaceEditPart.VISUAL_ID:
				return new PropertyForInterfaceEditPart(view);
			case PropertyforDataTypeEditPart.VISUAL_ID:
				return new PropertyforDataTypeEditPart(view);
			case NestedClassForClassEditPart.VISUAL_ID:
				return new NestedClassForClassEditPart(view);
			case NestedClassForComponentEditPart.VISUAL_ID:
				return new NestedClassForComponentEditPart(view);
			case NestedClassForInterfaceEditPart.VISUAL_ID:
				return new NestedClassForInterfaceEditPart(view);
			case OperationForClassEditPart.VISUAL_ID:
				return new OperationForClassEditPart(view);
			case OperationForComponentEditPart.VISUAL_ID:
				return new OperationForComponentEditPart(view);
			case OperationForInterfaceEditpart.VISUAL_ID:
				return new OperationForInterfaceEditpart(view);
			case OperationForDataTypeEditPart.VISUAL_ID:
				return new OperationForDataTypeEditPart(view);
			case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
				return new ConnectableElementTemplateParameterEditPart(view);
			case OperationTemplateParameterEditPart.VISUAL_ID:
				return new OperationTemplateParameterEditPart(view);
			case ClassifierTemplateParameterEditPart.VISUAL_ID:
				return new ClassifierTemplateParameterEditPart(view);
			case TemplateParameterEditPart.VISUAL_ID:
				return new TemplateParameterEditPart(view);
			case EnumerationLiteralEditPart.VISUAL_ID:
				return new EnumerationLiteralEditPart(view);
			case ReceptionEditPart.VISUAL_ID:
				return new ReceptionEditPart(view);
			case ReceptionInInterfaceEditPart.VISUAL_ID:
				return new ReceptionInInterfaceEditPart(view);
			case SlotEditPart.VISUAL_ID:
				return new SlotEditPart(view);
			case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				return new RedefinableTemplateSignatureEditPart(view);
			case ContainmentCircleEditPart.VISUAL_ID:
				return new ContainmentCircleEditPart(view);
			case TemplateSignatureEditPart.VISUAL_ID:
				return new TemplateSignatureEditPart(view);
			case InstanceSpecificationEditPartCN.VISUAL_ID:
				return new InstanceSpecificationEditPartCN(view);
			case InstanceSpecificationNameEditPartCN.VISUAL_ID:
				return new InstanceSpecificationNameEditPartCN(view);
			case ComponentEditPartCN.VISUAL_ID:
				return new ComponentEditPartCN(view);
			case ComponentNameEditPartCN.VISUAL_ID:
				return new ComponentNameEditPartCN(view);
			case SignalEditPartCN.VISUAL_ID:
				return new SignalEditPartCN(view);
			case SignalNameEditPartCN.VISUAL_ID:
				return new SignalNameEditPartCN(view);
			case InterfaceEditPartCN.VISUAL_ID:
				return new InterfaceEditPartCN(view);
			case InterfaceNameEditPartCN.VISUAL_ID:
				return new InterfaceNameEditPartCN(view);
			case ModelEditPartCN.VISUAL_ID:
				return new ModelEditPartCN(view);
			case ModelNameEditPartCN.VISUAL_ID:
				return new ModelNameEditPartCN(view);
			case EnumerationEditPartCN.VISUAL_ID:
				return new EnumerationEditPartCN(view);
			case EnumerationNameEditPartCN.VISUAL_ID:
				return new EnumerationNameEditPartCN(view);
			case PackageEditPartCN.VISUAL_ID:
				return new PackageEditPartCN(view);
			case PackageNameEditPartCN.VISUAL_ID:
				return new PackageNameEditPartCN(view);
			case InformationItemEditPartCN.VISUAL_ID:
				return new InformationItemEditPartCN(view);
			case InformationItemNameEditPartCN.VISUAL_ID:
				return new InformationItemNameEditPartCN(view);
			case ClassEditPartCN.VISUAL_ID:
				return new ClassEditPartCN(view);
			case ClassNameEditPartCN.VISUAL_ID:
				return new ClassNameEditPartCN(view);
			case PrimitiveTypeEditPartCN.VISUAL_ID:
				return new PrimitiveTypeEditPartCN(view);
			case PrimitiveTypeNameEditPartCN.VISUAL_ID:
				return new PrimitiveTypeNameEditPartCN(view);
			case DataTypeEditPartCN.VISUAL_ID:
				return new DataTypeEditPartCN(view);
			case DataTypeNameEditPartCN.VISUAL_ID:
				return new DataTypeNameEditPartCN(view);
			case CommentEditPartCN.VISUAL_ID:
				return new CommentEditPartCN(view);
			case CommentBodyEditPartCN.VISUAL_ID:
				return new CommentBodyEditPartCN(view);
			case ConstraintEditPartCN.VISUAL_ID:
				return new ConstraintEditPartCN(view);
			case ConstraintNameEditPartCN.VISUAL_ID:
				return new ConstraintNameEditPartCN(view);
			case ConstraintBodyEditPartCN.VISUAL_ID:
				return new ConstraintBodyEditPartCN(view);
			case NestedInterfaceForClassEditPart.VISUAL_ID:
				return new NestedInterfaceForClassEditPart(view);
			case NestedInterfaceForComponentEditPart.VISUAL_ID:
				return new NestedInterfaceForComponentEditPart(view);
			case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
				return new NestedInterfaceForInterfaceEditPart(view);
			case ClassAttributeCompartmentEditPartCN.VISUAL_ID:
				return new ClassAttributeCompartmentEditPartCN(view);
			case ClassOperationCompartmentEditPartCN.VISUAL_ID:
				return new ClassOperationCompartmentEditPartCN(view);
			case ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID:
				return new ClassNestedClassifierCompartmentEditPartCN(view);
			case ComponentAttributeCompartmentEditPartCN.VISUAL_ID:
				return new ComponentAttributeCompartmentEditPartCN(view);
			case ComponentOperationCompartmentEditPartCN.VISUAL_ID:
				return new ComponentOperationCompartmentEditPartCN(view);
			case ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID:
				return new ComponentNestedClassifierCompartmentEditPartCN(view);
			case SignalAttributeCompartmentEditPartCN.VISUAL_ID:
				return new SignalAttributeCompartmentEditPartCN(view);
			case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
				return new InterfaceAttributeCompartmentEditPartCN(view);
			case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
				return new InterfaceOperationCompartmentEditPartCN(view);
			case InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID:
				return new InterfaceNestedClassifierCompartmentEditPartCN(view);
			case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPartCN(view);
			case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPartCN(view);
			case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPartCN(view);
			case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPartCN(view);
			case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPartCN(view);
			case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
				return new InstanceSpecificationSlotCompartmentEditPartCN(view);
			case ClassAttributeCompartmentEditPart.VISUAL_ID:
				return new ClassAttributeCompartmentEditPart(view);
			case ClassOperationCompartmentEditPart.VISUAL_ID:
				return new ClassOperationCompartmentEditPart(view);
			case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new ClassNestedClassifierCompartmentEditPart(view);
			case ComponentAttributeCompartmentEditPart.VISUAL_ID:
				return new ComponentAttributeCompartmentEditPart(view);
			case ComponentOperationCompartmentEditPart.VISUAL_ID:
				return new ComponentOperationCompartmentEditPart(view);
			case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new ComponentNestedClassifierCompartmentEditPart(view);
			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				return new InterfaceAttributeCompartmentEditPart(view);
			case InterfaceOperationCompartmentEditPart.VISUAL_ID:
				return new InterfaceOperationCompartmentEditPart(view);
			case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new InterfaceNestedClassifierCompartmentEditPart(view);
			case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPart(view);
			case DataTypeOperationCompartmentEditPart.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPart(view);
			case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
				return new AssociationClassAttributeCompartmentEditPart(view);
			case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
				return new InstanceSpecificationSlotCompartmentEditPart(view);
			case SignalAttributeCompartmentEditPart.VISUAL_ID:
				return new SignalAttributeCompartmentEditPart(view);
			case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPartTN(view);
			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPart(view);
			case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPart(view);
			case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
				return new AssociationClassOperationCompartmentEditPart(view);
			case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new AssociationClassNestedClassifierCompartmentEditPart(view);
			case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
				return new RedefinableTemplateSignatureTemplateParameterCompartmentEditPart(view);
			case TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
				return new TemplateSignatureTemplateParameterCompartmentEditPart(view);
			case AssociationClassDashedLinkEditPart.VISUAL_ID:
				return new AssociationClassDashedLinkEditPart(view);
			case AssociationClassLinkEditPart.VISUAL_ID:
				return new AssociationClassLinkEditPart(view);
			case AssociationClassRoleSourceEditPart.VISUAL_ID:
				return new AssociationClassRoleSourceEditPart(view);
			case AssociationClassRoleTargetEditPart.VISUAL_ID:
				return new AssociationClassRoleTargetEditPart(view);
			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);
			case AppliedStereotypeAssociationEditPart.VISUAL_ID:
				return new AppliedStereotypeAssociationEditPart(view);
			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);
			case AssociationTargetNameEditPart.VISUAL_ID:
				return new AssociationTargetNameEditPart(view);
			case AssociationSourceNameEditPart.VISUAL_ID:
				return new AssociationSourceNameEditPart(view);
			case AssociationMultiplicitySourceEditPart.VISUAL_ID:
				return new AssociationMultiplicitySourceEditPart(view);
			case AssociationMultiplicityTargetEditPart.VISUAL_ID:
				return new AssociationMultiplicityTargetEditPart(view);
			case AssociationBranchEditPart.VISUAL_ID:
				return new AssociationBranchEditPart(view);
			case AssociationBranchRoleEditPart.VISUAL_ID:
				return new AssociationBranchRoleEditPart(view);
			case AssociationBranchMutliplicityEditPart.VISUAL_ID:
				return new AssociationBranchMutliplicityEditPart(view);
			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);
			case AppliedStereotyperGeneralizationEditPart.VISUAL_ID:
				return new AppliedStereotyperGeneralizationEditPart(view);
			case InterfaceRealizationEditPart.VISUAL_ID:
				return new InterfaceRealizationEditPart(view);
			case AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID:
				return new AppliedStereotypeInterfaceRealizationEditPart(view);
			case InterfaceRealizationName2EditPart.VISUAL_ID:
				return new InterfaceRealizationName2EditPart(view);
			case SubstitutionEditPart.VISUAL_ID:
				return new SubstitutionEditPart(view);
			case AppliedStereotypeSubstitutionEditPart.VISUAL_ID:
				return new AppliedStereotypeSubstitutionEditPart(view);
			case SubstitutionNameEditPart.VISUAL_ID:
				return new SubstitutionNameEditPart(view);
			case RealizationEditPart.VISUAL_ID:
				return new RealizationEditPart(view);
			case AppliedStereotypeRealizationEditPart.VISUAL_ID:
				return new AppliedStereotypeRealizationEditPart(view);
			case RealizationNameEditPart.VISUAL_ID:
				return new RealizationNameEditPart(view);
			case AbstractionEditPart.VISUAL_ID:
				return new AbstractionEditPart(view);
			case AbstractionNameEditPart.VISUAL_ID:
				return new AbstractionNameEditPart(view);
			case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
				return new AppliedStereotypeAbstractionEditPart(view);
			case UsageEditPart.VISUAL_ID:
				return new UsageEditPart(view);
			case UsageNameEditPart.VISUAL_ID:
				return new UsageNameEditPart(view);
			case AppliedStereotypeUsageEditPart.VISUAL_ID:
				return new AppliedStereotypeUsageEditPart(view);
			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);
			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);
			case AppliedStereotypeDependencyEditPart.VISUAL_ID:
				return new AppliedStereotypeDependencyEditPart(view);
			case DependencyBranchEditPart.VISUAL_ID:
				return new DependencyBranchEditPart(view);
			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);
			case ElementImportAliasEditPart.VISUAL_ID:
				return new ElementImportAliasEditPart(view);
			case AppliedStereotypeElementImportEditPart.VISUAL_ID:
				return new AppliedStereotypeElementImportEditPart(view);
			case PackageImportEditPart.VISUAL_ID:
				return new PackageImportEditPart(view);
			case AppliedStereotypePackageImportEditPart.VISUAL_ID:
				return new AppliedStereotypePackageImportEditPart(view);
			case PackageMergeEditPart.VISUAL_ID:
				return new PackageMergeEditPart(view);
			case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
				return new AppliedStereotypePackageMergeEditPart(view);
			case ProfileApplicationEditPart.VISUAL_ID:
				return new ProfileApplicationEditPart(view);
			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);
			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);
			case TemplateBindingEditPart.VISUAL_ID:
				return new TemplateBindingEditPart(view);
			case BindingSubstitutionEditPart.VISUAL_ID:
				return new BindingSubstitutionEditPart(view);
			case AppliedStereotypeTemplateBindingEditPart.VISUAL_ID:
				return new AppliedStereotypeTemplateBindingEditPart(view);
			case GeneralizationSetEditPart.VISUAL_ID:
				return new GeneralizationSetEditPart(view);
			case ConstraintLabelEditPart.VISUAL_ID:
				return new ConstraintLabelEditPart(view);
			case AppliedStereotypeGeneralizationSetLabelEditPart.VISUAL_ID:
				return new AppliedStereotypeGeneralizationSetLabelEditPart(view);
			case InstanceSpecificationLinkEditPart.VISUAL_ID:
				return new InstanceSpecificationLinkEditPart(view);
			case SourceISLinkLabelEditPart.VISUAL_ID:
				return new SourceISLinkLabelEditPart(view);
			case TargetISLinkLabelEditPart.VISUAL_ID:
				return new TargetISLinkLabelEditPart(view);
			case ContainmentSubLinkEditPart.VISUAL_ID:
				return new ContainmentSubLinkEditPart(view);
			case ContainmentLinkEditPart.VISUAL_ID:
				return new ContainmentLinkEditPart(view);
			case ConnectorTimeObservationEditPart.VISUAL_ID:
				return new ConnectorTimeObservationEditPart(view);
			case ConnectorDurationObservationEditPart.VISUAL_ID:
				return new ConnectorDurationObservationEditPart(view);
			case InformationFlowEditPart.VISUAL_ID:
				return new InformationFlowEditPart(view);
			case InformationFlowConveyedLabelEditPart.VISUAL_ID:
				return new InformationFlowConveyedLabelEditPart(view);
			case InformationFlowAppliedStereotypeEditPart.VISUAL_ID:
				return new InformationFlowAppliedStereotypeEditPart(view);
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
		if(source.getFigure() instanceof IMultilineEditableFigure) {
			return new MultilineCellEditorLocator((IMultilineEditableFigure)source.getFigure());
		} else {
			return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
		}
	}

	/**
	 * @generated
	 */
	static private class MultilineCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private IMultilineEditableFigure multilineEditableFigure;

		/**
		 * @generated
		 */
		public MultilineCellEditorLocator(IMultilineEditableFigure figure) {
			this.multilineEditableFigure = figure;
		}

		/**
		 * @generated
		 */
		public IMultilineEditableFigure getMultilineEditableFigure() {
			return multilineEditableFigure;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
			rect.x = getMultilineEditableFigure().getEditionLocation().x;
			rect.y = getMultilineEditableFigure().getEditionLocation().y;
			getMultilineEditableFigure().translateToAbsolute(rect);
			if(getMultilineEditableFigure().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
