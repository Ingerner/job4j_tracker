package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс выполняет добавление пользователей  и банковские счета в систему.
 * Позволяет переводить деньги с одного банковского счета на другой
 * @author Korotkiy Oleg
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы и их банковские счета,
     * хранение осуществляется в коллекции типа HashMap
     * */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Выполняет добавление пользователя
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет новый счет к пользователю
     * (счет добавляется только в том случаи если его нет в системе)
     * @param passport поле по которому происходит поиск пользователя
     * @param account добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Выполняет поиск пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает пользователя или null если пользователь не найден
     */
    public User findByPassport(String passport) {
          return users.keySet()
                  .stream()
                  .filter(
                          e -> passport.equals(e.getPassport())
                  )
                  .findFirst()
                  .orElse(null);
    }

    /**
     * Ищет пользователя по паспорту и ищет у него нужные реквизиты
     * @param passport номер паспорта
     * @param requisite реквизиты
     * @return реквизиты или null если реквизиты не найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(
                            e -> e.getRequisite().equals(requisite)
                    )
                    .findFirst()
                    .orElse(null);
        }
        return null;

    }

    /**
     * Выполняет перечесление денежных средств с одного счета на другой
     * @param srcPassport номер паспорта пользователя у которого будут списаны денежные средства
     * @param srcRequisite реквизиты счета списания
     * @param destPassport номер паспорта пользователя  к которому
     *                     будут зачислены денежные средства
     * @param destRequisite реквизиты счета зачисления
     * @param amount сумма списания
     * @return false - если счет не найден или не хватает денег на srcRequisite,
     *         true - если операция выполнена успешно
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccout = findByRequisite(srcPassport, srcRequisite);
        Account destAccout = findByRequisite(destPassport, destRequisite);
        if (srcAccout != null && destAccout != null && srcAccout.getBalance() >= amount) {
            srcAccout.setBalance(srcAccout.getBalance() - amount);
            destAccout.setBalance(destAccout.getBalance() + amount);
            rsl = true;
        }
        return rsl;

    }
}
