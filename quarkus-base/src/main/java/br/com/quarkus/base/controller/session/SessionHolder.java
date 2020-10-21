package br.com.quarkus.base.controller.session;

public class SessionHolder {

    private static final InheritableThreadLocal<String> currentAuthorization = new InheritableThreadLocal<>();

    public static void setAuthorization(final String authorization) {
        currentAuthorization.set(authorization);
    }

    public static String getCurrentAuthorization() {
        return currentAuthorization.get();
    }

}