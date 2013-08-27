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
package org.eclipse.papyrus.cdo.internal.core.controlmode;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.net4j.util.ref.Interner;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;


/**
 * A canonical cache of proxy {@link EObject}s by URI.
 */
public class CDOProxyManager {

	private static final String URI_SCHEME = CDOURIUtil.PROTOCOL_NAME;

	private final ResourceSet resourceSet;

	private final ProxyInterner proxies = new ProxyInterner();

	public CDOProxyManager(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public EObject getProxy(URI proxyURI) {
		return proxies.intern(proxyURI);
	}

	protected InternalEObject createProxy(URI uri) {
		InternalEObject result = null;

		CDOID cdoid = CDOIDUtil.read(uri.fragment());
		long oid = CDOIDUtil.getLong(cdoid);
		CDOClassifierRef typeRef = CDOIDUtil.getClassifierRef(cdoid);

		EClassifier resolvedType = typeRef.resolve(resourceSet.getPackageRegistry());

		if(resolvedType instanceof EClass) {
			EClass actualType = (EClass)resolvedType;
			result = (InternalEObject)EcoreUtil.create(actualType);

			StringBuilder fragment = new StringBuilder();
			CDOIDUtil.write(fragment, CDOIDUtil.createLong(oid));

			result.eSetProxyURI(uri.trimFragment().appendFragment(fragment.toString()));
		}

		return result;
	}

	public static boolean isCDOProxyURI(URI uri) {
		boolean result = uri.hasFragment() && URI_SCHEME.equals(uri.scheme());

		if(result) {
			CDOID oid = CDOIDUtil.read(uri.fragment());
			result = oid instanceof CDOClassifierRef.Provider;
		}

		return result;
	}

	public static String createPapyrusCDOURI(EObject object) {
		return createPapyrusCDOURI(object.eResource().getURI(), object);
	}

	public static String createPapyrusCDOURI(URI resourceURI, EObject object) {
		long oid = CDOIDUtil.getLong(CDOUtils.getCDOID(object));
		CDOClassifierRef typeRef = new CDOClassifierRef(object.eClass());
		CDOID oidWithTypeRef = CDOIDUtil.createLongWithClassifier(oid, typeRef);

		StringBuilder result = new StringBuilder();
		result.append(resourceURI);
		result.append('#');
		CDOIDUtil.write(result, oidWithTypeRef);

		return result.toString();
	}

	public static String extractOIDFragment(URI proxyURI) {
		String result = null;

		CDOID oid = CDOIDUtil.read(proxyURI.fragment());
		if(oid.isObject()) {
			StringBuilder buf = new StringBuilder();
			CDOIDUtil.write(buf, CDOIDUtil.createLong(CDOIDUtil.getLong(oid)));
			result = buf.toString();
		}

		return result;
	}

	//
	// Nested types
	//

	private final class ProxyInterner extends Interner<InternalEObject> {

		public synchronized InternalEObject intern(URI proxyURI) {
			InternalEObject result = null;

			long oid = CDOIDUtil.getLong(CDOIDUtil.read(proxyURI.fragment()));
			final int hashCode = hashCode(oid);

			for(Entry<InternalEObject> entry = getEntry(hashCode); (entry != null) && (result == null); entry = entry.getNextEntry()) {
				result = entry.get();

				if((result != null) && getOID(result) != oid) {
					result = null;
				}
			}

			if(result == null) {
				result = createProxy(proxyURI);
				addEntry(createEntry(result, hashCode));
			}

			return result;
		}

		private long getOID(InternalEObject object) {
			long result;

			if(object.eIsProxy()) {
				result = CDOIDUtil.getLong(CDOIDUtil.read(object.eProxyURI().fragment()));
			} else {
				result = CDOIDUtil.getLong(CDOUtils.getCDOID(object));
			}

			return result;
		}

		@Override
		protected int hashCode(InternalEObject proxy) {
			return hashCode(getOID(proxy));
		}

		int hashCode(long oid) {
			return (int)(oid & 0xFFFFFFFF);
		}
	}

}
