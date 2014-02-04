/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.export;

import static org.eclipse.nebula.widgets.nattable.util.ObjectUtils.isNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.nebula.widgets.nattable.export.FileOutputStreamProvider;
import org.eclipse.nebula.widgets.nattable.export.IOutputStreamProvider;
import org.eclipse.nebula.widgets.nattable.export.excel.ExcelExporter;
import org.eclipse.papyrus.infra.nattable.Activator;

public class PapyrusExcelExporter extends ExcelExporter {

	private static final String EXCEL_HEADER_FILE = "papyrusExcelExportHeader.txt"; //$NON-NLS-1$

	public PapyrusExcelExporter() {
		this(new FileOutputStreamProvider("table_export.xls", new String[]{ "Excel Workbok (*.xls)" }, new String[]{ "*.xls" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public PapyrusExcelExporter(IOutputStreamProvider outputStreamProvider) {
		super(outputStreamProvider);
	}

	@Override
	public void exportLayerBegin(OutputStream outputStream, String layerName) throws IOException {
		writeHeader(outputStream);//no super!
		outputStream.write(asBytes("<body><table border='1'>")); //$NON-NLS-1$
	}

	//this method is private is NatTable...
	private void writeHeader(OutputStream outputStream) throws IOException {
		InputStream headerStream = null;
		try {
			headerStream = this.getClass().getResourceAsStream(EXCEL_HEADER_FILE);
			int c;
			while((c = headerStream.read()) != -1) {
				outputStream.write(c);
			}
		} catch (Exception e) {
			Activator.log.error(e);
		} finally {
			if(isNotNull(headerStream)) {
				headerStream.close();
			}
		}
	}

	private byte[] asBytes(String string) {
		return string.getBytes();
	}
}
