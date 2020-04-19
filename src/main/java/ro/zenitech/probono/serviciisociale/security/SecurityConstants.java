package ro.zenitech.probono.serviciisociale.security;

public class SecurityConstants {

    public static final String SECRET = "JavaIsNoSecret";
    public static final long EXPIRATION_TIME = 8_640_000; // 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "api/v1/users/sign-up";
    public static final String AUTHORITIES_KEY = "scopes";

}
