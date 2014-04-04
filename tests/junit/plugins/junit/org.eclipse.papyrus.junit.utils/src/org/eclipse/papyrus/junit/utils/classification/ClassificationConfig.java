/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils.classification;

import static org.eclipse.papyrus.junit.utils.classification.TestCategory.FailingTest;
import static org.eclipse.papyrus.junit.utils.classification.TestCategory.InteractiveTest;
import static org.eclipse.papyrus.junit.utils.classification.TestCategory.InvalidTest;
import static org.eclipse.papyrus.junit.utils.classification.TestCategory.NotImplemented;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.infra.tools.util.ListHelper;


/**
 * This class is used to configure the Classification Annotations which should be
 * excluded from a test job.
 *
 * Usage:
 *
 * ClassificationConfig.setExcludedTestCategories(TestCategory.InvalidTest, TestCategory.NotImplemented);
 *
 * or
 *
 * ClassificationConfig.setIncludedTestCategories(TestCategory.Standard, TestCategory.NotImplemented);
 *
 * @author Camille Letavernier
 *
 * @see {@link TestCategory}
 * @see {@link ClassificationRunner}
 *
 */
public class ClassificationConfig {

	public static final Set<TestCategory> excludedTestCategories = new HashSet<TestCategory>();

	static {
		//Default on Hudson: exclude everything which is already identified as an issue (i.e. is not a (new) regression)
		setExcludedTestCategories(NotImplemented, InvalidTest, FailingTest, InteractiveTest);

		//Check whether identified regressions are still failing
		//setIncludedTestCategories(FailingTest);
	}

	/**
	 * Define the test categories which should be excluded from the TestSuite
	 *
	 * @param categoriesToInclude
	 */
	public static void setExcludedTestCategories(TestCategory... categories) {
		setExcludedTestCategories(Arrays.asList(categories));
	}

	/**
	 * Define the test categories which should be included in the TestSuite
	 *
	 * @param categoriesToInclude
	 */
	public static void setIncludedTestCategories(TestCategory... categories) {
		setIncludedTestCategories(Arrays.asList(categories));
	}

	/**
	 * Define the test categories which should be excluded from the TestSuite
	 *
	 * @param categoriesToInclude
	 */
	public static void setExcludedTestCategories(Collection<TestCategory> categoriesToExclude) {
		excludedTestCategories.clear();
		excludedTestCategories.addAll(categoriesToExclude);
	}

	/**
	 * Define the test categories which should be included in the TestSuite
	 *
	 * @param categoriesToInclude
	 */
	public static void setIncludedTestCategories(Collection<TestCategory> categoriesToInclude) {
		excludedTestCategories.clear();
		List<TestCategory> categoriesToExclude = ListHelper.asList(TestCategory.values());
		categoriesToExclude.removeAll(categoriesToInclude);
		excludedTestCategories.addAll(categoriesToExclude);
	}

	/**
	 * Tests whether a method containing the given set of Annotations should be executed
	 *
	 * @param annotations
	 *        The annotations applied to the Method
	 * @return
	 *         True if the test method should be executed, false if it should be ignored
	 */
	public static boolean shouldRun(Annotation[] annotations) {
		for(Annotation annotation : annotations) {
			Class<? extends Annotation> annotationClass = annotation.annotationType();
			if(isExcluded(annotationClass)) {
				return false;
			}
		}

		if(excludedTestCategories.contains(TestCategory.Standard)) {
			for(TestCategory testCategory : TestCategory.values()) {
				if(testCategory == TestCategory.Standard) {
					continue;
				}

				for(Annotation annotation : annotations) {
					if(testCategory.match(annotation.annotationType())) {
						return true;
					}
				}
			}

			return false;
		}

		return true;
	}

	/**
	 * Tests whether the given Annotation should be excluded
	 *
	 * @param annotationClass
	 * @return
	 */
	public static boolean isExcluded(Class<? extends Annotation> annotationClass) {
		for(TestCategory testCategory : excludedTestCategories) {
			if(testCategory.match(annotationClass)) {
				return true;
			}
		}

		return false;
	}

}
