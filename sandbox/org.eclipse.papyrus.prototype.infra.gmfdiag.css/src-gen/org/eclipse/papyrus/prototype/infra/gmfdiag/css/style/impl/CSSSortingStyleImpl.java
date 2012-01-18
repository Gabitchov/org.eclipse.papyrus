package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSSortingStyleImpl implements CSSSortingStyle{
	
	private SortingStyle sortingStyle;

	public CSSSortingStyleImpl(SortingStyle sortingStyle){
		this.sortingStyle = sortingStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public Sorting getCSSSorting(){
		return sortingStyle.getSorting();
	}

	public java.util.Map getCSSSortingKeys(){
		return sortingStyle.getSortingKeys();
	}
}
