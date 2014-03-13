/*******************************************************************************
 * Copyright (c) 2008, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Vincent Lorenzo (CEA-LIST) - bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *******************************************************************************/

package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.presentation;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/** A singleton image provider, which caches image descriptors */
public final class ImageProvider {

	private ImageProvider() {
		// This class must only be instantiated by getInstance().
	}

	private static ImageProvider instance;

	public static ImageProvider getInstance() {
		if (ImageProvider.instance == null) {
			ImageProvider.instance = new ImageProvider();
		}
		return ImageProvider.instance;
	}

	private Image linkIcon = null;
	private Image linkUniDirIcon = null;
	private Image linkFacetIcon = null;
	private Image aggregIcon = null;
	private Image aggregUniDirIcon = null;
	private Image invAggregIcon = null;

	private Image emptyLinksIcon = null;
	// private Image sortInstancesIcon = null;
	private Image sortLinksIcon = null;
	private Image sortLinksByTypeIcon = null;
	// private Image sortNumericallyIcon = null;
	private Image showDerivedLinksIcon = null;
	private Image showFullQualifiedNamesIcon = null;
	private Image showMultiplicityIcon = null;
	private Image showOppositeLinksIcon = null;

	private Image rangeIcon = null;
	private Image containerIcon = null;
	// private Image emptyMetaclassesIcon = null;
	private Image packageIcon = null;
	// private Image derivedInstancesIcon = null;
	// private Image derivationTreeIcon = null;
	private Image attributeIcon = null;
	private Image attributeFacetIcon = null;
	private Image emptyAttributeIcon = null;
	private Image orderingIcon = null;
	private Image linkTypeIcon = null;

	private Image facetIcon = null;
	private Image viewMenuIcon = null;

	private ImageDescriptor increaseFontSizeIcon = null;
	private ImageDescriptor decreaseFontSizeIcon = null;
	private ImageDescriptor restoreFontSizeIcon = null;

	private Image hideEmptyColumnsIcon = null;
	private Image commonColumnsIcon = null;
	private Image eClassIcon = null;
	private Image operationIcon = null;
	private Image predicateIcon = null;
	private Image emffacetIcon = null;
	private Image featureIcon = null;
	private Image errorIcon = null;
	private Image queryIcon = null;
	private Image uiCustomIcon = null;
	private Image grayedUiCustomIcon=null;
	private Image uriIcon = null;
	
	private Image shortcutIcon = null;
	
	private Image topLeftOverlay = null;
	private Image topMiddleOverlay = null;
	private Image topRightOverlay = null;
	private Image middleLeftOverlay = null;
	private Image middleRightOverlay = null;
	private Image bottomLeftOverlay = null;
	private Image bottomMiddleOverlay = null;
	private Image bottomRightOverlay = null;
	private Image customizationLabel = null;
	private Image customizationImage = null;
	private Image rgb = null;
	private Image fontName = null;
	private Image fontSize = null;
	private Image isBold = null;
	private Image isItalic = null;
	private Image isUnderlined = null;
	private Image isStruckthrough = null;
	

	private static final String LINK_ICON_PATH = "/icons/full/ctool16/link.gif"; //$NON-NLS-1$
	private static final String LINK_UNIDIR_ICON_PATH = "/icons/full/ctool16/link_unidir.gif"; //$NON-NLS-1$
	private static final String LINK_FACET_ICON_PATH = "/icons/full/ctool16/link_unidir_facet.gif"; //$NON-NLS-1$
	private static final String AGGREG_ICON_PATH = "/icons/full/ctool16/aggreg.gif"; //$NON-NLS-1$
	private static final String AGGREG_UNIDIR_ICON_PATH = "/icons/full/ctool16/aggreg_unidir.gif"; //$NON-NLS-1$
	private static final String INV_AGGREG_ICON_PATH = "/icons/full/ctool16/inv_aggreg.gif"; //$NON-NLS-1$
	private static final String EMPTY_LINKS_ICON_PATH = "/icons/full/ctool16/empty_links.gif"; //$NON-NLS-1$
	private static final String SORT_INSTANCES_ICON_PATH = "/icons/full/ctool16/sort.gif"; //$NON-NLS-1$
	private static final String SORT_LINKS_ICON_PATH = "/icons/full/ctool16/sort_links.gif"; //$NON-NLS-1$
	private static final String SORT_LINKS_BY_TYPE_ICON_PATH = "/icons/full/ctool16/sort_links_by_type.gif"; //$NON-NLS-1$
	private static final String SORT_NUMERICALLY_ICON_PATH = "/icons/full/ctool16/sort_num.gif"; //$NON-NLS-1$
	private static final String SHOW_DERIVED_LINKS_ICON_PATH = "/icons/full/ctool16/derived.gif"; //$NON-NLS-1$
	private static final String SHOW_FULL_QUALIFIED_NAMES_ICON_PATH = "/icons/full/ctool16/full_name.gif"; //$NON-NLS-1$
	private static final String RANGE_ICON_PATH = "/icons/full/ctool16/range.gif"; //$NON-NLS-1$
	private static final String SHOW_MULTIPLICITY_ICON_PATH = "/icons/full/ctool16/multiplicity.gif"; //$NON-NLS-1$
	private static final String SHOW_OPPOSITE_LINKS_ICON_PATH = "/icons/full/ctool16/opposite_links.gif"; //$NON-NLS-1$
	private static final String CONTAINER_ICON_PATH = "/icons/full/ctool16/container.gif"; //$NON-NLS-1$
	private static final String EMPTY_METACLASSES_ICON_PATH = "/icons/full/ctool16/zero.gif"; //$NON-NLS-1$
	private static final String PACKAGE_ICON_PATH = "/icons/full/ctool16/package.gif"; //$NON-NLS-1$
	private static final String DERIVED_INSTANCES_ICON_PATH = "/icons/full/ctool16/derived_instances.gif"; //$NON-NLS-1$
	private static final String DERIVATION_TREE_ICON_PATH = "/icons/full/ctool16/derivation_tree.gif"; //$NON-NLS-1$
	private static final String ATTRIBUTE_ICON_PATH = "/icons/full/ctool16/attributes.gif"; //$NON-NLS-1$
	private static final String ATTRIBUTE_FACET_ICON_PATH = "/icons/full/ctool16/attribute_facet.gif"; //$NON-NLS-1$
	private static final String EMPTY_ATTRIBUTE_ICON_PATH = "/icons/full/ctool16/empty_attributes.gif"; //$NON-NLS-1$
	private static final String INCREASE_FONT_SIZE_ICON_PATH = "/icons/full/ctool16/increase_font_size.gif"; //$NON-NLS-1$
	private static final String DECREASE_FONT_SIZE_ICON_PATH = "/icons/full/ctool16/decrease_font_size.gif"; //$NON-NLS-1$
	private static final String RESTORE_FONT_SIZE_ICON_PATH = "/icons/full/ctool16/restore_font_size.gif"; //$NON-NLS-1$
	private static final String HIDE_EMPTY_COLUMNS_ICON_PATH = "/icons/full/ctool16/non-zero.gif"; //$NON-NLS-1$
	private static final String COMMON_COLUMNS_ICON_PATH = "/icons/full/ctool16/common_columns.gif"; //$NON-NLS-1$
	private static final String ORDERING_ICON_PATH = "/icons/full/ctool16/ordering.gif"; //$NON-NLS-1$
	private static final String ECLASS_ICON_PATH = "/icons/full/ctool16/eClass.gif"; //$NON-NLS-1$
	private static final String OPERATION_ICON_PATH = "/icons/full/ctool16/operation.gif"; //$NON-NLS-1$
	private static final String PREDICATE_ICON_PATH = "/icons/full/ctool16/predicate.gif"; //$NON-NLS-1$
	private static final String EMFFACET_ICON_PATH = "icons/logoEmfFacetMini.gif"; //$NON-NLS-1$
	private static final String FEATURE_ICON_PATH = "icons/full/ctool16/feature.gif"; //$NON-NLS-1$
	private static final String ERROR_ICON_PATH = "icons/error.gif"; //$NON-NLS-1$
	private static final String FACET_ICON_PATH = "icons/Facet.gif"; //$NON-NLS-1$
	private static final String ADD_UI_CUSTOM_ICON_PATH = "icons/full/ctool16/addUiCustom.gif"; //$NON-NLS-1$
	private static final String VIEW_MENU_ICON_PATH = "icons/full/ctool16/view_menu.gif"; //$NON-NLS-1$
	private static final String LINK_TYPE_ICON_PATH = "icons/full/ctool16/link_type.gif"; //$NON-NLS-1$
	private static final String QUERY_ICON_PATH = "icons/query.png"; //$NON-NLS-1$
	private static final String ELEMENT_IDS_ICON_PATH = "/icons/full/ctool16/element_id.gif"; //$NON-NLS-1$
	private static final String URI_ICON_PATH = "/icons/full/ctool16/uri.gif"; //$NON-NLS-1$
	private static final String COLLAPSE_ALL_ICON_PATH = "/icons/full/ctool16/collapseall.gif"; //$NON-NLS-1$
	private static final String SHORTCUT_ICON_PATH = "/icons/shortcut.png"; //$NON-NLS-1$

	//Customization
	private static final String TOP_LEFT_OVERLAY_ICON_PATH = "/icons/full/ctool16/topLeftOverlay.png";
	private static final String TOP_MIDDLE_OVERLAY_ICON_PATH = "/icons/full/ctool16/topMiddleOverlay.png";
	private static final String TOP_RIGHT_OVERLAY_ICON_PATH = "/icons/full/ctool16/topRightOverlay.png";
	private static final String MIDDLE_LEFT_OVERLAY_ICON_PATH = "/icons/full/ctool16/middleLeftOverlay.png";
	private static final String MIDDLE_RIGHT_OVERLAY_ICON_PATH = "/icons/full/ctool16/middleRightOverlay.png";
	private static final String BOTTOM_LEFT_OVERLAY_ICON_PATH = "/icons/full/ctool16/bottomLeftOverlay.png";
	private static final String BOTTOM_MIDDLE_OVERLAY_ICON_PATH = "/icons/full/ctool16/bottomMiddleOverlay.png";
	private static final String BOTTOM_RIGHT_OVERLAY_ICON_PATH = "/icons/full/ctool16/bottomRightOverlay.png";
	private static final String LABEL_CUSTOMIZATION = "/icons/full/ctool16/customizationLabel.png";
	private static final String IMAGE_CUSTOMIZATION = "/icons/full/ctool16/imageCustomization.png";
	private static final String RGB_CUSTOMIZATION = "/icons/full/ctool16/rgb.png";
	private static final String FONT_NAME = "/icons/full/ctool16/fontName.png"; //$NON-NLS-1$
	private static final String FONT_SIZE = "/icons/full/ctool16/fontSize.png"; //$NON-NLS-1$
	private static final String IS_BOLD = "/icons/full/ctool16/fontBold.png"; //$NON-NLS-1$
	private static final String IS_ITALIC = "/icons/full/ctool16/fontItalic.bmp"; //$NON-NLS-1$
	private static final String IS_UNDERLINED = "/icons/full/ctool16/fontUnderline.bmp"; //$NON-NLS-1$
	private static final String IS_STRUCKTHROUGH = "/icons/full/ctool16/fontStrukethrough.bmp"; //$NON-NLS-1$

	/**
	 * Create an image descriptor from a resource
	 * 
	 * @param resourcePath
	 *            the path of the resource (in the bundle)
	 * @return the image descriptor
	 */
	private ImageDescriptor createImageDescriptor(final String resourcePath) {
		final URL url = Activator.getDefault().getBundle().getResource(resourcePath);
		if (url == null) {
			Logger.logError(NLS.bind("Resource not found: {0}", //$NON-NLS-1$
					resourcePath), Activator.getDefault());
			return ImageDescriptor.getMissingImageDescriptor();
		}
		return ImageDescriptor.createFromURL(url);
	}

	/** Return the icon representing a bidirectional link */
	public Image getLinkIcon() {
		if (this.linkIcon == null) {
			this.linkIcon = createImageDescriptor(ImageProvider.LINK_ICON_PATH).createImage();
		}
		return this.linkIcon;
	}

	/** Return the icon representing an unidirectional link */
	public Image getUnidirectionalLinkIcon() {
		if (this.linkUniDirIcon == null) {
			this.linkUniDirIcon = createImageDescriptor(ImageProvider.LINK_UNIDIR_ICON_PATH)
					.createImage();
		}
		return this.linkUniDirIcon;
	}

	/** Return the icon representing a facet reference */
	public Image getFacetLinkIcon() {
		if (this.linkFacetIcon == null) {
			this.linkFacetIcon = createImageDescriptor(ImageProvider.LINK_FACET_ICON_PATH)
					.createImage();
		}
		return this.linkFacetIcon;
	}

	/** Return the icon representing a composition link */
	public Image getAggregIcon() {
		if (this.aggregIcon == null) {
			this.aggregIcon = createImageDescriptor(ImageProvider.AGGREG_ICON_PATH).createImage();
		}
		return this.aggregIcon;
	}

	/** Return the icon representing an unidirectional composition link */
	public Image getUnidirectionalAggregIcon() {
		if (this.aggregUniDirIcon == null) {
			this.aggregUniDirIcon = createImageDescriptor(ImageProvider.AGGREG_UNIDIR_ICON_PATH)
					.createImage();
		}
		return this.aggregUniDirIcon;
	}

	/** Return the icon representing a reverse composition link */
	public Image getInvAggregIcon() {
		if (this.invAggregIcon == null) {
			this.invAggregIcon = createImageDescriptor(ImageProvider.INV_AGGREG_ICON_PATH)
					.createImage();
		}
		return this.invAggregIcon;
	}

	/** Return the icon representing empty links */
	public Image getEmptyLinksIcon() {
		if (this.emptyLinksIcon == null) {
			this.emptyLinksIcon = createImageDescriptor(ImageProvider.EMPTY_LINKS_ICON_PATH)
					.createImage();
		}
		return this.emptyLinksIcon;
	}

	/** Return the icon representing empty links */
	public ImageDescriptor getEmptyLinksImageDescriptor() {
		return createImageDescriptor(ImageProvider.EMPTY_LINKS_ICON_PATH);
	}

	/** Return the icon representing sorting of instances */
	public ImageDescriptor getSortInstancesIcon() {
		return createImageDescriptor(ImageProvider.SORT_INSTANCES_ICON_PATH);
	}

	/** Return the icon representing sorting of links */
	public Image getSortLinksIcon() {
		if (this.sortLinksIcon == null) {
			this.sortLinksIcon = createImageDescriptor(ImageProvider.SORT_LINKS_ICON_PATH)
					.createImage();
		}
		return this.sortLinksIcon;
	}

	/** Return the icon representing sorting of links */
	public ImageDescriptor getSortLinksImageDescriptor() {
		return createImageDescriptor(ImageProvider.SORT_LINKS_ICON_PATH);
	}

	/** Return the icon representing sorting of links by type */
	public Image getSortLinksByTypeIcon() {
		if (this.sortLinksByTypeIcon == null) {
			this.sortLinksByTypeIcon = createImageDescriptor(
					ImageProvider.SORT_LINKS_BY_TYPE_ICON_PATH).createImage();
		}
		return this.sortLinksByTypeIcon;
	}

	/** Return the icon representing sorting of links by type */
	public ImageDescriptor getSortLinksByTypeImageDescriptor() {
		return createImageDescriptor(ImageProvider.SORT_LINKS_BY_TYPE_ICON_PATH);
	}

	/** Return the icon representing sorting numerically */
	public ImageDescriptor getSortNumericallyIcon() {
		return createImageDescriptor(ImageProvider.SORT_NUMERICALLY_ICON_PATH);
	}

	/** Return the icon representing derived links */
	public Image getShowDerivedLinksIcon() {
		if (this.showDerivedLinksIcon == null) {
			this.showDerivedLinksIcon = createImageDescriptor(
					ImageProvider.SHOW_DERIVED_LINKS_ICON_PATH).createImage();
		}
		return this.showDerivedLinksIcon;
	}

	/** Return the icon representing derived links */
	public ImageDescriptor getShowDerivedLinksImageDescriptor() {
		return createImageDescriptor(ImageProvider.SHOW_DERIVED_LINKS_ICON_PATH);
	}

	/** Return the icon representing full qualified names */
	public Image getShowFullQualifiedNamesIcon() {
		if (this.showFullQualifiedNamesIcon == null) {
			this.showFullQualifiedNamesIcon = createImageDescriptor(
					ImageProvider.SHOW_FULL_QUALIFIED_NAMES_ICON_PATH).createImage();
		}
		return this.showFullQualifiedNamesIcon;
	}

	/** Return the icon representing full qualified names */
	public ImageDescriptor getShowFullQualifiedNamesImageDescriptor() {
		return createImageDescriptor(ImageProvider.SHOW_FULL_QUALIFIED_NAMES_ICON_PATH);
	}

	/** Return the icon representing a range */
	public Image getRangeIcon() {
		if (this.rangeIcon == null) {
			this.rangeIcon = createImageDescriptor(ImageProvider.RANGE_ICON_PATH).createImage();
		}
		return this.rangeIcon;
	}

	/** Return the multiplicity icon */
	public Image getShowMultiplicityIcon() {
		if (this.showMultiplicityIcon == null) {
			this.showMultiplicityIcon = createImageDescriptor(
					ImageProvider.SHOW_MULTIPLICITY_ICON_PATH).createImage();
		}
		return this.showMultiplicityIcon;
	}

	/** Return the multiplicity icon */
	public ImageDescriptor getShowMultiplicityImageDescriptor() {
		return createImageDescriptor(ImageProvider.SHOW_MULTIPLICITY_ICON_PATH);
	}

	/** Return the "opposite links" icon */
	public Image getShowOppositeLinksIcon() {
		if (this.showOppositeLinksIcon == null) {
			this.showOppositeLinksIcon = createImageDescriptor(
					ImageProvider.SHOW_OPPOSITE_LINKS_ICON_PATH).createImage();
		}
		return this.showOppositeLinksIcon;
	}

	/** Return the "opposite links" icon */
	public ImageDescriptor getShowOppositeLinksImageDescriptor() {
		return createImageDescriptor(ImageProvider.SHOW_OPPOSITE_LINKS_ICON_PATH);
	}

	/** Return the "container" icon */
	public Image getContainerIcon() {
		if (this.containerIcon == null) {
			this.containerIcon = createImageDescriptor(ImageProvider.CONTAINER_ICON_PATH)
					.createImage();
		}
		return this.containerIcon;
	}

	/** Return the "container" icon */
	public ImageDescriptor getContainerImageDescriptor() {
		return createImageDescriptor(ImageProvider.CONTAINER_ICON_PATH);
	}

	/** Return the "show empty metaclasses" icon */
	public ImageDescriptor getShowEmptyMetaclassesIcon() {
		return createImageDescriptor(ImageProvider.EMPTY_METACLASSES_ICON_PATH);
	}

	/** Return the "package" icon */
	public Image getPackageIcon() {
		if (this.packageIcon == null) {
			this.packageIcon = createImageDescriptor(ImageProvider.PACKAGE_ICON_PATH).createImage();
		}
		return this.packageIcon;
	}

	/** Return the "package" icon */
	public ImageDescriptor getPackageImageDescriptor() {
		return createImageDescriptor(ImageProvider.PACKAGE_ICON_PATH);
	}

	// /** Return the "derived instances" icon */
	// public Image getDerivedInstancesIcon() {
	// if (this.derivedInstancesIcon == null) {
	// this.derivedInstancesIcon = createImageDescriptor(
	// ImageProvider.DERIVED_INSTANCES_ICON_PATH).createImage();
	// }
	// return this.derivedInstancesIcon;
	// }

	/** Return the "derived instances" icon */
	public ImageDescriptor getDerivedInstancesImageDescriptor() {
		return createImageDescriptor(ImageProvider.DERIVED_INSTANCES_ICON_PATH);
	}

	/** Return the "derivation tree" icon */
	public ImageDescriptor getDerivationTreeIcon() {
		return createImageDescriptor(ImageProvider.DERIVATION_TREE_ICON_PATH);
	}

	/** Return the "attribute" icon */
	public Image getAttributeIcon() {
		if (this.attributeIcon == null) {
			this.attributeIcon = createImageDescriptor(ImageProvider.ATTRIBUTE_ICON_PATH)
					.createImage();
		}
		return this.attributeIcon;
	}

	/** Return the "attribute" icon */
	public ImageDescriptor getAttributeImageDescriptor() {
		return createImageDescriptor(ImageProvider.ATTRIBUTE_ICON_PATH);
	}

	/** Return the "facet attribute" icon */
	public Image getFacetAttributeIcon() {
		if (this.attributeFacetIcon == null) {
			this.attributeFacetIcon = createImageDescriptor(ImageProvider.ATTRIBUTE_FACET_ICON_PATH)
					.createImage();
		}
		return this.attributeFacetIcon;
	}

	/** Return the "empty attributes" icon */
	public Image getEmptyAttributeIcon() {
		if (this.emptyAttributeIcon == null) {
			this.emptyAttributeIcon = createImageDescriptor(ImageProvider.EMPTY_ATTRIBUTE_ICON_PATH)
					.createImage();
		}
		return this.emptyAttributeIcon;
	}

	/** Return the "empty attributes" icon */
	public ImageDescriptor getEmptyAttributeImageDescriptor() {
		return createImageDescriptor(ImageProvider.EMPTY_ATTRIBUTE_ICON_PATH);
	}

	/** Return the "increase font size" icon */
	public ImageDescriptor getIncreaseFontSizeIcon() {
		if (this.increaseFontSizeIcon == null) {
			this.increaseFontSizeIcon = createImageDescriptor(ImageProvider.INCREASE_FONT_SIZE_ICON_PATH);
		}
		return this.increaseFontSizeIcon;
	}

	/** Return the "decrease font size" icon */
	public ImageDescriptor getDecreaseFontSizeIcon() {
		if (this.decreaseFontSizeIcon == null) {
			this.decreaseFontSizeIcon = createImageDescriptor(ImageProvider.DECREASE_FONT_SIZE_ICON_PATH);
		}
		return this.decreaseFontSizeIcon;
	}

	/** Return the "restore font size" icon */
	public ImageDescriptor getRestoreFontSizeIcon() {
		if (this.restoreFontSizeIcon == null) {
			this.restoreFontSizeIcon = createImageDescriptor(ImageProvider.RESTORE_FONT_SIZE_ICON_PATH);
		}
		return this.restoreFontSizeIcon;
	}

	/** Return the "hide empty columns" icon */
	public Image getHideEmptyColumnsIcon() {
		if (this.hideEmptyColumnsIcon == null) {
			this.hideEmptyColumnsIcon = createImageDescriptor(
					ImageProvider.HIDE_EMPTY_COLUMNS_ICON_PATH).createImage();
		}
		return this.hideEmptyColumnsIcon;
	}

	/** Return the "common columns" icon */
	public Image getCommonColumnsIcon() {
		if (this.commonColumnsIcon == null) {
			this.commonColumnsIcon = createImageDescriptor(ImageProvider.COMMON_COLUMNS_ICON_PATH)
					.createImage();
		}
		return this.commonColumnsIcon;
	}

	/** Return the "ordering" icon */
	public Image getOrderingIcon() {
		if (this.orderingIcon == null) {
			this.orderingIcon = createImageDescriptor(ImageProvider.ORDERING_ICON_PATH)
					.createImage();
		}
		return this.orderingIcon;
	}

	/** Return the "ordering" icon */
	public ImageDescriptor getOrderingImageDescriptor() {
		return createImageDescriptor(ImageProvider.ORDERING_ICON_PATH);
	}

	/** Return the "eClass" icon */
	public Image getEClassIcon() {
		if (this.eClassIcon == null) {
			this.eClassIcon = createImageDescriptor(ImageProvider.ECLASS_ICON_PATH).createImage();
		}
		return this.eClassIcon;
	}

	/** Return the "operation" icon */
	public Image getOperationIcon() {
		if (this.operationIcon == null) {
			this.operationIcon = createImageDescriptor(ImageProvider.OPERATION_ICON_PATH)
					.createImage();
		}
		return this.operationIcon;
	}

	/** Return the "predicate" icon */
	public Image getPredicateIcon() {
		if (this.predicateIcon == null) {
			this.predicateIcon = createImageDescriptor(ImageProvider.PREDICATE_ICON_PATH)
					.createImage();
		}
		return this.predicateIcon;
	}

	/** Return the "EmfFacet" icon */
	public Image getEmfFacetIcon() {
		if (this.emffacetIcon == null) {
			this.emffacetIcon = createImageDescriptor(ImageProvider.EMFFACET_ICON_PATH).createImage();
		}
		return this.emffacetIcon;
	}

	/** Return an icon representing the concept of "feature" */
	public Image getFeatureIcon() {
		if (this.featureIcon == null) {
			this.featureIcon = createImageDescriptor(ImageProvider.FEATURE_ICON_PATH).createImage();
		}
		return this.featureIcon;
	}

	/** Return an icon descriptor representing the concept of "feature" */
	public ImageDescriptor getFeatureIconDescriptor() {
		return createImageDescriptor(ImageProvider.FEATURE_ICON_PATH);
	}

	/** Return an icon descriptor representing the concept of "facet" */
	public ImageDescriptor getFacetIconDescriptor() {
		return createImageDescriptor(ImageProvider.FACET_ICON_PATH);
	}

	/** Return an icon descriptor representing the concept of "facet" */
	public Image getFacetIcon() {
		if (this.facetIcon == null) {
			this.facetIcon = createImageDescriptor(ImageProvider.FACET_ICON_PATH).createImage();
		}
		return this.facetIcon;
	}

	/** Return an icon descriptor for "uiCustom" */
	public ImageDescriptor getAddUiCustomIconDescriptor() {
		return createImageDescriptor(ImageProvider.ADD_UI_CUSTOM_ICON_PATH);
	}

	/** Return an icon for "uiCustom" */
	public Image getUiCustomIcon() {
		if (this.uiCustomIcon == null) {
			this.uiCustomIcon = createImageDescriptor(ImageProvider.ADD_UI_CUSTOM_ICON_PATH)
					.createImage();
		}
		return this.uiCustomIcon;
	}
	
	/**Return the grayed image for "uiCustom*/
	public Image getGrayedUiCustomIcon(){
		if(this.grayedUiCustomIcon==null){
			this.grayedUiCustomIcon = new Image(Display.getCurrent(), getUiCustomIcon(), SWT.IMAGE_GRAY);
		}
		return this.grayedUiCustomIcon;
	}
	
	/** Return the "error" icon */
	public Image getErrorIcon() {
		if (this.errorIcon == null) {
			this.errorIcon = createImageDescriptor(ImageProvider.ERROR_ICON_PATH).createImage();
		}
		return this.errorIcon;
	}

	/** Return the toolbar menu icon */
	public Image getViewMenuIcon() {
		if (this.viewMenuIcon == null) {
			this.viewMenuIcon = createImageDescriptor(ImageProvider.VIEW_MENU_ICON_PATH)
					.createImage();
		}
		return this.viewMenuIcon;
	}

	/** Return the query menu icon */
	public Image getQueryIcon() {
		if (this.queryIcon == null) {
			this.queryIcon = createImageDescriptor(ImageProvider.QUERY_ICON_PATH).createImage();
		}
		return this.queryIcon;
	}

	/** Return the link type icon */
	public Image getLinkTypeIcon() {
		if (this.linkTypeIcon == null) {
			this.linkTypeIcon = createImageDescriptor(ImageProvider.LINK_TYPE_ICON_PATH)
					.createImage();
		}
		return this.linkTypeIcon;
	}

	/** Return the link type icon descriptor */
	public ImageDescriptor getLinkTypeIconDescriptor() {
		return createImageDescriptor(ImageProvider.LINK_TYPE_ICON_PATH);
	}

	/** Return the "element ID" icon descriptor */
	public ImageDescriptor getShowElementIDsDescriptor() {
		return createImageDescriptor(ImageProvider.ELEMENT_IDS_ICON_PATH);
	}

	public ImageDescriptor getShowURIDescriptor() {
		return createImageDescriptor(ImageProvider.URI_ICON_PATH);
	}

	public Image getURIIcon() {
		if (this.uriIcon == null) {
			this.uriIcon = createImageDescriptor(ImageProvider.URI_ICON_PATH).createImage();
		}
		return this.uriIcon;
	}

	public ImageDescriptor getCollapseAllDescriptor() {
		return createImageDescriptor(ImageProvider.COLLAPSE_ALL_ICON_PATH);
	}
	
	public Image getShortcutIcon() {
		if (this.shortcutIcon == null) {
			this.shortcutIcon = createImageDescriptor(ImageProvider.SHORTCUT_ICON_PATH).createImage();
		}
		return this.shortcutIcon;
	}
	
	public Image getTopLeftOverlayIcon() {
		if (this.topLeftOverlay == null) {
			this.topLeftOverlay = createImageDescriptor(ImageProvider.TOP_LEFT_OVERLAY_ICON_PATH).createImage();
		}
		return this.topLeftOverlay;
	}
	
	public Image getTopMiddleOverlayIcon() {
		if (this.topMiddleOverlay == null) {
			this.topMiddleOverlay = createImageDescriptor(ImageProvider.TOP_MIDDLE_OVERLAY_ICON_PATH).createImage();
		}
		return this.topMiddleOverlay;
	}
	
	public Image getTopRightOverlayIcon() {
		if (this.topRightOverlay == null) {
			this.topRightOverlay = createImageDescriptor(ImageProvider.TOP_RIGHT_OVERLAY_ICON_PATH).createImage();
		}
		return this.topRightOverlay;
	}
	
	public Image getMiddleLeftOverlayIcon() {
		if (this.middleLeftOverlay == null) {
			this.middleLeftOverlay = createImageDescriptor(ImageProvider.MIDDLE_LEFT_OVERLAY_ICON_PATH).createImage();
		}
		return this.middleLeftOverlay;
	}
	
	public Image getMiddleRightOverlayIcon() {
		if (this.middleRightOverlay == null) {
			this.middleRightOverlay = createImageDescriptor(ImageProvider.MIDDLE_RIGHT_OVERLAY_ICON_PATH).createImage();
		}
		return this.middleRightOverlay;
	}
	
	public Image getBottomLeftOverlayIcon() {
		if (this.bottomLeftOverlay == null) {
			this.bottomLeftOverlay = createImageDescriptor(ImageProvider.BOTTOM_LEFT_OVERLAY_ICON_PATH).createImage();
		}
		return this.bottomLeftOverlay;
	}
	
	public Image getBottomMiddleOverlayIcon() {
		if (this.bottomMiddleOverlay == null) {
			this.bottomMiddleOverlay = createImageDescriptor(ImageProvider.BOTTOM_MIDDLE_OVERLAY_ICON_PATH).createImage();
		}
		return this.bottomMiddleOverlay;
	}
	
	public Image getBottomRightOverlayIcon() {
		if (this.bottomRightOverlay == null) {
			this.bottomRightOverlay = createImageDescriptor(ImageProvider.BOTTOM_RIGHT_OVERLAY_ICON_PATH).createImage();
		}
		return this.bottomRightOverlay;
	}
	
	public Image getCustomizationLabelIcon() {
		if (this.customizationLabel == null) {
			this.customizationLabel = createImageDescriptor(ImageProvider.LABEL_CUSTOMIZATION).createImage();
		}
		return this.customizationLabel;
	}
	
	public Image getCustomizationImageIcon() {
		if (this.customizationImage == null) {
			this.customizationImage = createImageDescriptor(ImageProvider.IMAGE_CUSTOMIZATION).createImage();
		}
		return this.customizationImage;
	}
	
	public Image getCustomizationColorIcon() {
		if (this.rgb == null) {
			this.rgb = createImageDescriptor(ImageProvider.RGB_CUSTOMIZATION).createImage();
		}
		return this.rgb;
	}
	
	public Image getFontNameIcon() {
		if (this.fontName == null) {
			this.fontName = createImageDescriptor(ImageProvider.FONT_NAME).createImage();
		}
		return this.fontName;
	}
	
	public Image getFontSizeIcon() {
		if (this.fontSize == null) {
			this.fontSize = createImageDescriptor(ImageProvider.FONT_SIZE).createImage();
		}
		return this.fontSize;
	}
	
	public Image getIsBoldIcon() {
		if (this.isBold == null) {
			this.isBold = createImageDescriptor(ImageProvider.IS_BOLD).createImage();
		}
		return this.isBold;
	}
	
	public Image getIsItalicIcon() {
		if (this.isItalic == null) {
			this.isItalic = createImageDescriptor(ImageProvider.IS_ITALIC).createImage();
		}
		return this.isItalic;
	}
	
	public Image getIsUnderlinedIcon() {
		if (this.isUnderlined == null) {
			this.isUnderlined = createImageDescriptor(ImageProvider.IS_UNDERLINED).createImage();
		}
		return this.isUnderlined;
	}
	
	public Image getIsStrukethroughIcon() {
		if (this.isStruckthrough == null) {
			this.isStruckthrough = createImageDescriptor(ImageProvider.IS_STRUCKTHROUGH).createImage();
		}
		return this.isStruckthrough;
	}
}
