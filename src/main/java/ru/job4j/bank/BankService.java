package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for(Account account : users.get(user)) {
                if(account.getRequisite().equals(requisite)) {
                    return account;
                }
            }

        }
        return null;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccout = findByRequisite(srcPassport, srcRequisite);
        Account destAccout = findByRequisite(destPassport, destRequisite);
        if(srcAccout != null && destAccout != null && srcAccout.getBalance() >=amount) {
            srcAccout.setBalance(srcAccout.getBalance() - amount);
            destAccout.setBalance(destAccout.getBalance() + amount);
            rsl = true;
        }
        return rsl;

    }
}
