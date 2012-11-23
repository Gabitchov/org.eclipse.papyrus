package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * Specific figure for the comaprtment
 */
public class ScalableCompartmentFigure extends ResizableCompartmentFigure {

	/**
	 * Creates a new Compartment figure.
	 * 
	 * @param compartmentTitle
	 *        title of the compartment
	 * @param mm
	 *        the <code>IMapMode</code> that is used to initialize the
	 *        default values of of the scrollpane contained inside the figure. This is
	 *        necessary since the figure is not attached at construction time and consequently
	 *        can't get access to the owned IMapMode in the parent containment hierarchy.
	 */
	public ScalableCompartmentFigure(String compartmentTitle, IMapMode mm) {
		super(compartmentTitle, mm);
	}

}
