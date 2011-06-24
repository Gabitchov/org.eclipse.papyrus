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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.providers;

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
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.part.Messages;
import org.eclipse.papyrus.diagram.profile.part.UMLDiagramEditorPlugin;
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
		if(editPart instanceof ProfileDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(13);
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Comment_1002);
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Diagram_2016);
			return types;
		}
		if(editPart instanceof StereotypeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3020);
			return types;
		}
		if(editPart instanceof EnumerationEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.EnumerationLiteral_1037);
			return types;
		}
		if(editPart instanceof DataTypeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3018);
			types.add(UMLElementTypes.Operation_3019);
			return types;
		}
		if(editPart instanceof StereotypeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3020);
			return types;
		}
		if(editPart instanceof PackageEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Package_1012);
			return types;
		}
		if(editPart instanceof EnumerationEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.EnumerationLiteral_1037);
			return types;
		}
		if(editPart instanceof DataTypeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3018);
			types.add(UMLElementTypes.Operation_3019);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Comment_1007);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Comment_1007);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			return types;
		}
		if(editPart instanceof ProfilePackageableElementCompartmentEditPartTN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_1007);
			types.add(UMLElementTypes.Class_3028);
			return types;
		}
		if(editPart instanceof ProfilePackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_1007);
			types.add(UMLElementTypes.Class_3028);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPartTN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Comment_1007);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Comment_1007);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof MetaclassEditPart) {
			return ((MetaclassEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ProfileEditPartTN) {
			return ((ProfileEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StereotypeEditPartCN) {
			return ((StereotypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof MetaclassEditPartCN) {
			return ((MetaclassEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ProfileEditPartCN) {
			return ((ProfileEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			return ((MetaclassEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			return ((ProfileEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			return ((StereotypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			return ((MetaclassEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			return ((ProfileEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof MetaclassEditPart) {
			return ((MetaclassEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ProfileEditPartTN) {
			return ((ProfileEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StereotypeEditPartCN) {
			return ((StereotypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof MetaclassEditPartCN) {
			return ((MetaclassEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ProfileEditPartCN) {
			return ((ProfileEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			return ((MetaclassEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			return ((ProfileEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			return ((StereotypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			return ((MetaclassEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			return ((ProfileEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof AssociationNodeEditPart) {
			return ((AssociationNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof MetaclassEditPart) {
			return ((MetaclassEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPartTN) {
			return ((ModelEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ProfileEditPartTN) {
			return ((ProfileEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StereotypeEditPartCN) {
			return ((StereotypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof MetaclassEditPartCN) {
			return ((MetaclassEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ProfileEditPartCN) {
			return ((ProfileEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
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
		HashSet<EObject> elements = new HashSet<EObject>();
		for(Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
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
