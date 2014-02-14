/*******************************************************************************
 * Copyright (c) 2008, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 339653 - org.eclipse.emf.facet.widgets API Cleaning
 *    Vincent Lorenzo (CEA-LIST) - bug 341192 - Add the method to get the image for Select Columns To Hide in the ImageManager
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.internal;

import java.net.URL;

import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

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
	private Image uriIcon = null;

	private Image shortcutIcon = null;

	private Image selectColumnsToHide = null;

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
	private static final String REMOVE_LINE_ICON_PATH = "/icons/full/ctool16/remove_line.gif"; //$NON-NLS-1$
	private static final String DELETE_ELEMENT_ICON_PATH = "/icons/full/ctool16/delete.gif"; //$NON-NLS-1$
	private static final String ADD_ICON_PATH = "/icons/full/ctool16/add.gif"; //$NON-NLS-1$
	private static final String SELECT_COLUMNS_TO_HIDE = "/icons/full/ctool16/select_columns_to_hide.png"; //$NON-NLS-1$

	/**
	 * Create an image descriptor from a resource
	 * 
	 * @param resourcePath
	 *            the path of the resource (in the bundle)
	 * @return the image descriptor
	 */
	private static ImageDescriptor createImageDescriptor(final String resourcePath) {
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
	public static ImageDescriptor getEmptyLinksImageDescriptor() {
		return createImageDescriptor(ImageProvider.EMPTY_LINKS_ICON_PATH);
	}

	/** Return the icon representing sorting of instances */
	public static ImageDescriptor getSortInstancesIcon() {
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
	public static ImageDescriptor getSortLinksImageDescriptor() {
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
	public static ImageDescriptor getSortLinksByTypeImageDescriptor() {
		return createImageDescriptor(ImageProvider.SORT_LINKS_BY_TYPE_ICON_PATH);
	}

	/** Return the icon representing sorting numerically */
	public static ImageDescriptor getSortNumericallyIcon() {
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
	public static ImageDescriptor getShowDerivedLinksImageDescriptor() {
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
	public static ImageDescriptor getShowFullQualifiedNamesImageDescriptor() {
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
	public static ImageDescriptor getShowMultiplicityImageDescriptor() {
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
	public static ImageDescriptor getShowOppositeLinksImageDescriptor() {
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
	public static ImageDescriptor getContainerImageDescriptor() {
		return createImageDescriptor(ImageProvider.CONTAINER_ICON_PATH);
	}

	/** Return the "show empty metaclasses" icon */
	public static ImageDescriptor getShowEmptyMetaclassesIcon() {
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
	public static ImageDescriptor getPackageImageDescriptor() {
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
	public static ImageDescriptor getDerivedInstancesImageDescriptor() {
		return createImageDescriptor(ImageProvider.DERIVED_INSTANCES_ICON_PATH);
	}

	/** Return the "derivation tree" icon */
	public static ImageDescriptor getDerivationTreeIcon() {
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
	public static ImageDescriptor getAttributeImageDescriptor() {
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
	public static ImageDescriptor getEmptyAttributeImageDescriptor() {
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

	/** Return the "hide empty columns" icon */
	public static ImageDescriptor getHideEmptyColumnsIconDescriptor() {
		return createImageDescriptor(ImageProvider.HIDE_EMPTY_COLUMNS_ICON_PATH);
	}

	/** Return the "common columns" icon */
	public Image getCommonColumnsIcon() {
		if (this.commonColumnsIcon == null) {
			this.commonColumnsIcon = createImageDescriptor(ImageProvider.COMMON_COLUMNS_ICON_PATH)
					.createImage();
		}
		return this.commonColumnsIcon;
	}

	/** Return the "common columns" icon */
	public static ImageDescriptor getCommonColumnsIconDescriptor() {
		return createImageDescriptor(ImageProvider.COMMON_COLUMNS_ICON_PATH);
	}

	/** Return the "delete line" icon */
	public static ImageDescriptor getRemoveLineIconDescriptor() {
		return createImageDescriptor(ImageProvider.REMOVE_LINE_ICON_PATH);
	}

	/** Return the "delete element" icon */
	public static ImageDescriptor getDeleteElementIconDescriptor() {
		return createImageDescriptor(ImageProvider.DELETE_ELEMENT_ICON_PATH);
	}

	/** Return the "add" icon */
	public static ImageDescriptor getAddIconDescriptor() {
		return createImageDescriptor(ImageProvider.ADD_ICON_PATH);
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
	public static ImageDescriptor getOrderingIconDescriptor() {
		return createImageDescriptor(ImageProvider.ORDERING_ICON_PATH);
	}

	/** Return the "ordering" icon */
	public static ImageDescriptor getOrderingImageDescriptor() {
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
			this.emffacetIcon = createImageDescriptor(ImageProvider.EMFFACET_ICON_PATH)
					.createImage();
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
	public static ImageDescriptor getFeatureIconDescriptor() {
		return createImageDescriptor(ImageProvider.FEATURE_ICON_PATH);
	}

	/** Return an icon descriptor representing the concept of "facet" */
	public static ImageDescriptor getFacetIconDescriptor() {
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
	public static ImageDescriptor getAddUiCustomIconDescriptor() {
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
	public static ImageDescriptor getLinkTypeIconDescriptor() {
		return createImageDescriptor(ImageProvider.LINK_TYPE_ICON_PATH);
	}

	/** Return the "element ID" icon descriptor */
	public static ImageDescriptor getShowElementIDsDescriptor() {
		return createImageDescriptor(ImageProvider.ELEMENT_IDS_ICON_PATH);
	}

	public static ImageDescriptor getShowURIDescriptor() {
		return createImageDescriptor(ImageProvider.URI_ICON_PATH);
	}

	public Image getURIIcon() {
		if (this.uriIcon == null) {
			this.uriIcon = createImageDescriptor(ImageProvider.URI_ICON_PATH).createImage();
		}
		return this.uriIcon;
	}

	public static ImageDescriptor getCollapseAllDescriptor() {
		return createImageDescriptor(ImageProvider.COLLAPSE_ALL_ICON_PATH);
	}

	public Image getShortcutIcon() {
		if (this.shortcutIcon == null) {
			this.shortcutIcon = createImageDescriptor(ImageProvider.SHORTCUT_ICON_PATH)
					.createImage();
		}
		return this.shortcutIcon;
	}

	public static ImageDescriptor getSelectColumnsToHideDescriptor() {
		return createImageDescriptor(ImageProvider.SELECT_COLUMNS_TO_HIDE);
	}

	public Image getSelectColumnsToHide() {
		if (this.selectColumnsToHide == null) {
			this.selectColumnsToHide = createImageDescriptor(ImageProvider.SELECT_COLUMNS_TO_HIDE)
					.createImage();
		}
		return this.selectColumnsToHide;
	}
}
