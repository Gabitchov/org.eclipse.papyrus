/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser dependencyName_7Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_7Parser() {
		if(dependencyName_7Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_7Parser = parser;
		}
		return dependencyName_7Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_48Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_48Parser() {
		if(modelName_48Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_48Parser = parser;
		}
		return modelName_48Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_35Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_35Parser() {
		if(packageName_35Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_35Parser = parser;
		}
		return packageName_35Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_1Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_1Parser() {
		if(commentBody_1Parser == null) {
			commentBody_1Parser = new CommentParser();
		}
		return commentBody_1Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_2Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_2Parser() {
		if(constraintName_2Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_2Parser = parser;
		}
		return constraintName_2Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_3Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_3Parser() {
		if(constraintSpecification_3Parser == null) {
			constraintSpecification_3Parser = new ConstraintParser();
		}
		return constraintSpecification_3Parser;
	}

	/**
	 * @generated
	 */
	private IParser executionEnvironmentName_5Parser;

	/**
	 * @generated
	 */
	private IParser getExecutionEnvironmentName_5Parser() {
		if(executionEnvironmentName_5Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			executionEnvironmentName_5Parser = parser;
		}
		return executionEnvironmentName_5Parser;
	}

	/**
	 * @generated
	 */
	private IParser deviceName_6Parser;

	/**
	 * @generated
	 */
	private IParser getDeviceName_6Parser() {
		if(deviceName_6Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			deviceName_6Parser = parser;
		}
		return deviceName_6Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_8Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_8Parser() {
		if(artifactName_8Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			artifactName_8Parser = parser;
		}
		return artifactName_8Parser;
	}

	/**
	 * @generated
	 */
	private IParser nodeName_9Parser;

	/**
	 * @generated
	 */
	private IParser getNodeName_9Parser() {
		if(nodeName_9Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nodeName_9Parser = parser;
		}
		return nodeName_9Parser;
	}

	/**
	 * @generated
	 */
	private IParser namedElementName_53Parser;

	/**
	 * @generated
	 */
	private IParser getNamedElementName_53Parser() {
		if(namedElementName_53Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			namedElementName_53Parser = parser;
		}
		return namedElementName_53Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_50Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_50Parser() {
		if(modelName_50Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_50Parser = parser;
		}
		return modelName_50Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_37Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_37Parser() {
		if(packageName_37Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_37Parser = parser;
		}
		return packageName_37Parser;
	}

	/**
	 * @generated
	 */
	private IParser nodeName_24Parser;

	/**
	 * @generated
	 */
	private IParser getNodeName_24Parser() {
		if(nodeName_24Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nodeName_24Parser = parser;
		}
		return nodeName_24Parser;
	}

	/**
	 * @generated
	 */
	private IParser nodeName_43Parser;

	/**
	 * @generated
	 */
	private IParser getNodeName_43Parser() {
		if(nodeName_43Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nodeName_43Parser = parser;
		}
		return nodeName_43Parser;
	}

	/**
	 * @generated
	 */
	private IParser deviceName_20Parser;

	/**
	 * @generated
	 */
	private IParser getDeviceName_20Parser() {
		if(deviceName_20Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			deviceName_20Parser = parser;
		}
		return deviceName_20Parser;
	}

	/**
	 * @generated
	 */
	private IParser deviceName_45Parser;

	/**
	 * @generated
	 */
	private IParser getDeviceName_45Parser() {
		if(deviceName_45Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			deviceName_45Parser = parser;
		}
		return deviceName_45Parser;
	}

	/**
	 * @generated
	 */
	private IParser executionEnvironmentName_22Parser;

	/**
	 * @generated
	 */
	private IParser getExecutionEnvironmentName_22Parser() {
		if(executionEnvironmentName_22Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			executionEnvironmentName_22Parser = parser;
		}
		return executionEnvironmentName_22Parser;
	}

	/**
	 * @generated
	 */
	private IParser executionEnvironmentName_47Parser;

	/**
	 * @generated
	 */
	private IParser getExecutionEnvironmentName_47Parser() {
		if(executionEnvironmentName_47Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			executionEnvironmentName_47Parser = parser;
		}
		return executionEnvironmentName_47Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_27Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_27Parser() {
		if(artifactName_27Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			artifactName_27Parser = parser;
		}
		return artifactName_27Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_29Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_29Parser() {
		if(artifactName_29Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			artifactName_29Parser = parser;
		}
		return artifactName_29Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_41Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_41Parser() {
		if(artifactName_41Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			artifactName_41Parser = parser;
		}
		return artifactName_41Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_55Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_55Parser() {
		if(commentBody_55Parser == null) {
			commentBody_55Parser = new CommentParser();
		}
		return commentBody_55Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_57Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_57Parser() {
		if(constraintName_57Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_57Parser = parser;
		}
		return constraintName_57Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_58Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_58Parser() {
		if(constraintSpecification_58Parser == null) {
			constraintSpecification_58Parser = new ConstraintParser();
		}
		return constraintSpecification_58Parser;
	}

	/**
	 * @generated
	 */
	private IParser deploymentName_13Parser;

	/**
	 * @generated
	 */
	private IParser getDeploymentName_13Parser() {
		if(deploymentName_13Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			deploymentName_13Parser = parser;
		}
		return deploymentName_13Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser deploymentName_14Parser;

	/**
	 * @generated
	 */
	private IParser getDeploymentName_14Parser() {
		if(deploymentName_14Parser == null) {
			deploymentName_14Parser = new AppliedStereotypeParser();
		}
		return deploymentName_14Parser;
	}

	/**
	 * @generated
	 */
	private IParser manifestationName_10Parser;

	/**
	 * @generated
	 */
	private IParser getManifestationName_10Parser() {
		if(manifestationName_10Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			manifestationName_10Parser = parser;
		}
		return manifestationName_10Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser manifestationName_11Parser;

	/**
	 * @generated
	 */
	private IParser getManifestationName_11Parser() {
		if(manifestationName_11Parser == null) {
			manifestationName_11Parser = new AppliedStereotypeParser();
		}
		return manifestationName_11Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationIsSubstitutable_4Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_4Parser() {
		if(generalizationIsSubstitutable_4Parser == null) {
			generalizationIsSubstitutable_4Parser = new AppliedStereotypeParser();
		}
		return generalizationIsSubstitutable_4Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_12Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_12Parser() {
		if(dependencyName_12Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_12Parser = parser;
		}
		return dependencyName_12Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyName_15Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_15Parser() {
		if(dependencyName_15Parser == null) {
			dependencyName_15Parser = new AppliedStereotypeParser();
		}
		return dependencyName_15Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case MultiDependencyLabelEditPart.VISUAL_ID:
			return getDependencyName_7Parser();
		case ModelNameEditPart.VISUAL_ID:
			return getModelName_48Parser();
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_35Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_2Parser();
		case ConstraintSpecificationEditPart.VISUAL_ID:
			return getConstraintSpecification_3Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_1Parser();
		case ExecutionEnvironmentNameEditPart.VISUAL_ID:
			return getExecutionEnvironmentName_5Parser();
		case DeviceNameEditPart.VISUAL_ID:
			return getDeviceName_6Parser();
		case ArtifactNameEditPart.VISUAL_ID:
			return getArtifactName_8Parser();
		case NodeNameEditPart.VISUAL_ID:
			return getNodeName_9Parser();
		case DefaultNamedElementNameEditPart.VISUAL_ID:
			return getNamedElementName_53Parser();
		case ModelNameEditPartCN.VISUAL_ID:
			return getModelName_50Parser();
		case PackageNameEditPartCN.VISUAL_ID:
			return getPackageName_37Parser();
		case DeviceNameEditPartCN.VISUAL_ID:
			return getDeviceName_20Parser();
		case NestedDeviceNameEditPartCN.VISUAL_ID:
			return getDeviceName_45Parser();
		case ExecutionEnvironmentNameEditPartCN.VISUAL_ID:
			return getExecutionEnvironmentName_22Parser();
		case NestedExecutionEnvironmentNameEditPartCN.VISUAL_ID:
			return getExecutionEnvironmentName_47Parser();
		case NodeNameEditPartCN.VISUAL_ID:
			return getNodeName_24Parser();
		case NestedNodeNameEditPart.VISUAL_ID:
			return getNodeName_43Parser();
		case ArtifactNameEditPartCN.VISUAL_ID:
			return getArtifactName_27Parser();
		case ArtifactNameEditPartACN.VISUAL_ID:
			return getArtifactName_29Parser();
		case NestedArtifactNameEditPart.VISUAL_ID:
			return getArtifactName_41Parser();
		case CommentBodyEditPartCN.VISUAL_ID:
			return getCommentBody_55Parser();
		case ConstraintNameEditPartCN.VISUAL_ID:
			return getConstraintName_57Parser();
		case ConstraintSpecificationEditPartCN.VISUAL_ID:
			return getConstraintSpecification_58Parser();
		case DeploymentNameEditPart.VISUAL_ID:
			return getDeploymentName_13Parser();
		case DeploymentAppliedStereotypeEditPart.VISUAL_ID:
			return getDeploymentName_14Parser();
		case ManifestationNameEditPart.VISUAL_ID:
			return getManifestationName_10Parser();
		case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
			return getManifestationName_11Parser();
		case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_4Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_12Parser();
		case DependencyAppliedStereotypeEditPart.VISUAL_ID:
			return getDependencyName_15Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String)hint.getAdapter(String.class);
		if(vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();
			if(UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if(IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
