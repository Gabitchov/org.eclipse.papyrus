package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSShapeStyleImpl implements CSSShapeStyle{
	
	private ShapeStyle shapeStyle;

	public CSSShapeStyleImpl(ShapeStyle shapeStyle){
		this.shapeStyle = shapeStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFontColor(){
		return shapeStyle.getFontColor();
	}

	public java.lang.String getCSSFontName(){
		return shapeStyle.getFontName();
	}

	public int getCSSFontHeight(){
		return shapeStyle.getFontHeight();
	}

	public boolean isCSSBold(){
		return shapeStyle.isBold();
	}

	public boolean isCSSItalic(){
		return shapeStyle.isItalic();
	}

	public boolean isCSSUnderline(){
		return shapeStyle.isUnderline();
	}

	public boolean isCSSStrikeThrough(){
		return shapeStyle.isStrikeThrough();
	}

	public java.lang.String getCSSDescription(){
		return shapeStyle.getDescription();
	}

	public int getCSSFillColor(){
		return shapeStyle.getFillColor();
	}

	public int getCSSTransparency(){
		return shapeStyle.getTransparency();
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient(){
		return shapeStyle.getGradient();
	}

	public int getCSSLineColor(){
		return shapeStyle.getLineColor();
	}

	public int getCSSLineWidth(){
		return shapeStyle.getLineWidth();
	}

	public int getCSSRoundedBendpointsRadius(){
		return shapeStyle.getRoundedBendpointsRadius();
	}
}
