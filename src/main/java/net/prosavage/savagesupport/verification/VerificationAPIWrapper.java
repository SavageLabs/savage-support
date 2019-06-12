package net.prosavage.savagesupport.verification;

import me.TechsCode.TechsCodeAPIClient.TechsCodeAPIClient;
import me.TechsCode.TechsCodeAPIClient.collections.PurchaseCollection;

public class VerificationAPIWrapper {

    private static TechsCodeAPIClient techsCodeAPIClient =
            // backend and bot on same machine :P
            new TechsCodeAPIClient("localhost:3333", "iwoueHGRFWQEPQEFPOIKNQEF");

    public static boolean checkIfOwnsPlugins(String username) {
        return techsCodeAPIClient.getPurchases().username(username).size() != 0;
    }

    public static String getUserId(String username) {
        return techsCodeAPIClient.getPurchases().username(username).first().getUserId();
    }

    public static PurchaseCollection getPurchases(String username) {
        return techsCodeAPIClient.getPurchases().username(username);
    }


}
