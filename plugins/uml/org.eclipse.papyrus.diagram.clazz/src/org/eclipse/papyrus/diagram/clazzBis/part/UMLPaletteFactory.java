package org.eclipse.papyrus.diagram.clazzBis.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDefault1Group());
		paletteRoot.add(createClassifiers2Group());
		paletteRoot.add(createRelationShips3Group());
		paletteRoot.add(createFeatures4Group());
		paletteRoot.add(createTemplate5Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Default1Group_desc);
		paletteContainer.add(createModel1CreationTool());
		paletteContainer.add(createPackage2CreationTool());
		paletteContainer.add(createConstraint3CreationTool());
		paletteContainer.add(createConstraintlink4CreationTool());
		paletteContainer.add(createComment5CreationTool());
		paletteContainer.add(createCommentlink6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Classifiers" palette tool group
	 * @generated
	 */
	private PaletteContainer createClassifiers2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Classifiers2Group_title);
		paletteContainer.setId("createClassifiers2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Classifiers2Group_desc);
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
	 * Creates "RelationShips" palette tool group
	 * @generated
	 */
	private PaletteContainer createRelationShips3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(org.eclipse.papyrus.diagram.clazzBis.part.Messages.RelationShips3Group_title);
		paletteContainer.setId("createRelationShips3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.RelationShips3Group_desc);
		paletteContainer.add(createAbstraction1CreationTool());
		paletteContainer.add(createAssociation2CreationTool());
		paletteContainer.add(createAssociationClass3CreationTool());
		paletteContainer.add(createDependency4CreationTool());
		paletteContainer.add(createElementImport5CreationTool());
		paletteContainer.add(createGeneralization6CreationTool());
		paletteContainer.add(createInterfaceRealization7CreationTool());
		paletteContainer.add(createPackageImport8CreationTool());
		paletteContainer.add(createPackageMerge9CreationTool());
		paletteContainer.add(createProfileApplication10CreationTool());
		paletteContainer.add(createRealization11CreationTool());
		paletteContainer.add(createSubstitution12CreationTool());
		paletteContainer.add(createUsage13CreationTool());
		paletteContainer.add(createTemplateBinding14CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Features" palette tool group
	 * @generated
	 */
	private PaletteContainer createFeatures4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Features4Group_title);
		paletteContainer.setId("createFeatures4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Features4Group_desc);
		paletteContainer.add(createReception1CreationTool());
		paletteContainer.add(createProperty2CreationTool());
		paletteContainer.add(createOperation3CreationTool());
		paletteContainer.add(createSlot4CreationTool());
		paletteContainer.add(createLiteralEnumeration5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Template" palette tool group
	 * @generated
	 */
	private PaletteContainer createTemplate5Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Template5Group_title);
		paletteContainer.setId("createTemplate5Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Template5Group_desc);
		paletteContainer.add(createRedefinableTemplateSignature1CreationTool());
		paletteContainer.add(createTemplateParameter2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModel1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Model1CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Model1CreationTool_desc, types);
		entry.setId("createModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Package2CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Package2CreationTool_desc, types);
		entry.setId("createPackage2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Constraint3CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Constraint3CreationTool_desc, types);
		entry.setId("createConstraint3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraintlink4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Constraintlink4CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Constraintlink4CreationTool_desc, types);
		entry.setId("createConstraintlink4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes
				.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Comment5CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Comment5CreationTool_desc, types);
		entry.setId("createComment5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentlink6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Commentlink6CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Commentlink6CreationTool_desc, types);
		entry.setId("createCommentlink6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes
				.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2004);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2023);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Class1CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Class1CreationTool_desc, types);
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Component2CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Component2CreationTool_desc, types);
		entry.setId("createComponent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataType3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.DataType3CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.DataType3CreationTool_desc, types);
		entry.setId("createDataType3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Enumeration4CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Enumeration4CreationTool_desc, types);
		entry.setId("createEnumeration4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Interface5CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Interface5CreationTool_desc, types);
		entry.setId("createInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPrimitiveType6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.PrimitiveType6CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.PrimitiveType6CreationTool_desc, types);
		entry.setId("createPrimitiveType6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSignal7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Signal7CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Signal7CreationTool_desc, types);
		entry.setId("createSignal7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInstanceSpecification8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.InstanceSpecification8CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.InstanceSpecification8CreationTool_desc, types);
		entry.setId("createInstanceSpecification8CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes
						.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbstraction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Abstraction1CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Abstraction1CreationTool_desc, types);
		entry.setId("createAbstraction1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Association2CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Association2CreationTool_desc, types);
		entry.setId("createAssociation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationClass3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.AssociationClass3CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.AssociationClass3CreationTool_desc, types);
		entry.setId("createAssociationClass3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Dependency4CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Dependency4CreationTool_desc, types);
		entry.setId("createDependency4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.ElementImport5CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.ElementImport5CreationTool_desc, types);
		entry.setId("createElementImport5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Generalization6CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Generalization6CreationTool_desc, types);
		entry.setId("createGeneralization6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterfaceRealization7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.InterfaceRealization7CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.InterfaceRealization7CreationTool_desc, types);
		entry.setId("createInterfaceRealization7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageImport8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.PackageImport8CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.PackageImport8CreationTool_desc, types);
		entry.setId("createPackageImport8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageMerge9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageMerge_3015);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.PackageMerge9CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.PackageMerge9CreationTool_desc, types);
		entry.setId("createPackageMerge9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageMerge_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProfileApplication10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ProfileApplication_3016);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.ProfileApplication10CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.ProfileApplication10CreationTool_desc, types);
		entry.setId("createProfileApplication10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ProfileApplication_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealization11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Realization11CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Realization11CreationTool_desc, types);
		entry.setId("createRealization11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubstitution12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Substitution12CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Substitution12CreationTool_desc, types);
		entry.setId("createSubstitution12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsage13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Usage13CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Usage13CreationTool_desc, types);
		entry.setId("createUsage13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateBinding14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		LinkToolEntry entry = new LinkToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.TemplateBinding14CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.TemplateBinding14CreationTool_desc, types);
		entry.setId("createTemplateBinding14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReception1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Reception_2020);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Reception1CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Reception1CreationTool_desc, types);
		entry.setId("createReception1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Reception_2020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2007);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2008);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2021);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2026);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Property2CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Property2CreationTool_desc, types);
		entry.setId("createProperty2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2003);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2009);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2022);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2027);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Operation3CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.Operation3CreationTool_desc, types);
		entry.setId("createOperation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSlot4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Slot_2002);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.Slot4CreationTool_title, org.eclipse.papyrus.diagram.clazzBis.part.Messages.Slot4CreationTool_desc,
				types);
		entry.setId("createSlot4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Slot_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLiteralEnumeration5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.EnumerationLiteral_2017);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.LiteralEnumeration5CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.LiteralEnumeration5CreationTool_desc, types);
		entry.setId("createLiteralEnumeration5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.EnumerationLiteral_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRedefinableTemplateSignature1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.RedefinableTemplateSignature1CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.RedefinableTemplateSignature1CreationTool_desc, types);
		entry.setId("createRedefinableTemplateSignature1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes
				.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateParameter2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateParameter_2006);
		NodeToolEntry entry = new NodeToolEntry(org.eclipse.papyrus.diagram.clazzBis.part.Messages.TemplateParameter2CreationTool_title,
				org.eclipse.papyrus.diagram.clazzBis.part.Messages.TemplateParameter2CreationTool_desc, types);
		entry.setId("createTemplateParameter2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateParameter_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
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
}
