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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.BooleanInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.IsVisiblePropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Is Visible Property Setter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IsVisiblePropertySetterImpl extends PropertySetterImpl implements IsVisiblePropertySetter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected IsVisiblePropertySetterImpl() {
		super();
		setPropertyName("isVisible");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.IS_VISIBLE_PROPERTY_SETTER;
	}

	/**
	 * Set the property of the specified view.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterImpl#setValue(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance)
	 *
	 * @param view
	 * @param value
	 */
	@Override
	public void setValue(View view, TypeInstance value) {
	
	
		BooleanInstance boolValue = (BooleanInstance)value;
		
		if(view instanceof Shape || view instanceof Connector) {
			// We restrict to Shape and Connector
			view.setVisible(boolValue.isValue());
		}
		
	}

} //IsVisiblePropertySetterImpl
