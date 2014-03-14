/**
 *  Copyright (c) 2011, 2012, 2013 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Nicolas Bros (Mia-Software) - Bug 372198 - resource leak in org.eclipse.papyrus.emf.facet.custom.ui.internal.CustomizedLabelProvider
 *      Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Nicolas Bros (Mia-Software) - Bug 374941 - To be able to customize overlay icons on EClass
 *      Gregoire Dupe (Mia-Software) - Bug 374941 - To be able to customize overlay icons on EClass
 *      Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *      Vincent Lorenzo (CEA-LIST) - Bug 352603 - [Table] A tooltip which displays the full label of a String cell editor
 *      Grégoire Dupé(Mia-Software) - Bug 352603 - [Table] A tooltip which displays the full label of a String cell editor
 *      David Couvrand (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 *  	Nicolas Rault (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 *      David Couvrand (Soft-Maint) - Bug 418418 - [Customization] Overlay icons not implemented
 *      David Couvrand (Soft-Maint) - Bug 422058 - Implementation of strikethrough and underline in the CustomizedLabelProvider
 *      Grégoire Dupé (Mia-Software) - Bug 424122 - [Table] Images, fonts and colors are not shared between the instances of table
 *      Thomas Cicognani (Soft-Maint) - Bug 424414 - ImageManager doesn't cache images
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomOverride;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedLabelProvider;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.util.core.DebugUtils;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.swt.colorprovider.IColorProvider;
import org.eclipse.papyrus.emf.facet.util.swt.colorprovider.IColorProviderFactory;
import org.eclipse.papyrus.emf.facet.util.swt.fontprovider.IFontProvider;
import org.eclipse.papyrus.emf.facet.util.swt.fontprovider.IFontProviderFactory;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.exception.CustomizationException;
import org.eclipse.papyrus.emf.facet.custom.core.internal.exported.CustomizationUtils;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CustomizedLabelProvider extends CellLabelProvider implements
		ICustomizedLabelProvider, IStyledLabelProvider {

	private static final boolean DEBUG_FONT = DebugUtils.getDebugStatus(Activator.getDefault(), "font"); //$NON-NLS-1$
	private static final boolean DEBUG_COLOR = DebugUtils.getDebugStatus(Activator.getDefault(), "color"); //$NON-NLS-1$
	private static final int RGB_MAX = 255;
	private static final RGB DEFAULT_BCKGND = new RGB(
			CustomizedLabelProvider.RGB_MAX, CustomizedLabelProvider.RGB_MAX,
			CustomizedLabelProvider.RGB_MAX);
	private static final RGB DEFAULT_FOREGND = new RGB(0, 0, 0);
	private final ICustomizationManager customManager;
	private final PropertiesHandler propertiesHandler;
	private final List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();
	private final ImageManager imageManager;
	private final ICustomOverride customOverride;

	@Deprecated
	public CustomizedLabelProvider(final ResourceSet resourceSet) {
		this(ICustomizationManagerFactory.DEFAULT
				.getOrCreateICustomizationManager(resourceSet));
	}

	public CustomizedLabelProvider(final ICustomizationManager customManager) {
		super();
		this.customManager = customManager;
		this.propertiesHandler = new PropertiesHandler(customManager);
		this.imageManager = new ImageManager();
		this.customOverride = getICustomOverride();
	}

	private <T> T getPropertyValue(final Object element,
			final FacetOperation property, final ETypedElement eTypedElement, final Class<T> classs) {
		return CustomizationUtils.getPropertyValue(this.customManager, element,
				property, eTypedElement, classs);
	}

	public String getText(final Object element) {
		String result;
		if (element instanceof EObject) {
			result = getPropertyValue(element,
					this.propertiesHandler.getLabelProperty(), null, String.class);
		} else if (element == null) {
			result = Messages.CustomizedLabelProvider_null;
		} else if (element instanceof List<?>) {
			// Here we do not add any square brackets because the square
			// brackets are useful to emphases the sublists and here we will non
			// meet any sublists.
			final StringBuffer strBuffer = new StringBuffer();
			final List<?> list = (List<?>) element;
			final Iterator<?> iter = list.iterator();
			while (iter.hasNext()) {
				final Object current = iter.next();
				strBuffer.append(getText(current));
				if (iter.hasNext()) {
					strBuffer.append(", "); //$NON-NLS-1$
				}
			}
			result = strBuffer.toString();
		} else {
			result = element.toString();
		}
		if (this.customOverride != null) {
			try {
				result = this.customOverride.getText(result, element,
						this.customManager, this.propertiesHandler);
			} catch (final CustomizationException e) {
				result = "ERROR, cf. log"; //$NON-NLS-1$
				Logger.logError(e, Activator.getDefault());
			}
		}
		return result;
	}

	private static ICustomOverride getICustomOverride() {
		final Bundle bundle = Activator.getDefault().getBundle();
		final BundleContext bundleContext = bundle.getBundleContext();
		final ServiceReference serviceReference = bundleContext
				.getServiceReference(ICustomOverride.class.getName());
		final ICustomOverride customOverride = (ICustomOverride) bundleContext
				.getService(serviceReference);
		return customOverride;
	}

	public String getText(final Object object, final ETypedElement eTypedElement) {
		String result;
		if (object == null) {
			result = Messages.CustomizedLabelProvider_null;
		} else {
			if (object instanceof EObject) {
				final EObject eObject = (EObject) object;
				try {
					result = this.customManager.getCustomValueOf(eObject,
							eTypedElement,
							this.propertiesHandler.getLabelProperty(),
							String.class);
				} catch (CustomizationException e) {
					Logger.logError(e, Activator.getDefault());
					result = "!!! Error, cf log !!!";
				}
			} else {
				result = object.toString();
			}

		} 
		return result;
		
//TODO Remove before to commit
//		if (structuralFeature.getUpperBound() == 1) {
//			final Object object = this.customManager.getFacetManager().get(eObject,
//					structuralFeature, Object.class);
//			result = getText(object);
//		} else {
//			final StringBuffer stringBuffer = new StringBuffer();
//			final List<Object> objects = this.customManager.getFacetManager()
//					.getMultiValued(eObject, structuralFeature, Object.class);
//			final Iterator<Object> objectsIter = objects.iterator();
//			while (objectsIter.hasNext()) {
//				final Object object = objectsIter.next();
//				stringBuffer.append(this.getText(object));
//				if (objectsIter.hasNext()) {
//					stringBuffer.append(", ");
//				}
//			}
//			result = stringBuffer.toString();
//		}
//TODO (end)
	}
	
	@Override
	public void addListener(final ILabelProviderListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void dispose() {
		this.listeners.clear();
	}

	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		return false;
	}

	@Override
	public void removeListener(final ILabelProviderListener listener) {
		this.listeners.remove(listener);
	}
	
	private static Color getColor(final RGB rgb) {
		final Display display = Display.getDefault();
		final IColorProvider colorProvider = IColorProviderFactory.DEFAULT
				.getOrCreateIColorProvider(display);
		return colorProvider.getColor(rgb);
	}

	public Color getForeground(final Object element) {
		final IColor color = getPropertyValue(element,
				this.propertiesHandler.getForegroundProperty(),
				null, IColor.class);
		Color result;
		if (color == null) {
			result = getColor(CustomizedLabelProvider.DEFAULT_FOREGND);
		} else {
			result = getColor(new RGB(color.getRed(), color.getGreen(),
					color.getBlue()));
		}
		return result;
	}

	public Color getBackground(final Object element) {
		final IColor color = getPropertyValue(element,
				this.propertiesHandler.getBackgroundProperty(), null, IColor.class);
		Color result;
		if (color == null) {
			result = getColor(CustomizedLabelProvider.DEFAULT_BCKGND);
		} else {
			result = getColor(new RGB(color.getRed(), color.getGreen(),
					color.getBlue()));
		}
		return result;
	}

	private Font getFont(final FontData fontData) {
		final IFontProvider fontProvider = IFontProviderFactory.DEFAULT
				.getOrCreateIFontProvider(Display.getDefault());
		return fontProvider.getFont(fontData);
	}
	
	public Font getFont(final Object element) {

		String fontName = getPropertyValue(element,
				this.propertiesHandler.getFontNameProperty(), null, String.class);
		if (fontName == null) {
			final FontData[] fontData = Display.getDefault().getSystemFont()
					.getFontData();
			fontName = fontData[0].getName();
		}

		Integer fontSize = getPropertyValue(element,
				this.propertiesHandler.getFontSizeProperty(), null, Integer.class);
		if (fontSize == null) {
			final FontData[] fontData = Display.getDefault().getSystemFont()
					.getFontData();
			fontSize = Integer.valueOf(fontData[0].getHeight());
		}

		Boolean isBold = getPropertyValue(element,
				this.propertiesHandler.getIsBoldProperty(), null, Boolean.class);
		if (isBold == null) {
			isBold = Boolean.FALSE;
		}

		Boolean isItalic = getPropertyValue(element,
				this.propertiesHandler.getIsItalicProperty(), null, Boolean.class);
		if (isItalic == null) {
			isItalic = Boolean.FALSE;
		}

		int fontStyle = 0;
		if (isBold.booleanValue()) {
			fontStyle = fontStyle | SWT.BOLD;
		}
		if (isItalic.booleanValue()) {
			fontStyle = fontStyle | SWT.ITALIC;
		}
		FontData fontData = new FontData(fontName, fontSize.intValue(),
				fontStyle);
		try {
			fontData = this.customOverride.getFont(fontData, element,
					this.customManager, this.propertiesHandler);
		} catch (final CustomizationException e) {
			Logger.logError(e, Activator.getDefault());
		}
		return getFont(fontData);
	}

	public Image getImage(final Object element) {
		final IImage image = getPropertyValue(element,
				this.propertiesHandler.getImageProperty(), null, IImage.class);
		return this.imageManager.getImage(image);
	}

	public Image getImage(final Object element, final ETypedElement featureColumn) {
		return getImage(element, this.propertiesHandler.getImageProperty(), featureColumn);
	}

	public ICustomizationManager getCustomizationManager() {
		return this.customManager;
	}

	public boolean isUnderlined(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getIsUnderlinedProperty(), null, Boolean.class).booleanValue();
	}

	public boolean isStruckthrough(final Object element,
			final ETypedElement eTypedElement) {
		final Boolean propertyValue = getPropertyValue(element,
				this.propertiesHandler.getIsStruckthroughProperty(),
				eTypedElement, Boolean.class);
		boolean result = false;
		if (propertyValue != null) {
			result = propertyValue.booleanValue();
		}
		return result;
	}
	
	private Image getImage(final Object element, final FacetOperation operation, final ETypedElement feature) {
		final IImage iimage = getPropertyValue(element, operation, feature,
				IImage.class);
		return this.imageManager.getImage(iimage);
	}

	public Image getTopLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getImage(element, this.propertiesHandler.getTopLeftOverlayProperty(), eTypedElement);
	}

	public Image getTopMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getImage(element, this.propertiesHandler.getTopMiddleOverlayProperty(), eTypedElement);
	}

	public Image getTopRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getImage(element, this.propertiesHandler.getTopRightOverlayProperty(), eTypedElement);
	}

	public Image getBottomLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getImage(element, this.propertiesHandler.getBottomLeftOverlayProperty(), eTypedElement);
	}

	public Image getBottomMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getImage(element, this.propertiesHandler.getBottomMiddleOverlayProperty(), eTypedElement);
	}

	public Image getBottomRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getImage(element, this.propertiesHandler.getBottomRightOverlayProperty(), eTypedElement);
	}


	@Override
	public String getToolTipText(final Object element) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipTextProperty(), null, String.class);
	}
	
	@Override
	public int getToolTipStyle(final Object element) {
		int style = 0;
		final Shadow shadow = getPropertyValue(element,
				this.propertiesHandler.getToolTipShadowProperty(), null,
				Shadow.class);
		switch (shadow) {
		case NONE : 
			style = SWT.SHADOW_NONE;
			break;
		case IN :
			style = SWT.SHADOW_IN;
			break;
		case OUT:
			style = SWT.SHADOW_OUT;
			break;
		default:
			throw new IllegalStateException("Un expected value"); //$NON-NLS-1$
		}
		
		final Alignment alignment = getPropertyValue(element,
				this.propertiesHandler.getToolTipAlignmentProperty(), null,
				Alignment.class);
		switch (alignment) {
		case LEFT:
			style |= SWT.LEFT;
			break;
		case CENTER:
			style |= SWT.CENTER;
			break;
		case RIGHT:
			style |= SWT.RIGHT;
			break;
		default:
			throw new IllegalStateException("Un expected value"); //$NON-NLS-1$
		}
		
		return style;
	}
	
	@Override
	public Image getToolTipImage(final Object element) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipImageProperty(), null, Image.class);
	}
	
	@Override
	public Color getToolTipBackgroundColor(final Object element) {
		final IColor color = getPropertyValue(element,
				this.propertiesHandler.getToolTipBackgroundProperty(),
				null, IColor.class);
		return getColor(new RGB(color.getRed(), color.getGreen(), color.getBlue()));
	}
	
	@Override
	public Color getToolTipForegroundColor(final Object element) {
		final IColor color = getPropertyValue(element,
				this.propertiesHandler.getToolTipForegroundProperty(),
				null, IColor.class);
		return getColor(new RGB(color.getRed(), color.getGreen(), color.getBlue()));
	}

	public Image getToolTipTopLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipTopLeftOverlayProperty(),
				null, Image.class);
	}

	public Image getToolTipTopMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipTopMiddleOverlayProperty(),
				null, Image.class);
	}

	public Image getToolTipTopRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipTopRightOverlayProperty(),
				null, Image.class);
	}

	public Image getToolTipBottomLeftOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipBottomLeftOverlayProperty(),
				null, Image.class);
	}

	public Image getToolTipBottomMiddleOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipBottomMiddleOverlayProperty(),
				null, Image.class);
	}

	public Image getToolTipBottomRightOverlay(final Object element,
			final ETypedElement eTypedElement) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipBottomRightOverlayProperty(),
				null, Image.class);
	}

	@Override
	public int getToolTipDisplayDelayTime(final Object element) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipDisplayDelayTimeProperty(),
				null, Integer.class).intValue();
	}

	@Override
	public int getToolTipTimeDisplayed(final Object element) {
		return getPropertyValue(element,
				this.propertiesHandler.getToolTipTimeDisplayedProperty(), null,
				Integer.class).intValue();
		
	}

	@Override
	public Font getToolTipFont(final Object element) {

		final String fontName = getPropertyValue(element,
				this.propertiesHandler.getToolTipFontNameProperty(), null,
				String.class);
		final Integer fontSize = getPropertyValue(element,
				this.propertiesHandler.getToolTipFontSizeProperty(), null,
				Integer.class);
		final Boolean isBold = getPropertyValue(element,
				this.propertiesHandler.getToolTipIsBoldProperty(), null,
				Boolean.class);
		final Boolean isItalic = getPropertyValue(element,
				this.propertiesHandler.getToolTipIsItalicProperty(), null,
				Boolean.class);
		int fontStyle = 0;
		if (isBold.booleanValue()) {
			fontStyle = fontStyle | SWT.BOLD;
		}
		if (isItalic.booleanValue()) {
			fontStyle = fontStyle | SWT.ITALIC;
		}
		final FontData fontData = new FontData(fontName, fontSize.intValue(),
				fontStyle);
		final IFontProvider fontProvider = IFontProviderFactory.DEFAULT
				.getOrCreateIFontProvider(Display.getDefault());
		return fontProvider.getFont(fontData);
	}

	@Override
	public void update(final ViewerCell cell) {
		final Object element = cell.getElement();
		cell.setText(getText(element));
		cell.setBackground(getBackground(element));
		cell.setFont(getFont(element));
		cell.setForeground(getForeground(element));
		cell.setImage(getImage(element));
	}

	public String getToolTipText(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getToolTipImage(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Font getToolTipFont(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getToolTipBackgroundColor(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getToolTipForegroundColor(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getToolTipTimeDisplayed(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getToolTipDisplayDelayTime(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getToolTipStyle(final Object element,
			final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ICustomizedLabelProvider cloneLabelProvider() {
		return new CustomizedLabelProvider(this.customManager);
	}

	public StyledString getStyledText(final Object element) {
		return new StyledString(getText(element));
	}

}
