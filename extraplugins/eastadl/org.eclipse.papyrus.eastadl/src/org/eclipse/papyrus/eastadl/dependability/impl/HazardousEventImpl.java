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
package org.eclipse.papyrus.eastadl.dependability.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind;
import org.eclipse.papyrus.eastadl.dependability.DependabilityPackage;
import org.eclipse.papyrus.eastadl.dependability.ExposureClassKind;
import org.eclipse.papyrus.eastadl.dependability.Hazard;
import org.eclipse.papyrus.eastadl.dependability.HazardousEvent;
import org.eclipse.papyrus.eastadl.dependability.SeverityClassKind;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.papyrus.eastadl.requirements.OperationalSituation;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.uml2.uml.UseCase;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hazardous Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getControllability <em>Controllability</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getExposure <em>Exposure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getHazardClassification <em>Hazard Classification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getClassificationAssumptions <em>Classification Assumptions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getHazard <em>Hazard</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getTraffic <em>Traffic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getOperationalSituationUseCase <em>Operational Situation Use Case</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getOperatingMode <em>Operating Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl#getExternalMeasures <em>External Measures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HazardousEventImpl extends TraceableSpecificationImpl implements HazardousEvent {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getControllability() <em>Controllability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllability()
	 * @generated
	 * @ordered
	 */
	protected static final ControllabilityClassKind CONTROLLABILITY_EDEFAULT = ControllabilityClassKind.C1;

	/**
	 * The cached value of the '{@link #getControllability() <em>Controllability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllability()
	 * @generated
	 * @ordered
	 */
	protected ControllabilityClassKind controllability = CONTROLLABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExposure() <em>Exposure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposure()
	 * @generated
	 * @ordered
	 */
	protected static final ExposureClassKind EXPOSURE_EDEFAULT = ExposureClassKind.E1;

	/**
	 * The cached value of the '{@link #getExposure() <em>Exposure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposure()
	 * @generated
	 * @ordered
	 */
	protected ExposureClassKind exposure = EXPOSURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHazardClassification() <em>Hazard Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardClassification()
	 * @generated
	 * @ordered
	 */
	protected static final ASILKind HAZARD_CLASSIFICATION_EDEFAULT = ASILKind.ASIL_A;

	/**
	 * The cached value of the '{@link #getHazardClassification() <em>Hazard Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardClassification()
	 * @generated
	 * @ordered
	 */
	protected ASILKind hazardClassification = HAZARD_CLASSIFICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final SeverityClassKind SEVERITY_EDEFAULT = SeverityClassKind.S0;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected SeverityClassKind severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassificationAssumptions() <em>Classification Assumptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassificationAssumptions()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSIFICATION_ASSUMPTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassificationAssumptions() <em>Classification Assumptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassificationAssumptions()
	 * @generated
	 * @ordered
	 */
	protected String classificationAssumptions = CLASSIFICATION_ASSUMPTIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHazard() <em>Hazard</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazard()
	 * @generated
	 * @ordered
	 */
	protected EList<Hazard> hazard;

	/**
	 * The cached value of the '{@link #getTraffic() <em>Traffic</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraffic()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationalSituation> traffic;

	/**
	 * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationalSituation> environment;

	/**
	 * The cached value of the '{@link #getOperationalSituationUseCase() <em>Operational Situation Use Case</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationalSituationUseCase()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> operationalSituationUseCase;

	/**
	 * The cached value of the '{@link #getOperatingMode() <em>Operating Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> operatingMode;

	/**
	 * The cached value of the '{@link #getExternalMeasures() <em>External Measures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> externalMeasures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HazardousEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityPackage.HAZARDOUS_EVENT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case DependabilityPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
				return getControllability();
			case DependabilityPackage.HAZARDOUS_EVENT__EXPOSURE:
				return getExposure();
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD_CLASSIFICATION:
				return getHazardClassification();
			case DependabilityPackage.HAZARDOUS_EVENT__SEVERITY:
				return getSeverity();
			case DependabilityPackage.HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS:
				return getClassificationAssumptions();
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD:
				return getHazard();
			case DependabilityPackage.HAZARDOUS_EVENT__TRAFFIC:
				return getTraffic();
			case DependabilityPackage.HAZARDOUS_EVENT__ENVIRONMENT:
				return getEnvironment();
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE:
				return getOperationalSituationUseCase();
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATING_MODE:
				return getOperatingMode();
			case DependabilityPackage.HAZARDOUS_EVENT__EXTERNAL_MEASURES:
				return getExternalMeasures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DependabilityPackage.HAZARDOUS_EVENT__BASE_CLASS:
				return base_Class != null;
			case DependabilityPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
				return controllability != CONTROLLABILITY_EDEFAULT;
			case DependabilityPackage.HAZARDOUS_EVENT__EXPOSURE:
				return exposure != EXPOSURE_EDEFAULT;
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD_CLASSIFICATION:
				return hazardClassification != HAZARD_CLASSIFICATION_EDEFAULT;
			case DependabilityPackage.HAZARDOUS_EVENT__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case DependabilityPackage.HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS:
				return CLASSIFICATION_ASSUMPTIONS_EDEFAULT == null ? classificationAssumptions != null : !CLASSIFICATION_ASSUMPTIONS_EDEFAULT.equals(classificationAssumptions);
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD:
				return hazard != null && !hazard.isEmpty();
			case DependabilityPackage.HAZARDOUS_EVENT__TRAFFIC:
				return traffic != null && !traffic.isEmpty();
			case DependabilityPackage.HAZARDOUS_EVENT__ENVIRONMENT:
				return environment != null && !environment.isEmpty();
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE:
				return operationalSituationUseCase != null && !operationalSituationUseCase.isEmpty();
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATING_MODE:
				return operatingMode != null && !operatingMode.isEmpty();
			case DependabilityPackage.HAZARDOUS_EVENT__EXTERNAL_MEASURES:
				return externalMeasures != null && !externalMeasures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DependabilityPackage.HAZARDOUS_EVENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
				setControllability((ControllabilityClassKind)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__EXPOSURE:
				setExposure((ExposureClassKind)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD_CLASSIFICATION:
				setHazardClassification((ASILKind)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__SEVERITY:
				setSeverity((SeverityClassKind)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS:
				setClassificationAssumptions((String)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD:
				getHazard().clear();
				getHazard().addAll((Collection<? extends Hazard>)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__TRAFFIC:
				getTraffic().clear();
				getTraffic().addAll((Collection<? extends OperationalSituation>)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__ENVIRONMENT:
				getEnvironment().clear();
				getEnvironment().addAll((Collection<? extends OperationalSituation>)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE:
				getOperationalSituationUseCase().clear();
				getOperationalSituationUseCase().addAll((Collection<? extends UseCase>)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATING_MODE:
				getOperatingMode().clear();
				getOperatingMode().addAll((Collection<? extends Mode>)newValue);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__EXTERNAL_MEASURES:
				getExternalMeasures().clear();
				getExternalMeasures().addAll((Collection<? extends Requirement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityPackage.Literals.HAZARDOUS_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityPackage.HAZARDOUS_EVENT__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.HAZARDOUS_EVENT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DependabilityPackage.HAZARDOUS_EVENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
				setControllability(CONTROLLABILITY_EDEFAULT);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__EXPOSURE:
				setExposure(EXPOSURE_EDEFAULT);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD_CLASSIFICATION:
				setHazardClassification(HAZARD_CLASSIFICATION_EDEFAULT);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS:
				setClassificationAssumptions(CLASSIFICATION_ASSUMPTIONS_EDEFAULT);
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__HAZARD:
				getHazard().clear();
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__TRAFFIC:
				getTraffic().clear();
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__ENVIRONMENT:
				getEnvironment().clear();
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE:
				getOperationalSituationUseCase().clear();
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__OPERATING_MODE:
				getOperatingMode().clear();
				return;
			case DependabilityPackage.HAZARDOUS_EVENT__EXTERNAL_MEASURES:
				getExternalMeasures().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassificationAssumptions() {
		return classificationAssumptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllabilityClassKind getControllability() {
		return controllability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationalSituation> getEnvironment() {
		if (environment == null) {
			environment = new EObjectResolvingEList<OperationalSituation>(OperationalSituation.class, this, DependabilityPackage.HAZARDOUS_EVENT__ENVIRONMENT);
		}
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExposureClassKind getExposure() {
		return exposure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getExternalMeasures() {
		if (externalMeasures == null) {
			externalMeasures = new EObjectResolvingEList<Requirement>(Requirement.class, this, DependabilityPackage.HAZARDOUS_EVENT__EXTERNAL_MEASURES);
		}
		return externalMeasures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hazard> getHazard() {
		if (hazard == null) {
			hazard = new EObjectResolvingEList<Hazard>(Hazard.class, this, DependabilityPackage.HAZARDOUS_EVENT__HAZARD);
		}
		return hazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILKind getHazardClassification() {
		return hazardClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHazardClassification(ASILKind newHazardClassification) {
		ASILKind oldHazardClassification = hazardClassification;
		hazardClassification = newHazardClassification == null ? HAZARD_CLASSIFICATION_EDEFAULT : newHazardClassification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.HAZARDOUS_EVENT__HAZARD_CLASSIFICATION, oldHazardClassification, hazardClassification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getOperatingMode() {
		if (operatingMode == null) {
			operatingMode = new EObjectResolvingEList<Mode>(Mode.class, this, DependabilityPackage.HAZARDOUS_EVENT__OPERATING_MODE);
		}
		return operatingMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getOperationalSituationUseCase() {
		if (operationalSituationUseCase == null) {
			operationalSituationUseCase = new EObjectResolvingEList<UseCase>(UseCase.class, this, DependabilityPackage.HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE);
		}
		return operationalSituationUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeverityClassKind getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationalSituation> getTraffic() {
		if (traffic == null) {
			traffic = new EObjectResolvingEList<OperationalSituation>(OperationalSituation.class, this, DependabilityPackage.HAZARDOUS_EVENT__TRAFFIC);
		}
		return traffic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassificationAssumptions(String newClassificationAssumptions) {
		String oldClassificationAssumptions = classificationAssumptions;
		classificationAssumptions = newClassificationAssumptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS, oldClassificationAssumptions, classificationAssumptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllability(ControllabilityClassKind newControllability) {
		ControllabilityClassKind oldControllability = controllability;
		controllability = newControllability == null ? CONTROLLABILITY_EDEFAULT : newControllability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.HAZARDOUS_EVENT__CONTROLLABILITY, oldControllability, controllability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExposure(ExposureClassKind newExposure) {
		ExposureClassKind oldExposure = exposure;
		exposure = newExposure == null ? EXPOSURE_EDEFAULT : newExposure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.HAZARDOUS_EVENT__EXPOSURE, oldExposure, exposure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(SeverityClassKind newSeverity) {
		SeverityClassKind oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.HAZARDOUS_EVENT__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (controllability: ");
		result.append(controllability);
		result.append(", exposure: ");
		result.append(exposure);
		result.append(", hazardClassification: ");
		result.append(hazardClassification);
		result.append(", severity: ");
		result.append(severity);
		result.append(", classificationAssumptions: ");
		result.append(classificationAssumptions);
		result.append(')');
		return result.toString();
	}

} //HazardousEventImpl
