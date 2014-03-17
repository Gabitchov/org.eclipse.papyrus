/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - adapt to source-incompatible API change in CDO Luna M6
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.providers;

import org.eclipse.emf.cdo.eresource.CDOBinaryResource;
import org.eclipse.emf.cdo.eresource.CDOFileResource;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceLeaf;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.eresource.CDOTextResource;
import org.eclipse.emf.cdo.eresource.util.EresourceSwitch;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * A provider of labels for CDO resources and URIs for CDO resources in the Papyrus label-provider service.
 */
public class CDOResourceLabelProvider extends LabelProvider implements IFilteredLabelProvider {

	private final ResourceManager images = new LocalResourceManager(JFaceResources.getResources());

	private final EresourceSwitch<String> nodeTypeSwitch = createNodeTypeSwitch();

	public CDOResourceLabelProvider() {
		super();
	}

	@Override
	public boolean accept(Object element) {
		return (element instanceof CDOResourceNode) || (element instanceof URI) && CDOUtils.isCDOURI((URI)element);
	}

	@Override
	public void dispose() {
		images.dispose();

		super.dispose();
	}

	@Override
	public Image getImage(Object element) {
		return images.createImage(Activator.getIcon(Activator.ICON_OPEN_REPOSITORY));
	}

	@Override
	public String getText(Object element) {
		String result = null;

		URI uri = (element instanceof URI) ? (URI)element : ((CDOResourceNode)element).getURI();

		if(uri != null) {
			String nodeType = element instanceof CDOResourceNode ? nodeTypeSwitch.doSwitch((CDOResource)element) : Messages.CDOResLabels_node;
			String path = CDOURIUtil.extractResourcePath(uri);
			IPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(uri);
			String repoName = (repo == null) ? Messages.CDOResLabels_unknown : repo.getName();

			result = NLS.bind(Messages.CDOResLabels_pattern, new Object[]{ nodeType, path, repoName });
		}

		return result;
	}

	private EresourceSwitch<String> createNodeTypeSwitch() {
		return new EresourceSwitch<String>() {

			@Override
			public String defaultCase(EObject object) {
				return Messages.CDOResLabels_nodeKind;
			}

			@Override
			public String caseCDOResource(CDOResource object) {
				return Messages.CDOResLabels_modelKind;
			}

			@Override
			public String caseCDOResourceFolder(CDOResourceFolder object) {
				return Messages.CDOResLabels_folderKind;
			}

			@Override
			public String caseCDOBinaryResource(CDOBinaryResource object) {
				return Messages.CDOResLabels_binKind;
			}

			@Override
			public String caseCDOTextResource(CDOTextResource object) {
				return Messages.CDOResLabels_txtKind;
			}

			@Override
			public <IO> String caseCDOFileResource(CDOFileResource<IO> object) {
				return Messages.CDOResLabels_fileKind;
			}

			@Override
			public String caseCDOResourceLeaf(CDOResourceLeaf object) {
				return Messages.CDOResLabels_leafKind;
			}
		};
	}
}
