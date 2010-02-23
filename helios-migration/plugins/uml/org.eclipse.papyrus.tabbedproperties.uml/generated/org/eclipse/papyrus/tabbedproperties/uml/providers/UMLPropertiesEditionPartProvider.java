/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.parts.forms.*;
import org.eclipse.papyrus.tabbedproperties.uml.parts.impl.*;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * 
 */
public class UMLPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == UMLViewsRepository.class;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if(key == UMLViewsRepository.Class_.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new Class_PropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new Class_PropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.AssociationClass.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AssociationClassPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AssociationClassPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LiteralUnlimitedNatural.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LiteralUnlimitedNaturalPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LiteralUnlimitedNaturalPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InstanceValue.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InstanceValuePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InstanceValuePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LiteralNull.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LiteralNullPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LiteralNullPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LiteralBoolean.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LiteralBooleanPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LiteralBooleanPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LiteralString.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LiteralStringPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LiteralStringPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LiteralInteger.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LiteralIntegerPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LiteralIntegerPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.PrimitiveType.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PrimitiveTypePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PrimitiveTypePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Slot.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SlotPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SlotPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InstanceSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InstanceSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InstanceSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.EnumerationLiteral.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new EnumerationLiteralPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new EnumerationLiteralPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Enumeration.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new EnumerationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new EnumerationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.PackageMerge.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PackageMergePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PackageMergePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Usage.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new UsagePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new UsagePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Expression.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExpressionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExpressionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DataType.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DataTypePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DataTypePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InterfaceRealization.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InterfaceRealizationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InterfaceRealizationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Operation.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OperationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OperationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Property.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PropertyPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PropertyPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Parameter.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ParameterPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ParameterPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.OpaqueExpression.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OpaqueExpressionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OpaqueExpressionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Abstraction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AbstractionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AbstractionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Realization.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new RealizationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new RealizationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Substitution.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SubstitutionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SubstitutionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.GeneralizationSet.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new GeneralizationSetPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new GeneralizationSetPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Generalization.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new GeneralizationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new GeneralizationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Association.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AssociationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AssociationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Constraint.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConstraintPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConstraintPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Comment.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CommentPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CommentPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Package_.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new Package_PropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new Package_PropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.PackageImport.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PackageImportPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PackageImportPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Dependency.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DependencyPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DependencyPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ElementImport.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ElementImportPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ElementImportPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Component.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ComponentPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ComponentPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ComponentRealization.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ComponentRealizationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ComponentRealizationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Connector.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConnectorPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConnectorPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Collaboration.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CollaborationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CollaborationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CollaborationUse.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CollaborationUsePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CollaborationUsePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Port.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PortPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PortPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Trigger.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TriggerPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TriggerPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ConnectorEnd.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConnectorEndPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConnectorEndPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExecutionEnvironment.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExecutionEnvironmentPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExecutionEnvironmentPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Device.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DevicePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DevicePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CommunicationPath.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CommunicationPathPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CommunicationPathPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Node.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new NodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new NodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Manifestation.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ManifestationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ManifestationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Artifact.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ArtifactPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ArtifactPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DeploymentSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DeploymentSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DeploymentSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Deployment.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DeploymentPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DeploymentPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReduceAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReduceActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReduceActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReplyAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReplyActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReplyActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.AcceptCallAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AcceptCallActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AcceptCallActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.AcceptEventAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AcceptEventActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AcceptEventActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CreateLinkObjectAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CreateLinkObjectActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CreateLinkObjectActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadLinkObjectEndQualifierActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadLinkObjectEndQualifierActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadLinkObjectEndAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadLinkObjectEndActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadLinkObjectEndActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.StartClassifierBehaviorAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StartClassifierBehaviorActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StartClassifierBehaviorActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadIsClassifiedObjectAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadIsClassifiedObjectActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadIsClassifiedObjectActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReclassifyObjectAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReclassifyObjectActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReclassifyObjectActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadExtentAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadExtentActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadExtentActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.RaiseExceptionAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new RaiseExceptionActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new RaiseExceptionActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.RemoveVariableValueAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new RemoveVariableValueActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new RemoveVariableValueActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ClearVariableAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ClearVariableActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ClearVariableActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.AddVariableValueAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AddVariableValueActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AddVariableValueActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadVariableAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadVariableActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadVariableActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ValueSpecificationAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ValueSpecificationActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ValueSpecificationActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.SendObjectAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SendObjectActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SendObjectActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.BroadcastSignalAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new BroadcastSignalActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new BroadcastSignalActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ClearAssociationAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ClearAssociationActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ClearAssociationActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LinkEndDestructionData.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LinkEndDestructionDataPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LinkEndDestructionDataPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DestroyLinkAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DestroyLinkActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DestroyLinkActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CreateLinkAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CreateLinkActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CreateLinkActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadLinkAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadLinkActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadLinkActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LinkEndCreationData.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LinkEndCreationDataPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LinkEndCreationDataPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.AddStructuralFeatureValueAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AddStructuralFeatureValueActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AddStructuralFeatureValueActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.RemoveStructuralFeatureValueAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new RemoveStructuralFeatureValueActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new RemoveStructuralFeatureValueActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ClearStructuralFeatureAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ClearStructuralFeatureActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ClearStructuralFeatureActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadStructuralFeatureAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadStructuralFeatureActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadStructuralFeatureActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReadSelfAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReadSelfActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReadSelfActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TestIdentityAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TestIdentityActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TestIdentityActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DestroyObjectAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DestroyObjectActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DestroyObjectActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CreateObjectAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CreateObjectActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CreateObjectActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.QualifierValue.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new QualifierValuePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new QualifierValuePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LinkEndData.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LinkEndDataPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LinkEndDataPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ValuePin.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ValuePinPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ValuePinPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.OpaqueAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OpaqueActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OpaqueActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExpansionRegion.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExpansionRegionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExpansionRegionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExpansionNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExpansionNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExpansionNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Clause.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ClausePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ClausePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.LoopNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LoopNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LoopNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ConditionalNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConditionalNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConditionalNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ObjectFlow.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ObjectFlowPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ObjectFlowPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DataStoreNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DataStoreNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DataStoreNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.JoinNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new JoinNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new JoinNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.UnmarshallAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new UnmarshallActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new UnmarshallActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ActionInputPin.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActionInputPinPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActionInputPinPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ActivityFinalNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActivityFinalNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActivityFinalNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DecisionNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DecisionNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DecisionNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.MergeNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new MergeNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new MergeNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CentralBufferNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CentralBufferNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CentralBufferNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.FlowFinalNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new FlowFinalNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new FlowFinalNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ForkNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ForkNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ForkNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.AnyReceiveEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new AnyReceiveEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new AnyReceiveEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ActivityParameterNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActivityParameterNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActivityParameterNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InitialNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InitialNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InitialNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ControlFlow.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ControlFlowPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ControlFlowPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.SequenceNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SequenceNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SequenceNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CallBehaviorAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CallBehaviorActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CallBehaviorActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CallOperationAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CallOperationActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CallOperationActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.SendSignalAction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SendSignalActionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SendSignalActionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InputPin.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InputPinPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InputPinPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Pin.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PinPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PinPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.OutputPin.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OutputPinPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OutputPinPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExceptionHandler.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExceptionHandlerPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExceptionHandlerPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InterruptibleActivityRegion.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InterruptibleActivityRegionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InterruptibleActivityRegionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ActivityPartition.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActivityPartitionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActivityPartitionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Variable.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new VariablePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new VariablePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Activity.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActivityPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActivityPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.StructuredActivityNode.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StructuredActivityNodePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StructuredActivityNodePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ParameterSet.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ParameterSetPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ParameterSetPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DurationObservation.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DurationObservationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DurationObservationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TimeObservation.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TimeObservationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TimeObservationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TimeInterval.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TimeIntervalPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TimeIntervalPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DurationConstraint.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DurationConstraintPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DurationConstraintPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.IntervalConstraint.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new IntervalConstraintPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new IntervalConstraintPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TimeConstraint.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TimeConstraintPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TimeConstraintPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DurationInterval.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DurationIntervalPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DurationIntervalPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Duration.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DurationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DurationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Interval.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new IntervalPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new IntervalPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TimeExpression.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TimeExpressionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TimeExpressionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.SignalEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SignalEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SignalEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ChangeEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ChangeEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ChangeEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CallEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CallEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CallEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.FunctionBehavior.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new FunctionBehaviorPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new FunctionBehaviorPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.OpaqueBehavior.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OpaqueBehaviorPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OpaqueBehaviorPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Signal.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SignalPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SignalPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Reception.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReceptionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReceptionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Interface_.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new Interface_PropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new Interface_PropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ConsiderIgnoreFragment.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConsiderIgnoreFragmentPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConsiderIgnoreFragmentPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Continuation.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ContinuationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ContinuationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CombinedFragment.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CombinedFragmentPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CombinedFragmentPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReceiveSignalEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReceiveSignalEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReceiveSignalEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ReceiveOperationEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ReceiveOperationEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ReceiveOperationEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExecutionOccurrenceSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExecutionOccurrenceSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExecutionOccurrenceSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.MessageOccurrenceSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new MessageOccurrenceSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new MessageOccurrenceSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.SendSignalEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SendSignalEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SendSignalEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.SendOperationEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new SendOperationEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new SendOperationEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.DestructionEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new DestructionEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new DestructionEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.CreationEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CreationEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CreationEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExecutionEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExecutionEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExecutionEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.BehaviorExecutionSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new BehaviorExecutionSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new BehaviorExecutionSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ActionExecutionSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActionExecutionSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActionExecutionSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.StateInvariant.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StateInvariantPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StateInvariantPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InteractionConstraint.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InteractionConstraintPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InteractionConstraintPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InteractionOperand.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InteractionOperandPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InteractionOperandPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.OccurrenceSpecification.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OccurrenceSpecificationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OccurrenceSpecificationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.GeneralOrdering.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new GeneralOrderingPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new GeneralOrderingPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Gate.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new GatePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new GatePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InteractionUse.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InteractionUsePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InteractionUsePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.PartDecomposition.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PartDecompositionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PartDecompositionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Lifeline.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new LifelinePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new LifelinePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Interaction.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InteractionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InteractionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Message.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new MessagePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new MessagePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ProtocolTransition.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ProtocolTransitionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ProtocolTransitionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TimeEvent.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TimeEventPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TimeEventPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.FinalState.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new FinalStatePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new FinalStatePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ProtocolConformance.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ProtocolConformancePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ProtocolConformancePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Pseudostate.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new PseudostatePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new PseudostatePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ConnectionPointReference.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConnectionPointReferencePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConnectionPointReferencePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.State.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StatePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StatePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Transition.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TransitionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TransitionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Region.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new RegionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new RegionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.StateMachine.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StateMachinePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StateMachinePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ProtocolStateMachine.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ProtocolStateMachinePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ProtocolStateMachinePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Actor.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ActorPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ActorPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExtensionPoint.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExtensionPointPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExtensionPointPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Extend.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExtendPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExtendPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Include.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new IncludePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new IncludePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.UseCase.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new UseCasePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new UseCasePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InformationFlow.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InformationFlowPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InformationFlowPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.InformationItem.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new InformationItemPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new InformationItemPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.StringExpression.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StringExpressionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StringExpressionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ClassifierTemplateParameter.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ClassifierTemplateParameterPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ClassifierTemplateParameterPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.RedefinableTemplateSignature.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new RedefinableTemplateSignaturePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new RedefinableTemplateSignaturePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.OperationTemplateParameter.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new OperationTemplateParameterPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new OperationTemplateParameterPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Model.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ModelPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ModelPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ConnectableElementTemplateParameter.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ConnectableElementTemplateParameterPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ConnectableElementTemplateParameterPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TemplateParameterSubstitution.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TemplateParameterSubstitutionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TemplateParameterSubstitutionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TemplateParameter.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TemplateParameterPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TemplateParameterPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TemplateSignature.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TemplateSignaturePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TemplateSignaturePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.TemplateBinding.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new TemplateBindingPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new TemplateBindingPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ProfileApplication.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ProfileApplicationPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ProfileApplicationPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Profile.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ProfilePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ProfilePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Image.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ImagePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ImagePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Stereotype.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new StereotypePropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new StereotypePropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.ExtensionEnd.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExtensionEndPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExtensionEndPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Extension.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new ExtensionPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new ExtensionPropertiesEditionPartForm(component);
		}
		if(key == UMLViewsRepository.Comments.class) {
			if(kind == UMLViewsRepository.SWT_KIND)
				return new CommentsPropertiesEditionPartImpl(component);
			if(kind == UMLViewsRepository.FORM_KIND)
				return new CommentsPropertiesEditionPartForm(component);
		}
		return null;
	}

}
