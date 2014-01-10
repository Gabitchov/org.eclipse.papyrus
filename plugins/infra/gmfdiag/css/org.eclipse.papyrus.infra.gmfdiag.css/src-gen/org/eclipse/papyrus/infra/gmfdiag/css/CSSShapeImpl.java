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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CSSCustomStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CustomStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSShapeStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSShapeStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate;

public class CSSShapeImpl extends ShapeImpl implements CSSShapeStyle, CustomStyle, CSSView {

	protected ExtendedCSSEngine engine;

	private CSSShapeStyle shapeStyle;

	private CSSView cssView;

	private CustomStyle customStyle;

	protected CSSShapeStyle getShapeStyle() {
		if(shapeStyle == null) {
			shapeStyle = new CSSShapeStyleDelegate(this, getEngine());
		}
		return shapeStyle;
	}

	protected CustomStyle getCustomStyle() {
		if(customStyle == null) {
			customStyle = new CSSCustomStyleDelegate(this, getEngine());
		}
		return customStyle;
	}

	protected CSSView getCSSView() {
		if(cssView == null) {
			cssView = new CSSViewDelegate(this, getEngine());
		}
		return cssView;
	}

	protected ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = ((CSSDiagramImpl)getDiagram()).getEngine();
		}
		return engine;
	}

	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////


	public int getCSSFontColor() {
		int value = super.getFontColor();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_FontColor(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSFontColor();
		}
	}

	public java.lang.String getCSSFontName() {
		java.lang.String value = super.getFontName();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_FontName(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSFontName();
		}
	}

	public int getCSSFontHeight() {
		int value = super.getFontHeight();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_FontHeight(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSFontHeight();
		}
	}

	public boolean isCSSBold() {
		boolean value = super.isBold();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_Bold(), value)) {
			return value;
		} else {
			return getShapeStyle().isCSSBold();
		}
	}

	public boolean isCSSItalic() {
		boolean value = super.isItalic();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_Italic(), value)) {
			return value;
		} else {
			return getShapeStyle().isCSSItalic();
		}
	}

	public boolean isCSSUnderline() {
		boolean value = super.isUnderline();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_Underline(), value)) {
			return value;
		} else {
			return getShapeStyle().isCSSUnderline();
		}
	}

	public boolean isCSSStrikeThrough() {
		boolean value = super.isStrikeThrough();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFontStyle_StrikeThrough(), value)) {
			return value;
		} else {
			return getShapeStyle().isCSSStrikeThrough();
		}
	}

	public boolean isCSSVisible() {
		boolean value = super.isVisible();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getView_Visible(), value)) {
			return value;
		} else {
			return getCSSView().isCSSVisible();
		}
	}

	public java.lang.String getCSSDescription() {
		java.lang.String value = super.getDescription();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getDescriptionStyle_Description(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSDescription();
		}
	}

	public int getCSSFillColor() {
		int value = super.getFillColor();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFillStyle_FillColor(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSFillColor();
		}
	}

	public int getCSSTransparency() {
		int value = super.getTransparency();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFillStyle_Transparency(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSTransparency();
		}
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		org.eclipse.gmf.runtime.notation.datatype.GradientData value = super.getGradient();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getFillStyle_Gradient(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSGradient();
		}
	}

	public int getCSSLineColor() {
		int value = super.getLineColor();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getLineStyle_LineColor(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSLineColor();
		}
	}

	public int getCSSLineWidth() {
		int value = super.getLineWidth();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getLineStyle_LineWidth(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSLineWidth();
		}
	}

	public int getCSSRoundedBendpointsRadius() {
		int value = super.getRoundedBendpointsRadius();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius(), value)) {
			return value;
		} else {
			return getShapeStyle().getCSSRoundedBendpointsRadius();
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

	@Override
	public java.lang.String getDescription() {
		//return super.getDescription();
		return getCSSDescription();
	}

	@Override
	public int getFillColor() {
		//return super.getFillColor();
		return getCSSFillColor();
	}

	@Override
	public int getTransparency() {
		//return super.getTransparency();
		return getCSSTransparency();
	}

	@Override
	public org.eclipse.gmf.runtime.notation.datatype.GradientData getGradient() {
		//return super.getGradient();
		return getCSSGradient();
	}

	@Override
	public int getLineColor() {
		//return super.getLineColor();
		return getCSSLineColor();
	}

	@Override
	public int getLineWidth() {
		//return super.getLineWidth();
		return getCSSLineWidth();
	}

	@Override
	public int getRoundedBendpointsRadius() {
		//return super.getRoundedBendpointsRadius();
		return getCSSRoundedBendpointsRadius();
	}

	@Override
	public boolean isVisible() {
		//return super.isVisible();
		return isCSSVisible();
	}

	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////

	@Override
	public void setVisible(boolean value) {
		super.setVisible(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Visible();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setType(java.lang.String value) {
		super.setType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Type();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setMutable(boolean value) {
		super.setMutable(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Mutable();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setFontColor(int value) {
		super.setFontColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_FontColor();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setFontName(java.lang.String value) {
		super.setFontName(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_FontName();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setFontHeight(int value) {
		super.setFontHeight(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_FontHeight();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setBold(boolean value) {
		super.setBold(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_Bold();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setItalic(boolean value) {
		super.setItalic(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_Italic();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setUnderline(boolean value) {
		super.setUnderline(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_Underline();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setStrikeThrough(boolean value) {
		super.setStrikeThrough(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFontStyle_StrikeThrough();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setDescription(java.lang.String value) {
		super.setDescription(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getDescriptionStyle_Description();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setFillColor(int value) {
		super.setFillColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFillStyle_FillColor();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setTransparency(int value) {
		super.setTransparency(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFillStyle_Transparency();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setGradient(org.eclipse.gmf.runtime.notation.datatype.GradientData value) {
		super.setGradient(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFillStyle_Gradient();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setLineColor(int value) {
		super.setLineColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineColor();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setLineWidth(int value) {
		super.setLineWidth(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineWidth();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setRoundedBendpointsRadius(int value) {
		super.setRoundedBendpointsRadius(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius();
		ForceValueHelper.setValue(this, feature, value);
	}

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		if(feature != null) {
			ForceValueHelper.unsetValue(this, feature);
		}
	}

	///////////////////////////////////
	//	Implements the custom styles //
	///////////////////////////////////

	public boolean showElementIcon() {
		return getCustomStyle().showElementIcon();
	}

	public int getQualifiedNameDepth() {
		return getCustomStyle().getQualifiedNameDepth();
	}

	public boolean showShadow() {
		return getCustomStyle().showShadow();
	}

	public int getLabelDisplay() {
		return getCustomStyle().getLabelDisplay();
	}

	//////////////////////////////////
	//	Implements the getNamedStyle //
	//////////////////////////////////

	@Override
	public NamedStyle getNamedStyle(EClass eClass, String name) {
		return getCSSNamedStyle(eClass, name);
	}

	public NamedStyle getCSSNamedStyle(EClass eClass, String name) {
		NamedStyle userStyle = super.getNamedStyle(eClass, name);
		if(userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSNamedStyle(eClass, name);
	}

}
