package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
          return users.keySet()
                  .stream()
                  .filter(
                          e -> passport.equals(e.getPassport())
                  )
                  .findFirst();
    }

    /**
     * Ищет пользователя по паспорту и ищет у него нужные реквизиты
     * @param passport номер паспортафф
     * @param requisite реквизиты
     * @return реквизиты или null если реквизиты не найдены
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(
                            e -> e.getRequisite().equals(requisite)
                    )
                    .findFirst();
        }
        return Optional.empty();

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
        Optional<Account> srcAccout = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccout = findByRequisite(destPassport, destRequisite);
        if (srcAccout.isPresent() && destAccout.isPresent()
                && srcAccout.get().getBalance() >= amount) {
            srcAccout.get().setBalance(srcAccout.get().getBalance() - amount);
            destAccout.get().setBalance(destAccout.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;

    }
}
