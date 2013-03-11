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

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.util.URI;

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

	private final List<URI> uris;

	public CDOResourceURITransferData(Iterable<? extends CDOResourceNode> resourceNodes) {
		this(ImmutableList.copyOf(Iterables.transform(resourceNodes, new Function<CDOResourceNode, URI>() {

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
}
