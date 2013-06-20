/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotML.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.RobotML.Agent;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.Surface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.AgentImpl#getMovesOver <em>Moves Over</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AgentImpl extends PhysicalObjectImpl implements Agent {

	/**
	 * The cached value of the '{@link #getMovesOver() <em>Moves Over</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMovesOver()
	 * @generated
	 * @ordered
	 */
	protected EList<Surface> movesOver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AgentImpl() {
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
		return RobotMLPackage.Literals.AGENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Surface> getMovesOver() {
		if(movesOver == null) {
			movesOver = new EObjectResolvingEList<Surface>(Surface.class, this, RobotMLPackage.AGENT__MOVES_OVER);
		}
		return movesOver;
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
		case RobotMLPackage.AGENT__MOVES_OVER:
			return getMovesOver();
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
		case RobotMLPackage.AGENT__MOVES_OVER:
			getMovesOver().clear();
			getMovesOver().addAll((Collection<? extends Surface>)newValue);
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
		case RobotMLPackage.AGENT__MOVES_OVER:
			getMovesOver().clear();
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
		case RobotMLPackage.AGENT__MOVES_OVER:
			return movesOver != null && !movesOver.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AgentImpl
