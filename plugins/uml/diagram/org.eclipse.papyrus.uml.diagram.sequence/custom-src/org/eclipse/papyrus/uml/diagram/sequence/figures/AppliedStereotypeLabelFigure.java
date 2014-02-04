/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.swt.graphics.Image;


/**
 * This figure use to display stereotype and properties in brace.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AppliedStereotypeLabelFigure extends Figure implements ILabelFigure, IPapyrusNodeUMLElementFigure {


	private Label stereotypeLabel;

	private WrappingLabel stereotypePropertiesInBraceContent;

	/**
	 * Constructor.
	 * 
	 */
	public AppliedStereotypeLabelFigure() {
		createContents();
	}

	/**
	 * create contents.
	 */
	protected void createContents() {
		ToolbarLayout layout = new ToolbarLayout(false);
		layout.setStretchMinorAxis(true);
		this.setLayoutManager(layout);
		this.setBorder(new MarginBorder(3));
		stereotypeLabel = new Label();
		stereotypeLabel.setLabelAlignment(PositionConstants.CENTER);

		this.add(stereotypeLabel);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
	 *      org.eclipse.swt.graphics.Image)
	 * 
	 * @param stereotypes
	 * @param image
	 */

	public void setStereotypeDisplay(String stereotypes, Image image) {
		stereotypeLabel.setText(stereotypes);
		stereotypeLabel.setIcon(image);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInBrace(java.lang.String)
	 * 
	 * @param stereotypeProperties
	 */

	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if(stereotypeProperties == null || stereotypeProperties.trim().equals("")) {
			if(stereotypePropertiesInBraceContent != null) {
				remove(stereotypePropertiesInBraceContent);
			}
			stereotypePropertiesInBraceContent = null;
		} else {
			if(stereotypePropertiesInBraceContent == null) {
				stereotypePropertiesInBraceContent = new WrappingLabel();
				stereotypePropertiesInBraceContent.setOpaque(false);
				this.add(stereotypePropertiesInBraceContent);
			}
			stereotypePropertiesInBraceContent.setText("{" + stereotypeProperties + "}");
		}

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInCompartment(java.lang.String)
	 * 
	 * @param stereotypeProperties
	 */

	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#getStereotypesLabel()
	 * 
	 * @return
	 */

	public Label getStereotypesLabel() {
		return stereotypeLabel;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setText(java.lang.String)
	 * 
	 * @param text
	 */

	public void setText(String text) {
		stereotypeLabel.setText(text);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getText()
	 * 
	 * @return
	 */

	public String getText() {
		return stereotypeLabel.getText();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setIcon(org.eclipse.swt.graphics.Image)
	 * 
	 * @param icon
	 */

	public void setIcon(Image icon) {
		stereotypeLabel.setIcon(icon);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getIcon()
	 * 
	 * @return
	 */

	public Image getIcon() {
		return stereotypeLabel.getIcon();
	}

}
