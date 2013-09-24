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
package org.eclipse.papyrus.cdo.internal.ui.dnd;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;


/**
 * This is the CDOResourceURITransferData type. Enjoy.
 */
public final class CDOResourceURITransferData {

	private static final String NS_URI = "http://www.eclipse.org/papyrus/1.0.0/cdo/private/dnd"; //$NON-NLS-1$

	private static final EClass ECLASS = (EClass)EPackage.Registry.INSTANCE.getEPackage(NS_URI).getEClassifier(CDOResourceURITransferData.class.getSimpleName());

	private static final EAttribute URIS = (EAttribute)ECLASS.getEStructuralFeature("resourceURIs"); //$NON-NLS-1$

	private final List<URI> uris;

	public CDOResourceURITransferData(Iterable<? extends CDOResourceNode> resourceNodes) {
		this(ImmutableList.copyOf(Iterables.transform(resourceNodes, new Function<CDOResourceNode, URI>() {

			@Override
			public URI apply(CDOResourceNode input) {
				return input.getURI();
			}
		})));
	}

	private CDOResourceURITransferData(List<URI> uris) {
		this.uris = uris;
	}

	public List<URI> getURIs() {
		return uris;
	}

	public byte[] serialize() {
		ByteArrayDataOutput data = ByteStreams.newDataOutput();

		data.writeInt(uris.size());
		for(URI next : uris) {
			data.writeUTF(next.toString());
		}

		return data.toByteArray();
	}

	public static CDOResourceURITransferData deserialize(byte[] serial) {
		ImmutableList.Builder<URI> uris = ImmutableList.builder();
		ByteArrayDataInput data = ByteStreams.newDataInput(serial);

		final int count = data.readInt();
		for(int i = 0; i < count; i++) {
			uris.add(URI.createURI(data.readUTF()));
		}

		return new CDOResourceURITransferData(uris.build());
	}

	public static boolean isCDOResourceURITransferData(EObject object) {
		return ECLASS.isInstance(object);
	}

	public static CDOResourceURITransferData fromEObject(EObject object) {
		@SuppressWarnings("unchecked")
		List<URI> uris = isCDOResourceURITransferData(object) ? (List<URI>)object.eGet(URIS) : Collections.<URI> emptyList();

		return new CDOResourceURITransferData(uris);
	}

	public EObject asEObject() {
		EObject result = EcoreUtil.create(ECLASS);
		result.eSet(URIS, getURIs());
		return result;
	}
}
