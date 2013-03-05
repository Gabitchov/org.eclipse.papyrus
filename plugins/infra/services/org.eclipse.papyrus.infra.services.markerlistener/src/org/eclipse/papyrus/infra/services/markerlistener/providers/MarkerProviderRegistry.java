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
package org.eclipse.papyrus.infra.services.markerlistener.providers;

import static org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils.getFile;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.services.markerlistener.Activator;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * This is the MarkerProviderRegistry type. Enjoy.
 */
public class MarkerProviderRegistry {

	private static final String EXT_POINT = "markerproviders";

	public static final MarkerProviderRegistry INSTANCE = new MarkerProviderRegistry();

	private final List<IMarkerProvider> providers = new java.util.ArrayList<IMarkerProvider>();

	private boolean needPrune;

	private MarkerProviderRegistry() {
		super();

		new MyRegistryReader().readRegistry();
	}

	/**
	 * Prune out any null providers (failed to initialize) and replace
	 * descriptors that have been instantiated by their instances, to avoid
	 * delegation.
	 */
	private void prune() {
		if (needPrune) {
			needPrune = false;
			for (ListIterator<IMarkerProvider> iter = providers.listIterator(); iter
				.hasNext();) {

				IMarkerProvider next = iter.next();
				if (next == IMarkerProvider.NULL) {
					iter.remove();
				} else if (next instanceof MyRegistryReader.Descriptor) {
					MyRegistryReader.Descriptor desc = (MyRegistryReader.Descriptor) next;
					if (desc.instance != null) {
						iter.set(desc.instance);
					}
				}
			}
		}
	}

	public IMarkerProvider getMarkerProvider(Resource resource) {
		IMarkerProvider result = IMarkerProvider.NULL;

		synchronized (providers) {
			prune();

			for (IMarkerProvider next : providers) {
				if (next.canProvideMarkersFor(resource)) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	private void removeProvider(String className) {
		synchronized (providers) {
			for (Iterator<IMarkerProvider> iter = providers.iterator(); iter
				.hasNext();) {

				IMarkerProvider next = iter.next();
				if (next instanceof MyRegistryReader.Descriptor) {
					MyRegistryReader.Descriptor desc = (MyRegistryReader.Descriptor) next;
					if (className.equals(desc.getClassName())) {
						iter.remove();
						break;
					}
				} else if (className.equals(next.getClass().getName())) {
					iter.remove();
					break;
				}
			}
		}
	}

	//
	// Nested types
	//

	private class MyRegistryReader
			extends RegistryReader {

		private static final String E_ENABLEMENT = "enablement";

		private static final String A_CLASS = "class";

		private static final String E_PROVIDER = "provider";

		private Descriptor currentDescriptor;

		private boolean inEnablement;

		MyRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID,
				EXT_POINT);
		}

		@Override
		protected boolean readElement(IConfigurationElement element, boolean add) {
			return add
				? handleAdd(element)
				: handleRemove(element);
		}

		private boolean handleAdd(IConfigurationElement element) {
			boolean result = false;

			if (E_PROVIDER.equals(element.getName())) {
				inEnablement = false;

				if (element.getAttribute(A_CLASS) == null) {
					logMissingAttribute(element, A_CLASS);
				} else {
					currentDescriptor = new Descriptor(element, A_CLASS);
					providers.add(currentDescriptor);
				}

				result = true;
			} else if (E_ENABLEMENT.equals(element.getName())) {
				if (currentDescriptor != null) {
					inEnablement = true;
					try {
						currentDescriptor
							.setMatchResourceExpression(ExpressionConverter
								.getDefault().perform(element));
						result = true;
					} catch (CoreException e) {
						Activator.getDefault().getLog().log(e.getStatus());
					}
				}
			} else {
				result = inEnablement; // ignore contents of the <enablement/>
			}

			return result;
		}

		private boolean handleRemove(IConfigurationElement element) {
			boolean result = true;

			if (E_PROVIDER.equals(element.getName())) {
				String className = element.getAttribute(A_CLASS);
				if (className == null) {
					logMissingAttribute(element, A_CLASS);
					result = false;
				} else {
					removeProvider(className);
				}
			}

			return result;
		}

		private class Descriptor
				extends PluginClassDescriptor
				implements IMarkerProvider {

			private Expression matchResource;

			private IMarkerProvider instance;

			Descriptor(IConfigurationElement element, String attributeName) {
				super(element, attributeName);
			}

			String getClassName() {
				return element.getAttribute(attributeName);
			}

			void setMatchResourceExpression(Expression expression) {
				this.matchResource = expression;
			}

			IMarkerProvider getInstance() {
				if (instance == null) {
					try {
						instance = (IMarkerProvider) createInstance();
					} catch (Exception e) {
						Activator.log.error(
							"Failed to instantiate marker provider extension.",
							e);
						instance = IMarkerProvider.NULL;
					}

					needPrune = true;
				}

				return instance;
			}

			public boolean canProvideMarkersFor(Resource resource) {
				return (instance == null)
					? evaluateEnablement(resource)
					: instance.canProvideMarkersFor(resource);
			}

			private boolean evaluateEnablement(Resource resource) {
				boolean result;

				if (matchResource != null) {
					IEvaluationContext ctx = new EvaluationContext(null,
						resource);

					ctx.addVariable("isFile", getFile(resource) != null);

					EvaluationResult evalResult = EvaluationResult.FALSE;
					try {
						evalResult = matchResource.evaluate(ctx);
					} catch (CoreException e) {
						Activator.getDefault().getLog().log(e.getStatus());
					}

					result = EvaluationResult.TRUE.equals(evalResult);
				} else {
					result = getInstance().canProvideMarkersFor(resource);
				}

				return result;
			}

			public Collection<? extends IPapyrusMarker> getMarkers(
					Resource resource, String type, boolean includeSubtypes)
					throws CoreException {

				return getInstance()
					.getMarkers(resource, type, includeSubtypes);
			}

			public void createMarkers(Resource resource, Diagnostic diagnostic,
					IProgressMonitor monitor)
					throws CoreException {

				getInstance().createMarkers(resource, diagnostic, monitor);
			}

			public void deleteMarkers(EObject object, IProgressMonitor monitor)
					throws CoreException {

				getInstance().deleteMarkers(object, monitor);
			}

			public void deleteMarkers(Resource resource,
					IProgressMonitor monitor)
					throws CoreException {

				getInstance().deleteMarkers(resource, monitor);
			}
		}
	}
}
