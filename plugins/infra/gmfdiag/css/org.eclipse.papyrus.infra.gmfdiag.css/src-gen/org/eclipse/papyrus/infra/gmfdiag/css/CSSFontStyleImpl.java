/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.FontStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSFontStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSFontStyleDelegate;

public class CSSFontStyleImpl extends FontStyleImpl implements CSSFontStyle {

	protected ExtendedCSSEngine engine;

	private CSSFontStyle fontStyle;

	protected CSSFontStyle getFontStyle() {
		if(fontStyle == null) {
			fontStyle = new CSSFontStyleDelegate(this, getEngine());
		}
		return fontStyle;
	}

	protected ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = ((CSSDiagramImpl)findView().getDiagram()).getEngine();
		}
		return engine;
	}

	protected View findView() {
		EObject parent = eContainer();
		while(!(parent instanceof View) && parent != null) {
			parent = parent.eContainer();
		}

		if(parent != null) {
			return (View)parent;
		}

		return null;
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////


	public int getCSSFontColor() {
		int value = super.getFontColor();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_FontColor(), value)) {
			return value;
		} else {
			return getFontStyle().getCSSFontColor();
		}
	}

	public java.lang.String getCSSFontName() {
		java.lang.String value = super.getFontName();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_FontName(), value)) {
			return value;
		} else {
			return getFontStyle().getCSSFontName();
		}
	}

	public int getCSSFontHeight() {
		int value = super.getFontHeight();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_FontHeight(), value)) {
			return value;
		} else {
			return getFontStyle().getCSSFontHeight();
		}
	}

	public boolean isCSSBold() {
		boolean value = super.isBold();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_Bold(), value)) {
			return value;
		} else {
			return getFontStyle().isCSSBold();
		}
	}

	public boolean isCSSItalic() {
		boolean value = super.isItalic();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_Italic(), value)) {
			return value;
		} else {
			return getFontStyle().isCSSItalic();
		}
	}

	public boolean isCSSUnderline() {
		boolean value = super.isUnderline();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_Underline(), value)) {
			return value;
		} else {
			return getFontStyle().isCSSUnderline();
		}
	}

	public boolean isCSSStrikeThrough() {
		boolean value = super.isStrikeThrough();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFontStyle_StrikeThrough(), value)) {
			return value;
		} else {
			return getFontStyle().isCSSStrikeThrough();
		}
	}


	@Override
	public int getFontColor() {
		//return super.getFontColor();
		return getCSSFontColor();
	}

	@Override
	public java.lang.String getFontName() {
		//return super.getFontName();
		return getCSSFontName();
	}

	@Override
	public int getFontHeight() {
		//return super.getFontHeight();
		return getCSSFontHeight();
	}

	@Override
	public boolean isBold() {
		//return super.isBold();
		return isCSSBold();
	}

	@Override
	public boolean isItalic() {
		//return super.isItalic();
		return isCSSItalic();
	}

	@Override
	public boolean isUnderline() {
		//return super.isUnderline();
		return isCSSUnderline();
	}

	@Override
	public boolean isStrikeThrough() {
		//return super.isStrikeThrough();
		return isCSSStrikeThrough();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setFontColor(int value) {
		super.setFontColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_FontColor();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setFontName(java.lang.String value) {
		super.setFontName(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_FontName();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setFontHeight(int value) {
		super.setFontHeight(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_FontHeight();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setBold(boolean value) {
		super.setBold(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_Bold();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setItalic(boolean value) {
		super.setItalic(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_Italic();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setUnderline(boolean value) {
		super.setUnderline(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_Underline();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setStrikeThrough(boolean value) {
		super.setStrikeThrough(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_StrikeThrough();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(findView(), feature);
	}


}
