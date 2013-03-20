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
package org.eclipse.papyrus.osgi.profile;

/**
 * this class contains all string to manipulate stereotypedElement
 *
 */
public interface IOSGIStereotype {
/** Qualified name of the  Bundle */
public static final String BUNDLE_ = "OSGI::ModuleLayer::Bundle";
/**  name of property hasLazyActivationPolicy of the stereotype Bundle */
public static final String BUNDLE_HASLAZYACTIVATIONPOLICY_ATT = "hasLazyActivationPolicy";
/**  name of property activator of the stereotype Bundle */
public static final String BUNDLE_ACTIVATOR_ATT = "activator";
/**  name of property category of the stereotype Bundle */
public static final String BUNDLE_CATEGORY_ATT = "category";
/**  name of property classPath of the stereotype Bundle */
public static final String BUNDLE_CLASSPATH_ATT = "classPath";
/**  name of property contactAddress of the stereotype Bundle */
public static final String BUNDLE_CONTACTADDRESS_ATT = "contactAddress";
/**  name of property copyright of the stereotype Bundle */
public static final String BUNDLE_COPYRIGHT_ATT = "copyright";
/**  name of property description of the stereotype Bundle */
public static final String BUNDLE_DESCRIPTION_ATT = "description";
/**  name of property docURL of the stereotype Bundle */
public static final String BUNDLE_DOCURL_ATT = "docURL";
/**  name of property icon of the stereotype Bundle */
public static final String BUNDLE_ICON_ATT = "icon";
/**  name of property license of the stereotype Bundle */
public static final String BUNDLE_LICENSE_ATT = "license";
/**  name of property localization of the stereotype Bundle */
public static final String BUNDLE_LOCALIZATION_ATT = "localization";
/**  name of property manifestVersion of the stereotype Bundle */
public static final String BUNDLE_MANIFESTVERSION_ATT = "manifestVersion";
/**  name of property nativeCode of the stereotype Bundle */
public static final String BUNDLE_NATIVECODE_ATT = "nativeCode";
/**  name of property requiredExecutionEnvironment of the stereotype Bundle */
public static final String BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT = "requiredExecutionEnvironment";
/**  name of property symbolicName of the stereotype Bundle */
public static final String BUNDLE_SYMBOLICNAME_ATT = "symbolicName";
/**  name of property isSingleton of the stereotype Bundle */
public static final String BUNDLE_ISSINGLETON_ATT = "isSingleton";
/**  name of property updateLocation of the stereotype Bundle */
public static final String BUNDLE_UPDATELOCATION_ATT = "updateLocation";
/**  name of property vendor of the stereotype Bundle */
public static final String BUNDLE_VENDOR_ATT = "vendor";
/**  name of property version of the stereotype Bundle */
public static final String BUNDLE_VERSION_ATT = "version";
/**  name of property dynamicImportPackage of the stereotype Bundle */
public static final String BUNDLE_DYNAMICIMPORTPACKAGE_ATT = "dynamicImportPackage";
/**  name of property exportPackage of the stereotype Bundle */
public static final String BUNDLE_EXPORTPACKAGE_ATT = "exportPackage";
/**  name of property fragmentHost of the stereotype Bundle */
public static final String BUNDLE_FRAGMENTHOST_ATT = "fragmentHost";
/**  name of property importPackage of the stereotype Bundle */
public static final String BUNDLE_IMPORTPACKAGE_ATT = "importPackage";
/**  name of property requireBundle of the stereotype Bundle */
public static final String BUNDLE_REQUIREBUNDLE_ATT = "requireBundle";
/**  name of property base_Component of the stereotype Bundle */
public static final String BUNDLE_BASE_COMPONENT_ATT = "base_Component";
/**  name of property name of the stereotype Bundle */
public static final String BUNDLE_NAME_ATT = "name";
/**  name of literal osgi of the Enumeration Bundle-Category */
public static final String BUNDLE_CATEGORY_OSGI_ENUM = "osgi";
/**  name of literal test of the Enumeration Bundle-Category */
public static final String BUNDLE_CATEGORY_TEST_ENUM = "test";
/**  name of literal nursery of the Enumeration Bundle-Category */
public static final String BUNDLE_CATEGORY_NURSERY_ENUM = "nursery";
/** Qualified name of the  VersionRange */
public static final String VERSIONRANGE_ = "OSGI::ModuleLayer::VersionRange";
/**  name of property floor of the stereotype VersionRange */
public static final String VERSIONRANGE_FLOOR_ATT = "floor";
/**  name of property ceiling of the stereotype VersionRange */
public static final String VERSIONRANGE_CEILING_ATT = "ceiling";
/**  name of property atleast of the stereotype VersionRange */
public static final String VERSIONRANGE_ATLEAST_ATT = "atleast";
/**  name of property includefloor of the stereotype VersionRange */
public static final String VERSIONRANGE_INCLUDEFLOOR_ATT = "includefloor";
/**  name of property includeCeiling of the stereotype VersionRange */
public static final String VERSIONRANGE_INCLUDECEILING_ATT = "includeCeiling";
/** Qualified name of the  BundleReference */
public static final String BUNDLEREFERENCE_ = "OSGI::ModuleLayer::BundleReference";
/**  name of property base_Dependency of the stereotype BundleReference */
public static final String BUNDLEREFERENCE_BASE_DEPENDENCY_ATT = "base_Dependency";
/** Qualified name of the  PackageReference */
public static final String PACKAGEREFERENCE_ = "OSGI::ModuleLayer::PackageReference";
/**  name of property base_Dependency of the stereotype PackageReference */
public static final String PACKAGEREFERENCE_BASE_DEPENDENCY_ATT = "base_Dependency";
/** Qualified name of the  ExportedPackage */
public static final String EXPORTEDPACKAGE_ = "OSGI::ModuleLayer::ExportedPackage";
/**  name of property base_Package of the stereotype ExportedPackage */
public static final String EXPORTEDPACKAGE_BASE_PACKAGE_ATT = "base_Package";
}
