/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusWrappingLabel;

/**
 * <pre>
 * This edge figure support stereotype application and name labels,
 * and does not make any assumption on style, decorations, and width.
 * These properties are managed by the edit part.
 * 
 * This figure also provides its own custom dash pattern that can be use calling
 * setLineType(Graphics.LINE_CUSTOM);
 * </pre>
 */
public class NamedElementEdgeFigure extends UMLEdgeFigure {

	private WrappingLabel nameLabel;

	/** Dashes used to paint line. */
	private final int[] dashes = new int[10];

	public NamedElementEdgeFigure() {
		super();

		// set dashes
		for(int i = 0; i < 10; i++) {
			dashes[i] = 5;
		}
		setLineDash(dashes);

		createContents();
	}

	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	/**
	 * @generated
	 */
	@Override
	protected void createContents() {
		super.createContents();
		nameLabel = new PapyrusWrappingLabel();
		nameLabel.setText("");

		this.add(nameLabel);
	}
}
