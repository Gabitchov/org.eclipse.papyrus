/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.strategy.ui.providers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.google.common.base.Predicate;


/**
 * The Class ExtensiveLabelProvider. {@link ILabelProvider} that extend the one use by the model explorer view.
 * This label provider can customize label and color of display object using predicate
 */
public class ExtensivePartitionNameLabelProvider implements IFontProvider, IColorProvider, ILabelProvider {


	private ILabelProvider internal;


	/** The color. */
	private Color color;

	/** The font. */
	private Font font;

	/** The predicate. */
	private Predicate<EObject> predicate;

	/**
	 * Instantiates a new extensive label provider.
	 *
	 * @param predicate
	 *        the predicate
	 */
	public ExtensivePartitionNameLabelProvider(Predicate<EObject> predicate, ILabelProvider internal) {
		super();
		this.predicate = predicate;
		this.internal = internal;
	}

	public ExtensivePartitionNameLabelProvider(ILabelProvider internal) {
		super();
		this.predicate = null;
		this.internal = internal;
	}


	/**
	 * Sets the color.
	 *
	 * @param color
	 *        the new color
	 */
	public void setColor(Color color) {
		this.color = color;
	}


	/**
	 * Sets the font.
	 *
	 * @param font
	 *        the new font
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		String superText = internal.getText(element);
		EObject eObject = EMFHelper.getEObject(element);
		if(eObject != null) {
			String partitionName = getPartitionName(eObject);
			if(partitionName != null) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(partitionName);
				stringBuilder.append(superText);
				superText = stringBuilder.toString();
			}
		}
		return superText;
	}

	private static final String CLOSING_BRACKET = "] ";

	private static final String OPEN_BRACKET = "[";


	/**
	 * Gets the partition name.
	 *
	 * @param eObject
	 *        the e object
	 * @return the partition name
	 */
	protected String getPartitionName(EObject eObject) {
		Resource resource = eObject.eResource();
		if(resource != null) {
			URI uri = resource.getURI().trimFileExtension();
			String partitionName = uri.segment(uri.segmentCount() - 1);
			StringBuilder builder = new StringBuilder(OPEN_BRACKET);
			builder.append(partitionName);
			builder.append(CLOSING_BRACKET);
			return builder.toString();
		}
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider#getFont(java.lang.Object)
	 */
	@Override
	public Font getFont(Object element) {
		if(predicate != null) {
			EObject eObject = EMFHelper.getEObject(element);
			if(eObject != null) {
				if(font != null) {
					if(predicate.apply(eObject)) {
						return font;
					}
				}
			}
		}
		if(internal instanceof IFontProvider) {
			return ((IFontProvider)internal).getFont(element);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider#getForeground(java.lang.Object)
	 */
	@Override
	public Color getForeground(Object element) {
		if(predicate != null) {
			EObject eObject = EMFHelper.getEObject(element);
			if(eObject != null) {
				if(color != null) {
					if(predicate.apply(eObject)) {
						return color;
					}
				}
			}
		}
		if(internal instanceof IColorProvider) {
			return ((IColorProvider)internal).getForeground(element);
		}
		return null;
	}


	@Override
	public void addListener(ILabelProviderListener listener) {
		internal.addListener(listener);

	}


	@Override
	public void dispose() {
		internal.dispose();

	}


	@Override
	public boolean isLabelProperty(Object element, String property) {
		return internal.isLabelProperty(element, property);
	}


	@Override
	public void removeListener(ILabelProviderListener listener) {
		internal.removeListener(listener);

	}


	@Override
	public Image getImage(Object element) {
		return internal.getImage(element);
	}


	@Override
	public Color getBackground(Object element) {
		if(internal instanceof IColorProvider) {
			return ((IColorProvider)internal).getBackground(element);
		}
		return null;
	}
}
