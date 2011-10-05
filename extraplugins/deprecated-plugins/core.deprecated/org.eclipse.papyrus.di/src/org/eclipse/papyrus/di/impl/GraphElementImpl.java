/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.DiagramElement;
import org.eclipse.papyrus.di.DiagramLink;
import org.eclipse.papyrus.di.GraphConnector;
import org.eclipse.papyrus.di.GraphElement;
import org.eclipse.papyrus.di.SemanticModelBridge;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphElementImpl#getContained <em>Contained</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphElementImpl#getLink <em>Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphElementImpl#getSemanticModel <em>Semantic Model</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphElementImpl#getPosition <em>Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphElementImpl#getAnchorage <em>Anchorage</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GraphElementImpl extends DiagramElementImpl implements GraphElement {

	/**
	 * The cached value of the '{@link #getContained() <em>Contained</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContained()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramElement> contained;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramLink> link;

	/**
	 * The cached value of the '{@link #getSemanticModel() <em>Semantic Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSemanticModel()
	 * @generated
	 * @ordered
	 */
	protected SemanticModelBridge semanticModel;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Point POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Point position = POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnchorage() <em>Anchorage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAnchorage()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphConnector> anchorage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GraphElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.GRAPH_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<DiagramElement> getContained() {
		if(contained == null) {
			contained = new EObjectContainmentWithInverseEList<DiagramElement>(DiagramElement.class, this, DiPackage.GRAPH_ELEMENT__CONTAINED, DiPackage.DIAGRAM_ELEMENT__CONTAINER);
		}
		return contained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<DiagramLink> getLink() {
		if(link == null) {
			link = new EObjectContainmentEList<DiagramLink>(DiagramLink.class, this, DiPackage.GRAPH_ELEMENT__LINK);
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SemanticModelBridge getSemanticModel() {
		return semanticModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSemanticModel(SemanticModelBridge newSemanticModel, NotificationChain msgs) {
		SemanticModelBridge oldSemanticModel = semanticModel;
		semanticModel = newSemanticModel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL, oldSemanticModel, newSemanticModel);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSemanticModel(SemanticModelBridge newSemanticModel) {
		if(newSemanticModel != semanticModel) {
			NotificationChain msgs = null;
			if(semanticModel != null)
				msgs = ((InternalEObject)semanticModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL, null, msgs);
			if(newSemanticModel != null)
				msgs = ((InternalEObject)newSemanticModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL, null, msgs);
			msgs = basicSetSemanticModel(newSemanticModel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL, newSemanticModel, newSemanticModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPosition(Point newPosition) {
		Point oldPosition = position;
		position = newPosition;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.GRAPH_ELEMENT__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GraphConnector> getAnchorage() {
		if(anchorage == null) {
			anchorage = new EObjectContainmentWithInverseEList<GraphConnector>(GraphConnector.class, this, DiPackage.GRAPH_ELEMENT__ANCHORAGE, DiPackage.GRAPH_CONNECTOR__GRAPH_ELEMENT);
		}
		return anchorage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getContained()).basicAdd(otherEnd, msgs);
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnchorage()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
			return ((InternalEList<?>)getContained()).basicRemove(otherEnd, msgs);
		case DiPackage.GRAPH_ELEMENT__LINK:
			return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
		case DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
			return basicSetSemanticModel(null, msgs);
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
			return ((InternalEList<?>)getAnchorage()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
			return getContained();
		case DiPackage.GRAPH_ELEMENT__LINK:
			return getLink();
		case DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
			return getSemanticModel();
		case DiPackage.GRAPH_ELEMENT__POSITION:
			return getPosition();
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
			return getAnchorage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
			getContained().clear();
			getContained().addAll((Collection<? extends DiagramElement>)newValue);
			return;
		case DiPackage.GRAPH_ELEMENT__LINK:
			getLink().clear();
			getLink().addAll((Collection<? extends DiagramLink>)newValue);
			return;
		case DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
			setSemanticModel((SemanticModelBridge)newValue);
			return;
		case DiPackage.GRAPH_ELEMENT__POSITION:
			setPosition((Point)newValue);
			return;
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
			getAnchorage().clear();
			getAnchorage().addAll((Collection<? extends GraphConnector>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
			getContained().clear();
			return;
		case DiPackage.GRAPH_ELEMENT__LINK:
			getLink().clear();
			return;
		case DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
			setSemanticModel((SemanticModelBridge)null);
			return;
		case DiPackage.GRAPH_ELEMENT__POSITION:
			setPosition(POSITION_EDEFAULT);
			return;
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
			getAnchorage().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
			return contained != null && !contained.isEmpty();
		case DiPackage.GRAPH_ELEMENT__LINK:
			return link != null && !link.isEmpty();
		case DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
			return semanticModel != null;
		case DiPackage.GRAPH_ELEMENT__POSITION:
			return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
			return anchorage != null && !anchorage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (position: ");
		result.append(position);
		result.append(')');
		return result.toString();
	}

} //GraphElementImpl
