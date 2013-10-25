/*****************************************************************************
< * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Atos Origin - Enable extending with a composite figure, by adding overrideable methods.
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.figure.layout.PropertiesCompartmentLayoutManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * This class is top graphNode figure. It contains: 1 icon label + 1 stereotype
 * label + 1 qualified name label + 1 name label
 */
public class NodeNamedElementFigure extends PapyrusNodeFigure implements IPapyrusNodeNamedElementFigure, IPapyrusNodeUMLElementFigure {

	protected boolean noBorder = false;

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

	protected Image nameLabelIcon = null;

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
	protected Label stereotypePropertiesInBraceContent;

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

	@Override
	public void setBorder(Border border) {
		if(border == null) {
			noBorder = true;
		} else {
			noBorder = false;
		}
		super.setBorder(border);
	}

	@Override
	protected Border getDefaultBorder(Color borderColor) {
		if(noBorder) {
			return null;
		} else {
			return super.getDefaultBorder(borderColor);
		}
	}

	@Override
	public void remove(IFigure figure) {
		if(figure instanceof AppliedStereotypeCompartmentFigure) {
			if(stereotypePropertiesContent == null) {
				this.createStereotypePropertiesContent();
			}
			stereotypePropertiesContent.remove(figure);
		} else {

			super.remove(figure);
		}

	}

	@Override
	public void add(IFigure figure, Object constraint, int index) {
		if(figure instanceof AppliedStereotypeCompartmentFigure) {
			if(stereotypePropertiesContent == null) {
				this.createStereotypePropertiesContent();
			}
			stereotypePropertiesContent.add(figure);
		} else {

			super.add(figure, constraint, index);
		}
	}


	public void setStereotypeDisplay(String stereotypes, Image image) {

		// Set stereotype text on figure
		if(!"".equals(stereotypes)) {
			setStereotypes(stereotypes);
		} else {
			setStereotypes(null);
		}

		setAppliedStereotypeIcon(image);
	}

	public NodeNamedElementFigure(String taggedLabelValue) {
		super();

		// creation of the nameLabel
		createNameLabel();

		initTagLabel(taggedLabelValue);
	}

	/**
	 * Create a label that contains the name of the element.
	 */
	protected void createNameLabel() {
		nameLabel = new WrappingLabel();

		nameLabel.setOpaque(false);
		nameLabel.setAlignment(PositionConstants.MIDDLE);
		getNameLabelContainer().add(nameLabel, getNameLabelConstraint(), -1);
	}

	public void restoreNameLabel() {
		nameLabel.setOpaque(false);
		nameLabel.setAlignment(PositionConstants.MIDDLE);
		getNameLabelContainer().add(nameLabel, getNameLabelConstraint(), getNameLabelPosition());
	}


	/**
	 * Create a label that contains the name of the element.
	 */
	public void removeNameLabel() {
		if(getNameLabelContainer().getChildren().contains(nameLabel)) {
			getNameLabelContainer().remove(nameLabel);
		}
	}

	/**
	 * Get the constraint for adding the name label. Children should override
	 * and implement this method in case the label must be drawn with a specific
	 * constraint.
	 * 
	 * @return figure containing the name label
	 * @see #getNameLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getNameLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the constraint for adding the icon label. Children should override
	 * and implement this method in case the label must be drawn with a specific
	 * constraint.
	 * 
	 * @return figure containing the icon label
	 * @see #getIconLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getIconLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the constraint for adding the qualified name label. Children should
	 * override and implement this method in case the label must be drawn with a
	 * specific constraint.
	 * 
	 * @return figure containing the qualified name label
	 * @see #getQualifiedNameLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getQualifiedNameLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the constraint for adding the stereotype label. Children should
	 * override and implement this method in case the label must be drawn with a
	 * specific constraint.
	 * 
	 * @return figure containing the qualified name label
	 * @see #getStereotypeLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getStereotypeLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the constraint for adding the stereotype properties in brace label.
	 * Children should override and implement this method in case the label must
	 * be drawn with a specific constraint.
	 * 
	 * @return figure containing the stereotype properties in brace label
	 * @see #getStereotypePropertiesInBraceLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getStereotypePropertiesInBraceLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the constraint for adding the stereotype properties compartment.
	 * Children should override and implement this method in case the label must
	 * be drawn with a specific constraint.
	 * 
	 * @return figure containing the stereotype properties compartment
	 * @see #getStereotypePropertiesCompartmentContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getStereotypePropertiesCompartmentConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the constraint for adding the tag label. Children should override and
	 * implement this method in case the label must be drawn with a specific
	 * constraint.
	 * 
	 * @return figure containing the qualified name label
	 * @see #getTagLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getTagLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the default constraint for all labels. Children should override and
	 * implement this method in case the label must be drawn with a specific
	 * constraint.
	 * 
	 * @return constraint for all labels by default
	 * @see #getDefaultLabelsContainer()
	 */
	protected Object getDefaultLabelsConstraint() {
		return null;
	}

	/**
	 * Get the container for the name label. Children should override and
	 * implement this method in case the label must not be drawn in the overall
	 * figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the name label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getNameLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the container for the icon label. Children should override and
	 * implement this method in case the label must not be drawn in the overall
	 * figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the icon label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getIconLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the container for the qualified name label. Children should override
	 * and implement this method in case the label must not be drawn in the
	 * overall figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the qualified name label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getQualifiedNameLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the container for the stereotype label. Children should override and
	 * implement this method in case the label must not be drawn in the overall
	 * figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the qualified name label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getStereotypeLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the container for the stereotype properties in brace label. Children
	 * should override and implement this method in case the label must not be
	 * drawn in the overall figure. The returned figure shall be created in the
	 * method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the stereotype properties in brace label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getStereotypePropertiesInBraceLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the container for the stereotype properties compartment. Children
	 * should override and implement this method in case the compartment must
	 * not be drawn in the overall figure. The returned figure shall be created
	 * in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the stereotype properties compartment
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getStereotypePropertiesCompartmentContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the container for the tag label. Children should override and
	 * implement this method in case the label must not be drawn in the overall
	 * figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the qualified name label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getTagLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the default container for all labels. Children should override and
	 * implement this method in case the label must not be drawn in the overall
	 * figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing labels by default
	 */
	protected IFigure getDefaultLabelsContainer() {
		return this;
	}

	/**
	 * Copy context to.
	 * 
	 * @param fig
	 *        the fig
	 */
	// @unused
	public void copyContextTo(IFigure fig) {
		Iterator it = this.getListeners(FigureListener.class);
		while(it.hasNext()) {
			fig.addFigureListener((FigureListener)it.next());
		}

	}

	/**
	 * used to create a label that contains the icon.
	 */
	protected void createIconLabel() {
		iconLabel = new LabelWithScalableIcons();
		// Add the label to the figure, at pos 0
		getIconLabelContainer().add(iconLabel, getIconLabelConstraint(), getIconLabelPosition());
		iconLabel.setLabelAlignment(PositionConstants.LEFT);
	}

	/**
	 * Creates the icon label.
	 * 
	 * @param position
	 *        the position
	 */
	protected void createIconLabel(int position) {
		iconLabel = new LabelWithScalableIcons();
		getIconLabelContainer().add(iconLabel, getIconLabelConstraint(), getIconLabelPosition());
		iconLabel.setLabelAlignment(position);
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
		getQualifiedNameLabelContainer().add(qualifiedLabel, getQualifiedNameLabelConstraint(), getQualifiedNameLabelPosition());
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
		getStereotypeLabelContainer().add(stereotypesLabel, getStereotypeLabelConstraint(), getStereotypeLabelPosition());
	}

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypePropertiesInBraceLabel() {
		stereotypePropertiesInBraceContent = new Label();
		stereotypePropertiesInBraceContent.setOpaque(false);
		// Add the stereotype label to the figure at pos 0
		getStereotypePropertiesInBraceLabelContainer().add(stereotypePropertiesInBraceContent, getStereotypePropertiesInBraceLabelConstraint(), getStereotypePropertiesLabelPosition());
	}

	protected void createStereotypePropertiesContent() {
		stereotypePropertiesContent = new StereotypePropertiesCompartment();
		stereotypePropertiesContent.setFill(false);
		stereotypePropertiesContent.setLineWidth(0);
		stereotypePropertiesContent.setBorder(null);
		stereotypePropertiesContent.setLayoutManager(getPropertiesCompartmentLayout());
		getStereotypePropertiesCompartmentContainer().add(stereotypePropertiesContent, getStereotypePropertiesCompartmentConstraint(), getStereotypePropertiesCompartmentPosition());
	}

	/**
	 * Get layout to display content of properties compartment. Children may
	 * override this method.
	 * 
	 * @return the layout
	 */
	protected LayoutManager getPropertiesCompartmentLayout() {
		return new PropertiesCompartmentLayoutManager();
	}

	private void fillStereotypePropertiesInCompartment(String stereotypeProperties) {

		stereotypePropertiesContent.getChildren().clear();
		StringTokenizer stringTokenizer = new StringTokenizer(stereotypeProperties, ";");
		while(stringTokenizer.hasMoreElements()) {
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
			getTagLabelContainer().add(taggedLabel, getTagLabelConstraint(), 0);
		}
	}

	public Dimension getMinimumDimension() {
		int width = 0;
		int height = 0;
		int temporysize = 0;
		if(getNameLabelContainer().getChildren().contains(getNameLabel())) {
			width = getNameLabel().getTextBounds().width + 10;
			height = getNameLabel().getTextBounds().height + 10;
		}
		if(getStereotypesLabel() != null) {
			temporysize = getStereotypesLabel().getTextBounds().width + 10;
			height = height + getStereotypesLabel().getTextBounds().height;
			if(width < temporysize) {
				width = temporysize;
			}
		}
		if(getQualifiedNameLabel() != null) {
			temporysize = getQualifiedNameLabel().getTextBounds().width + 10;
			height = height + getQualifiedNameLabel().getTextBounds().height;
			if(width < temporysize) {
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

		if(this.getIconLabel() != null && getIconLabelContainer().equals(getNameLabelContainer())) {
			nameHeight += this.getIconLabel().getPreferredSize().height;
		}
		if(this.getStereotypesLabel() != null && getStereotypeLabelContainer().equals(getNameLabelContainer())) {
			nameHeight += this.getStereotypesLabel().getPreferredSize().height;
		}
		if(this.getQualifiedNameLabel() != null && getQualifiedNameLabelContainer().equals(getNameLabelContainer())) {
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
	 * Calculate the partial qualified name with a specified depth.
	 * 
	 * @param qualifiedName
	 *        the qualified name can return null
	 */
	public String getQualifiedName(String qualifiedName, int depth) {
		int n = -1;
		if(qualifiedName == null) {
			return null;
		}
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
	 * return the label that contains the qualified name.
	 * 
	 * @return the label that contains the qualified name
	 */
	public Label getQualifiedNameLabel() {
		return this.qualifiedLabel;
	}

	/**
	 * @return the position of the icon label
	 */
	protected int getIconLabelPosition() {
		return 0;
	}

	/**
	 * @return the position of the stereotype label
	 */
	protected int getStereotypeLabelPosition() {
		int position = 0;
		if(getStereotypeLabelContainer().equals(getIconLabelContainer())) {
			// located after icon label
			position = getIconLabelPosition();
			if((this.iconLabel != null) && (this.iconLabel.getIcon() != null)) {
				position++;
			}
		}
		return position;

	}



	/**
	 * Returns the position of the stereotype properties location. this is just
	 * after stereotype position
	 * 
	 * @return the position of the stereotype properties in brace label
	 */
	protected int getStereotypePropertiesLabelPosition() {
		int position = 0;
		if(getStereotypePropertiesInBraceLabelContainer().equals(getStereotypeLabelContainer())) {
			// located after stereotype label
			position = getStereotypeLabelPosition();
			if(this.stereotypesLabel != null) {
				position++;
			}
		} else if(getStereotypePropertiesInBraceLabelContainer().equals(getIconLabelContainer())) {
			// located after icon label
			position = getIconLabelPosition();
			if((this.iconLabel != null) && (this.iconLabel.getIcon() != null)) {
				position++;
			}
		}
		return position;
	}

	/**
	 * @return the position of the qualified name label
	 */
	protected int getQualifiedNameLabelPosition() {
		int position = 0;
		if(getQualifiedNameLabelContainer().equals(getStereotypePropertiesInBraceLabelContainer())) {
			// located after stereotype properties in brace label
			position = getStereotypePropertiesLabelPosition();
			if(this.stereotypePropertiesInBraceContent != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getStereotypeLabelContainer())) {
			// located after stereotype label
			position = getStereotypeLabelPosition();
			if(this.stereotypesLabel != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getIconLabelContainer())) {
			// located after icon label
			position = getIconLabelPosition();
			if((this.iconLabel != null) && (this.iconLabel.getIcon() != null)) {
				position++;
			}
		}
		return position;
	}

	/**
	 * @return the position of the name label
	 */
	// @unused
	protected int getNameLabelPosition() {
		int position = 0;
		if(getNameLabelContainer().equals(getQualifiedNameLabelContainer())) {
			// located after qualifed name label
			position = getQualifiedNameLabelPosition();
			if(this.qualifiedLabel != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getStereotypePropertiesInBraceLabelContainer())) {
			// located after stereotype properties in brace label
			position = getStereotypePropertiesLabelPosition();
			if(this.stereotypePropertiesInBraceContent != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getStereotypeLabelContainer())) {
			// located after stereotype label
			position = getStereotypeLabelPosition();
			if(this.stereotypesLabel != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getIconLabelContainer())) {
			// located after icon label
			position = getIconLabelPosition();
			if((this.iconLabel != null) && (this.iconLabel.getIcon() != null)) {
				position++;
			}
		}
		return position;
	}

	/**
	 * @return the position of the stereotype properties compartment
	 */
	protected int getStereotypePropertiesCompartmentPosition() {
		int position = 0;
		if(getStereotypePropertiesCompartmentContainer().equals(getNameLabelContainer())) {
			// locate after name label (which is never removed)
			position = getNameLabelContainer().getChildren().indexOf(nameLabel);
			position++;
		} else if(getNameLabelContainer().equals(getQualifiedNameLabelContainer())) {
			// located after qualifed name label
			position = getQualifiedNameLabelPosition();
			if(this.qualifiedLabel != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getStereotypePropertiesInBraceLabelContainer())) {
			// located after stereotype properties in brace label
			position = getStereotypePropertiesLabelPosition();
			if(this.stereotypePropertiesInBraceContent != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getStereotypeLabelContainer())) {
			// located after stereotype label
			position = getStereotypeLabelPosition();
			if(this.stereotypesLabel != null) {
				position++;
			}
		} else if(getQualifiedNameLabelContainer().equals(getIconLabelContainer())) {
			// located after icon label
			position = getIconLabelPosition();
			if((this.iconLabel != null) && (this.iconLabel.getIcon() != null)) {
				position++;
			}
		}
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
	 *        the label that we look for
	 * @param pt
	 *        the point that we test
	 * 
	 * @return true if the point is on the label
	 */
	// @unused
	protected boolean labelContainsPoint(Label label, Point pt) {
		Rectangle rc;

		rc = new PrecisionRectangle(label.getBounds());
		label.translateToAbsolute(rc);
		if(rc.contains(pt)) {
			return true;
		}
		return false;
	}

	/**
	 * Refresh stereotypes.
	 * 
	 * @param presentation
	 *        the presentation
	 * @param hasIcon
	 *        the has icon
	 * @param hasShape
	 *        the has shape
	 * @param stereotypes
	 *        the stereotypes
	 */
	public void refreshStereotypes(String stereotypes, String presentation, boolean hasIcon, boolean hasShape) {

		if(stereotypes.equals("")) {
			this.setStereotypes(null);
			return;
		}

		if(presentation.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) && hasIcon) {
			this.setStereotypes(null);
			return;
		} else if(presentation.equals(UMLVisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION) && hasShape) {
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
	 *        the new depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *        the name
	 */
	// @unused
	public void setName(String name) {
		this.nameLabel.setText(name);
	}

	public void setNameLabelIcon(boolean displayNameLabelIcon) {
		if(getNameLabel().getIcon() != null) {
			nameLabelIcon = getNameLabel().getIcon();
		}
		if(displayNameLabelIcon) {
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
	 *        the qualified name
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
				getQualifiedNameLabelContainer().remove(this.qualifiedLabel);
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
	 *        the string representing the stereotype properties to be
	 *        displayed
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if(stereotypeProperties == null) {
			// Remove label if any
			if(this.stereotypePropertiesInBraceContent != null) {
				getStereotypePropertiesInBraceLabelContainer().remove(this.stereotypePropertiesInBraceContent);
				this.stereotypePropertiesInBraceContent = null;
			}
			return;
		}

		// Set the stereotype label if it does not already exist
		if(this.stereotypePropertiesInBraceContent == null) {
			this.createStereotypePropertiesInBraceLabel();
		}

		// Set stereotype text on figure
		if(!"".equals(stereotypeProperties)) {
			this.stereotypePropertiesInBraceContent.setText("{" + stereotypeProperties + "}");
		} else {
			this.stereotypePropertiesInBraceContent.setText("");
		}
	}

	/**
	 * displays the new string corresponding to the list of stereotypes.
	 * 
	 * if the string is <code>null</code>, then the figure that displays the
	 * stereotype label is removed from the NodeNamedElementFigure.
	 * 
	 * @param stereotypeProperties
	 *        the string to be displayed.
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		if(stereotypeProperties == null || stereotypeProperties.trim() == "") {
			// remove figure of stereotype properties compartment
			if(this.stereotypePropertiesContent != null) {
				getStereotypePropertiesCompartmentContainer().remove(this.stereotypePropertiesContent);
				this.stereotypePropertiesContent = null;
			}
			return;
		}

		// set stereotype properties content
		if(stereotypePropertiesContent == null) {
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
	 *        the string representing the stereotypes to be displayed
	 */
	public void setStereotypes(String stereotypes) {
		if(stereotypes == null) {
			// Remove label if any
			if(this.stereotypesLabel != null) {
				getStereotypeLabelContainer().remove(this.stereotypesLabel);
				this.stereotypesLabel = null;
			}
			return;
		}

		// Set the stereotype label if it does not already exist
		if(this.stereotypesLabel == null) {
			this.createStereotypeLabel();
		}

		// Set stereotype text on figure
		if(!"".equals(stereotypes)) {
			this.stereotypesLabel.setText(stereotypes);
		} else {
			this.stereotypesLabel.setText("");
		}
	}

	/**
	 * Sets the stereotype icon for this figure.
	 * 
	 * @param stereotypes
	 *        the image representing the stereotype
	 */
	public void setAppliedStereotypeIcon(Image image) {
		if(image == null) {
			// Remove label if any
			if(this.iconLabel != null) {
				getIconLabelContainer().remove(this.iconLabel);
				this.iconLabel = null;
			}
			return;
		}

		// Set the stereotype label if it does not already exist
		if(this.iconLabel == null) {
			this.createIconLabel();
		}

		// Set stereotype icon on figure
		this.iconLabel.setIcon(image);
	}

	/**
	 * Sets the applied stereotype icon.
	 * 
	 * @param image
	 *        the image
	 * @param position
	 *        the position
	 */
	public void setAppliedStereotypeIcon(Image image, int position) {
		if(image == null) {
			// Remove label if any
			if(this.iconLabel != null) {
				getIconLabelContainer().remove(this.iconLabel);
				this.iconLabel = null;
			}
			return;
		}

		// Set the stereotype label with position parameter if it does not
		// already exist
		if(this.iconLabel == null) {
			this.createIconLabel(position);
		}

		// Set stereotype icon on figure
		this.iconLabel.setIcon(image);
	}

}
