package net.prosavage.savagesupport.verification;

import me.TechsCode.TechsCodeAPIClient.TechsCodeAPIClient;

public class VerificationAPIWrapper {

    private static TechsCodeAPIClient techsCodeAPIClient =
            new TechsCodeAPIClient("localhost:3333", "iwoueHGRFWQEPQEFPOIKNQEF");

    public static boolean checkIfOwnsPlugins(String username) {
        return techsCodeAPIClient.getPurchases().username(username).size() != 0;
    }

    public static String getUserId(String username) {
        return techsCodeAPIClient.getPurchases().username(username).first().getUserId();
    }


}
