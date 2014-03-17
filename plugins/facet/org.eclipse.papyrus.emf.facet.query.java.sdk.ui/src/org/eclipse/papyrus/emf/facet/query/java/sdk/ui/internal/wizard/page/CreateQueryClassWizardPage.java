/*******************************************************************************
 * Copyright (c) 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Gregoire Dupe (Mia-Software)
 *		Nicolas Bros (Mia-Software)
 *		Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *		Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.page;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.JavaQueryUtils;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.JdtUtils;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.StringUtils;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;

// Copied from org.eclipse.papyrus.emf.facet.query.java.ui.internal.wizard.page.NewQueryClassWizardPage
public class CreateQueryClassWizardPage extends NewClassWizardPage {

	// This class has been copied from
	// org.eclipse.papyrus.emf.facet.infra.query.ui.wizards.NewQueryClassWizardPage

	public CreateQueryClassWizardPage(final IQueryContext queryContainer) {
		super();
		final IJavaProject javaProject = JavaCore.create(queryContainer
				.getProject());
		final List<String> interfaceList = new ArrayList<String>();
		interfaceList.add(IJavaQuery2.class.getName());
		setSuperInterfaces(interfaceList, false);
		final String packageName = JavaQueryUtils.getDefaultPackageName(
				queryContainer,
				javaProject);
		final String typeName = getClassName(queryContainer);
		setTypeName(typeName, true);
		selectPackage(javaProject, packageName);
		setModifiers(this.F_PUBLIC, false);
		setSuperClass("", false); //$NON-NLS-1$
		setEnclosingTypeSelection(false, false);
		setAddComments(false, false);
	}

	private static String getClassName(final IQueryContext queryContext) {
		final StringBuffer result = new StringBuffer();
		final EObject intermediate = queryContext.getIntermediateEObject();
		if (intermediate instanceof ETypedElementCase) {
			final ETypedElementCase eteCase = (ETypedElementCase) intermediate;
			String caseLabel = ""; //$NON-NLS-1$
			if (eteCase.getCase() != null) {
				caseLabel = eteCase.getCase().getName();
			}
			result.append(StringUtils.firstLetterToUpperCase(caseLabel));
		}
		result.append(StringUtils.firstLetterToUpperCase(queryContext
				.getDerivedTypedElementName()));
		result.append("Query"); //$NON-NLS-1$
		return result.toString();
	}

	private void selectPackage(final IJavaProject javaProject,
			final String packageName) {
		try {
			for (final IPackageFragmentRoot packageFragmentRootToTest : javaProject
					.getPackageFragmentRoots()) {
				if (packageFragmentRootToTest.getKind() == IPackageFragmentRoot.K_SOURCE) {
					final IPackageFragmentRoot pkgFragmentRoot = packageFragmentRootToTest;
					setPackageFragmentRoot(pkgFragmentRoot, false);
					final IPackageFragment packageFragment = pkgFragmentRoot
							.getPackageFragment(packageName);
					setPackageFragment(packageFragment, true);
					break;
				}
			}
		} catch (final JavaModelException e1) {
			Logger.logError(e1, Activator.getDefault());
		}
	}

	public String apply(final EClassifier returnType,
			final boolean multiValues,
			final EClassifier scope) {
		String result = ""; //$NON-NLS-1$
		try {
			final IPackageFragmentRoot root = getPackageFragmentRoot();
			final IPackageFragment packageFragment = getPackageFragment();
			final String typeName = getTypeName();
			final String cuName = getCompilationUnitName(typeName);
			final ICompilationUnit javaClass = JdtUtils.createJavaClass(
					returnType, multiValues, scope, packageFragment, root,
					typeName, cuName);
			final IProject project = javaClass.getCorrespondingResource()
					.getProject();
			JdtUtils.setupProject(project, returnType, scope);
			result = packageFragment.getElementName() + '.' + typeName;
		} catch (final Exception e) {
			Logger.logError(e, Activator.getDefault());
			MessageDialog
					.openError(
							getShell(),
							Messages.NewQueryClassWizardPage_Failed_to_create_java_class,
							Messages.NewQueryClassWizardPage_Failed_to_create_query_implementation);
		}
		return result;
	}

}
