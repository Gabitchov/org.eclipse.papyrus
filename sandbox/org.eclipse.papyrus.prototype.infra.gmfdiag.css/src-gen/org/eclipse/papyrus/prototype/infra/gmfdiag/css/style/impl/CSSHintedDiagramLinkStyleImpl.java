package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSHintedDiagramLinkStyleImpl implements CSSHintedDiagramLinkStyle{
	
	private HintedDiagramLinkStyle hintedDiagramLinkStyle;

	public CSSHintedDiagramLinkStyleImpl(HintedDiagramLinkStyle hintedDiagramLinkStyle){
		this.hintedDiagramLinkStyle = hintedDiagramLinkStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSHint(){
		return hintedDiagramLinkStyle.getHint();
	}
}
