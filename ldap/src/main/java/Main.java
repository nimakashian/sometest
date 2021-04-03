import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        try {
            // Set up the environment for creating the initial context
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://10.20.30.38:389/DC=Ab,DC=net");
            //
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
//            env.put(Context.SECURITY_PRINCIPAL, "CN=ms.rahimi,OU=service-accounts,OU=BA24,DC=Ab,DC=net"); //we have 2 \\ because it's a escape char
//            env.put(Context.SECURITY_PRINCIPAL, ""); //we have 2 \\ because it's a escape char
//            env.put(Context.SECURITY_PRINCIPAL, "CN=مرتضی کاشیان,OU=OUPartnerOrganizations4,OU=OUPartnerOrganizations,OU=NewBA24,DC=Ab,DC=net"); //we have 2 \\ because it's a escape char
//            env.put(Context.SECURITY_CREDENTIALS, "Kashian@adp12345");

            env.put(Context.SECURITY_PRINCIPAL, "CN=Atiyepishkhan3,OU=service-accounts,OU=BA24,DC=Ab,DC=net"); //we have 2 \\ because it's a escape char
            env.put(Context.SECURITY_CREDENTIALS, "QWER@wsx");

            // Create the initial context

            DirContext ctx = new InitialDirContext(env);

            //login info
//            String searchUserName = "m.kashian";
            String searchUserName = "ms.rahimi";
            String password = "Kashian@adp12345";

            String filter = String.format("(sAMAccountName=%s)", searchUserName);
            SearchControls ctrl = new SearchControls();
            ctrl.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration answer = ctx.search("", filter, ctrl);

            Attributes attributes = null;
            if (answer.hasMore()) {
                SearchResult result = (SearchResult) answer.next();
                attributes = result.getAttributes();
            }

            System.out.println(attributes.get("distinguishedName"));


            //login test
            String dn = (String) attributes.get("distinguishedName").get();
            env.put(Context.SECURITY_PRINCIPAL, dn);
            env.put(Context.SECURITY_CREDENTIALS, password);

            new InitialDirContext(env);


            answer.close();


            if (ctx != null)
                ctx.close();

            System.out.println("hi");
        } catch (Exception e) {
            System.out.println("bye");
        }

    }


}
