/**
 * 
 */
package javagen.umlparser;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

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

	private static final String WILDCARD = "*";

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
	public static Package getModel(Package parent, String name) {
		
		Package p = lookupPackage(parent, name);
		if(p == null)
		{
			// Create as model
			p = (Package)parent.getPackagedElement(name, false, UMLPackage.eINSTANCE.getModel(), true);
		}
		return p;
	}

	/**
	 * Lookup for the specified package in the parent package. Do not create it.
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
	 * Lookup for the specified Namespace in the parent Namespace. Do not create it.
	 * 
	 * @param parent
	 *        the containing package
	 * @param name
	 *        Package to get
	 * @return The requested package (never null)
	 */
	private static Namespace lookupNamespace(Namespace parent, String name) {
		// Get or create an instance of the specified package.
		NamedElement foundElement = parent.getOwnedMember(name);
		if( foundElement instanceof Namespace) 
			return (Namespace)foundElement;
		// Not found
		return null;
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
	 * Get the Namespace containing the last namespace of the qualifiedName.
	 * Do not lookup for the last element.
	 * If there is no scope package in the qualifiedName, return the root.
	 * 
	 * @param parent
	 * @param qualifiedName
	 * @return The containing package (never null)
	 */
	private static Namespace lookupContainingNamespace(Namespace parent, List<String> qualifiedName) {
		Namespace cur = parent;
		for(int i = 0; i < qualifiedName.size() - 1; i++) {
			String name = qualifiedName.get(i);
			cur = lookupNamespace(parent, name);
			if(cur == null)
				return null;
		}
		return cur;
	}

	/**
	 * Get the package containing the {@value #WILDCARD}.
	 * Do not create intermediate packages.
	 * Do not lookup for the last element.
	 * The qualified name contains a {@value #WILDCARD}, lookup the package just before it.
	 * 
	 * @param root
	 * @param qualifiedName
	 * @return The containing package or null if not found.
	 */
	public static Package lookupPackageBeforeWildcard(Package root, List<String> qualifiedName) {
		Package cur = root;
		for(int i = 0; i < qualifiedName.size(); i++) {
			String name = qualifiedName.get(i);
			// Stop if we encounter the wilcard.
			if( WILDCARD.equals(name) )
					break;
			
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
	 * Get the Model corresponding to the qname.
	 * Create all missing package.  
	 * 
	 * @param parent
	 * @param qualifiedName
	 * @return The requested package (never null)
	 */
	public static Package getModel(Package parent, List<String> qualifiedName) {
		Package cur = parent;
		
		// Get the intermediate as Package
		int i=0;
		for(i = 0; i < qualifiedName.size()-1; i++) {
			String name = qualifiedName.get(i);
			cur = getPackage(cur, name);
		}
		// Get the last one as Model
		String name = qualifiedName.get(i);
		cur = getModel(cur, name);
		
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
		// Get or create containing packages
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
	 * Lookup for the classifier with specified qualifiedName in specified model resource..
	 * 
	 * @param qualifiedName
	 * @return The requested package or null if not found
	 */
	public static <R extends Type> R lookupClassifierWithWildcard(Resource model, List<String> qualifiedName, EClass expectedType) {
		Package p = lookupContainingPackage(model, qualifiedName);
		if(p == null)
			return null;

		return (R)p.getOwnedType(qualifiedName.get(qualifiedName.size() - 1), false, expectedType, false);
	}


	/**
	 * Lookup for the classifier with specified qualifiedName in specified model resource..
	 * Don't Create it .
	 * The qualifiedName can contain a wildcard "*".
	 * 
	 * @param parentPackage
	 * @param generalQualifiedName
	 * @param expectedType
	 * @return Found classifier or null
	 */
	public static <R extends Type> R lookupClassifierWithWildcard(Package parent, List<String> qualifiedName, EClass expectedType) {

		int wildcardIndex = qualifiedName.indexOf(WILDCARD);
		// If there is no wildcard, use more simple implementation.
		if(wildcardIndex < 0)
			return lookupClassifier(parent, qualifiedName, expectedType);
		
		// Get containing package till the WILDCARD
		Package p = lookupPackageBeforeWildcard(parent, qualifiedName);
		// If not found, return
		if(p == null)
			return null;
		
		// Use the last name to lookup the element
		// Look for existing packages at the place of the wildcard.
		List<Package> existingPackages = p.getNestedPackages();
		// Get the remaining path from ]index, size]
		List<String> remainingPath = qualifiedName.subList(wildcardIndex+1, qualifiedName.size());
		// Now continue searching from the existing packages
		for(Package nestedPackage : existingPackages) {
			
			R r = lookupClassifier(nestedPackage, qualifiedName, expectedType);
			if(r != null)
				return r;
		}
		
		// Nothing found
		return null;
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
	 * Lookup the requested qualifiedName. Don't Create it .
	 * 
	 * @param parentPackage
	 * @param generalQualifiedName
	 * @param expectedType
	 * @return Found classifier or null
	 */
	public static <R extends Classifier> R lookupClassifier(Namespace parent, List<String> qualifiedName, EClass expectedType) {
		// Get containing package
		Namespace p = lookupContainingNamespace(parent, qualifiedName);
		if(p == null)
			return null;
		
		parent = p;
		String shortname = qualifiedName.get(qualifiedName.size() - 1);
		Classifier result;
		
		if( parent instanceof Package)
		{
			result = (Classifier) ((Package)parent).getOwnedType(shortname, false, expectedType, false);
			
		}
		else if( parent instanceof Interface )
		{
			result = ((Interface) parent).getNestedClassifier(shortname, false, expectedType, false);
		}
		else if( parent instanceof Class )
		{
			result = ((Class) parent).getNestedClassifier(shortname, false, expectedType, false);
		}
		else
		{
			// Should never happen !
			return null;
		}

		return (R)result;
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
	 * @param enclosingParents list of enclosing parent, from the most outerside to the most inner side.
	 * @param name
	 * @return
	 */
	public static Class getClass(List<Namespace> enclosingParents, String name) {
		
		EClass type = UMLPackage.eINSTANCE.getClass_();
		Class result = (Class)getClassifier(enclosingParents, name, type);
		
		return result;
	}

	/**
	 * Get or create a Classifier by its name. The type of the classifier can be Class or Interface
	 * Lookup is done in the provided namespaces, using the short name.
	 * The classifier is expected to be in the directly enclosing parent, but lookup is done in all enclosing parents.
	 * If the position is not the one expected, the found classifier is moved to the enclosing parent.
	 * 
	 * If not found, create the classifier in the directly enclosing namespace.
	 * If found, correct the classifier parent to be the directly enclosing namespace. Eventually correct the type 
	 * if it doesn't match.
	 * 
	 * @param enclosingParents
	 * @param name
	 * @param type
	 * @return
	 */
	private static Classifier getClassifier(List<Namespace> enclosingParents, String name, EClass type) {
		Classifier result = null;
		int parentsCount = enclosingParents.size();
		// Get the direct parent
		Namespace parent = enclosingParents.get(parentsCount-1);
		
		// Look in enclosing parents 
		for( int i=parentsCount-1; i>=0; i--)
		{
			Namespace namespace = enclosingParents.get(i);
			
			// Lookup for the exact type
			result = (Classifier)namespace.getOwnedMember(name, false, type);
			if(result == null)
			{
				// Lookup for the other type
			result = (Classifier)namespace.getOwnedMember(name, false, UMLPackage.eINSTANCE.getClassifier());
			}

			// Here, the result should have the correct type
			if(result != null)
			{
				// Change type if needed
				if( result.eClass() != type) {
					System.err.println("Classifier type need to be corrected for ("+ result.getQualifiedName() +")");
					// Correct the classifier type
					result = (Classifier)transformInto(result, type);
				}
				// Check if parent need to be corrected
				if( result.getOwner() != parent) {

				// Correct the parent
					setClassifierOwner( result, parent );
					// Get the transformed element.
				}
				
				// Found, return it
				return result;
			}
		}
		
		// Not found, create in the direct parent.
		
		if( parent instanceof Package)
		{
			result = (Classifier) ((Package)parent).getOwnedType(name, false, type, true);
			
		}
		else if( parent instanceof Interface )
		{
			result = ((Interface) parent).createNestedClassifier(name, type);
		}
		else if( parent instanceof Class )
		{
			result = ((Class) parent).createNestedClassifier(name, type);
		}
		else
		{
			// Should never happen !
			// The first namespace is always the package.
			Package parentPackage = (Package)enclosingParents.get(0);
			result = (Classifier) ((Package)parentPackage).getOwnedType(name, false, type, true);
		}
		return result;
	}

	/**
	 * Change the owner of the classifier
	 * @param classifier The classifier to change the parent
	 * @param newParent The parent to set.
	 */
	private static void setClassifierOwner(Classifier classifier, Namespace newParent) {
		// Not found, create in the direct parent.
		if( newParent instanceof Package)
		{
			classifier.setPackage((Package)newParent);
			
		}
		else if( newParent instanceof Interface )
		{
			
			((Interface) newParent).getNestedClassifiers().add(classifier);
		}
		else if( newParent instanceof Class )
		{
			((Class) newParent).getNestedClassifiers().add(classifier);
		}
		else
		{
			// Should never happen !
			// The first namespace is always the package.
			System.err.println("Don't know how to change classifier owner for " + newParent);
		}
	}

	/**
	 * Transform the element into the specified type
	 * @param toTransform Classifier to transform (Class or interface)
	 * @param type Type to transform into
	 */
	private static EObject transformInto(Classifier toTransform, EClass type) {
		
		GenericTransformer transformer = new GenericTransformer(toTransform);
		EObject result = transformer.transform(type);
		return result;
		
	}

	/**
	 * Get or create a guessed Classifier by its name. The type of the classifier can be Class or Interface.
	 * A guessed classifier is a classifier specified by an attribute, a parameter, a return type ...
	 * First, lookup for a Classifier with the same name, and return it regardless of its type.
	 * If nothing is found, create a classifier with the specified type.
	 * 
	 * 
	 * If not found, create the classifier in the package (enclosingParent[0]).
	 * If found, return it.
	 * 
	 * @param enclosingParents
	 * @param name The short name
	 * @param type the proposed type to use as a hint for creation.
	 * @return
	 */
	public static Classifier getGuessedClassifier(List<Namespace> enclosingParents, List<String> name, EClass type) {
		Classifier result = null;
		int parentsCount = enclosingParents.size();
		// Get the direct parent
		Namespace parent = enclosingParents.get(parentsCount-1);
		
		// Look in enclosing parents 
		for( int i=parentsCount-1; i>=0; i--)
		{
			Namespace namespace = enclosingParents.get(i);
			
			// Lookup for any type
			result = (Classifier)lookupClassifier(namespace, name, UMLPackage.eINSTANCE.getClassifier());			
//			result = (Classifier)namespace.getOwnedMember(name, false, UMLPackage.eINSTANCE.getClassifier());
			if(result != null)
			{
				return result;
			}
		}
		
		// Not found, create in the direct parent.
		// The first namespace is always the package.
		Package parentPackage = (Package)enclosingParents.get(0);
		result = (Classifier) getClassifier(parentPackage, name,  type);
//		result = (Classifier) ((Package)parentPackage).getOwnedType(name, false, type, true);
		
		return result;
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
	 * 
	 * @param enclosingParents list of enclosing parent, from the most outerside to the most inner side.
	 * @param name
	 * @return
	 */
	public static Interface getInterface(List<Namespace> enclosingParents, String name) {
		return (Interface)getClassifier(enclosingParents, name, UMLPackage.eINSTANCE.getInterface());
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
	 * Create a InterfaceRealization relation between the specified Classifier
	 * 
	 * @param child
	 * @param general
	 */
	public static void getInterfaceRealization(BehavioredClassifier child, Interface general) {
		Realization res = lookupInterfaceRealization(child, general);
		if(res == null)
			createInterfaceRealization(child, general);
	}

	/**
	 * Lookup for the specified realization inside the package
	 * 
	 * @param parent
	 * @param child
	 * @param general
	 * @return
	 */
	private static InterfaceRealization lookupInterfaceRealization(Classifier child, Classifier general) {
		for(Dependency ele : child.getClientDependencies()) {
			if(ele instanceof InterfaceRealization) {
				InterfaceRealization real = (InterfaceRealization)ele;
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
	public static void createInterfaceRealization(BehavioredClassifier child, Interface general) {
		InterfaceRealization res = UMLFactory.eINSTANCE.createInterfaceRealization();
		
		res.setContract(general);
		res.setImplementingClassifier(child);
		
//		res.getClients().add(child);
//		res.getSuppliers().add(general);
		res.setName(child.getName() + " implements " + general.getName());
//		child.createGeneralization(general);
//		child.getClientDependencies().add(res);
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
