package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает бизнес логику работы с пользователями {@link User} и счетами {@link Account}.
 *
 * @author DMITRIY KHODYREV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей системы с привязанными к ним счетами осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход нового пользователя и добавляет его в систему.
     * Если такой пользователь существует, то ничего не происходит.
     *
     * @param user новый пользователь банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и новый счёт.
     * Если такой пользователь существует, то проверяется наличие счёта у пользователя.
     * Если счёта не существует, новый счёт добавляется пользователю.
     *
     * @param passport номер паспорта пользователя
     * @param account  новый счёт пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта и ищет по нему пользователя.
     * Если такой пользователь существует, то метод возвращает его.
     * Если счёта не существует, новый счёт добавляется пользователю.
     *
     * @param passport номер паспорта пользователя
     * @return {@code User} возвращает пользователя, если он найден, в противном случае {@code null}
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает на вход номер паспорта пользователя, реквизиты счёта и ищет по ним счёт
     * Если такой пользователь существует, то по реквизитам ищется счёт у пользователя.
     * Если счёт найден, то метод возвращяет его, в противном случае возвращается {@code null}.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счёта пользователя
     * @return {@code Account} возвращает счёт, если он найден, в противном случае {@code null}
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        return user != null
                ? users.get(user).stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst()
                .orElse(null)
                : null;
    }

    /**
     * Метод принимает на вход номер паспорта кредитора, реквизиты счёта кредитора,
     * номер паспорта дебитора, реквизиты счёта дебитора, сумму перевода и
     * осуществляет перевод указанной суммы с одного счёта на другой
     * Если кредитор и дебитор найдена, а указанные счета существуют и на счете кредитора достаточная сумма,
     * то осуществляется перевод и метод возвращает {@code true}
     *
     * @param srcPassport   номер паспорта кредитора
     * @param destPassport  номер паспорта дебитора
     * @param srcRequisite  реквизиты счёта кредитора
     * @param destRequisite реквизиты счёта дебитора
     * @param amount        сумма перевода
     * @return {@code boolean} возвращает {@code true}, если перевод прошёл успешно, в противном случае {@code false}
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод принимает на вход пользователя. Возвращает список счетов пользователя.
     * Используется в тестах.
     *
     * @param user пользователь
     * @return {@code List<Account>}
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}