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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TimeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Workload Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl#getGenerator <em>Generator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl#getTimedEvent <em>Timed Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaWorkloadEventImpl extends EObjectImpl implements GaWorkloadEvent {
	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenerator() <em>Generator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerator()
	 * @generated
	 * @ordered
	 */
	protected GaWorkloadGenerator generator;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected GaEventTrace trace;

	/**
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
	protected GaScenario effect;

	/**
	 * The cached value of the '{@link #getTimedEvent() <em>Timed Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimedEvent()
	 * @generated
	 * @ordered
	 */
	protected TimeEvent timedEvent;

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaWorkloadEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_WORKLOAD_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_EVENT__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaWorkloadGenerator getGenerator() {
		if (generator != null && generator.eIsProxy()) {
			InternalEObject oldGenerator = (InternalEObject)generator;
			generator = (GaWorkloadGenerator)eResolveProxy(oldGenerator);
			if (generator != oldGenerator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_WORKLOAD_EVENT__GENERATOR, oldGenerator, generator));
			}
		}
		return generator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaWorkloadGenerator basicGetGenerator() {
		return generator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerator(GaWorkloadGenerator newGenerator) {
		GaWorkloadGenerator oldGenerator = generator;
		generator = newGenerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_EVENT__GENERATOR, oldGenerator, generator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaEventTrace getTrace() {
		if (trace != null && trace.eIsProxy()) {
			InternalEObject oldTrace = (InternalEObject)trace;
			trace = (GaEventTrace)eResolveProxy(oldTrace);
			if (trace != oldTrace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_WORKLOAD_EVENT__TRACE, oldTrace, trace));
			}
		}
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaEventTrace basicGetTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(GaEventTrace newTrace) {
		GaEventTrace oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_EVENT__TRACE, oldTrace, trace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario getEffect() {
		if (effect != null && effect.eIsProxy()) {
			InternalEObject oldEffect = (InternalEObject)effect;
			effect = (GaScenario)eResolveProxy(oldEffect);
			if (effect != oldEffect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_WORKLOAD_EVENT__EFFECT, oldEffect, effect));
			}
		}
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario basicGetEffect() {
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEffect(GaScenario newEffect) {
		GaScenario oldEffect = effect;
		effect = newEffect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_EVENT__EFFECT, oldEffect, effect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent getTimedEvent() {
		if (timedEvent != null && timedEvent.eIsProxy()) {
			InternalEObject oldTimedEvent = (InternalEObject)timedEvent;
			timedEvent = (TimeEvent)eResolveProxy(oldTimedEvent);
			if (timedEvent != oldTimedEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_WORKLOAD_EVENT__TIMED_EVENT, oldTimedEvent, timedEvent));
			}
		}
		return timedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent basicGetTimedEvent() {
		return timedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimedEvent(TimeEvent newTimedEvent) {
		TimeEvent oldTimedEvent = timedEvent;
		timedEvent = newTimedEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_EVENT__TIMED_EVENT, oldTimedEvent, timedEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if (base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if (base_NamedElement != oldBase_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_WORKLOAD_EVENT__PATTERN:
				return getPattern();
			case GQAMPackage.GA_WORKLOAD_EVENT__GENERATOR:
				if (resolve) return getGenerator();
				return basicGetGenerator();
			case GQAMPackage.GA_WORKLOAD_EVENT__TRACE:
				if (resolve) return getTrace();
				return basicGetTrace();
			case GQAMPackage.GA_WORKLOAD_EVENT__EFFECT:
				if (resolve) return getEffect();
				return basicGetEffect();
			case GQAMPackage.GA_WORKLOAD_EVENT__TIMED_EVENT:
				if (resolve) return getTimedEvent();
				return basicGetTimedEvent();
			case GQAMPackage.GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GQAMPackage.GA_WORKLOAD_EVENT__PATTERN:
				setPattern((String)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__GENERATOR:
				setGenerator((GaWorkloadGenerator)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__TRACE:
				setTrace((GaEventTrace)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__EFFECT:
				setEffect((GaScenario)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__TIMED_EVENT:
				setTimedEvent((TimeEvent)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case GQAMPackage.GA_WORKLOAD_EVENT__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__GENERATOR:
				setGenerator((GaWorkloadGenerator)null);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__TRACE:
				setTrace((GaEventTrace)null);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__EFFECT:
				setEffect((GaScenario)null);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__TIMED_EVENT:
				setTimedEvent((TimeEvent)null);
				return;
			case GQAMPackage.GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GQAMPackage.GA_WORKLOAD_EVENT__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case GQAMPackage.GA_WORKLOAD_EVENT__GENERATOR:
				return generator != null;
			case GQAMPackage.GA_WORKLOAD_EVENT__TRACE:
				return trace != null;
			case GQAMPackage.GA_WORKLOAD_EVENT__EFFECT:
				return effect != null;
			case GQAMPackage.GA_WORKLOAD_EVENT__TIMED_EVENT:
				return timedEvent != null;
			case GQAMPackage.GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (pattern: ");
		result.append(pattern);
		result.append(')');
		return result.toString();
	}

} //GaWorkloadEventImpl
