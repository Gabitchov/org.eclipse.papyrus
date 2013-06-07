/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATEMODELCREATIONTOOL = "createModelCreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_PACKAGE = "deployment.tool.package"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_NODE = "deployment.tool.node"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEVICE = "deployment.tool.device"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_EXECUTIONENVIRONMENT = "deployment.tool.executionEnvironment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_ARTIFACT = "deployment.tool.artifact"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_COMMENT = "deployment.tool.comment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_CONSTRAINT = "deployment.tool.constraint"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_LINK = "deployment.tool.link"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPENDENCY = "deployment.tool.dependency"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPENDENCYBRANCH = "deployment.tool.dependencybranch"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_GENERALIZATION = "deployment.tool.generalization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPLOYMENT = "deployment.tool.deployment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_MANIFESTATION = "deployment.tool.manifestation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CREATEMODELCREATIONTOOL)) {
			return createModelCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_PACKAGE)) {
			return createPackageCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_NODE)) {
			return createNodeCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_DEVICE)) {
			return createDeviceCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_EXECUTIONENVIRONMENT)) {
			return createExecutionEnvironmentCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_ARTIFACT)) {
			return createArtifactCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_COMMENT)) {
			return createCommentCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_CONSTRAINT)) {
			return createConstraintCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_LINK)) {
			return createLinkCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_DEPENDENCY)) {
			return createDependencyCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_DEPENDENCYBRANCH)) {
			return createDependencyBranchCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_GENERALIZATION)) {
			return createGeneralizationCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_DEPLOYMENT)) {
			return createDeploymentCreationTool();
		}
		if(toolId.equals(DEPLOYMENT_TOOL_MANIFESTATION)) {
			return createManifestationCreationTool();
		}

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createModelCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Model_49);
		types.add(UMLElementTypes.Model_2010);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_2009);
		types.add(UMLElementTypes.Package_36);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createNodeCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Node_2008);
		types.add(UMLElementTypes.Node_23);
		types.add(UMLElementTypes.Node_42);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeviceCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Device_2003);
		types.add(UMLElementTypes.Device_16);
		types.add(UMLElementTypes.Device_44);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExecutionEnvironmentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.ExecutionEnvironment_2002);
		types.add(UMLElementTypes.ExecutionEnvironment_21);
		types.add(UMLElementTypes.ExecutionEnvironment_46);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createArtifactCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Artifact_2006);
		types.add(UMLElementTypes.Artifact_25);
		types.add(UMLElementTypes.Artifact_28);
		types.add(UMLElementTypes.Artifact_40);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_2001);
		types.add(UMLElementTypes.Comment_54);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_2005);
		types.add(UMLElementTypes.Constraint_56);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_4008);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4009);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4004);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyBranchCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4010);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4003);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeploymentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Deployment_4001);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createManifestationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Manifestation_4002);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

}
