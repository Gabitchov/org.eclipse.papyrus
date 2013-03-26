/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.internal.ui.importsources;

import static org.eclipse.papyrus.cdo.internal.ui.Activator.ICON_PAPYRUS_MODEL;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.SharedImages;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoryItemProvider;
import org.eclipse.papyrus.cdo.uml.internal.ui.Activator;
import org.eclipse.papyrus.cdo.uml.internal.ui.l10n.Messages;
import org.eclipse.papyrus.infra.widgets.providers.DelegatingLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.uml.tools.importsources.AbstractPackageImportSource;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Ordering;

/**
 * This is the CDOPackageImportSource type. Enjoy.
 */
public class CDOPackageImportSource extends AbstractPackageImportSource {

	private final IPapyrusRepositoryManager repoMan = PapyrusRepositoryManager.INSTANCE;

	private List<IPapyrusRepository> availableRepos;

	private ModelRepositoryItemProvider itemProvider;

	public CDOPackageImportSource() {
		super();
	}

	@Override
	public boolean canImportInto(Collection<?> selection) {
		boolean result = super.canImportInto(selection);

		if(result) {
			Package package_ = getPackage(selection);
			result = CDOUtils.isCDOObject(package_);
		}

		return result;
	}

	@Override
	public void initialize(Collection<?> selection) {
		availableRepos = new java.util.ArrayList<IPapyrusRepository>();
		for(IPapyrusRepository next : repoMan.getRepositories()) {
			if(next.isConnected()) {
				availableRepos.add(next);
			}
		}

		itemProvider = new ModelRepositoryItemProvider(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
	}

	@Override
	public void dispose() {
		availableRepos = null;
		itemProvider = null;

		super.dispose();
	}

	@Override
	protected IStaticContentProvider createModelHierarchyContentProvider() {
		return new CDOContent();
	}

	@Override
	protected ILabelProvider createModelHierarchyLabelProvider() {
		return new DelegatingLabelProvider(itemProvider) {

			@Override
			protected Image customGetImage(Object element) {
				Image result = null;

				if(element == CDOPackageImportSource.this) {
					result = SharedImages.getImage(ICON_PAPYRUS_MODEL);
				}

				return result;
			}

			@Override
			protected String customGetText(Object element) {
				String result = null;

				if(element == CDOPackageImportSource.this) {
					result = Messages.CDOPackageImportSource_0;
				}

				return result;
			}
		};
	}

	protected CDOResource getCDOResource(Object model) {
		CDOResource result = null;

		if(model instanceof CDOResource) {
			result = (CDOResource)model;
		} else if(model instanceof IAdaptable) {
			result = (CDOResource)((IAdaptable)model).getAdapter(CDOResource.class);
		}

		return result;
	}

	@Override
	protected void validateSelection(Object model) throws CoreException {

		CDOResource cdo = getCDOResource(model);
		if(cdo == null) {
			throw new CoreException(new Status(IStatus.WARNING, Activator.PLUGIN_ID, NLS.bind(Messages.CDOPackageImportSource_1, getText(model))));
		}

		super.validateSelection(model);
	}

	@Override
	public List<Package> getPackages(ResourceSet resourceSet, Object model) throws CoreException {

		List<Package> result;

		if(model instanceof DIModel) {
			result = new java.util.ArrayList<Package>(3);

			for(Object next : ((DIModel)model).getChildren()) {
				if(next instanceof Resource) {
					result.addAll(EcoreUtil.<Package> getObjectsByType(((Resource)next).getContents(), UMLPackage.Literals.PACKAGE));
				}
			}
		} else {
			result = super.getPackages(resourceSet, getCDOResource(model));
		}

		return result;
	}

	//
	// Nested types
	//

	private class CDOContent extends StaticContentProvider implements ITreeContentProvider {

		private final Ordering<Object> sorter = new Ordering<Object>() {

			@Override
			public int compare(Object left, Object right) {
				String leftLabel = getText(left);
				String rightLabel = getText(right);

				return Ordering.natural().compare(leftLabel, rightLabel);
			}
		};

		CDOContent() {
			super(availableRepos.toArray());
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if(newInput == null) {
				itemProvider.inputChanged(viewer, repoMan, null);
			} else {
				// substitute the repository manager as the input element
				itemProvider.inputChanged(viewer, null, repoMan);

				// prime the internal nodes for the repositories
				itemProvider.getChildren(repoMan);
			}
		}

		public Object getParent(Object element) {
			return itemProvider.getParent(element);
		}

		public boolean hasChildren(Object element) {
			return itemProvider.hasChildren(element);
		}

		public Object[] getChildren(Object parentElement) {
			Object[] result = itemProvider.getChildren(parentElement);

			Arrays.sort(result, sorter);

			return result;
		}

	}
}
