/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier;
import org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reg Exp Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegExpLayerImpl extends AbstractLayerImpl implements RegExpLayer {
	/**
	 * The default value of the '{@link #getExpr() <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected String expr = EXPR_EDEFAULT;
	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * listener on this object container (i.e owner) attached/detached events
	 */
	protected Adapter containerListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			
			switch(msg.getFeatureID(RegExpLayer.class)) {
			  case EcorePackage.EOBJECT___ECONTAINER :
				  switch(msg.getEventType()) {
					case Notification.SET:
						// 
						Object newValue = msg.getNewValue();
						if( newValue == null) {
							deactivate((AbstractLayerOperator)msg.getOldValue());
						}
						else {
							activate((AbstractLayerOperator)msg.getNewValue());
						}
						break;

					case Notification.UNSET:
						deactivate((AbstractLayerOperator)msg.getOldValue());
						break;

					default:
						break;
				  }
				  break;
			};
		};
	};
	
	protected DiagramViewEventNotifier diagramViewEventNotifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RegExpLayerImpl() {
		super();
		// Listen on this object attachment / detachment from its container.
		eAdapters().add(containerListener);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.REG_EXP_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpr() {
		return expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(String newExpr) {
		String oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__EXPR, oldExpr, expr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newLayerParent 
	 * @generated NOT
	 */
	public void activate(AbstractLayerOperator newLayerParent) {

		LayersStack layersStack;
		try {
			layersStack = newLayerParent.getLayersStack();
		} catch (NotFoundException e) {
			// silently fails
			return;
		}
		
		// Listen on view events
		if(diagramViewEventNotifier == null) {
			diagramViewEventNotifier = new DiagramViewEventNotifier(layersStack.getDiagram());
			return;
		}
		
//		diagramViewEventNotifier.
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param oldParentLayer 
	 * @generated NOT
	 */
	public void deactivate(AbstractLayerOperator oldParentLayer) {
		
		if( oldParentLayer == null) {
			return;
		}
		
		LayersStack layersStack;
		try {
			layersStack = oldParentLayer.getLayersStack();
		} catch (NotFoundException e) {
			// silently fails
			return;
		}
		
		layersStack.getDiagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<View> evaluateExpr() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.REG_EXP_LAYER__EXPR:
				return getExpr();
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				return getLanguage();
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
			case LayersPackage.REG_EXP_LAYER__EXPR:
				setExpr((String)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				setLanguage((String)newValue);
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
			case LayersPackage.REG_EXP_LAYER__EXPR:
				setExpr(EXPR_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
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
			case LayersPackage.REG_EXP_LAYER__EXPR:
				return EXPR_EDEFAULT == null ? expr != null : !EXPR_EDEFAULT.equals(expr);
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.REG_EXP_LAYER___ACTIVATE__ABSTRACTLAYEROPERATOR:
				activate((AbstractLayerOperator)arguments.get(0));
				return null;
			case LayersPackage.REG_EXP_LAYER___DEACTIVATE__ABSTRACTLAYEROPERATOR:
				deactivate((AbstractLayerOperator)arguments.get(0));
				return null;
			case LayersPackage.REG_EXP_LAYER___EVALUATE_EXPR:
				return evaluateExpr();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (expr: ");
		result.append(expr);
		result.append(", language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

	/**
	 * Called by the observers when a view is added.
	 * @param view
	 */
	protected void viewAdded( View view) {
		
	}
	
	/**
	 * Called by the observers when a view is removed.
	 * @param view
	 */
	protected void viewRemoved( View view) {
		
	}
	
//	public class ViewEventAdapter extends {
//		
//	}
	
	public class DiagramViewEventListener implements IDiagramViewEventListener {

	@Override
	public void diagramViewAdded(Notification msg) {
		viewAdded((View)msg.getNewValue());
		
	}

	@Override
	public void diagramViewRemoved(Notification msg) {
		viewRemoved((View)msg.getNewValue());
	}
		
	}
} //RegExpLayerImpl
