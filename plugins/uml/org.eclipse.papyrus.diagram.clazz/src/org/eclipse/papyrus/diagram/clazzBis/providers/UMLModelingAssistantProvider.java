package org.eclipse.papyrus.diagram.clazzBis.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Slot_2002);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2003);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2004);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			ArrayList types = new ArrayList(2);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2007);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2008);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2009);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.EnumerationLiteral_2017);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			ArrayList types = new ArrayList(5);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2021);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Reception_2020);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2022);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2023);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			ArrayList types = new ArrayList(3);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2026);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2027);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateParameter_2006);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Slot_2002);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			ArrayList types = new ArrayList(4);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2003);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2004);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			ArrayList types = new ArrayList(2);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2007);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			ArrayList types = new ArrayList(4);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2008);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2009);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.EnumerationLiteral_2017);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			ArrayList types = new ArrayList(5);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2021);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Reception_2020);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2022);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2023);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			ArrayList types = new ArrayList(3);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2026);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2027);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart) {
			ArrayList types = new ArrayList(12);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart) {
			ArrayList types = new ArrayList(12);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart) {
			ArrayList types = new ArrayList(12);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart) {
			ArrayList types = new ArrayList(12);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
			return types;
		}
		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart) {
			ArrayList types = new ArrayList(15);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			return ((org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
