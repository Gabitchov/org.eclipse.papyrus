/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.org;

public interface IADL4ECLIPSE_Stereotype {
	/** Qualified name of the stereotype Plugin */
	public static final String PLUGIN_STEREOTYPE = "ADL4Eclipse::Plugin";
	/**  name of property isIncubation of the stereoype Plugin */
	public static final String PLUGIN_ISINCUBATION_ATT = "isIncubation";
	/**  name of property lazyStart of the stereoype Plugin */
	public static final String PLUGIN_LAZYSTART_ATT = "lazyStart";
	/**  name of property lazyStartException of the stereoype Plugin */
	public static final String PLUGIN_LAZYSTARTEXCEPTION_ATT = "lazyStartException";
	/**  name of property platformFilter of the stereoype Plugin */
	public static final String PLUGIN_PLATFORMFILTER_ATT = "platformFilter";
	/**  name of property buddyPolicy of the stereoype Plugin */
	public static final String PLUGIN_BUDDYPOLICY_ATT = "buddyPolicy";
	/**  name of property extensibleAPI of the stereoype Plugin */
	public static final String PLUGIN_EXTENSIBLEAPI_ATT = "extensibleAPI";
	/**  name of property bundleShape of the stereoype Plugin */
	public static final String PLUGIN_BUNDLESHAPE_ATT = "bundleShape";
	/**  name of property capability of the stereoype Plugin */
	public static final String PLUGIN_CAPABILITY_ATT = "capability";
	/**  name of property requireCapability of the stereoype Plugin */
	public static final String PLUGIN_REQUIRECAPABILITY_ATT = "requireCapability";
	/**  name of property genericCapabilityAlias of the stereoype Plugin */
	public static final String PLUGIN_GENERICCAPABILITYALIAS_ATT = "genericCapabilityAlias";
	/** Qualified name of the stereotype EclipseExportedPackage */
	public static final String ECLIPSEEXPORTEDPACKAGE_STEREOTYPE = "ADL4Eclipse::EclipseExportedPackage";
	/**  name of property isInternal of the stereoype EclipseExportedPackage */
	public static final String ECLIPSEEXPORTEDPACKAGE_ISINTERNAL_ATT = "isInternal";
	/**  name of property friend of the stereoype EclipseExportedPackage */
	public static final String ECLIPSEEXPORTEDPACKAGE_FRIEND_ATT = "friend";
	/**  name of literal dependent of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_DEPENDENT_ENUM = "dependent";
	/**  name of literal global of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_GLOBAL_ENUM = "global";
	/**  name of literal registered of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_REGISTERED_ENUM = "registered";
	/**  name of literal app of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_APP_ENUM = "app";
	/**  name of literal ext of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_EXT_ENUM = "ext";
	/**  name of literal boot of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_BOOT_ENUM = "boot";
	/**  name of literal parent of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_PARENT_ENUM = "parent";
	/**  name of literal jar of the Enumeration BundleShapeEnumeration */
	public static final String BUNDLESHAPEENUMERATION_JAR_ENUM = "jar";
	/**  name of literal dir of the Enumeration BundleShapeEnumeration */
	public static final String BUNDLESHAPEENUMERATION_DIR_ENUM = "dir";
	/** Qualified name of the stereotype Feature */
	public static final String FEATURE_STEREOTYPE = "ADL4Eclipse::Feature";
	/**  name of property base_Class of the stereoype Feature */
	public static final String FEATURE_BASE_CLASS_ATT = "base_Class";
	/**  name of property description of the stereoype Feature */
	public static final String FEATURE_DESCRIPTION_ATT = "description";
	/**  name of property copyright of the stereoype Feature */
	public static final String FEATURE_COPYRIGHT_ATT = "copyright";
	/**  name of property license of the stereoype Feature */
	public static final String FEATURE_LICENSE_ATT = "license";
	/**  name of property provider of the stereoype Feature */
	public static final String FEATURE_PROVIDER_ATT = "provider";
	/**  name of property image of the stereoype Feature */
	public static final String FEATURE_IMAGE_ATT = "image";
	/**  name of property url of the stereoype Feature */
	public static final String FEATURE_URL_ATT = "url";
	/**  name of property plugins of the stereoype Feature */
	public static final String FEATURE_PLUGINS_ATT = "plugins";
	/**  name of property includedFeatures of the stereoype Feature */
	public static final String FEATURE_INCLUDEDFEATURES_ATT = "includedFeatures";
	/**  name of property importedFeatures of the stereoype Feature */
	public static final String FEATURE_IMPORTEDFEATURES_ATT = "importedFeatures";
	/**  name of property label of the stereoype Feature */
	public static final String FEATURE_LABEL_ATT = "label";
	/**  name of property id of the stereoype Feature */
	public static final String FEATURE_ID_ATT = "id";
	/**  name of property version of the stereoype Feature */
	public static final String FEATURE_VERSION_ATT = "version";
}
