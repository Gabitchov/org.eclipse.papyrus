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
package org.eclipse.papyrus.eastadl.dependability;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.requirements.OperationalSituation;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.uml2.uml.UseCase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hazardous Event</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The HazardousEvent metaclass represents a combination of a Hazard and a specific situation, the latter being characterized by operating mode and
 * operational situation in terms of a particular use case, environment and traffic.
 * 
 * Semantics:
 * The HazardousEvent denotes a combination of a Hazard and an operational situation. The controllability and severity attributes shall be consistent
 * with the operational situation and operational scenario, and the Exposure shall reflect the likelihood of the operational situation and scenario.
 * 
 * Notation:
 * The Hazard is shown as a solid-outline rectangle with "Haz" at the top right. It contains the name of the Hazard and optionally the name of the
 * source entity.
 * 
 * Extension:
 * UML::Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getControllability <em>Controllability</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExposure <em>Exposure</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazardClassification <em>Hazard Classification</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getSeverity <em>Severity</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getClassificationAssumptions <em>Classification Assumptions</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazard <em>Hazard</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getTraffic <em>Traffic</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getEnvironment <em>Environment</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getOperationalSituationUseCase <em>Operational Situation Use Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getOperatingMode <em>Operating Mode</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExternalMeasures <em>External Measures</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent()
 * @model
 * @generated
 */
public interface HazardousEvent extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Classification Assumptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classification Assumptions</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Classification Assumptions</em>' attribute.
	 * @see #setClassificationAssumptions(String)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_ClassificationAssumptions()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getClassificationAssumptions();

	/**
	 * Returns the value of the '<em><b>Controllability</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controllability</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Controllability</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
	 * @see #setControllability(ControllabilityClassKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Controllability()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ControllabilityClassKind getControllability();

	/**
	 * Returns the value of the '<em><b>Environment</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.OperationalSituation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Environment</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Environment()
	 * @model ordered="false"
	 * @generated
	 */
	EList<OperationalSituation> getEnvironment();

	/**
	 * Returns the value of the '<em><b>Exposure</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.ExposureClassKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposure</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exposure</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.ExposureClassKind
	 * @see #setExposure(ExposureClassKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Exposure()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ExposureClassKind getExposure();

	/**
	 * Returns the value of the '<em><b>External Measures</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Measures</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>External Measures</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_ExternalMeasures()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Requirement> getExternalMeasures();

	/**
	 * Returns the value of the '<em><b>Hazard</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.Hazard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazard</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hazard</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Hazard()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Hazard> getHazard();

	/**
	 * Returns the value of the '<em><b>Hazard Classification</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazard Classification</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hazard Classification</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see #setHazardClassification(ASILKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_HazardClassification()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ASILKind getHazardClassification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazardClassification <em>Hazard Classification</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Hazard Classification</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see #getHazardClassification()
	 * @generated
	 */
	void setHazardClassification(ASILKind value);

	/**
	 * Returns the value of the '<em><b>Operating Mode</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating Mode</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operating Mode</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_OperatingMode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getOperatingMode();

	/**
	 * Returns the value of the '<em><b>Operational Situation Use Case</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Situation Use Case</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operational Situation Use Case</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_OperationalSituationUseCase()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<UseCase> getOperationalSituationUseCase();

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.SeverityClassKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.SeverityClassKind
	 * @see #setSeverity(SeverityClassKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Severity()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	SeverityClassKind getSeverity();

	/**
	 * Returns the value of the '<em><b>Traffic</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.OperationalSituation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traffic</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Traffic</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getHazardousEvent_Traffic()
	 * @model ordered="false"
	 * @generated
	 */
	EList<OperationalSituation> getTraffic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getClassificationAssumptions
	 * <em>Classification Assumptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Classification Assumptions</em>' attribute.
	 * @see #getClassificationAssumptions()
	 * @generated
	 */
	void setClassificationAssumptions(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getControllability <em>Controllability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Controllability</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
	 * @see #getControllability()
	 * @generated
	 */
	void setControllability(ControllabilityClassKind value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExposure <em>Exposure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Exposure</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.ExposureClassKind
	 * @see #getExposure()
	 * @generated
	 */
	void setExposure(ExposureClassKind value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.SeverityClassKind
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(SeverityClassKind value);

} // HazardousEvent
