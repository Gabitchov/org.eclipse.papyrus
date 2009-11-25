/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.swt.graphics.Image;

/**
 * This class is top graphNode figure. It contains: 1 icone label + 1 stereotype label + 1 qualified
 * nale label + 1 name label
 */
public class NodeNamedElementFigure extends PapyrusNodeFigure implements IPapyrusNodeNamedElementFigure, IPapyrusNodeUMLElementFigure {

	private static final String CHEVRON = String.valueOf("\u00AB") + String.valueOf("\u00BB");

	private Label taggedLabel;

	/** the depth of the qualified name **/
	private int depth = 0;

	/**
	 * The icon label.
	 */
	protected Label iconLabel;

	/**
	 * The name label.
	 */
	protected WrappingLabel nameLabel;

	private Image nameLabelIcon = null;

	/**
	 * The qualified label.
	 */
	protected Label qualifiedLabel;

	/**
	 * Added for stereptypes properties
	 */
	private RectangleFigure stereotypePropertiesContent;

	/**
	 * Added for stereotypes properties, displayed in the InBrace location
	 */
	private Label stereotypePropertiesInBraceContent;

	/**
	 * The stereotypes label.
	 */
	protected Label stereotypesLabel;

	/**
	 * Create a basic figure.
	 */
	public NodeNamedElementFigure() {
		this(null);
	}

	public void setStereotypeDisplay(String stereotypes, Image image) {

		// Set stereotype text on figure
		if (!"".equals(stereotypes)) {
			setStereotypes(stereotypes);
		} else {
			setStereotypes(null);
		}

		setAppliedStereotypeIcon(image);
	}
	public NodeNamedElementFigure(String taggedLabelValue) {
		super();

		// creation of the nameLabel
		nameLabel = new WrappingLabel();

		nameLabel.setOpaque(false);
		nameLabel.setAlignment(PositionConstants.MIDDLE);
		add(nameLabel);

		initTagLabel(taggedLabelValue);
	}

	/**
	 * Copy context to.
	 * 
	 * @param fig
	 *            the fig
	 */
	// @unused
	public void copyContextTo(IFigure fig) {
		Iterator it = this.getListeners(FigureListener.class);
		while (it.hasNext()) {
			fig.addFigureListener((FigureListener) it.next());
		}

	}

	/**
	 * used to create a label that contains the icon.
	 */
	protected void createIconLabel() {
		iconLabel = new Label();
		// Add the label to the figure, at pos 0
		add(iconLabel, getIconLabelPosition());
		iconLabel.setLabelAlignment(PositionConstants.LEFT);
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

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypeLabel() {
		stereotypesLabel = new Label();
		stereotypesLabel.setOpaque(false);
		stereotypesLabel.setFont(getNameLabel().getFont());
		stereotypesLabel.setForegroundColor(getNameLabel().getForegroundColor());
		// Add the stereotype label to the figure at pos 0
		this.add(stereotypesLabel, getStereotypeLabelPosition());
	}

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypePropertiesInBraceLabel() {
		stereotypePropertiesInBraceContent = new Label();
		stereotypePropertiesInBraceContent.setOpaque(false);
		// Add the stereotype label to the figure at pos 0
		this.add(stereotypePropertiesInBraceContent, getStereotypePropertiesLabelPosition());

	}

	protected void createStereotypePropertiesContent() {
		stereotypePropertiesContent = new StereotypePropertiesCompartment();
		stereotypePropertiesContent.setFill(false);
		stereotypePropertiesContent.setLineWidth(0);
		stereotypePropertiesContent.setBorder(null);
		stereotypePropertiesContent.setLayoutManager(new PropertiesCompatmentLayoutManager());
		this.add(stereotypePropertiesContent, getStereotypePropertiesCompartmentPosition());
	}

	private void fillStereotypePropertiesInCompartment(String stereotypeProperties) {

		stereotypePropertiesContent.getChildren().clear();
		StringTokenizer stringTokenizer = new StringTokenizer(stereotypeProperties, ";");
		while (stringTokenizer.hasMoreElements()) {
			String tokenStereotype = stringTokenizer.nextToken();
			tokenStereotype = tokenStereotype.replace("#", "\n  ");
			tokenStereotype = tokenStereotype.replace("|", "\n  ");
			Label label = new Label(tokenStereotype);
			label.setLabelAlignment(PositionConstants.LEFT);
			label.setBorder(null);
			stereotypePropertiesContent.add(label);
		}

	}

	/**
	 * Get the label containing the tagged value
	 * 
	 * @return
	 */
	public Label getTaggedLabel() {
		return taggedLabel;
	}

	/**
	 * Gets the depth.
	 * 
	 * @return the depth
	 */
	// @unused
	public int getDepth() {
		return depth;
	}

	/**
	 * return the label thath contains the icon.
	 * 
	 * @return the label that contains the icon
	 */
	public Label getIconLabel() {
		return this.iconLabel;
	}

	/**
	 * Create the tag label in the figure. The tag label is created if value is not null.
	 * 
	 * @param value
	 *            the value to use
	 */
	protected void initTagLabel(String value) {
		if (value != null && value.length() > 0) {
			taggedLabel = new Label();
			String textToDisplay = new StringBuffer(CHEVRON).insert(1, value).toString();
			taggedLabel.setText(textToDisplay);
			taggedLabel.setOpaque(false);
			taggedLabel.setForegroundColor(getNameLabel().getForegroundColor());
			taggedLabel.setFont(getNameLabel().getFont());
			add(taggedLabel, 0);
		}
	}

	/**
	 * 
	 * 
	 * @return
	 */
	protected int getIconLabelPosition() {
		return 0;
	}

	public Dimension getMinimumDimension() {
		int width = getNameLabel().getTextBounds().width + 10;
		int height = getNameLabel().getTextBounds().height + 10;
		int temporysize = 0;
		if (getStereotypesLabel() != null) {
			temporysize = getStereotypesLabel().getTextBounds().width + 10;
			height = height + getStereotypesLabel().getTextBounds().height;
			if (width < temporysize) {
				width = temporysize;
			}
		}
		if (getQualifiedNameLabel() != null) {
			temporysize = getQualifiedNameLabel().getTextBounds().width + 10;
			height = height + getQualifiedNameLabel().getTextBounds().height;
			if (width < temporysize) {
				width = temporysize;
			}
		}
		return new Dimension(width, height);
	}

	/**
	 * Helper method to calculate the height of name
	 */
	protected int getNameHeight() {
		int nameHeight = this.getNameLabel().getPreferredSize().height;

		if (this.getIconLabel() != null) {
			nameHeight += this.getIconLabel().getPreferredSize().height;
		}
		if (this.getStereotypesLabel() != null) {
			nameHeight += this.getStereotypesLabel().getPreferredSize().height;
		}
		if (this.getQualifiedNameLabel() != null) {
			nameHeight += this.getQualifiedNameLabel().getPreferredSize().height;
		}
		nameHeight += 5;

		return nameHeight;

	}

	/**
	 * Gets the name label.
	 * 
	 * @return the name label
	 */
	public WrappingLabel getNameLabel() {
		return this.nameLabel;
	}

	// @unused
	public Image getNameLabelIcon() {
		return nameLabelIcon;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	// @unused
	protected int getNameLabelPosition() {
		int position = getQualifiedNameLabelPosition();
		if (this.qualifiedLabel != null) {
			position++;
		}
		return position;
	}

	/**
	 * Calculate the partial qualified name with a specified depth.
	 * 
	 * @param qualifiedName
	 *            the qualified name
	 */
	public String getQualifiedName(String qualifiedName, int depth) {
		int n = -1;

		int i = 0;
		if (depth <= 0) {
			return qualifiedName;
		}

		while (i < depth) {
			if ((n = qualifiedName.indexOf("::", n + 1)) != -1) {
				i++;
			} else {
				return null;
			}
		}

		if (n == -1) {
			return qualifiedName;
		} else {
			return qualifiedName.substring(n + 2);
		}

	}

	/**
	 * return the label that contains the qualified name.
	 * 
	 * @return the label that contains the qualified name
	 */
	public Label getQualifiedNameLabel() {
		return this.qualifiedLabel;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	protected int getQualifiedNameLabelPosition() {
		int position = getStereotypePropertiesLabelPosition();
		if (this.stereotypePropertiesInBraceContent != null) {
			position++;
		}
		return position;
	}

	/**
	 * 
	 * 
	 * @return the position of the stereotype label in the figure
	 */
	protected int getStereotypeLabelPosition() {
		int position = getIconLabelPosition();
		if ((this.iconLabel != null) && (this.iconLabel.getIcon() != null)) {
			position++;
		}
		return position;
	}

	/**
	 * Returns the position of the stereotype properties location. this is just after stereotype
	 * position
	 * 
	 * @return the position of the stereotype properties label in the figure
	 */
	protected int getStereotypePropertiesLabelPosition() {
		int position = getStereotypeLabelPosition();
		if (this.stereotypesLabel != null) {
			position++;
		}
		return position;
	}

	protected int getStereotypePropertiesCompartmentPosition() {
		int position = getChildren().indexOf(nameLabel);
		position++;
		return position;
	}

	/**
	 * to obtain the stereotypePropertiesContent of the class figure
	 * 
	 */
	public RectangleFigure getStereotypePropertiesContent() {
		return this.stereotypePropertiesContent;
	}

	/**
	 * Gets the stereotypes label.
	 * 
	 * @return the stereotypes label
	 */
	public Label getStereotypesLabel() {
		return this.stereotypesLabel;
	}

	/**
	 * return true inf the label in localized at the point pt.
	 * 
	 * @param label
	 *            the label that we look for
	 * @param pt
	 *            the point that we test
	 * 
	 * @return true if the point is on the label
	 */
	// @unused
	protected boolean labelContainsPoint(Label label, Point pt) {
		Rectangle rc;

		rc = new PrecisionRectangle(label.getBounds());
		label.translateToAbsolute(rc);
		if (rc.contains(pt)) {
			return true;
		}
		return false;
	}

	/**
	 * Refresh stereotypes.
	 * 
	 * @param presentation
	 *            the presentation
	 * @param hasIcon
	 *            the has icon
	 * @param hasShape
	 *            the has shape
	 * @param stereotypes
	 *            the stereotypes
	 */
	public void refreshStereotypes(String stereotypes, String presentation, boolean hasIcon, boolean hasShape) {

		if (stereotypes.equals("")) {
			this.setStereotypes(null);
			return;
		}

		if (presentation.equals(VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) && hasIcon) {
			this.setStereotypes(null);
			return;
		} else if (presentation.equals(VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION) && hasShape) {
			this.setStereotypes(null);
			return;
		}

		this.setStereotypes(stereotypes);// add stereotypes on the class figure
		return;
	}

	/**
	 * Sets the depth.
	 * 
	 * @param depth
	 *            the new depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name
	 */
	// @unused
	public void setName(String name) {
		this.nameLabel.setText(name);
	}

	public void setNameLabelIcon(boolean displayNameLabelIcon) {
		if (getNameLabel().getIcon() != null) {
			nameLabelIcon = getNameLabel().getIcon();
		}
		if (displayNameLabelIcon) {
			getNameLabel().setIcon(nameLabelIcon);
		} else {
			getNameLabel().setIcon(null);
		}
	}

	// @unused
	public void setNameLabelIcon(Image nameLabelIcon) {
		this.nameLabelIcon = nameLabelIcon;
	}

	/**
	 * Sets the qualified name.
	 * 
	 * @param qualifiedName
	 *            the qualified name
	 */
	public void setQualifiedName(String qualifiedName) {
		String tmpQualifiedName = getQualifiedName(qualifiedName, depth);

		// two raisons to remove label!
		// null
		// or the qualified name is equal to 1
		if (qualifiedName == null || !tmpQualifiedName.contains("::")) { // Remove
			// label
			// if
			// any
			if (this.qualifiedLabel != null) {
				this.remove(this.qualifiedLabel);
				this.qualifiedLabel = null;
			}
			return;
		}

		// Set the stereotype label
		if (this.qualifiedLabel == null) {
			this.createQualifiedNameLabel();
		}
		// we have to not display name.

		int i = tmpQualifiedName.lastIndexOf("::");
		if (i != -1) {
			tmpQualifiedName = tmpQualifiedName.substring(0, i);
		}
		this.qualifiedLabel.setText("(" + tmpQualifiedName.trim() + ")");

	}

	/**
	 * Sets the stereotypes properties for this figure.
	 * <p>
	 * This implementation checks if the specified string is null or not.
	 * <ul>
	 * <li>if the string is <code>null</code>, it removes the label representing the stereotypes
	 * properties with brace.</li>
	 * <li>if this is not <code>null</code>, it creates the stereotype properties label if needed
	 * and displays the specified string.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param stereotypeProperties
	 *            the string representing the stereotype properties to be displayed
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if (stereotypeProperties == null) {
			// Remove label if any
			if (this.stereotypePropertiesInBraceContent != null) {
				this.remove(this.stereotypePropertiesInBraceContent);
				this.stereotypePropertiesInBraceContent = null;
			}
			return;
		}

		// Set the stereotype label if it does not already exist
		if (this.stereotypePropertiesInBraceContent == null) {
			this.createStereotypePropertiesInBraceLabel();
		}

		// Set stereotype text on figure
		if (!"".equals(stereotypeProperties)) {
			this.stereotypePropertiesInBraceContent.setText("{" + stereotypeProperties + "}");
		} else {
			this.stereotypePropertiesInBraceContent.setText("");
		}
	}

	/**
	 * displays the new string corresponding to the list of stereotypes.
	 * 
	 * if the string is <code>null</code>, then the figure that displays the stereotype label is
	 * removed from the NodeNamedElementFigure.
	 * 
	 * @param stereotypeProperties
	 *            the string to be displayed.
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		if (stereotypeProperties == null) {
			// remove figure of stereotype properties compartment
			if (this.stereotypePropertiesContent != null) {
				this.remove(this.stereotypePropertiesContent);
				this.stereotypePropertiesContent = null;
			}
			return;
		}

		// set stereotype properties content
		if (stereotypePropertiesContent == null) {
			this.createStereotypePropertiesContent();
		}

		fillStereotypePropertiesInCompartment(stereotypeProperties);
	}

	/**
	 * Sets the stereotypes for this figure.
	 * <p>
	 * This implementation checks if the specified string is null or not.
	 * <ul>
	 * <li>if the string is <code>null</code>, it removes the label representing the stereotypes.</li>
	 * <li>if this is not <code>null</code>, it creates the stereotype label if needed and displays
	 * the specified string.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param stereotypes
	 *            the string representing the stereotypes to be displayed
	 */
	public void setStereotypes(String stereotypes) {
		if (stereotypes == null) {
			// Remove label if any
			if (this.stereotypesLabel != null) {
				this.remove(this.stereotypesLabel);
				this.stereotypesLabel = null;
			}
			return;
		}

		// Set the stereotype label if it does not already exist
		if (this.stereotypesLabel == null) {
			this.createStereotypeLabel();
		}

		// Set stereotype text on figure
		if (!"".equals(stereotypes)) {
			this.stereotypesLabel.setText( stereotypes);
		} else {
			this.stereotypesLabel.setText("");
		}
	}

	/**
	 * Sets the stereotype icon for this figure.
	 * 
	 * @param stereotypes
	 *            the image representing the stereotype
	 */
	public void setAppliedStereotypeIcon(Image image) {
		if (image == null) {
			// Remove label if any
			if (this.iconLabel != null) {
				this.remove(this.iconLabel);
				this.iconLabel = null;
			}
			return;
		}

		// Set the stereotype label if it does not already exist
		if (this.iconLabel == null) {
			this.createIconLabel();
		}

		// Set stereotype icon on figure
		this.iconLabel.setIcon(image);
	}

	private class PropertiesCompatmentLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

			int minimumWith = 0;
			int minimumHeight = 0;
			// display name
			for (int i = 0; i < container.getChildren().size(); i++) {
				minimumHeight = minimumHeight + ((IFigure) container.getChildren().get(i)).getPreferredSize().height;
			}

			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			List childrenList = container.getChildren();
			for (int i = 0; i < container.getChildren().size(); i++) {
				Rectangle bound = new Rectangle(((IFigure) childrenList.get(i)).getBounds());
				bound.setSize(((IFigure) childrenList.get(i)).getPreferredSize());
				if (i > 0) {
					bound.y = ((IFigure) childrenList.get(i - 1)).getBounds().getBottomLeft().y - 1;
					bound.x = getBounds().x;
					bound.width = container.getBounds().width;

				} else {
					bound.x = container.getBounds().x;
					bound.y = container.getBounds().y;
					bound.width = container.getBounds().width;

				}
				((IFigure) childrenList.get(i)).setBounds(bound);
			}

		}

	}
}
