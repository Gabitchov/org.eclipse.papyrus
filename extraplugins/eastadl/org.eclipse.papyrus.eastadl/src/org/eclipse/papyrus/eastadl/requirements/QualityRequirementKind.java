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
package org.eclipse.papyrus.eastadl.requirements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration ' <em><b>Quality Requirement Kind</b></em>', and utility methods for
 * working with them. <!--
 * end-user-doc --> <!-- begin-model-doc --> Various types of quality requirements. <!--
 * end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getQualityRequirementKind()
 * @model
 * @generated
 */
public enum QualityRequirementKind implements Enumerator {
	/**
	 * The '<em><b>Ergonomy</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ERGONOMY_VALUE
	 * @generated
	 * @ordered
	 */
	ERGONOMY(0, "ergonomy", "ergonomy"),

	/**
	 * The '<em><b>Configurability</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #CONFIGURABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIGURABILITY(1, "configurability", "configurability"),

	/**
	 * The '<em><b>Integrity</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #INTEGRITY_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGRITY(2, "integrity", "integrity"), /**
	 * The '<em><b>Safety</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SAFETY_VALUE
	 * @generated
	 * @ordered
	 */
	SAFETY(3, "safety", "safety"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(4, "other", "other"),

	/**
	 * The '<em><b>Security</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SECURITY_VALUE
	 * @generated
	 * @ordered
	 */
	SECURITY(5, "security", "security"),

	/**
	 * The '<em><b>Human Machine Interface</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #HUMAN_MACHINE_INTERFACE_VALUE
	 * @generated
	 * @ordered
	 */
	HUMAN_MACHINE_INTERFACE(6, "humanMachineInterface", "humanMachineInterface"), /**
	 * The '<em><b>Timing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #TIMING_VALUE
	 * @generated
	 * @ordered
	 */
	TIMING(7, "timing", "timing"), /**
	 * The '<em><b>Availability</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #AVAILABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	AVAILABILITY(8, "availability", "availability"), /**
	 * The '<em><b>Reliability</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #RELIABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	RELIABILITY(9, "reliability", "reliability"), /**
	 * The '<em><b>Confidentiality</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #CONFIDENTIALITY_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIDENTIALITY(10, "confidentiality", "confidentiality"), /**
	 * The '<em><b>Maintainability</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MAINTAINABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	MAINTAINABILITY(11, "maintainability", "maintainability");

	/**
	 * The '<em><b>Ergonomy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ergonomy</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ERGONOMY
	 * @model name="ergonomy"
	 * @generated
	 * @ordered
	 */
	public static final int ERGONOMY_VALUE = 0;

	/**
	 * The '<em><b>Configurability</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Configurability</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CONFIGURABILITY
	 * @model name="configurability"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIGURABILITY_VALUE = 1;

	/**
	 * The '<em><b>Integrity</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integrity</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INTEGRITY
	 * @model name="integrity"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGRITY_VALUE = 2;

	/**
	 * The '<em><b>Safety</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Safety</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SAFETY
	 * @model name="safety"
	 * @generated
	 * @ordered
	 */
	public static final int SAFETY_VALUE = 3;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OTHER
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 4;

	/**
	 * The '<em><b>Security</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Security</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SECURITY
	 * @model name="security"
	 * @generated
	 * @ordered
	 */
	public static final int SECURITY_VALUE = 5;

	/**
	 * The '<em><b>Human Machine Interface</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Human Machine Interface</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #HUMAN_MACHINE_INTERFACE
	 * @model name="humanMachineInterface"
	 * @generated
	 * @ordered
	 */
	public static final int HUMAN_MACHINE_INTERFACE_VALUE = 6;

	/**
	 * The '<em><b>Timing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Timing</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TIMING
	 * @model name="timing"
	 * @generated
	 * @ordered
	 */
	public static final int TIMING_VALUE = 7;

	/**
	 * The '<em><b>Availability</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Availability</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #AVAILABILITY
	 * @model name="availability"
	 * @generated
	 * @ordered
	 */
	public static final int AVAILABILITY_VALUE = 8;

	/**
	 * The '<em><b>Reliability</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reliability</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #RELIABILITY
	 * @model name="reliability"
	 * @generated
	 * @ordered
	 */
	public static final int RELIABILITY_VALUE = 9;

	/**
	 * The '<em><b>Confidentiality</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Confidentiality</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CONFIDENTIALITY
	 * @model name="confidentiality"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIDENTIALITY_VALUE = 10;

	/**
	 * The '<em><b>Maintainability</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Maintainability</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #MAINTAINABILITY
	 * @model name="maintainability"
	 * @generated
	 * @ordered
	 */
	public static final int MAINTAINABILITY_VALUE = 11;

	/**
	 * An array of all the '<em><b>Quality Requirement Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final QualityRequirementKind[] VALUES_ARRAY = new QualityRequirementKind[]{ ERGONOMY, CONFIGURABILITY, INTEGRITY, SAFETY, OTHER, SECURITY, HUMAN_MACHINE_INTERFACE, TIMING, AVAILABILITY, RELIABILITY, CONFIDENTIALITY, MAINTAINABILITY, };

	/**
	 * A public read-only list of all the '<em><b>Quality Requirement Kind</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<QualityRequirementKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Quality Requirement Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static QualityRequirementKind get(int value) {
		switch(value) {
		case ERGONOMY_VALUE:
			return ERGONOMY;
		case CONFIGURABILITY_VALUE:
			return CONFIGURABILITY;
		case INTEGRITY_VALUE:
			return INTEGRITY;
		case SAFETY_VALUE:
			return SAFETY;
		case OTHER_VALUE:
			return OTHER;
		case SECURITY_VALUE:
			return SECURITY;
		case HUMAN_MACHINE_INTERFACE_VALUE:
			return HUMAN_MACHINE_INTERFACE;
		case TIMING_VALUE:
			return TIMING;
		case AVAILABILITY_VALUE:
			return AVAILABILITY;
		case RELIABILITY_VALUE:
			return RELIABILITY;
		case CONFIDENTIALITY_VALUE:
			return CONFIDENTIALITY;
		case MAINTAINABILITY_VALUE:
			return MAINTAINABILITY;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Quality Requirement Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static QualityRequirementKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			QualityRequirementKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Quality Requirement Kind</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static QualityRequirementKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			QualityRequirementKind result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private QualityRequirementKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // QualityRequirementKind
