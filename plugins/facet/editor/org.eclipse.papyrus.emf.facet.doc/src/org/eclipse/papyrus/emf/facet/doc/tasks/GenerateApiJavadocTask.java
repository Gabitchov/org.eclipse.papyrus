/*******************************************************************************
 * Copyright (c) 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.doc.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Javadoc;
import org.apache.tools.ant.types.FileSet;

public class GenerateApiJavadocTask extends Javadoc {

	private String sourceTreePath = null;
	private Pattern pattern = Pattern.compile(".*"); //$NON-NLS-1$

	public void setSourceTreePath(final String path) {
		this.sourceTreePath = path;
	}

	public void setPattern(final String pattern) {
		this.pattern = Pattern.compile(pattern);
	}

	@Override
	public void execute() throws BuildException {
		if (this.sourceTreePath == null) {
			throw new BuildException("sourceTreePath must be set"); //$NON-NLS-1$
		}

		getProject().log("sourceTreePath = " + this.sourceTreePath, Project.MSG_DEBUG); //$NON-NLS-1$

		final List<File> apiPackages = new ArrayList<File>();

		File root = new File(this.sourceTreePath);
		if (!root.isAbsolute()) {
			root = new File(getProject().getBaseDir(), this.sourceTreePath);
		}
		if (!root.exists()) {
			throw new BuildException("root path doesn't exist: " + root.getPath()); //$NON-NLS-1$
		}
		try {
			for (final String childPath : root.list()) {
				final boolean matches = this.pattern.matcher(childPath).matches();
				if (matches) {
					getProject().log("pattern matches: " + childPath, Project.MSG_DEBUG); //$NON-NLS-1$
				} else {
					getProject().log("pattern rejects: " + childPath, Project.MSG_DEBUG); //$NON-NLS-1$
				}
				if (matches) {
					final File file = new File(root, childPath);
					if (file.isDirectory()) {
						final File manifestFile = new File(file, "META-INF/MANIFEST.MF"); //$NON-NLS-1$
						if (manifestFile.exists()) {
							FileInputStream fileInputStream;
							fileInputStream = new FileInputStream(manifestFile);
							final Manifest manifest = new Manifest(fileInputStream);

							final Attributes mainAttributes = manifest.getMainAttributes();
							for (final Entry<Object, Object> entry : mainAttributes.entrySet()) {
								final String name = entry.getKey().toString();
								if ("Export-Package".equals(name)) { //$NON-NLS-1$
									final String value = (String) entry.getValue();
									final String[] packageEntries = value.split(","); //$NON-NLS-1$
									for (final String packageEntry : packageEntries) {
										final String[] parts = packageEntry.split(";"); //$NON-NLS-1$
										final String packageName = parts[0];
										boolean internal = false;
										for (int i = 1; i < parts.length; i++) {
											if (parts[i].contains("x-internal") || parts[i].contains("x-friends")) { //$NON-NLS-1$ //$NON-NLS-2$
												internal = true;
											}
										}
										if (!internal) {
											final File packageDir = new File(file.getPath(), "src/" + packageName.replace('.', '/')); //$NON-NLS-1$
											if (packageDir.exists()) {
												apiPackages.add(packageDir);
											}
										}
									}
								}
							}
							fileInputStream.close();
						}
					}
				}
			}
		} catch (final Exception e) {
			throw new BuildException("Error reading manifests", e); //$NON-NLS-1$
		}

		for (final File apiPackage : apiPackages) {
			final String[] children = apiPackage.list();
			boolean packageImpl = false;
			boolean factoryImpl = false;
			for (final String child : children) {
				if (child.endsWith("PackageImpl.java")) { //$NON-NLS-1$
					packageImpl = true;
				}
				if (child.endsWith("FactoryImpl.java")) { //$NON-NLS-1$
					factoryImpl = true;
				}
			}
			if (packageImpl && factoryImpl) {
				getProject().log("excluding metamodel implementation package: " + apiPackage.getPath(), Project.MSG_INFO); //$NON-NLS-1$
				continue;
			}

			if (apiPackage.exists()) {
				System.out.println(apiPackage);

				final FileSet fileSet = new FileSet();
				fileSet.setProject(getProject());
				fileSet.setDir(apiPackage);
				fileSet.setIncludes("*.java"); //$NON-NLS-1$
				System.out.println(fileSet);
				addFileset(fileSet);
			} else {
				getProject().log("package doesn't exist: " + apiPackage, Project.MSG_ERR); //$NON-NLS-1$
			}
		}

		super.execute();
	}
}
