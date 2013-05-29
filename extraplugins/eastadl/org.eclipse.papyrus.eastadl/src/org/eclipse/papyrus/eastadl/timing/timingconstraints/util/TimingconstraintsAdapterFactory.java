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
package org.eclipse.papyrus.eastadl.timing.timingconstraints.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.timing.TimingConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage
 * @generated
 */
public class TimingconstraintsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TimingconstraintsPackage modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimingconstraintsSwitch<Adapter> modelSwitch =
		new TimingconstraintsSwitch<Adapter>() {
			@Override
			public Adapter caseDelayConstraint(DelayConstraint object) {
				return createDelayConstraintAdapter();
			}
			@Override
			public Adapter caseAgeTimingConstraint(AgeTimingConstraint object) {
				return createAgeTimingConstraintAdapter();
			}
			@Override
			public Adapter caseEventConstraint(EventConstraint object) {
				return createEventConstraintAdapter();
			}
			@Override
			public Adapter caseInputSynchronizationConstraint(InputSynchronizationConstraint object) {
				return createInputSynchronizationConstraintAdapter();
			}
			@Override
			public Adapter caseOutputSynchronizationConstraint(OutputSynchronizationConstraint object) {
				return createOutputSynchronizationConstraintAdapter();
			}
			@Override
			public Adapter caseReactionConstraint(ReactionConstraint object) {
				return createReactionConstraintAdapter();
			}
			@Override
			public Adapter caseSporadicEventConstraint(SporadicEventConstraint object) {
				return createSporadicEventConstraintAdapter();
			}
			@Override
			public Adapter casePeriodicEventConstraint(PeriodicEventConstraint object) {
				return createPeriodicEventConstraintAdapter();
			}
			@Override
			public Adapter casePatternEventConstraint(PatternEventConstraint object) {
				return createPatternEventConstraintAdapter();
			}
			@Override
			public Adapter caseArbitraryEventConstraint(ArbitraryEventConstraint object) {
				return createArbitraryEventConstraintAdapter();
			}
			@Override
			public Adapter caseEAElement(EAElement object) {
				return createEAElementAdapter();
			}
			@Override
			public Adapter caseTimingConstraint(TimingConstraint object) {
				return createTimingConstraintAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingconstraintsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TimingconstraintsPackage.eINSTANCE;
		}
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint <em>Age Timing Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint
	 * @generated
	 */
	public Adapter createAgeTimingConstraintAdapter() {
		return null;
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint <em>Arbitrary Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint
	 * @generated
	 */
	public Adapter createArbitraryEventConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement <em>EA Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement
	 * @generated
	 */
	public Adapter createEAElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint <em>Delay Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint
	 * @generated
	 */
	public Adapter createDelayConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint <em>Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint
	 * @generated
	 */
	public Adapter createEventConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint <em>Input Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint
	 * @generated
	 */
	public Adapter createInputSynchronizationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint <em>Output Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint
	 * @generated
	 */
	public Adapter createOutputSynchronizationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint <em>Pattern Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint
	 * @generated
	 */
	public Adapter createPatternEventConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint <em>Periodic Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint
	 * @generated
	 */
	public Adapter createPeriodicEventConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint <em>Reaction Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint
	 * @generated
	 */
	public Adapter createReactionConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint <em>Sporadic Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint
	 * @generated
	 */
	public Adapter createSporadicEventConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.timing.TimingConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingConstraint
	 * @generated
	 */
	public Adapter createTimingConstraintAdapter() {
		return null;
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

} //TimingconstraintsAdapterFactory
