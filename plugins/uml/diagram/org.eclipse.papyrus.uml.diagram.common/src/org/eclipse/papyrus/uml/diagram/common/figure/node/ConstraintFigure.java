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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.swt.graphics.Image;

/**
 * this class is used to display the a constraint with the possibility of
 * gradient qualified name
 * 
 */
public class ConstraintFigure extends CornerBentFigure implements IPapyrusNodeNamedElementFigure, ILabelFigure, IMultilineEditableFigure {

	private static final String CHEVRON = String.valueOf("\u00AB") + String.valueOf("\u00BB");

	protected static final String LEFT_BRACE = "{";

	private Label taggedLabel;

	protected static final String RIGHT_BRACE = "}";

	protected TextFlowEx textFlow;

	private WrappingLabel nameLabel;

	private Label qualifiedLabel;

	/** the depth of the qualified name **/
	private int depth = 0;

	/** main flow page */
	protected FlowPage page;

	/**
	 * Calculate the partial qualified name with a specified depth.
	 * 
	 * @param qualifiedName
	 *        the qualified name can return null
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

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#setQualifiedName(java.lang.String)
	 * 
	 * @param qualifiedName
	 */
	public void setQualifiedName(String qualifiedName) {
		String tmpQualifiedName = getQualifiedName(qualifiedName, depth);
		// two raisons to remove label!
		// null
		// or the qualified name is equal to 1
		if(qualifiedName == null || tmpQualifiedName == null || !tmpQualifiedName.contains("::")) { // Remove
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

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#getQualifiedNameLabel()
	 * 
	 * @return
	 */

	public Label getQualifiedNameLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public ConstraintFigure() {
		this(null);
	}

	public ConstraintFigure(String tagLabel) {
		super();

		nameLabel = new WrappingLabel();

		nameLabel.setOpaque(false);
		nameLabel.setAlignment(PositionConstants.MIDDLE);
		add(nameLabel);
		initTagLabel(tagLabel);
		page = new FlowPage();
		page.setOpaque(false);

		this.add(page);

		textFlow = new TextFlowEx("");
		page.add(textFlow);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#getTaggedLabel()
	 * 
	 * @return
	 */
	public Label getTaggedLabel() {
		return taggedLabel;
	}

	/**
	 * Create the tag label in the figure. The tag label is created if value is
	 * not null.
	 * 
	 * @param value
	 *        the value to use
	 */
	protected void initTagLabel(String value) {
		if(value != null && value.length() > 0) {
			taggedLabel = new Label();
			String textToDisplay = new StringBuffer(CHEVRON).insert(1, value).toString();
			taggedLabel.setText(textToDisplay);
			taggedLabel.setOpaque(false);
			taggedLabel.setForegroundColor(getNameLabel().getForegroundColor());
			taggedLabel.setFont(getNameLabel().getFont());
			this.add(taggedLabel, null, 0);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#setDepth(int)
	 * 
	 * @param depth
	 */
	public void setDepth(int depth) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#getNameLabel()
	 * 
	 * @return
	 */
	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#setNameLabelIcon(boolean)
	 * 
	 * @param displayNameLabelIcon
	 */
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

	/**
	 * use to obtain the reference of this figure (use in order to launch an
	 * edit request)
	 * 
	 * @return the constraintfigure
	 */
	public ConstraintFigure getConstraintFigure() {
		return this;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setText(java.lang.String)
	 * 
	 * @param text
	 */
	public void setText(String text) {
		// generates new ones
		textFlow.setText(LEFT_BRACE + text + RIGHT_BRACE);
	}

	/**
	 * 
	 * @return the textflow of the constraint that contain the string of the
	 *         specification
	 */
	public TextFlowEx getTextFlow() {
		return textFlow;
	}

	/**
	 * 
	 * @return the container of the text flow
	 */
	public FlowPage getPageFlow() {
		return page;

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getText()
	 * 
	 * @return the display string that represents the specification
	 */
	public String getText() {
		return textFlow.getText();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setIcon(org.eclipse.swt.graphics.Image)
	 * 
	 * @param icon
	 */
	public void setIcon(Image icon) {
		//Nothing
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getIcon()
	 * 
	 * @return
	 */
	public Image getIcon() {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 * 
	 * 
	 */
	@Override
	public Dimension getMinimumSize(int wHint, int hHint) {
		return new Dimension(20, 20);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure#getEditionLocation()
	 * 
	 */
	public Point getEditionLocation() {
		return page.getLocation();
	}

	/**
	 * Create a label that contains the name of the element.
	 */
	public void restoreNameLabel() {
		//		nameLabel.setOpaque(false);
		//		nameLabel.setAlignment(PositionConstants.MIDDLE);
		//		getNameLabelContainer().add(nameLabel, getNameLabelConstraint(), getNameLabelPosition());
	}

	public void removeNameLabel() {
		//		if(getNameLabelContainer().getChildren().contains(nameLabel)) {
		//			getNameLabelContainer().remove(nameLabel);
		//		}
	}

	public void removeStereotypeLabel() {
		// TODO Auto-generated method stub
		
	}

	public void restoreStereotypeLabel() {
		// TODO Auto-generated method stub
		
	}

	public void restoreTaggedLabel() {
		// TODO Auto-generated method stub
		
	}

	public void removeTaggedLabel() {
		// TODO Auto-generated method stub
		
	}


}
