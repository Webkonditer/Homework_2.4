import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String login = "Super_user_4";
        String password = "Dbdfbs_573574";
        String confirmPassword = "Dbdfbs_573574";

        if(checkData(login, password, confirmPassword)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    public static boolean checkData(String login, String password, String confirmPassword){
       try {
           if (!Pattern.matches("[0-9a-zA-Z_]{1,20}",login)){
               throw new WrongLoginException("Неверный логин");
           } else if (!Pattern.matches("[0-9a-zA-Z_]{1,19}",password) || !password.equals(confirmPassword)){
               throw new WrongPasswordException("Неверный пароль или не совпадают пароли");
           }
       } catch (WrongLoginException e) {
           System.out.println("Неверный логин");
           return false;
       } catch (WrongPasswordException e) {
           System.out.println("Неверный пароль или не совпадают пароли");
           return false;
       } finally {
           System.out.println("Проверка завершена");
       }
       return true;
    }

}