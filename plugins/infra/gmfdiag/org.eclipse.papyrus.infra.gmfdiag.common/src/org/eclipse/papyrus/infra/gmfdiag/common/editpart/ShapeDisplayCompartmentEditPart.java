/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.AnimatableScrollPane;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.BorderedScalableImageFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ScalableCompartmentFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ShapeFlowLayout;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SubCompartmentLayoutManager;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.NotificationManager;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ShapeService;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

/**
 * CompartmentEditPart in charge of shpae display.
 */
public class ShapeDisplayCompartmentEditPart extends ResizableCompartmentEditPart {

	/** Title of this compartment */
	public final static String COMPARTMENT_NAME = "shape"; // $NON-NLS-1$

	/**
	 * Creates a new ShapeDisplayCompartmentEditPart
	 * 
	 * @param model
	 *        The resizable compartment view
	 */
	public ShapeDisplayCompartmentEditPart(EObject model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		super.activate();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Start of user code custom edit policies
		installEditPolicy(ShapeRefreshEditPolicy.SHAPE_REFRESH_EDIT_POLICY_ROLE, new ShapeRefreshEditPolicy());
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompartmentName() {
		return COMPARTMENT_NAME;
	}

	/**
	 * this method is used to set the ratio of the figure.
	 * pay attention if the ratio  is true, the only figure is displayed 
	 * @param maintainRatio
	 */
	public void maintainRatio(boolean maintainRatio){
		IFigure contentPane= ((ResizableCompartmentFigure)getFigure()).getContentPane();
		for(Object subFigure : contentPane.getChildren()) {
			if( subFigure instanceof BorderedScalableImageFigure){
				((BorderedScalableImageFigure)subFigure).setMaintainAspectRatio(maintainRatio);
			}

		}
		if(!maintainRatio){
			OneShapeLayoutManager layout = new OneShapeLayoutManager();
			contentPane.setLayoutManager(layout);
		}
		else{
			ShapeFlowLayout layout = new ShapeFlowLayout();
			contentPane.setLayoutManager(layout);
		}
		

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = new ScalableCompartmentFigure(getCompartmentName(), getMapMode());
		//result.setBackgroundColor(ColorConstants.lightBlue);
		//result.setForegroundColor(ColorConstants.blue);
		// result.getParent().setBackgroundColor(ColorConstants.lightGray);
		ShapeCompartmentLayoutManager layoutManager = new ShapeCompartmentLayoutManager();
		result.setLayoutManager(layoutManager);
		ShapeFlowLayout layout = new ShapeFlowLayout();
		//		layout.setHorizontal(true);
		//		layout.setStretchMinorAxis(true);
		//		layout.setStretchMajorAxis(true);
		//		layout.setMinorAlignment(OrderedLayout.ALIGN_CENTER);

		result.getContentPane().setLayoutManager(layout);

		return result;
	}

	/**
	 * Refreshes the displayed shapes on the figure. 
	 * <P>To be sure everything is clean, it removes all the current displayed shapes and then redraw all of the demanded shapes. This could be probably improved in case of performance issues.</P> 
	 * @param contentPane the figure where to add the new shapes
	 */
	protected void refreshShapes(IFigure contentPane) {
		List<Object> children = new ArrayList<Object>(contentPane.getChildren());
		for(Object child : children) {
			if(child instanceof IFigure) {
				contentPane.remove((IFigure)child);
			}
		}

		List<RenderedImage> shapesToDisplay = ShapeService.getInstance().getShapesToDisplay(getNotationView().eContainer());
		if(shapesToDisplay != null && !shapesToDisplay.isEmpty()) {
			for(RenderedImage image : shapesToDisplay) {
				if(image !=null) {
					IFigure imageFigure = new BorderedScalableImageFigure(image, false, false, true);
					imageFigure.setOpaque(false);
					imageFigure.setVisible(true);
					contentPane.add(imageFigure);
				} else {
					Activator.log.debug("No image will be drawn");
				}
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setRatio(Double ratio) {
		if(getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	 * Specific layout manager for the shape compartment. The main goal of this class is to ease the debug process. no specific implementation is
	 * planned yet.
	 * We prevent to display the label of the compartment shape
	 */
	public class ShapeCompartmentLayoutManager extends SubCompartmentLayoutManager {

		public static final int MIN_PREFERRED_SIZE = 40; 

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void layout(IFigure container) {
			super.layout(container);
			for(int i = 0; i < container.getChildren().size(); i++) {
			 if(container.getChildren().get(i) instanceof ScrollPane ){
				 ((ScrollPane)container.getChildren().get(i)).setBounds(container.getBounds()); 
			 }
			}
			
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure figure, int wHint, int hHint) {
			Dimension dim =  super.calculatePreferredSize(figure, wHint, hHint);

			dim.height = Math.max(MIN_PREFERRED_SIZE, dim.height);

			return dim;
		}
		

	}
	public class OneShapeLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

			int minimumWith = 50;
			int minimumHeight = 50;

			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			Rectangle compartmentBound = new Rectangle(container.getBounds());
			if(container.getBorder() instanceof MarginBorder){
				MarginBorder marginBorder=((MarginBorder)container.getBorder());
				compartmentBound=compartmentBound.shrink(marginBorder.getInsets(container));
			}
			
			
			IFigure contentPane= ((ResizableCompartmentFigure)getFigure()).getContentPane();
			ScalableImageFigure scalableImageFigure=null;
			if( contentPane.getChildren().size()>0){
				Object lastFig=contentPane.getChildren().get(contentPane.getChildren().size()-1);
				if( lastFig instanceof ScalableImageFigure){
					scalableImageFigure= (ScalableImageFigure)lastFig;
				}
			}
			if(scalableImageFigure != null) {
				scalableImageFigure.setBounds(compartmentBound);
			}

		}
	}

	/**
	 * Edit Policy in charge of the graphical update of the compartment 
	 */
	@SuppressWarnings("restriction")
	public class ShapeRefreshEditPolicy extends GraphicalEditPolicyEx implements NotificationListener {

		/** role for this edit policy */
		public static final String SHAPE_REFRESH_EDIT_POLICY_ROLE = "shape_refresh_edit_policy"; ////$NON-NLS-1$

		/** manager for notifications */
		protected NotificationManager notificationManager;

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void activate() {
			super.activate();
			// retrieve the view and the element managed by the edit part
			View view = getView();
			if(view == null) {
				return;
			}
			// listens for modifications on the container of the compartment, i.e. the figure that handle stereotype management (ClassifierView for example)
			notificationManager = ShapeService.getInstance().createNotificationManager(getDiagramEventBroker(), view.eContainer(), this);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void deactivate() {
			// retrieve the view and the element managed by the edit part
			View view = getView();
			if(view == null) {
				return;
			}
			notificationManager.dispose();
			notificationManager = null;
			super.deactivate();
		}

		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("restriction")
		@Override
		public void refresh() {
			super.refresh();
			refreshShapes(getContentPane());
		}

		/**
		 * {@inheritDoc}
		 */
		public void notifyChanged(Notification notification) {
			refresh();
		}

		/**
		 * Gets the diagram event broker from the editing domain.
		 * 
		 * @return the diagram event broker
		 */
		protected DiagramEventBroker getDiagramEventBroker() {
			TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
			if(theEditingDomain != null) {
				return DiagramEventBroker.getInstance(theEditingDomain);
			}
			return null;
		}

		/**
		 * Returns the view controlled by the host edit part
		 * 
		 * @return the view controlled by the host edit part
		 */
		protected View getView() {
			return (View)getHost().getModel();
		}
	}
}
