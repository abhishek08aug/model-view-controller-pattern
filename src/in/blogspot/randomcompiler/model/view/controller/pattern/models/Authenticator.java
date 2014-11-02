package in.blogspot.randomcompiler.model.view.controller.pattern.models;

public class Authenticator {
	public boolean authenticate(String username, String password) {
        if (("abhishek".equalsIgnoreCase(username))
                && ("password".equals(password))) {
            return true;
        } else {
            return false;
        }
    }
}
