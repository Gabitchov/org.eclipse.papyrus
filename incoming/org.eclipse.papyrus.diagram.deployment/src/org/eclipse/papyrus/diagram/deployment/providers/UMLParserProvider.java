package org.eclipse.papyrus.diagram.deployment.providers;

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
import org.eclipse.papyrus.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ArtifactNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ArtifactNameEditPartACN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ArtifactNameEditPartCN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeviceNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeviceNameEditPartCN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.NodeNameEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.NodeNameEditPartCN;
import org.eclipse.papyrus.diagram.deployment.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

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
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_1Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_2Parser();
		case ConstraintSpecificationEditPart.VISUAL_ID:
			return getConstraintSpecification_3Parser();
		case ExecutionEnvironmentNameEditPart.VISUAL_ID:
			return getExecutionEnvironmentName_5Parser();
		case DeviceNameEditPart.VISUAL_ID:
			return getDeviceName_6Parser();
		case ArtifactNameEditPart.VISUAL_ID:
			return getArtifactName_8Parser();
		case NodeNameEditPart.VISUAL_ID:
			return getNodeName_9Parser();
		case NodeNameEditPartCN.VISUAL_ID:
			return getNodeName_24Parser();
		case DeviceNameEditPartCN.VISUAL_ID:
			return getDeviceName_20Parser();
		case ExecutionEnvironmentNameEditPartCN.VISUAL_ID:
			return getExecutionEnvironmentName_22Parser();
		case ArtifactNameEditPartCN.VISUAL_ID:
			return getArtifactName_27Parser();
		case ArtifactNameEditPartACN.VISUAL_ID:
			return getArtifactName_29Parser();
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
