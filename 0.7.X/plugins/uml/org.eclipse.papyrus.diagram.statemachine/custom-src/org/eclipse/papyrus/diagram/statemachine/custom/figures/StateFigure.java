package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.diagram.common.figure.node.CompartmentFigure;
import org.eclipse.swt.SWT;

/**
 * Represents a classifier.
 */
public class StateFigure extends CompartmentFigure {

	int arcwidth = 20;

	/**
	 * The information label.
	 */
	protected WrappingLabel informationLabel;

	protected boolean isInformationShown = false;
	/** The State Compartment */
	private final static String STATE_COMPARTMENT = "stateCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(STATE_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor
	 */
	public StateFigure() {
		this(null);
	}

	/**
	 * Create a new StateMachine figure with the given tag
	 * 
	 * @param tagLabel
	 *        a String that will be displayed at the top of the figure
	 */
	public StateFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
		shadowborder = new RoundedShadowBorder(getForegroundColor());
		setBorder(shadowborder);
		((AutomaticCompartmentLayoutManager)getLayoutManager()).setAddExtraHeight(false);
	}

	@Override
	protected void createNameLabel() {
		// TODO Auto-generated method stub
		super.createNameLabel();
		
		createInformationLabel();
	}
	
	/**
	 * Create a label that contains the name of the element.
	 */
	protected void createInformationLabel() {
		informationLabel = new WrappingLabel();

		informationLabel.setOpaque(false);
		informationLabel.setAlignment(PositionConstants.MIDDLE);
		informationLabel.setVisible(false);
		informationLabel.setTextWrap(true);
		getInformationLabelContainer().add(informationLabel, getInformationLabelConstraint(), -1);
	}

	public void fillInformation(String text) {
		informationLabel.setText(text);
		refreshInformationToShow();
	}

	/**
	 * Get the constraint for adding the information label.
	 * Children should override and implement this method in case the label must be drawn with a specific constraint.
	 * 
	 * @return figure containing the name label
	 * @see #getInformationLabelContainer()
	 * @see #getDefaultLabelsConstraint()
	 */
	protected Object getInformationLabelConstraint() {
		return getDefaultLabelsConstraint();
	}

	/**
	 * Get the container for the information label.
	 * Children should override and implement this method in case the label must not be drawn in the overall figure. The returned figure shall be
	 * created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return figure containing the name label
	 * @see #getDefaultLabelsContainer()
	 */
	protected IFigure getInformationLabelContainer() {
		return getDefaultLabelsContainer();
	}

	/**
	 * Get the state compartment figure
	 * 
	 * @return
	 */
	public RectangleFigure getStateCompartmentFigure() {
		return getCompartment(STATE_COMPARTMENT);
	}

	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		Rectangle r = rectangle;

		if(isUsingGradient()) {
			applyTransparency(graphics);
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
			graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
			Rectangle tmp = new Rectangle(r.x + arcwidth / 2, r.y, r.width - arcwidth + 1, r.height);
			graphics.fillGradient(tmp, isVertical);
			tmp = new Rectangle(r.x, r.y + arcwidth / 2, r.width, r.height - arcwidth + 1);
			graphics.fillGradient(tmp, isVertical);
			if(isVertical) {
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.fillArc(r.x + r.width - arcwidth, r.y + r.height - arcwidth, arcwidth, arcwidth, 270, 90);
				graphics.fillArc(r.x, r.y + r.height - arcwidth, arcwidth, arcwidth, 180, 90);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillArc(r.x + r.width - arcwidth, r.y, arcwidth, arcwidth, 0, 90);
				graphics.fillArc(r.x, r.y, arcwidth, arcwidth, 90, 90);
			} else {
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.fillArc(r.x + r.width - arcwidth, r.y + r.height - arcwidth, arcwidth, arcwidth, 270, 90);
				graphics.fillArc(r.x + r.width - arcwidth, r.y, arcwidth, arcwidth, 0, 90);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillArc(r.x, r.y, arcwidth, arcwidth, 90, 90);
				graphics.fillArc(r.x, r.y + r.height - arcwidth, arcwidth, arcwidth, 180, 90);
			}
		} else {

			if(isShadow())
				r = r.getCopy().shrink(1, 1).translate(-1, -1);

			graphics.fillArc(r.x, r.y, arcwidth, arcwidth, 90, 90);
			graphics.fillArc(r.x + r.width - arcwidth, r.y, arcwidth, arcwidth, 0, 90);
			graphics.fillArc(r.x + r.width - arcwidth, r.y + r.height - arcwidth, arcwidth, arcwidth, 270, 90);
			graphics.fillArc(r.x, r.y + r.height - arcwidth, arcwidth, arcwidth, 180, 90);

			graphics.fillRectangle(r.x + arcwidth / 2, r.y, r.width - arcwidth + 1, r.height);
			graphics.fillRectangle(r.x, r.y + arcwidth / 2, r.width, r.height - arcwidth + 1);

		}
	}

	/**
	 * Refreshes the status of the label that displays information, depending on the text to display
	 */
	protected void refreshInformationToShow() {
		String text = informationLabel.getText();
		if(text == null || text.length() == 0 || text.equalsIgnoreCase("\n")) {
			informationLabel.setVisible(false);
			isInformationShown = false;
		} else {
			informationLabel.setVisible(true);
			isInformationShown = true;
		}
	}


	@Override
	public void paintFigure(Graphics graphics) {
		paintBackground(graphics, getBounds());

		shadowborder.setColor(getForegroundColor());
		refreshInformationToShow();

		if(isInformationShown) {
			Rectangle rect = informationLabel.getBounds();

			graphics.setLineStyle(SWT.BORDER_SOLID);
			graphics.setLineWidth(SWT.BOLD);

			graphics.drawLine(rect.x, rect.y, rect.x + rect.width - 1, rect.y);

		}
	}

	@Override
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if(!shadow) {
			RoundedBorder bord = new RoundedBorder(arcwidth, arcwidth);
			this.setBorder(bord);
		}
	}
}
