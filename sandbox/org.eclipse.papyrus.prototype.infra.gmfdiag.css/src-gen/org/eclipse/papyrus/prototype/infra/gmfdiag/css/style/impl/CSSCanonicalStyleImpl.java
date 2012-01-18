package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSCanonicalStyleImpl implements CSSCanonicalStyle{
	
	private CanonicalStyle canonicalStyle;

	public CSSCanonicalStyleImpl(CanonicalStyle canonicalStyle){
		this.canonicalStyle = canonicalStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSCanonical(){
		return canonicalStyle.isCanonical();
	}
}
