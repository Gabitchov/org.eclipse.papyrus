/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.uml.edit.providers.*;
import org.osgi.framework.Bundle;

public class AlternativeUMLItemProviderAdapterFactory extends UMLItemProviderAdapterFactory {

	public AlternativeUMLItemProviderAdapterFactory(IPreferenceStore preferenceStore) {
		myPreferenceStore = preferenceStore;
	}

	@Override
	public Adapter createCommentAdapter() {
		if (commentItemProvider == null) {
			commentItemProvider = new CommentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Comment.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return commentItemProvider;
	}

	@Override
	public Adapter createDependencyAdapter() {
		if (dependencyItemProvider == null) {
			dependencyItemProvider = new DependencyItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Dependency.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return dependencyItemProvider;
	}

	@Override
	public Adapter createTemplateParameterAdapter() {
		if (templateParameterItemProvider == null) {
			templateParameterItemProvider = new TemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateParameter.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return templateParameterItemProvider;
	}

	@Override
	public Adapter createTemplateSignatureAdapter() {
		if (templateSignatureItemProvider == null) {
			templateSignatureItemProvider = new TemplateSignatureItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateSignature.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return templateSignatureItemProvider;
	}

	@Override
	public Adapter createTemplateBindingAdapter() {
		if (templateBindingItemProvider == null) {
			templateBindingItemProvider = new TemplateBindingItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateBinding.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return templateBindingItemProvider;
	}

	@Override
	public Adapter createTemplateParameterSubstitutionAdapter() {
		if (templateParameterSubstitutionItemProvider == null) {
			templateParameterSubstitutionItemProvider = new TemplateParameterSubstitutionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateParameterSubstitution.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return templateParameterSubstitutionItemProvider;
	}

	@Override
	public Adapter createElementImportAdapter() {
		if (elementImportItemProvider == null) {
			elementImportItemProvider = new ElementImportItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ElementImport.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return elementImportItemProvider;
	}

	@Override
	public Adapter createPackageImportAdapter() {
		if (packageImportItemProvider == null) {
			packageImportItemProvider = new PackageImportItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PackageImport.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return packageImportItemProvider;
	}

	@Override
	public Adapter createPackageAdapter() {
		if (packageItemProvider == null) {
			packageItemProvider = new PackageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Package.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return packageItemProvider;
	}

	@Override
	public Adapter createPackageMergeAdapter() {
		if (packageMergeItemProvider == null) {
			packageMergeItemProvider = new PackageMergeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PackageMerge.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return packageMergeItemProvider;
	}

	@Override
	public Adapter createProfileApplicationAdapter() {
		if (profileApplicationItemProvider == null) {
			profileApplicationItemProvider = new ProfileApplicationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProfileApplication.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return profileApplicationItemProvider;
	}

	@Override
	public Adapter createProfileAdapter() {
		if (profileItemProvider == null) {
			profileItemProvider = new ProfileItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Profile.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return profileItemProvider;
	}

	@Override
	public Adapter createStereotypeAdapter() {
		if (stereotypeItemProvider == null) {
			stereotypeItemProvider = new StereotypeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Stereotype.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return stereotypeItemProvider;
	}

	@Override
	public Adapter createImageAdapter() {
		if (imageItemProvider == null) {
			imageItemProvider = new ImageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Image.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return imageItemProvider;
	}

	@Override
	public Adapter createClassAdapter() {
		if (classItemProvider == null) {
			classItemProvider = new ClassItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Class.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return classItemProvider;
	}

	@Override
	public Adapter createGeneralizationAdapter() {
		if (generalizationItemProvider == null) {
			generalizationItemProvider = new GeneralizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Generalization.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return generalizationItemProvider;
	}

	@Override
	public Adapter createGeneralizationSetAdapter() {
		if (generalizationSetItemProvider == null) {
			generalizationSetItemProvider = new GeneralizationSetItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/GeneralizationSet.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return generalizationSetItemProvider;
	}

	@Override
	public Adapter createUseCaseAdapter() {
		if (useCaseItemProvider == null) {
			useCaseItemProvider = new UseCaseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/UseCase.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return useCaseItemProvider;
	}

	@Override
	public Adapter createIncludeAdapter() {
		if (includeItemProvider == null) {
			includeItemProvider = new IncludeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Include.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return includeItemProvider;
	}

	@Override
	public Adapter createExtendAdapter() {
		if (extendItemProvider == null) {
			extendItemProvider = new ExtendItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Extend.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return extendItemProvider;
	}

	@Override
	public Adapter createConstraintAdapter() {
		if (constraintItemProvider == null) {
			constraintItemProvider = new ConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Constraint.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return constraintItemProvider;
	}

	@Override
	public Adapter createExtensionPointAdapter() {
		if (extensionPointItemProvider == null) {
			extensionPointItemProvider = new ExtensionPointItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExtensionPoint.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return extensionPointItemProvider;
	}

	@Override
	public Adapter createSubstitutionAdapter() {
		if (substitutionItemProvider == null) {
			substitutionItemProvider = new SubstitutionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Substitution.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return substitutionItemProvider;
	}

	@Override
	public Adapter createRealizationAdapter() {
		if (realizationItemProvider == null) {
			realizationItemProvider = new RealizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Realization.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return realizationItemProvider;
	}

	@Override
	public Adapter createAbstractionAdapter() {
		if (abstractionItemProvider == null) {
			abstractionItemProvider = new AbstractionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Abstraction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return abstractionItemProvider;
	}

	@Override
	public Adapter createOpaqueExpressionAdapter() {
		if (opaqueExpressionItemProvider == null) {
			opaqueExpressionItemProvider = new OpaqueExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OpaqueExpression.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return opaqueExpressionItemProvider;
	}

	@Override
	public Adapter createParameterAdapter() {
		if (parameterItemProvider == null) {
			parameterItemProvider = new ParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Parameter.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return parameterItemProvider;
	}

	@Override
	public Adapter createConnectorEndAdapter() {
		if (connectorEndItemProvider == null) {
			connectorEndItemProvider = new ConnectorEndItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConnectorEnd.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return connectorEndItemProvider;
	}

	@Override
	public Adapter createPropertyAdapter() {
		if (propertyItemProvider == null) {
			propertyItemProvider = new PropertyItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Property.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return propertyItemProvider;
	}

	@Override
	public Adapter createDeploymentAdapter() {
		if (deploymentItemProvider == null) {
			deploymentItemProvider = new DeploymentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Deployment.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return deploymentItemProvider;
	}

	@Override
	public Adapter createDeploymentSpecificationAdapter() {
		if (deploymentSpecificationItemProvider == null) {
			deploymentSpecificationItemProvider = new DeploymentSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DeploymentSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return deploymentSpecificationItemProvider;
	}

	@Override
	public Adapter createArtifactAdapter() {
		if (artifactItemProvider == null) {
			artifactItemProvider = new ArtifactItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Artifact.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return artifactItemProvider;
	}

	@Override
	public Adapter createManifestationAdapter() {
		if (manifestationItemProvider == null) {
			manifestationItemProvider = new ManifestationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Manifestation.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return manifestationItemProvider;
	}

	@Override
	public Adapter createOperationAdapter() {
		if (operationItemProvider == null) {
			operationItemProvider = new OperationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Operation.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return operationItemProvider;
	}

	@Override
	public Adapter createParameterSetAdapter() {
		if (parameterSetItemProvider == null) {
			parameterSetItemProvider = new ParameterSetItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ParameterSet.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return parameterSetItemProvider;
	}

	@Override
	public Adapter createDataTypeAdapter() {
		if (dataTypeItemProvider == null) {
			dataTypeItemProvider = new DataTypeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DataType.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return dataTypeItemProvider;
	}

	@Override
	public Adapter createInterfaceAdapter() {
		if (interfaceItemProvider == null) {
			interfaceItemProvider = new InterfaceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Interface.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interfaceItemProvider;
	}

	@Override
	public Adapter createReceptionAdapter() {
		if (receptionItemProvider == null) {
			receptionItemProvider = new ReceptionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Reception.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return receptionItemProvider;
	}

	@Override
	public Adapter createSignalAdapter() {
		if (signalItemProvider == null) {
			signalItemProvider = new SignalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Signal.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return signalItemProvider;
	}

	@Override
	public Adapter createProtocolStateMachineAdapter() {
		if (protocolStateMachineItemProvider == null) {
			protocolStateMachineItemProvider = new ProtocolStateMachineItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProtocolStateMachine.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return protocolStateMachineItemProvider;
	}

	@Override
	public Adapter createStateMachineAdapter() {
		if (stateMachineItemProvider == null) {
			stateMachineItemProvider = new StateMachineItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StateMachine.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return stateMachineItemProvider;
	}

	@Override
	public Adapter createRegionAdapter() {
		if (regionItemProvider == null) {
			regionItemProvider = new RegionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Region.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return regionItemProvider;
	}

	@Override
	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Transition.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return transitionItemProvider;
	}

	@Override
	public Adapter createTriggerAdapter() {
		if (triggerItemProvider == null) {
			triggerItemProvider = new TriggerItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Trigger.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return triggerItemProvider;
	}

	@Override
	public Adapter createPortAdapter() {
		if (portItemProvider == null) {
			portItemProvider = new PortItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Port.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return portItemProvider;
	}

	@Override
	public Adapter createStateAdapter() {
		if (stateItemProvider == null) {
			stateItemProvider = new StateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/State.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return stateItemProvider;
	}

	@Override
	public Adapter createConnectionPointReferenceAdapter() {
		if (connectionPointReferenceItemProvider == null) {
			connectionPointReferenceItemProvider = new ConnectionPointReferenceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConnectionPointReference.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return connectionPointReferenceItemProvider;
	}

	@Override
	public Adapter createPseudostateAdapter() {
		if (pseudostateItemProvider == null) {
			pseudostateItemProvider = new PseudostateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Pseudostate.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return pseudostateItemProvider;
	}

	@Override
	public Adapter createProtocolConformanceAdapter() {
		if (protocolConformanceItemProvider == null) {
			protocolConformanceItemProvider = new ProtocolConformanceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProtocolConformance.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return protocolConformanceItemProvider;
	}

	@Override
	public Adapter createOperationTemplateParameterAdapter() {
		if (operationTemplateParameterItemProvider == null) {
			operationTemplateParameterItemProvider = new OperationTemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OperationTemplateParameter.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return operationTemplateParameterItemProvider;
	}

	@Override
	public Adapter createAssociationAdapter() {
		if (associationItemProvider == null) {
			associationItemProvider = new AssociationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Association.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return associationItemProvider;
	}

	@Override
	public Adapter createConnectableElementTemplateParameterAdapter() {
		if (connectableElementTemplateParameterItemProvider == null) {
			connectableElementTemplateParameterItemProvider = new ConnectableElementTemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConnectableElementTemplateParameter.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return connectableElementTemplateParameterItemProvider;
	}

	@Override
	public Adapter createCollaborationUseAdapter() {
		if (collaborationUseItemProvider == null) {
			collaborationUseItemProvider = new CollaborationUseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CollaborationUse.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return collaborationUseItemProvider;
	}

	@Override
	public Adapter createCollaborationAdapter() {
		if (collaborationItemProvider == null) {
			collaborationItemProvider = new CollaborationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Collaboration.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return collaborationItemProvider;
	}

	@Override
	public Adapter createConnectorAdapter() {
		if (connectorItemProvider == null) {
			connectorItemProvider = new ConnectorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Connector.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return connectorItemProvider;
	}

	@Override
	public Adapter createRedefinableTemplateSignatureAdapter() {
		if (redefinableTemplateSignatureItemProvider == null) {
			redefinableTemplateSignatureItemProvider = new RedefinableTemplateSignatureItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RedefinableTemplateSignature.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return redefinableTemplateSignatureItemProvider;
	}

	@Override
	public Adapter createClassifierTemplateParameterAdapter() {
		if (classifierTemplateParameterItemProvider == null) {
			classifierTemplateParameterItemProvider = new ClassifierTemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClassifierTemplateParameter.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return classifierTemplateParameterItemProvider;
	}

	@Override
	public Adapter createInterfaceRealizationAdapter() {
		if (interfaceRealizationItemProvider == null) {
			interfaceRealizationItemProvider = new InterfaceRealizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InterfaceRealization.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interfaceRealizationItemProvider;
	}

	@Override
	public Adapter createExtensionAdapter() {
		if (extensionItemProvider == null) {
			extensionItemProvider = new ExtensionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Extension.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return extensionItemProvider;
	}

	@Override
	public Adapter createExtensionEndAdapter() {
		if (extensionEndItemProvider == null) {
			extensionEndItemProvider = new ExtensionEndItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExtensionEnd.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return extensionEndItemProvider;
	}

	@Override
	public Adapter createStringExpressionAdapter() {
		if (stringExpressionItemProvider == null) {
			stringExpressionItemProvider = new StringExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StringExpression.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return stringExpressionItemProvider;
	}

	@Override
	public Adapter createExpressionAdapter() {
		if (expressionItemProvider == null) {
			expressionItemProvider = new ExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Expression.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return expressionItemProvider;
	}

	@Override
	public Adapter createLiteralIntegerAdapter() {
		if (literalIntegerItemProvider == null) {
			literalIntegerItemProvider = new LiteralIntegerItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralInteger.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return literalIntegerItemProvider;
	}

	@Override
	public Adapter createLiteralStringAdapter() {
		if (literalStringItemProvider == null) {
			literalStringItemProvider = new LiteralStringItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralString.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return literalStringItemProvider;
	}

	@Override
	public Adapter createLiteralBooleanAdapter() {
		if (literalBooleanItemProvider == null) {
			literalBooleanItemProvider = new LiteralBooleanItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralBoolean.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return literalBooleanItemProvider;
	}

	@Override
	public Adapter createLiteralNullAdapter() {
		if (literalNullItemProvider == null) {
			literalNullItemProvider = new LiteralNullItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralNull.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return literalNullItemProvider;
	}

	@Override
	public Adapter createSlotAdapter() {
		if (slotItemProvider == null) {
			slotItemProvider = new SlotItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Slot.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return slotItemProvider;
	}

	@Override
	public Adapter createInstanceSpecificationAdapter() {
		if (instanceSpecificationItemProvider == null) {
			instanceSpecificationItemProvider = new InstanceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InstanceSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return instanceSpecificationItemProvider;
	}

	@Override
	public Adapter createEnumerationAdapter() {
		if (enumerationItemProvider == null) {
			enumerationItemProvider = new EnumerationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Enumeration.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return enumerationItemProvider;
	}

	@Override
	public Adapter createEnumerationLiteralAdapter() {
		if (enumerationLiteralItemProvider == null) {
			enumerationLiteralItemProvider = new EnumerationLiteralItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/EnumerationLiteral.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return enumerationLiteralItemProvider;
	}

	@Override
	public Adapter createPrimitiveTypeAdapter() {
		if (primitiveTypeItemProvider == null) {
			primitiveTypeItemProvider = new PrimitiveTypeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PrimitiveType.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return primitiveTypeItemProvider;
	}

	@Override
	public Adapter createInstanceValueAdapter() {
		if (instanceValueItemProvider == null) {
			instanceValueItemProvider = new InstanceValueItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InstanceValue.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return instanceValueItemProvider;
	}

	@Override
	public Adapter createLiteralUnlimitedNaturalAdapter() {
		if (literalUnlimitedNaturalItemProvider == null) {
			literalUnlimitedNaturalItemProvider = new LiteralUnlimitedNaturalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralUnlimitedNatural.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return literalUnlimitedNaturalItemProvider;
	}

	@Override
	public Adapter createOpaqueBehaviorAdapter() {
		if (opaqueBehaviorItemProvider == null) {
			opaqueBehaviorItemProvider = new OpaqueBehaviorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OpaqueBehavior.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return opaqueBehaviorItemProvider;
	}

	@Override
	public Adapter createFunctionBehaviorAdapter() {
		if (functionBehaviorItemProvider == null) {
			functionBehaviorItemProvider = new FunctionBehaviorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/FunctionBehavior.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return functionBehaviorItemProvider;
	}

	@Override
	public Adapter createActorAdapter() {
		if (actorItemProvider == null) {
			actorItemProvider = new ActorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Actor.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return actorItemProvider;
	}

	@Override
	public Adapter createUsageAdapter() {
		if (usageItemProvider == null) {
			usageItemProvider = new UsageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Usage.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return usageItemProvider;
	}

	@Override
	public Adapter createMessageAdapter() {
		if (messageItemProvider == null) {
			messageItemProvider = new MessageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Message.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return messageItemProvider;
	}

	@Override
	public Adapter createInteractionAdapter() {
		if (interactionItemProvider == null) {
			interactionItemProvider = new InteractionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Interaction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interactionItemProvider;
	}

	@Override
	public Adapter createLifelineAdapter() {
		if (lifelineItemProvider == null) {
			lifelineItemProvider = new LifelineItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Lifeline.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return lifelineItemProvider;
	}

	@Override
	public Adapter createPartDecompositionAdapter() {
		if (partDecompositionItemProvider == null) {
			partDecompositionItemProvider = new PartDecompositionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PartDecomposition.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return partDecompositionItemProvider;
	}

	@Override
	public Adapter createInteractionUseAdapter() {
		if (interactionUseItemProvider == null) {
			interactionUseItemProvider = new InteractionUseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InteractionUse.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interactionUseItemProvider;
	}

	@Override
	public Adapter createGateAdapter() {
		if (gateItemProvider == null) {
			gateItemProvider = new GateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Gate.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return gateItemProvider;
	}

	@Override
	public Adapter createActivityAdapter() {
		if (activityItemProvider == null) {
			activityItemProvider = new ActivityItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Activity.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return activityItemProvider;
	}

	@Override
	public Adapter createActivityPartitionAdapter() {
		if (activityPartitionItemProvider == null) {
			activityPartitionItemProvider = new ActivityPartitionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActivityPartition.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return activityPartitionItemProvider;
	}

	@Override
	public Adapter createStructuredActivityNodeAdapter() {
		if (structuredActivityNodeItemProvider == null) {
			structuredActivityNodeItemProvider = new StructuredActivityNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StructuredActivityNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return structuredActivityNodeItemProvider;
	}

	@Override
	public Adapter createVariableAdapter() {
		if (variableItemProvider == null) {
			variableItemProvider = new VariableItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Variable.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return variableItemProvider;
	}

	@Override
	public Adapter createInterruptibleActivityRegionAdapter() {
		if (interruptibleActivityRegionItemProvider == null) {
			interruptibleActivityRegionItemProvider = new InterruptibleActivityRegionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InterruptibleActivityRegion.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interruptibleActivityRegionItemProvider;
	}

	@Override
	public Adapter createExceptionHandlerAdapter() {
		if (exceptionHandlerItemProvider == null) {
			exceptionHandlerItemProvider = new ExceptionHandlerItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExceptionHandler.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return exceptionHandlerItemProvider;
	}

	@Override
	public Adapter createOutputPinAdapter() {
		if (outputPinItemProvider == null) {
			outputPinItemProvider = new OutputPinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OutputPin.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return outputPinItemProvider;
	}

	@Override
	public Adapter createPinAdapter() {
		if (pinItemProvider == null) {
			pinItemProvider = new PinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Pin.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return pinItemProvider;
	}

	@Override
	public Adapter createInputPinAdapter() {
		if (inputPinItemProvider == null) {
			inputPinItemProvider = new InputPinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InputPin.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return inputPinItemProvider;
	}

	@Override
	public Adapter createGeneralOrderingAdapter() {
		if (generalOrderingItemProvider == null) {
			generalOrderingItemProvider = new GeneralOrderingItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/GeneralOrdering.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return generalOrderingItemProvider;
	}

	@Override
	public Adapter createOccurrenceSpecificationAdapter() {
		if (occurrenceSpecificationItemProvider == null) {
			occurrenceSpecificationItemProvider = new OccurrenceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OccurrenceSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return occurrenceSpecificationItemProvider;
	}

	@Override
	public Adapter createInteractionOperandAdapter() {
		if (interactionOperandItemProvider == null) {
			interactionOperandItemProvider = new InteractionOperandItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InteractionOperand.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interactionOperandItemProvider;
	}

	@Override
	public Adapter createInteractionConstraintAdapter() {
		if (interactionConstraintItemProvider == null) {
			interactionConstraintItemProvider = new InteractionConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InteractionConstraint.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return interactionConstraintItemProvider;
	}

	@Override
	public Adapter createExecutionOccurrenceSpecificationAdapter() {
		if (executionOccurrenceSpecificationItemProvider == null) {
			executionOccurrenceSpecificationItemProvider = new ExecutionOccurrenceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExecutionOccurrenceSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return executionOccurrenceSpecificationItemProvider;
	}

	@Override
	public Adapter createExecutionEventAdapter() {
		if (executionEventItemProvider == null) {
			executionEventItemProvider = new ExecutionEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExecutionEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return executionEventItemProvider;
	}

	@Override
	public Adapter createStateInvariantAdapter() {
		if (stateInvariantItemProvider == null) {
			stateInvariantItemProvider = new StateInvariantItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StateInvariant.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return stateInvariantItemProvider;
	}

	@Override
	public Adapter createActionExecutionSpecificationAdapter() {
		if (actionExecutionSpecificationItemProvider == null) {
			actionExecutionSpecificationItemProvider = new ActionExecutionSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActionExecutionSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return actionExecutionSpecificationItemProvider;
	}

	@Override
	public Adapter createBehaviorExecutionSpecificationAdapter() {
		if (behaviorExecutionSpecificationItemProvider == null) {
			behaviorExecutionSpecificationItemProvider = new BehaviorExecutionSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/BehaviorExecutionSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return behaviorExecutionSpecificationItemProvider;
	}

	@Override
	public Adapter createCreationEventAdapter() {
		if (creationEventItemProvider == null) {
			creationEventItemProvider = new CreationEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreationEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return creationEventItemProvider;
	}

	@Override
	public Adapter createDestructionEventAdapter() {
		if (destructionEventItemProvider == null) {
			destructionEventItemProvider = new DestructionEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DestructionEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return destructionEventItemProvider;
	}

	@Override
	public Adapter createSendOperationEventAdapter() {
		if (sendOperationEventItemProvider == null) {
			sendOperationEventItemProvider = new SendOperationEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendOperationEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return sendOperationEventItemProvider;
	}

	@Override
	public Adapter createSendSignalEventAdapter() {
		if (sendSignalEventItemProvider == null) {
			sendSignalEventItemProvider = new SendSignalEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendSignalEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return sendSignalEventItemProvider;
	}

	@Override
	public Adapter createMessageOccurrenceSpecificationAdapter() {
		if (messageOccurrenceSpecificationItemProvider == null) {
			messageOccurrenceSpecificationItemProvider = new MessageOccurrenceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/MessageOccurrenceSpecification.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return messageOccurrenceSpecificationItemProvider;
	}

	@Override
	public Adapter createReceiveOperationEventAdapter() {
		if (receiveOperationEventItemProvider == null) {
			receiveOperationEventItemProvider = new ReceiveOperationEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReceiveOperationEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return receiveOperationEventItemProvider;
	}

	@Override
	public Adapter createReceiveSignalEventAdapter() {
		if (receiveSignalEventItemProvider == null) {
			receiveSignalEventItemProvider = new ReceiveSignalEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReceiveSignalEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return receiveSignalEventItemProvider;
	}

	@Override
	public Adapter createCombinedFragmentAdapter() {
		if (combinedFragmentItemProvider == null) {
			combinedFragmentItemProvider = new CombinedFragmentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CombinedFragment.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return combinedFragmentItemProvider;
	}

	@Override
	public Adapter createContinuationAdapter() {
		if (continuationItemProvider == null) {
			continuationItemProvider = new ContinuationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Continuation.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return continuationItemProvider;
	}

	@Override
	public Adapter createConsiderIgnoreFragmentAdapter() {
		if (considerIgnoreFragmentItemProvider == null) {
			considerIgnoreFragmentItemProvider = new ConsiderIgnoreFragmentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConsiderIgnoreFragment.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return considerIgnoreFragmentItemProvider;
	}

	@Override
	public Adapter createCallEventAdapter() {
		if (callEventItemProvider == null) {
			callEventItemProvider = new CallEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CallEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return callEventItemProvider;
	}

	@Override
	public Adapter createChangeEventAdapter() {
		if (changeEventItemProvider == null) {
			changeEventItemProvider = new ChangeEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ChangeEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return changeEventItemProvider;
	}

	@Override
	public Adapter createSignalEventAdapter() {
		if (signalEventItemProvider == null) {
			signalEventItemProvider = new SignalEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SignalEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return signalEventItemProvider;
	}

	@Override
	public Adapter createAnyReceiveEventAdapter() {
		if (anyReceiveEventItemProvider == null) {
			anyReceiveEventItemProvider = new AnyReceiveEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AnyReceiveEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return anyReceiveEventItemProvider;
	}

	@Override
	public Adapter createCreateObjectActionAdapter() {
		if (createObjectActionItemProvider == null) {
			createObjectActionItemProvider = new CreateObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreateObjectAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return createObjectActionItemProvider;
	}

	@Override
	public Adapter createDestroyObjectActionAdapter() {
		if (destroyObjectActionItemProvider == null) {
			destroyObjectActionItemProvider = new DestroyObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DestroyObjectAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return destroyObjectActionItemProvider;
	}

	@Override
	public Adapter createTestIdentityActionAdapter() {
		if (testIdentityActionItemProvider == null) {
			testIdentityActionItemProvider = new TestIdentityActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TestIdentityAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return testIdentityActionItemProvider;
	}

	@Override
	public Adapter createReadSelfActionAdapter() {
		if (readSelfActionItemProvider == null) {
			readSelfActionItemProvider = new ReadSelfActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadSelfAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readSelfActionItemProvider;
	}

	@Override
	public Adapter createReadStructuralFeatureActionAdapter() {
		if (readStructuralFeatureActionItemProvider == null) {
			readStructuralFeatureActionItemProvider = new ReadStructuralFeatureActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadStructuralFeatureAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readStructuralFeatureActionItemProvider;
	}

	@Override
	public Adapter createClearStructuralFeatureActionAdapter() {
		if (clearStructuralFeatureActionItemProvider == null) {
			clearStructuralFeatureActionItemProvider = new ClearStructuralFeatureActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClearStructuralFeatureAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return clearStructuralFeatureActionItemProvider;
	}

	@Override
	public Adapter createRemoveStructuralFeatureValueActionAdapter() {
		if (removeStructuralFeatureValueActionItemProvider == null) {
			removeStructuralFeatureValueActionItemProvider = new RemoveStructuralFeatureValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RemoveStructuralFeatureValueAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return removeStructuralFeatureValueActionItemProvider;
	}

	@Override
	public Adapter createAddStructuralFeatureValueActionAdapter() {
		if (addStructuralFeatureValueActionItemProvider == null) {
			addStructuralFeatureValueActionItemProvider = new AddStructuralFeatureValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AddStructuralFeatureValueAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return addStructuralFeatureValueActionItemProvider;
	}

	@Override
	public Adapter createLinkEndDataAdapter() {
		if (linkEndDataItemProvider == null) {
			linkEndDataItemProvider = new LinkEndDataItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LinkEndData.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return linkEndDataItemProvider;
	}

	@Override
	public Adapter createQualifierValueAdapter() {
		if (qualifierValueItemProvider == null) {
			qualifierValueItemProvider = new QualifierValueItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/QualifierValue.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return qualifierValueItemProvider;
	}

	@Override
	public Adapter createReadLinkActionAdapter() {
		if (readLinkActionItemProvider == null) {
			readLinkActionItemProvider = new ReadLinkActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadLinkAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readLinkActionItemProvider;
	}

	@Override
	public Adapter createLinkEndCreationDataAdapter() {
		if (linkEndCreationDataItemProvider == null) {
			linkEndCreationDataItemProvider = new LinkEndCreationDataItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LinkEndCreationData.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return linkEndCreationDataItemProvider;
	}

	@Override
	public Adapter createCreateLinkActionAdapter() {
		if (createLinkActionItemProvider == null) {
			createLinkActionItemProvider = new CreateLinkActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreateLinkAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return createLinkActionItemProvider;
	}

	@Override
	public Adapter createDestroyLinkActionAdapter() {
		if (destroyLinkActionItemProvider == null) {
			destroyLinkActionItemProvider = new DestroyLinkActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DestroyLinkAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return destroyLinkActionItemProvider;
	}

	@Override
	public Adapter createLinkEndDestructionDataAdapter() {
		if (linkEndDestructionDataItemProvider == null) {
			linkEndDestructionDataItemProvider = new LinkEndDestructionDataItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LinkEndDestructionData.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return linkEndDestructionDataItemProvider;
	}

	@Override
	public Adapter createClearAssociationActionAdapter() {
		if (clearAssociationActionItemProvider == null) {
			clearAssociationActionItemProvider = new ClearAssociationActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClearAssociationAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return clearAssociationActionItemProvider;
	}

	@Override
	public Adapter createBroadcastSignalActionAdapter() {
		if (broadcastSignalActionItemProvider == null) {
			broadcastSignalActionItemProvider = new BroadcastSignalActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/BroadcastSignalAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return broadcastSignalActionItemProvider;
	}

	@Override
	public Adapter createSendObjectActionAdapter() {
		if (sendObjectActionItemProvider == null) {
			sendObjectActionItemProvider = new SendObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendObjectAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return sendObjectActionItemProvider;
	}

	@Override
	public Adapter createValueSpecificationActionAdapter() {
		if (valueSpecificationActionItemProvider == null) {
			valueSpecificationActionItemProvider = new ValueSpecificationActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ValueSpecificationAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return valueSpecificationActionItemProvider;
	}

	@Override
	public Adapter createTimeExpressionAdapter() {
		if (timeExpressionItemProvider == null) {
			timeExpressionItemProvider = new TimeExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeExpression.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return timeExpressionItemProvider;
	}

	@Override
	public Adapter createDurationAdapter() {
		if (durationItemProvider == null) {
			durationItemProvider = new DurationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Duration.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return durationItemProvider;
	}

	@Override
	public Adapter createValuePinAdapter() {
		if (valuePinItemProvider == null) {
			valuePinItemProvider = new ValuePinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ValuePin.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return valuePinItemProvider;
	}

	@Override
	public Adapter createDurationIntervalAdapter() {
		if (durationIntervalItemProvider == null) {
			durationIntervalItemProvider = new DurationIntervalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DurationInterval.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return durationIntervalItemProvider;
	}

	@Override
	public Adapter createIntervalAdapter() {
		if (intervalItemProvider == null) {
			intervalItemProvider = new IntervalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Interval.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return intervalItemProvider;
	}

	@Override
	public Adapter createTimeConstraintAdapter() {
		if (timeConstraintItemProvider == null) {
			timeConstraintItemProvider = new TimeConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeConstraint.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return timeConstraintItemProvider;
	}

	@Override
	public Adapter createIntervalConstraintAdapter() {
		if (intervalConstraintItemProvider == null) {
			intervalConstraintItemProvider = new IntervalConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/IntervalConstraint.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return intervalConstraintItemProvider;
	}

	@Override
	public Adapter createTimeIntervalAdapter() {
		if (timeIntervalItemProvider == null) {
			timeIntervalItemProvider = new TimeIntervalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeInterval.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return timeIntervalItemProvider;
	}

	@Override
	public Adapter createDurationConstraintAdapter() {
		if (durationConstraintItemProvider == null) {
			durationConstraintItemProvider = new DurationConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DurationConstraint.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return durationConstraintItemProvider;
	}

	@Override
	public Adapter createTimeObservationAdapter() {
		if (timeObservationItemProvider == null) {
			timeObservationItemProvider = new TimeObservationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeObservation.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return timeObservationItemProvider;
	}

	@Override
	public Adapter createDurationObservationAdapter() {
		if (durationObservationItemProvider == null) {
			durationObservationItemProvider = new DurationObservationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DurationObservation.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return durationObservationItemProvider;
	}

	@Override
	public Adapter createOpaqueActionAdapter() {
		if (opaqueActionItemProvider == null) {
			opaqueActionItemProvider = new OpaqueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OpaqueAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return opaqueActionItemProvider;
	}

	@Override
	public Adapter createSendSignalActionAdapter() {
		if (sendSignalActionItemProvider == null) {
			sendSignalActionItemProvider = new SendSignalActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendSignalAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return sendSignalActionItemProvider;
	}

	@Override
	public Adapter createCallOperationActionAdapter() {
		if (callOperationActionItemProvider == null) {
			callOperationActionItemProvider = new CallOperationActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CallOperationAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return callOperationActionItemProvider;
	}

	@Override
	public Adapter createCallBehaviorActionAdapter() {
		if (callBehaviorActionItemProvider == null) {
			callBehaviorActionItemProvider = new CallBehaviorActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CallBehaviorAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return callBehaviorActionItemProvider;
	}

	@Override
	public Adapter createInformationItemAdapter() {
		if (informationItemItemProvider == null) {
			informationItemItemProvider = new InformationItemItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InformationItem.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return informationItemItemProvider;
	}

	@Override
	public Adapter createInformationFlowAdapter() {
		if (informationFlowItemProvider == null) {
			informationFlowItemProvider = new InformationFlowItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InformationFlow.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return informationFlowItemProvider;
	}

	@Override
	public Adapter createModelAdapter() {
		if (modelItemProvider == null) {
			modelItemProvider = new ModelItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Model.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return modelItemProvider;
	}

	@Override
	public Adapter createReadVariableActionAdapter() {
		if (readVariableActionItemProvider == null) {
			readVariableActionItemProvider = new ReadVariableActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadVariableAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readVariableActionItemProvider;
	}

	@Override
	public Adapter createClearVariableActionAdapter() {
		if (clearVariableActionItemProvider == null) {
			clearVariableActionItemProvider = new ClearVariableActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClearVariableAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return clearVariableActionItemProvider;
	}

	@Override
	public Adapter createAddVariableValueActionAdapter() {
		if (addVariableValueActionItemProvider == null) {
			addVariableValueActionItemProvider = new AddVariableValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AddVariableValueAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return addVariableValueActionItemProvider;
	}

	@Override
	public Adapter createRemoveVariableValueActionAdapter() {
		if (removeVariableValueActionItemProvider == null) {
			removeVariableValueActionItemProvider = new RemoveVariableValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RemoveVariableValueAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return removeVariableValueActionItemProvider;
	}

	@Override
	public Adapter createRaiseExceptionActionAdapter() {
		if (raiseExceptionActionItemProvider == null) {
			raiseExceptionActionItemProvider = new RaiseExceptionActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RaiseExceptionAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return raiseExceptionActionItemProvider;
	}

	@Override
	public Adapter createActionInputPinAdapter() {
		if (actionInputPinItemProvider == null) {
			actionInputPinItemProvider = new ActionInputPinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActionInputPin.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return actionInputPinItemProvider;
	}

	@Override
	public Adapter createReadExtentActionAdapter() {
		if (readExtentActionItemProvider == null) {
			readExtentActionItemProvider = new ReadExtentActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadExtentAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readExtentActionItemProvider;
	}

	@Override
	public Adapter createReclassifyObjectActionAdapter() {
		if (reclassifyObjectActionItemProvider == null) {
			reclassifyObjectActionItemProvider = new ReclassifyObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReclassifyObjectAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return reclassifyObjectActionItemProvider;
	}

	@Override
	public Adapter createReadIsClassifiedObjectActionAdapter() {
		if (readIsClassifiedObjectActionItemProvider == null) {
			readIsClassifiedObjectActionItemProvider = new ReadIsClassifiedObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadIsClassifiedObjectAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readIsClassifiedObjectActionItemProvider;
	}

	@Override
	public Adapter createStartClassifierBehaviorActionAdapter() {
		if (startClassifierBehaviorActionItemProvider == null) {
			startClassifierBehaviorActionItemProvider = new StartClassifierBehaviorActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StartClassifierBehaviorAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return startClassifierBehaviorActionItemProvider;
	}

	@Override
	public Adapter createReadLinkObjectEndActionAdapter() {
		if (readLinkObjectEndActionItemProvider == null) {
			readLinkObjectEndActionItemProvider = new ReadLinkObjectEndActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadLinkObjectEndAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readLinkObjectEndActionItemProvider;
	}

	@Override
	public Adapter createReadLinkObjectEndQualifierActionAdapter() {
		if (readLinkObjectEndQualifierActionItemProvider == null) {
			readLinkObjectEndQualifierActionItemProvider = new ReadLinkObjectEndQualifierActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadLinkObjectEndQualifierAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return readLinkObjectEndQualifierActionItemProvider;
	}

	@Override
	public Adapter createCreateLinkObjectActionAdapter() {
		if (createLinkObjectActionItemProvider == null) {
			createLinkObjectActionItemProvider = new CreateLinkObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreateLinkObjectAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return createLinkObjectActionItemProvider;
	}

	@Override
	public Adapter createAcceptEventActionAdapter() {
		if (acceptEventActionItemProvider == null) {
			acceptEventActionItemProvider = new AcceptEventActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AcceptEventAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return acceptEventActionItemProvider;
	}

	@Override
	public Adapter createAcceptCallActionAdapter() {
		if (acceptCallActionItemProvider == null) {
			acceptCallActionItemProvider = new AcceptCallActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AcceptCallAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return acceptCallActionItemProvider;
	}

	@Override
	public Adapter createReplyActionAdapter() {
		if (replyActionItemProvider == null) {
			replyActionItemProvider = new ReplyActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReplyAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return replyActionItemProvider;
	}

	@Override
	public Adapter createUnmarshallActionAdapter() {
		if (unmarshallActionItemProvider == null) {
			unmarshallActionItemProvider = new UnmarshallActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/UnmarshallAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return unmarshallActionItemProvider;
	}

	@Override
	public Adapter createReduceActionAdapter() {
		if (reduceActionItemProvider == null) {
			reduceActionItemProvider = new ReduceActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReduceAction.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return reduceActionItemProvider;
	}

	@Override
	public Adapter createControlFlowAdapter() {
		if (controlFlowItemProvider == null) {
			controlFlowItemProvider = new ControlFlowItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ControlFlow.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return controlFlowItemProvider;
	}

	@Override
	public Adapter createInitialNodeAdapter() {
		if (initialNodeItemProvider == null) {
			initialNodeItemProvider = new InitialNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InitialNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return initialNodeItemProvider;
	}

	@Override
	public Adapter createActivityParameterNodeAdapter() {
		if (activityParameterNodeItemProvider == null) {
			activityParameterNodeItemProvider = new ActivityParameterNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActivityParameterNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return activityParameterNodeItemProvider;
	}

	@Override
	public Adapter createForkNodeAdapter() {
		if (forkNodeItemProvider == null) {
			forkNodeItemProvider = new ForkNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ForkNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return forkNodeItemProvider;
	}

	@Override
	public Adapter createFlowFinalNodeAdapter() {
		if (flowFinalNodeItemProvider == null) {
			flowFinalNodeItemProvider = new FlowFinalNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/FlowFinalNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return flowFinalNodeItemProvider;
	}

	@Override
	public Adapter createCentralBufferNodeAdapter() {
		if (centralBufferNodeItemProvider == null) {
			centralBufferNodeItemProvider = new CentralBufferNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CentralBufferNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return centralBufferNodeItemProvider;
	}

	@Override
	public Adapter createMergeNodeAdapter() {
		if (mergeNodeItemProvider == null) {
			mergeNodeItemProvider = new MergeNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/MergeNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return mergeNodeItemProvider;
	}

	@Override
	public Adapter createDecisionNodeAdapter() {
		if (decisionNodeItemProvider == null) {
			decisionNodeItemProvider = new DecisionNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DecisionNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return decisionNodeItemProvider;
	}

	@Override
	public Adapter createActivityFinalNodeAdapter() {
		if (activityFinalNodeItemProvider == null) {
			activityFinalNodeItemProvider = new ActivityFinalNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActivityFinalNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return activityFinalNodeItemProvider;
	}

	@Override
	public Adapter createJoinNodeAdapter() {
		if (joinNodeItemProvider == null) {
			joinNodeItemProvider = new JoinNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/JoinNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return joinNodeItemProvider;
	}

	@Override
	public Adapter createDataStoreNodeAdapter() {
		if (dataStoreNodeItemProvider == null) {
			dataStoreNodeItemProvider = new DataStoreNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DataStoreNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return dataStoreNodeItemProvider;
	}

	@Override
	public Adapter createObjectFlowAdapter() {
		if (objectFlowItemProvider == null) {
			objectFlowItemProvider = new ObjectFlowItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ObjectFlow.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return objectFlowItemProvider;
	}

	@Override
	public Adapter createSequenceNodeAdapter() {
		if (sequenceNodeItemProvider == null) {
			sequenceNodeItemProvider = new SequenceNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SequenceNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return sequenceNodeItemProvider;
	}

	@Override
	public Adapter createConditionalNodeAdapter() {
		if (conditionalNodeItemProvider == null) {
			conditionalNodeItemProvider = new ConditionalNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConditionalNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return conditionalNodeItemProvider;
	}

	@Override
	public Adapter createClauseAdapter() {
		if (clauseItemProvider == null) {
			clauseItemProvider = new ClauseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Clause.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return clauseItemProvider;
	}

	@Override
	public Adapter createLoopNodeAdapter() {
		if (loopNodeItemProvider == null) {
			loopNodeItemProvider = new LoopNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LoopNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return loopNodeItemProvider;
	}

	@Override
	public Adapter createExpansionNodeAdapter() {
		if (expansionNodeItemProvider == null) {
			expansionNodeItemProvider = new ExpansionNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExpansionNode.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return expansionNodeItemProvider;
	}

	@Override
	public Adapter createExpansionRegionAdapter() {
		if (expansionRegionItemProvider == null) {
			expansionRegionItemProvider = new ExpansionRegionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExpansionRegion.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return expansionRegionItemProvider;
	}

	@Override
	public Adapter createComponentRealizationAdapter() {
		if (componentRealizationItemProvider == null) {
			componentRealizationItemProvider = new ComponentRealizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ComponentRealization.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return componentRealizationItemProvider;
	}

	@Override
	public Adapter createComponentAdapter() {
		if (componentItemProvider == null) {
			componentItemProvider = new ComponentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Component.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return componentItemProvider;
	}

	@Override
	public Adapter createNodeAdapter() {
		if (nodeItemProvider == null) {
			nodeItemProvider = new NodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Node.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return nodeItemProvider;
	}

	@Override
	public Adapter createDeviceAdapter() {
		if (deviceItemProvider == null) {
			deviceItemProvider = new DeviceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Device.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return deviceItemProvider;
	}

	@Override
	public Adapter createExecutionEnvironmentAdapter() {
		if (executionEnvironmentItemProvider == null) {
			executionEnvironmentItemProvider = new ExecutionEnvironmentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExecutionEnvironment.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return executionEnvironmentItemProvider;
	}

	@Override
	public Adapter createCommunicationPathAdapter() {
		if (communicationPathItemProvider == null) {
			communicationPathItemProvider = new CommunicationPathItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CommunicationPath.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return communicationPathItemProvider;
	}

	@Override
	public Adapter createFinalStateAdapter() {
		if (finalStateItemProvider == null) {
			finalStateItemProvider = new FinalStateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/FinalState.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return finalStateItemProvider;
	}

	@Override
	public Adapter createTimeEventAdapter() {
		if (timeEventItemProvider == null) {
			timeEventItemProvider = new TimeEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeEvent.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return timeEventItemProvider;
	}

	@Override
	public Adapter createProtocolTransitionAdapter() {
		if (protocolTransitionItemProvider == null) {
			protocolTransitionItemProvider = new ProtocolTransitionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProtocolTransition.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return protocolTransitionItemProvider;
	}

	@Override
	public Adapter createAssociationClassAdapter() {
		if (associationClassItemProvider == null) {
			associationClassItemProvider = new AssociationClassItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AssociationClass.gif"), null)); //$NON-NLS-1$
					}
					return super.getImage(object);
				}
			};
		}
		return associationClassItemProvider;
	}

	private boolean useAlternativeIcons(Object object) {
		return UMLPreferencesConstants.PREF_ICON_STYLE_CHEERFUL.equals(myPreferenceStore.getString(UMLPreferencesConstants.PREF_ICON_STYLE));
	}

	private static final Bundle UML_BUNDLE = Platform.getBundle("org.eclipse.papyrus.diagram.common.common"); //$NON-NLS-1$

	private IPreferenceStore myPreferenceStore;
}
