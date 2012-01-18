package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSFilteringStyleImpl implements CSSFilteringStyle{
	
	private FilteringStyle filteringStyle;

	public CSSFilteringStyleImpl(FilteringStyle filteringStyle){
		this.filteringStyle = filteringStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public Filtering getCSSFiltering(){
		return filteringStyle.getFiltering();
	}

	public java.util.List getCSSFilteringKeys(){
		return filteringStyle.getFilteringKeys();
	}
}
