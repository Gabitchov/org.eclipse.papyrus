package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
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

	protected boolean informationHasChanged = false;

	protected boolean isInformationShown = false;

	protected String submachineStateName = "";

	protected boolean isSubmachineState = false;

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

	public void setSubmachineStateName(String text){
		submachineStateName = text;
	}

	public void setIsSubmachineState(boolean b){
		isSubmachineState = b;
	}


	protected void refreshName(){
		if(isSubmachineState){
			nameLabel.setText(submachineStateName);
		}
	}
	
	@Override
	protected void createNameLabel() {
		// TODO Auto-generated method stub
		super.createNameLabel();

		createInformationLabel();
	}

	public void fillInformation(String text) {
		if(!informationLabel.getText().equals(text)){
			informationLabel.setText(text);
			informationHasChanged = true;
			refreshInformationToShow();
		}
		else
			informationHasChanged = false;
	}

	public WrappingLabel getInformationLabel(){
		return informationLabel;
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

	public boolean hasInformationChanged(){
		return informationHasChanged;
	}

	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if(isUsingGradient()) {
			applyTransparency(graphics);
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			if(isVertical && rectangle.height>((3*arcwidth)/2)){
				Rectangle rect1= new Rectangle(rectangle.getLocation(),new Dimension(rectangle.width,arcwidth));
				Rectangle rect2= new Rectangle(rectangle.x,rectangle.y+rectangle.height-arcwidth,rectangle.width,arcwidth);;
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillRoundRectangle(rect1,arcwidth,arcwidth);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.fillRoundRectangle(rect2,arcwidth,arcwidth);


				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				Rectangle rect= new Rectangle(rectangle.x,rectangle.y+arcwidth/2,rectangle.width,rectangle.height-arcwidth);
				graphics.fillGradient(rect, true);
			}
			else if(!isVertical && rectangle.width>((3*arcwidth)/2)){
				Rectangle rect1= new Rectangle(rectangle.getLocation(),new Dimension(arcwidth,rectangle.height));
				Rectangle rect2= new Rectangle(rectangle.x+rectangle.width-arcwidth,rectangle.y,arcwidth,rectangle.height);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillRoundRectangle(rect1,arcwidth,arcwidth);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.fillRoundRectangle(rect2,arcwidth,arcwidth);


				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				Rectangle rect= new Rectangle(rectangle.x+arcwidth/2, rectangle.y,rectangle.width-arcwidth,rectangle.height);
				graphics.fillGradient(rect, false);
			}
			else{
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillRoundRectangle(rectangle,arcwidth,arcwidth);
			}
		}
		else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillRoundRectangle(rectangle,arcwidth,arcwidth);
		}
	}

	@Override
	public void paintFigure(Graphics graphics) {
		paintBackground(graphics, getBounds());

		refreshInformationToShow();
		
		refreshName();

		if(isInformationShown) {
			Rectangle rect = informationLabel.getBounds();
			Rectangle rect2 = nameLabel.getBounds();

			graphics.setForegroundColor(getBorderColor());
			graphics.setLineStyle(SWT.BORDER_SOLID);
			graphics.setLineWidth(SWT.BOLD);

			graphics.drawLine(rect.x-2, rect.y, rect.x + rect.width - 1, rect.y);

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
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if(!shadow) {
			RoundedBorder bord = new RoundedBorder(arcwidth, arcwidth);
			this.setBorder(bord);
		}
	}
}
