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
 */
package org.eclipse.papyrus.diagram.activity.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.figure.node.PapyrusRoundedNodeFigure;

/**
 * Activity figure for the activity diagram
 * @author PT202707
 *
 */
public class ActivityFigure extends PapyrusRoundedNodeFigure {

	/**
	 * gap in x to display name stereotypes and qualified name
	 */
	protected final int GAP_X = 10;

	/**
	 * gap in y to display the first label at the top of the package
	 */
	protected final int GAP_Y = 5;
	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class ActivityLayoutManager extends AbstractLayout {

		/**
		 * ---------------------------------------------------|
		 * |sterotypeLabel|        precondition               |
		 * |--------------|                                   |
		 * |QualifiedName |-----------------------------------|
		 * |--------------|                                   |
		 * |name          |      postcondition                |
		 * |--------------------------------------------------|
		 * | stereotype compartment                           |
		 * |--------------------------------------------------|
		 * |parameter |                                       |
		 * |-----------                                       |
		 * |             activity content                     |
		 * ----------------------------------------------------
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

			int minimumWith = 0;
			int minimumHeight = 0;
			// display name
			if(getNameLabel() != null) {
				if(getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = getNameLabel().getPreferredSize().width;
				}
				minimumHeight += getNameLabel().getPreferredSize().height;
			}

			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			List childrenList = container.getChildren();
			for(int i = 0; i < container.getChildren().size(); i++) {
				Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
				bound.setSize(((IFigure)childrenList.get(i)).getPreferredSize());
				if(i > 0) {
					bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
					bound.x = getBounds().x + GAP_X;
				} else {
					bound.x = getBounds().x + GAP_X;
					bound.y = getBounds().y + GAP_Y;

				}
				((IFigure)childrenList.get(i)).setBounds(bound);
			}
			// container
			Rectangle lastRectangle = getContentFigure().getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			lastRectangle.x = container.getBounds().x;
			lastRectangle.width = getBounds().width;
			getContentFigure().setBounds(lastRectangle);
			if(getGMFContentContainer() != null) {
				getGMFContentContainer().setBounds(lastRectangle);
			}
			//place precondition
			// setX
			Rectangle preconditionBound= getPreconditionFigure().getBounds().getCopy();
			preconditionBound.x= getNameLabel().getBounds().getTopRight().x+GAP_X;
			//take in account stereotype label
			if( getStereotypesLabel()!=null){
				int posStererotypeLabel= getStereotypesLabel().getBounds().getTopRight().x+GAP_X;
				if(posStererotypeLabel> preconditionBound.x){
					preconditionBound.x=posStererotypeLabel;
				}
			}
			//take in account qualified name
			if( getQualifiedNameLabel()!=null){
				int posqualifiedName= getQualifiedNameLabel().getBounds().getTopRight().x+GAP_X;
				if(posqualifiedName> preconditionBound.x){
					preconditionBound.x=posqualifiedName;
				}
			}
			//take in account stereotype properties
			if( stereotypePropertiesInBraceContent!=null){
				int possterotypeInBrace= stereotypePropertiesInBraceContent.getBounds().getTopRight().x+GAP_X;
				if(possterotypeInBrace> preconditionBound.x){
					preconditionBound.x=possterotypeInBrace;
				}
			}
			//take in account parameter figure
			if( getParameterFigure()!=null){
				int posparameter= getParameterFigure().getBounds().getTopRight().x+GAP_X;
				if(posparameter> preconditionBound.x){
					preconditionBound.x=posparameter;
				}
			}
			//setY
			preconditionBound.y=((IFigure) container.getChildren().get(0)).getBounds().y;
			getPreconditionFigure().setBounds(preconditionBound);
			if(getPreconditionFigure().getChildren().size() > 0) {
				 ((IFigure)getPreconditionFigure().getChildren().get(0)).setBounds(preconditionBound);;
			}

			//setPoscondtion
			Rectangle postconditionBound= getPostconditionFigure().getBounds().getCopy();
			postconditionBound.x= getPreconditionFigure().getBounds().x;
			postconditionBound.y= getPreconditionFigure().getBounds().y+getPreconditionFigure().getBounds().height+GAP_Y;
			getPostconditionFigure().setBounds(postconditionBound);
			if(getPostconditionFigure().getChildren().size() > 0) {
				 ((IFigure)getPostconditionFigure().getChildren().get(0)).setBounds(postconditionBound);;
			}

			//setPoscondtion
			Rectangle singleExecutionBound= getHeaderSingleExecution().getBounds().getCopy();
			singleExecutionBound.x= getPreconditionFigure().getBounds().x+getPreconditionFigure().getBounds().width+GAP_X;;
			singleExecutionBound.y= getPreconditionFigure().getBounds().y;
			getHeaderSingleExecution().setBounds(singleExecutionBound);
			
			//replace compartment stereotype properties
			if(getStereotypePropertiesContent()!=null){
				Rectangle pscontainer=getStereotypePropertiesContent().getBounds().getCopy();
				if(getPostconditionFigure().getBounds().y+getPostconditionFigure().getBounds().height+GAP_Y>pscontainer.y)
					pscontainer.y=getPostconditionFigure().getBounds().y+getPostconditionFigure().getBounds().height+GAP_Y;
				getStereotypePropertiesContent().setBounds(pscontainer);
			}
			
			
			//place parameter
			//replace compartment stereotype properties
			if(getStereotypePropertiesContent()!=null){
				Rectangle paramBoundcontainer=getParameterFigure().getBounds().getCopy();
				paramBoundcontainer.y=getStereotypePropertiesContent().getBounds().getBottomLeft().y;
				getParameterFigure().setBounds(paramBoundcontainer);
				if(getParameterFigure().getChildren().size() > 0) {
					 ((IFigure)shapeCompartment.getChildren().get(0)).setBounds(paramBoundcontainer);
					 
					 
				}
			}
			else{
				Rectangle paramBoundcontainer=getParameterFigure().getBounds().getCopy();
				paramBoundcontainer.y=getNameLabel().getBounds().getBottomLeft().y;
				getParameterFigure().setBounds(paramBoundcontainer);
				if(getParameterFigure().getChildren().size() > 0) {
					 ((IFigure)shapeCompartment.getChildren().get(0)).setBounds(paramBoundcontainer);;
				}
			}
			
		}

	}

	/**
	 * @generated
	 */
	private WrappingLabel fHeaderLabel;

	/**
	 * @generated
	 */
	private RectangleFigure fActivityParametersCompartment;

	/**
	 * @generated
	 */
	private RectangleFigure fActivityPreconditionsCompartment;

	/**
	 * @generated
	 */
	private RectangleFigure fActivityPostconditionsCompartment;

	/**
	 * @generated
	 */
	protected WrappingLabel fHeaderSingleExecution;

	/**
	 * @generated
	 */
	private RectangleFigure fCompartmentFigure;

	private RectangleFigure shapeCompartment;

	private RectangleFigure preconditionFigure;

	private RectangleFigure postconditionFigure;
	private RectangleFigure parameterFigure;

	/**
	 * @generated
	 */
	public ActivityFigure() {
		super();
		setLayoutManager( new ActivityLayoutManager());

		shapeCompartment = new RectangleFigure();
		shapeCompartment.setOpaque(false);
		shapeCompartment.setFill(false);
		shapeCompartment.setOutline(false);
		shapeCompartment.setLineWidth(0);
		add(shapeCompartment);


		preconditionFigure = new RectangleFigure();
		preconditionFigure.setOpaque(false);
		preconditionFigure.setFill(false);
		preconditionFigure.setOutline(false);
		preconditionFigure.setLineWidth(10);
		preconditionFigure.setBorder(null);
		preconditionFigure.setForegroundColor(ColorConstants.red);
		add(preconditionFigure);


		parameterFigure = new RectangleFigure();
		parameterFigure.setOpaque(false);
		parameterFigure.setFill(false);
		parameterFigure.setOutline(false);
		parameterFigure.setLineWidth(0);
		add(parameterFigure);

		postconditionFigure = new RectangleFigure();
		postconditionFigure.setOpaque(false);
		postconditionFigure.setFill(false);
		postconditionFigure.setOutline(false);
		postconditionFigure.setLineWidth(0);
		add(postconditionFigure);
		
		
		fHeaderSingleExecution= new WrappingLabel();
		add(fHeaderSingleExecution);
		//createContents();
	}

	public RectangleFigure getPreconditionFigure(){
		return preconditionFigure;
	}

	public RectangleFigure getPostconditionFigure(){
		return postconditionFigure;
	}
	public RectangleFigure getParameterFigure(){
		return parameterFigure;
	}
	public RectangleFigure getContentFigure(){
		return shapeCompartment;
	}
	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFContentContainer() {
		if(shapeCompartment.getChildren().size() > 0) {
			return (ShapeCompartmentFigure)shapeCompartment.getChildren().get(0);
		}
		return null;
	}
	/**
	 * @generated
	 */
	private void createContents() {

		RoundedRectangle activityBorderFigure0 = new RoundedRectangle();
		this.add(activityBorderFigure0, BorderLayout.CENTER);
		//to remove
		activityBorderFigure0.setBackgroundColor(ColorConstants.red);


		GridLayout layoutActivityBorderFigure0 = new GridLayout();
		layoutActivityBorderFigure0.numColumns = 3;
		layoutActivityBorderFigure0.makeColumnsEqualWidth = false;
		layoutActivityBorderFigure0.horizontalSpacing = 0;
		layoutActivityBorderFigure0.verticalSpacing = 0;
		layoutActivityBorderFigure0.marginWidth = 0;
		layoutActivityBorderFigure0.marginHeight = 0;
		activityBorderFigure0.setLayoutManager(layoutActivityBorderFigure0);

		RectangleFigure labelAndParameter1 = new RectangleFigure();
		labelAndParameter1.setFill(false);
		labelAndParameter1.setOutline(false);
		labelAndParameter1.setLineWidth(0);
		//to remove
		labelAndParameter1.setBackgroundColor(ColorConstants.blue);

		GridData constraintLabelAndParameter1 = new GridData();
		constraintLabelAndParameter1.verticalAlignment = GridData.CENTER;
		constraintLabelAndParameter1.horizontalAlignment = GridData.BEGINNING;
		constraintLabelAndParameter1.horizontalIndent = 0;
		constraintLabelAndParameter1.horizontalSpan = 1;
		constraintLabelAndParameter1.verticalSpan = 1;
		constraintLabelAndParameter1.grabExcessHorizontalSpace = true;
		constraintLabelAndParameter1.grabExcessVerticalSpace = false;
		activityBorderFigure0.add(labelAndParameter1,
			constraintLabelAndParameter1);

		GridLayout layoutLabelAndParameter1 = new GridLayout();
		layoutLabelAndParameter1.numColumns = 1;
		layoutLabelAndParameter1.makeColumnsEqualWidth = true;
		labelAndParameter1.setLayoutManager(layoutLabelAndParameter1);

		fHeaderLabel = new WrappingLabel();
		fHeaderLabel.setText("ActivityName");


		GridData constraintFHeaderLabel = new GridData();
		constraintFHeaderLabel.verticalAlignment = GridData.CENTER;
		constraintFHeaderLabel.horizontalAlignment = GridData.BEGINNING;
		constraintFHeaderLabel.horizontalIndent = 4;
		constraintFHeaderLabel.horizontalSpan = 1;
		constraintFHeaderLabel.verticalSpan = 1;
		constraintFHeaderLabel.grabExcessHorizontalSpace = true;
		constraintFHeaderLabel.grabExcessVerticalSpace = false;
		labelAndParameter1.add(fHeaderLabel, constraintFHeaderLabel);

		fActivityParametersCompartment = new RectangleFigure();
		//to remove
		fActivityParametersCompartment.setBackgroundColor(ColorConstants.green);

		fActivityParametersCompartment.setFill(false);
		fActivityParametersCompartment.setOutline(false);
		fActivityParametersCompartment.setLineWidth(0);

		GridData constraintFActivityParametersCompartment = new GridData();
		constraintFActivityParametersCompartment.verticalAlignment = GridData.CENTER;
		constraintFActivityParametersCompartment.horizontalAlignment = GridData.BEGINNING;
		constraintFActivityParametersCompartment.horizontalIndent = 0;
		constraintFActivityParametersCompartment.horizontalSpan = 1;
		constraintFActivityParametersCompartment.verticalSpan = 1;
		constraintFActivityParametersCompartment.grabExcessHorizontalSpace = true;
		constraintFActivityParametersCompartment.grabExcessVerticalSpace = false;
		labelAndParameter1.add(fActivityParametersCompartment,
			constraintFActivityParametersCompartment);

		fActivityParametersCompartment.setLayoutManager(new StackLayout());

		RectangleFigure prePostContions1 = new RectangleFigure();
		//to remove
		prePostContions1.setBackgroundColor(ColorConstants.cyan);
		prePostContions1.setFill(false);
		prePostContions1.setOutline(false);
		prePostContions1.setLineWidth(0);

		GridData constraintPrePostContions1 = new GridData();
		constraintPrePostContions1.verticalAlignment = GridData.CENTER;
		constraintPrePostContions1.horizontalAlignment = GridData.BEGINNING;
		constraintPrePostContions1.horizontalIndent = 0;
		constraintPrePostContions1.horizontalSpan = 1;
		constraintPrePostContions1.verticalSpan = 1;
		constraintPrePostContions1.grabExcessHorizontalSpace = true;
		constraintPrePostContions1.grabExcessVerticalSpace = false;
		activityBorderFigure0.add(prePostContions1,
			constraintPrePostContions1);

		GridLayout layoutPrePostContions1 = new GridLayout();
		layoutPrePostContions1.numColumns = 1;
		layoutPrePostContions1.makeColumnsEqualWidth = true;
		prePostContions1.setLayoutManager(layoutPrePostContions1);

		fActivityPreconditionsCompartment = new RectangleFigure();
		fActivityPreconditionsCompartment.setBackgroundColor(ColorConstants.darkBlue);
		fActivityPreconditionsCompartment.setFill(false);
		fActivityPreconditionsCompartment.setOutline(false);
		fActivityPreconditionsCompartment.setLineWidth(0);

		GridData constraintFActivityPreconditionsCompartment = new GridData();
		constraintFActivityPreconditionsCompartment.verticalAlignment = GridData.CENTER;
		constraintFActivityPreconditionsCompartment.horizontalAlignment = GridData.BEGINNING;
		constraintFActivityPreconditionsCompartment.horizontalIndent = 0;
		constraintFActivityPreconditionsCompartment.horizontalSpan = 1;
		constraintFActivityPreconditionsCompartment.verticalSpan = 1;
		constraintFActivityPreconditionsCompartment.grabExcessHorizontalSpace = true;
		constraintFActivityPreconditionsCompartment.grabExcessVerticalSpace = false;
		prePostContions1.add(fActivityPreconditionsCompartment,
			constraintFActivityPreconditionsCompartment);

		fActivityPreconditionsCompartment
		.setLayoutManager(new StackLayout());

		fActivityPostconditionsCompartment = new RectangleFigure();
		fActivityPostconditionsCompartment.setFill(false);
		fActivityPostconditionsCompartment.setOutline(false);
		fActivityPostconditionsCompartment.setLineWidth(0);

		GridData constraintFActivityPostconditionsCompartment = new GridData();
		constraintFActivityPostconditionsCompartment.verticalAlignment = GridData.CENTER;
		constraintFActivityPostconditionsCompartment.horizontalAlignment = GridData.BEGINNING;
		constraintFActivityPostconditionsCompartment.horizontalIndent = 0;
		constraintFActivityPostconditionsCompartment.horizontalSpan = 1;
		constraintFActivityPostconditionsCompartment.verticalSpan = 1;
		constraintFActivityPostconditionsCompartment.grabExcessHorizontalSpace = true;
		constraintFActivityPostconditionsCompartment.grabExcessVerticalSpace = false;
		prePostContions1.add(fActivityPostconditionsCompartment,
			constraintFActivityPostconditionsCompartment);

		fActivityPostconditionsCompartment
		.setLayoutManager(new StackLayout());

		fHeaderSingleExecution = new WrappingLabel();
		fHeaderSingleExecution.setText("");

		GridData constraintFHeaderSingleExecution = new GridData();
		constraintFHeaderSingleExecution.verticalAlignment = GridData.CENTER;
		constraintFHeaderSingleExecution.horizontalAlignment = GridData.BEGINNING;
		constraintFHeaderSingleExecution.horizontalIndent = 0;
		constraintFHeaderSingleExecution.horizontalSpan = 1;
		constraintFHeaderSingleExecution.verticalSpan = 2;
		constraintFHeaderSingleExecution.grabExcessHorizontalSpace = false;
		constraintFHeaderSingleExecution.grabExcessVerticalSpace = false;
		activityBorderFigure0.add(fHeaderSingleExecution,
			constraintFHeaderSingleExecution);

		fCompartmentFigure = new RectangleFigure();
		fCompartmentFigure.setFill(false);
		fCompartmentFigure.setOutline(false);
		fCompartmentFigure.setLineWidth(0);

		GridData constraintFCompartmentFigure = new GridData();
		constraintFCompartmentFigure.verticalAlignment = GridData.FILL;
		constraintFCompartmentFigure.horizontalAlignment = GridData.FILL;
		constraintFCompartmentFigure.horizontalIndent = 0;
		constraintFCompartmentFigure.horizontalSpan = 3;
		constraintFCompartmentFigure.verticalSpan = 1;
		constraintFCompartmentFigure.grabExcessHorizontalSpace = true;
		constraintFCompartmentFigure.grabExcessVerticalSpace = true;
		activityBorderFigure0.add(fCompartmentFigure,
			constraintFCompartmentFigure);

	}

	/**
	 * @generated
	 */
	public WrappingLabel getHeaderLabel() {
		return fHeaderLabel;
	}

	/**
	 * @generated
	 */
	public RectangleFigure getActivityParametersCompartment() {
		return fActivityParametersCompartment;
	}

	/**
	 * @generated
	 */
	public RectangleFigure getActivityPreconditionsCompartment() {
		return fActivityPreconditionsCompartment;
	}

	/**
	 * @generated
	 */
	public RectangleFigure getActivityPostconditionsCompartment() {
		return fActivityPostconditionsCompartment;
	}

	/**
	 * @generated
	 */
	public WrappingLabel getHeaderSingleExecution() {
		return fHeaderSingleExecution;
	}

	/**
	 * @generated
	 */
	public RectangleFigure getCompartmentFigure() {
		return fCompartmentFigure;
	}



}
