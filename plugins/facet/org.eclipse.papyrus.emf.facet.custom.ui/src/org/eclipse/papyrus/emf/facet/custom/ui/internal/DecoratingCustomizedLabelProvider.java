/*******************************************************************************
 * Copyright (c) 2013 Soft-Maint.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Couvrand (Soft-Maint) - Bug 418418 - [Customization] Overlay icons not implemented
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedLabelProvider;
import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

public class DecoratingCustomizedLabelProvider extends
		DecoratingStyledCellLabelProvider implements ICustomizedLabelProvider {

	private ICustomizedLabelProvider lblProvider;

	private DecoratingCustomizedLabelProvider(
			final IStyledLabelProvider labelProvider,
			final ILabelDecorator decorator,
			final IDecorationContext decorationContext) {
		super(labelProvider, decorator, decorationContext);
	}

	public DecoratingCustomizedLabelProvider(
			final ICustomizationManager customizationMgr) {
		this(new CustomizedLabelProvider(customizationMgr),
				new CustomizedLabelDecorator(customizationMgr), null);
		this.lblProvider = (ICustomizedLabelProvider) getStyledStringProvider();
	}

	public String getText(final Object element) {
		return this.lblProvider.getText(element);
	}

	public String getToolTipText(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipText(element, eTypedElement);
	}

	public Image getToolTipImage(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipImage(element, eTypedElement);
	}

	public Font getToolTipFont(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipFont(element, eTypedElement);
	}

	public Color getToolTipBackgroundColor(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipBackgroundColor(element,
				eTypedElement);
	}

	public Color getToolTipForegroundColor(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipForegroundColor(element,
				eTypedElement);
	}

	public Image getToolTipTopLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider
				.getToolTipTopLeftOverlay(element, eTypedElement);
	}

	public Image getToolTipTopMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipTopMiddleOverlay(element,
				eTypedElement);
	}

	public Image getToolTipTopRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipTopRightOverlay(element,
				eTypedElement);
	}

	public Image getToolTipBottomLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipBottomLeftOverlay(element,
				eTypedElement);
	}

	public Image getToolTipBottomMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipBottomMiddleOverlay(element,
				eTypedElement);
	}

	public Image getToolTipBottomRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipBottomRightOverlay(element,
				eTypedElement);
	}

	public int getToolTipTimeDisplayed(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipTimeDisplayed(element, eTypedElement);
	}

	public int getToolTipDisplayDelayTime(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipDisplayDelayTime(element,
				eTypedElement);
	}

	public int getToolTipStyle(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getToolTipStyle(element, eTypedElement);
	}

	public ICustomizationManager getCustomizationManager() {
		return this.lblProvider.getCustomizationManager();
	}

	public boolean isUnderlined(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.isUnderlined(element, eTypedElement);
	}

	public boolean isStruckthrough(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.isStruckthrough(element, eTypedElement);
	}

	public Image getTopLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getTopLeftOverlay(element, eTypedElement);
	}

	public Image getTopMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getTopMiddleOverlay(element, eTypedElement);
	}

	public Image getTopRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getTopRightOverlay(element, eTypedElement);
	}

	public Image getBottomLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getBottomLeftOverlay(element, eTypedElement);
	}

	public Image getBottomMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getBottomMiddleOverlay(element, eTypedElement);
	}

	public Image getBottomRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getBottomRightOverlay(element, eTypedElement);
	}

	public String getText(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getText(element, eTypedElement);
	}

	public Image getImage(final Object element,
			final ETypedElement eTypedElement) {
		return this.lblProvider.getImage(element, eTypedElement);
	}

	public ICustomizedLabelProvider cloneLabelProvider() {
		return this.lblProvider.cloneLabelProvider();
	}
}
