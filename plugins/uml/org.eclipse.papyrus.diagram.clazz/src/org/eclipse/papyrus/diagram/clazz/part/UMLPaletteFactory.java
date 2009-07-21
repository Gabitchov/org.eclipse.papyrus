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
package org.eclipse.papyrus.diagram.clazz.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbstraction1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Abstraction_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.Abstraction1CreationTool_title,
				Messages.Abstraction1CreationTool_desc, types);
		entry.setId("createAbstraction1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Abstraction_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Association_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.Association2CreationTool_title,
				Messages.Association2CreationTool_desc, types);
		entry.setId("createAssociation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationBranch3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Association_4019);
		LinkToolEntry entry = new LinkToolEntry(Messages.AssociationBranch3CreationTool_title,
				Messages.AssociationBranch3CreationTool_desc, types);
		entry.setId("createAssociationBranch3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationClass4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.AssociationClass_4017);
		LinkToolEntry entry = new LinkToolEntry(Messages.AssociationClass4CreationTool_title,
				Messages.AssociationClass4CreationTool_desc, types);
		entry.setId("createAssociationClass4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.AssociationClass_4017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(5);
		types.add(UMLElementTypes.Class_3004);
		types.add(UMLElementTypes.Class_3008);
		types.add(UMLElementTypes.Class_3010);
		types.add(UMLElementTypes.Class_3014);
		types.add(UMLElementTypes.Class_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Class1CreationTool_title, Messages.Class1CreationTool_desc,
				types);
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Class_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates "Classifiers" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createClassifiers2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Classifiers2Group_title);
		paletteContainer.setId("createClassifiers2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Classifiers2Group_desc);
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createComponent2CreationTool());
		paletteContainer.add(createDataType3CreationTool());
		paletteContainer.add(createEnumeration4CreationTool());
		paletteContainer.add(createInterface5CreationTool());
		paletteContainer.add(createPrimitiveType6CreationTool());
		paletteContainer.add(createSignal7CreationTool());
		paletteContainer.add(createInstanceSpecification8CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Comment_3028);
		types.add(UMLElementTypes.Comment_2012);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment5CreationTool_title,
				Messages.Comment5CreationTool_desc, types);
		entry.setId("createComment5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_3028));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentlink6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4013);
		LinkToolEntry entry = new LinkToolEntry(Messages.Commentlink6CreationTool_title,
				Messages.Commentlink6CreationTool_desc, types);
		entry.setId("createCommentlink6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Component_2002);
		types.add(UMLElementTypes.Component_3021);
		NodeToolEntry entry = new NodeToolEntry(Messages.Component2CreationTool_title,
				Messages.Component2CreationTool_desc, types);
		entry.setId("createComponent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Component_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Constraint_3029);
		types.add(UMLElementTypes.Constraint_2011);
		NodeToolEntry entry = new NodeToolEntry(Messages.Constraint3CreationTool_title,
				Messages.Constraint3CreationTool_desc, types);
		entry.setId("createConstraint3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_3029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraintlink4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		LinkToolEntry entry = new LinkToolEntry(Messages.Constraintlink4CreationTool_title,
				Messages.Constraintlink4CreationTool_desc, types);
		entry.setId("createConstraintlink4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataType3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.DataType_3027);
		types.add(UMLElementTypes.DataType_2010);
		NodeToolEntry entry = new NodeToolEntry(Messages.DataType3CreationTool_title,
				Messages.DataType3CreationTool_desc, types);
		entry.setId("createDataType3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DataType_3027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Dependency_4008);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency5CreationTool_title,
				Messages.Dependency5CreationTool_desc, types);
		entry.setId("createDependency5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependencyBranch6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Dependency_4018);
		LinkToolEntry entry = new LinkToolEntry(Messages.DependencyBranch6CreationTool_title,
				Messages.DependencyBranch6CreationTool_desc, types);
		entry.setId("createDependencyBranch6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.ElementImport_4009);
		LinkToolEntry entry = new LinkToolEntry(Messages.ElementImport7CreationTool_title,
				Messages.ElementImport7CreationTool_desc, types);
		entry.setId("createElementImport7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Enumeration_3025);
		types.add(UMLElementTypes.Enumeration_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Enumeration4CreationTool_title,
				Messages.Enumeration4CreationTool_desc, types);
		entry.setId("createEnumeration4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Enumeration_3025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumerationliteral5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.EnumerationLiteral_3017);
		NodeToolEntry entry = new NodeToolEntry(Messages.Enumerationliteral5CreationTool_title,
				Messages.Enumerationliteral5CreationTool_desc, types);
		entry.setId("createEnumerationliteral5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.EnumerationLiteral_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates "Features" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createFeatures4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Features4Group_title);
		paletteContainer.setId("createFeatures4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Features4Group_desc);
		paletteContainer.add(createReception1CreationTool());
		paletteContainer.add(createProperty2CreationTool());
		paletteContainer.add(createOperation3CreationTool());
		paletteContainer.add(createSlot4CreationTool());
		paletteContainer.add(createEnumerationliteral5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Generalization_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization8CreationTool_title,
				Messages.Generalization8CreationTool_desc, types);
		entry.setId("createGeneralization8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInstanceSpecification8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.InstanceSpecification_2001);
		types.add(UMLElementTypes.InstanceSpecification_3020);
		NodeToolEntry entry = new NodeToolEntry(Messages.InstanceSpecification8CreationTool_title,
				Messages.InstanceSpecification8CreationTool_desc, types);
		entry.setId("createInstanceSpecification8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InstanceSpecification_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Interface_2004);
		types.add(UMLElementTypes.Interface_3023);
		NodeToolEntry entry = new NodeToolEntry(Messages.Interface5CreationTool_title,
				Messages.Interface5CreationTool_desc, types);
		entry.setId("createInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Interface_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterfaceRealization9CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.InterfaceRealization_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.InterfaceRealization9CreationTool_title,
				Messages.InterfaceRealization9CreationTool_desc, types);
		entry.setId("createInterfaceRealization9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InterfaceRealization_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModel1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Model_2005);
		types.add(UMLElementTypes.Model_3024);
		NodeToolEntry entry = new NodeToolEntry(Messages.Model1CreationTool_title, Messages.Model1CreationTool_desc,
				types);
		entry.setId("createModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Model_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(4);
		types.add(UMLElementTypes.Operation_3003);
		types.add(UMLElementTypes.Operation_3007);
		types.add(UMLElementTypes.Operation_3013);
		types.add(UMLElementTypes.Operation_3019);
		NodeToolEntry entry = new NodeToolEntry(Messages.Operation3CreationTool_title,
				Messages.Operation3CreationTool_desc, types);
		entry.setId("createOperation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Operation_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Package_3009);
		types.add(UMLElementTypes.Package_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Package2CreationTool_title,
				Messages.Package2CreationTool_desc, types);
		entry.setId("createPackage2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Package_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageImport10CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.PackageImport_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.PackageImport10CreationTool_title,
				Messages.PackageImport10CreationTool_desc, types);
		entry.setId("createPackageImport10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PackageImport_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageMerge11CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.PackageMerge_4011);
		LinkToolEntry entry = new LinkToolEntry(Messages.PackageMerge11CreationTool_title,
				Messages.PackageMerge11CreationTool_desc, types);
		entry.setId("createPackageMerge11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PackageMerge_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates "Packages" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createPackages1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Packages1Group_title);
		paletteContainer.setId("createPackages1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Packages1Group_desc);
		paletteContainer.add(createModel1CreationTool());
		paletteContainer.add(createPackage2CreationTool());
		paletteContainer.add(createConstraint3CreationTool());
		paletteContainer.add(createConstraintlink4CreationTool());
		paletteContainer.add(createComment5CreationTool());
		paletteContainer.add(createCommentlink6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPrimitiveType6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.PrimitiveType_3026);
		types.add(UMLElementTypes.PrimitiveType_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.PrimitiveType6CreationTool_title,
				Messages.PrimitiveType6CreationTool_desc, types);
		entry.setId("createPrimitiveType6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PrimitiveType_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProfileApplication12CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.ProfileApplication_4012);
		LinkToolEntry entry = new LinkToolEntry(Messages.ProfileApplication12CreationTool_title,
				Messages.ProfileApplication12CreationTool_desc, types);
		entry.setId("createProfileApplication12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ProfileApplication_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(5);
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3005);
		types.add(UMLElementTypes.Property_3006);
		types.add(UMLElementTypes.Property_3012);
		types.add(UMLElementTypes.Property_3018);
		NodeToolEntry entry = new NodeToolEntry(Messages.Property2CreationTool_title,
				Messages.Property2CreationTool_desc, types);
		entry.setId("createProperty2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealization13CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Realization_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.Realization13CreationTool_title,
				Messages.Realization13CreationTool_desc, types);
		entry.setId("createRealization13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Realization_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReception1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Reception_3011);
		NodeToolEntry entry = new NodeToolEntry(Messages.Reception1CreationTool_title,
				Messages.Reception1CreationTool_desc, types);
		entry.setId("createReception1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Reception_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRedefinableTemplateSignature1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		NodeToolEntry entry = new NodeToolEntry(Messages.RedefinableTemplateSignature1CreationTool_title,
				Messages.RedefinableTemplateSignature1CreationTool_desc, types);
		entry.setId("createRedefinableTemplateSignature1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.RedefinableTemplateSignature_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates "RelationShips" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createRelationShips3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.RelationShips3Group_title);
		paletteContainer.setId("createRelationShips3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.RelationShips3Group_desc);
		paletteContainer.add(createAbstraction1CreationTool());
		paletteContainer.add(createAssociation2CreationTool());
		paletteContainer.add(createAssociationBranch3CreationTool());
		paletteContainer.add(createAssociationClass4CreationTool());
		paletteContainer.add(createDependency5CreationTool());
		paletteContainer.add(createDependencyBranch6CreationTool());
		paletteContainer.add(createElementImport7CreationTool());
		paletteContainer.add(createGeneralization8CreationTool());
		paletteContainer.add(createInterfaceRealization9CreationTool());
		paletteContainer.add(createPackageImport10CreationTool());
		paletteContainer.add(createPackageMerge11CreationTool());
		paletteContainer.add(createProfileApplication12CreationTool());
		paletteContainer.add(createRealization13CreationTool());
		paletteContainer.add(createSubstitution14CreationTool());
		paletteContainer.add(createUsage15CreationTool());
		paletteContainer.add(createTemplateBinding16CreationTool());
		paletteContainer.add(createGeneralizationSet17CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSignal7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Signal_2003);
		types.add(UMLElementTypes.Signal_3022);
		NodeToolEntry entry = new NodeToolEntry(Messages.Signal7CreationTool_title, Messages.Signal7CreationTool_desc,
				types);
		entry.setId("createSignal7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Signal_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSlot4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Slot_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Slot4CreationTool_title, Messages.Slot4CreationTool_desc,
				types);
		entry.setId("createSlot4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Slot_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubstitution14CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Substitution_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.Substitution14CreationTool_title,
				Messages.Substitution14CreationTool_desc, types);
		entry.setId("createSubstitution14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Substitution_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates "Template" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createTemplate5Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Template5Group_title);
		paletteContainer.setId("createTemplate5Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Template5Group_desc);
		paletteContainer.add(createRedefinableTemplateSignature1CreationTool());
		paletteContainer.add(createTemplateParameter2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateBinding16CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.TemplateBinding_4015);
		LinkToolEntry entry = new LinkToolEntry(Messages.TemplateBinding16CreationTool_title,
				Messages.TemplateBinding16CreationTool_desc, types);
		entry.setId("createTemplateBinding16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.TemplateBinding_4015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralizationSet17CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.GeneralizationSet_4020);
		LinkToolEntry entry = new LinkToolEntry(Messages.GeneralizationSet17CreationTool_title,
				Messages.GeneralizationSet17CreationTool_desc, types);
		entry.setId("createGeneralizationSet17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.GeneralizationSet_4020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateParameter2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.TemplateParameter_3016);
		NodeToolEntry entry = new NodeToolEntry(Messages.TemplateParameter2CreationTool_title,
				Messages.TemplateParameter2CreationTool_desc, types);
		entry.setId("createTemplateParameter2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.TemplateParameter_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsage15CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Usage_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.Usage15CreationTool_title, Messages.Usage15CreationTool_desc,
				types);
		entry.setId("createUsage15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Usage_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createPackages1Group());
		paletteRoot.add(createClassifiers2Group());
		paletteRoot.add(createRelationShips3Group());
		paletteRoot.add(createFeatures4Group());
		paletteRoot.add(createTemplate5Group());
	}
}
