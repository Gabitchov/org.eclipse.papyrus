/*******************************************************************************
 * Copyright (c) 2006, 2013 Soyatec (http://www.soyatec.com), CEA, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Christian W. Damus (CEA) - Fix failure to propagate stream handlers of URLs (CDO)
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.xml;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.XWTException;

/**
 * @author yyang
 * @since 1.0
 */
public class DocumentRoot {

	/**
	 * The file type(Can be resolved by java.io.File)
	 */
	public static final int TYPE_FILE = 0;

	/**
	 * The path type(Can be resolved by java.net.URL)
	 */
	public static final int TYPE_PATH = 1;

	/**
	 * The zip format.
	 */
	public static final int FORMAT_ZIP = 2;

	/**
	 * The gzip format.
	 */
	public static final int FORMAT_GZIP = 3;

	/**
	 * The plain format.
	 */
	public static final int FORMAT_NONE = 4;

	private int type = TYPE_PATH;

	private int format = FORMAT_NONE;

	/**
	 * The absolute path.
	 */
	private String basePath;

	/**
	 * The relative path.
	 */
	private URL baseURL;

	/**
	 * The main file name.
	 */
	private String baseFile;

	private static URL DOCUMENT_ROOT;

	static {
		try {
			DOCUMENT_ROOT = new File(System.getProperty("user.dir")).toURI().toURL();
		} catch (MalformedURLException e) {
			DOCUMENT_ROOT = null;
		}
	}

	public DocumentRoot() {
		reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentRoot#getFormat()
	 */
	public int getFormat() {
		return format;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentRoot#getType()
	 */
	public int getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentRoot#getPath()
	 */
	public URL getPath() {
		return baseURL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentRoot#getFile()
	 */
	public String getFile() {
		return baseFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentRoot#openStream()
	 */
	public InputStream openStream() throws IOException {
		switch(format) {
		case FORMAT_GZIP:
			return new GZIPInputStream(new URL(basePath + "/" + baseFile).openStream());
		default:
			return new URL(baseURL, basePath + "/" + baseFile).openStream(); // preserve the stream handler
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentRoot#openStream(java.lang.String)
	 */
	public InputStream openStream(String path) throws IOException {
		assert path != null;
		InputStream in = null;

		if(path.indexOf(':') < 0) {
			if(format == FORMAT_ZIP) {
				// If it is zip format, that means all directories and files in
				// zip file are extracted to temporary directory.
				File file = new File(basePath + "/" + path);
				in = new FileInputStream(file);
			} else {
				// Else, maybe the file parent or url path.
				switch(type) {
				case TYPE_FILE:
					File file;
					if(path.startsWith("/")) {
						// Use absolute path
						file = new File(path);
					} else {
						// Use relative path
						file = new File(basePath + "/" + path);
					}
					in = new FileInputStream(file);
					break;
				case TYPE_PATH:
					URL url = new URL(basePath + "/" + path);
					in = url.openStream();
					break;
				}
			}
		} else {
			if(path.startsWith("classpath:")) {
				// Use class path
				String p = path.substring(10);
				in = getClass().getResourceAsStream(p);
				if(in == null) {
					in = String.class.getResourceAsStream(p);
				}
				if(in == null) {
					in = Thread.currentThread().getClass().getResourceAsStream(p);
				}
				if(in == null) {
					throw new IOException("File not found in classpath: " + p);
				}
			} else {
				File file = new File(path);
				if(file.exists()) {
					// Use Windows File path. For example, G:\\somefile.txt
					in = new FileInputStream(file);
				} else {
					// Use URL path
					in = new URL(path).openStream();
				}
			}
		}

		// Automatically select the stream type
		PushbackInputStream pis = new PushbackInputStream(in, 4);
		if(Format.isGZIP(pis)) {
			return new GZIPInputStream(pis);
		} else if(Format.isZIP(pis)) {
			ZipInputStream zis = new ZipInputStream(pis);
			// Skip entry of directory or file which contains directory
			// path("someDirectory/someFile.suffix").
			for(ZipEntry entry = zis.getNextEntry(); entry != null && (entry.isDirectory() || entry.getName().indexOf('/') != -1); entry = zis.getNextEntry());
			return zis;
		} else {
			return pis;
		}
	}

	/**
	 * This method is used in <code>ModelLoader</code>
	 * 
	 * @param file
	 *        the xaml file path.
	 */
	protected void init(InputStream inputStream, URL url) throws IOException {
		File file = null;
		
		try {
			file = "file".equals(url.getProtocol()) ? new File(url.toURI()) : null;
		} catch (URISyntaxException e) {
			// not a valid file URL.  Fine
		}
		
		if((inputStream == null) && (file != null) && file.exists()) {
			// Is file
			init(file);
		} else {
			// Is URL
			basePath = null;
			baseURL = url;
			PushbackInputStream pis = null;
			boolean shouldClose_pis = false;
			if(inputStream instanceof PushbackInputStream) {
				pis = (PushbackInputStream)inputStream;
			} else {
				if(inputStream == null) {
					pis = new PushbackInputStream(baseURL.openStream(), 4);
					shouldClose_pis = true;
				} else {
					pis = new PushbackInputStream(inputStream, 4);
				}
			}
			if(Format.isGZIP(pis)) {
				format = FORMAT_GZIP;
			} else if(Format.isZIP(pis)) {
				format = FORMAT_ZIP;
				File tempDir = extractZipToTemporary(pis);
				basePath = "file:/" + tempDir.getAbsolutePath();
				baseFile = getMainFile(tempDir);
			}
			if(shouldClose_pis) {
				pis.close();
			}

			if(basePath == null) {
				String path = url.toString();
				while(path.endsWith("/")) {
					path = path.substring(0, path.length() - 1);
				}

				int lastIndex = path.lastIndexOf("/");
				if(lastIndex > 0) {
					basePath = path.substring(0, lastIndex);
					baseFile = path.substring(lastIndex + 1);
					baseURL = new URL(url, basePath); // be sure to preserve the stream handler
				} else {
					basePath = System.getProperty("user.dir");
					baseURL = new File(basePath).toURI().toURL();
					baseFile = path;
				}
			}

			type = TYPE_PATH;
		}
	}

	/**
	 * This method is used in <code>ModelLoader</code>
	 */
	protected void reset() {
		type = TYPE_PATH;
		format = FORMAT_NONE;
		baseURL = DOCUMENT_ROOT;
		basePath = DOCUMENT_ROOT.toString();
		baseFile = null;
	}

	/**
	 * This method is used in <code>ModelLoader</code>
	 * 
	 * @param file
	 *        the XAML file.
	 */
	private void init(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		PushbackInputStream pis = new PushbackInputStream(fis, 4);
		baseURL = file.getParentFile().toURI().toURL();
		basePath = baseURL.toString();
		baseFile = file.getName();
		if(Format.isGZIP(pis)) {
			format = FORMAT_GZIP;
		} else if(Format.isZIP(pis)) {
			format = FORMAT_ZIP;
			File tempDir = extractZipToTemporary(pis);
			basePath = "file:/" + tempDir.getAbsolutePath();
			baseFile = getMainFile(tempDir);
			baseURL = file.toURI().toURL();
		}

		type = TYPE_FILE;
	}

	private String getMainFile(File tempDir) {
		File[] tempFiles = tempDir.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().toLowerCase().endsWith(IConstants.XWT_EXTENSION_SUFFIX);
			}
		});
		for(File tempFile : tempFiles) {
			return tempFile.getName();
		}
		return null;
	}

	/**
	 * Extract zip stream to temporary directory.
	 * 
	 * @param stream
	 *        zip stream.
	 * @return Returns the directory file the zip stream extracted.
	 */
	private File extractZipToTemporary(InputStream stream) throws IOException {
		File file = new File(System.getProperty("java.io.tmpdir") + "/cb" + System.currentTimeMillis() + Math.random());
		if(!file.mkdir()) {
			throw new XWTException("Folder creation fails: " + file.toString());
		}
		file.deleteOnExit();

		String directory = file.getAbsolutePath();
		ZipInputStream in = new ZipInputStream(stream);
		ZipEntry z;
		while((z = in.getNextEntry()) != null) {
			if(z.isDirectory()) {
				String name = z.getName();
				name = name.substring(0, name.length() - 1);
				File f = new File(directory + File.separator + name);
				if(!f.mkdir()) {
					throw new XWTException("Folder creation fails: " + f.toString());
				}
				f.deleteOnExit();
			} else {
				File f = new File(directory + File.separator + z.getName());
				if(!f.createNewFile()) {
					throw new XWTException("File creation fails: " + f.toString());
				}
				f.deleteOnExit();
				FileOutputStream out = new FileOutputStream(f);
				byte[] cache = new byte[4096];
				for(int i = in.read(cache); i != -1; i = in.read(cache)) {
					out.write(cache, 0, i);
				}
				out.close();
			}
		}
		in.close();

		return file;
	}

	/**
	 * File format uitility.
	 * <p>
	 * To check the format of file or stream.
	 * </p>
	 * 
	 */
	static class Format {

		/**
		 * Check the stream is a gzip format or not.
		 * 
		 * @param stream
		 *        the checked stream.
		 * @return Returns true is the stream is a gzip format.
		 */
		public static boolean isGZIP(PushbackInputStream stream) throws IOException {
			assert stream != null;

			byte[] cachedBytes = new byte[2];
			if(stream.read(cachedBytes) != cachedBytes.length) {
				throw new RuntimeException("data content wrong.");
			}
			stream.unread(cachedBytes);
			// GZIP's header data starts with two bytes{1F,8B},
			if((cachedBytes[0] & 0xff) == 0x1f && (cachedBytes[1] & 0xff) == 0x8b) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Check the file is a gzip format or not.
		 * 
		 * @param file
		 *        the checked file.
		 * @return Returns true is the file is a gzip format.
		 */
		public static boolean isGZIP(File file) throws IOException {
			assert file != null;

			FileInputStream fis = new FileInputStream(file);
			PushbackInputStream pis = new PushbackInputStream(fis, 2);
			boolean returnValue = isGZIP(pis);
			pis.close();
			return returnValue;
		}

		/**
		 * Check the stream is a zip format or not.
		 * 
		 * @param stream
		 *        the checked stream.
		 * @return Returns true is the stream is a zip format.
		 */
		public static boolean isZIP(PushbackInputStream stream) throws IOException {
			assert stream != null;

			byte[] cachedBytes = new byte[4];
			if(stream.read(cachedBytes) != cachedBytes.length) {
				throw new RuntimeException("data content wrong.");
			}
			stream.unread(cachedBytes);
			// ZIP's header data starts with four bytes{0x50, 0x4b, 0x03, 0x04},
			if((cachedBytes[0] & 0xff) == 0x50 && (cachedBytes[1] & 0xff) == 0x4b && (cachedBytes[2] & 0xff) == 0x03 && (cachedBytes[3] & 0xff) == 0x04) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Check the file is a zip format or not.
		 * 
		 * @param file
		 *        the checked file.
		 * @return Returns true is the file is a zip format.
		 */
		public static boolean isZIP(File file) throws IOException {
			assert file != null;

			FileInputStream fis = new FileInputStream(file);
			PushbackInputStream pis = new PushbackInputStream(fis, 4);
			boolean returnValue = isZIP(pis);
			pis.close();
			return returnValue;
		}
	}
}
