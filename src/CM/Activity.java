package CM;

import CM.InvalidCredintial;

public interface Activity {
     boolean login(String email, String password) throws InvalidCredintial, Exception;

}