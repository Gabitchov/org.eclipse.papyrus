package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSFontStyleImpl implements CSSFontStyle{
	
	private FontStyle fontStyle;

	public CSSFontStyleImpl(FontStyle fontStyle){
		this.fontStyle = fontStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFontColor(){
		return fontStyle.getFontColor();
	}

	public java.lang.String getCSSFontName(){
		return fontStyle.getFontName();
	}

	public int getCSSFontHeight(){
		return fontStyle.getFontHeight();
	}

	public boolean isCSSBold(){
		return fontStyle.isBold();
	}

	public boolean isCSSItalic(){
		return fontStyle.isItalic();
	}

	public boolean isCSSUnderline(){
		return fontStyle.isUnderline();
	}

	public boolean isCSSStrikeThrough(){
		return fontStyle.isStrikeThrough();
	}
}
