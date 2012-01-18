package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style;

import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public interface CSSFillStyle {
	
	public int getCSSFillColor();


	public int getCSSTransparency();


	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient();

}
