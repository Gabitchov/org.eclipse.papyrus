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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
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

	private boolean shadow = true;

	private boolean displayGradient = true;

	/** the depht of the qualified name **/
	private int depth = 0;

	/**
	 * Added for stereptypes properties
	 */

	private ContainerFigure stereotypePropertiesContent;

	/**
	 * The channel.
	 */
	protected int channel = 28;

	/**
	 * The background color.
	 */
	protected Color backgroundColor = ColorConstants.lightBlue;

	/**
	 * The border color.
	 */
	protected Color borderColor = ColorConstants.black;

	/**
	 * The fore ground color.
	 */
	protected Color foreGroundColor = ColorConstants.black;

	/**
	 * The font color.
	 */
	protected Color fontColor = ColorConstants.black;

	/**
	 * The Line thickness.
	 */
	protected int LineThickness = 1;

	/**
	 * The font size.
	 */
	protected int fontSize = 10;

	/**
	 * The line style.
	 */
	protected String lineStle;

	/**
	 * The font string.
	 */
	protected String fontString = "Arial";

	/**
	 * The font.
	 */
	protected Font font = null;

	/**
	 * The img.
	 */
	protected Image img = null;

	/**
	 * The stereotypes label.
	 */
	protected Label stereotypesLabel;

	/**
	 * The icon label.
	 */
	protected Label iconLabel;

	/**
	 * The name label.
	 */
	protected WrappingLabel nameLabel;

	/**
	 * The qualified label.
	 */
	protected Label qualifiedLabel;

	protected RectangularShadowBorder shadowborder;

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
		shadowborder = new RectangularShadowBorder(2, getForegroundColor());
		setBorder(shadowborder);
	}

	/**
	 * add the stereotypePropertiesContent in the class figure
	 * 
	 */
	public void addStereotypePropertiesContainer(ContainerFigure stereotypePropertiesContent) {
		this.stereotypePropertiesContent = stereotypePropertiesContent;
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
		label.setForegroundColor(ColorConstants.black);
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
		// Add the stereotype label to the figure at pos 0
		this.add(label, getStereotypeLabelPosition());
		this.stereotypesLabel = label;
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
		int position = getStereotypeLabelPosition();
		if (this.stereotypesLabel != null) {
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
	 * to obtain the stereotypePropertiesContent of the class figure
	 * 
	 */
	public ContainerFigure getStereotypePropertiesContent() {
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
		if ((icon != null) && ((presentation.equals(VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION)) || presentation.equals(VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION))) {
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

	/**
	 * Sets the qualified name.
	 * 
	 * @param qualifiedName
	 *            the qualified name
	 */
	public void setQualifiedName(String qualifiedName) {
		if (qualifiedName == null) { // Remove label if any
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
		this.qualifiedLabel.setText("(" + getQualifiedName(qualifiedName, depth) + ")");
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}

	/**
	 * Sets the stereotypes.
	 * 
	 * @param stereotypes
	 *            the stereotypes
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

		// Set the stereotype label
		if (this.stereotypesLabel == null) {
			this.createStereotypeLabel();
		}

		// Set stereotype text on figure
		if (!stereotypes.equals("")) {
			this.stereotypesLabel.setText(Activator.ST_LEFT + stereotypes + Activator.ST_RIGHT);
		} else {
			this.stereotypesLabel.setText("");
		}
	}
}
