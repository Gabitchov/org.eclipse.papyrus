/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * this class is used to display the a constraint with the possibility of gradient qualified name
 *
 */
public class ConstraintFigure extends CornerBentFigure implements IPapyrusNodeNamedElementFigure{

	private WrappingLabel nameLabel;
	private Label qualifiedLabel;
	/** the depth of the qualified name **/
	private int depth = 0;
	
	/**
	 * Calculate the partial qualified name with a specified depth.
	 * 
	 * @param qualifiedName
	 *        the qualified name
	 *        can return null
	 */
	public String getQualifiedName(String qualifiedName, int depth) {
		int n = -1;

		int i = 0;
		if(depth <= 0) {
			return qualifiedName;
		}

		while(i < depth) {
			if((n = qualifiedName.indexOf("::", n + 1)) != -1) {
				i++;
			} else {
				return null;
			}
		}

		if(n == -1) {
			return qualifiedName;
		} else {
			return qualifiedName.substring(n + 2);
		}

	}

	public void setQualifiedName(String qualifiedName) {
		String tmpQualifiedName = getQualifiedName(qualifiedName, depth);
		// two raisons to remove label!
		// null
		// or the qualified name is equal to 1
		if(qualifiedName == null ||tmpQualifiedName==null|| !tmpQualifiedName.contains("::")) { // Remove
			// label
			// if
			// any
			if(this.qualifiedLabel != null) {
				this.remove(this.qualifiedLabel);
				this.qualifiedLabel = null;
			}
			return;
		}

		// Set the stereotype label
		if(this.qualifiedLabel == null) {
			this.createQualifiedNameLabel();
		}
		// we have to not display name.

		int i = tmpQualifiedName.lastIndexOf("::");
		if(i != -1) {
			tmpQualifiedName = tmpQualifiedName.substring(0, i);
		}
		this.qualifiedLabel.setText("(" + tmpQualifiedName.trim() + ")");

	}

	
	
	public Label getQualifiedNameLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public ConstraintFigure() {
		super();
		nameLabel = new WrappingLabel();

		nameLabel.setOpaque(false);
		nameLabel.setAlignment(PositionConstants.MIDDLE);
		add(nameLabel);

	}

	public Label getTaggedLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDepth(int depth) {
		// TODO Auto-generated method stub
		
	}

	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabelIcon(boolean displayNameLabelIcon) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * create the label that contains the qualified name.
	 */
	protected void createQualifiedNameLabel() {
		qualifiedLabel = new Label();
		qualifiedLabel.setOpaque(false);
		qualifiedLabel.setFont(getNameLabel().getFont());
		qualifiedLabel.setForegroundColor(getNameLabel().getForegroundColor());
		// Add the label to the figure, after the name
		this.add(qualifiedLabel, getQualifiedNameLabelPosition());
	}

	protected int getQualifiedNameLabelPosition() {
		int position = getStereotypePropertiesLabelPosition();
		if(stereotypePropertiesInBraceContent != null) {
			position++;
		}
		return position;
	}

}
