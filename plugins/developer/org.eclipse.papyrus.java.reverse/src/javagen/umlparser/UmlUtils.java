/**
 * 
 */
package javagen.umlparser;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Utility methods.
 * <ul>
 * <li>getXxx() methods lookup for the element and create it if not found.</li>
 * <li>lookup() methods lookup for the element.</li>
 * <li>xxx( Resource, ...) methods lookup from the model container.</li>
 * <li>xxx( Package, ...) methods lookup from the specified package?</li>
 * </ul>
 * 
 * The following methods can be used:
 * <ul>
 * <li>package.getPackagedElement( name, b, type, createOnDemand) : PackageableElement</li>
 * <li>package.getNestPacke()</li>
 * <li>package.getOwnedType(name, b, type, createOnDemand) : Type</li>
 * </ul>
 * 
 * @author dumoulin
 * 
 */
public class UmlUtils {

	/**
	 * Get the qualified name from a name.
	 * Name is splitted arround '.'
	 * 
	 * @param name
	 * @return
	 */
	public static List<String> toQualifiedName(String qname) {
		String[] splittedName = qname.split("\\.");
		return Arrays.asList(splittedName);
	}

	/**
	 * Get the qualified name from a name.
	 * Name is splitted arround '/'
	 * 
	 * @param name
	 * @return
	 */
	public static List<String> slashNameToQualifiedName(String qname) {
		String[] splittedName = qname.split("/");
		return Arrays.asList(splittedName);
	}

	/**
	 * Lookup for the specified package in the parent package. Create it if not found.
	 * 
	 * @param parent
	 *        the containing package
	 * @param name
	 *        Package to get
	 * @return The requested package (never null)
	 */
	public static Package getPackage(Package parent, String name) {
		// Get or create an instance of the specified package.
		Package p = (Package)parent.getPackagedElement(name, false, UMLPackage.eINSTANCE.getPackage(), true);
		return p;
	}

	/**
	 * Lookup for the specified package in the parent package. Create it if not found.
	 * 
	 * @param parent
	 *        the containing package
	 * @param name
	 *        Package to get
	 * @return The requested package (never null)
	 */
	private static Package lookupPackage(Package parent, String name) {
		// Get or create an instance of the specified package.
		Package p = (Package)parent.getPackagedElement(name, false, UMLPackage.eINSTANCE.getPackage(), false);
		return p;
	}

	/**
	 * Get the package containing the last package of the qualifiedName.
	 * Create any missing package if needed
	 * Do not lookup for the last element.
	 * If there is no scope package in the qualifiedName, return the root.
	 * 
	 * @param root
	 * @param qualifiedName
	 * @return The containing package (never null)
	 */
	public static Package getContainingPackage(Package root, List<String> qualifiedName) {
		Package cur = root;
		for(int i = 0; i < qualifiedName.size() - 1; i++) {
			String name = qualifiedName.get(i);
			cur = getPackage(cur, name);
			//          if(cur==null)
			//              return null;
		}
		return cur;
	}

	/**
	 * Get the package containing the last package of the qualifiedName.
	 * Create any missing package if needed
	 * Do not lookup for the last element.
	 * If there is no scope package in the qualifiedName, return the root.
	 * 
	 * @param root
	 * @param qualifiedName
	 * @return The containing package (never null)
	 */
	private static Package lookupContainingPackage(Package root, List<String> qualifiedName) {
		Package cur = root;
		for(int i = 0; i < qualifiedName.size() - 1; i++) {
			String name = qualifiedName.get(i);
			cur = lookupPackage(cur, name);
			if(cur == null)
				return null;
		}
		return cur;
	}


	/**
	 * Get the package containing the last package of the qualifiedName.
	 * Create any missing package if needed
	 * Do not lookup for the last element.
	 * If there is no scope package in the qualifiedName, return the root.
	 * 
	 * @param model
	 * @param qualifiedName
	 * @return The containing package (never null)
	 */
	public static Package getContainingPackage(Resource model, List<String> qualifiedName) {
		Package cur = getNamedElement(model, UMLPackage.eINSTANCE.getPackage(), qualifiedName.get(0));

		for(int i = 1; i < qualifiedName.size() - 1; i++) {
			String name = qualifiedName.get(i);
			cur = getPackage(cur, name);
			//		    if(cur==null)
			//		    	return null;
		}
		return cur;
	}

	/**
	 * Get the package containing the last package of the qualifiedName.
	 * Create any missing package if needed
	 * Do not lookup for the last element.
	 * If there is no scope package in the qualifiedName, return the root.
	 * 
	 * @param model
	 * @param qualifiedName
	 * @return The containing package or null if not found.
	 */
	private static Package lookupContainingPackage(Resource model, List<String> qualifiedName) {
		Package cur = lookupNamedElement(model, UMLPackage.eINSTANCE.getPackage(), qualifiedName.get(0));
		if(cur == null)
			return null;

		for(int i = 1; i < qualifiedName.size() - 1; i++) {
			String name = qualifiedName.get(i);
			cur = lookupPackage(cur, name);
			if(cur == null)
				return null;
		}
		return cur;
	}

	/**
	 * Get the Package corresponding to the qname.
	 * Create all missing package
	 * 
	 * @param qualifiedName
	 * @return The requested package (never null)
	 */
	public static Package getPackage(Resource model, List<String> qualifiedName) {
		Package cur = getNamedElement(model, UMLPackage.eINSTANCE.getPackage(), qualifiedName.get(0));

		for(int i = 1; i < qualifiedName.size(); i++) {
			String name = qualifiedName.get(i);
			cur = getPackage(cur, name);
			//          if(cur==null)
			//              return null;
		}
		return cur;
	}

	/**
	 * Lookup the Package corresponding to the qname in specified model resource..
	 * 
	 * @param qualifiedName
	 * @return The requested package or null if not found
	 */
	public static Package lookupPackage(Resource model, List<String> qualifiedName) {
		Package cur = lookupNamedElement(model, UMLPackage.eINSTANCE.getPackage(), qualifiedName.get(0));
		if(cur == null)
			return null;

		for(int i = 1; i < qualifiedName.size(); i++) {
			String name = qualifiedName.get(i);
			cur = lookupPackage(cur, name);
			if(cur == null)
				return null;
		}
		return cur;
	}

	/**
	 * Get the Package corresponding to the qname.
	 * Create all missing package
	 * 
	 * @param parent
	 * @param qualifiedName
	 * @return The requested package (never null)
	 */
	public static Package getPackage(Package parent, List<String> qualifiedName) {
		Package cur = parent;
		for(int i = 0; i < qualifiedName.size(); i++) {
			String name = qualifiedName.get(i);
			cur = getPackage(cur, name);
			//            if(cur==null)
			//                return null;
		}
		return cur;
	}

	/**
	 * Get the Package corresponding to the qname.
	 * 
	 * @param parent
	 * @param qualifiedName
	 * @return The requested package or null if not found
	 */
	public static Package lookupPackage(Package parent, List<String> qualifiedName) {
		Package cur = parent;
		for(int i = 0; i < qualifiedName.size(); i++) {
			String name = qualifiedName.get(i);
			cur = lookupPackage(cur, name);
			if(cur == null)
				return null;
		}
		return cur;
	}

	/**
	 * get (lookup or create) the specified NamedElement with the requested type
	 * 
	 * @param <R>
	 *        should be equals to expected type.
	 * @param model
	 * @param expectedType
	 * @param name
	 * @return
	 */
	protected static <R extends NamedElement> R getNamedElement(Resource model, EClass expectedType, String name) {

		for(Object cur : model.getContents()) {
			//			System.out.println("Compare " + cur.getClass().getName() + "-->" + name );
			if(expectedType.getInstanceClass().isInstance(cur) && name.equals(((NamedElement)cur).getName())) {
				//				System.out.println("found !!!");
				return (R)cur;
			}
		}

		// Create it
		R res = (R)UMLFactory.eINSTANCE.create(expectedType);
		res.setName(name);
		model.getContents().add(res);
		return res;
	}

	/**
	 * Lookup for the specified NamedElement with the requested type from the model container.
	 * 
	 * @param <R>
	 * @param model
	 * @param expectedType
	 * @param name
	 * @return
	 */
	protected static <R extends NamedElement> R lookupNamedElement(Resource model, EClass expectedType, String name) {

		for(Object cur : model.getContents()) {
			if(expectedType.isInstance(cur) && name.equals(((NamedElement)cur).getName())) {
				return (R)cur;
			}
		}

		return null;
	}


	/**
	 * Lookup or create the requested qualifiedName. Create it with the specified type.
	 * 
	 * @param parentPackage
	 * @param generalQualifiedName
	 * @param expectedType
	 * @return
	 */
	public static <R extends Type> R getClassifier(Package parent, List<String> qualifiedName, EClass expectedType) {
		// Get containing package
		Package p = getContainingPackage(parent, qualifiedName);
		// Use the last name to create the element
		return (R)p.getOwnedType(qualifiedName.get(qualifiedName.size() - 1), false, expectedType, true);
	}

	/**
	 * Lookup the corresponding classifier to the qname in specified model resource..
	 * 
	 * @param qualifiedName
	 * @return The requested package or null if not found
	 */
	public static <R extends Type> R lookupClassifier(Resource model, List<String> qualifiedName, EClass expectedType) {
		Package p = lookupContainingPackage(model, qualifiedName);
		if(p == null)
			return null;

		return (R)p.getOwnedType(qualifiedName.get(qualifiedName.size() - 1), false, expectedType, false);
	}


	/**
	 * Lookup the requested qualifiedName. Don't Create it .
	 * 
	 * @param parentPackage
	 * @param generalQualifiedName
	 * @param expectedType
	 * @return Found classifier or null
	 */
	public static <R extends Type> R lookupClassifier(Package parent, List<String> qualifiedName, EClass expectedType) {
		// Get containing package
		Package p = lookupContainingPackage(parent, qualifiedName);
		if(p == null)
			return null;
		// Use the last name to create the element
		return (R)p.getOwnedType(qualifiedName.get(qualifiedName.size() - 1), false, expectedType, false);
	}

	/**
	 * Lookup for the specified package in the parent package. Create it if not found.
	 * 
	 * @param parent
	 * @param name
	 *        Package to found
	 * @return
	 */
	public static Class getClass(Package parent, String name) {
		// Get or create an instance of the specified package.
		Class p = (Class)parent.getOwnedType(name, false, UMLPackage.eINSTANCE.getClass_(), true);
		return p;
	}

	/**
	 * Get the specified class from the specified parent.
	 * Missing package and the class are created if needed.
	 * 
	 * @param parent
	 * @param qualifiedName
	 * @return
	 */
	public static Class getClass(Package parent, List<String> qualifiedName) {
		Package p = getContainingPackage(parent, qualifiedName);
		// Use the last name to create the element
		return getClass(p, qualifiedName.get(qualifiedName.size() - 1));
	}

	/**
	 * 
	 * @param parent
	 * @param name
	 * @return
	 */
	public static Interface getInterface(Package parent, String name) {
		Interface p = (Interface)parent.getOwnedType(name, false, UMLPackage.eINSTANCE.getInterface(), true);
		return p;
	}

	/**
	 * Create a Property and add it to the parent.
	 * 
	 * @param parent
	 * @param name
	 * @param arrayCount
	 * @return
	 */
	public static Property createProperty(Classifier parent, Type type, String name, int arrayCount) {
		Property p;
		if(parent instanceof Class)
			p = createProperty((Class)parent, type, name, arrayCount);
		else if(parent instanceof Interface)
			p = createProperty((Interface)parent, type, name, arrayCount);
		else
			return null;

		p.setIsUnique(false);
		return p;
	}

	/**
	 * Create a property for the Class
	 * 
	 * @param parent
	 * @param type
	 * @param name
	 * @param arrayCount
	 * @return
	 */
	public static Property createProperty(Class parent, Type type, String name, int arrayCount) {
		return parent.getOwnedAttribute(name, type, false, UMLPackage.eINSTANCE.getProperty(), true);
	}

	/**
	 * Create a property for the Class
	 * 
	 * @param parent
	 * @param type
	 * @param name
	 * @param arrayCount
	 * @return
	 */
	public static Property createProperty(Interface parent, Type type, String name, int arrayCount) {
		return parent.getOwnedAttribute(name, type, false, UMLPackage.eINSTANCE.getProperty(), true);
	}

	/**
	 * Create a Generalization relation between the specified Classifier
	 * 
	 * @param child
	 * @param general
	 */
	public static void getGeneralization(Classifier child, Classifier general) {
		child.getGeneralization(general, true);
		//		child.createGeneralization(general);
	}


	/**
	 * Create a Generalization relation between the specified Classifier
	 * 
	 * @param child
	 * @param general
	 */
	public static void getRealization(Package parent, Classifier child, Classifier general) {
		Realization res = lookupRealization(parent, child, general);
		if(res == null)
			createRealization(parent, child, general);
	}

	/**
	 * Lookup for the specified realization inside the package
	 * 
	 * @param parent
	 * @param child
	 * @param general
	 * @return
	 */
	private static Realization lookupRealization(Package parent, Classifier child, Classifier general) {
		for(PackageableElement ele : parent.getPackagedElements()) {
			if(ele instanceof Realization) {
				Realization real = (Realization)ele;
				if(real.getClients().contains(child) && real.getSuppliers().contains(general))
					return real;
			}
		}
		return null;
	}

	/**
	 * Create a Generalization relation between the specified Classifier
	 * 
	 * @param child
	 * @param general
	 */
	public static void createRealization(Package parent, Classifier child, Classifier general) {
		Realization res = UMLFactory.eINSTANCE.createRealization();
		res.getClients().add(child);
		res.getSuppliers().add(general);
		res.setName(child.getName() + " extends " + general.getName());
		parent.getPackagedElements().add(res);
	}

	/**
	 * Create a primitive type.
	 * 
	 * @param root
	 * @param typeName
	 */
	public static PrimitiveType getPrimitive(Package parent, String typeName) {
		return (PrimitiveType)parent.getOwnedType(typeName, true, UMLPackage.eINSTANCE.getPrimitiveType(), true);

	}

	/**
	 * Get the specified class from the specified parent.
	 * Missing package and the class are created if needed.
	 * 
	 * @param parent
	 * @param qualifiedName
	 * @return
	 */
	public static PrimitiveType getPrimitive(Package parent, List<String> qualifiedName) {
		Package p = getContainingPackage(parent, qualifiedName);
		// Use the last name to create the element
		return getPrimitive(p, qualifiedName.get(qualifiedName.size() - 1));
	}

	/**
	 * Get the specified operation from the provided type.
	 * 
	 * @param classifier
	 * @param name
	 * @return
	 */
	public static Operation getOperation(Classifier classifier, String name) {
		// TODO Auto-generated method stub
		List<Operation> opers = classifier.getOperations();
		for(Operation op : opers) {
			if(name.equals(op.getName()))
				return op;
		}

		Operation res = createOperation(classifier, name);
		return res;
	}

	/**
	 * Create an operation with the specified name.
	 * 
	 * @param classifier
	 * @param name
	 * @return
	 */
	public static Operation createOperation(Classifier classifier, String name) {
		// Not found, create it
		Operation res = UMLFactory.eINSTANCE.createOperation();
		res.setName(name);
		if(classifier instanceof Class) {
			((Class)classifier).getOwnedOperations().add(res);
		} else if(classifier instanceof Interface) {
			((Interface)classifier).getOwnedOperations().add(res);
		} else if(classifier instanceof DataType) {
			((DataType)classifier).getOwnedOperations().add(res);
		}
		return res;
	}



}
