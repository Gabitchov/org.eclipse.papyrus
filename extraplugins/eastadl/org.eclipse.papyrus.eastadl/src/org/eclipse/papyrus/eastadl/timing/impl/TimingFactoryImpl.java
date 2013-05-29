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
package org.eclipse.papyrus.eastadl.timing.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.timing.EventChain;
import org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint;
import org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.Timing;
import org.eclipse.papyrus.eastadl.timing.TimingFactory;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class TimingFactoryImpl extends EFactoryImpl implements TimingFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TimingPackage getPackage() {
		return TimingPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static TimingFactory init() {
		try {
			TimingFactory theTimingFactory = (TimingFactory)EPackage.Registry.INSTANCE.getEFactory(TimingPackage.eNS_URI);
			if (theTimingFactory != null) {
				return theTimingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TimingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TimingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TimingPackage.TIME_DURATION: return createTimeDuration();
			case TimingPackage.TIMING: return createTiming();
			case TimingPackage.EVENT_CHAIN: return createEventChain();
			case TimingPackage.EXECUTION_TIME_CONSTRAINT: return createExecutionTimeConstraint();
			case TimingPackage.PRECEDENCE_CONSTRAINT: return createPrecedenceConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventChain createEventChain() {
		EventChainImpl eventChain = new EventChainImpl();
		return eventChain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeConstraint createExecutionTimeConstraint() {
		ExecutionTimeConstraintImpl executionTimeConstraint = new ExecutionTimeConstraintImpl();
		return executionTimeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrecedenceConstraint createPrecedenceConstraint() {
		PrecedenceConstraintImpl precedenceConstraint = new PrecedenceConstraintImpl();
		return precedenceConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration createTimeDuration() {
		TimeDurationImpl timeDuration = new TimeDurationImpl();
		return timeDuration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Timing createTiming() {
		TimingImpl timing = new TimingImpl();
		return timing;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TimingPackage getTimingPackage() {
		return (TimingPackage)getEPackage();
	}

} // TimingFactoryImpl
