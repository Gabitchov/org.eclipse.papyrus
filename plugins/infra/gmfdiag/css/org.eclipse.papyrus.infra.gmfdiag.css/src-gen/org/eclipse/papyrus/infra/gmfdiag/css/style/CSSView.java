package org.eclipse.papyrus.infra.gmfdiag.css.style;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.View;


public interface CSSView {

	/**
	 * CSS Implementation of the isVisible() method
	 * 
	 * @return
	 * 
	 * @see View#isVisible()
	 */
	public boolean isCSSVisible();

	/**
	 * CSS Implementation of the getNamedStyle() method
	 * 
	 * @param eClass
	 * @param name
	 * @return
	 * 
	 * @see View#getNamedStyle(EClass, String)
	 */
	public NamedStyle getCSSNamedStyle(EClass eClass, String name);
}
