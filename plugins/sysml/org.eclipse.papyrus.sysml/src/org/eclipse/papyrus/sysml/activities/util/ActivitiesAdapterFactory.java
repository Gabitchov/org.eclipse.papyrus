/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.activities.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.Continuous;
import org.eclipse.papyrus.sysml.activities.ControlOperator;
import org.eclipse.papyrus.sysml.activities.Discrete;
import org.eclipse.papyrus.sysml.activities.NoBuffer;
import org.eclipse.papyrus.sysml.activities.Optional;
import org.eclipse.papyrus.sysml.activities.Overwrite;
import org.eclipse.papyrus.sysml.activities.Probability;
import org.eclipse.papyrus.sysml.activities.Rate;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage
 * @generated
 */
public class ActivitiesAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ActivitiesPackage modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivitiesSwitch<Adapter> modelSwitch = new ActivitiesSwitch<Adapter>() {


		@Override
		public Adapter caseParameterStereotypedByOptional(Parameter parameter_) {
			if(isOptionalFromParameter(parameter_)) {
				return createOptionalAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseParameterStereotypedByRate(Parameter parameter_) {
			if(isRateFromParameter(parameter_)) {
				return createRateAdapter();
			}
			return null;
		}

		@Override
		public Adapter caseActivityEdgeStereotypedByRate(ActivityEdge activityEdge_) {
			if(isRateFromActivityEdge(activityEdge_)) {
				return createRateAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseActivityEdgeStereotypedByProbability(ActivityEdge activityEdge_) {
			if(isProbabilityFromActivityEdge(activityEdge_)) {
				return createProbabilityAdapter();
			}
			return null;
		}

		@Override
		public Adapter caseParameterSetStereotypedByProbability(ParameterSet parameterSet_) {
			if(isProbabilityFromParameterSet(parameterSet_)) {
				return createProbabilityAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseParameterStereotypedByContinuous(Parameter parameter_) {
			if(isContinuousFromParameter(parameter_)) {
				return createContinuousAdapter();
			}
			return null;
		}

		@Override
		public Adapter caseActivityEdgeStereotypedByContinuous(ActivityEdge activityEdge_) {
			if(isContinuousFromActivityEdge(activityEdge_)) {
				return createContinuousAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseParameterStereotypedByDiscrete(Parameter parameter_) {
			if(isDiscreteFromParameter(parameter_)) {
				return createDiscreteAdapter();
			}
			return null;
		}

		@Override
		public Adapter caseActivityEdgeStereotypedByDiscrete(ActivityEdge activityEdge_) {
			if(isDiscreteFromActivityEdge(activityEdge_)) {
				return createDiscreteAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseOperationStereotypedByControlOperator(Operation operation_) {
			if(isControlOperatorFromOperation(operation_)) {
				return createControlOperatorAdapter();
			}
			return null;
		}

		@Override
		public Adapter caseBehaviorStereotypedByControlOperator(Behavior behavior_) {
			if(isControlOperatorFromBehavior(behavior_)) {
				return createControlOperatorAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseObjectNodeStereotypedByNoBuffer(ObjectNode objectNode_) {
			if(isNoBufferFromObjectNode(objectNode_)) {
				return createNoBufferAdapter();
			}
			return null;
		}



		@Override
		public Adapter caseObjectNodeStereotypedByOverwrite(ObjectNode objectNode_) {
			if(isOverwriteFromObjectNode(objectNode_)) {
				return createOverwriteAdapter();
			}
			return null;
		}


		@Override
		public Adapter caseOptional(Optional object) {
			return createOptionalAdapter();
		}

		@Override
		public Adapter caseRate(Rate object) {
			return createRateAdapter();
		}

		@Override
		public Adapter caseProbability(Probability object) {
			return createProbabilityAdapter();
		}

		@Override
		public Adapter caseContinuous(Continuous object) {
			return createContinuousAdapter();
		}

		@Override
		public Adapter caseDiscrete(Discrete object) {
			return createDiscreteAdapter();
		}

		@Override
		public Adapter caseControlOperator(ControlOperator object) {
			return createControlOperatorAdapter();
		}

		@Override
		public Adapter caseNoBuffer(NoBuffer object) {
			return createNoBufferAdapter();
		}

		@Override
		public Adapter caseOverwrite(Overwrite object) {
			return createOverwriteAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivitiesAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = ActivitiesPackage.eINSTANCE;
		}
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *        the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.Optional <em>Optional</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.Optional
	 * @generated
	 */
	public Adapter createOptionalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.Continuous <em>Continuous</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.Continuous
	 * @generated
	 */
	public Adapter createContinuousAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.ControlOperator <em>Control Operator</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.ControlOperator
	 * @generated
	 */
	public Adapter createControlOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.Discrete <em>Discrete</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.Discrete
	 * @generated
	 */
	public Adapter createDiscreteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.NoBuffer <em>No Buffer</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.NoBuffer
	 * @generated
	 */
	public Adapter createNoBufferAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.Overwrite <em>Overwrite</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.Overwrite
	 * @generated
	 */
	public Adapter createOverwriteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml.activities.Probability <em>Probability</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.Probability
	 * @generated
	 */
	public Adapter createProbabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class ' {@link org.eclipse.papyrus.sysml.activities.Rate <em>Rate</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml.activities.Rate
	 * @generated
	 */
	public Adapter createRateAdapter() {
		return null;
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage || object == UMLPackage.eINSTANCE) {
			return true;
		}
		if(object instanceof EObject) {
			EPackage ePackage = ((EObject)object).eClass().getEPackage();
			return ePackage != null && (ePackage == modelPackage || ePackage == UMLPackage.eINSTANCE);
		}
		return false;
	}

} // ActivitiesAdapterFactory
