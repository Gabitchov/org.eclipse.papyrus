/**
 * <copyright>
 * 
 * Copyright (c) 2008-2011 See4sys, BMW Car IT, itemis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     See4sys - Initial API and implementation
 *     BMW Car IT - Added/Updated javadoc
 *     itemis - [346715] IMetaModelDescriptor methods of MetaModelDescriptorRegistry taking EObject or Resource arguments should not start new EMF transactions
 *     itemis - [357962] Make sure that problems occurring when saving model elements in a new resource are not recorded as errors/warnings on resource 
 * </copyright>
 */
package org.eclipse.papyrus.emf.compare.transactional.editor.sphinx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.sphinx.emf.Activator;
import org.eclipse.sphinx.emf.edit.TransientItemProvider;
import org.eclipse.sphinx.emf.internal.messages.Messages;
import org.eclipse.sphinx.emf.resource.ExtendedResource;
import org.eclipse.sphinx.emf.resource.ExtendedResourceAdapterFactory;
import org.eclipse.sphinx.emf.resource.ScopingResourceSetImpl;
import org.eclipse.sphinx.platform.util.ExtendedPlatform;
import org.eclipse.sphinx.platform.util.PlatformLogUtil;
import org.eclipse.sphinx.platform.util.XMLRootElementHandler;
import org.xml.sax.SAXException;

/**
 * Utility class for resource management.
 */
public final class EcoreResourceUtil {

	// Prevent from instantiation
	private EcoreResourceUtil() {
	}

	/**
	 * Returns an instance of {@link ExtensibleURIConverterImpl} where the URI mappings are initialized in such a way
	 * that normalization of non-platform:/resource {@link URI}s which reference resources inside the workspace yields
	 * the corresponding platform:/resource {@link URI}s.
	 * 
	 * @return An instance of {@link ExtensibleURIConverterImpl} containing URI mappings for normalizing
	 *         non-platform:/resource {@link URI}s referencing workspace resources to corresponding platform:/resource
	 *         {@link URI}s.
	 */
	public static URIConverter getURIConverter() {
		return getURIConverter(null);
	}

	/**
	 * Returns the {@link URIConverter URI converter} of given {@link ResourceSet resource set}. If no
	 * {@link ResourceSet resource set} is provided an instance of {@link ExtensibleURIConverterImpl} is returned
	 * instead. In both cases, the {@link URIConverter URI converter}'s URI mappings are initialized in such a way that
	 * normalization of non-platform:/resource {@link URI}s which reference resources inside the workspace yields the
	 * corresponding platform:/resource {@link URI}s.
	 * 
	 * @param resourceSet
	 *            The {@link ResourceSet resource set} whose {@link URIConverter URI converter} is to be retrieved.
	 * @return The {@link URIConverter URI converter} of given {@link ResourceSet resource set}, or an instance of
	 *         {@link ExtensibleURIConverterImpl} if no such is provided, containing URI mappings for normalizing
	 *         non-platform:/resource {@link URI}s referencing workspace resources to corresponding platform:/resource
	 *         {@link URI}s.
	 */
	public static URIConverter getURIConverter(ResourceSet resourceSet) {
		// Retrieve or create URI converter
		URIConverter uriConverter;
		if (resourceSet != null) {
			uriConverter = resourceSet.getURIConverter();
		} else {
			uriConverter = new ExtensibleURIConverterImpl();
		}
		if (Platform.isRunning()) {
			// Initialize URI mappings
			IPath workspaceRootPath = ResourcesPlugin.getWorkspace().getRoot().getFullPath().addTrailingSeparator();
			URI workspaceRootURI = URI.createPlatformResourceURI(workspaceRootPath.toString(), true);

			IPath workspaceRootLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation().addTrailingSeparator();
			URI workspaceRootLocationURI = URI.createURI(workspaceRootLocation.toString(), true);
			URI workspaceRootLocationFileURI = URI.createFileURI(workspaceRootLocation.toString());

			uriConverter.getURIMap().put(workspaceRootLocationURI, workspaceRootURI);
			uriConverter.getURIMap().put(workspaceRootLocationFileURI, workspaceRootURI);
		}
		return uriConverter;
	}

	/**
	 * Converts given {@link URI} into an absolute file {@link URI}.
	 * 
	 * @param uri
	 *            The {@link URI} to be converted.
	 * @return Absolute file {@link URI} for the given {@link URI} or given {@link URI} if no conversion is possible.
	 */
	public static URI convertToAbsoluteFileURI(URI uri) {
		Assert.isNotNull(uri);

		// FIXME File bug to EMF: CommonPlugin.asLocalURI() is unable to convert URIs that start with a driver letter
		// (IOException raised and caught internally)
		if (!uri.isRelative() && uri.scheme().matches("[A-Z]")) { //$NON-NLS-1$
			uri = URI.createFileURI(uri.toString());
		}

		// Try to convert given URI to absolute file URI right away
		URI convertedURI = CommonPlugin.asLocalURI(uri);

		// Resulting URI still relative?
		if (convertedURI.isRelative()) {
			// Normalize given URI and try to convert it again
			uri = getURIConverter().normalize(uri);
			convertedURI = CommonPlugin.asLocalURI(uri);
		}

		return convertedURI;
	}

	/**
	 * Converts given URI into a platform resource URI.
	 * 
	 * @param uri
	 *            The {@link URI} to be converted.
	 * @return platform resource URI for the given URI or given URI if it references a location outside the workspace or
	 *         platform is not available.
	 */
	public static URI convertToPlatformResourceURI(URI uri) {
		Assert.isNotNull(uri);

		// Already a platform resource URI?
		if (uri.isPlatformResource()) {
			return uri;
		} else {
			// Try to convert given URI to platform resource URI
			return getURIConverter().normalize(uri);
		}
	}

	/**
	 * Proves if resource specified by an URI exists.
	 * 
	 * @param uri
	 *            The URI to prove Returns <b>true</b> only if the URI represents a file and if this file exists.
	 */
	public static boolean exists(URI uri) {
		if (uri != null) {
			return getURIConverter().exists(uri, null);
		}
		return false;
	}

	/**
	 * Returns the id of the content type of the file behind given {@link URI}.
	 * 
	 * @param uri
	 *            The {@link URI} whose content type id is to be established.
	 * @return The id of the content type of the file behind given {@link URI}, or <code>null</code> if given
	 *         {@link URI} references a resource which is no file (e.g., a folder or project), or a file that does not
	 *         exist or has no content type.
	 */
	public static String getContentTypeId(URI uri) {
		if (uri != null) {
			try {
				Map<String, ?> contentDescription = getURIConverter().contentDescription(uri, null);
				return (String) contentDescription.get(ContentHandler.CONTENT_TYPE_PROPERTY);
			} catch (Exception ex) {
				PlatformLogUtil.logAsError(Activator.getPlugin(), ex);
			}
		}
		return null;
	}

	/**
	 * Determines if {@link Resource resource} behind specified {@link URI} is read-only. Returns <code>false</code> if
	 * this resource does not exist.
	 * 
	 * @param uri
	 *            The {@link URI} identifying the {@link Resource resource} to be investigated.
	 * @return <code>true</code> if {@link Resource resource} behind specified {@link URI} is read-only, and
	 *         <code>false</code> otherwise.
	 */
	public static boolean isReadOnly(URI uri) {
		if (uri != null) {
			Map<String, ?> attributes = getURIConverter().getAttributes(uri, null);
			Object readOnly = attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);
			return readOnly instanceof Boolean && (Boolean) readOnly;
		}
		return false;
	}

	/**
	 * Reads the model namespace (i.e. XML namespace) of given {@link Resource resource}. Returns a meaningful result
	 * only if given {@link Resource resource} is an XML document.
	 * 
	 * @param resource
	 *            The {@link Resource resource} to investigate.
	 * @return The model namespace denoted in given {@link Resource resource} or <code>null</code> if the
	 *         {@link Resource resource} is either a non-XML file or an XML file which is not well-formed or has no
	 *         model namespace.
	 */
	public static String readModelNamespace(Resource resource) {
		if (resource != null) {
			return readModelNamespace(EcoreResourceUtil.getURIConverter(resource.getResourceSet()), resource.getURI());
		}
		return null;
	}

	/**
	 * Reads the model namespace (i.e. XML namespace) of resource behind given {@link URI}. Returns a meaningful result
	 * only if the resource in question is an XML document.
	 * 
	 * @param uriConverter
	 *            The {@link URIConverter uriConverter} used to create {@link InputStream inputstream} . May be
	 *            <code>null</code>.
	 * @param uri
	 *            The {@link URI uri} of the resource to investigate.
	 * @return The model namespace denoted in resource behind given {@link URI} or <code>null</code> if the resource in
	 *         question is either a non-XML file or an XML file which is not well-formed or has no model namespace.
	 */
	public static String readModelNamespace(URIConverter uriConverter, URI uri) {
		String namespace = null;
		if (exists(uri)) {
			InputStream inputStream = null;
			try {
				uriConverter = uriConverter != null ? uriConverter : new ExtensibleURIConverterImpl();
				inputStream = uriConverter.createInputStream(uri);
				XMLRootElementHandler handler = new XMLRootElementHandler();
				handler.parseContents(inputStream);
				namespace = handler.getRootElementNamespace();
			} catch (SAXException ex) {
				// Ignore parse exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (IOException ex) {
				// Ignore I/O exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (Exception ex) {
				PlatformLogUtil.logAsWarning(Activator.getPlugin(), ex);
			} finally {
				ExtendedPlatform.safeClose(inputStream);
			}
		}
		return namespace;
	}

	/**
	 * Reads the target namespace of given {@link Resource resource}. Returns a meaningful result only if given
	 * {@link Resource resource} is an XML document.
	 * 
	 * @param resource
	 *            The {@link Resource resource} to investigate.
	 * @return The target namespace denoted in given {@link Resource resource} or <code>null</code> if the
	 *         {@link Resource resource} is either a not an XML file or an XML file which is not well-formed or has no
	 *         target namespace.
	 */
	public static String readTargetNamespace(Resource resource) {
		return readTargetNamespace(resource, (String[]) null);
	}

	public static String readTargetNamespace(Resource resource, String... targetNamespaceExcludePatterns) {
		if (resource != null) {
			return readTargetNamespace(getURIConverter(resource.getResourceSet()), resource.getURI(), targetNamespaceExcludePatterns);
		}
		return null;
	}

	/**
	 * Reads the target namespace of the resource behind given {@link URI}. Returns a meaningful result only if the
	 * resource in question is an XML document.
	 * 
	 * @param uriConverter
	 *            The {@link URIConverter uriConverter} used to create {@link InputStream input stream} . May be
	 *            <code>null</code>.
	 * @param uri
	 *            The {@link URI uri} of the resource to investigate.
	 * @return The target namespace denoted in resource behind given {@link URI} or <code>null</code> if the resource in
	 *         question is either a not an XML file or an XML file which is not well-formed or has no target namespace.
	 */
	public static String readTargetNamespace(URIConverter uriConverter, URI uri) {
		return readTargetNamespace(uriConverter, uri, (String[]) null);
	}

	public static String readTargetNamespace(URIConverter uriConverter, URI uri, String... targetNamespaceExcludePatterns) {
		String targetNamespace = null;
		if (exists(uri)) {
			InputStream inputStream = null;
			try {
				uriConverter = uriConverter != null ? uriConverter : new ExtensibleURIConverterImpl();
				inputStream = uriConverter.createInputStream(uri);
				XMLRootElementHandler handler = new XMLRootElementHandler();
				if (targetNamespaceExcludePatterns != null) {
					handler.seTargetNamespaceExcludePatterns(targetNamespaceExcludePatterns);
				}
				handler.parseContents(inputStream);
				targetNamespace = handler.getTargetNamespace();
			} catch (SAXException ex) {
				// Ignore parse exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (IOException ex) {
				// Ignore I/O exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (Exception ex) {
				PlatformLogUtil.logAsWarning(Activator.getPlugin(), ex);
			} finally {
				ExtendedPlatform.safeClose(inputStream);
			}
		}
		return targetNamespace;
	}

	/**
	 * Retrieves the XML comments located above the root element in given {@link Resource resource}. Returns a
	 * meaningful result only if given {@link Resource resource} is an XML document.
	 * 
	 * @param resource
	 *            The {@link Resource resource} to investigate.
	 * @return Collection of strings representing the retrieved XML comments or empty collection if no such could be
	 *         found.
	 */
	public static Collection<String> readRootElementComments(Resource resource) {
		if (resource != null) {
			return readRootElementComments(getURIConverter(resource.getResourceSet()), resource.getURI());
		}
		return Collections.emptyList();
	}

	/**
	 * Retrieves the XML comments located above the root element in resource behind given {@link URI}. Returns a
	 * meaningful result only if the resource in question is an XML document.
	 * 
	 * @param uriConverter
	 *            The {@link URIConverter uriConverter} used to create {@link InputStream input stream} . May be
	 *            <code>null</code>.
	 * @param uri
	 *            The {@link URI uri} of the resource to investigate.
	 * @return Collection of strings representing the retrieved XML comments or empty collection if no such could be
	 *         found.
	 */
	public static Collection<String> readRootElementComments(URIConverter uriConverter, URI uri) {
		Collection<String> comments = new ArrayList<String>();

		if (exists(uri)) {
			InputStream inputStream = null;
			try {
				uriConverter = uriConverter != null ? uriConverter : new ExtensibleURIConverterImpl();
				inputStream = uriConverter.createInputStream(uri);
				XMLRootElementHandler handler = new XMLRootElementHandler();
				// Parse and retrieve comments above root element
				handler.parseContents(inputStream, true);
				comments = handler.getRootElementComments();
			} catch (SAXException ex) {
				// Ignore parse exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (IOException ex) {
				// Ignore I/O exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (Exception ex) {
				PlatformLogUtil.logAsWarning(Activator.getPlugin(), ex);
			} finally {
				ExtendedPlatform.safeClose(inputStream);
			}
		}
		return comments;
	}

	/**
	 * Reads the XSI schema location of given {@link Resource resource} and extracts pairs of namespace and schema URIs
	 * from it (see http://www.w3.org/TR/xmlschema-0/#schemaLocation for details). Returns a meaningful result only if
	 * given {@link Resource resource} is an XML document.
	 * 
	 * @param resource
	 *            The {@link Resource resource} to investigate.
	 * @return Pairs of namespace and schema URIs in given {@link Resource resource} or an empty map if the
	 *         {@link Resource resource} is either a non-XML file or an XML file which is not well-formed or has no XSI
	 *         schema location.
	 */
	public static Map<String, String> readSchemaLocationEntries(Resource resource) {
		if (resource != null) {
			return readSchemaLocationEntries(getURIConverter(resource.getResourceSet()), resource.getURI());
		}
		return Collections.emptyMap();
	}

	/**
	 * Reads the XSI schema location of the resource behind given {@link URI} and extracts pairs of namespace and schema
	 * URIs from it (see http://www.w3.org/TR/xmlschema-0/#schemaLocation for details). Returns a meaningful result only
	 * if the resource in question is an XML document.
	 * 
	 * @param uriConverter
	 *            The {@link URIConverter uriConverter} used to create {@link InputStream input stream} . May be
	 *            <code>null</code>.
	 * @param uri
	 *            The {@link URI uri} of the {@link Resource resource} to investigate.
	 * @return Pairs of namespace and schema URIs in resource behind given {@link URI} or an empty map if the resource
	 *         in question is either a non-XML file or an XML file which is not well-formed or has no XSI schema
	 *         location.
	 */
	public static Map<String, String> readSchemaLocationEntries(URIConverter uriConverter, URI uri) {
		String schemaLocation = null;
		if (exists(uri)) {
			InputStream inputStream = null;
			try {
				uriConverter = uriConverter != null ? uriConverter : new ExtensibleURIConverterImpl();
				inputStream = uriConverter.createInputStream(uri);
				XMLRootElementHandler handler = new XMLRootElementHandler();
				handler.parseContents(inputStream);
				schemaLocation = handler.getSchemaLocation();
			} catch (SAXException ex) {
				// Ignore parse exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (IOException ex) {
				// Ignore I/O exceptions because we might be face to non-XML files or XML files
				// which are not well-formed - that's o.k. simply return null
			} catch (Exception ex) {
				PlatformLogUtil.logAsWarning(Activator.getPlugin(), ex);
			} finally {
				ExtendedPlatform.safeClose(inputStream);
			}
		}
		Map<String, String> schemaLocationEntries = new HashMap<String, String>();
		if (schemaLocation != null) {
			String[] schemaLocationTokens = schemaLocation.split(" "); //$NON-NLS-1$
			for (int i = 0; i + 1 < schemaLocationTokens.length; i = i + 2) {
				schemaLocationEntries.put(schemaLocationTokens[i], schemaLocationTokens[i + 1]);
			}
		}
		return schemaLocationEntries;
	}

	/**
	 * Returns a set of default options which can be used for loading a Resource.
	 * 
	 * @return A set of default options for loading a Resource.
	 */
	public static Map<?, ?> getDefaultLoadOptions() {
		HashMap<Object, Object> options = new HashMap<Object, Object>(1);

		// Be fault-tolerant and enable files which are partially broken to be loaded
		options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);

		return options;
	}

	/**
	 * Returns a map with the default options for resource saving.
	 * 
	 * @return This method will return an empty map.
	 */
	public static Map<?, ?> getDefaultSaveOptions() {
		return Collections.emptyMap();
	}

	/**
	 * Retrieves the top level EObject contained within a resource.
	 * 
	 * @param resource
	 *            Some model resource
	 * @return The first EObject from the resource's content. Returns <code>null</code> if:
	 *         <ul>
	 *         <li><code>resource</code> is <code>null</code>;</li>
	 *         <li><code>resource</code> has no content;</li>
	 *         <li>content does not contain an EObject as its first element.</li>
	 *         </ul>
	 */
	public static EObject getModelRoot(Resource resource) {
		if (resource != null) {
			EList<EObject> contents = resource.getContents();
			if (contents.size() > 0) {
				return resource.getContents().get(0);
			}
		}
		return null;
	}

	/**
	 * Returns the root element of the model owned by the resource specified by the given URI. Does not explicitly ask
	 * the loading of the resource if it has not already been loaded in resource set.
	 * 
	 * @param resourceSet
	 *            The resource set into which model resource must be loaded.
	 * @param uri
	 *            The URI to resolve; i.e. the URI of the model resource to load.
	 * @return The root of the loaded model or <code>null</code> if underlying resource has not been loaded.
	 */
	public static EObject getModelRoot(ResourceSet resourceSet, URI uri) {
		return loadModelRoot(resourceSet, uri, null, false);
	}

	/**
	 * Returns the element of the model owned by the resource specified by the given URI and pointed by the given
	 * fragment. Does not explicitly ask the loading of the resource if it has not already been loaded in resource set.
	 * 
	 * @param resourceSet
	 *            The resource set into which model resource must be loaded.
	 * @param uri
	 *            The URI to resolve; i.e. the URI of the model resource to load.
	 * @return The element of the loaded model pointed by the fragment of the uri or <code>null</code> if underlying
	 *         resource has not been loaded.
	 */
	public static EObject getModelFragment(ResourceSet resourceSet, URI uri) {
		return loadModelFragment(resourceSet, uri, false);
	}

	/**
	 * Returns the element of the model pointed by the fragment owned by the resource specified by the given {@link URI
	 * uri}. Asks the loading of the resource if it has not already been loaded in resource set.
	 * 
	 * @param resourceSet
	 *            The resource set into which model resource must be loaded.
	 * @param uri
	 *            The {@link URI uri} containing a fragment to resolve; i.e. the URI of the model resource to load
	 *            append with the reference to the model object.
	 * @return The object of the loaded model referenced by the fragment, or <code>null</code> if the URI cannot be
	 *         resolved to an existing file.
	 */
	public static EObject loadModelFragment(ResourceSet resourceSet, URI uri) {
		return loadModelFragment(resourceSet, uri, true);
	}

	private static EObject loadModelFragment(ResourceSet resourceSet, URI uri, boolean loadOnDemand) {
		Assert.isNotNull(resourceSet);
		Assert.isNotNull(uri);

		if (uri.hasFragment()) {
			// Try to convert given URI to platform:/resource URI if not yet so
			/*
			 * !! Important Note !! This is necessary in order to avoid that resources which are located inside the
			 * workspace get loaded multiple times just because they are referenced by URIs with different schemes. If
			 * given resource set were an instance of ResourceSetImpl this extra conversion wouldn't be necessary.
			 * org.eclipse.emf.ecore.resource.ResourceSet.getResource(URI, boolean) normalizes and compares given URI
			 * and to normalized copies of URIs of already present resources and thereby avoids multiple loading of same
			 * resources on its own. This is however not true when ExtendedResourceSetImpl or a subclass of it is used.
			 * Herein, URI normalization and comparison has been removed from
			 * org.eclipse.sphinx.emf.resource.ExtendedResourceSetImpl.getResource(URI, boolean) in order to increase
			 * runtime performance.
			 */
			if (!uri.isPlatform()) {
				uri = convertToPlatformResourceURI(uri);
			}

			return resourceSet.getEObject(uri, loadOnDemand);
		}
		return null;
	}

	/**
	 * Returns the root element of the model owned by the resource specified by the given URI. Asks the loading of the
	 * resource if it has not already been loaded in resource set.
	 * 
	 * @param resourceSet
	 *            The resource set into which model resource must be loaded.
	 * @param uri
	 *            The URI to resolve; i.e. the URI of the model resource to load.
	 * @param options
	 *            The load options. If <code>null</code>, default loading options are used.
	 * @return The root of the loaded model.
	 */
	public static EObject loadModelRoot(ResourceSet resourceSet, URI uri, Map<?, ?> options) {
		return loadModelRoot(resourceSet, uri, options, true);
	}

	/**
	 * Loads a model from a {@link java.io.File File} in a given {@link ResourceSet}.
	 * <p>
	 * This will return the first root of the loaded model, other roots can be accessed via the resource's content.
	 * </p>
	 * 
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @param file
	 *            {@link java.io.File File} containing the model to be loaded.
	 * @param options
	 *            The load options. If <code>null</code>, default loading options are used.
	 * @return The model loaded from the file.
	 * @throws IOException
	 *             If the given file does not exist.
	 */
	public static EObject loadModelRoot(ResourceSet resourceSet, File file, Map<?, ?> options) throws IOException {
		Assert.isNotNull(file);
		return loadModelRoot(resourceSet, URI.createFileURI(file.getPath()), options);
	}

	/**
	 * Returns the {@linkplain Resource resource} corresponding to the specified {@linkplain Object object}.
	 * <p>
	 * The supported object types are:
	 * <ul>
	 * <li>{@linkplain org.eclipse.emf.ecore.resource.Resource}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.EObject}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.util.FeatureMap.Entry}</li>
	 * <li>{@linkplain org.eclipse.emf.edit.provider.IWrapperItemProvider}</li>
	 * </ul>
	 * <p>
	 * If the type of the specified object does not belongs to that list of supported types, <code>null</code> is
	 * returned.
	 * 
	 * @param object
	 *            The object from which a resource must be returned.
	 * @return The underlying resource from the given object.
	 */
	public static Resource getResource(Object object) {
		if (object instanceof Resource) {
			return (Resource) object;
		} else if (object instanceof EObject) {
			return getResource((EObject) object);
		} else if (object instanceof IWrapperItemProvider) {
			return getResource((IWrapperItemProvider) object);
		} else if (object instanceof FeatureMap.Entry) {
			return getResource((FeatureMap.Entry) object);
		} else if (object instanceof TransientItemProvider) {
			return getResource((TransientItemProvider) object);
		}
		return null;
	}

	/**
	 * Retrieves the {@linkplain Resource resource} corresponding to the given {@link EObject object}.
	 * 
	 * @param eObject
	 *            The {@linkplain EObject object} whose {@link Resource resource} is to be returned.
	 * @return The resource corresponding to the specified {@link EObject object}.
	 */
	public static Resource getResource(final EObject eObject) {
		if (eObject != null) {
			return eObject.eResource();
		}
		return null;
	}

	/**
	 * Retrieves the {@linkplain Resource resource} owning the given {@link IWrapperItemProvider provider}.
	 * <p>
	 * First retrieves the owner of the {@link IWrapperItemProvider provider}; then, if owner is an {@linkplain EObject}
	 * returns its resource, else delegates to {@linkplain #getResource(Object)}.
	 * 
	 * @param provider
	 *            The {@linkplain IWrapperItemProvider} whose resource must be returned.
	 * @return The resource containing the specified {@link IWrapperItemProvider provider}; <code>null</code> if that
	 *         provider is <code>null</code>.
	 */
	public static Resource getResource(final IWrapperItemProvider provider) {
		if (provider != null) {
			Object owner = provider.getOwner();
			if (owner instanceof EObject) {
				return ((EObject) owner).eResource();
			} else {
				Object unwrapped = AdapterFactoryEditingDomain.unwrap(provider);
				return getResource(unwrapped);
			}
		}
		return null;
	}

	/**
	 * Retrieves the {@linkplain Resource resource} matching the given {@link FeatureMap.Entry entry}.
	 * <p>
	 * First unwraps the {@link FeatureMap.Entry entry}; then, delegates to {@linkplain #getResource(Object)}.
	 * 
	 * @param entry
	 *            The {@linkplain FeatureMap.Entry} whose underlying resource must be returned.
	 * @return The resource under the specified {@link FeatureMap.Entry entry}.
	 */
	public static Resource getResource(FeatureMap.Entry entry) {
		Object unwrapped = AdapterFactoryEditingDomain.unwrap(entry);
		return getResource(unwrapped);
	}

	/**
	 * Retrieves the {@linkplain Resource resource} owning the given {@link TransientItemProvider provider}.
	 * <p>
	 * First retrieves the owner of the {@link TransientItemProvider provider}; then, if owner is an
	 * {@linkplain EObject} returns its resource, else delegates to {@linkplain #getResource(Object)}.
	 * 
	 * @param provider
	 *            The {@linkplain TransientItemProvider} whose resource must be returned.
	 * @return The resource containing the specified {@link IWrapperItemProvider provider}; <code>null</code> if that
	 *         provider is <code>null</code>.
	 */
	public static Resource getResource(TransientItemProvider provider) {
		if (provider != null) {
			Notifier target = provider.getTarget();
			if (target instanceof EObject) {
				return ((EObject) target).eResource();
			}
		}
		return null;
	}

	/**
	 * Returns the contents of given Resource. If the provided Resource is
	 * <tt>null<tt> the method will return an empty list.
	 * 
	 * @param resource
	 * @return The content of the given <code>resource</code> or an empty list if no Resource is provided.
	 */
	public static EList<EObject> getResourceContents(Resource resource) {
		if (resource != null) {
			return resource.getContents();
		}
		return new BasicEList<EObject>(0);
	}

	/**
	 * Returns the name of the model for the provided model root.
	 * 
	 * @param modelRoot
	 *            Can either be an EObject or a Resource.
	 * @return The name of the model specified by the given <code>modelRoot</code>.
	 */
	public static String getModelName(Notifier modelRoot) {
		EObject modelContent = null;
		if (modelRoot instanceof EObject) {
			modelContent = (EObject) modelRoot;
		}
		if (modelRoot instanceof Resource) {
			modelContent = EcoreResourceUtil.getModelRoot((Resource) modelRoot);
		}
		if (modelContent != null) {
			String modelPackageName = modelContent.eClass().getEPackage().getName();
			return modelPackageName.substring(0, 1).toUpperCase() + modelPackageName.substring(1);
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * Proves if the model with the specified {@link URI uri} is already loaded into the given {@link ResourceSet
	 * resourceSet}.
	 * 
	 * @param resourceSet
	 *            The resource set to search resource in.
	 * @param uri
	 *            The URI of the concerned resource.
	 * @return <ul>
	 *         <li><tt><b>true</b>&nbsp;&nbsp;</tt> if resource set contains the model with specified the URI;</li>
	 *         <li><tt><b>false</b>&nbsp;</tt> otherwise.</li>
	 *         </ul>
	 */
	public static boolean isResourceLoaded(ResourceSet resourceSet, URI uri) {
		if (resourceSet != null && uri != null) {
			Resource resource = resourceSet.getResource(uri, false);
			return resource != null && resource.isLoaded();
		}
		return false;
	}

	/**
	 * Create the new model given by the {@link EObject modelRoot} parameter. The method will create a new Resource
	 * specified by a given URI and content type id. The new created resource will be added to a given ResourceSet.
	 * 
	 * @param resourceSet
	 *            The ResourceSet to which the new Resource is added.
	 * @param uri
	 *            The URI specifying the location to which the Resource is to be saved to.
	 * @param contentTypeId
	 *            The id of the content type of which new created Resource shall be of.
	 * @param modelRoot
	 *            Can either be an EObject or a Resource.
	 * @since 0.7.0
	 */
	public static Resource addNewModelResource(ResourceSet resourceSet, URI uri, String contentTypeId, EObject modelRoot) {
		if (uri != null && modelRoot != null) {
			try {
				// Create new ResourceSet if none has been provided
				if (resourceSet == null) {
					resourceSet = new ScopingResourceSetImpl();
				}

				// Unload and remove model resource if it is already loaded
				Resource resource = resourceSet.getResource(uri, false);
				if (resource != null) {
					try {
						unloadResource(resource);
					} catch (Exception ex) {
						PlatformLogUtil.logAsError(Activator.getPlugin(), ex);
					}
				}

				// Create and add new model resource to the resourceSet
				resource = resourceSet.createResource(uri, contentTypeId);
				if (resource != null) {
					resource.getContents().add(modelRoot);
				}
				return resource;
			} catch (Exception ex) {
				throw new WrappedException(ex);
			}
		}
		return null;
	}

	/**
	 * The {@link Resource} provided as argument will be added to the given ResourceSet if it is not already inside.
	 * 
	 * @param resourceSet
	 *            The resourceSet where to add resources
	 * @param resource
	 *            The resource to add
	 * @since 0.7.0
	 */
	public static void addModelResource(ResourceSet resourceSet, Resource resource) {
		if (resource != null) {
			// Create new ResourceSet if none has been provided
			if (resourceSet == null) {
				resourceSet = new ScopingResourceSetImpl();
			}

			// Add resource to resourceSet if not already present
			if (resourceSet.getResource(resource.getURI(), false) == null) {
				resourceSet.getResources().add(resource);
			}
		}
	}

	/**
	 * Saves the new model given by the {@link EObject modelRoot} parameter. The method will create a new Resource
	 * specified by a given URI and content type id. The new created resource will be added to a given ResourceSet and
	 * saved.
	 * 
	 * @param resourceSet
	 *            The ResourceSet to which the new Resource is added.
	 * @param uri
	 *            The URI specifying the location to which the Resource is to be saved to.
	 * @param contentTypeId
	 *            The id of the content type of which new created Resource shall be of.
	 * @param modelRoot
	 *            Can either be an EObject or a Resource.
	 * @param options
	 *            The save options.
	 * @see #getDefaultSaveOptions()
	 */
	public static void saveNewModelResource(ResourceSet resourceSet, URI uri, String contentTypeId, EObject modelRoot, Map<?, ?> options) {
		// Create new model resource and add it to the provided ResourceSet
		Resource resource = addNewModelResource(resourceSet, uri, contentTypeId, modelRoot);

		// Save the newly created resource
		saveModelResource(resource, options);
	}

	/**
	 * Saves the specified <code>resource</code>.
	 * 
	 * @param resource
	 *            The {@link Resource resource} to be saved.
	 * @param options
	 *            The save options.
	 * @see #getDefaultSaveOptions()
	 */
	public static void saveModelResource(Resource resource, Map<?, ?> options) {
		if (resource != null) {
			try {
				resource.save(options);
			} catch (IOException ex) {
				// Record exception as error on resource
				Throwable cause = ex.getCause();
				Exception exception = cause instanceof Exception ? (Exception) cause : ex;
				URI uri = resource.getURI();
				resource.getErrors()
						.add(new XMIException(NLS.bind(Messages.error_problemOccurredWhenSavingResource, uri.toString()), exception, uri.toString(),
								1, 1));

				// Re-throw exception
				throw new WrappedException(ex);
			}
		}
	}

	/**
	 * Unloads given {@link Resource resource} and removes it from underlying {@link ResourceSet resourceSet}.
	 * 
	 * @param resource
	 *            The resource to be unloaded.
	 */
	public static void unloadResource(Resource resource) {
		unloadResource(resource, false);
	}

	/**
	 * Unloads given {@link Resource resource} and removes it from underlying {@link ResourceSet resourceSet}.
	 * 
	 * @param resource
	 *            The resource to be unloaded.
	 * @param memoryOptimized
	 *            Will activate the memory optimization option for unloading the resource. This is only available if the
	 *            resource is an XMLResource.
	 */
	public static void unloadResource(Resource resource, boolean memoryOptimized) {
		if (resource != null) {
			try {
				// Perform resource unload, either memory optimized or normally
				if (memoryOptimized) {
					ExtendedResource extendedResource = ExtendedResourceAdapterFactory.INSTANCE.adapt(resource);
					if (extendedResource != null) {
						Map<Object, Object> defaultLoadOptions = extendedResource.getDefaultLoadOptions();
						defaultLoadOptions.put(ExtendedResource.OPTION_UNLOAD_MEMORY_OPTIMIZED, Boolean.TRUE);
					}
				}
				resource.unload();
			} catch (Exception ex) {
				throw new WrappedException(ex);
			} finally {
				// Remove resource from ResourceSet
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet != null) {
					resourceSet.getResources().remove(resource);
				}
			}
		}
	}

	/**
	 * Unloads the resource with the specified URI from the given resource set.
	 * 
	 * @param resourceSet
	 *            A resource set from which the model's resource should be unloaded.
	 * @param uri
	 *            The URI of the resource to unload.
	 */
	public static void unloadResource(ResourceSet resourceSet, URI uri) {
		unloadResource(resourceSet, uri, false);
	}

	/**
	 * Unloads the resource with the specified URI from the given resource set.
	 * <p>
	 * It is recommended to call this method inside a write-transaction (see
	 * {@link EcorePlatformUtil#unloadFile(ResourceSet, IPath)}).
	 * 
	 * @param resourceSet
	 *            A resource set from which the model's resource should be unloaded.
	 * @param uri
	 *            The URI of the resource to unload.
	 * @param memoryOptimized
	 *            Will activate the memory optimization option for unloading the resource. This is only available if the
	 *            resource is an XMLResource.
	 */
	public static void unloadResource(ResourceSet resourceSet, URI uri, boolean memoryOptimized) {
		if (resourceSet != null && uri != null) {
			// Get resource and unload it
			Resource resource = resourceSet.getResource(uri, false);
			unloadResource(resource, memoryOptimized);
		}
	}

	/**
	 * Parses {@link Resource resource} with given {@link URI uri} and validates it against XSD schema with specified
	 * {@link URL url}. Raises an exception if the {@link Resource resource}'s content is not compliant with respect to
	 * XSD schema.
	 * 
	 * @param uri
	 *            The {@link URI uri} of the {@link Resource resource} to be validated.
	 * @param schemaURL
	 *            The {@link URL url} of the XSD schema to be used for validation.
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void validate(URI uri, URL schemaURL) throws SAXException, IOException {
		Assert.isNotNull(uri);

		// 1. Lookup a factory for the W3C XML Schema language
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		// 2. Compile the schema
		Schema schema = factory.newSchema(schemaURL);

		// 3. Get a validator from the schema
		Validator validator = schema.newValidator();

		// 4. Load the resource and validate it
		InputStream stream = null;
		try {
			stream = URIConverter.INSTANCE.createInputStream(uri);
			Source source = new StreamSource(stream);
			validator.validate(source);
		} finally {
			ExtendedPlatform.safeClose(stream);
		}
	}

	/**
	 * Loads from resource set the resource specified by the given URI, or try to load the URI if not in resource set.
	 * 
	 * @param resourceSet
	 *            The resource set into which model resource must be loaded.
	 * @param uri
	 *            The URI to resolve; <em>i.e.</em> the URI of the model resource to load.
	 * @param options
	 *            The loading options.
	 * @param loadOnDemand
	 *            If <code>true</code>, creates and loads the resource if it does not already exist.
	 * @return The resource resolved by the specified URI, or <code>null</code> if there is not one and it is not being
	 *         demand loaded.
	 */
	private static Resource loadModelResource(ResourceSet resourceSet, URI uri, Map<?, ?> options, boolean loadOnDemand) {
		Assert.isNotNull(uri);

		// Create new ResourceSet if none has been provided
		if (resourceSet == null) {
			resourceSet = new ScopingResourceSetImpl();
		}

		// Try to convert given URI to platform:/resource URI if not yet so
		/*
		 * !! Important Note !! This is necessary in order to avoid that resources which are located inside the
		 * workspace get loaded multiple times just because they are referenced by URIs with different schemes. If given
		 * resource set were an instance of ResourceSetImpl this extra conversion wouldn't be necessary.
		 * org.eclipse.emf.ecore.resource.ResourceSet.getResource(URI, boolean) normalizes and compares given URI and to
		 * normalized copies of URIs of already present resources and thereby avoids multiple loading of same resources
		 * on its own. This is however not true when ExtendedResourceSetImpl or a subclass of it is used. Herein, URI
		 * normalization and comparison has been removed from
		 * org.eclipse.sphinx.emf.resource.ExtendedResourceSetImpl.getResource(URI, boolean) in order to increase
		 * runtime performance.
		 */
		if (!uri.isPlatform()) {
			uri = convertToPlatformResourceURI(uri);
		}

		// Just get model resource if it is already loaded
		Resource resource = resourceSet.getResource(uri, false);

		// Load it using specified options if not done so yet and a demand load has been requested
		if ((resource == null || !resource.isLoaded()) && loadOnDemand) {
			if (exists(uri)) {
				if (resource == null) {
					String contentType = getContentTypeId(uri);
					resource = resourceSet.createResource(uri, contentType);
				}
				if (resource != null) {
					try {
						// Capture errors and warnings encountered during resource creation
						/*
						 * !! Important note !! This is necessary because the resource's errors and warnings are
						 * automatically cleared when the loading begins. Therefore, if we don't retrieve them at this
						 * point all previously encountered errors and warnings would be lost (see
						 * org.eclipse.emf.ecore.resource.impl.ResourceImpl.load(InputStream, Map<?, ?>) for details)
						 */
						List<Diagnostic> creationErrors = new ArrayList<Diagnostic>(resource.getErrors());
						List<Diagnostic> creationWarnings = new ArrayList<Diagnostic>(resource.getWarnings());

						// Load resource
						resource.load(options);

						// Make sure that no empty resources are kept in resource set
						if (resource.getContents().isEmpty()) {
							unloadResource(resource, true);
						}

						// Restore creation time errors and warnings
						resource.getErrors().addAll(creationErrors);
						resource.getWarnings().addAll(creationWarnings);
					} catch (IOException ex) {
						// Capture errors and warnings encountered during resource load attempt
						/*
						 * !! Important note !! This is necessary because the resource's errors and warnings are
						 * automatically cleared when it gets unloaded. Therefore, if we don't retrieve them at this
						 * point all encountered errors and warnings encountered during loading would be lost (see
						 * org.eclipse.emf.ecore.resource.impl.ResourceImpl.doUnload() for details)
						 */
						List<Diagnostic> loadErrors = new ArrayList<Diagnostic>(resource.getErrors());
						List<Diagnostic> loadWarnings = new ArrayList<Diagnostic>(resource.getWarnings());

						// Make sure that resource gets unloaded and removed from resource set again
						try {
							unloadResource(resource, true);
						} catch (Exception e) {
							// Log unload problem in Error Log but don't let it go along as runtime exception. It is
							// most likely just a consequence of the load problems encountered before and therefore
							// should not prevent those from being restored as errors and warnings on resource.
							PlatformLogUtil.logAsError(Activator.getPlugin(), e);
						}

						// Restore load time errors and warnings on resource
						resource.getErrors().addAll(loadErrors);
						resource.getWarnings().addAll(loadWarnings);

						// Re-throw exception
						throw new WrappedException(ex);
					}
				}
			}
		}
		return resource;
	}

	/**
	 * Loads the model from the resource specified by the given URI and returns its root element.
	 * 
	 * @param resourceSet
	 *            The resource set into which model resource must be loaded.
	 * @param uri
	 *            The URI to resolve; <em>i.e.</em> the URI of the model resource to load.
	 * @param options
	 *            The load options. If <code>null</code>, default loading options are used.
	 * @param loadOnDemand
	 *            If <code>true</code>, creates and loads the resource if it does not already exist.
	 * @return The root of the loaded model; can be <code>null</code> if resource is not loaded resource set.
	 */
	private static EObject loadModelRoot(ResourceSet resourceSet, URI uri, Map<?, ?> options, boolean loadOnDemand) {
		// Use default loading options when no specified
		if (options == null) {
			options = getDefaultLoadOptions();
		}

		// Load resource from resource set
		Resource resource = loadModelResource(resourceSet, uri, options, loadOnDemand);

		// Obtain and return resource content
		return getModelRoot(resource);
	}
}
