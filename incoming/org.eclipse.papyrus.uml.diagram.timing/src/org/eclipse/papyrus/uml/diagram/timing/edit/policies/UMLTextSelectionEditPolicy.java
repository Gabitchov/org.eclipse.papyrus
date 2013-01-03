/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.policies;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLTextSelectionEditPolicy extends SelectionEditPolicy implements IRefreshableFeedbackEditPolicy {

	/**
	 * @generated
	 */
	private IFigure selectionFeedbackFigure;

	/**
	 * @generated
	 */
	private IFigure focusFeedbackFigure;

	/**
	 * @generated
	 */
	private FigureListener hostPositionListener;

	/**
	 * @generated
	 */
	@Override
	protected void showPrimarySelection() {
		if (getHostFigure() instanceof WrappingLabel) {
			((WrappingLabel) getHostFigure()).setSelected(true);
			((WrappingLabel) getHostFigure()).setFocus(true);
		} else {
			showSelection();
			showFocus();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void showSelection() {
		if (getHostFigure() instanceof WrappingLabel) {
			((WrappingLabel) getHostFigure()).setSelected(true);
			((WrappingLabel) getHostFigure()).setFocus(false);
		} else {
			hideSelection();
			addFeedback(this.selectionFeedbackFigure = createSelectionFeedbackFigure());
			getHostFigure().addFigureListener(getHostPositionListener());
			refreshSelectionFeedback();
			hideFocus();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void hideSelection() {
		if (getHostFigure() instanceof WrappingLabel) {
			((WrappingLabel) getHostFigure()).setSelected(false);
			((WrappingLabel) getHostFigure()).setFocus(false);
		} else {
			if (this.selectionFeedbackFigure != null) {
				removeFeedback(this.selectionFeedbackFigure);
				getHostFigure().removeFigureListener(getHostPositionListener());
				this.selectionFeedbackFigure = null;
			}
			hideFocus();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void showFocus() {
		if (getHostFigure() instanceof WrappingLabel) {
			((WrappingLabel) getHostFigure()).setFocus(true);
		} else {
			hideFocus();
			addFeedback(this.focusFeedbackFigure = createFocusFeedbackFigure());
			refreshFocusFeedback();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void hideFocus() {
		if (getHostFigure() instanceof WrappingLabel) {
			((WrappingLabel) getHostFigure()).setFocus(false);
		} else {
			if (this.focusFeedbackFigure != null) {
				removeFeedback(this.focusFeedbackFigure);
				this.focusFeedbackFigure = null;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Rectangle getFeedbackBounds() {
		Rectangle bounds;
		if (getHostFigure() instanceof Label) {
			bounds = ((Label) getHostFigure()).getTextBounds();
			bounds.intersect(getHostFigure().getBounds());
		} else {
			bounds = getHostFigure().getBounds().getCopy();
		}
		getHostFigure().getParent().translateToAbsolute(bounds);
		getFeedbackLayer().translateToRelative(bounds);
		return bounds;
	}

	/**
	 * @generated
	 */
	protected IFigure createSelectionFeedbackFigure() {
		if (getHostFigure() instanceof Label) {
			final Label feedbackFigure = new Label();
			feedbackFigure.setOpaque(true);
			feedbackFigure.setBackgroundColor(ColorConstants.menuBackgroundSelected);
			feedbackFigure.setForegroundColor(ColorConstants.menuForegroundSelected);
			return feedbackFigure;
		} else {
			final RectangleFigure feedbackFigure = new RectangleFigure();
			feedbackFigure.setFill(false);
			return feedbackFigure;
		}
	}

	/**
	 * @generated
	 */
	protected IFigure createFocusFeedbackFigure() {
		return new Figure() {

			@Override
			protected void paintFigure(final Graphics graphics) {
				graphics.drawFocus(getBounds().getResized(-1, -1));
			}
		};
	}

	/**
	 * @generated
	 */
	protected void updateLabel(final Label target) {
		final Label source = (Label) getHostFigure();
		target.setText(source.getText());
		target.setTextAlignment(source.getTextAlignment());
		target.setFont(source.getFont());
	}

	/**
	 * @generated
	 */
	protected void refreshSelectionFeedback() {
		if (this.selectionFeedbackFigure != null) {
			if (this.selectionFeedbackFigure instanceof Label) {
				updateLabel((Label) this.selectionFeedbackFigure);
				this.selectionFeedbackFigure.setBounds(getFeedbackBounds());
			} else {
				this.selectionFeedbackFigure.setBounds(getFeedbackBounds().expand(5, 5));
			}
		}
	}

	/**
	 * @generated
	 */
	protected void refreshFocusFeedback() {
		if (this.focusFeedbackFigure != null) {
			this.focusFeedbackFigure.setBounds(getFeedbackBounds());
		}
	}

	/**
	 * @generated
	 */
	public void refreshFeedback() {
		refreshSelectionFeedback();
		refreshFocusFeedback();
	}

	/**
	 * @generated
	 */
	private FigureListener getHostPositionListener() {
		if (this.hostPositionListener == null) {
			this.hostPositionListener = new FigureListener() {
				public void figureMoved(final IFigure source) {
					refreshFeedback();
				}
			};
		}
		return this.hostPositionListener;
	}

}
