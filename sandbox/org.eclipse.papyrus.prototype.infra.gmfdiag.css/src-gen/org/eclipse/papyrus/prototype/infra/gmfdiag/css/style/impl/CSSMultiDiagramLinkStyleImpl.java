package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSMultiDiagramLinkStyleImpl implements CSSMultiDiagramLinkStyle{
	
	private MultiDiagramLinkStyle multiDiagramLinkStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSMultiDiagramLinkStyleImpl(MultiDiagramLinkStyle multiDiagramLinkStyle, CSSStylableElement element, CSSEngine engine){
		this.multiDiagramLinkStyle = multiDiagramLinkStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

}
