/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.parts;

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
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
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
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case ModelEditPart.VISUAL_ID:
				return new ModelEditPart(view);

			case Dependency2EditPart.VISUAL_ID:
				return new Dependency2EditPart(view);

			case AssociationClassEditPart.VISUAL_ID:
				return new AssociationClassEditPart(view);

			case AssociationClassName2EditPart.VISUAL_ID:
				return new AssociationClassName2EditPart(view);

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

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case ShortCutDiagramEditPart.VISUAL_ID:
				return new ShortCutDiagramEditPart(view);

			case DiagramNameEditPart.VISUAL_ID:
				return new DiagramNameEditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case OperationEditPart.VISUAL_ID:
				return new OperationEditPart(view);

			case Class2EditPart.VISUAL_ID:
				return new Class2EditPart(view);

			case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				return new RedefinableTemplateSignatureEditPart(view);

			case TemplateParameterEditPart.VISUAL_ID:
				return new TemplateParameterEditPart(view);

			case Property2EditPart.VISUAL_ID:
				return new Property2EditPart(view);

			case Property3EditPart.VISUAL_ID:
				return new Property3EditPart(view);

			case Operation2EditPart.VISUAL_ID:
				return new Operation2EditPart(view);

			case Class3EditPart.VISUAL_ID:
				return new Class3EditPart(view);

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

			case EnumerationLiteralEditPart.VISUAL_ID:
				return new EnumerationLiteralEditPart(view);

			case PackageEditPartCN.VISUAL_ID:
				return new PackageEditPartCN(view);

			case PackageNameEditPartCN.VISUAL_ID:
				return new PackageNameEditPartCN(view);

			case ClassEditPartCN.VISUAL_ID:
				return new ClassEditPartCN(view);

			case ClassNameEditPartCN.VISUAL_ID:
				return new ClassNameEditPartCN(view);

			case ReceptionEditPart.VISUAL_ID:
				return new ReceptionEditPart(view);

			case Property4EditPart.VISUAL_ID:
				return new Property4EditPart(view);

			case Operation3EditPart.VISUAL_ID:
				return new Operation3EditPart(view);

			case Class5EditPart.VISUAL_ID:
				return new Class5EditPart(view);

			case PrimitiveTypeEditPartCN.VISUAL_ID:
				return new PrimitiveTypeEditPartCN(view);

			case PrimitiveTypeNameEditPartCN.VISUAL_ID:
				return new PrimitiveTypeNameEditPartCN(view);

			case DataTypeEditPartCN.VISUAL_ID:
				return new DataTypeEditPartCN(view);

			case DataTypeNameEditPartCN.VISUAL_ID:
				return new DataTypeNameEditPartCN(view);

			case Property5EditPart.VISUAL_ID:
				return new Property5EditPart(view);

			case Operation4EditPart.VISUAL_ID:
				return new Operation4EditPart(view);

			case Comment2EditPart.VISUAL_ID:
				return new Comment2EditPart(view);

			case CommentBody2EditPart.VISUAL_ID:
				return new CommentBody2EditPart(view);

			case Constraint2EditPart.VISUAL_ID:
				return new Constraint2EditPart(view);

			case ConstraintName2EditPart.VISUAL_ID:
				return new ConstraintName2EditPart(view);

			case SlotEditPart.VISUAL_ID:
				return new SlotEditPart(view);

			case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
				return new AssociationClassAttributeCompartmentEditPart(view);

			case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
				return new InstanceSpecificationSlotCompartmentEditPart(view);

			case ComponentAttributeCompartmentEditPart.VISUAL_ID:
				return new ComponentAttributeCompartmentEditPart(view);

			case ComponentOperationCompartmentEditPart.VISUAL_ID:
				return new ComponentOperationCompartmentEditPart(view);

			case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new ComponentNestedClassifierCompartmentEditPart(view);

			case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
				return new RedefinableTemplateSignatureTemplateParameterCompartmentEditPart(view);

			case SignalAttributeCompartmentEditPart.VISUAL_ID:
				return new SignalAttributeCompartmentEditPart(view);

			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				return new InterfaceAttributeCompartmentEditPart(view);

			case InterfaceOperationCompartmentEditPart.VISUAL_ID:
				return new InterfaceOperationCompartmentEditPart(view);

			case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new InterfaceNestedClassifierCompartmentEditPart(view);

			case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPart(view);

			case ComponentAttributeCompartment2EditPart.VISUAL_ID:
				return new ComponentAttributeCompartment2EditPart(view);

			case ComponentOperationCompartment2EditPart.VISUAL_ID:
				return new ComponentOperationCompartment2EditPart(view);

			case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new ComponentNestedClassifierCompartment2EditPart(view);

			case SignalAttributeCompartment2EditPart.VISUAL_ID:
				return new SignalAttributeCompartment2EditPart(view);

			case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
				return new InterfaceAttributeCompartment2EditPart(view);

			case InterfaceOperationCompartment2EditPart.VISUAL_ID:
				return new InterfaceOperationCompartment2EditPart(view);

			case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new InterfaceNestedClassifierCompartment2EditPart(view);

			case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
				return new ModelPackageableElementCompartment2EditPart(view);

			case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartment2EditPart(view);

			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPart(view);

			case ClassAttributeCompartmentEditPart.VISUAL_ID:
				return new ClassAttributeCompartmentEditPart(view);

			case ClassOperationCompartmentEditPart.VISUAL_ID:
				return new ClassOperationCompartmentEditPart(view);

			case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new ClassNestedClassifierCompartmentEditPart(view);

			case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
				return new DataTypeAttributeCompartment2EditPart(view);

			case DataTypeOperationCompartment2EditPart.VISUAL_ID:
				return new DataTypeOperationCompartment2EditPart(view);

			case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPart(view);

			case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
				return new PackagePackageableElementCompartment2EditPart(view);

			case ClassAttributeCompartment2EditPart.VISUAL_ID:
				return new ClassAttributeCompartment2EditPart(view);

			case ClassOperationCompartment2EditPart.VISUAL_ID:
				return new ClassOperationCompartment2EditPart(view);

			case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new ClassNestedClassifierCompartment2EditPart(view);

			case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPart(view);

			case DataTypeOperationCompartmentEditPart.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPart(view);

			case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
				return new InstanceSpecificationSlotCompartmentEditPartCN(view);

			case CommentLinkDescriptorEditPart.VISUAL_ID:
				return new CommentLinkDescriptorEditPart(view);

			case AssociationClass2EditPart.VISUAL_ID:
				return new AssociationClass2EditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AppliedStereotypeAssociationEditPart.VISUAL_ID:
				return new AppliedStereotypeAssociationEditPart(view);

			case AssociationName2EditPart.VISUAL_ID:
				return new AssociationName2EditPart(view);

			case AssociationName3EditPart.VISUAL_ID:
				return new AssociationName3EditPart(view);

			case AssociationName4EditPart.VISUAL_ID:
				return new AssociationName4EditPart(view);

			case AssociationName5EditPart.VISUAL_ID:
				return new AssociationName5EditPart(view);

			case AssociationName6EditPart.VISUAL_ID:
				return new AssociationName6EditPart(view);

			case AssociationBranchEditPart.VISUAL_ID:
				return new AssociationBranchEditPart(view);

			case AssociationBranchRoleEditPart.VISUAL_ID:
				return new AssociationBranchRoleEditPart(view);

			case AssociationBranchMultEditPart.VISUAL_ID:
				return new AssociationBranchMultEditPart(view);

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

			case SubstitutionName2EditPart.VISUAL_ID:
				return new SubstitutionName2EditPart(view);

			case RealizationEditPart.VISUAL_ID:
				return new RealizationEditPart(view);

			case AppliedStereotypeRealizationEditPart.VISUAL_ID:
				return new AppliedStereotypeRealizationEditPart(view);

			case RealizationName2EditPart.VISUAL_ID:
				return new RealizationName2EditPart(view);

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

			case DependencyName3EditPart.VISUAL_ID:
				return new DependencyName3EditPart(view);

			case AppliedStereotypeDependency3EditPart.VISUAL_ID:
				return new AppliedStereotypeDependency3EditPart(view);

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

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case GeneralizationSetEditPart.VISUAL_ID:
				return new GeneralizationSetEditPart(view);

			case ConstraintLabelEditPart.VISUAL_ID:
				return new ConstraintLabelEditPart(view);

			case InstanceSpecificationLinkEditPart.VISUAL_ID:
				return new InstanceSpecificationLinkEditPart(view);

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
