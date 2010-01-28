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
package org.eclipse.papyrus.diagram.clazz.providers;

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
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPartCN;
import org.eclipse.papyrus.diagram.clazz.part.Messages;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
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
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof AssociationClassEditPart) {
			ArrayList types = new ArrayList(3);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3003);
			types.add(UMLElementTypes.Class_3004);
			return types;
		}
		if(editPart instanceof InstanceSpecificationEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.Slot_3030);
			return types;
		}
		if(editPart instanceof ComponentEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3003);
			types.add(UMLElementTypes.Class_3004);
			return types;
		}
		if(editPart instanceof SignalEditPart) {
			ArrayList types = new ArrayList(2);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3005);
			return types;
		}
		if(editPart instanceof InterfaceEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Operation_3007);
			types.add(UMLElementTypes.Class_3008);
			return types;
		}
		if(editPart instanceof ModelEditPartTN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if(editPart instanceof EnumerationEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.EnumerationLiteral_3017);
			return types;
		}
		if(editPart instanceof PackageEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if(editPart instanceof ClassEditPart) {
			ArrayList types = new ArrayList(6);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Port_3032);
			types.add(UMLElementTypes.Property_3012);
			types.add(UMLElementTypes.Reception_3011);
			types.add(UMLElementTypes.Operation_3013);
			types.add(UMLElementTypes.Class_3014);
			return types;
		}
		if(editPart instanceof DataTypeEditPart) {
			ArrayList types = new ArrayList(3);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3018);
			types.add(UMLElementTypes.Operation_3019);
			return types;
		}
		if(editPart instanceof RedefinableTemplateSignatureEditPart) {
			ArrayList types = new ArrayList(2);
			types.add(UMLElementTypes.ClassifierTemplateParameter_3031);
			types.add(UMLElementTypes.TemplateParameter_3016);
			return types;
		}
		if(editPart instanceof InstanceSpecificationEditPartCN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.Slot_3030);
			return types;
		}
		if(editPart instanceof ComponentEditPartCN) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3003);
			types.add(UMLElementTypes.Class_3004);
			return types;
		}
		if(editPart instanceof SignalEditPartCN) {
			ArrayList types = new ArrayList(2);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3005);
			return types;
		}
		if(editPart instanceof InterfaceEditPartCN) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Operation_3007);
			types.add(UMLElementTypes.Class_3008);
			return types;
		}
		if(editPart instanceof ModelEditPartCN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if(editPart instanceof EnumerationEditPartCN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.EnumerationLiteral_3017);
			return types;
		}
		if(editPart instanceof PackageEditPartCN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if(editPart instanceof ClassEditPartCN) {
			ArrayList types = new ArrayList(5);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3012);
			types.add(UMLElementTypes.Reception_3011);
			types.add(UMLElementTypes.Operation_3013);
			types.add(UMLElementTypes.Class_3014);
			return types;
		}
		if(editPart instanceof DataTypeEditPartCN) {
			ArrayList types = new ArrayList(3);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3018);
			types.add(UMLElementTypes.Operation_3019);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPart) {
			ArrayList types = new ArrayList(12);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartment2EditPart) {
			ArrayList types = new ArrayList(12);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPart) {
			ArrayList types = new ArrayList(12);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartment2EditPart) {
			ArrayList types = new ArrayList(12);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if(editPart instanceof ModelEditPart) {
			ArrayList types = new ArrayList(16);
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.Comment_2012);
			types.add(UMLElementTypes.Diagram_2016);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof Dependency2EditPart) {
			return ((Dependency2EditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof AssociationClassEditPart) {
			return ((AssociationClassEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InstanceSpecificationEditPartCN) {
			return ((InstanceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ClassEditPartCN) {
			return ((ClassEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof Comment2EditPart) {
			return ((Comment2EditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ContainmentCircleEditPart) {
			return ((ContainmentCircleEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof Dependency2EditPart) {
			return ((Dependency2EditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			return ((AssociationClassEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ClassEditPart) {
			return ((ClassEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			return ((InstanceSpecificationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ClassEditPartCN) {
			return ((ClassEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof Comment2EditPart) {
			return ((Comment2EditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ContainmentCircleEditPart) {
			return ((ContainmentCircleEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof Dependency2EditPart) {
			return ((Dependency2EditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof AssociationClassEditPart) {
			return ((AssociationClassEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InstanceSpecificationEditPartCN) {
			return ((InstanceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ClassEditPartCN) {
			return ((ClassEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof Comment2EditPart) {
			return ((Comment2EditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ContainmentCircleEditPart) {
			return ((ContainmentCircleEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof Dependency2EditPart) {
			return ((Dependency2EditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			return ((AssociationClassEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ClassEditPart) {
			return ((ClassEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			return ((InstanceSpecificationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ClassEditPartCN) {
			return ((ClassEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof Comment2EditPart) {
			return ((Comment2EditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ContainmentCircleEditPart) {
			return ((ContainmentCircleEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof Dependency2EditPart) {
			return ((Dependency2EditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof AssociationClassEditPart) {
			return ((AssociationClassEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InstanceSpecificationEditPartCN) {
			return ((InstanceSpecificationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ClassEditPartCN) {
			return ((ClassEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof Comment2EditPart) {
			return ((Comment2EditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ContainmentCircleEditPart) {
			return ((ContainmentCircleEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
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
		if(types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram)editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for(Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject)it.next();
			if(isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if(elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[])elements.toArray(new EObject[elements.size()]));
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
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if(dialog.open() == Window.OK) {
			selected = (EObject)dialog.getFirstResult();
		}
		return selected;
	}
}
