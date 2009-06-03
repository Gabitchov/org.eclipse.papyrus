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
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.uml.Element;

/**
 * This class is top graphNode figure. It contains: 1 icone label + 1 stereotype label + 1 qualified nale label + 1 name label
 */
public class NodeNamedElementFigure extends Figure implements IAbstractElementFigure {

	/**
	 * The background color.
	 */
	protected Color backgroundColor = ColorConstants.lightBlue;

	/**
	 * The border color.
	 */
	protected Color borderColor = ColorConstants.black;

	/** the depth of the qualified name **/
	private int depth = 0;

	private boolean displayGradient = true;

	/**
	 * The font.
	 */
	protected Font font = null;

	/**
	 * The font color.
	 */
	protected Color fontColor = ColorConstants.black;

	/**
	 * The font size.
	 */
	protected int fontSize = 10;

	/**
	 * The font string.
	 */
	protected String fontString = "Arial";

	/**
	 * The fore ground color.
	 */
	protected Color foreGroundColor = ColorConstants.black;

	/**
	 * The icon label.
	 */
	protected Label iconLabel;

	/**
	 * The img.
	 */
	protected Image img = null;

	/**
	 * The line style.
	 */
	protected String lineStle;

	/**
	 * The Line thickness.
	 */
	protected int LineThickness = 1;

	/**
	 * The name label.
	 */
	protected WrappingLabel nameLabel;

	private Image nameLabelIcon = null;

	/**
	 * The qualified label.
	 */
	protected Label qualifiedLabel;

	private boolean shadow = true;

	protected RectangularShadowBorder shadowborder;

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
		super();
		FontData[] fontdata = { new FontData(this.fontString, this.fontSize, SWT.NORMAL) };
		this.font = Activator.fontManager.get(fontdata);
		FontData[] fontdata2 = { new FontData("Arial", this.fontSize, SWT.BOLD) };
		Font font2 = Activator.fontManager.get(fontdata2);
		setBackgroundColor(Activator.colorManager.get(new RGB(242, 242, 242)));

		setForegroundColor(Activator.colorManager.get(new RGB(204, 204, 204)));

		// creation of the nameLabel
		this.nameLabel = new WrappingLabel();
		this.nameLabel.setFont(font2);
		this.nameLabel.setOpaque(false);
		this.nameLabel.setAlignment(PositionConstants.MIDDLE);
		this.add(this.nameLabel);
		shadowborder = new RectangularShadowBorder(3, getForegroundColor());
		setBorder(shadowborder);
	}

	/**
	 * Copy context to.
	 * 
	 * @param fig
	 *            the fig
	 */
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
		Label label = new Label("");
		label.setFont(nameLabel.getFont());

		// Add the label to the figure, at pos 0
		this.add(label, getIconLabelPosition());
		this.iconLabel = label;
		this.iconLabel.setLabelAlignment(PositionConstants.RIGHT);
		if (this.img != null) {
			this.iconLabel.setIcon(this.img);
		}
	}

	/**
	 * create the label that contains the qualified name.
	 */
	protected void createQualifiedNameLabel() {
		FontData[] fontdata = { new FontData(this.fontString, this.fontSize, SWT.ITALIC) };
		Font font = Activator.fontManager.get(fontdata);
		Label label = new Label();
		label.setFont(font);
		label.setForegroundColor(getFontColor());
		label.setOpaque(false);
		// Add the label to the figure, after the name
		this.add(label, getQualifiedNameLabelPosition());
		this.qualifiedLabel = label;
	}

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypeLabel() {
		FontData[] fontdata = { new FontData(this.fontString, fontSize, SWT.NORMAL) };
		Font font = Activator.fontManager.get(fontdata);
		Label label = new Label();
		label.setFont(font);
		label.setOpaque(false);
		label.setForegroundColor(getFontColor());
		// Add the stereotype label to the figure at pos 0
		this.add(label, getStereotypeLabelPosition());
		this.stereotypesLabel = label;
	}

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypePropertiesInBraceLabel() {
		final FontData[] fontdata = { new FontData(this.fontString, fontSize, SWT.NORMAL) };
		final Font font = Activator.fontManager.get(fontdata);
		final Label label = new Label();
		label.setFont(font);
		label.setOpaque(false);
		label.setForegroundColor(getFontColor());
		// Add the stereotype label to the figure at pos 0
		this.add(label, getStereotypePropertiesLabelPosition());
		this.stereotypePropertiesInBraceContent = label;
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
		FontData[] fontdata = { new FontData(this.fontString, fontSize, SWT.NORMAL) };
		Font font = Activator.fontManager.get(fontdata);
		stereotypePropertiesContent.getChildren().clear();
		StringTokenizer stringTokenizer = new StringTokenizer(stereotypeProperties, ";");
		while (stringTokenizer.hasMoreElements()) {
			String tokenStereotype = stringTokenizer.nextToken();
			tokenStereotype = tokenStereotype.replace("#", "\n  ");
			tokenStereotype = tokenStereotype.replace("|", "\n  ");
			Label label = new Label(tokenStereotype);
			label.setFont(font);
			label.setLabelAlignment(PositionConstants.LEFT);
			label.setForegroundColor(getFontColor());
			label.setBorder(null);
			stereotypePropertiesContent.add(label);
		}

	}

	/**
	 * Gets the background color.
	 * 
	 * @return the background color
	 */
	@Override
	public Color getBackgroundColor() {
		return this.backgroundColor;
	}

	/**
	 * Gets the border color.
	 * 
	 * @return the border color
	 */
	public Color getBorderColor() {
		return this.borderColor;
	}

	/**
	 * Gets the depth.
	 * 
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	public boolean getDisplayGradient() {
		return displayGradient;
	}

	/**
	 * Getfigure font.
	 * 
	 * @return the figure font
	 */
	public String getfigureFont() {
		return this.fontString;
	}

	/**
	 * Gets the font color.
	 * 
	 * @return the font color
	 */
	public Color getFontColor() {
		return this.fontColor;
	}

	/**
	 * Gets the font size.
	 * 
	 * @return the font size
	 */
	public int getFontSize() {
		return this.fontSize;
	}

	/**
	 * Gets the fore ground color.
	 * 
	 * @return the fore ground color
	 */
	public Color getForeGroundColor() {
		return this.foreGroundColor;
	}

	public Color getGradientColor() {
		return getForegroundColor();
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
	 * 
	 * 
	 * @return
	 */
	protected int getIconLabelPosition() {
		return 0;
	}

	/**
	 * Gets the line stle.
	 * 
	 * @return the line stle
	 */
	public String getLineStle() {
		return this.lineStle;
	}

	/**
	 * Gets the line thickness.
	 * 
	 * @return the line thickness
	 */
	public int getLineThickness() {
		return this.LineThickness;
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

		if (this.getIconLabel() != null)
			nameHeight += this.getIconLabel().getPreferredSize().height;
		if (this.getStereotypesLabel() != null)
			nameHeight += this.getStereotypesLabel().getPreferredSize().height;
		if (this.getQualifiedNameLabel() != null)
			nameHeight += this.getQualifiedNameLabel().getPreferredSize().height;
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

	public Image getNameLabelIcon() {
		return nameLabelIcon;
	}

	/**
	 * 
	 * 
	 * @return
	 */
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
		if (depth <= 0)
			return qualifiedName;

		while (i < depth) {
			if ((n = qualifiedName.indexOf("::", n + 1)) != -1)
				i++;
			else
				return null;
		}

		if (n == -1)
			return qualifiedName;
		else
			return qualifiedName.substring(n + 2);

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
	 * Returns the position of the stereotype properties location. this is just after stereotype position
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

	public boolean isShadow() {
		return shadow;
	}

	/**
	 * return true inf the label in localized at the point pt.
	 * 
	 * @param label
	 *            the label that we look for
	 * @param pt
	 *            the point thaht we test
	 * 
	 * @return true if the point is on the label
	 */
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
	 * Paint figure.
	 * 
	 * @param graphics
	 *            the graphics
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		graphics.setForegroundColor(this.getGradientColor());
		graphics.setBackgroundColor(this.backgroundColor);
		if (getDisplayGradient()) {
			graphics.fillGradient(getBounds(), true);
		} else {
			graphics.fillRectangle(getBounds());
		}
		if (this.img != null) {
			if (this.iconLabel == null) {
				this.createIconLabel();
			}
		} else {
			if (this.iconLabel != null) {
				this.remove(this.iconLabel);
			}
		}
		shadowborder.setColor(getForegroundColor());
	}

	/**
	 * Refresh presentation.
	 * 
	 * @param presentation
	 *            the presentation
	 * @param selection
	 *            the selection
	 */
	public void refreshPresentation(String presentation, Element selection, Image defaultImage) {

		org.eclipse.swt.graphics.Image icon = Activator.getIconElement(selection);

		/* if the presentation is icon or icon with text, we can set the icon */
		if ((icon != null)
				&& ((presentation.equals(VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION)) || presentation.equals(VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION))) {
			this.setIcon(icon);
			if (iconLabel == null) {
				createIconLabel();
			}

			iconLabel.setIcon(icon);
			iconLabel.repaint();
			this.add(iconLabel, 0);
			this.repaint();

		} else {
			// If a default image (ex: Component standard UML Icon) it is shown
			// it is shown in the IconLabel
			// See : ComponentFigure in ClassDiagram for usage example
			if (defaultImage != null) {
				this.setIcon(defaultImage);
				if (iconLabel == null) {
					createIconLabel();
				}
				iconLabel.setIcon(defaultImage);
				iconLabel.repaint();
				this.add(iconLabel, 0);
				this.repaint();

			} else {
				if ((iconLabel != null) && (iconLabel.getParent() != null)) {
					this.remove(iconLabel);
				}
				this.repaint();
			}
		}
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
	 * Sets the background color.
	 * 
	 * @param backgroundColor
	 *            the background color
	 */
	@Override
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		super.setBackgroundColor(backgroundColor);
	}

	/**
	 * Sets the border color.
	 * 
	 * @param borderColor
	 *            the border color
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		super.setBorder(new LineBorder(borderColor));
	}

	/**
	 * Sets the bounds.
	 * 
	 * @param rect
	 *            the rect
	 */
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
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

	public void setDisplayGradient(boolean displayGradient) {
		this.displayGradient = displayGradient;
		repaint();
	}

	/**
	 * Setfigure font.
	 * 
	 * @param font
	 *            the font
	 */
	public void setfigureFont(String font) {

		this.fontString = font;
		FontData[] fontdata = { new FontData(font, this.fontSize, SWT.NORMAL) };
		this.font = Activator.fontManager.get(fontdata);
		super.setFont(this.font);
	}

	/**
	 * Sets the font.
	 * 
	 * @param f
	 *            the f
	 */
	@Override
	public void setFont(Font f) {
		fontSize = f.getFontData()[0].getHeight();
		fontString = f.getFontData()[0].getName();
		int fontStyle = f.getFontData()[0].getStyle();
		this.nameLabel.setFont(Activator.fontManager.get(new FontData[] { new FontData(fontString, fontSize, fontStyle) }));

		if (this.getStereotypesLabel() != null) {
			if (fontSize > 3) {
				this.getStereotypesLabel().setFont(Activator.fontManager.get(new FontData[] { new FontData(fontString, fontSize - 2, SWT.NORMAL) }));
			} else {
				this.getStereotypesLabel().setFont(Activator.fontManager.get(new FontData[] { new FontData(fontString, 2, SWT.NORMAL) }));
			}
		}
		if (this.getQualifiedNameLabel() != null) {
			this.getQualifiedNameLabel().setFont(Activator.fontManager.get(new FontData[] { new FontData(fontString, fontSize, SWT.ITALIC) }));
		}
	}

	/**
	 * Sets the font color.
	 * 
	 * @param fontColor
	 *            the font color
	 */
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * Sets the font size.
	 * 
	 * @param fontSize
	 *            the font size
	 */
	public void setFontSize(int fontSize) {

		FontData[] fontdata = { new FontData(this.fontString, fontSize, SWT.NORMAL) };
		this.font = Activator.fontManager.get(fontdata);
		super.setFont(this.font);
		this.fontSize = fontSize;
	}

	/**
	 * Sets the fore ground color.
	 * 
	 * @param foreGroundColor
	 *            the fore ground color
	 */
	public void setForeGroundColor(Color foreGroundColor) {
		this.foreGroundColor = foreGroundColor;
		super.setForegroundColor(foreGroundColor);

	}

	/**
	 * Sets the icon.
	 * 
	 * @param img
	 *            the img
	 */
	public void setIcon(Image img) {
		this.img = img;
	}

	/**
	 * Sets the line stle.
	 * 
	 * @param lineStle
	 *            the line stle
	 */
	public void setLineStle(String lineStle) {

		this.lineStle = lineStle;
	}

	/**
	 * Sets the line thickness.
	 * 
	 * @param lineThickness
	 *            the line thickness
	 */
	public void setLineThickness(int lineThickness) {
		this.LineThickness = lineThickness;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name
	 */
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
		if (qualifiedName == null || !tmpQualifiedName.contains("::")) { // Remove label if any
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

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
		if (shadow == true) {
			this.setBorder(shadowborder);
		} else {
			this.setBorder(new LineBorder());
		}
	}

	/**
	 * Sets the stereotypes properties for this figure.
	 * <p>
	 * This implementation checks if the specified string is null or not.
	 * <ul>
	 * <li>if the string is <code>null</code>, it removes the label representing the stereotypes properties with brace.</li>
	 * <li>if this is not <code>null</code>, it creates the stereotype properties label if needed and displays the specified string.</li>
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
	 * if the string is <code>null</code>, then the figure that displays the stereotype label is removed from the NodeNamedElementFigure.
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
	 * <li>if this is not <code>null</code>, it creates the stereotype label if needed and displays the specified string.</li>
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
			this.stereotypesLabel.setText(Activator.ST_LEFT + stereotypes + Activator.ST_RIGHT);
		} else {
			this.stereotypesLabel.setText("");
		}
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
