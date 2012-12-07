/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Arthur Daussy - arthur.daussy@atos.net - 395920: [Block Diagram Definition] All element contained by a block should be able to be linked to constraint or comment
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;

/**
 * Create a papyrus wrapping label that can be targeted by a connection.
 * 
 * @author arthur daussy
 * 
 */
public class PapyrusAnchorableWrappingLabel extends PapyrusWrappingLabel implements IAnchorableFigure {


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createDefaultAnchor()
	 */
	protected ConnectionAnchor createDefaultAnchor() {
		return new SlidableAnchor(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#szAnchor()
	 */
	static public final String szAnchor = ""; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getConnectionAnchor()
	 */
	public ConnectionAnchor getConnectionAnchor(String terminal) {

		ConnectionAnchor connectAnchor = (ConnectionAnchor)getConnectionAnchors().get(terminal);
		if(connectAnchor == null) {
			if(terminal.equals(szAnchor)) {
				// get a new one - this figure doesn't support static anchors
				connectAnchor = createDefaultAnchor();
				getConnectionAnchors().put(terminal, connectAnchor);
			} else {
				connectAnchor = createAnchor(SlidableAnchor.parseTerminalString(terminal));
			}
		}

		return connectAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createAnchor()
	 */
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		if(p == null)
			// If the old terminal for the connection anchor cannot be resolved (by SlidableAnchor) a null
			// PrecisionPoint will passed in - this is handled here
			return createDefaultAnchor();
		return new SlidableAnchor(this, p);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getConnectionAnchors()
	 */
	protected Hashtable getConnectionAnchors() {
		if(connectionAnchors == null)
			connectionAnchors = new Hashtable(1);
		return connectionAnchors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#connectionAnchors()
	 */
	private Hashtable connectionAnchors;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getConnectionAnchorTerminal()
	 */
	public String getConnectionAnchorTerminal(ConnectionAnchor c) {
		if(c instanceof SlidableAnchor) {
			return ((SlidableAnchor)c).getTerminal();
		}
		if(getConnectionAnchors().containsValue(c)) {
			Iterator iter = getConnectionAnchors().keySet().iterator();
			String key;
			while(iter.hasNext()) {
				key = (String)iter.next();
				if(getConnectionAnchors().get(key).equals(c))
					return key;
			}
		}
		getConnectionAnchor(szAnchor);
		return szAnchor;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getSourceConnectionAnchorAt()
	 */
	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		return createConnectionAnchor(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getTargetConnectionAnchorAt()
	 */
	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		return createConnectionAnchor(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createConnectionAnchor()
	 */
	protected ConnectionAnchor createConnectionAnchor(Point p) {
		if(p == null) {
			return getConnectionAnchor(szAnchor);
		} else {
			Point temp = p.getCopy();
			translateToRelative(temp);
			PrecisionPoint pt = BaseSlidableAnchor.getAnchorRelativeLocation(temp, getBounds());
			if(isDefaultAnchorArea(pt))
				return getConnectionAnchor(szAnchor);
			return createAnchor(pt);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea()
	 */
	protected boolean isDefaultAnchorArea(PrecisionPoint p) {
		return p.preciseX >= getSlidableAnchorArea() / 2 && p.preciseX <= 1 - getSlidableAnchorArea() / 2 && p.preciseY >= getSlidableAnchorArea() / 2 && p.preciseY <= 1 - getSlidableAnchorArea() / 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure#getConnectionAnchor(java.lang.String)
	 * Copied from @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getSlidableAnchorArea()
	 */
	protected double getSlidableAnchorArea() {
		return 0.5;
	}

}