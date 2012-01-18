package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSDiagramStyleImpl implements CSSDiagramStyle{
	
	private DiagramStyle diagramStyle;

	public CSSDiagramStyleImpl(DiagramStyle diagramStyle){
		this.diagramStyle = diagramStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSPageX(){
		return diagramStyle.getPageX();
	}

	public int getCSSPageY(){
		return diagramStyle.getPageY();
	}

	public int getCSSPageWidth(){
		return diagramStyle.getPageWidth();
	}

	public int getCSSPageHeight(){
		return diagramStyle.getPageHeight();
	}

	public java.lang.String getCSSDescription(){
		return diagramStyle.getDescription();
	}
}
