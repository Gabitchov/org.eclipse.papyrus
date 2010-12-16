/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.conversion.di2.Di2Package;
import org.eclipse.papyrus.conversion.di2.GraphElement;
import org.eclipse.papyrus.conversion.di2.SemanticModelBridge;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Semantic Model Bridge</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.SemanticModelBridgeImpl#getPresentation
 * <em>Presentation</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.SemanticModelBridgeImpl#getGraphElement
 * <em>Graph Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SemanticModelBridgeImpl extends EObjectImpl implements SemanticModelBridge {

	/**
	 * The default value of the '{@link #getPresentation() <em>Presentation</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPresentation()
	 * @generated
	 * @ordered
	 */
	protected static final String PRESENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPresentation() <em>Presentation</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPresentation()
	 * @generated
	 * @ordered
	 */
	protected String presentation = PRESENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphElement() <em>Graph Element</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGraphElement()
	 * @generated
	 * @ordered
	 */
	protected GraphElement graphElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SemanticModelBridgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Di2Package.Literals.SEMANTIC_MODEL_BRIDGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPresentation() {
		return presentation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPresentation(String newPresentation) {
		String oldPresentation = presentation;
		presentation = newPresentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.SEMANTIC_MODEL_BRIDGE__PRESENTATION,
					oldPresentation, presentation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement getGraphElement() {
		if (graphElement != null && graphElement.eIsProxy()) {
			InternalEObject oldGraphElement = (InternalEObject) graphElement;
			graphElement = (GraphElement) eResolveProxy(oldGraphElement);
			if (graphElement != oldGraphElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Di2Package.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT, oldGraphElement, graphElement));
			}
		}
		return graphElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement basicGetGraphElement() {
		return graphElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGraphElement(GraphElement newGraphElement) {
		GraphElement oldGraphElement = graphElement;
		graphElement = newGraphElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT,
					oldGraphElement, graphElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Di2Package.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
			return getPresentation();
		case Di2Package.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
			if (resolve)
				return getGraphElement();
			return basicGetGraphElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Di2Package.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
			setPresentation((String) newValue);
			return;
		case Di2Package.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
			setGraphElement((GraphElement) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Di2Package.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
			setPresentation(PRESENTATION_EDEFAULT);
			return;
		case Di2Package.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
			setGraphElement((GraphElement) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Di2Package.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
			return PRESENTATION_EDEFAULT == null ? presentation != null : !PRESENTATION_EDEFAULT.equals(presentation);
		case Di2Package.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
			return graphElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (presentation: ");
		result.append(presentation);
		result.append(')');
		return result.toString();
	}

} // SemanticModelBridgeImpl
