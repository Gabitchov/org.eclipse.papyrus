package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.draw2d.IFigure;

/**
 * This is an editPart in which we can get primaryShape to obtain the figure
 * 
 */
public interface IPapyrusEditPart {

	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public IFigure getPrimaryShape();
}
