package org.eclipse.papyrus.diagram.clazz.part;

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
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

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

	/**
	 * Creates "Packages" palette tool group
	 * @generated
	 */
	private PaletteContainer createPackages1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Packages1Group_title);
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
	 * Creates "Classifiers" palette tool group
	 * @generated
	 */
	private PaletteContainer createClassifiers2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Classifiers2Group_title);
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
	 * Creates "RelationShips" palette tool group
	 * @generated
	 */
	private PaletteContainer createRelationShips3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.RelationShips3Group_title);
		paletteContainer.setId("createRelationShips3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.RelationShips3Group_desc);
		paletteContainer.add(createAbstraction1CreationTool());
		paletteContainer.add(createAssociation2CreationTool());
		paletteContainer.add(createAssociationClass3CreationTool());
		paletteContainer.add(createDependency4CreationTool());
		paletteContainer.add(createDependencyBranch5CreationTool());
		paletteContainer.add(createElementImport6CreationTool());
		paletteContainer.add(createGeneralization7CreationTool());
		paletteContainer.add(createInterfaceRealization8CreationTool());
		paletteContainer.add(createPackageImport9CreationTool());
		paletteContainer.add(createPackageMerge10CreationTool());
		paletteContainer.add(createProfileApplication11CreationTool());
		paletteContainer.add(createRealization12CreationTool());
		paletteContainer.add(createSubstitution13CreationTool());
		paletteContainer.add(createUsage14CreationTool());
		paletteContainer.add(createTemplateBinding15CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Features" palette tool group
	 * @generated
	 */
	private PaletteContainer createFeatures4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Features4Group_title);
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
	 * Creates "Template" palette tool group
	 * @generated
	 */
	private PaletteContainer createTemplate5Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Template5Group_title);
		paletteContainer.setId("createTemplate5Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Template5Group_desc);
		paletteContainer.add(createRedefinableTemplateSignature1CreationTool());
		paletteContainer.add(createTemplateParameter2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModel1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Model_2005);
		types.add(UMLElementTypes.Model_3024);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Model1CreationTool_title,
				Messages.Model1CreationTool_desc, types);
		entry.setId("createModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Model_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Package_3009);
		types.add(UMLElementTypes.Package_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Package2CreationTool_title,
				Messages.Package2CreationTool_desc, types);
		entry.setId("createPackage2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Package_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Constraint_3029);
		types.add(UMLElementTypes.Constraint_2011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Constraint3CreationTool_title,
				Messages.Constraint3CreationTool_desc, types);
		entry.setId("createConstraint3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Constraint_3029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraintlink4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Constraintlink4CreationTool_title,
				Messages.Constraintlink4CreationTool_desc, types);
		entry.setId("createConstraintlink4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Comment_3028);
		types.add(UMLElementTypes.Comment_2012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Comment5CreationTool_title,
				Messages.Comment5CreationTool_desc, types);
		entry.setId("createComment5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Comment_3028));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentlink6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4013);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Commentlink6CreationTool_title,
				Messages.Commentlink6CreationTool_desc, types);
		entry.setId("createCommentlink6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types.add(UMLElementTypes.Class_3004);
		types.add(UMLElementTypes.Class_3008);
		types.add(UMLElementTypes.Class_3010);
		types.add(UMLElementTypes.Class_3014);
		types.add(UMLElementTypes.Class_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Class1CreationTool_title,
				Messages.Class1CreationTool_desc, types);
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Class_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Component_2002);
		types.add(UMLElementTypes.Component_3021);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Component2CreationTool_title,
				Messages.Component2CreationTool_desc, types);
		entry.setId("createComponent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Component_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataType3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.DataType_3027);
		types.add(UMLElementTypes.DataType_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataType3CreationTool_title,
				Messages.DataType3CreationTool_desc, types);
		entry.setId("createDataType3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.DataType_3027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Enumeration_3025);
		types.add(UMLElementTypes.Enumeration_2006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Enumeration4CreationTool_title,
				Messages.Enumeration4CreationTool_desc, types);
		entry.setId("createEnumeration4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Enumeration_3025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Interface_2004);
		types.add(UMLElementTypes.Interface_3023);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Interface5CreationTool_title,
				Messages.Interface5CreationTool_desc, types);
		entry.setId("createInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Interface_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPrimitiveType6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.PrimitiveType_3026);
		types.add(UMLElementTypes.PrimitiveType_2009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PrimitiveType6CreationTool_title,
				Messages.PrimitiveType6CreationTool_desc, types);
		entry.setId("createPrimitiveType6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.PrimitiveType_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSignal7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Signal_2003);
		types.add(UMLElementTypes.Signal_3022);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Signal7CreationTool_title,
				Messages.Signal7CreationTool_desc, types);
		entry.setId("createSignal7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Signal_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInstanceSpecification8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.InstanceSpecification_2001);
		types.add(UMLElementTypes.InstanceSpecification_3020);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InstanceSpecification8CreationTool_title,
				Messages.InstanceSpecification8CreationTool_desc, types);
		entry.setId("createInstanceSpecification8CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.InstanceSpecification_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbstraction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Abstraction_4006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Abstraction1CreationTool_title,
				Messages.Abstraction1CreationTool_desc, types);
		entry.setId("createAbstraction1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Abstraction_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Association_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Association2CreationTool_title,
				Messages.Association2CreationTool_desc, types);
		entry.setId("createAssociation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Association_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationClass3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.AssociationClass_4017);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AssociationClass3CreationTool_title,
				Messages.AssociationClass3CreationTool_desc, types);
		entry.setId("createAssociationClass3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.AssociationClass_4017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4008);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Dependency4CreationTool_title,
				Messages.Dependency4CreationTool_desc, types);
		entry.setId("createDependency4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Dependency_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependencyBranch5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4018);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.DependencyBranch5CreationTool_title,
				Messages.DependencyBranch5CreationTool_desc, types);
		entry.setId("createDependencyBranch5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Dependency_4018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_4009);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ElementImport6CreationTool_title,
				Messages.ElementImport6CreationTool_desc, types);
		entry.setId("createElementImport6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ElementImport_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Generalization_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Generalization7CreationTool_title,
				Messages.Generalization7CreationTool_desc, types);
		entry.setId("createGeneralization7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Generalization_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterfaceRealization8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.InterfaceRealization_4003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.InterfaceRealization8CreationTool_title,
				Messages.InterfaceRealization8CreationTool_desc, types);
		entry.setId("createInterfaceRealization8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.InterfaceRealization_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageImport9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.PackageImport_4010);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.PackageImport9CreationTool_title,
				Messages.PackageImport9CreationTool_desc, types);
		entry.setId("createPackageImport9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.PackageImport_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageMerge10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.PackageMerge_4011);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.PackageMerge10CreationTool_title,
				Messages.PackageMerge10CreationTool_desc, types);
		entry.setId("createPackageMerge10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.PackageMerge_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProfileApplication11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ProfileApplication_4012);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ProfileApplication11CreationTool_title,
				Messages.ProfileApplication11CreationTool_desc, types);
		entry.setId("createProfileApplication11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ProfileApplication_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealization12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Realization_4005);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Realization12CreationTool_title,
				Messages.Realization12CreationTool_desc, types);
		entry.setId("createRealization12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Realization_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubstitution13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Substitution_4004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Substitution13CreationTool_title,
				Messages.Substitution13CreationTool_desc, types);
		entry.setId("createSubstitution13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Substitution_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsage14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Usage_4007);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Usage14CreationTool_title,
				Messages.Usage14CreationTool_desc, types);
		entry.setId("createUsage14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Usage_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateBinding15CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.TemplateBinding_4015);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.TemplateBinding15CreationTool_title,
				Messages.TemplateBinding15CreationTool_desc, types);
		entry.setId("createTemplateBinding15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.TemplateBinding_4015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReception1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Reception_3011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Reception1CreationTool_title,
				Messages.Reception1CreationTool_desc, types);
		entry.setId("createReception1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Reception_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3005);
		types.add(UMLElementTypes.Property_3006);
		types.add(UMLElementTypes.Property_3012);
		types.add(UMLElementTypes.Property_3018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Property2CreationTool_title,
				Messages.Property2CreationTool_desc, types);
		entry.setId("createProperty2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Property_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(UMLElementTypes.Operation_3003);
		types.add(UMLElementTypes.Operation_3007);
		types.add(UMLElementTypes.Operation_3013);
		types.add(UMLElementTypes.Operation_3019);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Operation3CreationTool_title,
				Messages.Operation3CreationTool_desc, types);
		entry.setId("createOperation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Operation_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSlot4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Slot_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Slot4CreationTool_title,
				Messages.Slot4CreationTool_desc, types);
		entry.setId("createSlot4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Slot_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumerationliteral5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.EnumerationLiteral_3017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Enumerationliteral5CreationTool_title,
				Messages.Enumerationliteral5CreationTool_desc, types);
		entry.setId("createEnumerationliteral5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.EnumerationLiteral_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRedefinableTemplateSignature1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RedefinableTemplateSignature1CreationTool_title,
				Messages.RedefinableTemplateSignature1CreationTool_desc, types);
		entry.setId("createRedefinableTemplateSignature1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.RedefinableTemplateSignature_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateParameter2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.TemplateParameter_3016);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.TemplateParameter2CreationTool_title,
				Messages.TemplateParameter2CreationTool_desc, types);
		entry.setId("createTemplateParameter2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.TemplateParameter_3016));
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
		private NodeToolEntry(String title, String description,
				List elementTypes) {
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
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
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
