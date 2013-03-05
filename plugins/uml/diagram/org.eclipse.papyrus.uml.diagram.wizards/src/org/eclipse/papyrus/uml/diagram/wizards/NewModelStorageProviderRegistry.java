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
package org.eclipse.papyrus.uml.diagram.wizards;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.services.IEvaluationService;

/**
 * This is the NewModelStorageProviderRegistry type. Enjoy.
 */
public class NewModelStorageProviderRegistry
		implements Iterable<NewModelStorageProviderRegistry.Descriptor> {

	private static final String EXTPT_ID = Activator.PLUGIN_ID
		+ ".newModelStorageProviders";

	private final List<Descriptor> descriptors = new java.util.ArrayList<Descriptor>();

	private final IEvaluationService evaluationService;

	public NewModelStorageProviderRegistry(IEvaluationService evaluationService) {
		this.evaluationService = evaluationService;

		for (IConfigurationElement config : sort(Platform
			.getExtensionRegistry().getConfigurationElementsFor(EXTPT_ID))) {

			if ("provider".equals(config.getName())) {
				descriptors.add(new Descriptor(config));
			}
		}
	}

	public Iterator<Descriptor> iterator() {
		return descriptors.iterator();
	}
	
	public int size() {
		return descriptors.size();
	}

	// sort configuration elements by contributing plug-in. Our own first, all
	// others as they come
	private List<IConfigurationElement> sort(
			IConfigurationElement[] providerElements) {
		
		List<IConfigurationElement> result = new java.util.ArrayList<IConfigurationElement>(
			Arrays.asList(providerElements));

		Collections.sort(result, new Comparator<IConfigurationElement>() {

			public int compare(IConfigurationElement o1,
					IConfigurationElement o2) {

				int result;

				String plugin1 = o1.getContributor().getName();
				String plugin2 = o2.getContributor().getName();

				if (plugin1.equals(plugin2)) {
					result = 0;
				} else if (Activator.PLUGIN_ID.equals(plugin1)) {
					result = -1;
				} else if (Activator.PLUGIN_ID.equals(plugin2)) {
					result = +1;
				} else {
					result = 0;
				}

				return result;
			}
		});

		return result;
	}

	//
	// Nested types
	//

	public class Descriptor
			implements INewModelStorageProvider {

		private final IConfigurationElement config;

		private String label;

		private Expression matchSelection;

		private INewModelStorageProvider instance;

		Descriptor(IConfigurationElement config) {
			this.config = config;

			this.label = config.getAttribute("name");

			initMatchExpression(config);
		}

		public String getLabel() {
			return label;
		}

		INewModelStorageProvider getInstance() {
			if (instance == null) {
				try {
					instance = (INewModelStorageProvider) config
						.createExecutableExtension("class");
				} catch (ClassCastException e) {
					Activator.log
						.error(
							"Storage provider does not implement INewModelStorageProvider interface.",
							e);
				} catch (Exception e) {
					Activator.log.error(
						"Could not instantiate storage provider.", e);
				}

				if (instance == null) {
					instance = new NullProvider();
				}
			}

			return instance;
		}

		public boolean canHandle(IStructuredSelection initialSelection) {
			boolean result;

			if (matchSelection != null) {
				List<?> selection = initialSelection.toList();
				IEvaluationContext ctx = new EvaluationContext(
					evaluationService.getCurrentState(), selection);
				ctx.addVariable("selection", selection);

				EvaluationResult evalResult = EvaluationResult.FALSE;
				try {
					evalResult = matchSelection.evaluate(ctx);
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}

				result = EvaluationResult.TRUE.equals(evalResult);
			} else {
				result = getInstance().canHandle(initialSelection);
			}

			return result;
		}

		public void init(CreateModelWizard wizard,
				IStructuredSelection selection) {
			getInstance().init(wizard, selection);
		}

		public List<? extends IWizardPage> createPages() {
			return getInstance().createPages();
		}

		public URI createNewModelURI(String diagramCategoryID) {
			return getInstance().createNewModelURI(diagramCategoryID);
		}

		public IEditorInput createEditorInput(URI uri) {
			return getInstance().createEditorInput(uri);
		}

		public IStatus validateDiagramCategories(String... newCategories) {
			return getInstance().validateDiagramCategories(newCategories);
		}

		public ISelectProviderPart createSelectProviderPart() {
			return getInstance().createSelectProviderPart();
		}

		private void initMatchExpression(IConfigurationElement parentConfig) {
			IConfigurationElement[] configs = parentConfig
				.getChildren("enablement");
			if (configs.length > 0) {
				try {
					matchSelection = ExpressionConverter.getDefault().perform(
						configs[0]);
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}
			}
		}
	}

	private static final class NullProvider
			extends AbstractNewModelStorageProvider {

		public boolean canHandle(IStructuredSelection initialSelection) {
			return false;
		}

		public List<? extends IWizardPage> createPages() {
			return Collections.emptyList();
		}

		public URI createNewModelURI(String diagramCategoryID) {
			return null; // I don't create models
		}

	}
}
