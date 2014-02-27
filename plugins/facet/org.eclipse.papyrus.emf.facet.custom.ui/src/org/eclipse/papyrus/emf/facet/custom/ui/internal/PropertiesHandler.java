/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *      Gregoire Dupe (Mia-Software) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Nicolas Bros (Mia-Software) - Bug 377866 - selection customization
 *      David Couvrand (Soft-Maint) - Bug 422058 - Implementation of strikethrough and underline in the CustomizedLabelProvider
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.custom.ui.IContentPropertiesHandler;
import org.eclipse.papyrus.emf.facet.custom.ui.IFontPropertiesHandler;
import org.eclipse.papyrus.emf.facet.custom.ui.ISelectionPropertiesHandler;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.ILabelPropertiesHandler;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;

public class PropertiesHandler implements IContentPropertiesHandler,
		ILabelPropertiesHandler, ISelectionPropertiesHandler, IFontPropertiesHandler {
	private static final String SEPARATOR = "::"; //$NON-NLS-1$
	private static final String CUSTOM_PROPERTIES = "resources/customproperties.efacet"; //$NON-NLS-1$
	
	private static final String CUSTOM = "CustomizedEObject"; //$NON-NLS-1$
	private static final String TT_CUSTOM = "CustomizedToolTipEObject"; //$NON-NLS-1$
	
	private static final String IMAGE = "image"; //$NON-NLS-1$
	private static final String LABEL = "label"; //$NON-NLS-1$
	private static final String BACKGROUND = "background"; //$NON-NLS-1$
	private static final String FOREGROUND = "foreground"; //$NON-NLS-1$
	private static final String FONT = "fontName"; //$NON-NLS-1$
	private static final String FONT_SIZE = "fontSize"; //$NON-NLS-1$
	private static final String IS_BOLD = "isBold"; //$NON-NLS-1$
	private static final String IS_ITALIC = "isItalic"; //$NON-NLS-1$
	private static final String COLLAPSE_LINK = "collapseLink"; //$NON-NLS-1$
	private static final String IS_VISIBLE = "isVisible"; //$NON-NLS-1$
	private static final String IS_UNDERLINED = "isUnderlined"; //$NON-NLS-1$
	private static final String IS_STRUCKTHROUGH = "isStruckthrough"; //$NON-NLS-1$
	private static final String TOP_L_OVERLAY = "topLeftOverlay"; //$NON-NLS-1$
	private static final String TOP_M_OVERLAY = "topMiddleOverlay"; //$NON-NLS-1$
	private static final String TOP_R_OVERLAY = "topRightOverlay"; //$NON-NLS-1$
	private static final String BOTTOM_L_OVERLAY = "bottomLeftOverlay"; //$NON-NLS-1$
	private static final String BOTTOM_M_OVERLAY = "bottomMiddleOverlay"; //$NON-NLS-1$
	private static final String BOTTOM_R_OVERLAY = "bottomRightOverlay"; //$NON-NLS-1$
	private static final String SELECTION = "selection"; //$NON-NLS-1$
	
	//for tooltips
	private static final String TEXT = "text"; //$NON-NLS-1$
	private static final String TIME_DISPLAYED = "timeDisplayed"; //$NON-NLS-1$
	private static final String DISPLAY_DELAY = "displayDelayTime"; //$NON-NLS-1$
	private static final String SHADOW = "shadow"; //$NON-NLS-1$
	private static final String ALIGNMENT = "alignment"; //$NON-NLS-1$
		
	private final Resource resource;
	private final Map<String, FacetOperation> map = new HashMap<String, FacetOperation>();

	/**
	 * 
	 * @deprecated Must be replaced by
	 *             org.eclipse.papyrus.emf.facet.custom.ui.internal.PropertiesHandler
	 *             .PropertiesHandler(ICustomizationManager)
	 */
	@Deprecated
	public PropertiesHandler(final ResourceSet resourceSet) {
		final String bundleName = Activator.getDefault().getBundle().getSymbolicName();
		URI propertiesUri = URI.createPlatformPluginURI(bundleName, true);
		propertiesUri = propertiesUri
				.appendSegments(PropertiesHandler.CUSTOM_PROPERTIES.split("/")); //$NON-NLS-1$
		this.resource = resourceSet.getResource(propertiesUri, true);
	}
	
	public PropertiesHandler(final ICustomizationManager customizationMgr) {
		final String bundleName = Activator.getDefault().getBundle().getSymbolicName();
		URI propertiesUri = URI.createPlatformPluginURI(bundleName, true);
		propertiesUri = propertiesUri
				.appendSegments(PropertiesHandler.CUSTOM_PROPERTIES.split("/")); //$NON-NLS-1$
		final ResourceSet resourceSet = customizationMgr.getResourceSet();
		this.resource = resourceSet.getResource(propertiesUri, true);
		final FacetSet facetSet = (FacetSet) this.resource.getContents().get(0);
		customizationMgr.getFacetManager().getManagedFacetSets()
				.add(0, facetSet);
	}

	private FacetOperation getPropertyByName(final String facetName,
			final String propertyName) {
		final String key = facetName + PropertiesHandler.SEPARATOR + propertyName;
		FacetOperation result = this.map.get(key);
		if (result == null) {
			final FacetSet facetSet = (FacetSet) this.resource.getContents()
					.get(0);
			final Facet facet = FacetUtils.getFacet(
					FacetUtils.getFacets(facetSet),
					facetName);
			final ETypedElement eTypedElement = FacetUtils
					.getETypedElement(facet, propertyName,
							ETypedElement.class);
			if (eTypedElement instanceof FacetOperation) {
				result = (FacetOperation) eTypedElement;
				this.map.put(key, result);
			}
		}
		return result;
	}
	
	public FacetOperation getImageProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.IMAGE);
	}

	
	public FacetOperation getCollapseLink() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.COLLAPSE_LINK);
	}
	public FacetOperation getLabelProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.LABEL);
	}

	public FacetOperation getBackgroundProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.BACKGROUND);
	}

	public FacetOperation getForegroundProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.FOREGROUND);
	}

	public FacetOperation getFontNameProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.FONT);
	}

	public FacetOperation getFontSizeProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.FONT_SIZE);
	}

	public FacetOperation getIsBoldProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.IS_BOLD);
	}

	public FacetOperation getIsItalicProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.IS_ITALIC);
	}

	public FacetOperation getIsVisible() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.IS_VISIBLE);
	}

	public FacetOperation getIsUnderlinedProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.IS_UNDERLINED);
	}

	public FacetOperation getIsStruckthroughProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.IS_STRUCKTHROUGH);
	}

	public FacetOperation getTopLeftOverlayProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.TOP_L_OVERLAY);
	}

	public FacetOperation getTopMiddleOverlayProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.TOP_M_OVERLAY);
	}

	public FacetOperation getTopRightOverlayProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.TOP_R_OVERLAY);
	}

	public FacetOperation getBottomLeftOverlayProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.BOTTOM_L_OVERLAY);
	}

	public FacetOperation getBottomMiddleOverlayProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.BOTTOM_M_OVERLAY);
	}

	public FacetOperation getBottomRightOverlayProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.BOTTOM_R_OVERLAY);
	}
	
	public FacetOperation getSelectionProperty() {
		return getPropertyByName(PropertiesHandler.CUSTOM,
				PropertiesHandler.SELECTION);
	}

	// methods for tooltips
	public FacetOperation getToolTipTextProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.TEXT);
	}

	public FacetOperation getToolTipImageProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.IMAGE);
	}

	public FacetOperation getToolTipFontNameProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.FONT);
	}

	public FacetOperation getToolTipFontSizeProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.FONT_SIZE);
	}

	public FacetOperation getToolTipIsBoldProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.IS_BOLD);
	}

	public FacetOperation getToolTipIsItalicProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.IS_ITALIC);
	}

	public FacetOperation getToolTipBackgroundProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.BACKGROUND);
	}

	public FacetOperation getToolTipForegroundProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.FOREGROUND);
	}

	public FacetOperation getToolTipTopLeftOverlayProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.TOP_L_OVERLAY);
	}

	public FacetOperation getToolTipTopMiddleOverlayProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.TOP_M_OVERLAY);
	}

	public FacetOperation getToolTipTopRightOverlayProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.TOP_R_OVERLAY);
	}

	public FacetOperation getToolTipBottomLeftOverlayProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.BOTTOM_L_OVERLAY);
	}

	public FacetOperation getToolTipBottomMiddleOverlayProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.BOTTOM_M_OVERLAY);
	}

	public FacetOperation getToolTipBottomRightOverlayProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.BOTTOM_R_OVERLAY);
	}

	public FacetOperation getToolTipTimeDisplayedProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.TIME_DISPLAYED);
	}

	public FacetOperation getToolTipDisplayDelayTimeProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.DISPLAY_DELAY);
	}

	public FacetOperation getToolTipAlignmentProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.ALIGNMENT);
	}

	public FacetOperation getToolTipShadowProperty() {
		return getPropertyByName(PropertiesHandler.TT_CUSTOM,
				PropertiesHandler.SHADOW);
	}
}