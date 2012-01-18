package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSByteArrayValueStyleImpl implements CSSByteArrayValueStyle{
	
	private ByteArrayValueStyle byteArrayValueStyle;

	public CSSByteArrayValueStyleImpl(ByteArrayValueStyle byteArrayValueStyle){
		this.byteArrayValueStyle = byteArrayValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return byteArrayValueStyle.getName();
	}

	public byte[] getCSSByteArrayValue(){
		return byteArrayValueStyle.getByteArrayValue();
	}
}
