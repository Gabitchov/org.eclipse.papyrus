package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSByteArrayValueStyleImpl implements CSSByteArrayValueStyle{
	
	private ByteArrayValueStyle byteArrayValueStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSByteArrayValueStyleImpl(ByteArrayValueStyle byteArrayValueStyle, CSSStylableElement element, CSSEngine engine){
		this.byteArrayValueStyle = byteArrayValueStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		String cssValue = engine.retrieveCSSProperty(element, "name", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getNamedStyle_Name().getDefaultValue(); 
			return (String)defaultValue;
		}
		return cssValue;
	}

	public byte[] getCSSByteArrayValue(){
		String cssValue = engine.retrieveCSSProperty(element, "byteArrayValue", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getByteArrayValueStyle_ByteArrayValue().getDefaultValue(); 
			return (byte[])defaultValue;
		}
		return null;
	}
}
