/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *		Nicolas Guyomar (Mia-Software) - Bug 349556 - EMF Facet Java Query wizard
 *		Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal;

import org.eclipse.osgi.util.NLS;

// copy from /org.eclipse.papyrus.emf.facet.query.java.sdk.ui/src/org/eclipse/emf/facet/query/java/sdk/ui/internal/Messages.java
public final class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.messages"; //$NON-NLS-1$
	public static String Choose_an_operation;
	public static String Choose_an_operation_desc;
	public static String Create_new_java_class;
	public static String JavaQueryWizardPage_Can_be_cached;
	public static String JavaQueryWizardPage_has_side_effect;
	public static String JavaQueryWizardPage_Java_Class_Name;
	public static String JavaQueryWizardPage_Java_Query;
	public static String JavaQueryWizardPage_Java_query_creation_page;
	public static String JavaQueryWizardPage_lower_bound;
	public static String JavaQueryWizardPage_Query_name;
	public static String JavaQueryWizardPage_Browse;
	public static String JavaQueryWizardPage_Create;
	public static String JavaQueryWizardPage_interface_constraints;
	public static String JavaQueryWizardPage_Please_select_a_scope;
	public static String JavaQueryWizardPage_Please_select_create_IJavaQuery_Class;
	public static String JavaQueryWizardPage_Scope;
	public static String JavaQueryWizardPage_upper_bound;
	public static String NewClassWizardPage_CreateANewJavaClass;
	public static String NewClassWizardPage_JavaClass;
	public static String NewQueryClassWizardPage_Failed_to_create_java_class;
	public static String NewQueryClassWizardPage_Failed_to_create_query_implementation;
	public static String Select_existing_java_class;
	public static String SelectJavaClassWizardPage_SeclectAJavaClassLongDescription;
	public static String SelectJavaClassWizardPage_SelectAJavaClass;
	public static String Upper_bound;
	public static String Multi_Values;

	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
