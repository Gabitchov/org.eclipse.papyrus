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
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.FontInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.FontPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Property Setter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FontPropertySetterImpl extends PropertySetterImpl implements FontPropertySetter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected FontPropertySetterImpl() {
		super();
		setPropertyName("font");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.FONT_PROPERTY_SETTER;
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
	
		// Try to get the FontStyle object to modify
		FontStyle style;
		if(view instanceof FontStyle) {
			// Try directly (case of Shape ...)
			style = (FontStyle)view;
		} 
		else {
			// Try as additionnal style
			style = (FontStyle)view.getStyle(NotationPackage.eINSTANCE.getFontStyle() );
		}
		
		// Set values
		if( style != null ) {
			FontInstance lineValue = (FontInstance)value;

			style.setFontColor(lineValue.getFontColor());
			style.setFontName(lineValue.getFontName());
			style.setFontHeight(lineValue.getFontHeigh());
			style.setBold(lineValue.isBold());
		}
		
	}

} //FontPropertySetterImpl
