package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User i : users) {
            if (login.equals(i.getUsername())) {
                return i;
            }
        }
        throw new UserNotFoundException("Пользователь в списке не найден.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((!user.isValid()) || (user.getUsername().length() < 3)) {
           throw new  UserInvalidException("не валидный");
        }
        return true;
    }

    public static void main(String[] args) {
      try {

          User[] users = {
                  new User("Petr Arsentev", true)
          };
          User user = findUser(users, "Petr Arsentev");
          if (validate(user)) {
              System.out.println("This user has an access");
          }
      } catch (UserInvalidException ui) {
          ui.printStackTrace();
      } catch (UserNotFoundException un) {
          un.printStackTrace();
      }
    }
}
