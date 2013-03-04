package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;

/**
 * Represents a classifier.
 */
public class StateFigure extends CompartmentFigure {

	int arcwidth = 20;

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

	public void setSubmachineStateName(String text) {
		submachineStateName = text;
	}

	public void setIsSubmachineState(boolean b) {
		isSubmachineState = b;
	}


	protected void refreshName() {
		if(isSubmachineState) {
			nameLabel.setText(submachineStateName);
		}
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
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if(!shadow) {
			RoundedBorder bord = new RoundedBorder(arcwidth, arcwidth);
			this.setBorder(bord);
		}
	}
}
