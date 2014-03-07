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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.requirements.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.requirements.Actor;
import org.eclipse.papyrus.eastadl.requirements.DeriveRequirement;
import org.eclipse.papyrus.eastadl.requirements.Extend;
import org.eclipse.papyrus.eastadl.requirements.ExtensionPoint;
import org.eclipse.papyrus.eastadl.requirements.Include;
import org.eclipse.papyrus.eastadl.requirements.OperationalSituation;
import org.eclipse.papyrus.eastadl.requirements.QualityRequirement;
import org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind;
import org.eclipse.papyrus.eastadl.requirements.Refine;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;
import org.eclipse.papyrus.eastadl.requirements.RequirementsFactory;
import org.eclipse.papyrus.eastadl.requirements.RequirementsLink;
import org.eclipse.papyrus.eastadl.requirements.RequirementsModel;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.papyrus.eastadl.requirements.RequirementsRelatedInformation;
import org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup;
import org.eclipse.papyrus.eastadl.requirements.Satisfy;
import org.eclipse.papyrus.eastadl.requirements.UseCase;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class RequirementsFactoryImpl extends EFactoryImpl implements RequirementsFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequirementsPackage getPackage() {
		return RequirementsPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RequirementsFactory init() {
		try {
			RequirementsFactory theRequirementsFactory = (RequirementsFactory)EPackage.Registry.INSTANCE.getEFactory(RequirementsPackage.eNS_URI);
			if(theRequirementsFactory != null) {
				return theRequirementsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequirementsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertQualityRequirementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case RequirementsPackage.QUALITY_REQUIREMENT_KIND:
			return convertQualityRequirementKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case RequirementsPackage.QUALITY_REQUIREMENT:
			return createQualityRequirement();
		case RequirementsPackage.REQUIREMENT:
			return createRequirement();
		case RequirementsPackage.REQUIREMENTS_CONTAINER:
			return createRequirementsContainer();
		case RequirementsPackage.REQUIREMENTS_RELATED_INFORMATION:
			return createRequirementsRelatedInformation();
		case RequirementsPackage.SATISFY:
			return createSatisfy();
		case RequirementsPackage.USE_CASE:
			return createUseCase();
		case RequirementsPackage.INCLUDE:
			return createInclude();
		case RequirementsPackage.EXTEND:
			return createExtend();
		case RequirementsPackage.EXTENSION_POINT:
			return createExtensionPoint();
		case RequirementsPackage.REFINE:
			return createRefine();
		case RequirementsPackage.DERIVE_REQUIREMENT:
			return createDeriveRequirement();
		case RequirementsPackage.REQUIREMENTS_RELATION_GROUP:
			return createRequirementsRelationGroup();
		case RequirementsPackage.REQUIREMENTS_LINK:
			return createRequirementsLink();
		case RequirementsPackage.REQUIREMENTS_MODEL:
			return createRequirementsModel();
		case RequirementsPackage.OPERATIONAL_SITUATION:
			return createOperationalSituation();
		case RequirementsPackage.ACTOR:
			return createActor();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeriveRequirement createDeriveRequirement() {
		DeriveRequirementImpl deriveRequirement = new DeriveRequirementImpl();
		return deriveRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case RequirementsPackage.QUALITY_REQUIREMENT_KIND:
			return createQualityRequirementKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationalSituation createOperationalSituation() {
		OperationalSituationImpl operationalSituation = new OperationalSituationImpl();
		return operationalSituation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QualityRequirement createQualityRequirement() {
		QualityRequirementImpl qualityRequirement = new QualityRequirementImpl();
		return qualityRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QualityRequirementKind createQualityRequirementKindFromString(EDataType eDataType, String initialValue) {
		QualityRequirementKind result = QualityRequirementKind.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Refine createRefine() {
		RefineImpl refine = new RefineImpl();
		return refine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsContainer createRequirementsContainer() {
		RequirementsContainerImpl requirementsContainer = new RequirementsContainerImpl();
		return requirementsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsLink createRequirementsLink() {
		RequirementsLinkImpl requirementsLink = new RequirementsLinkImpl();
		return requirementsLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsModel createRequirementsModel() {
		RequirementsModelImpl requirementsModel = new RequirementsModelImpl();
		return requirementsModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsRelatedInformation createRequirementsRelatedInformation() {
		RequirementsRelatedInformationImpl requirementsRelatedInformation = new RequirementsRelatedInformationImpl();
		return requirementsRelatedInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsRelationGroup createRequirementsRelationGroup() {
		RequirementsRelationGroupImpl requirementsRelationGroup = new RequirementsRelationGroupImpl();
		return requirementsRelationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Satisfy createSatisfy() {
		SatisfyImpl satisfy = new SatisfyImpl();
		return satisfy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UseCase createUseCase() {
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Include createInclude() {
		IncludeImpl include = new IncludeImpl();
		return include;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Extend createExtend() {
		ExtendImpl extend = new ExtendImpl();
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtensionPoint createExtensionPoint() {
		ExtensionPointImpl extensionPoint = new ExtensionPointImpl();
		return extensionPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsPackage getRequirementsPackage() {
		return (RequirementsPackage)getEPackage();
	}

} // RequirementsFactoryImpl
