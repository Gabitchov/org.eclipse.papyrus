package org.eclipse.papyrus.facadeSpecificEditor.glue;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GlueGenerator extends MouseAdapter {

	protected Facade facade;

	public GlueGenerator(Facade facade) {
		super();
		this.facade = facade;

	}

	protected void printHead(PrintStream printStream) {
		printStream.println("import java.io.IOException;");
		printStream.println("import java.io.InputStream;");
		printStream.println("import java.io.OutputStream;");
		printStream.println("import java.util.Map;");

		printStream.println("import org.eclipse.emf.common.util.URI;");
		printStream.println("import org.eclipse.emf.ecore.resource.ResourceSet;");
		printStream.println("import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;");
		printStream.println("import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;");
		printStream.println("import org.eclipse.papyrus.FacadeMetamodel.FacadeMetamodel.Facade;");
		printStream.println("import org.eclipse.papyrus.facacemetamodel.interpreter.Loader;");
		printStream.println("import org.eclipse.papyrus.facacemetamodel.interpreter.Saver;");

		printStream.println("public class MetamodelResourceImpl extends XMIResourceImpl {");

		printStream.println("public MetamodelResourceImpl(URI uri) {");
		printStream.println("super(uri);");
		printStream.println("}");

	}

	protected void printDoLoad(PrintStream printStream) {
		printStream.println("@Override");
		printStream.println("public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {");

		printStream.println("URI facadeURI = URI.createPlatformPluginURI(\"/vitualProfile/model/My.facademetamodel\", true);");
		printStream.println("ResourceSet resourceSet = new ResourceSetImpl();");
		printStream.println("try {");
		printStream.println("Object facade = resourceSet.getResource(facadeURI, true).getContents().get(0);");
		printStream.println("if (facade != null) {");
		printStream.println("if (facade instanceof Facade) {");

		printStream.println("Loader.doLoad(inputStream, options, (Facade) facade);");
		printStream.println("} else {");
		printStream.println("System.err.println(\"Facade is not of right kind\");");
		printStream.println("}");
		printStream.println("} else {");
		printStream.println("System.err.println(\"Cannot open facade model\");");
		printStream.println("}");

		printStream.println("} catch (Exception e) {");
		printStream.println("e.printStackTrace();");
		printStream.println("}");
		printStream.println("}");
	}

	protected void printDoSave(PrintStream printStream) {
		printStream.println("@Override");
		printStream.println("public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {");
		printStream.println("URI facadeURI = URI.createPlatformPluginURI(\"/vitualProfile/model/My.facademetamodel\", true);");
		printStream.println("ResourceSet resourceSet = new ResourceSetImpl();");
		printStream.println("try {");
		printStream.println("Object facade = resourceSet.getResource(facadeURI, true).getContents().get(0);");
		printStream.println("if (facade != null) {");
		printStream.println("if (facade instanceof Facade) {");

		printStream.println("Saver.doSave(outputStream, options, (Facade) facade, this);");
		printStream.println("} else {");
		printStream.println("System.err.println(\"Facade is not of right kind\");");
		printStream.println("}");
		printStream.println("} else {");
		printStream.println("System.err.println(\"Cannot open facade model\");");
		printStream.println("}");

		printStream.println("} catch (Exception e) {");
		printStream.println("e.printStackTrace();");
		printStream.println("}");
		printStream.println("}");
	}

	protected void printTail(PrintStream printStream) {
		printStream.println("}");
	}

	@Override
	public void mouseUp(MouseEvent e) {

		URI facadeURI = facade.eResource().getURI();

		URI glueURI = facadeURI.appendFileExtension("java");

		URIConverter uriConverter = new ExtensibleURIConverterImpl();

		try {
			OutputStream outputStream = uriConverter.createOutputStream(glueURI);
			PrintStream printStream = new PrintStream(outputStream);

			printHead(printStream);

			printDoSave(printStream);

			printDoLoad(printStream);

			printTail(printStream);

			printStream.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
