package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style;


public interface CSSFillStyle {

	public String GRADIENT_VERTICAL = "vertical";

	public String GRADIENT_HORIZONTAL = "horizontal";


	public int getCSSFillColor();


	public int getCSSTransparency();


	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient();

}
