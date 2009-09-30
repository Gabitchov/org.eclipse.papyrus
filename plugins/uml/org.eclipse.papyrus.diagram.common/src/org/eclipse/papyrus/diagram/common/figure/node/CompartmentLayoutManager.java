package org.eclipse.papyrus.diagram.common.figure.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * this is the layout manager in charge to place element in compartment element
 * 
 */

public class CompartmentLayoutManager extends AbstractLayout {

	protected static final int MINIMUM_COMPARTMENT_HEIGHT = 15;
	//list of compartments
	protected ArrayList<IFigure> compartmentList= new ArrayList<IFigure>();  
	//list of none compartments ex wrapping label etc...
	protected ArrayList<IFigure> notCompartmentList= new ArrayList<IFigure>();  
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

		int minimumWith = 0;
		int minimumHeight = 0;
		if(container instanceof CompartmentFigure){
			// display name
			if (((CompartmentFigure)container).getNameLabel() != null) {
				if (((CompartmentFigure)container).getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = ((CompartmentFigure)container).getNameLabel().getPreferredSize().width;
				}
				minimumHeight += ((CompartmentFigure)container).getNameLabel().getPreferredSize().height;
			}
		}
		return new Dimension(minimumWith, minimumHeight);
	}

	/**
	 * layout by putting label in the center of figure
	 * @param container
	 */
	protected void layoutCenterForLabel(IFigure container){
		int labelheight=0;
		for (int i = 0; i < notCompartmentList.size(); i++) {
			labelheight+=notCompartmentList.get(i).getPreferredSize().height;
		}

		for (int i = 0; i < container.getChildren().size(); i++) {
			if( notCompartmentList.contains(((IFigure) container.getChildren().get(i)))){
				Rectangle bound = new Rectangle(((IFigure) container.getChildren().get(i)).getBounds());
				bound.setSize(getPreferedSize(((IFigure) container.getChildren().get(i))));
				if (i > 0) {
					bound.y = ((IFigure) container.getChildren().get(i - 1)).getBounds().getBottomLeft().y +1;
					bound.x = container.getBounds().x + 3;
					bound.width= container.getBounds().width;
				} else {
					bound.x = container.getBounds().x + 3;
					bound.y = container.getBounds().y+ ((container.getBounds().height-labelheight)/2);
					bound.width= container.getBounds().width;

				}
				((IFigure) container.getChildren().get(i)).setBounds(bound);
			}
			else{
				Rectangle bound = new Rectangle(((IFigure) container.getChildren().get(i)).getBounds());
				bound.y = container.getBounds().getBottomLeft().y+1;
				bound.x = container.getBounds().x + 3;
				((IFigure) container.getChildren().get(i)).setBounds(bound);}
		}

	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	public void layout (IFigure container){
		collectInformationOnChildren(container);

		//choose the good layout by taking in account if it exist GMF compartment
		if(compartmentList.size()!=0){
			List childrenList = container.getChildren();
			for (int i = 0; i < container.getChildren().size(); i++) {
				Rectangle bound = new Rectangle(((IFigure) childrenList.get(i)).getBounds());
				bound.setSize(getPreferedSize(((IFigure) childrenList.get(i))));
				if (i > 0) {
					bound.y = ((IFigure) childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
					bound.x = container.getBounds().x +3;
					bound.width= container.getBounds().width;
				} else {
					bound.x = container.getBounds().x + 3;
					bound.y = container.getBounds().y;
					bound.width= container.getBounds().width;

				}
				((IFigure) childrenList.get(i)).setBounds(bound);
				adaptGMFContainerBound(((IFigure) childrenList.get(i)), bound);

			}
			optimizeCompartmentSize(container);
		}
		else{
			layoutCenterForLabel(container);

		}
	}

	/**
	 * Optimize the size of each compartment depending on the size of the compartments container, and the size of each compartment. 
	 * If a compartment is empty, or not expanded, then a default size is applied to this compartment 
	 * @param compartmentsDimension an hashmap containing each compartment dimension.
	 */
	protected void optimizeCompartmentSize(IFigure container) {
		int compartmentsHeight = 0;
		int notCompartmentsHeight = 0;
		for( int i=0;i< notCompartmentList.size();i++){
			notCompartmentsHeight+= notCompartmentList.get(i).getBounds().height;
		}

		for( int i=0;i< compartmentList.size();i++){
			compartmentsHeight+= compartmentList.get(i).getBounds().height;
		}
		int remainingspace=container.getBounds().height-notCompartmentsHeight;

		// ratio between the height of all compartments and the size of the compartments container.
		double ratio = new Integer(compartmentsHeight).doubleValue()
		/ new Integer(remainingspace).doubleValue();

		for( int i=0;i< compartmentList.size();i++){
			Rectangle bound = new Rectangle(((IFigure) compartmentList.get(i)).getBounds());
			int value = (int) (bound.height / ratio);
			bound.height=value;
			bound.x=container.getBounds().x;
			if(i>0){
				bound.y = ((IFigure) compartmentList.get(i - 1)).getBounds().getBottomLeft().y + 1;

			}
			((IFigure) compartmentList.get(i)).setBounds(bound);
			adaptGMFContainerBound(((IFigure) compartmentList.get(i)), bound);

		}


	}

	public void collectInformationOnChildren(IFigure container){
		compartmentList= new ArrayList<IFigure>();  
		notCompartmentList= new ArrayList<IFigure>();  
		for (int i = 0; i < container.getChildren().size(); i++) {
			if(isAGMFContainer(((IFigure)container.getChildren().get(i)) )){
				compartmentList.add(((IFigure)container.getChildren().get(i)));
			}
			else{
				if((container.getChildren().get(i)) instanceof Label||(container.getChildren().get(i)) instanceof WrappingLabel){
					notCompartmentList.add(((IFigure)container.getChildren().get(i)));}}

		}
	}

	/**
	 * set the bound of the container of  a GMF compartment figure
	 * @param figure
	 * @param bounds
	 */
	protected void adaptGMFContainerBound(IFigure figure, Rectangle bounds ){
		if (figure.getChildren().size() > 0) {
			if (figure.getChildren().get(0) instanceof ShapeCompartmentFigure){
				((ShapeCompartmentFigure)figure.getChildren().get(0)).setBounds(bounds);
			}
		}
	}
	/**
	 * obtain a prefered size 
	 * @param figure that can contain a GMF compartment figure
	 * @return a the size
	 */
	public Dimension getPreferedSize(IFigure figure){
		Dimension dim =figure.getPreferredSize();
		if (figure.getChildren().size() > 0) {
			if (figure.getChildren().get(0) instanceof ResizableCompartmentFigure){
				dim.height=((ResizableCompartmentFigure)figure.getChildren().get(0)).getPreferredSize().height+10;
				if (dim.height==0){
					dim.height=MINIMUM_COMPARTMENT_HEIGHT;
				}

			}
		}
		return dim;
	}
	/**
	 * tests is the figure contains a GMF compartment
	 * @param figure
	 * @return true if this is the case
	 */
	public boolean isAGMFContainer(IFigure figure ){
		if (figure.getChildren().size() > 0) {
			if (figure.getChildren().get(0) instanceof ResizableCompartmentFigure){
				return true;
			}
		}
		return false;
	}

}

